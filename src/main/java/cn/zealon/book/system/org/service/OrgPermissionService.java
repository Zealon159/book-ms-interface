/*
package cn.zealon.book.system.org.service;

import cn.zealon.book.common.base.BaseService;
import cn.zealon.book.system.org.entity.OrgRolePermission;
import cn.zealon.common.base.BaseService;
import cn.zealon.common.domain.Params;
import cn.zealon.common.result.PageVO;
import cn.zealon.system.org.entity.OrgPermission;
import cn.zealon.system.org.entity.OrgRolePermission;

import java.util.List;
import java.util.Map;

public interface OrgPermissionService extends BaseService<OrgPermission> {
        */
/**
         * 获取权限树JSON
         * @return
         *//*

        String selectAllTreeJsonData();

        String selectAllJsonData();
        */
/**
         * @author cy
         * @return
         * @description 获取角色权限映射集合
         *//*

        List<OrgRolePermission> getOrgRolePermissionMapList(String key, String value);
        */
/**
         * @author cy
         * @param roleId
         * @return
         * @description 通过角色id查询权限信息
         *//*

        String selectPermissionIdByRoleId(String roleId);
        OrgPermission selectById(Long id);
        Map<String, Boolean> findPermissionRangeByUserid(String userid);

        Integer findCurrentRangeByPermission(String permission);

        PageVO<OrgPermission> getPageList(Params params);

}
*/
