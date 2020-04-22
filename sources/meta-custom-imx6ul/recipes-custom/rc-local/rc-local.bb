# Copyright (C) 2012 O.S. Systems Software LTDA.

DESCRIPTION = "Extra files for rc.local"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=271b217bfe926eaeb7b523cc48dc1fb4"

SRC_URI = "file://rc.local.etc \
           file://LICENSE \
            "

S = "${WORKDIR}"

inherit update-rc.d

INITSCRIPT_NAME = "rc.local"
INITSCRIPT_PARAMS = "start 99 2 3 4 5 ."

do_install () {
    mkdir ${D}/${sysconfdir}/
    install -m 755 ${S}/rc.local.etc ${D}/${sysconfdir}/rc.local
}

FILES_${PN} = " /etc/ \
	      "

INSANE_SKIP_${PN}-dev = "ldflags"
INSANE_SKIP_${PN} = "${ERROR_QA} ${WARN_QA}"
