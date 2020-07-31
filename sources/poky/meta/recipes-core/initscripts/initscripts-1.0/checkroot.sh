#!/bin/sh
### BEGIN INIT INFO
# Provides:          checkroot
# Required-Start:    udev
# Required-Stop:     
# Default-Start:     S
# Default-Stop:
# Short-Description: Check to root file system.
### END INIT INFO

mount -n -o remount,rw /

: exit 0
