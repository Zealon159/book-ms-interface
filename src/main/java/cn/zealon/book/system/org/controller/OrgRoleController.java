package cn.zealon.book.system.org.controller;

import cn.zealon.book.common.base.BaseController;
import cn.zealon.book.common.domain.Params;
import cn.zealon.book.common.result.PageVO;
import cn.zealon.book.common.result.Result;
import cn.zealon.book.system.org.bo.OrgRoleBO;
import cn.zealon.book.system.org.entity.OrgRole;
import cn.zealon.book.system.org.service.OrgRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * 角色接口
 * @author: zealon
 * @since: 2020/2/1
 */
@RestController
@RequestMapping("system/org/role")
public class OrgRoleController extends BaseController {
    
    @Autowired
    private OrgRoleService orgRoleService;

    @PostMapping("/create")
    public Result create(@RequestBody OrgRoleBO record){
        return orgRoleService.create(record);
    }

    @PutMapping("/update")
    public Result update(@RequestBody OrgRoleBO record){
        return orgRoleService.update(record);
    }

    @DeleteMapping("/delete")
    public Result delete(Integer id){
        return orgRoleService.deleteById(id);
    }

    @GetMapping("/get-list")
    public PageVO<OrgRole> findByPage(@RequestParam Map<String,Object> params){
        Params p = Params.build(params).cleanEmpty();
        return orgRoleService.getPageList(p);
    }

    @GetMapping("/get-options")
    public Result getRoleOptions(){
        return this.orgRoleService.getRoleOptions();
    }

    /**
     * 详情
     */
    @GetMapping("/details")
    public Result details(Integer id){
        return orgRoleService.findById(id);
    }

    /**
     * 获取角色权限IDs
     * @param roleId
     * @return
     */
    @GetMapping("/get-role-permissoion-ids")
    public Result getRolePermissoionIds(Integer roleId){
        return this.orgRoleService.getRolePermissoionIds(roleId);
    }
}
