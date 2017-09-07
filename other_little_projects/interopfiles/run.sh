#!/bin/sh

javac P1Writer/P1Writer.java -d bin/ && javac P2Reader/P2Reader.java -d bin/ && javac P3_42/P3_42.java -d bin/ && cd bin/ && java P1Writer && java P2Reader && java P3_42 && java P2Reader
