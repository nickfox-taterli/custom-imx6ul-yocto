#!/bin/sh
### BEGIN INIT INFO
# Provides:          bootmisc
# Required-Start:    $local_fs mountvirtfs
# Required-Stop:     $local_fs
# Default-Start:     S
# Default-Stop:      0 6
# Short-Description: Misc and other.
### END INIT INFO

#
# This is as good a place as any for a sanity check
#
# Set the system clock from hardware clock
# If the timestamp is more recent than the current time,
# use the timestamp instead.
test -x /etc/init.d/hwclock.sh && /etc/init.d/hwclock.sh start
if test -e /etc/timestamp
then
	SYSTEMDATE=`date -u +%4Y%2m%2d%2H%2M%2S`
	read TIMESTAMP < /etc/timestamp
	if [ ${TIMESTAMP} -gt $SYSTEMDATE ]; then
		# format the timestamp as date expects it (2m2d2H2M4Y.2S)
		TS_YR=${TIMESTAMP%??????????}
		TS_SEC=${TIMESTAMP#????????????}
		TS_FIRST12=${TIMESTAMP%??}
		TS_MIDDLE8=${TS_FIRST12#????}
		date -u ${TS_MIDDLE8}${TS_YR}.${TS_SEC}
		test -x /etc/init.d/hwclock.sh && /etc/init.d/hwclock.sh stop
	fi
fi

hostname `cat /etc/hostname`

ifup eth0 > /dev/null 2>&1 &
ifup eth1 > /dev/null 2>&1 &

: exit 0
