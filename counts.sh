#!/bin/sh
#set -vx
uniqueCombos=`grep Equation maven.log | awk '{print $7, $9}' |sort -u |wc -l`
pingFiles=`ls -1 *png |wc -l`

echo "Unique requests: $uniqueCombos. Png count: $pingFiles"