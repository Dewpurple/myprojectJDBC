import java.sql.*;

public class Execute03 {

    public static void main(String[] args) throws SQLException {

        //TASK-3. Get all information about the developers whose salary is lowest
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","dev_user","1234");

        Statement statement=con.createStatement();

        String query3 = "SELECT * FROM developers WHERE salary = (SELECT min(salary) FROM developers)";
        ResultSet resultSet3 = statement.executeQuery(query3);

        while (resultSet3.next()){
            System.out.println(resultSet3.getInt("id")+" -- "+resultSet3.getString("name")+
                    " -- "+ resultSet3.getString("prog_lang") +" -- "+ resultSet3.getDouble("salary"));
        }

        con.close();
        statement.close();
        resultSet3.close();


    }
}
