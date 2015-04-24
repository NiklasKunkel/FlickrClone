# FlickrClone

This is a clone of the popular social image site Flickr

All that's needed to run the server is to execute: 
./apache-tomcat-5.5.15/bin/catalina.sh start

If any of the files are changed, the following sequence is necessary:
./apache-tomcat-5.5.15/bin/catalina.sh stop
rm photoshare/photoshare.war
rm apache-tomcat-5.5.15/webapps/photoshare.war
rm -r apache-tomcat-5.5.15/webapps/photoshare
ant -f photoshare.xml all
cp photoshare/photoshare.war apache-tomcat-5.5.15/webapps
./apache-tomcat-5.5.15/bin/catalina.sh start

If the schema is changed (located in photoshare/docs) then must execute:
psql -f /home/course/cs460/nkunkel/cs460/PA2/photoshare/docs/photoshare_schema.sql