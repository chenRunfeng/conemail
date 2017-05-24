package springweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 

public class testjtds {
	public static void main(String[] args) {
        Connection con=null;
        try
        {
            String driver="net.sourceforge.jtds.jdbc.Driver";
            String url="jdbc:jtds:sqlserver://127.0.0.1:1433/consultation";
            Class.forName(driver).newInstance();
            System.out.println(" [net.sourceforge.jtds.jdbc.Driver]连接开始。。。。。。");
            long starttime = System.currentTimeMillis();
            con =DriverManager.getConnection(url,"sa","sa");
            long endtime = System.currentTimeMillis();
            System.out.println(" 连接成功 !Lost time:" + (endtime - starttime) +"毫秒");
//            Statement stat=con.createStatement();
//            for(Integer i=0;i<10;i++)
//                stat.execute("insert into test1(title,val,des) values('title','values','description')");                
//            long inserttime = System.currentTimeMillis();
//            System.out.println(" insert成功 !Lost time:" + (inserttime-endtime) +"毫秒");
//            for(Integer i=0;i<10;i++)
//                stat.execute("update test1 set des='description update'");
//            long updatetime = System.currentTimeMillis();
//            System.out.println(" insert成功 !Lost time:" + (updatetime-inserttime) +"毫秒");
//            for(Integer i=0;i<10;i++)
//                stat.executeQuery("select * from test1 where title='title'");
//            long selecttime = System.currentTimeMillis();
//            System.out.println(" select成功 !Lost time:" + (selecttime-updatetime) +"毫秒");
//            for(Integer i=0;i<10;i++)
//                stat.execute("delete  from test1 where title='title'");
//            long deltime = System.currentTimeMillis();
//            System.out.println(" delete成功 !Lost time:" + (deltime-selecttime) +"毫秒");
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(null != con){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
 
}
