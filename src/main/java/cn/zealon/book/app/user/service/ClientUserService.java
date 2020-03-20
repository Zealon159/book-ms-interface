package cn.zealon.book.app.user.service;

import cn.zealon.book.common.config.SystemPropertiesConfig;
import cn.zealon.book.common.result.Result;
import cn.zealon.book.common.result.util.ResultUtil;
import cn.zealon.book.core.cache.RedisService;
import cn.zealon.book.system.attachment.service.SysAttachmentService;
import cn.zealon.book.system.org.bo.OrgUserBO;
import cn.zealon.book.system.org.dao.OrgUserMapper;
import cn.zealon.book.system.org.entity.OrgUser;
import cn.zealon.book.system.org.vo.OrgUserVO;
import cn.zealon.book.system.security.shiro.util.ShiroUserPwdUtil;
import cn.zealon.book.system.security.shiro.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 客户端用户服务
 * @author: tangyl
 * @since: 2020/3/12
 */
@Service
public class ClientUserService {

    @Autowired
    private OrgUserMapper orgUserMapper;

    @Autowired
    private SysAttachmentService attachmentService;

    @Autowired
    RedisService redisService;

    @Autowired
    private SystemPropertiesConfig systemPropertiesConfig;

    public Result updateUserInfo(OrgUserBO bo){
        if (systemPropertiesConfig.getDeleteSwitch()) {
            if (bo.getUserId().equals("admin")) {
                return ResultUtil.verificationFailed().buildMessage("演示数据admin不能修改哦");
            }
        }
        OrgUserVO vo = UserUtil.getCurrentOrgUser();
        OrgUser user = new OrgUser();
        user.setUserId(vo.getUserId());
        user.setUserName( bo.getUserName());
        user.setPhoneNumber(bo.getPhoneNumber());
        user.setHeadImgUrl(bo.getHeadImgUrl());
        try {
            this.orgUserMapper.updateByPrimaryKey(user);
            // 处理附件关联
            attachmentService.relevanceAttachments(vo.getUserId().hashCode(), bo.getAttachmentIds());
            return ResultUtil.success().buildMessage("保存成功啦 O(∩_∩)O");
        } catch (Exception ex){
            ex.printStackTrace();
            return ResultUtil.fail().buildMessage("保存失败了~");
        }
    }

    /**
     * 修改用户密码
     * @param currentPwd
     * @param pass
     * @return
     */
    public Result updateUserPwd(String currentPwd,String pass){
        if (systemPropertiesConfig.getDeleteSwitch()) {
            if (UserUtil.getCurrentUserId().equals("admin")) {
                return ResultUtil.verificationFailed().buildMessage("演示数据admin不能修改哦");
            }
        }
        OrgUser dbUser = this.orgUserMapper.selectByUserId(UserUtil.getCurrentUserId());
        String checkPwd = ShiroUserPwdUtil.generateEncryptPwd(dbUser.getUserId(), currentPwd);
        if (!checkPwd.equals(dbUser.getUserPwd())) {
            return ResultUtil.verificationFailed().buildMessage("原始密码输入错误，请重试~");
        }

        String newPwd = ShiroUserPwdUtil.generateEncryptPwd(dbUser.getUserId(), pass);
        OrgUser user = new OrgUser();
        user.setUserId(dbUser.getUserId());
        user.setUserPwd(newPwd);
        this.orgUserMapper.updateByPrimaryKey(user);
        return ResultUtil.success().buildMessage("修改成功，下次登录请使用新密码哦~");
    }

    /**
     * 清理用户会话缓存
     */
    public void clearUserSessionCache(){
        String key = "shiro-activeSessionCache:"+UserUtil.getCurrentSessionId();
        this.redisService.removeCache(key);
    }
}
