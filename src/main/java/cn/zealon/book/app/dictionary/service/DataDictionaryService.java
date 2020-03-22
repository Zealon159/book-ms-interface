package cn.zealon.book.app.dictionary.service;

import cn.zealon.book.app.book.dao.BookMapper;
import cn.zealon.book.app.dictionary.dao.DataDictionaryMapper;
import cn.zealon.book.app.dictionary.entity.DataDictionary;
import cn.zealon.book.common.Const;
import cn.zealon.book.common.DataDictionaryEnum;
import cn.zealon.book.common.config.SystemPropertiesConfig;
import cn.zealon.book.common.domain.Params;
import cn.zealon.book.common.result.PageVO;
import cn.zealon.book.common.result.Result;
import cn.zealon.book.common.result.SelectVO;
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
    private SystemPropertiesConfig systemPropertiesConfig;

    @Autowired
    private DataDictionaryMapper dictionaryMapper;

    @Autowired
    private BookMapper bookMapper;

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
        if (this.systemPropertiesConfig.getDeleteSwitch()) {
            return ResultUtil.verificationFailed().buildMessage(Const.TIP_CONTENT);
        }
        record.setCode(null);
        this.dictionaryMapper.updateByPrimaryKey(record);
        return ResultUtil.success();
    }

    public Result delete(Integer id){
        if (this.systemPropertiesConfig.getDeleteSwitch()) {
            return ResultUtil.verificationFailed().buildMessage(Const.TIP_CONTENT);
        }

        // 字典使用校验
        DataDictionary dataDictionary = this.dictionaryMapper.selectById(id);
        int count = 0;
        if (dataDictionary.getDicType().equals(DataDictionaryEnum.CATEGORY.getValue())) {
            count = this.bookMapper.findPageWithCount(dataDictionary.getCode(),null,null,null,null,null,null);
        } else if (dataDictionary.getDicType().equals(DataDictionaryEnum.CHANNEL.getValue())) {
            count = this.bookMapper.findPageWithCount(null,dataDictionary.getCode(),null,null,null,null,null);
        } else if (dataDictionary.getDicType().equals(DataDictionaryEnum.SERIAL_STATUS.getValue())) {
            count = this.bookMapper.findPageWithCount(null,null,dataDictionary.getCode(),null,null,null,null);
        }
        if (count > 0) {
            return ResultUtil.verificationFailed().buildMessage(dataDictionary.getDicTypeName() + "："+dataDictionary.getName() + "，已被图书使用，不能删哦！");
        }

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

    /**
     * 获取字典数据源
     * @param type
     * @return
     */
    public Result getDictionaryOptions(String type){
        List<DataDictionary> list = this.dictionaryMapper.findPageWithResult(type);
        List<SelectVO> vos = new ArrayList<>(list.size());
        for (int i = 0; i < list.size(); i++) {
            DataDictionary dic = list.get(i);
            SelectVO vo = new SelectVO(dic.getCode(),dic.getName());
            vos.add(vo);
        }
        return ResultUtil.successAndNoMsg().buildData(vos);
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
