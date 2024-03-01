package com.softroad.service;

import com.softroad.component.CsvDataInit;
import com.softroad.entity.CsvEntity;
import com.softroad.util.GlobalCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class FileHandleService {


   @Autowired
   private CsvDataInit csvDataInit;


    /**
     * handle
     *
     * @param fileId 文件id
     * @param handleType 处理类型 CMNSEND 送信 CMNRECV 受信
     * @return
     */
    public void handle(String fileId, String handleType) {

        CsvEntity fileData = (CsvEntity) GlobalCache.getIfPresent(fileId);

        if (Objects.isNull(fileData)) {
            csvDataInit.init();
            fileData = (CsvEntity) GlobalCache.getIfPresent(fileId);


        }



    }



}
