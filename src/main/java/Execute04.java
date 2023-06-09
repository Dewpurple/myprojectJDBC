import java.sql.*;

public class Execute04 {

    public static void main(String[] args) throws SQLException {

//TASK - 4 : Display students' name and grade whose grades are higher than average passing grade of branches.

        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","dev_user","1234");

        Statement st=con.createStatement();

        String q04="Select name, grade From students Where grade >(Select AVG(pass_grade) From departments )";
        ResultSet rs04=st.executeQuery(q04);

        while (rs04.next()){
            System.out.println(rs04.getString("name") + " " + rs04.getInt("grade"));
        }

        con.close();
        st.close();
        rs04.close();



    }
}
