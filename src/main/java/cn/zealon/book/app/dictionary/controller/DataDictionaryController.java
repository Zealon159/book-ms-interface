package cn.zealon.book.app.dictionary.controller;

import cn.zealon.book.app.dictionary.entity.DataDictionary;
import cn.zealon.book.app.dictionary.service.DataDictionaryService;
import cn.zealon.book.common.base.BaseController;
import cn.zealon.book.common.domain.Params;
import cn.zealon.book.common.result.PageVO;
import cn.zealon.book.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * 数据字典接口
 * @author: tangyl
 * @since: 2020/3/13
 */
@RestController
@RequestMapping("data-dictionary")
public class DataDictionaryController extends BaseController {

    @Autowired
    private DataDictionaryService dataDictionaryService;

    @PostMapping("/create")
    public Result create(@RequestBody DataDictionary record){
        return this.dataDictionaryService.create(record);
    }

    @PutMapping("/update")
    public Result update(@RequestBody DataDictionary record){
        return this.dataDictionaryService.update(record);
    }

    @DeleteMapping("/delete")
    public Result delete(Integer id){
        return dataDictionaryService.delete(id);
    }

    @GetMapping("/get-list")
    public PageVO<DataDictionary> findByPage(@RequestParam Map<String,Object> params){
        Params p = Params.build(params).cleanEmpty();
        return dataDictionaryService.getPageList(p);
    }

    /** 详情 */
    @GetMapping("/details")
    public Result details(Integer id){
        return dataDictionaryService.selectById(id);
    }

    /** 字典类型数据源 */
    @GetMapping("/get-type-options")
    public Result getTypeOptions(){
        return dataDictionaryService.getTypeOptions();
    }

    /**
     * 获取字典数据源
     * @param type
     * @return
     */
    @GetMapping("/get-select-options")
    public Result getDictionaryOptions(String type){
        return this.dataDictionaryService.getDictionaryOptions(type);
    }
}
