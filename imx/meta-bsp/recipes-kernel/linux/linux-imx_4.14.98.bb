# Copyright (C) 2013-2016 Freescale Semiconductor
# Copyright 2017-2018 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel provided and supported by NXP"
DESCRIPTION = "Linux Kernel provided and supported by NXP with focus on \
i.MX Family Reference Boards. It includes support for many IPs such as GPU, VPU and IPU."

require recipes-kernel/linux/linux-imx.inc
require linux-imx-src-${PV}.inc

SRC_URI += "file://0001-MLK-22253-1-Revert-MLK-22094-usb-cdns3-include-head-.patch" 
SRC_URI += "file://0002-MLK-22253-2-Revert-MLK-18579-1-usb-cdns3-using-upstr.patch" 
SRC_URI += "file://0003-MLK-22253-3-Revert-usb-common-Simplify-usb_decode_ge.patch" 
SRC_URI += "file://0004-MLK-22253-4-Revert-usb-common-Patch-simplify-usb_dec.patch" 
SRC_URI += "file://0005-MLK-22253-5-Revert-usb-common-change-debug-message-A.patch" 
SRC_URI += "file://0006-MLK-22138-VPU-Decoder-distinguish-seek-and-resolutio.patch" 
SRC_URI += "file://0007-MLK-22141-VPU-Decoder-fix-consumed-length-calculatio.patch" 
SRC_URI += "file://0008-MLK-22163-VPU-Decoder-constraint-value-range-of-colo.patch" 
SRC_URI += "file://0009-MLK-22165-VPU-Decoder-ignore-the-invalid-timestamp-o.patch" 
SRC_URI += "file://0010-MLK-22189-VPU-Decoder-fix-hang-after-set-trick-mode.patch" 
SRC_URI += "file://0011-MLK-22164-VPU-Decoder-check-input-frame-type-before-.patch" 
SRC_URI += "file://0012-MLK-22195-VPU-Decoder-ensure-when-framework-update-s.patch" 
SRC_URI += "file://0013-MLK-22206-VPU-Decoder-modify-vpu-log-print-method.patch" 
SRC_URI += "file://0014-MLK-22038-don-t-clear-instance-before-reset-firmware.patch" 
SRC_URI += "file://0015-MLK-22038-VPU-Decoder-cancel-work-when-suspend.patch" 
SRC_URI += "file://0016-MLK-22251-VPU-Decoder-send-fw-reset-cmd-directly.patch" 
SRC_URI += "file://0017-MLK-22250-VPU-Decoder-get-seq-info-from-event-data-i.patch" 
SRC_URI += "file://0018-MLK-22257-VPU-Decoder-clear-pending-cmd-if-cmd-is-ti.patch" 
SRC_URI += "file://0019-MLK-22112-1-arm64-dts-imx8mm-decrease-the-iomem-rang.patch" 
SRC_URI += "file://0020-MLK-22112-2-arm64-dts-define-resets-property-for-mip.patch" 
SRC_URI += "file://0021-MLK-22112-3-media-mipi_csi-replace-reset-flow-for-ph.patch" 
SRC_URI += "file://0022-MLK-22040-clk-imx-enable-qspi-clock-if-m4-enabled-on.patch" 
SRC_URI += "file://0023-MLK-22086-clk-imx-Keep-the-root-clock-gate-always-en.patch" 
SRC_URI += "file://0024-arm64-dts-freescale-Disable-the-csi_bridge-node-in-m.patch" 
SRC_URI += "file://0025-staging-android-ion-Support-cpu-access-during-dma_bu.patch" 
SRC_URI += "file://0026-staging-android-ion-fix-sys-heap-pool-s-gfp_flags.patch" 
SRC_URI += "file://0027-MA-12602-Add-ION-carveout-heap-support-on-4.14-kerne.patch" 
SRC_URI += "file://0028-MA-12602-2-Add-ION-carveout-heap-support-on-4.14-ker.patch" 
SRC_URI += "file://0029-MA-12602-3-Add-ION-carveout-heap-support-on-4.14-ker.patch" 
SRC_URI += "file://0030-MA-12122-Enlarge-ION-carveout-memory-address-alignme.patch" 
SRC_URI += "file://0031-MA-12702-Add-vmap-and-vunmap-to-ION-driver.patch" 
SRC_URI += "file://0032-uapi-Add-ion.h-to-userspace.patch" 
SRC_URI += "file://0033-MMIOT-153-Enable-ION-unmapped-heap-support-on-4.14-k.patch" 
SRC_URI += "file://0034-Started-to-integrate-ion-monitor-in-4.14.patch" 
SRC_URI += "file://0035-Ion-monitor-enhancements.patch" 
SRC_URI += "file://0036-Enable-ION-monitor.patch" 

DEPENDS += "lzop-native bc-native"

DEFAULT_PREFERENCE = "1"

DO_CONFIG_V7_COPY = "no"
DO_CONFIG_V7_COPY_mx6 = "yes"
DO_CONFIG_V7_COPY_mx7 = "yes"
DO_CONFIG_V7_COPY_mx8 = "no"

addtask copy_defconfig after do_patch before do_preconfigure
do_copy_defconfig () {
    install -d ${B}
    if [ ${DO_CONFIG_V7_COPY} = "yes" ]; then
        # copy latest imx_v7_defconfig to use for mx6, mx6ul and mx7
        mkdir -p ${B}
        cp ${S}/arch/arm/configs/imx_v7_defconfig ${B}/.config
        cp ${S}/arch/arm/configs/imx_v7_defconfig ${B}/../defconfig
    else
        # copy latest defconfig to use for mx8
        mkdir -p ${B}
        cp ${S}/arch/arm64/configs/defconfig ${B}/.config
        cp ${S}/arch/arm64/configs/defconfig ${B}/../defconfig
    fi
}

COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"
