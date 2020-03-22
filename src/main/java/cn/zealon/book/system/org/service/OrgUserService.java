package cn.zealon.book.system.org.service;

import cn.zealon.book.common.Const;
import cn.zealon.book.common.config.SystemPropertiesConfig;
import cn.zealon.book.common.domain.Params;
import cn.zealon.book.common.result.PageVO;
import cn.zealon.book.common.result.Result;
import cn.zealon.book.common.result.util.ResultUtil;
import cn.zealon.book.core.cache.RedisService;
import cn.zealon.book.system.org.bo.OrgUserBO;
import cn.zealon.book.system.org.dao.OrgUserMapper;
import cn.zealon.book.system.org.entity.OrgUser;
import cn.zealon.book.system.org.vo.OrgUserEditVO;
import cn.zealon.book.system.org.vo.OrgUserVO;
import cn.zealon.book.system.security.shiro.util.ShiroUserPwdUtil;
import cn.zealon.book.system.security.shiro.util.UserUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * 用户服务
 * @author zealon
 */
@Service
public class OrgUserService {

	protected final Logger logger = LoggerFactory.getLogger(OrgUserService.class);

	@Autowired
	private RedisService redisService;

	@Autowired
	private OrgUserMapper orgUserMapper;

	@Autowired
	private OrgUserRoleService orgUserRoleService;

	@Autowired
	private SystemPropertiesConfig systemPropertiesConfig;
	
	/**
	 * 获取当前用户所有角色
	 * @param userId
	 * @return
	 */
	public Set<String> getUserRoles(String userId) {
		// todo
		/*List<String> list =orgRoleMapper.getUserRoles(userId);
		Set<String> set = new HashSet<String>();
		for(String str : list){
			set.add(str);
		}
		return set;*/
		return null;
	}

	/**
	 * 获取当前用户所有权限
	 * @param userId
	 * @return
	 */
	public Set<String> getUserPermissions(String userId) {
		/*List<String> list =menuMapper.getUserPermissions(userId);
		Set<String> set = new HashSet<String>();
		for(String str : list){
			set.add(str);
		}
		return set;*/
		return null;
	}

	public PageVO<OrgUserVO> getPageList(Params params) {
		Integer page = params.getInt("page");
        Integer limit = params.getInt("limit");
        Integer deptId = params.getInt("deptId");
		String keyword = params.getString("keyword");
		PageHelper.startPage(page, limit);
        Page<OrgUserVO> pageList = (Page<OrgUserVO>) orgUserMapper.findPageWithResult(keyword,deptId);
        return new PageVO<>(pageList.getTotal(),200,"",pageList);
	}
	
	/***
	 * 根据用户id获取用户信息
	 */
	public OrgUser selectByUserId(String userId){
		return orgUserMapper.selectByUserId(userId);
	}

	/**
	 * 新增用户
	 * @param record
	 * @return
	 */
	public Result create(OrgUserBO record) {
		// 查询id是否重复
		OrgUser user = orgUserMapper.selectByUserId(record.getUserId());
		if(user != null){
			return ResultUtil.verificationFailed().buildMessage("添加失败,用户ID重复!");
		}

		OrgUser orgUser = new OrgUser();
		BeanUtils.copyProperties(record,orgUser);
		Date date = new Date();
		orgUser.setCreateTime(date);
		orgUser.setUpdateTime(date);
		orgUser.setCreater(UserUtil.getCurrentUserId());
		orgUser.setUpdater(UserUtil.getCurrentUserId());
		String newPwd = ShiroUserPwdUtil.generateEncryptPwd(record.getUserId(), record.getUserPwd());
		orgUser.setUserPwd(newPwd);
		orgUser.setFreezeStatus(false);
		try{
			// 保存用户
			this.orgUserMapper.insert(orgUser);
			// 添加用户角色
			this.orgUserRoleService.create(record.getUserId(),record.getRoles());

			return ResultUtil.success();
		} catch (Exception ex){
			logger.error("添加用户异常:{}",ex.getMessage());
			return ResultUtil.fail();
		}
	}

	public Result deleteByUserId(String userId){
		Result r = ResultUtil.success();
		if(userId.equals("admin") || userId.equals("designer")){
			r = ResultUtil.verificationFailed().buildMessage("不能删除系统管理员哦！");
		}else{
			try{
                // 删除用户角色
                this.orgUserRoleService.deleteByUserId(userId);
				// 删除用户
				orgUserMapper.deleteByPrimaryKey(userId);
			}catch (Exception ex){
				ex.printStackTrace();
				r = ResultUtil.fail();
			}
		}
		return r;
	}
	
	/**
	 * 修改用户密码
	 * @param record
	 * @return
	 */
	public Result updatePassword(OrgUser record) {
		if (systemPropertiesConfig.getDeleteSwitch()) {
			if (record.getUserId().equals("admin")) {
				return ResultUtil.verificationFailed().buildMessage(Const.TIP_CONTENT);
			}
		}

		OrgUser user = this.selectByUserId(record.getUserId());
		if (user == null) {
			return ResultUtil.notFound().buildMessage("操作失败！找不到该用户（"+record.getUserId()+"）！");
		}

		//密码加密
		String password = ShiroUserPwdUtil.generateEncryptPwd(user.getUserId(), record.getUserPwd());
		try{
			OrgUser updateUser = new OrgUser();
			Date date = new Date();
			updateUser.setUserId(user.getUserId());
			updateUser.setUserPwd(password);
			updateUser.setUpdateTime(date);
			updateUser.setUpdater(UserUtil.getCurrentUserId());
			this.orgUserMapper.updateByPrimaryKey(updateUser);
			return ResultUtil.success();
		} catch (Exception ex){
			logger.error("修改用户密码异常:{}",ex.getMessage());
			return ResultUtil.fail();
		}
	}

	/**
	 * 修改用户
	 * @param bo
	 * @return
	 */
	public Result update(OrgUserBO bo){
		if (systemPropertiesConfig.getDeleteSwitch()) {
			if (bo.getUserId().equals("admin")) {
				return ResultUtil.verificationFailed().buildMessage(Const.TIP_CONTENT);
			}
		}

	    OrgUser record = new OrgUser();
	    BeanUtils.copyProperties(bo,record);
		record.setUpdateTime(new Date());
		record.setUpdater(UserUtil.getCurrentUserId());
		// 禁止修改密码
		record.setUserPwd(null);
		try{
			this.orgUserMapper.updateByPrimaryKey(record);
            // 存储用户角色
            this.orgUserRoleService.deleteByUserId(bo.getUserId());
            this.orgUserRoleService.create(bo.getUserId(),bo.getRoles());
			return ResultUtil.success();
		} catch (Exception ex){
			logger.error("修改用户密码异常:{}",ex.getMessage());
			return ResultUtil.fail();
		}
	}

	/**
	 * 用户详情
	 * @param userId
	 * @return
	 */
	public Result findByUserId(String userId){
		OrgUser user = this.orgUserMapper.selectByUserId(userId);
		return ResultUtil.successAndNoMsg(user);
	}

    /**
     * 编辑用户详情
     * @param userId
     * @return
     */
    public Result findEditVOByUserId(String userId){
        OrgUser orgUser = this.orgUserMapper.selectByUserId(userId);
        if (orgUser == null) {
            return ResultUtil.notFound().buildMessage("找不到该用户["+userId+"]");
        }
        OrgUserEditVO user = new OrgUserEditVO();
        BeanUtils.copyProperties(orgUser,user);
        // 查询角色
        Integer[] roles = this.orgUserRoleService.getRolesArrayByUserId(userId);
        user.setRoles(roles);
        return ResultUtil.successAndNoMsg(user);
    }

	/**
	 * 获取用户个人信息
	 * @return
	 */
	public Result getUserInfo(){
		OrgUserVO userVO = UserUtil.getCurrentOrgUser();
		if (userVO == null){
			return ResultUtil.forbidden();
		}
		return ResultUtil.successAndNoMsg().buildData(userVO);
	}
}
