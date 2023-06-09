import java.sql.*;

public class PreparedStatement02 {

    public static void main(String[] args) throws SQLException {
        //1)
        //Create connection and import
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "dev_user", "1234");

        //Create Statement -- to execute SQL queries
        Statement st = con.createStatement();


        //2) //TASK-1. Using preparedstatement, delete students who are from Mathematics department, from students table.
        //        System.out.println("************ TASK-1 **************");

//        String q1 = "delete from students where department ILIKE ?";
//        PreparedStatement prs=con.prepareStatement(q1);
//        prs.setString(1,"mathematics");
//        int numOfUpdated =prs.executeUpdate();
//        System.out.println("deleted = " + numOfUpdated);

        //TASK-2. Insert software engineering department using prepared statement into departments table.
        // (id = 5006, pass_grade=475, campus='South')

        String q2 = "INSERT INTO departments VALUES ( ?, ? , ?, ?)";
        PreparedStatement prs2=con.prepareStatement(q2);
        prs2.setInt(1,5006);
        prs2.setString(2,"software_engineering");
        prs2.setString(4,"South");
        prs2.setInt(3,475);


        int numOfUpdated2 =prs2.executeUpdate();
        System.out.println("added = " + numOfUpdated2);



       // prs.close();
        con.close();
        st.close();


    }
}
