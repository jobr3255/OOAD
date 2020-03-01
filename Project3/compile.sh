#!/bin/bash

MAIN_DIR="src"
TARGET="classes"
JAVA_FILES=$(find $MAIN_DIR -name \*.java)
javac $JAVA_FILES -d $TARGET

# TEST_DIR="src/test/java"
# JAVA_FILES=$(find $TEST_DIR -name \*.java)
# javac $JAVA_FILES -d target/test-classes/
