SUMMARY = "Start up Shellhttpd Application"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit allarch systemd
RDEPENDS_${PN} += "bash"

SRC_URI = " \
	file://httpd.sh \
	file://shellhttpd.service \
"
SRCREV = "f90f221ce4fcea2fde0062bc909f26cca6dbd1b6"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SYSTEMD_SERVICE_${PN} = "shellhttpd.service"
SYSTEMD_AUTO_ENABLE_${PN} = "enable"

do_install () {
	install -d ${D}${systemd_system_unitdir}
	install -m 0644 ${WORKDIR}/shellhttpd.service ${D}${systemd_system_unitdir}
	install -d ${D}${datadir}/shellhttpd/
	install -m 0755 ${WORKDIR}/httpd.sh ${D}${datadir}/shellhttpd/

}

FILES_${PN} += "${systemd_system_unitdir}/shellhttpd.service"
FILES_${PN} += "${systemd_unitdir}/system-preset"
FILES_${PN} += "${datadir} ${datadir}/app-manager/"
