# Copyright (C) 2017-2020 NXP

SUMMARY = "OPTEE OS"
DESCRIPTION = "OPTEE OS"
HOMEPAGE = "http://www.optee.org/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c1f21c4f72f372ef38a5a4aee55ec173"

inherit deploy pythonnative autotools
DEPENDS = "python-pycrypto-native u-boot-mkimage-native"

SRCBRANCH = "imx_5.4.3_2.0.0"
OPTEE_OS_SRC ?= "git://source.codeaurora.org/external/imx/imx-optee-os.git;protocol=https;protocol=https"
SRC_URI = "${OPTEE_OS_SRC};branch=${SRCBRANCH}"

SRC_URI += "file://0001-TEE-485-drivers-crypto-implement-crypto-driver-DH.patch;md5sum=a86601f57123c63776c05e8c1e310dca" 
SRC_URI += "file://0002-TEE-485-drivers-caam-implement-NXP-CAAM-DH.patch;md5sum=8eeff0d695a8fb8b25f8716fa7b1ad74" 
SRC_URI += "file://0003-TEE-517-core-imx-Fix-DEK-Blob-support-for-i.MX-8msca.patch;md5sum=03c941be090822bf1a569b92b8696773" 
SRC_URI += "file://0004-TEE-517-core-imx-Add-dynamic-shared-memory-configura.patch;md5sum=d2469ccedf9758436adac50a1ca6a5c9" 
SRC_URI += "file://0005-TEE-450-Add-support-for-i.MX-8DXL.patch;md5sum=87aa2ca770ecb6b1ce460cd778ba95ed" 
SRC_URI += "file://0006-TEE-521-core-imx-cleanup-i.MX-8QM-QxP-configuration.patch;md5sum=3b588061160f45fa788689164b711982" 
SRC_URI += "file://0007-TEE-525-core-imx-fix-i.MX-8mq-boot-failure.patch;md5sum=06f563e0d1944e88f845fd70bd6b0fc8" 
SRC_URI += "file://0008-MLK-23577-core-imx-imx8mp-select-correct-job-ring-to.patch;md5sum=b82827d534a408d4e9b98bfb0a48173d" 
SRC_URI += "file://0009-fix-warnings.patch;md5sum=6f2b91aa168eb4343f772aa38718a1be" 
SRC_URI += "file://0010-core-imx-64-bits-SDP-memory-taked-into-account.patch;md5sum=c199a8fd4e722aa8120643b5799ab0f8" 
SRC_URI += "file://0011-plat-imx-add-support-for-dynamic-shared-memory.patch;md5sum=52eb34f6dfdcd7b7970c506cafe110f9" 
SRC_URI += "file://0012-MMIOT-4-3-SDP-memory-mapped-without-cache-enabled-to.patch;md5sum=8391e7358827c7c9fe7ad88ce380a216" 
SRC_URI += "file://0013-MMIOT-20-Enable-TZASC-protection-on-Secure-Data-Path.patch;md5sum=dbb1aa0bce8c7783116ab0b9d053c64e" 
SRC_URI += "file://0014-core-crypto-add-support-MD5-hashes-in-RSA-sign-verif.patch;md5sum=15237e1e2c8a0b309fa140b1bb0332ac" 
SRC_URI += "file://0015-core-crypto-change-supported-HMAC-key-size-ranges.patch;md5sum=9b9bbf0cd2b4533e6698bf3ae86878a8" 
SRC_URI += "file://0016-core-crypto-add-free-rsa-ecc-keypair-calls.patch;md5sum=e2614a2a3130d2f3737cdf14054c4bf3" 
SRC_URI += "file://0017-core-crypto-detect-elliptic-curve-size.patch;md5sum=a0af6f3102013dd91211b60f147e748b" 
SRC_URI += "file://0018-core-driver-crypto-add-support-MD5-hashes-in-RSA-sig.patch;md5sum=e2612d664f10496938a3a1cbe0ad1987" 
SRC_URI += "file://0019-Introduce-ASN1-ENUMERATED-tag-support.patch;md5sum=b933eea674e23849f36871d2171ca333" 
SRC_URI += "file://0020-libutee-remove-restrictions-for-TEE_ALG_RSA_NOPAD.patch;md5sum=5d3c5ad1ebe9461c64394ab37840421a" 
SRC_URI += "file://0021-libtomcrypt-rsa-oaep-Use-SHA-1-by-default-for-MGF1.patch;md5sum=888312322e48778cec343819f4167562" 
SRC_URI += "file://0022-ltc-asn1-der-add-support-of-additional-types.patch;md5sum=c064b166123be7eeb5db832f7b30d2ac" 
SRC_URI += "file://0023-plat-imx-add-support-for-RPMB-and-early-TAs.patch;md5sum=1ede5d5ab1d1c4cf22aae67fd77d8349" 
SRC_URI += "file://0024-ta-avb-Temporarily-disable-RPMB-functionalities.patch;md5sum=115eb5bd1f0eb060aeb9a589ea3e3c5f" 
SRC_URI += "file://0025-ta-avb-Adjust-AVB-operations-based-on-CFG_RPMB_FS-co.patch;md5sum=68c4559f6af5e9d54fbd3386c5fbeb7f" 
SRC_URI += "file://0026-rpmb-configure-correct-dev_id-for-i.MX8mm-evk.patch;md5sum=e1534306281ddb2a693ab3d3c2d23d5c" 
SRC_URI += "file://0027-rpmb-Use-default-configuration.patch;md5sum=5970e5ada895519905e0fe10bdbdda1a" 
SRC_URI += "file://0028-MMIOT-232-Allow-to-block-RPMB-operations.patch;md5sum=f80cf539b85280e66980524eb5124aaf" 
SRC_URI += "file://0029-MMIOT-232-Implement-a-Config-pseudo-TA.patch;md5sum=4f52230604b91f190d71509f821992bf" 
SRC_URI += "file://0030-MMIOT-232-Solve-an-issue-to-write-lock-state.patch;md5sum=79c95ed2bc6f6cbc4c3f951953945373" 
SRC_URI += "file://0031-MMIOT-278-Enable-RPMB-support-by-default.patch;md5sum=fb64429e47f730f215cea8a1eecf6d5c" 
SRC_URI += "file://0032-MMIOT-356-Lock-unlock-not-supported-if-CFG_RPMB_FS-n.patch;md5sum=6c6ce4a0d40f991907e7a63ddbe8425b" 
SRC_URI += "file://0033-MMIOT-271-MMIOT-272-Add-AVB-TA-in-the-Early-TA.patch;md5sum=58b1de5b1eca4a710609f8b883209544" 
SRC_URI += "file://0034-MMIOT-191-Add-secure-Hantro-VPU-PTA.patch;md5sum=c704187e6fb9738ae91e283cc94f2caf" 
SRC_URI += "file://0035-core-driver-caam-SDP-mem-cache-tested.patch;md5sum=b10e34ee5042267244b71d07d80d960e" 
SRC_URI += "file://0036-core-driver-disable-CAAM-AES-RSA.patch;md5sum=a0d048561edb916cf2637646b166f91a" 
SRC_URI += "file://0037-Set-memory-pool-size-to-16KB.patch;md5sum=795ed34b56c2e13af2990801a3e82878" 
SRC_URI += "file://0038-core-driver-disable-CAAM-ECC.patch;md5sum=032d4d8bfde598bbfb9dd51f47e78322" 
SRC_URI += "file://0039-MMIOT-117-Add-persistent-TA-to-protect-HDMI-HDCP-reg.patch;md5sum=43f66f39c973c33fa98fb2b56bedc151" 
SRC_URI += "file://0040-MMIOT-461-Add-CFG_RPMB_DISABLE_HASH_DB.patch;md5sum=0377bb6e9ee93031f17a9ae9b1568a69" 
SRC_URI += "file://0041-crypto-caam-disable-DH.patch;md5sum=9cfcbe14e42d831370c896ccc873a359" 
SRC_URI += "file://0042-core-crypto-use-supplied-DSA-parameters-when-creatin.patch;md5sum=0980ddc4e40ad5f9a4bfbf7d6d0baad3" 
SRC_URI += "file://0043-core-crypto-DH-make-sure-key_size-is-consistent-with.patch;md5sum=7c6dd93dc63138fe22ae0bdb4ab13497" 
SRC_URI += "file://0044-core-crypto-ECC-make-sure-key_size-is-consistent-wit.patch;md5sum=1cc2d548027ce433b1e9cd0987428862" 
SRC_URI += "file://0045-libmbedtls-mbedtls_mpi_shrink-fix-possible-unwanted-.patch;md5sum=e07ce75453f1ab2dcbc1c935a72e83f2" 
SRC_URI += "file://0046-imx8mq-Add-a-warning-if-VPU-do-not-support-TZASC.patch;md5sum=550e460bf2229ce38095344d9ddf4223" 
SRC_URI += "file://0047-core-csu-add-imx8m-csu-protection.patch;md5sum=9c0af9980e9ecff1866797d599ddede1" 
SRC_URI += "file://0048-MMIOT-499-Increase-amount-of-MEM_AREA_RES_VASPACE-me.patch;md5sum=b17d0ece69df66227ea81ac8fdf96c8f" 
SRCREV = "65d11b9078bed0d1fe2908b473a55e038db2280c"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build.${PLATFORM_FLAVOR}"

# The platform flavor corresponds to the Yocto machine without the leading 'i'.
PLATFORM_FLAVOR                 = "${@d.getVar('MACHINE')[1:]}"
PLATFORM_FLAVOR_imx6qpdlsolox   = "mx6qsabresd"
PLATFORM_FLAVOR_imx6ul7d        = "mx6ulevk"
PLATFORM_FLAVOR_imx6ull14x14evk = "mx6ullevk"
PLATFORM_FLAVOR_imx6ull9x9evk   = "mx6ullevk"
PLATFORM_FLAVOR_imx6ulz14x14evk = "mx6ullevk"
PLATFORM_FLAVOR_mx8mm   = "mx8mmevk"
PLATFORM_FLAVOR_imx8qmqxp   = "mx8qmmek"

OPTEE_ARCH ?= "arm32"
OPTEE_ARCH_armv7a = "arm32"
OPTEE_ARCH_aarch64 = "arm64"

# Optee-os can be built for 32 bits and 64 bits at the same time
# as long as the compilers are correctly defined.
# For 64bits, CROSS_COMPILE64 must be set
# When defining CROSS_COMPILE and CROSS_COMPILE64, we assure that
# any 32 or 64 bits builds will pass
EXTRA_OEMAKE = "PLATFORM=imx PLATFORM_FLAVOR=${PLATFORM_FLAVOR} \
                CROSS_COMPILE=${HOST_PREFIX} \
                CROSS_COMPILE64=${HOST_PREFIX} \
                NOWERROR=1 \
                LDFLAGS= \
		O=${B} \
        "

EXTRA_OEMAKE_append = " ${@bb.utils.contains('DISTRO_FEATURES', 'sdp', \
               'CFG_SECURE_DATA_PATH=y \
                CFG_TEE_SDP_MEM_BASE=0xCC000000 \
                CFG_TEE_SDP_MEM_SIZE=0x02000000 \
                CFG_TEE_SDP_NONCACHE=y \
                CFG_DRM_SECURE_DATA_PATH=y \
                CFG_RDC_SECURE_DATA_PATH=y \
                CFG_RDC_DECODED_BUFFER_BASE=0xCE000000 \
                CFG_RDC_DECODED_BUFFER_SIZE=0x30000000 \
                CFG_HANTRO_VPU_PTA=y', '', d)}"

do_compile () {
    unset LDFLAGS
    export CFLAGS="${CFLAGS} --sysroot=${STAGING_DIR_HOST}"
    export CFG_RPMB_FS="n"
    #export CFG_RPMB_WRITE_KEY="n"
    export CFG_RPMB_RESET_FAT="n"
    export CFG_CORE_HEAP_SIZE="131072"
#    oe_runmake -C ${S} all CFG_TEE_TA_LOG_LEVEL=0
    oe_runmake -C ${S} all CFG_TEE_CORE_LOG_LEVEL=3 CFG_TEE_TA_LOG_LEVEL=3 DEBUG=1
}


do_deploy () {
    install -d ${DEPLOYDIR}
    ${TARGET_PREFIX}objcopy -O binary ${B}/core/tee.elf ${DEPLOYDIR}/tee.${PLATFORM_FLAVOR}.bin

    if [ "${OPTEE_ARCH}" != "arm64" ]; then
        IMX_LOAD_ADDR=`cat ${B}/core/tee-init_load_addr.txt` && \
        uboot-mkimage -A arm -O linux -C none -a ${IMX_LOAD_ADDR} -e ${IMX_LOAD_ADDR} \
            -d ${DEPLOYDIR}/tee.${PLATFORM_FLAVOR}.bin ${DEPLOYDIR}/uTee-${OPTEE_BIN_EXT}
    fi

    cd ${DEPLOYDIR}
    ln -sf tee.${PLATFORM_FLAVOR}.bin tee.bin
    cd -
}

do_install () {
    install -d ${D}/lib/firmware/
    install -m 644 ${B}/core/*.bin ${D}/lib/firmware/

    # Install the TA devkit
    install -d ${D}/usr/include/optee/export-user_ta_${OPTEE_ARCH}/

    for f in ${B}/export-ta_${OPTEE_ARCH}/*; do
        cp -aR $f ${D}/usr/include/optee/export-user_ta_${OPTEE_ARCH}/
    done
}

addtask deploy after do_compile before do_install


FILES_${PN} = "/lib/firmware/"
FILES_${PN}-dev = "/usr/include/optee"
INSANE_SKIP_${PN}-dev = "staticdev"

COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"

PACKAGE_ARCH = "${MACHINE_ARCH}"
