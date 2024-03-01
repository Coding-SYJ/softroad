#! /bin/sh
#*********************************************
#*           R4D-GW 送信処理                 *
#*********************************************
cd /app/bat
#ジョブ名
JOBNAME=CMNSEND
export JOBNAME

#Javaプログラムのパス
JARPATH=/app/jar
export JARPATH

#ファイルID
INFILEID=$1
export INFILEID

#GW・APサーバ間の共有フォルダー
INPATH=/home/share/keep/data/
export INPATH

#他システムへの出力ファイルを格納
OUTPATH=/home/snd/
export OUTPATH

#GWサーバの送信データを保存する
BKPATH=/bk/snd
export BKPATH

#関連送受信情報CSV
CSVFILE=/app/property/APPLINFO.CSV
export CSVFILE

#エラーメッセージファイル
ERRMSGFILE=/app/property/TECLOG.TXT
export ERRMSGFILE

#リターンコード
COND_CODE=0
export COND_CODE
#
echo "Job ${JOBNAME} submitted. PID = $$"

if ( "-f" "${JARPATH}/XXXXXX.jar" )
then
    echo "`date +%H:%M:%S` CMNSEND - JOB EXECUTION STARTED"
    java -jar ${JARPATH}/XXXXXX.jar ${JOBNAME} ${JOBNAME}
    COND_CODE=$?
    echo "`date +%H:%M:%S` CMNSEND - JOB EXECUTION ENDED   RETURN CODE:${COND_CODE}
else
    COND_CODE=16
    echo "`date +%H:%M:%S` CMNSEND - ERROR JOB NOT FOUND RETURN CODE:${COND_CODE}
fi

exit ${COND_CODE}
