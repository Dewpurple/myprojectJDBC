import java.sql.*;

public class ExecuteQuery03 {

    public static void main(String[] args) throws SQLException {

        //1)
        //Create connection and import
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "dev_user", "1234");

        //Create Statement -- to execute SQL queries
        Statement st = con.createStatement();



        System.out.println("************** Task-3 **************");
        //Task-3: List department name, campus and highest grades of students from every department

        String query3 = "SELECT department, campus, (SELECT max(grade) FROM students s WHERE d.department = s.department) max_grade FROM departments d";
        ResultSet rs3 =  st.executeQuery(query3);

        while (rs3.next()){
            System.out.println(rs3.getString("department")+" -- " +
                    rs3.getString("campus")+" -- "+
                    rs3.getInt("max_grade"));
        }


        st.close();
        con.close();


    }
}
