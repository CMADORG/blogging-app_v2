FROM tomcat:latest
ADD target/*.war /usr/local/tomcat/webapps/CMAD.war
ADD setenv.sh /usr/local/tomcat/bin/setenv.sh