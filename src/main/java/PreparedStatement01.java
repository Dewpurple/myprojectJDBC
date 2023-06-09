import java.sql.*;

public class PreparedStatement01 {

    public static void main(String[] args) throws SQLException {

        //1)
        //Create connection and import
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "dev_user", "1234");

        //Create Statement -- to execute SQL queries
        Statement st = con.createStatement();

        //2) task is  Update pass_grade to 475 of Mathematics department (use PreparedStatement)

        //paremeterized query
        String q1 = "update departments\n" +
                "set pass_grade=?\n" +
                "where department ILIKE ?; \n";

        //create prepared statement
        PreparedStatement prs=con.prepareStatement(q1);
        //set values for the parameters
        prs.setInt(1,475);
        prs.setString(2,"mathematics");
        //execute the prepared statement
        int numOfUpdated =prs.executeUpdate();
        System.out.println("numOfUpdated = " + numOfUpdated);

        //2) task is  Update pass_grade to 455 of Literature department (use PreparedStatement)
        String q2 = "update departments\n" +
                "set pass_grade=?\n" +
                "where department ILIKE ?; \n";

        //create prepared statement
        PreparedStatement prs2=con.prepareStatement(q2);
        //set values for the parameters
        prs2.setInt(1,455);
        prs2.setString(2,"literature");
        //execute the prepared statement
        int numOfUpdated2 =prs2.executeUpdate();
        System.out.println("numOfUpdated of Literature = " + numOfUpdated2);




       st.close();
       con.close();
       prs.close();
       prs2.close();
    }
}
