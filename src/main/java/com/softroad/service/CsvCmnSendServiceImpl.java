package com.softroad.service;

import org.springframework.stereotype.Service;

/**
 * 送信serviceImpl
 */
@Service
public class CsvCmnSendServiceImpl {

    /**
     * handle
     *
     * @param fileId 文件id
     * @param handleType 处理类型 CMNSEND 送信 CMNRECV 受信
     * @return
     */
    public String handle(String fileId, String handleType) {
        return "CsvCmnSend";
    }
}
