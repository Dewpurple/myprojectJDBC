import java.sql.*;

public class Execute001 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //2.Register the Driver Class
        Class.forName("org.postgresql.Driver");

        //3.create Connection to get connected to DB
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro","postgres","1234");

        //4.create statement  -- to execute SQL queries
        Statement st=con.createStatement();
        System.out.println("Connection Success");

     //   ResultSet rs=st.executeQuery("select *from tablename");


    }
}
