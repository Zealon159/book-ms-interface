package cn.zealon.book.system.attachment.controller;

import cn.zealon.book.common.domain.Params;
import cn.zealon.book.common.result.Result;
import cn.zealon.book.system.attachment.service.SysAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 附件接口
 * @author: tangyl
 * @since: 2019/10/25
 */
@RequestMapping("attachment")
@RestController
public class SysAttachmentController {

    @Autowired
    private SysAttachmentService attachmentService;

    /**
     * 查询表实例对应的附件列表
     * @param params
     * @return
     */
    @GetMapping("/get-list")
    public Result getList(@RequestParam Map<String,Object> params){
        Params p = Params.build(params).cleanEmpty();
        Integer documentId = p.getInt("documentId");
        String tableCode = p.getString("tableCode");
        String tableField = p.getString("tableField");
        return attachmentService.getList(documentId,tableCode,tableField);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam String id){
        return attachmentService.delete(id);
    }

    /**
     * 批量删除
     * @param params
     * @return
     */
    @PutMapping("/delete-batch")
    public Result deleteBatch(@RequestBody Map<String,Object> params){
        List<String> ids = (List<String>) params.get("ids");
        return attachmentService.deleteBatch(ids);
    }

    @GetMapping("/download")
    public void download(HttpServletResponse response, String id){
        attachmentService.download(response, id);
    }

}
