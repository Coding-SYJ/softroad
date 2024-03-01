package com.softroad.entity;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class CsvEntity {


    /**
     * 文件ID
     */
    @CsvBindByName(column = "MAIN-FILE-ID")
    private String mainFileId;

    /**
     * HULFT送信的文件ID ，命令例：utlsend -f N8R5DF01 -sync
     */
    @CsvBindByName(column = "HULFT-ID")
    private String hulftId;

    /**
     * 指定是FTP送信还是HULFT送信
     */
    @CsvBindByName(column = "SEND-CLASS")
    private String sendClass;

    /**
     * 要处理加工的数据文件名
     */
    @CsvBindByName(column = "SEND-DETAIL-FILE")
    private String sendDetailFile;

    /**
     * 系统CODE
     */
    @CsvBindByName(column = "PLANTCD")
    private String plantCd;

    /**
     * 指定时需要进行编码转换
     */
    @CsvBindByName(column = "CODE-CONVERT")
    private String codeConvert;

    /**
     * 入力文件的形式，FB固定长文件，VB可变长文件
     */
    @CsvBindByName(column = "IN-REC-TYPE")
    private String inRecType;


    /**
     * 入力文件的长度
     */
    @CsvBindByName(column = "IN-REC-LENGTH")
    private Integer inRecLength;

    /**
     * 出力文件的形式，FB固定长文件，VB可变长文件
     */
    @CsvBindByName(column = "OUT-REC-TYPE")
    private String outRecType;

    /**
     * 出力文件的长度
     */
    @CsvBindByName(column = "OUT-REC-LENGTH")
    private Integer outRecLength;

    /**
     * 指定什么形式的换行符
     */
    @CsvBindByName(column = "NEW-LINE-TYPE")
    private String newLineType;

    /**
     * 汉字项目的制御CODE处理
     */
    @CsvBindByName(column = "SHIFTTRANSACT")
    private String shiftTransact;

    /**
     * HEAD删除。删除每一条数据的指定的开始位数，
     */
    @CsvBindByName(column = "SSFDEL")
    private String ssfDel;

    /**
     * 送信时，发生错误的动作指示
     */
    @CsvBindByName(column = "CMDERRMD")
    private String cmdErrMd;

    /**
     * 送信时，发生错误的动作指示
     */
    @CsvBindByName(column = "RETRY")
    private Integer retry;

    /**
     * 送信时，发生错误时，RETRY的间隔时间（秒）
     */
    @CsvBindByName(column = "INTERVAL")
    private Integer interval;

    /**
     * 数据是0件时的送信指示
     */
    @CsvBindByName(column = "ZERO-CHK")
    private Boolean zeroChk;

}
