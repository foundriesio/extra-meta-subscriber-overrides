#!/bin/sh -e

PORT="${PORT-8090}"
MSG="${MSG-Hello from Shellhttpd Recipe}"

RESPONSE="HTTP/1.1 200 OK\r\n\r\n${MSG}\r\n"

while true; do
	echo -en "$RESPONSE" | nc -c -l -p "${PORT}" || true
	echo "= $(date) ============================="
done