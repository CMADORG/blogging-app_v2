FROM tomcat:latest
ADD target/CMAD1*.war /usr/local/tomcat/webapps/CMAD1.war
ADD setenv.sh /usr/local/tomcat/bin/setenv.sh