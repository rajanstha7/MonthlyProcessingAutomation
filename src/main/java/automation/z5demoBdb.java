package automation;

import org.testng.annotations.BeforeMethod;

import java.sql.*;

import static org.junit.Assert.assertTrue;

public class z5demoBdb {

    static Connection Conn = null;
    static PreparedStatement PrepareStat = null;

    public static void main(String[] argv) {

        try {
            System.out.println("trying to connect db");
            makeJDBCConnection();
            assertTrue(true);
            getmedicaldata();


        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    @BeforeMethod
    private static void makeJDBCConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registration");

        } catch (ClassNotFoundException e) {
            System.out.println("Sorry couldnot find jdbc driver Make sure you have added JDBC Maven Dependency Correctly");
            e.printStackTrace();
            return;
        }

        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String urljdbc = "jdbc:mysql://#########:3306/zph_z5demo_b";
            String dbuserId = "############";
            String dbpassword = "#########";
            // DriverManager: The basic service for managing a set of JDBC drivers.
            Conn = DriverManager.getConnection(urljdbc, dbuserId, dbpassword);
            if (Conn != null) {
                System.out.println("Working Connection");
                getmedicaldata();

            //    getDataFromDB();
                //check();

            } else {
                System.out.println("Failed to make connection");

            }
        } catch (SQLException e) {
            System.out.println("MYSQL connection failed");

            e.printStackTrace();
            return;
        }
        System.out.println(" @Test DB Connection Passed Succesfully"); //
        assertTrue(true);

    }


    /* To ads contents
            private static void addDataToDB(String companyName, String address, int totalEmployee, String webSite) {

                try {
                    String insertQueryStatement = "INSERT  INTO  Employee  VALUES  (?,?,?,?)";

                    PrepareStat = Conn.prepareStatement(insertQueryStatement);
                    PrepareStat.setString(1, companyName);
                    PrepareStat.setString(2, address);
                    PrepareStat.setInt(3, totalEmployee);
                    PrepareStat.setString(4, webSite);

                    // execute insert SQL statement
                    PrepareStat.executeUpdate();
                    System.out.println(companyName+"added successfully");
                    //log(companyName + " added successfully");
                } catch (

                        SQLException e) {
                    e.printStackTrace();
                }
            }

     */

    /*
    @Test
    private static void getDataFromDB() {

        try {
            // MySQL Select Query Tutorial
            String getQueryStatement = "SELECT * FROM user";


            PrepareStat = Conn.prepareStatement(getQueryStatement);

            // Execute the Query, and get a java ResultSet
            ResultSet rs = PrepareStat.executeQuery();

            // Let's iterate through the java ResultSet
            while (rs.next()) {
                //String id = rs.getString("id");
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String fname = rs.getString("first_name");
                String lname = rs.getString("last_name");
                String userID = rs.getString("username");
                String userpassword = rs.getString("password");
                Boolean status = rs.getBoolean("enabled");
                String phone = rs.getString("phone");

                // Simply Print the results
                System.out.format("ID:%d\t,Email: %s\t, FirstName:%s\t, LastName:%s\t, Username: %s\t,Password: %s\t, Enabled:%b\t,Phone No: %s\n", id, email, fname, lname, userID, userpassword, status, phone);

            }

        } catch (

                SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Get data Successfully passed");
        assertTrue(true);
    }

    */
     /*
    /* @Test
    private static void check() {

        try {
            String reqinfo = "SELECT id, first_name, last_name, phone FROM user" +
                    " WHERE email='rajan.shrestha@zakipoint.com'";
            ResultSet rs = PrepareStat.executeQuery(reqinfo);

            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String fname = rs.getString("first_name");
                String lastname = rs.getString("last_name");
                String phone = rs.getString("phone");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", First Name: " + fname);
                System.out.print(", Last Name: " + lastname);
                System.out.println(", Phone: " + phone);

                if (rs.getString("first_name").equals("Rajan")) {
                    System.out.println("Test success");
                } else {
                    System.out.println("Test failed");
                }
            }


        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }
        System.out.println("checked data successfully passed");
        assertTrue(true);
    }
*/
    public static void getmedicaldata() {
        String getmedicaldata = "SELECT CONCAT(SUBSTR(cycle_month_int,1,4),'-',SUBSTR(cycle_month_int,5,2)) cycle_date, sum(rev_paid_amt) paid_amt   FROM member_by_paid_medical_by_month member    WHERE (cycle_month_int BETWEEN 201703 AND 202002) group by cycle_date , ;";
        try {
            ResultSet getmedical = PrepareStat.executeQuery(getmedicaldata);
            while (getmedical.next()) {
                //Retrieve by column name
                Integer paidamount = getmedical.getInt("paid_amt");
                String cycle_date = getmedical.getString("cycle_date");
                
                //Display values
                System.out.format("Cycle Date: %s,Paid Amount:%d\n", cycle_date,paidamount);
            }



            } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}








