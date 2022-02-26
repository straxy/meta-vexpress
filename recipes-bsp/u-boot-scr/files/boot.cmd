fatload mmc 0:1 0x62000000 zImage
fatload mmc 0:1 0x68000000 vexpress-v2p-ca9.dtb
setenv bootargs "console=ttyAMA0 root=/dev/mmcblk0p2 rw"
bootz 0x62000000 - 0x68000000
