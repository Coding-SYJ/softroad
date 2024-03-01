package com.softroad.controller;

import com.softroad.service.FileHandleService;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileHandleController {

    @Resource
    private FileHandleService fileHandleService;

    /**
     * @param fileId     文件id
     * @param handleType 处理类型 CMNSEND 送信 CMNRECV 受信
     * @return
     */
    @GetMapping(value = "/file/handle/{fileId}/{handleType}")
    public String handle(@PathVariable String fileId, @PathVariable String handleType) {
        Assert.isTrue(StringUtils.isNotEmpty(fileId), "文件key不能为空");
        Assert.isTrue(StringUtils.isNotEmpty(handleType), "文件处理类型不能为空");
        fileHandleService.handle(fileId, handleType);
        return null;
    }

}
