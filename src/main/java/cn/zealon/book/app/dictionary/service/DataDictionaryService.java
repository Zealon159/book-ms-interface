package cn.zealon.book.app.dictionary.service;

import cn.zealon.book.app.dictionary.dao.DataDictionaryMapper;
import cn.zealon.book.app.dictionary.entity.DataDictionary;
import cn.zealon.book.common.DataDictionaryEnum;
import cn.zealon.book.common.domain.Params;
import cn.zealon.book.common.result.PageVO;
import cn.zealon.book.common.result.Result;
import cn.zealon.book.common.result.util.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据字典服务
 * @author: zealon
 * @since: 2020/3/13
 */
@Service
public class DataDictionaryService {

    @Autowired
    private DataDictionaryMapper dictionaryMapper;

    public Result create(DataDictionary record){
        if (this.dictionaryMapper.selectByDicTypeAndCode(record.getDicType(), record.getCode()) != null) {
            return ResultUtil.verificationFailed().buildMessage(record.getDicType()+"已经存在此code，请更换！");
        }
        String typeName = this.getTypeName(record.getDicType());
        record.setDicTypeName(typeName);
        this.dictionaryMapper.insert(record);
        return ResultUtil.success();
    }

    public Result update(DataDictionary record){
        record.setCode(null);
        this.dictionaryMapper.updateByPrimaryKey(record);
        return ResultUtil.success();
    }

    public Result delete(Integer id){
        // todo 存在判断

        this.dictionaryMapper.deleteByPrimaryKey(id);
        return ResultUtil.success();
    }

    public Result selectById(Integer id){
        return ResultUtil.successAndNoMsg(this.dictionaryMapper.selectById(id));
    }

    public PageVO<DataDictionary> getPageList(Params params) {
        Integer page = params.getInt("page");
        Integer limit = params.getInt("limit");
        String dicType = params.getString("dicType");
        PageHelper.startPage(page, limit);
        Page<DataDictionary> pageList = (Page<DataDictionary>) this.dictionaryMapper.findPageWithResult(dicType);
        return new PageVO<>(pageList.getTotal(),200,"",pageList);
    }

    /**
     * 获取字典类型数据源
     * @return
     */
    public Result getTypeOptions(){
        List<Map> list = new ArrayList<>();
        DataDictionaryEnum[] values = DataDictionaryEnum.values();
        for (int i = 0; i < values.length; i++) {
            Map map = new HashMap();
            map.put("value",values[i].getValue());
            map.put("name",values[i].getName());
            list.add(map);
        }
        return ResultUtil.successAndNoMsg(list);
    }

    private String getTypeName(String type){
        String typeName = "";
        DataDictionaryEnum[] values = DataDictionaryEnum.values();
        for (int i = 0; i < values.length; i++) {
            if (values[i].getValue().equals(type)) {
                typeName = values[i].getName();
                break;
            }
        }
        return typeName;
    }
}
