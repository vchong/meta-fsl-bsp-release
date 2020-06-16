# Copyright 2017-2018 NXP

DESCRIPTION = "i.MX ARM Trusted Firmware"
SECTION = "BSP"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

inherit fsl-eula-unpack pkgconfig deploy

PV = "2.0+git${SRCPV}"

ATF_SRC ?= "git://source.codeaurora.org/external/imx/imx-atf.git;protocol=https"
SRCBRANCH = "imx_4.14.98_2.1.0"

SRC_URI = "${ATF_SRC};branch=${SRCBRANCH}"

SRC_URI += "file://0001-MLK-22207-plat-imx8m-Fix-the-data-sync-issue-in-dram.patch;md5sum=db6d6b5c4997ba3a19a90caab9a5634b" 
SRC_URI += "file://0002-Revert-plat-imx8mm-change-DISPMIX-power-domain-handl.patch;md5sum=0cc6bdacb962023e65ef8b4efffef144" 
SRC_URI += "file://0003-MMIOT-244-On-secure-closed-board-linux-can-t-configu.patch;md5sum=c1824de8dcf2b18051221390adf8e427" 
SRC_URI += "file://0004-MMIOT-191-Do-not-prevent-VPU-to-decode-in-CMA.patch;md5sum=f1818fafecb0d900ca287e8f0b33cc6c" 
SRC_URI += "file://0005-MMIOT-193-Setup-CSU-VPU-access-in-TZ-only.patch;md5sum=c59972e6ad585043a5b9f8d497f66c97" 
SRC_URI += "file://0006-MMIOT-193-imx8mm-csu-config-updated-with-Secure-VPU-.patch;md5sum=02f69dfa940a60c01b9ce7bfa4974f13" 
SRC_URI += "file://0007-MMIOT-193-Fix-CFG_SECURE_HANTRO_VPU-flag-definition.patch;md5sum=ab3c257453e325b8abb08e58268c87dd" 
SRC_URI += "file://0008-MMIOT-412-Add-PCIe-slave-in-default-CSU-configuratio.patch;md5sum=0b905f72a6c73b9753b2b48795e3038a" 
SRCREV = "727cf896a4c79d152dae4537e28400c747bf39b9"

S = "${WORKDIR}/git"

BOOT_TOOLS = "imx-boot-tools"

SOC_ATF ?= "imx8qm"
SOC_ATF_mx8qm = "imx8qm"
SOC_ATF_mx8qxp = "imx8qx"
SOC_ATF_mx8mq = "imx8mq"
SOC_ATF_mx8mm = "imx8mm"
SOC_ATF_mx8mn = "imx8mn"

SYSROOT_DIRS += "/boot"

BUILD_OPTEE = "${@bb.utils.contains('COMBINED_FEATURES', 'optee', 'true', 'false', d)}"

EXTRA_OEMAKE_append = " ${@bb.utils.contains('DISTRO_FEATURES', 'sdp', \
                         'DECRYPTED_BUFFER_START=0xCC000000 \
                          DECRYPTED_BUFFER_LEN=0x02000000 \
                          DECODED_BUFFER_START=0xCE000000 \
                          DECODED_BUFFER_LEN=0x30000000 \
                          CFG_SECURE_HANTRO_VPU=y', '', d)}"

do_compile () {
    export CROSS_COMPILE="${TARGET_PREFIX}"
    cd ${S}
    # Clear LDFLAGS to avoid the option -Wl recognize issue
    unset LDFLAGS

    echo "-> Build ${SOC_ATF} bl31.bin"
    # Set BUIL_STRING with the revision info
    BUILD_STRING=""
    if [ -e ${S}/.revision ]; then
        cur_rev=`cat ${S}/.revision`
        echo " Current revision is ${cur_rev} ."
        BUILD_STRING="BUILD_STRING=${cur_rev}"
    else
        echo " No .revision found! "
    fi
    oe_runmake clean PLAT=${SOC_ATF}
    oe_runmake ${BUILD_STRING} PLAT=${SOC_ATF} bl31

    # Build opteee version
    if [ "${BUILD_OPTEE}" = "true" ]; then
        oe_runmake clean PLAT=${SOC_ATF} BUILD_BASE=build-optee
        oe_runmake ${BUILD_STRING} PLAT=${SOC_ATF} BUILD_BASE=build-optee SPD=opteed bl31
    fi
    unset CROSS_COMPILE
}

do_install () {
    install -d ${D}/boot
    install -m 0644 ${S}/build/${SOC_ATF}/release/bl31.bin ${D}/boot/bl31-${SOC_ATF}.bin
    # Install opteee version
    if [ "${BUILD_OPTEE}" = "true" ]; then
        install -m 0644 ${S}/build-optee/${SOC_ATF}/release/bl31.bin ${D}/boot/bl31-${SOC_ATF}.bin-optee
    fi
}

do_deploy () {
    install -d ${DEPLOYDIR}/${BOOT_TOOLS}
    install -m 0644 ${S}/build/${SOC_ATF}/release/bl31.bin ${DEPLOYDIR}/${BOOT_TOOLS}/bl31-${SOC_ATF}.bin
    # Deploy opteee version
    if [ "${BUILD_OPTEE}" = "true" ]; then
        install -m 0644 ${S}/build-optee/${SOC_ATF}/release/bl31.bin ${DEPLOYDIR}/${BOOT_TOOLS}/bl31-${SOC_ATF}.bin-optee
    fi
}

addtask deploy before do_install after do_compile

FILES_${PN} = "/boot"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx8)"
