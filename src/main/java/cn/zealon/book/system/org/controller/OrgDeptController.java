package cn.zealon.book.system.org.controller;

import cn.zealon.book.common.base.BaseController;
import cn.zealon.book.common.domain.Params;
import cn.zealon.book.common.result.PageVO;
import cn.zealon.book.common.result.Result;
import cn.zealon.book.system.org.entity.OrgDept;
import cn.zealon.book.system.org.service.OrgDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * 组织控制器类
 * @author zealon
 * @date 2019年3月1日
 */
@RestController
@RequestMapping("system/org/dept")
public class OrgDeptController extends BaseController {
	
	@Autowired
	private OrgDeptService orgDeptService;

	@PostMapping("/create")
	public Result create(@RequestBody OrgDept record){
		return orgDeptService.create(record);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody OrgDept record){
		return orgDeptService.update(record);
	}
	
	@DeleteMapping("/delete")
	public Result delete(Integer id){
		return orgDeptService.deleteById(id);
	}

	@GetMapping("/get-list")
	public PageVO<OrgDept> findByPage(@RequestParam Map<String,Object> params){
		Params p = Params.build(params).cleanEmpty();
		return orgDeptService.getPageList(p);
	}

	@GetMapping("/get-select-data")
	public Result getDeptSelect(){
		return this.orgDeptService.getDeptSelect();
	}
	
	/**
     * 详情
     */
    @GetMapping("/details")
    public Result details(Integer id){
        return orgDeptService.findById(id);
    }
}
