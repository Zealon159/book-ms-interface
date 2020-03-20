package cn.zealon.book.system.attachment.controller;

import cn.zealon.book.common.base.BaseController;
import cn.zealon.book.common.result.Result;
import cn.zealon.book.system.attachment.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 普通附件上传接口
 * @author: zealon
 * @since: 2019/10/25
 */
@RestController
public class UploadController extends BaseController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("upload")
    public Result upload(HttpServletRequest request,
                         @RequestParam("file") MultipartFile[] files,
                         @RequestParam(value = "documentId",required = false) Integer documentId,
                         @RequestParam(value = "tableCode") String tableCode,
                         @RequestParam(value = "tableField") String tableField){
        return uploadService.uploadFiles(request,files,documentId, tableCode, tableField);
    }
}
