#!/bin/bash

java -Dspring.profiles.active=prod -classpath Scaffold.jar com.jiwon.app.util.PasswordEncryption $1