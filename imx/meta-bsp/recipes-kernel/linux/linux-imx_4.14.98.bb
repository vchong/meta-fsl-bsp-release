# Copyright (C) 2013-2016 Freescale Semiconductor
# Copyright 2017-2018 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel provided and supported by NXP"
DESCRIPTION = "Linux Kernel provided and supported by NXP with focus on \
i.MX Family Reference Boards. It includes support for many IPs such as GPU, VPU and IPU."

require recipes-kernel/linux/linux-imx.inc
require linux-imx-src-${PV}.inc

SRC_URI += "file://0001-MLK-22253-1-Revert-MLK-22094-usb-cdns3-include-head-.patch;md5sum=2c5f5f6ae8a75757f1b73dfb077a7371" 
SRC_URI += "file://0002-MLK-22253-2-Revert-MLK-18579-1-usb-cdns3-using-upstr.patch;md5sum=fca8654c28c0c005a34ff4c8f544c5ac" 
SRC_URI += "file://0003-MLK-22253-3-Revert-usb-common-Simplify-usb_decode_ge.patch;md5sum=b529fca10e911690a0dd26a0ef85edd7" 
SRC_URI += "file://0004-MLK-22253-4-Revert-usb-common-Patch-simplify-usb_dec.patch;md5sum=911a560044c4ca4ec76820f754bdc7e2" 
SRC_URI += "file://0005-MLK-22253-5-Revert-usb-common-change-debug-message-A.patch;md5sum=c99e854d15702f1c4dc907c2c9074025" 
SRC_URI += "file://0006-MLK-22138-VPU-Decoder-distinguish-seek-and-resolutio.patch;md5sum=951de8a7f79326be6a4feddfc99f1f9d" 
SRC_URI += "file://0007-MLK-22141-VPU-Decoder-fix-consumed-length-calculatio.patch;md5sum=659ae60799779ce02f95e7e2b209d9d3" 
SRC_URI += "file://0008-MLK-22163-VPU-Decoder-constraint-value-range-of-colo.patch;md5sum=4e0ce34fdf4f61e153db6b3eda3031a5" 
SRC_URI += "file://0009-MLK-22165-VPU-Decoder-ignore-the-invalid-timestamp-o.patch;md5sum=04aa8662e4b047b7164e5fdd03b0d8cc" 
SRC_URI += "file://0010-MLK-22189-VPU-Decoder-fix-hang-after-set-trick-mode.patch;md5sum=104f95baf4cbd235884efa9e68a6f8d7" 
SRC_URI += "file://0011-MLK-22164-VPU-Decoder-check-input-frame-type-before-.patch;md5sum=cbc999fc2c0192ce22cde34649ce5974" 
SRC_URI += "file://0012-MLK-22195-VPU-Decoder-ensure-when-framework-update-s.patch;md5sum=71d6ca1d11af73a08ab3263a70ed589b" 
SRC_URI += "file://0013-MLK-22206-VPU-Decoder-modify-vpu-log-print-method.patch;md5sum=07d6620c959e3a138c81ac49817425d6" 
SRC_URI += "file://0014-MLK-22038-don-t-clear-instance-before-reset-firmware.patch;md5sum=2efeee024ddccf7962b9bbb2c891dd47" 
SRC_URI += "file://0015-MLK-22038-VPU-Decoder-cancel-work-when-suspend.patch;md5sum=6a2f1136bfda6723a06dd5f0e9bda2ca" 
SRC_URI += "file://0016-MLK-22251-VPU-Decoder-send-fw-reset-cmd-directly.patch;md5sum=c26b67df2857e46288c3142b688499ec" 
SRC_URI += "file://0017-MLK-22250-VPU-Decoder-get-seq-info-from-event-data-i.patch;md5sum=20fb4917035e1db8c971adbeeab764e8" 
SRC_URI += "file://0018-MLK-22257-VPU-Decoder-clear-pending-cmd-if-cmd-is-ti.patch;md5sum=f6fcef0ef02b20fa2ca48fa6042d0c74" 
SRC_URI += "file://0019-MLK-22112-1-arm64-dts-imx8mm-decrease-the-iomem-rang.patch;md5sum=72f7576692fde61bdc66a1245fdd2628" 
SRC_URI += "file://0020-MLK-22112-2-arm64-dts-define-resets-property-for-mip.patch;md5sum=984a6cbb6561f504c74f64766de67b0d" 
SRC_URI += "file://0021-MLK-22112-3-media-mipi_csi-replace-reset-flow-for-ph.patch;md5sum=af04ef73d285bea9c73a0045d3b1dbad" 
SRC_URI += "file://0022-MLK-22040-clk-imx-enable-qspi-clock-if-m4-enabled-on.patch;md5sum=8505ffb9d505403deaf89f5e1d3c3533" 
SRC_URI += "file://0023-MLK-22086-clk-imx-Keep-the-root-clock-gate-always-en.patch;md5sum=dfb7d426212c855fe20617f5a4c050e2" 
SRC_URI += "file://0024-arm64-dts-freescale-Disable-the-csi_bridge-node-in-m.patch;md5sum=210628be576087cc9012eb890e15198e" 
SRC_URI += "file://0025-staging-android-ion-Support-cpu-access-during-dma_bu.patch;md5sum=5148c3163592ed0d28d97ad8c8acfeaf" 
SRC_URI += "file://0026-staging-android-ion-fix-sys-heap-pool-s-gfp_flags.patch;md5sum=4fb0b9da23250a8cd17b822c2cd5edf3" 
SRC_URI += "file://0027-MA-12602-Add-ION-carveout-heap-support-on-4.14-kerne.patch;md5sum=05efbf55f5f9f0f11e6a8af6a2450bf9" 
SRC_URI += "file://0028-MA-12602-2-Add-ION-carveout-heap-support-on-4.14-ker.patch;md5sum=f792eddb1962d5d10c9d3057838b4976" 
SRC_URI += "file://0029-MA-12602-3-Add-ION-carveout-heap-support-on-4.14-ker.patch;md5sum=179df817a04e23f5358478486eccc3ae" 
SRC_URI += "file://0030-MA-12122-Enlarge-ION-carveout-memory-address-alignme.patch;md5sum=6898a5f2ccad779a0d0f7bb56bd8dbc3" 
SRC_URI += "file://0031-MA-12702-Add-vmap-and-vunmap-to-ION-driver.patch;md5sum=5bbb778a2056598d9ab973d1d46e72fa" 
SRC_URI += "file://0032-uapi-Add-ion.h-to-userspace.patch;md5sum=7d3ff1faf0ba482d9cc7a400903bd650" 
SRC_URI += "file://0033-MMIOT-153-Enable-ION-unmapped-heap-support-on-4.14-k.patch;md5sum=2c4bdb204f24963c553aeaf63c22f3e9" 
SRC_URI += "file://0034-Started-to-integrate-ion-monitor-in-4.14.patch;md5sum=075ae07f5bfb4613fb298f95f10d5e7c" 
SRC_URI += "file://0035-Ion-monitor-enhancements.patch;md5sum=9edd6574c463af1cc83a3ee05572965d" 
SRC_URI += "file://0036-Enable-ION-monitor.patch;md5sum=0cc8c09d24d97b44cea7aa47eef19b83" 
SRC_URI += "file://0037-MMIOT-459-hdmi-Add-support-for-6-audio-channels.patch;md5sum=4d56d2db0604288815a745b4d787cc90" 
SRC_URI += "file://0038-MMIOT-117-Start-optee-driver-earlier-to-allow-linux-.patch;md5sum=ccc3596a7314a28f6c044d9c34d54aaa" 
SRC_URI += "file://0039-MMIOT-117-Add-control-of-HDMI-HDCP-registers-using-O.patch;md5sum=16c708020b9025a6a7d3b1c2a563adaf" 
SRC_URI += "file://0040-ion-unmapped-do-not-reset-ion-buffer.patch;md5sum=b46dd502738ece7051591e689a9ff15a" 
SRC_URI += "file://0041-MMIOT-192-VU-hantro-linux-driver-Use-OPTEE-Kernel-AP.patch;md5sum=14259810c804a782eeea3b25800e01e6" 
SRC_URI += "file://0042-MMIOT-192-Handle-IRQ-in-secure.patch;md5sum=d17fdf46832d2673737abdc75e35bb80" 
SRC_URI += "file://0043-MMIOT-192-Block-control-use-of-Secure-VPU-driver.patch;md5sum=47ed2109dc6502d59414dc62e8e52c2e" 
SRC_URI += "file://0044-MMIOT-192-Add-shared-mem-optim-code-refactoring.patch;md5sum=fe5af0357f64e769b4e1d207acf527f3" 
SRC_URI += "file://0045-MMIOT-192-hantro-decoder-Add-support-for-imx8mq.patch;md5sum=551fc7114c65e203e627070a57c61239" 
SRC_URI += "file://0046-MMIOT-192-Hantro-secure-code-optimization-refactorin.patch;md5sum=43e85e194288cb93ea21d65f68f4f18e" 
SRC_URI += "file://0047-MMIOT-193-Add-PTA_HANTRO_VPU_CMD_READ_MULTIPLE-comma.patch;md5sum=dab62d06517c513242df5b9acc5281c7" 
SRC_URI += "file://0048-MMIOT-192-Remove-CONFIG_MXC_HANTRO_SECURE-by-default.patch;md5sum=ddeb36e2703c65f74042dfd013f95486" 
SRC_URI += "file://0049-hantrodec-driver-init-start-level-set-to-late-init.patch;md5sum=a89e90044ccdaf5509b4f226847d7de7" 
SRC_URI += "file://0050-Hantro-secure-decoder-add-performance-counters.patch;md5sum=73bf0f623a6defe76257c97bd9460ed7" 
SRC_URI += "file://0051-MMIOT-413-Add-fsl-imx8mq-evk-optee.dts.patch;md5sum=7fae08e2b0c33356fb18d00fefe1e089" 
SRC_URI += "file://print_oom.patch"

SRC_URI += "file://secure_vpu.cfg"

DEPENDS += "lzop-native bc-native"

DEFAULT_PREFERENCE = "1"

DO_CONFIG_V7_COPY = "no"
DO_CONFIG_V7_COPY_mx6 = "yes"
DO_CONFIG_V7_COPY_mx7 = "yes"
DO_CONFIG_V7_COPY_mx8 = "no"

EXTRA_KERNEL_CONFIG = "${@bb.utils.contains('DISTRO_FEATURES', 'sdp', '${WORKDIR}/secure_vpu.cfg', '', d)}"

addtask copy_defconfig after do_patch before do_preconfigure
do_copy_defconfig () {
    install -d ${B}
    if [ ${DO_CONFIG_V7_COPY} = "yes" ]; then
        # copy latest imx_v7_defconfig to use for mx6, mx6ul and mx7
        mkdir -p ${B}
        cp ${S}/arch/arm/configs/imx_v7_defconfig ${B}/.config
    else
        # copy latest defconfig to use for mx8
        mkdir -p ${B}
        cp ${S}/arch/arm64/configs/defconfig ${B}/.config
    fi

    if [ ! -z ${EXTRA_KERNEL_CONFIG} ]; then
        echo "\n" >> ${B}/.config
        cat ${EXTRA_KERNEL_CONFIG} >> ${B}/.config
    fi
    cp ${B}/.config ${B}/../defconfig
}

COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"
