# Copyright (C) 2013-2016 Freescale Semiconductor
# Copyright 2017-2019 NXP

DESCRIPTION = "i.MX U-Boot suppporting i.MX reference boards."
require u-boot-common.inc
require u-boot.inc
inherit pythonnative

PROVIDES += "u-boot"
DEPENDS_append = " python dtc-native"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

UBOOT_SRC ?= "git://source.codeaurora.org/external/imx/uboot-imx.git;protocol=https"
SRCBRANCH = "imx_v2019.04_4.19.35_1.0.0"
SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH}"

SRC_URI += "file://0001-MLK-21904-epdc-Fix-EPDC-waveform-and-logo-file-loadi.patch;md5sum=bc1b3e5219e108d23d8bad3ef54d3b11" 
SRC_URI += "file://0002-MA-14916-fix-build-and-function-issues-of-fastboot-f.patch;md5sum=973720cea1241452ad64121b2881ab79" 
SRC_URI += "file://0003-MA-14916-4-iot-Update-size-format-for-write_counter.patch;md5sum=9f2f1c36362c00b0cef7f3955cc78809" 
SRC_URI += "file://0004-MA-14916-2-fix-fastboot-getvar-issue-in-32bit-device.patch;md5sum=9100290355cf56933d975a90aca129da" 
SRC_URI += "file://0005-MA-14916-9-fix-build-warnings-with-BSP-defconfig.patch;md5sum=2c030cc18ea8507e1f832e5de3991759" 
SRC_URI += "file://0006-MA-14916-1-adapt-to-the-directory-change-of-libavb.patch;md5sum=e64c0db6ec04ef14402293de38d06d5d" 
SRC_URI += "file://0007-MA-14916-3-Add-mx6-7-reference-board-support-to-enab.patch;md5sum=ca50d6ba21abfe0966bc571c277f1fba" 
SRC_URI += "file://0008-MA-13936-Add-CAAM-self-test.patch;md5sum=b323ae77c8f3377b15f33afb7867271a" 
SRC_URI += "file://0009-MA-13937-Enable-CAAM-for-imx8q.patch;md5sum=424a254579a43530b3446acfd997694c" 
SRC_URI += "file://0010-MA-14916-7-comply-with-mmc-struct-definition-in-avb-.patch;md5sum=5c114aa063ef983e96935fff20481c91" 
SRC_URI += "file://0011-MA-14916-8-iot-Set-power-on-write-protection-for-boo.patch;md5sum=ed669ce9f1980ffee288207dc306864b" 
SRC_URI += "file://0012-MLK-20373-2-dm-serial-introduce-puts-hook.patch;md5sum=02cf27673246dd1cc477d972f6041dc4" 
SRC_URI += "file://0013-MA-14916-4-support-dual-bootloader-for-imx8m-imx8q.patch;md5sum=d42cfdd051ba34eac7ba72cf12ef0098" 
SRC_URI += "file://0014-MLK-18591-8-android-Add-imx8-imx8m-reference-boards-.patch;md5sum=4d562b53e04bcd01fc826685a131dd33" 
SRC_URI += "file://0015-MA-12421-Fix-CAAM-not-work-on-Android-Things.patch;md5sum=cfeec2287bbc6a2a021e74ab85b044a3" 
SRC_URI += "file://0016-MA-12973-AUTO-Skip-serial-init-in-board_init_f.patch;md5sum=71767f9e87f7f863528beb7d6dcddbfa" 
SRC_URI += "file://0017-Fix-P0-EVT-boards-boot-without-serial-cable-connecti.patch;md5sum=dc368225dc51ddf2fe59ef4a7faee790" 
SRC_URI += "file://0018-MA-13453-1-Add-new-board-target-imx8mq_aiy.patch;md5sum=8cb54906ffcb6d70d4b0ea2879364e1a" 
SRC_URI += "file://0019-MA-15135-remove-dtb-target-for-8mn.patch;md5sum=29b46420f880d18089f43b68a0c5bbfb" 
SRC_URI += "file://0020-MA-14712-change-androidboot.storage_type-to-androidb.patch;md5sum=ed97ce1a1e0566a17e2aa203a7489aa2" 
SRC_URI += "file://0021-MA-14916-10-fix-fastboot-reboot-bootloader-issue.patch;md5sum=a458595eb2f513218cc6aae5f78c0aef" 
SRC_URI += "file://0022-TEE-346-Add-DEK-blob-encapsulation-for-imx8m.patch;md5sum=dfff3d5bfdcb243185a55b3a5785b6a7" 
SRC_URI += "file://0023-MLK-21297-imx8-Add-DEK-blob-encapsulation.patch;md5sum=dc17c2f0f2239a6ddf917c8ebc8c2afb" 
SRC_URI += "file://0024-MA-14898-Fix-build-warnings.patch;md5sum=1c1038a6d122febe55de91b4e13a32f7" 
SRC_URI += "file://0025-MLK-22387-configs-imx7dsabresd-correct-the-emmc_dev.patch;md5sum=79a5b9b0e12b19f8c96a2639314561e3" 
SRC_URI += "file://0026-MLK-22505-mx7ulp-Enable-UUU-support-for-mx7ulp_evk_m.patch;md5sum=c53ee5abaf148879a283fa1296ec3df1" 
SRC_URI += "file://0027-MLK-22513-doc-ahab-Update-OS-container-image-target.patch;md5sum=50a3caa8db770130ebe71735fc47de5d" 
SRC_URI += "file://0028-MLK-22515-doc-habv4-mx8m-Remove-u-boot.bin-dependenc.patch;md5sum=68935dc64519efab21fe95a81d5f83ea" 
SRC_URI += "file://0029-Use-a-customize-device-tree-configuration-for-DRM.patch;md5sum=b92a50d7ab1c5fa675db4fabda3f7dc3" 
SRC_URI += "file://0030-MLK-22622-imx8m-Add-Workaround-for-ROM-SError-issue.patch;md5sum=13f8bc8b423478dfdb97f3e25f4ada50" 
SRC_URI += "file://0031-MLK-22622-imx8m-Add-Workaround-for-ROM-SError-issue.patch;md5sum=0d25b2746b0c117c1ce7fbc0f7a74851" 
SRCREV = "85bdcc798163f72a7dfd723af4f0ef35d526ae09"

S = "${WORKDIR}/git"

inherit fsl-u-boot-localversion

LOCALVERSION ?= "-${SRCBRANCH}"

BOOT_TOOLS = "imx-boot-tools"

do_deploy_append_mx8m () {
    # Deploy the mkimage, u-boot-nodtb.bin and fsl-imx8mq-XX.dtb for mkimage to generate boot binary
    if [ -n "${UBOOT_CONFIG}" ]
    then
        for config in ${UBOOT_MACHINE}; do
            i=$(expr $i + 1);
            for type in ${UBOOT_CONFIG}; do
                j=$(expr $j + 1);
                if [ $j -eq $i ]
                then
                    install -d ${DEPLOYDIR}/${BOOT_TOOLS}
                    install -m 0777 ${B}/${config}/arch/arm/dts/${UBOOT_DTB_NAME}  ${DEPLOYDIR}/${BOOT_TOOLS}
                    install -m 0777 ${B}/${config}/tools/mkimage  ${DEPLOYDIR}/${BOOT_TOOLS}/mkimage_uboot
                    install -m 0777 ${B}/${config}/u-boot-nodtb.bin  ${DEPLOYDIR}/${BOOT_TOOLS}/u-boot-nodtb.bin-${MACHINE}-${UBOOT_CONFIG}
                fi
            done
            unset  j
        done
        unset  i
    fi

}

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"

UBOOT_NAME_mx6 = "u-boot-${MACHINE}.bin-${UBOOT_CONFIG}"
UBOOT_NAME_mx7 = "u-boot-${MACHINE}.bin-${UBOOT_CONFIG}"
UBOOT_NAME_mx8 = "u-boot-${MACHINE}.bin-${UBOOT_CONFIG}"
