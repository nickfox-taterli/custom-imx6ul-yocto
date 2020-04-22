# Copyright (C) 2013-2016 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel"
DESCRIPTION = "Linux Kernel provided and supported by Freescale with focus on \
i.MX Family Reference Boards. It includes support for many IPs such as GPU, VPU and IPU."

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

LOCALVERSION = "-1.2.0"
# SRCREV = "2345cf99f3cba35af24e67ce21e5c7d141c029ed"
SRCREV = "${AUTOREV}"
SRCBRANCH = "master"
SRC_URI = "git://github.com/nickfox-taterli/custom-imx6ul-kernel.git;branch=${SRCBRANCH} \
           file://defconfig \ 
          "

DEFAULT_PREFERENCE = "1"

COMPATIBLE_MACHINE = "(mx6ull|mx6ul)"
