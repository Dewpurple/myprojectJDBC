import java.sql.*;

public class Execute02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

      Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","dev_user","1234");

      Statement st=con.createStatement();

        //TASK-1. GET/SELECT  "country_name" from countries table with ID between 5 and 10

        String q01="Select country_name From countries Where id Between 5 and 10";
        boolean sql1=st.execute(q01);
        System.out.println(sql1);

       ResultSet rs01=st.executeQuery(q01);
       //1.way

//        rs01.next();
//        System.out.println(rs01.getString("country_name"));
//        rs01.next();
//        System.out.println(rs01.getString("country_name"));

      //2.way

   //   while(rs01.next()){
        //  System.out.println(rs01.getString("country_name"));//get column by columnLabel
      //      System.out.println(rs01.getString(1));//get column by index number.

      //ResultSet    has methods such first(), last (), or next()




 //  }

        //TASK - 2: Get "phone_code" and "country_name" from countries table,
        // whose phone code is greater than 200

        String q02="Select phone_code,country_name From countries Where phone_code> 200";
        boolean sql2=st.execute(q02);
        System.out.println(sql2);

        ResultSet rs02=st.executeQuery(q02);

        while (rs02.next()){
          //  System.out.println(rs02.getInt("phone_code") + " " +rs02.getString("country_name"));
           System.out.println(rs02.getInt(1) + " " +rs02.getString(2));
        }

        con.close();
        st.close();
        rs02.close();
        rs01.close();

    }
}
