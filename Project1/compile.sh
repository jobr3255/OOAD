#!/bin/bash

JAVA_FILES=$(find src -name \*.java)
javac $JAVA_FILES -d classes/
