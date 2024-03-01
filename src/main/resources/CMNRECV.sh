#! /bin/sh
#*********************************************
#*           R4D-GW 受信処理                 *
#*********************************************
cd /app/bat
#ジョブ名
JOBNAME=CMNRECV
export JOBNAME

#Javaプログラムのパス
JARPATH=/app/jar
export JARPATH

#ファイルID
INFILEID=$1
export INFILEID

#他システムからの入力ファイルを格納
INPATH=/home/rcv
export INPATH

#GW・APサーバ間の共有フォルダー
OUTPATH=/home/share/keep/rcv
export OUTPATH

#GWサーバの受信データを保存する
BKPATH=/bk/rcv
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
    echo "`date +%H:%M:%S` CMNRECV - JOB EXECUTION STARTED"
    java -jar ${JARPATH}/XXXXXX.jar ${JOBNAME} ${JOBNAME}
    COND_CODE=$?
    echo "`date +%H:%M:%S` CMNRECV - JOB EXECUTION ENDED   RETURN CODE:${COND_CODE}
else
    COND_CODE=16
    echo "`date +%H:%M:%S` CMNRECV - ERROR JOB NOT FOUND RETURN CODE:${COND_CODE}
fi

exit ${COND_CODE}
