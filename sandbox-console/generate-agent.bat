set rootdir=%~dp0
set maindir=%rootdir%src/main
set javadir=%rootdir%src/main/java
set outputdir=%rootdir%target
set javaagent_jarname=%1
set javaagent_jarfile=%outputdir%/%javaagent_jarname%

javac -encoding utf8 %javadir%/com/sandbox/console/PreMain.java -d %outputdir%/
cd %outputdir%
jar cvfm %javaagent_jarfile% %maindir%/resources/META-INF/MANIFEST.MF ./com/sandbox/console/PreMain.class
::java -javaagent:%javaagent_jarfile% -jar %outputdir%/sandbox-console-0.0.1-SNAPSHOT.jar
cd ..
java -javaagent:%javaagent_jarfile%=agentOps -jar %javaagent_jarfile%