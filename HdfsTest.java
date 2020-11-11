import java.security.PrivilegedExceptionAction;

import org.apache.hadoop.conf.*;
import org.apache.hadoop.security.UserGroupInformation;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileStatus;

public class HdfsTest {

    public static void main(String args[]) {

        String nn_host = args[0];
        String nn_port = args[1];
        String hdfs_dir = args[2];
        String hdfs_user = args[3];
        String hdfs_auth = args[4];

        try {
            
            Configuration conf = new Configuration();
            
            conf.set("fs.defaultFS", "hdfs://"+nn_host+":"+nn_port);
            if(hdfs_auth.equals("kerberos")) {
                conf.set("hadoop.security.authentication", "kerberos");
            }            

            UserGroupInformation.setConfiguration(conf);
            // Subject is taken from current user context
            UserGroupInformation.loginUserFromSubject(null);

            FileSystem fs = FileSystem.get(conf);
            FileStatus[] fsStatus = fs.listStatus(new Path(hdfs_dir));

            for (FileStatus file : fsStatus ){
                System.out.println(file.getPath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
