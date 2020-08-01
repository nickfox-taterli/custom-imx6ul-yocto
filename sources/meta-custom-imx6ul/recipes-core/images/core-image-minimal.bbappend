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

IMAGE_FEATURES_remove += "package-management rpm"
EXTRA_IMAGE_FEATURES_remove += "package-management rpm"