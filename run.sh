#!/bin/bash
java -cp .:antlr-4.7.1-complete.jar org.antlr.v4.Tool Language.g4 -package language.parser -o ./src/language/parser


