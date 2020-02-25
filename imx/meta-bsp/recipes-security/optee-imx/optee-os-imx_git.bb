# Copyright (C) 2017-2018 NXP

SUMMARY = "OPTEE OS"
DESCRIPTION = "OPTEE OS"
HOMEPAGE = "http://www.optee.org/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=69663ab153298557a59c67a60a743e5b"

inherit deploy pythonnative autotools
DEPENDS = "python-pycrypto-native u-boot-mkimage-native"

SRCBRANCH = "imx_4.14.98_2.1.0"
OPTEE_OS_SRC ?= "git://source.codeaurora.org/external/imx/imx-optee-os.git;protocol=https"
SRC_URI = "${OPTEE_OS_SRC};branch=${SRCBRANCH}"

SRC_URI += "file://0001-PTA-add-support-for-deriving-device-and-TA-unique-ke.patch" 
SRC_URI += "file://0002-core-introduce-huk_subkey_derive.patch" 
SRC_URI += "file://0003-core-add-scattered-array.patch" 
SRC_URI += "file://0004-core-introduce-CFG_CORE_HUK_SUBKEY_COMPAT.patch" 
SRC_URI += "file://0005-HUK-Add-enum-for-TA-unique-key-derivation.patch" 
SRC_URI += "file://0006-core-fix-access-flags-in-system_derive_ta_unique_key.patch" 
SRC_URI += "file://0007-core-pseudo_ta-Pass-null-memref-as-valid-param.patch" 
SRC_URI += "file://0008-MMIOT-95-We-should-change-the-API-of-tee_otp_get_hw_.patch" 
SRC_URI += "file://0009-libmbedtls-configure-mbedTLS-for-different-modes.patch" 
SRC_URI += "file://0010-libmbedtls-make-mbedtls_mpi_mont-available.patch" 
SRC_URI += "file://0011-libmbedtls-add-mbedtls_mpi_init_mempool.patch" 
SRC_URI += "file://0012-mbedtls-add-mbedtls_mpi_init_static.patch" 
SRC_URI += "file://0013-mbedtls-fix-memory-leak-in-mpi_miller_rabin.patch" 
SRC_URI += "file://0014-mbedtls-TEE_BigIntMul-use-temporary.patch" 
SRC_URI += "file://0015-libutee-lessen-dependency-on-mbedtls-internals.patch" 
SRC_URI += "file://0016-Squashed-commit-upgrading-to-mbedtls-2.16.0.patch" 
SRC_URI += "file://0017-libmbedtls-add-interfaces-in-mbedtls-for-context-mem.patch" 
SRC_URI += "file://0018-libmbedtls-fix-no-CRT-issue.patch" 
SRC_URI += "file://0019-libmbedtls-support-mbedTLS-in-kernel-mode.patch" 
SRC_URI += "file://0020-libmbedtls-support-mbedtls-hash-algorithm.patch" 
SRC_URI += "file://0021-libmbedtls-support-symmetrical-ciphers.patch" 
SRC_URI += "file://0022-libmbedtls-implement-AES-encrypt-api.patch" 
SRC_URI += "file://0023-libmbedtls-support-mbedtls-HMAC-algorithm.patch" 
SRC_URI += "file://0024-libmbedtls-support-CMAC-algorithm.patch" 
SRC_URI += "file://0025-libmbedtls-support-mbedtls-bignum-functions.patch" 
SRC_URI += "file://0026-libmbedtls-support-mbedtls-acipher-RSA-function.patch" 
SRC_URI += "file://0027-libmbedtls-support-mbedtls-DH-function.patch" 
SRC_URI += "file://0028-libmbedtls-support-mbedtls-ECC-function.patch" 
SRC_URI += "file://0029-libmbedtls-Support-DSA-algorithm.patch" 
SRC_URI += "file://0030-libmbedtls-Support-cipher-XTS-algorithm.patch" 
SRC_URI += "file://0031-mbedtls-Support-AES-CCM-algorithm.patch" 
SRC_URI += "file://0032-ci-.shippable.yml-add-build-for-mbedtls.patch" 
SRC_URI += "file://0033-libmbedtls-mbedtls_mpi_exp_mod-initialize-W.patch" 
SRC_URI += "file://0034-libmbedtls-preserve-mempool-usage-on-reinit.patch" 
SRC_URI += "file://0035-libmbedtls-mbedtls_mpi_exp_mod-reduce-stack-usage.patch" 
SRC_URI += "file://0036-libmbedtls-mbedtls_mpi_exp_mod-optimize-mempool-usag.patch" 
SRCREV = "37f4865cd3a4d22cbebeb7d8fe83449d77dd5c7f" 

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
                CFG_RDC_DECODED_BUFFER=0xCE000000', '', d)}"

do_compile () {
    unset LDFLAGS
    export CFLAGS="${CFLAGS} --sysroot=${STAGING_DIR_HOST}"
    oe_runmake -C ${S} all CFG_TEE_TA_LOG_LEVEL=0
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
