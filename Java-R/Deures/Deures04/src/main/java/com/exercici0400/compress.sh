#!/bin/bash

rm -rf Libs
rm -rf .build

zip -r exercici0400.zip . -x "*.DS_Store" "*/__MACOSX/*" "compress.sh"
