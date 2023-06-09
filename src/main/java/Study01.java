import java.sql.*;

public class Study01 {

    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "dev_user", "1234");
        Statement st = con.createStatement();
        String iscilerTablosu = "Create Table isciler"
                + " (id int  primary key,"
                + " birim Varchar (10),"
                + " maas int)";
        System.out.println(st.execute(iscilerTablosu));

        boolean s1=st.execute("drop table isciler");;
        System.out.println(s1);


        con.close();
        st.close();

        boolean s2=st.execute("Select* from isciler");;
        System.out.println(s1);//kapanmis tabloda islem yapilmaz



    }
}
