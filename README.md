# hdfs_java_client

cd hdfs_java_client

cp /etc/hadoop/conf/hdfs-site.xml .
cp /etc/hadoop/conf/core-site.xml .
cp /etc/hbase/conf/hbase-site.xml .

mv manifest_CDH5.15.txt manifest.txt

or 

mv manifest_HDP-2.6.5.txt manifest.txt


mkdir libs

cd libs

# For CDH:

cp /opt/cloudera/parcels/CDH/lib/hadoop/hadoop-common.jar .
cp /opt/cloudera/parcels/CDH/lib/hadoop/hadoop-auth.jar .
cp /opt/cloudera/parcels/CDH/lib/hadoop/hadoop-annotations.jar .
cp /opt/cloudera/parcels/CDH/lib/hadoop/client/hadoop-hdfs.jar .
cp /opt/cloudera/parcels/CDH/lib/hadoop/client/htrace-core4.jar .
cp /opt/cloudera/parcels/CDH/lib/hadoop/client/commons-cli.jar .
cp /opt/cloudera/parcels/CDH/lib/hadoop/client/commons-codec.jar .
cp /opt/cloudera/parcels/CDH/lib/hadoop/client/commons-collections.jar .
cp /opt/cloudera/parcels/CDH/lib/hadoop/client/commons-configuration.jar .
cp /opt/cloudera/parcels/CDH/lib/hadoop/client/commons-lang.jar .
cp /opt/cloudera/parcels/CDH/lib/hadoop/client/commons-logging.jar .
cp /opt/cloudera/parcels/CDH/lib/hadoop/client/guava.jar .
cp /opt/cloudera/parcels/CDH/lib/hadoop/client/log4j.jar .
cp /opt/cloudera/parcels/CDH/lib/hadoop/client/protobuf-java.jar .
cp /opt/cloudera/parcels/CDH/lib/hadoop/client/slf4j-api.jar .
cp /opt/cloudera/parcels/CDH/lib/hadoop/client/slf4j-log4j12.jar .

# For HDP

cp /usr/hdp/current/hadoop-client/client/hadoop-common.jar .
cp /usr/hdp/current/hadoop-client/client/hadoop-auth.jar .
cp /usr/hdp/current/hadoop-client/client/hadoop-annotations.jar .
cp /usr/hdp/current/hadoop-client/client/hadoop-hdfs.jar .
cp /usr/hdp/current/hadoop-client/client/htrace-core.jar .
cp /usr/hdp/current/hadoop-client/client/commons-cli.jar .
cp /usr/hdp/current/hadoop-client/client/commons-codec.jar .
cp /usr/hdp/current/hadoop-client/client/commons-collections.jar .
cp /usr/hdp/current/hadoop-client/client/commons-configuration.jar .
cp /usr/hdp/current/hadoop-client/client/commons-io.jar .
cp /usr/hdp/current/hadoop-client/client/commons-lang.jar .
cp /usr/hdp/current/hadoop-client/client/commons-logging.jar .
cp /usr/hdp/current/hadoop-client/client/guava.jar .
cp /usr/hdp/current/hadoop-client/client/log4j.jar .
cp /usr/hdp/current/hadoop-client/client/protobuf-java.jar .
cp /usr/hdp/current/hadoop-client/client/slf4j-api.jar .
cp /usr/hdp/current/hadoop-client/client/slf4j-log4j12.jar .

cd ../

javac -cp "libs/*:." HdfsTest.java


jar cvfm HdfsTest.jar manifest.txt HdfsTest.class libs

# Usage:

java -jar HdfsTest.jar <Active NN> <ANN port > <path> <user> <auth>

a. java -jar HdfsTest.jar a.b.com 8020 / hdfs kerberos

b. java -jar HdfsTest.jar a.b.com 8020 / hdfs simple

# For Kerberos:

1. Get a valid Kerberos ticket

2. java -jar HdfsTest.jar <Active NN> 8020 / hdfs kerberos

# Non kerberos:

1 java -jar HdfsTest.jar <Active NN> 8020 / hdfs simple
