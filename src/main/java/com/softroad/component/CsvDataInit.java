package com.softroad.component;

import com.softroad.entity.CsvEntity;
import com.softroad.util.CsvUtil;
import com.softroad.util.GlobalCache;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@Slf4j
public class CsvDataInit {

    @Value("${csv.filePath}")
    private String csvFilePath;


    /**
     * 初始化数据到缓存中
     */
    @PostConstruct
    public void init() {

        Assert.isTrue(StringUtils.isNotEmpty(csvFilePath),"csv filePath is empty");
        List<CsvEntity> csvData = CsvUtil.getCsvData(csvFilePath, CsvEntity.class);
        log.info("======开始读取CSV数据，共{}条======", csvData.size());
        // 将csv数据存储到缓存中
        GlobalCache.putAll(csvData.stream().collect(Collectors.toMap(CsvEntity::getMainFileId, Function.identity())));
        log.info("======读取CSV数据完毕，共{}条======", GlobalCache.size());
    }

}
