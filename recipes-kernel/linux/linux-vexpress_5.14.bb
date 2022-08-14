SUMMARY = "Linux Kernel for vexpress-a9"
SECTION = "kernel"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel siteinfo
require recipes-kernel/linux/linux-yocto.inc

DEPENDS += "lzop-native bc-native"

LINUX_VERSION ?= "5.14.3"
PV = "${LINUX_VERSION}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# If archive is used
# {

# PV = "${LINUX_VERSION}"
# S = "${WORKDIR}/linux-${PV}"
# SRC_URI = " \
#     https://cdn.kernel.org/pub/linux/kernel/v5.x/linux-${PV}.tar.xz \
#     file://graphics.cfg \
# "
# SRC_URI[md5sum] = "b45b18effd1af9077de47f4bc496d2ab"
# SRC_URI[sha256sum] = "c6c340be69e22021d9406c51467d03e2e28fb7221939b2ef114cac3d3602a8d8"

# } else
# If git is used
# {

SRCBRANCH = "linux-5.14.y"
LOCALVERSION = "-vexpress"
SRCREV = "787ccb9cba759e35906f1793fbf975d3336053d9"
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=https;branch=${SRCBRANCH} \
           file://graphics.cfg \
           file://0001-Device-tree-update-for-mmsens.patch \
           "
S = "${WORKDIR}/git"

# }

COMPATIBLE_MACHINE = "(vexpress-qemu)"

KBUILD_DEFCONFIG_vexpress-qemu = "multi_v7_defconfig"
KCONFIG_MODE = "--alldefconfig"

