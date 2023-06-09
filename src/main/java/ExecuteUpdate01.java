import java.sql.*;

public class ExecuteUpdate01 {

    public static void main(String[] args) throws SQLException {

        //1)
        //Create connection and import
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "dev_user", "1234");

        //Create Statement -- to execute SQL queries
        Statement st = con.createStatement();


        //TASK-1. Update salaries of developers whose salaries are less than average salary with average salary
        String q1 = "update developers \n" +
                "set salary=(Select Avg (salary) from developers)\n" +
                "Where salary<(Select Avg(salary) from developers)";
        int rs1 = st.executeUpdate(q1);

        System.out.println(" " + rs1);
        //to see all records

        String query2 = "SELECT name, salary FROM developers";
        ResultSet rs2 = st.executeQuery(query2);
        while (rs2.next()){
            System.out.println(rs2.getString("name")+" -- "+ rs2.getDouble("salary"));
        }

        //TASK-2. Add new developer to developers table
//        String q2 = "INSERT INTO developers (id,name,salary,prog_lang) VALUES (21,'Bedreddin',6000,'Python')";
//        int rs02=st.executeUpdate(q2);
//        System.out.println("Inserted" +rs02);


        //TASK-3. DELETE row which has id of 14
//        String q3= "DELETE FROM developers WHERE id=14";
//        int rs03=st.executeUpdate(q3);
//        System.out.println("Deleted" +rs03);


        //TASK-4. DELETE prog_lang which is Ruby
        String q4= "DELETE FROM developers WHERE prog_lang ILIKE 'ruby'";
        int rs04=st.executeUpdate(q4);
        System.out.println("Deleted ===> Ruby" +rs04);




        con.close();
        st.close();


    }
}
