require conf/distro/poky.conf

DISTRO = "mistra-base"
DISTRO_NAME = "Mistra Distro Base"
DISTRO_VERSION = "3.1"

SDK_VENDOR = "-mistrasdk"

MAINTAINER = "straxy <strahinja.p.jankovic@gmail.com>"

TARGET_VENDOR = "-mistra"

DISTROOVERRIDES = "mistra"

ARM_INSTRUCTION_SET_mistra ??= "thumb"

# Log information on images and packages
INHERIT += "buildhistory"
BUILDHISTORY_COMMIT = "1"
