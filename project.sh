#!/bin/bash
ERROR='\e[38;5;1mError:\e[38;5;231m'
GREEN='\e[38;5;2m'
RED='\e[38;5;1m'
END='\e[38;5;231m'

PROJECT_NUM=$1
PROJECT_DIR=$(pwd)
FILE_OUTPUT=""

ROOT_DIR=$(pwd)

# *************************
# FUNCTIONS
# *************************

usage () {
    echo "usage: ./project.sh [project number] [-c] [-r] [-o] [-h]"
}

helpMenu () {
    usage
    echo ""
    echo "project.sh - easily compile and run projects"
    echo ""
    echo "-h"
    echo "    Display this menu"
    echo ""
    echo "[project number]"
    echo "    Compile and run java project"
    echo ""
    echo "[project number] -c"
    echo "    Compile java project"
    echo ""
    echo "[project number] -r"
    echo "    Run java project"
    echo ""
    echo "[project number] -o [file name]"
    echo "    Compile and run project and output to file. Output file will be located in the project directory"
    echo ""
    exit 0
}

compile(){
    COMPILE_FILE=$PROJECT_DIR'/compile.sh'
    if [ ! -f $COMPILE_FILE ]; then
      echo -e $END"Project $PROJECT_NUM does not need to compile"
    else
        echo -e $END"Compiling Project $PROJECT_NUM..."
        # JAVA_FILES=$(find $PROJECT_DIR -name \*.java)
        # javac $JAVA_FILES -d $PROJECT_DIR/classes/
        cd $PROJECT_DIR
        ./compile.sh
        cd $ROOT_DIR
        if [ $? == 0 ]; then
            echo -e $GREEN"Compile successful"$END
        else
            echo -e "$ERROR Failed to compile Project $PROJECT_NUM"
            exit 1
        fi
    fi
}

run(){
  RUN_FILE=$PROJECT_DIR'/run.sh'
  if [ ! -f $RUN_FILE ]; then
    echo -e $END"Project $PROJECT_NUM does not have a run file."
  else
    echo -e $END"-------------------------"
    echo "Running Project $PROJECT_NUM..."
    echo "-------------------------"
    if [ ! -z "$FILE_OUTPUT" ]; then
        echo "Output file: $FILE_OUTPUT"
        # java -cp $PROJECT_DIR/classes project$PROJECT_NUM.Main > $FILE_OUTPUT
        cd $PROJECT_DIR
        ./run.sh > $FILE_OUTPUT
        cd $ROOT_DIR
    else
        # java -cp $PROJECT_DIR/classes project$PROJECT_NUM.Main
        cd $PROJECT_DIR
        ./run.sh
        cd $ROOT_DIR
    fi
  fi
}

# *************************
# PRECHECK
# *************************

if [[ $* == *-h* ]]; then
    helpMenu
fi

# Check if project has been spcified
if [ $# == 0 ]; then
    echo -e "$ERROR No project specified"
    exit 1
fi

# First variable should always be the project number
PROJECT_DIR=$(pwd)'/Project'$1
if [ ! -d $PROJECT_DIR ]; then
    echo "Project '$1' does not exists."
    exit 0
fi

# If only project number is passed in compile and run that project
if [ $# == 1 ]; then
    compile
    run
fi

# Don't allow compile and run flags to be combined with output flag
if [[ $* == *-c* || $* == *-r* ]]; then
    if [[ $* == *-o* ]]; then
        echo -e "$ERROR '-o' cannot be combined with '-c' or '-r'"
    fi
fi

# *************************
# EXECUTE
# *************************

while test $# -gt 0; do
    shift
    case "$1" in
        -h)
            helpMenu
            exit 0
            ;;
        -c)
            compile
            ;;
        -r)
            run
            ;;
        -o)
            shift
            if test $# -gt 0; then
                FILE_OUTPUT="$PROJECT_DIR/$1"
            else
                echo -e $ERROR" No output file specified"
                exit 1
            fi
            shift
            compile
            run
            ;;
        *)
            # makes sure the detected variable is not empty
            if [ ! -z "$1" ]; then
                echo "Invalid option: '$1'"
                usage
                exit 1
            fi
            ;;
    esac
done

# echo -e $GREEN"Done"$END
exit 0
