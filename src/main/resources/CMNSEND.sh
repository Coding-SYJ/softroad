#! /bin/sh
#*********************************************
#*           R4D-GW ���M����                 *
#*********************************************
cd /app/bat
#�W���u��
JOBNAME=CMNSEND
export JOBNAME

#Java�v���O�����̃p�X
JARPATH=/app/jar
export JARPATH

#�t�@�C��ID
INFILEID=$1
export INFILEID

#GW�EAP�T�[�o�Ԃ̋��L�t�H���_�[
INPATH=/home/share/keep/data/
export INPATH

#���V�X�e���ւ̏o�̓t�@�C�����i�[
OUTPATH=/home/snd/
export OUTPATH

#GW�T�[�o�̑��M�f�[�^��ۑ�����
BKPATH=/bk/snd
export BKPATH

#�֘A����M���CSV
CSVFILE=/app/property/APPLINFO.CSV
export CSVFILE

#�G���[���b�Z�[�W�t�@�C��
ERRMSGFILE=/app/property/TECLOG.TXT
export ERRMSGFILE

#���^�[���R�[�h
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
