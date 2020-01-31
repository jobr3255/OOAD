#!/bin/bash

./compile.sh
if [ $? == 0 ]; then
  ./run.sh
fi
