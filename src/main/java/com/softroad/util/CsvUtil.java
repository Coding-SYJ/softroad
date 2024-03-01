package com.softroad.util;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Slf4j
public class CsvUtil {


    public static <T> List<T> getCsvData(String filePath, Class<T> clazz) {
        try (FileReader fr = new FileReader(filePath)) {
            return parseCsvData(fr, clazz);
        } catch (IOException e) {
            log.error("读取csv文件异常，文件路径: {}", filePath, e);
            throw new RuntimeException("读取csv文件异常", e);
        }
    }

    private static <T> List<T> parseCsvData(FileReader fr, Class<T> clazz) {
        HeaderColumnNameMappingStrategy<T> strategy = new HeaderColumnNameMappingStrategy<>();
        strategy.setType(clazz);

        CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(fr)
                .withSeparator(',')
                .withQuoteChar('\'')
                .withMappingStrategy(strategy)
                .build();

        try {
            return csvToBean.parse();
        } catch (RuntimeException e) {
            log.error("解析csv文件异常，请检查csv文件。");
            throw new RuntimeException("解析csv文件异常", e);
        }
    }


}