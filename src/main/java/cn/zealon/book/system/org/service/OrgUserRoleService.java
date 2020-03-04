package cn.zealon.book.system.org.service;

import cn.zealon.book.common.result.Result;
import cn.zealon.book.common.result.util.ResultUtil;
import cn.zealon.book.system.org.dao.OrgUserRoleMapper;
import cn.zealon.book.system.org.entity.OrgUserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户角色管理
 * @author: zealon
 * @since: 2020/2/4
 */
@Service
public class OrgUserRoleService {

    protected final Logger LOGGER = LoggerFactory.getLogger(OrgUserRoleService.class);

    @Autowired
    private OrgUserRoleMapper mapper;

    public Result create(String userId , Integer[] roles){
        try{
            List<OrgUserRole> userRoles = new ArrayList<>(roles.length);
            for (int i = 0; i < roles.length; i++) {
                OrgUserRole userRole = new OrgUserRole(userId,roles[i]);
                userRoles.add(userRole);
            }
            this.mapper.batchInsert(userRoles);
            return ResultUtil.success();
        } catch (Exception e){
            LOGGER.error("保存用户角色异常：{}，userId：{},roles:{}",e.getMessage(),userId,roles);
            return ResultUtil.fail(e.getMessage());
        }
    }

    public Result deleteByUserId(String userId){
        try{
            this.mapper.deleteByUserId(userId);
            return ResultUtil.success();
        } catch (Exception e){
            LOGGER.error("删除用户角色异常：{}，userId：{}",e.getMessage(),userId);
            return ResultUtil.fail(e.getMessage());
        }
    }

    /**
     * 获取用户角色数组
     * @param userId
     * @return
     */
    public Integer[] getRolesArrayByUserId(String userId){
        List<OrgUserRole> orgUserRoles = this.mapper.selectByUserId(userId);
        Integer[] roles = new Integer[orgUserRoles.size()];
        for (int i = 0; i < orgUserRoles.size(); i++) {
            roles[i] = orgUserRoles.get(i).getRoleId();
        }
        return roles;
    }
}
