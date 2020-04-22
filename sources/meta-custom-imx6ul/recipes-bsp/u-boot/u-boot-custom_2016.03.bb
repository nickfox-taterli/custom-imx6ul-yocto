# Copyright (C) 2013-2016 Freescale Semiconductor

DESCRIPTION = "U-Boot provided by Freescale"
require recipes-bsp/u-boot/u-boot.inc

PROVIDES += "u-boot"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRCBRANCH = "master"
UBOOT_SRC = "git://github.com/nickfox-taterli/custom-imx6ul-uboot.git"
SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH}"
# SRCREV = "be6b22d1467de8f00e4f3ee67edc60899345b93b"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit fsl-u-boot-localversion

LOCALVERSION ?= "-${SRCBRANCH}"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx6|mx6ul|mx6ull|mx7)"
