# Copyright 2017-2018 NXP

require imx-vpu-hantro.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=72c0f70181bb6e83eee6aab8de12a9f3"

SRC_URI[md5sum] = "48593116d410ed152d63a9a0ae35524f"
SRC_URI[sha256sum] = "e4bff5ee4c68233428dda4ff33ab890010429fa4d4c7acee43dbdf2600f99018"


SRC_URI += "file://0001-MMIOT-193-Use-hantro-driver-to-read-VPU-io-regs.patch;md5sum=7fd1217c06e41e34a3580cdb5b48eb47" 
SRC_URI += "file://0002-MMIOT-91-Fix-memory-leak-in-VP9-hwd-decoder.patch;md5sum=08c9934f4f02f54f92e6991016d0a302" 
SRC_URI += "file://0003-MMIOT-91-Fix-memory-leak-in-VP9-hwd-decoder.patch;md5sum=bac459e772ed87355197ceec5b6debfe" 
SRC_URI += "file://0004-M865SW-132-G1G2-HEVC-decoder-illegal-memory-access-i.patch;md5sum=f6d94e12673fb7eaf13c7634781a4c4b" 
SRC_URI += "file://0005-MMIOT-418-Allow-to-configure-CFG_SECURE_DATA_PATH-on.patch;md5sum=7e7dd3d1ae7cf530fb495753b89e285a" 
SRC_URI += "file://0006-MMIOT-477-Parse-VP9-super-frame-index-in-secure-mode.patch;md5sum=64f033ac55d3527c0058e8ea84c927aa" 

COMPATIBLE_MACHINE = "imxvpuhantro"
