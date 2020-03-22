package cn.zealon.book.app.book.service;

import cn.zealon.book.app.book.bo.BookBO;
import cn.zealon.book.app.book.dao.BookAuthorMapper;
import cn.zealon.book.app.book.dao.BookChapterMapper;
import cn.zealon.book.app.book.dao.BookMapper;
import cn.zealon.book.app.book.entity.Book;
import cn.zealon.book.app.book.entity.BookAuthor;
import cn.zealon.book.common.Const;
import cn.zealon.book.common.config.SystemPropertiesConfig;
import cn.zealon.book.common.domain.Params;
import cn.zealon.book.common.result.PageVO;
import cn.zealon.book.common.result.Result;
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

/**
 * 图书服务
 * @author: zealon
 * @since: 2020/3/16
 */
@Service
public class BookService {

    protected final Logger LOGGER = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookAuthorMapper bookAuthorMapper;

    @Autowired
    private BookChapterMapper bookChapterMapper;

    @Autowired
    private SysAttachmentService attachmentService;

    @Autowired
    private SystemPropertiesConfig systemPropertiesConfig;

    public BookService() {
    }

    /**
     * 创建图书
     * @param bo
     * @return
     */
    public Result create(BookBO bo){
        // 校验bookId是否重复
        Book dbBook = bookMapper.selectByBookId(bo.getBookId());
        if(dbBook != null){
            return ResultUtil.verificationFailed().buildMessage("添加失败，BookID重复了啊！");
        }

        Book book = new Book();
        BeanUtils.copyProperties(bo, book);
        book.setCreater(UserUtil.getCurrentUserId());
        book.setUpdater(UserUtil.getCurrentUserId());

        try{
            // 获取作者名称
            BookAuthor author = this.bookAuthorMapper.selectById(bo.getAuthorId());
            if (author != null) {
                book.setAuthorName(author.getName());
            }

            // 保存图书
            this.bookMapper.insert(book);
            // 处理附件关联
            attachmentService.relevanceAttachments(book.getId(), bo.getAttachmentIds());
        } catch (Exception ex){
            LOGGER.error("添加图书异常:{}",ex.getMessage());
            return ResultUtil.fail();
        }
        return ResultUtil.success();
    }

    /**
     * 更新图书
     * @param bo
     * @return
     */
    public Result update(BookBO bo){
        if (this.systemPropertiesConfig.getDeleteSwitch()) {
            if (bo.getId() <= 20) {
                return ResultUtil.verificationFailed().buildMessage(Const.TIP_CONTENT);
            }
        }
        Book book = new Book();
        BeanUtils.copyProperties(bo, book);
        book.setUpdater(UserUtil.getCurrentUserId());

        try{
            // 保存图书
            this.bookMapper.updateByPrimaryKey(book);
            // 处理附件关联
            attachmentService.relevanceAttachments(book.getId(), bo.getAttachmentIds());
        } catch (Exception ex){
            LOGGER.error("更新图书异常:{}",ex.getMessage());
            return ResultUtil.fail();
        }
        return ResultUtil.success();
    }

    /**
     * 图书列表数据源
     * @param params
     * @return
     */
    public PageVO<Book> getPageList(Params params) {
        Integer page = params.getInt("page");
        Integer limit = params.getInt("limit");
        // 查询条件
        Integer dicCategory = params.getInt("dicCategory");
        Integer dicChannel = params.getInt("dicChannel");
        Integer dicSerialStatus = params.getInt("dicSerialStatus");
        Integer onlineStatus = params.getInt("onlineStatus");
        Integer authorId = params.getInt("authorId");
        String bookId = params.getString("bookId");
        String bookName = params.getString("bookName");
        PageHelper.startPage(page, limit);
        Page<Book> pageList = (Page<Book>) bookMapper.findPageWithResult(dicCategory, dicChannel,
                 dicSerialStatus, onlineStatus,  authorId,  bookId,  bookName);
        return new PageVO<>(pageList.getTotal(),200,"",pageList);
    }

    /**
     * 删除图书
     * @param id
     * @return
     */
    public Result delete(Integer id){
        if (this.systemPropertiesConfig.getDeleteSwitch()) {
            if (id <= 20) {
                return ResultUtil.verificationFailed().buildMessage(Const.TIP_CONTENT);
            }
        }
        try{
            // 删除图书
            this.bookMapper.deleteByPrimaryKey(id);
            // 删除章节
            this.bookChapterMapper.deleteByBookId(id);
        } catch (Exception ex){
            LOGGER.error("删除图书异常:{}",ex.getMessage());
            return ResultUtil.fail();
        }
        return ResultUtil.success().buildMessage("删除成功！");
    }

    /***
     * 图书详情
     * @param id
     * @return
     */
    public Result details(Integer id){
        Book book = this.bookMapper.selectById(id);
        return ResultUtil.successAndNoMsg(book);
    }
}
