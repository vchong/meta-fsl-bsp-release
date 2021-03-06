# Copyright 2017-2018 NXP

DESCRIPTION = "i.MX HANTRO VPU library"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://vpu/EULA.txt;md5=b063366b066c9f10037c59756a9ced54"

inherit fsl-eula-unpack use-imx-headers

PARALLEL_MAKE="-j 1"

PROVIDES = "virtual/imxvpu"
RPROVIDES_${PN} = "virtual/imxvpu"

SRC_URI = "${FSL_MIRROR}/${PN}-${PV}.bin;fsl-eula=true \
           file://0001-MMIOT-418-Allow-to-configure-CFG_SECURE_DATA_PATH-on.patch \
"

PLATFORM_mx8mm = "IMX8MM"
PLATFORM_mx8mq = "IMX8MQ"

EXTRA_OEMAKE_append = " ${@bb.utils.contains('DISTRO_FEATURES', 'sdp', 'CFG_SECURE_DATA_PATH=y', '', d)}"

do_compile () {
    oe_runmake CROSS_COMPILE="${HOST_PREFIX}" SDKTARGETSYSROOT="${STAGING_DIR_TARGET}" PLATFORM="${PLATFORM}" all
}

do_install () {
    oe_runmake DEST_DIR="${D}" PLATFORM="${PLATFORM}" install
}

FILES_${PN} += "/unit_tests"

PACKAGE_ARCH = "${MACHINE_ARCH}"
