package cn.zealon.book.app.book.service;

import cn.zealon.book.app.book.bo.BookAuthorBO;
import cn.zealon.book.app.book.dao.BookAuthorMapper;
import cn.zealon.book.app.book.dao.BookMapper;
import cn.zealon.book.app.book.entity.BookAuthor;
import cn.zealon.book.common.Const;
import cn.zealon.book.common.base.AbstractBaseService;
import cn.zealon.book.common.config.SystemPropertiesConfig;
import cn.zealon.book.common.result.Result;
import cn.zealon.book.common.result.SelectVO;
import cn.zealon.book.common.result.util.ResultUtil;
import cn.zealon.book.system.attachment.service.SysAttachmentService;
import cn.zealon.book.system.security.shiro.util.UserUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 作者服务
 * @author: zealon
 * @since: 2020/3/14
 */
@Service
public class BookAuthorService extends AbstractBaseService<BookAuthor> {

    private final Logger LOGGER = LoggerFactory.getLogger(BookAuthorService.class);

    @Autowired
    private BookAuthorMapper bookAuthorMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private SysAttachmentService attachmentService;

    @Autowired
    private SystemPropertiesConfig systemPropertiesConfig;

    public Result create(BookAuthorBO bo) {
        BookAuthor record = new BookAuthor();
        Date now = new Date();
        BeanUtils.copyProperties(bo,record);
        record.setCreater(UserUtil.getCurrentUserId());
        record.setCreateTime(now);
        record.setUpdater(UserUtil.getCurrentUserId());
        record.setUpdateTime(now);
        try {
            // 持久化作者
            this.bookAuthorMapper.insert(record);
            // 处理附件关联
            attachmentService.relevanceAttachments(record.getId(), bo.getAttachmentIds());
        } catch (Exception ex){
            LOGGER.error("保存作者信息失败！{}",ex.getMessage());
            return ResultUtil.fail();
        }
        return ResultUtil.success();
    }

    public Result update(BookAuthorBO bo) {
        if (this.systemPropertiesConfig.getDeleteSwitch()) {
            if (bo.getId() <= 40) {
                return ResultUtil.verificationFailed().buildMessage(Const.TIP_CONTENT);
            }
        }
        BookAuthor record = new BookAuthor();
        Date now = new Date();
        BeanUtils.copyProperties(bo,record);
        record.setUpdater(UserUtil.getCurrentUserId());
        record.setUpdateTime(now);
        try {
            // 持久化作者
            this.bookAuthorMapper.updateByPrimaryKey(record);
            // 处理附件关联
            attachmentService.relevanceAttachments(record.getId(), bo.getAttachmentIds());
        } catch (Exception ex){
            LOGGER.error("更新作者信息失败！{}",ex.getMessage());
            return ResultUtil.fail();
        }
        return ResultUtil.success();
    }

    @Override
    public Result deleteById(Integer id) {
        if (this.systemPropertiesConfig.getDeleteSwitch()) {
            if (id <= 40) {
                return ResultUtil.verificationFailed().buildMessage(Const.TIP_CONTENT);
            }
        }

        Integer count = this.bookMapper.findPageWithCount(null,null,null,null,id,null,null);
        if (count > 0) {
            return ResultUtil.verificationFailed().buildMessage("作者笔下有"+count+"本图书，还不能删除哦！");
        }
        return super.deleteById(id);
    }

    /**
     * 关键字查询作者数据源
     * @param keyword
     * @return
     */
    public Result getAuthorOptions(String keyword){
        PageHelper.startPage(1, 50);
        Page<BookAuthor> pageList = (Page<BookAuthor>) bookAuthorMapper.findPageWithResult(keyword);
        List<SelectVO> vos = new ArrayList<>();
        for (int i = 0; i < pageList.size(); i++) {
            BookAuthor author = pageList.get(i);
            SelectVO vo = new SelectVO(author.getId(),author.getName());
            vos.add(vo);
        }
        return ResultUtil.successAndNoMsg(vos);
    }
}
