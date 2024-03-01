#! /bin/sh
#*********************************************
#*           R4D-GW ��M����                 *
#*********************************************
cd /app/bat
#�W���u��
JOBNAME=CMNRECV
export JOBNAME

#Java�v���O�����̃p�X
JARPATH=/app/jar
export JARPATH

#�t�@�C��ID
INFILEID=$1
export INFILEID

#���V�X�e������̓��̓t�@�C�����i�[
INPATH=/home/rcv
export INPATH

#GW�EAP�T�[�o�Ԃ̋��L�t�H���_�[
OUTPATH=/home/share/keep/rcv
export OUTPATH

#GW�T�[�o�̎�M�f�[�^��ۑ�����
BKPATH=/bk/rcv
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
    echo "`date +%H:%M:%S` CMNRECV - JOB EXECUTION STARTED"
    java -jar ${JARPATH}/XXXXXX.jar ${JOBNAME} ${JOBNAME}
    COND_CODE=$?
    echo "`date +%H:%M:%S` CMNRECV - JOB EXECUTION ENDED   RETURN CODE:${COND_CODE}
else
    COND_CODE=16
    echo "`date +%H:%M:%S` CMNRECV - ERROR JOB NOT FOUND RETURN CODE:${COND_CODE}
fi

exit ${COND_CODE}
