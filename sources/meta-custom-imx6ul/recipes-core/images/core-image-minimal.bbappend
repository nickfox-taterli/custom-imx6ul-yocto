IMAGE_INSTALL += "imx-kobs \
    bzip2 \
    gzip \
    mtd-utils \
    mtd-utils-ubifs \
    rc-local \
    udev-extraconf \
    u-boot-custom \
    openssh \
    openssl \
    udev-rules-imx "

IMAGE_FEATURES_remove += "package-management"

remove_alternative_files() {
   rm -rf ${IMAGE_ROOTFS}/usr/lib/opkg
   rm -rf ${IMAGE_ROOTFS}/etc/init.d/run-postinsts
   rm -rf ${IMAGE_ROOTFS}/etc/rpm
   rm -rf ${IMAGE_ROOTFS}/etc/rpm-postinsts
}

ROOTFS_POSTPROCESS_COMMAND_append = " \
  remove_alternative_files; \
"