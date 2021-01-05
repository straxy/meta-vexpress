SUMMARY = "Linux Kernel for vexpress-a9"
SECTION = "kernel"
LICENSE = "GPLv2"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel siteinfo

DEPENDS += "lzop-native bc-native"

LINUX_VERSION ?= "5.9.11"

# PV = "${LINUX_VERSION}"
# S = "${WORKDIR}/linux-${PV}"
# SRC_URI = " \
#     https://cdn.kernel.org/pub/linux/kernel/v5.x/linux-${PV}.tar.xz \
# "
# SRC_URI[md5sum] = "530543935698468bf30dfacd4a20d84f"
# SRC_URI[sha256sum] = "5eb20a65a410669928f94b3975872e493fa6d0fe441c6a78b7564affa2a5d260"

SRCBRANCH = "linux-5.9.y"
LOCALVERSION = "-vexpress"
SRCREV = "38cbdc4e3d0bd01bfb3ec16081bbf7dadfafd659"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=https;branch=${SRCBRANCH} \
    file://defconfig \
"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "(vexpress-qemu)"

KBUILD_DEFCONFIG_vexpress-qemu = "multi_v7_defconfig"

