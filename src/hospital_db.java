import javax.sound.sampled.Line;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.SQLException;
import java.sql.Statement;

public class hospital_db {
    private static final String url = "jdbc:mysql://localhost:3306/hospital_management";
    private static final String username = "root";
    private static final String pass = "spsp.0011";
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws ClassNotFoundException,SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("drivers loaded successfully");
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con =DriverManager.getConnection(url,username,pass);
            System.out.println("connection successfully");
            while(true){
                System.out.println(" Enter your Choice : ");
                System.out.println(" 1. Add doctor data to the database ");
                System.out.println(" 2. Remove Data from the database ");
                System.out.println(" 3. Update doctor Data in the database ");
                System.out.println(" 4. show the doctor database ");
                System.out.println(" 5. get doctor specification ");
                System.out.println(" 0. Exit ");
                System.out.print(" choose an option --->");
                int a = input.nextInt();
                switch(a){
                    case 1:
                        addDoc(con,input);
                        break;
                    case 2:
                        delDoc(con);
                        break;
                    case 3:
                        //updDoc(con,input);
                        break;
                    case 4:
                        showDoc(con,input);
                        break;
                    case 5:
                        //getDoc(con,input);
                        break;
                    case 0:
                        //exit();
                        input.close();
                    default:
                        System.out.println("invalid choice , please choose again ");
                }
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }//catch(InterruptedException e){
           // throw new RuntimeException(e);
        //}

    }
    private static void addDoc(Connection con, Scanner input){
        try{
//            System.out.println("enter the first name ");
//            String F_name=input.next();
//            System.out.println("enter the last name ");
//            String L_name=input.next();
//            System.out.println("enter the age ");
//            int age =input.nextInt();
//            System.out.println("enter the specialization ");
//            String spl=input.next();
//            System.out.println("enter the gender ");
//            String gender=input.next();
//            System.out.println("enter the doctor id ");
//            int did =input.nextInt();
//            System.out.println("enter the hospital id ");
//            int hid =input.nextInt();
            String sql = "INSERT INTO doctor( F_name, L_name, age, specialist, gender, doctor_id, hospital_id)\n"
            +"VALUES ('aditya','gupta',47,'neurosurgeon','m',104,1101);";
            try( Statement stmt = con.createStatement()){
                int affectrows= stmt.executeUpdate(sql);
                if(affectrows>0){
                    System.out.println("added successful");
                }else{
                    System.out.println("failed to add data ");
                }}
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
    }
    private static void delDoc(Connection con){
        try{
            System.out.println("enter the first name ");
            String F_name=input.next();
            System.out.println("enter the last name ");
            String L_name=input.next();
            System.out.println("enter the age ");
            int age =input.nextInt();
            System.out.println("enter the specialization ");
            String spl=input.next();
            System.out.println("enter the gender ");
            String gender=input.next();
            System.out.println("enter the doctor id ");
            int did =input.nextInt();
            System.out.println("enter the hospital id ");
            int hid =input.nextInt();
            String sql = "INSERT INTO doctor( F_name, L_name, age, specialist, gender, doctor_id, hospital_id)\n"
                    +"VALUES (F_name,L_name,age,spl,gender,did,hid);";
            try( Statement stmt = con.createStatement()){
                int affectrows= stmt.executeUpdate(sql);
                if(affectrows>0){
                    System.out.println("added successful");
                }else{
                    System.out.println("failed to add data ");
                }}
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private static void showDoc(Connection con, Scanner input) throws SQLException{
        String sql = "SELECT * FROM doctor;";

            try( Statement stmt = con.createStatement()){
                ResultSet rs=   stmt.executeQuery(sql);
                System.out.println("Current Reservations:");
                System.out.println("+------------+-----------+-----+------------+--------+------------+--------------+");
                System.out.println("| First name | Last name | age | specialist | gender | doctor_id  | hospital_id  |");
                System.out.println("+------------+----------+------+------------+--------+------------+--------------+");
                while(rs.next()){
                    int s_no = rs.getInt("no");
                    String Fname = rs.getString("F_name");
                    String Lname = rs.getString("L_name");
                    int age = rs.getInt("age");
                    String spl = rs.getString("specialist");
                    String gen = rs.getString("gender");
                    int did = rs.getInt("doctor_id");
                    int hid = rs.getInt("hospital_id");
                    System.out.printf("| %-10s | %-8s | %-4d | %-10s | %-4s | %-10d | %-10d |\n",Fname,Lname,age,spl,gen,did,hid);
                    System.out.println("+------------+----------+------+----------------+--------+------------+--------------+");
                }

    }





}}
