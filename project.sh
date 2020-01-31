#!/bin/bash
ERROR='\e[38;5;1mError:\e[38;5;231m'
GREEN='\e[38;5;2m'
RED='\e[38;5;1m'
END='\e[38;5;231m'

PROJECT_NUM=$1
PROJECT_DIR=$(pwd)

helpMenu () {
  echo "project.sh - easily compile and run projects"
  echo " "
  echo "project.sh [project number] [option]"
  echo "Defualt options: -c -r"
  echo ""
  echo "[option]:"
  echo "-c      Compile java project"
  echo "-r      Run java project"
  echo ""
  exit 0
}

compile(){
  echo -e $END"Compiling Project $PROJECT_NUM..."
  JAVA_FILES=$(find $PROJECT_DIR -name \*.java)
  javac $JAVA_FILES -d $PROJECT_DIR/classes/
  if [ $? == 0 ]; then
    echo -e $GREEN"Compile successful"$END
  else
    echo -e $ERROR" Failed to compile"$END
    exit 1
  fi
}

run(){
  echo "-------------------------"
  echo "Running Project $PROJECT_NUM..."
  echo "-------------------------"
  java -cp $PROJECT_DIR/classes project$PROJECT_NUM.Main
}


# Check options
if [ $# == 0 ]; then
  echo -e "$ERROR: No project specified"
  exit 1
elif [ $# -gt 2 ]; then
  echo -e "$ERROR: Too many options"
  exit 1
elif [ $1 == "-h" ]; then
  helpMenu
fi

PROJECT_DIR=$(pwd)'/Project'$1
if [ ! -d $PROJECT_DIR ]; then
  echo "Project '$1' does not exists."
  exit 0
fi

if [ $# == 1 ]; then
  compile
  run
fi
# If statement to detect flags
# if [[ $* == *--flag* ]]
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
    *)
      # makes sure the detected variable is not empty
      if [ ! -z "$1" ]; then
        echo "Invalid option: '$1'"
        exit 1
      fi
      ;;
  esac
done

# echo -e $GREEN"Done"$END
exit 0
