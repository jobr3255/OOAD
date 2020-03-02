#!/bin/bash
./compile.sh
if [ $? == 0 ]; then
  cd classes
  java project3.test.TestRunner
fi
