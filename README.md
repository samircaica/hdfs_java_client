# hdfs_java_client

cd hdfs_java_client

cp /etc/hadoop/conf/hdfs-site.xml .<br />
cp /etc/hadoop/conf/core-site.xml .<br />
cp /etc/hbase/conf/hbase-site.xml .<br />

mv manifest_CDH5.15.txt manifest.txt

or 

mv manifest_HDP-2.6.5.txt manifest.txt


mkdir libs

cd libs

# For CDH:

cp /opt/cloudera/parcels/CDH/lib/hadoop/hadoop-common.jar .  
cp /opt/cloudera/parcels/CDH/lib/hadoop/hadoop-auth.jar .  
cp /opt/cloudera/parcels/CDH/lib/hadoop/hadoop-annotations.jar .<br />
cp /opt/cloudera/parcels/CDH/lib/hadoop/client/hadoop-hdfs.jar .<br />
cp /opt/cloudera/parcels/CDH/lib/hadoop/client/htrace-core4.jar .<br />
cp /opt/cloudera/parcels/CDH/lib/hadoop/client/commons-cli.jar .<br />
cp /opt/cloudera/parcels/CDH/lib/hadoop/client/commons-codec.jar .<br />
cp /opt/cloudera/parcels/CDH/lib/hadoop/client/commons-collections.jar .<br />
cp /opt/cloudera/parcels/CDH/lib/hadoop/client/commons-configuration.jar .<br />
cp /opt/cloudera/parcels/CDH/lib/hadoop/client/commons-lang.jar .<br />
cp /opt/cloudera/parcels/CDH/lib/hadoop/client/commons-logging.jar .<br />
cp /opt/cloudera/parcels/CDH/lib/hadoop/client/guava.jar .<br />
cp /opt/cloudera/parcels/CDH/lib/hadoop/client/log4j.jar .<br />
cp /opt/cloudera/parcels/CDH/lib/hadoop/client/protobuf-java.jar .<br />
cp /opt/cloudera/parcels/CDH/lib/hadoop/client/slf4j-api.jar .<br />
cp /opt/cloudera/parcels/CDH/lib/hadoop/client/slf4j-log4j12.jar .<br />

# For HDP

cp /usr/hdp/current/hadoop-client/client/hadoop-common.jar .<br />
cp /usr/hdp/current/hadoop-client/client/hadoop-auth.jar .<br />
cp /usr/hdp/current/hadoop-client/client/hadoop-annotations.jar .<br />
cp /usr/hdp/current/hadoop-client/client/hadoop-hdfs.jar .<br />
cp /usr/hdp/current/hadoop-client/client/htrace-core.jar .<br />
cp /usr/hdp/current/hadoop-client/client/commons-cli.jar .<br />
cp /usr/hdp/current/hadoop-client/client/commons-codec.jar .<br />
cp /usr/hdp/current/hadoop-client/client/commons-collections.jar .<br />
cp /usr/hdp/current/hadoop-client/client/commons-configuration.jar .<br />
cp /usr/hdp/current/hadoop-client/client/commons-io.jar .<br />
cp /usr/hdp/current/hadoop-client/client/commons-lang.jar .<br />
cp /usr/hdp/current/hadoop-client/client/commons-logging.jar .<br />
cp /usr/hdp/current/hadoop-client/client/guava.jar .<br />
cp /usr/hdp/current/hadoop-client/client/log4j.jar .<br />
cp /usr/hdp/current/hadoop-client/client/protobuf-java.jar .<br />
cp /usr/hdp/current/hadoop-client/client/slf4j-api.jar .<br />
cp /usr/hdp/current/hadoop-client/client/slf4j-log4j12.jar .<br />

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
