import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1.step: Register Driver - (optional)
        Class.forName("org.postgresql.Driver");

        //2.step : Create Connection to get connected to DB
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","dev_user","1234");

        //3. step: Create Statement -- to execute SQL queries
        Statement st=con.createStatement();

        //4. step: Execute SQL queries


//        boolean sql1=st.execute("CREATE TABLE employee (employee_id INT, employee_name VARCHAR(50), salary REAL)");
//        //execute() returns boolean true or false, and this method is DDL (Data Definition Language), or DQL (Data Query Language)
//        //if it is used with  DDL it returns false
//        //if it is used with  DQL (Select...) it returns true
//        System.out.println("sql1 Create Table employee :" +sql1);


        //TASK 2: add Varchar (20) column name "city" to employee table

//        String sql2String= "Alter Table employee ADD COLUMN city Varchar (20)";
//        boolean sql2= st.execute(sql2String);
//        System.out.println("Add a column with Alter " +sql2);


        //TASK 3: Delete employee table from SCHEMA

//        String sql3String= "Drop Table employee ";
//        boolean sql3=st.execute(sql3String);
//        System.out.println(sql3);


        con.close();
        st.close();



    }
}
