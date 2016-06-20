#/bin/sh
cd ../Source/oot
mvn package
cp gui/target/gui-0.0.1-jar-with-dependencies.jar ../../bin/WerWirdMillionaer.jar
cd ../../bin