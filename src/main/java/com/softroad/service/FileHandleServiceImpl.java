package com.softroad.service;

import com.softroad.constant.Constant;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class FileHandleServiceImpl {

    @Resource
    private CsvCmnRecvServiceImpl csvCmnRecvService;

    @Resource
    private CsvCmnSendServiceImpl csvCmnSendService;

    /**
     * handle
     *
     * @param fileId 文件id
     * @param handleType 处理类型 CMNSEND 送信 CMNRECV 受信
     * @return
     */
    public String handle(String fileId, String handleType) {
        if (Constant.CMNRECV.equalsIgnoreCase(handleType)) {
            return csvCmnRecvService.handle(fileId, handleType);
        } else if (Constant.CMNSEND.equalsIgnoreCase(handleType)) {
            return csvCmnSendService.handle(fileId, handleType);
        } else {
            return "";
        }
    }
}
