import java.sql.*;

public class ExecuteQuery02 {
    public static void main(String[] args) throws SQLException {

        //1)
        //Create connection and import
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "dev_user", "1234");

        //Create Statement -- to execute SQL queries
        Statement st = con.createStatement();


        //2)
//        System.out.println("************** Task-1 1.way **************");
//        //Task-1: Print department name and grade of department which has second highest pass_grade
//        String q1 = "SELECT department , pass_grade FROM departments ORDER BY pass_grade DESC OFFSET 1 LIMIT 1";
//        ResultSet rs1 =  st.executeQuery(q1);
//        while (rs1.next()){
//            System.out.println("Department: "+rs1.getString("department")+" -- "+rs1.getInt("pass_grade"));
//        }



        System.out.println("************** Task-1 2.way **************");
        //Task-1: Print department name and grade of department which has second highest pass_grade
        String q1 = "Select department, pass_grade from departments where pass_grade=(SELECT MAX(pass_grade)\n" +
                "FROM departments\n" +
                "WHERE pass_grade<(SELECT MAX(pass_grade) FROM departments))";
        ResultSet rs1 =  st.executeQuery(q1);
        while (rs1.next()){
            System.out.println("Department: "+rs1.getString("department")+" -- "+rs1.getInt("pass_grade"));
        }


        //last one is close
        con.close();
        st.close();


    }
}
