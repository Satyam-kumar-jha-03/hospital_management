import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;

public class hospital_db {
    private static final String url = "jdbc:mysql://localhost:3306/hospital_management";
    private static final String username = "root";
    private static final String pass = "spsp.0011";
    static Scanner input = new Scanner(System.in);
    static LocalDate date= LocalDate.now();

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        System.out.println(" Enter your Choice : ");
        System.out.println(" 1. doctor database");
        System.out.println(" 2. patient database");
        System.out.println(" 3. hospital database");
        System.out.println(" 4. record database");
        System.out.println(" 5. relative database");
        System.out.println(" 0. Exit ");
        System.out.print(" choose an option --->");
        int ch = input.nextInt();
        int b =0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("drivers loaded successfully");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url, username, pass);
            System.out.println("connection successfully");
        switch(ch) {
            case 1:
                while (b!=0) {
                    System.out.println(" Enter your Choice : ");
                    System.out.println(" 1. Add doctor data to the database ");
                    System.out.println(" 2. Remove Data from the database ");
                    System.out.println(" 3. Update doctor Data in the database ");
                    System.out.println(" 4. show the doctor database ");
                    System.out.println(" 5. get doctor specification  ");
                    System.out.println(" 0. Exit ");
                    System.out.print(" choose an option --->");
                    int a = input.nextInt();
                    switch (a) {
                        case 1:
                            addDoc(con, input);
                            break;
                        case 2:
                            delDoc(con);
                            break;
                        case 3:
                            updDoc(con, input);
                            break;
                        case 4:
                            showDoc(con);
                            break;
                        case 5:
                            getDoc(con);
                            break;
                        case 0:
                            exit();
                            b=a;
                        default:
                            System.out.println("invalid choice , please choose again ");
                    }
                }
            case 2:
                while (b!=0) {
                    System.out.println(" Enter your Choice : ");
                    System.out.println(" 1. Add doctor data to the database ");
                    System.out.println(" 2. Remove Data from the database ");
                    System.out.println(" 3. Update doctor Data in the database ");
                    System.out.println(" 4. show the doctor database ");
                    System.out.println(" 5. get doctor specification  ");
                    System.out.println(" 0. Exit ");
                    System.out.print(" choose an option --->");
                    int a = input.nextInt();
                    switch (a) {
                        case 1:
                            addPat(con, input);
                            break;
                        case 2:
                            delPat(con);
                            break;
                        case 3:
                            updPat(con, input);
                            break;
                        case 4:
                            showPat(con);
                            break;
                        case 5:
                            getPat(con);
                            break;
                        case 0:
                            exit();
                            b=a;
                        default:
                            System.out.println("invalid choice , please choose again ");
                    }
                }
            case 3:
                while (b!=0) {
                    System.out.println(" Enter your Choice : ");
                    System.out.println(" 1. Add hospital data to the database ");
                    System.out.println(" 2. Remove Data from the database ");
                    System.out.println(" 3. Update hospital Data in the database ");
                    System.out.println(" 4. show the hospital database ");
                    System.out.println(" 5. get hospital specification  ");
                    System.out.println(" 0. Exit ");
                    System.out.print(" choose an option --->");
                    int a = input.nextInt();
                    switch (a) {
                        case 1:
                            addHos(con, input);
                            break;
                        case 2:
                            delHos(con);
                            break;
                        case 3:
                            updHos(con, input);
                            break;
                        case 4:
                            showHos(con);
                            break;
                        case 5:
                            getHos(con);
                            break;
                        case 0:
                            exit();
                            b=a;
                        default:
                            System.out.println("invalid choice , please choose again ");
                    }
                }
            case 4:
                while (b!=0) {
                    System.out.println(" Enter your Choice : ");
                    System.out.println(" 1. Add record data to the database ");
                    System.out.println(" 2. Remove Data from the database ");
                    System.out.println(" 3. Update record Data in the database ");
                    System.out.println(" 4. show the patient record database ");
                    System.out.println(" 5. get hospital specification  ");
                    System.out.println(" 0. Exit ");
                    System.out.print(" choose an option --->");
                    int a = input.nextInt();
                    switch (a) {
                        case 1:
                            addRec(con, input);
                            break;
                        case 2:
                            delRec(con);
                            break;
                        case 3:
                            updRec(con, input);
                            break;
                        case 4:
                            showRec(con);
                            break;
                        case 5:
                            getRec(con);
                            break;
                        case 0:
                            exit();
                            b=a;
                        default:
                            System.out.println("invalid choice , please choose again ");
                    }
                }
            case 5:
                while (b!=0) {
                    System.out.println(" Enter your Choice : ");
                    System.out.println(" 1. Add relative data to the database ");
                    System.out.println(" 2. Remove Data from the database ");
                    System.out.println(" 3. Update record Data in the database ");
                    System.out.println(" 4. show the relative database ");
                    System.out.println(" 5. get relative details  ");
                    System.out.println(" 0. Exit ");
                    System.out.print(" choose an option --->");
                    int a = input.nextInt();
                    switch (a) {
                        case 1:
                            addRel(con, input);
                            break;
                        case 2:
                            delRel(con);
                            break;
                        case 3:
                            updRel(con, input);
                            break;
                        case 4:
                            showRel(con);
                            break;
                        case 5:
                            getRel(con);
                            break;
                        case 0:
                            exit();
                            b=a;
                        default:
                            System.out.println("invalid choice , please choose again ");
                    }
                }
            case 0:
                exit();
                input.close();
            default:
                System.out.println("invalid choice. please choose again ");


        }} catch(SQLException e){
                System.out.println(e.getMessage());
            }//catch(InterruptedException e){
                catch(InterruptedException e){
                throw new RuntimeException(e);
            }

    }

    private static void exit() throws InterruptedException {
        System.out.println("Exiting System ");
        int i = 5;
        while (i != 0) {
            System.out.print(".");
            Thread.sleep(450);
            i--;
        }
        System.out.println();
        System.out.println("thank you for using hospital reservation system!!!!");
    }



    private static void addDoc(Connection con, Scanner input) {
        try {
            System.out.println("enter the first name of the doctor ");
            String F_name = input.next();
            System.out.println("enter the last name of the doctor ");
            String L_name = input.next();
            System.out.println("enter the age of the doctor");
            int age = input.nextInt();
            System.out.println("enter the specialization of the doctor");
            String spl = input.next();
            System.out.println("enter the gender of the doctor");
            String gender = input.next();
            System.out.println("enter the doctor id od the doctor ");
            int did = input.nextInt();
            System.out.println("enter the hospital id in which the doctor works");
            int hid = input.nextInt();

            String sql = "INSERT INTO doctor( F_name, L_name, age, specialist, gender, doctor_id, hospital_id)\n"
                    + "VALUES ('" + F_name + "','" + L_name + "'," + age + ",'" + spl + "','" + gender + "' ,'" + did + "', '" + hid + "');";

            try (Statement stmt = con.createStatement()) {
//                ResultSet rs = stmt.executeQuery(sql);
                int affectrows = stmt.executeUpdate(sql);
                if (affectrows > 0) {
                        System.out.println("added successful");
                    } else {
                        System.out.println("failed to add data ");
                    }
                }
            } catch (SQLException e) {
                System.out.println("error coming");
                System.out.println(e.getMessage());
            }
        }

    private static void delDoc(Connection con) {
        try {
            System.out.println("enter the doctor id to delete from the database");
            int did = input.nextInt();
            String sql = "DELETE * \n" +
                    "FROM doctor \n" +
                    "WHERE doctor_id = " + did;
            try (Statement stmt = con.createStatement()) {
                int affectrows = stmt.executeUpdate(sql);
                if (affectrows > 0) {
                    System.out.println("deletion successful");
                } else {
                    System.out.println("failed to delete data ");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showDoc(Connection con) throws SQLException {
        String sql = "SELECT * FROM doctor;";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Current doctors:");
            System.out.println("+------------+-----------+-----+------------+--------+------------+--------------+");
            System.out.println("| First name | Last name | age | specialist | gender | doctor_id  | hospital_id  |");
            System.out.println("+------------+----------+------+------------+--------+------------+--------------+");
            while (rs.next()) {
//                int s_no = rs.getInt("no");
                String Fname = rs.getString("F_name");
                String Lname = rs.getString("L_name");
                int age = rs.getInt("age");
                String spl = rs.getString("specialist");
                String gen = rs.getString("gender");
                int did = rs.getInt("doctor_id");
                int hid = rs.getInt("hospital_id");
                System.out.printf("| %-10s | %-8s | %-4d | %-10s | %-4s | %-10d | %-10d |\n", Fname, Lname, age, spl, gen, did, hid);
                System.out.println("+------------+----------+------+----------------+--------+------------+--------------+");
            }

        }
    }

    private static void updDoc(Connection con, Scanner input) throws IOException {
        System.out.println("enter the doctor id :");
        int id = input.nextInt();
        System.out.println("what do you want to change :");
        System.out.println("1. First name");
        System.out.println("2. Last name");
        System.out.println("3. Age");
        System.out.println("4. Specification");
        System.out.print("enter your choice:");
        int ch = input.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        switch (ch) {
            case 1:
                System.out.println("enter the new first name");
                String fname = br.readLine();
                try {
                    String sql = "UPDATE doctor SET F_name =" + fname + "WHERE doctor_id = " + id+";";
//                    PreparedStatement ps = con.prepareStatement(sql);
//                    ps.setString(1,fname);

                    try (Statement stmt = con.createStatement()) {
                        int affectrows = stmt.executeUpdate(sql);
                        if (affectrows > 0) {
                            System.out.println("updated successfully ");
                        } else {
                            System.out.println("failed to update the data ");
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("error coming");
                    System.out.println(e.getMessage());
                }
                break;

            case 2:
                System.out.println("enter the new last name");
                String lname = br.readLine();
                try {
                    String sql = "UPDATE doctor SET L_name =" + '?' + "\n" +
                            "WHERE doctor_id =" + id;
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, lname);
                    try (Statement stmt = con.createStatement()) {
                        int affectrows = stmt.executeUpdate(sql);
                        if (affectrows > 0) {
                            System.out.println("updated successful");
                        } else {
                            System.out.println("failed to update data ");
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("error coming");
                    System.out.println(e.getMessage());
                }
                break;

            case 3:
                System.out.println("enter the new age");
                int age = Integer.parseInt(br.readLine());
                try {
                    String sql = "UPDATE doctor SET age =" + '?' + "\n" +
                            "WHERE doctor_id =" + id;
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, age);
                    try (Statement stmt = con.createStatement()) {
                        int affectrows = stmt.executeUpdate(sql);
                        if (affectrows > 0) {
                            System.out.println("updated successfully ");
                        } else {
                            System.out.println("failed to update the data ");
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("error coming");
                    System.out.println(e.getMessage());
                }
                break;

            case 4:
                System.out.println("enter the new specialization");
                String speci = br.readLine();
                try {
                    String sql = "UPDATE doctor SET specialist =" + '?' +
                            "\n WHERE doctor_id =" + id;
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, speci);
                    try (Statement stmt = con.createStatement()) {
                        int affectrows = stmt.executeUpdate(sql);
                        if (affectrows > 0) {
                            System.out.println("updated successfully ");
                        } else {
                            System.out.println("failed to update the data ");
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("error coming");
                    System.out.println(e.getMessage());
                }
                break;

        }
    }

    private static void getDoc(Connection con) throws SQLException {

        System.out.println("enter the doctor id you want to check");
        int d_id=input.nextInt();
        String sql = "SELECT * FROM doctor where doctor_id =" + d_id + " ;";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("data of the doctor you wany to see:");
            System.out.println("+------------+-----------+-----+------------+--------+------------+--------------+");
            System.out.println("| First name | Last name | age | specialist | gender | doctor_id  | hospital_id  |");
            System.out.println("+------------+----------+------+------------+--------+------------+--------------+");
            while(rs.next()) {
                if(rs.getInt("doctor_id")==d_id){
//                int s_no = rs.getInt("no");
                    String Fname = rs.getString("F_name");
                    String Lname = rs.getString("L_name");
                    int age = rs.getInt("age");
                    String spl = rs.getString("specialist");
                    String gen = rs.getString("gender");
                    int did = rs.getInt("doctor_id");
                    int hid = rs.getInt("hospital_id");
                    System.out.printf("| %-10s | %-8s | %-4d | %-10s | %-4s | %-10d | %-10d |\n", Fname, Lname, age, spl, gen, did, hid);
                    System.out.println("+------------+----------+------+------------+--------+------------+--------------+");
                }else{
                    System.out.println("there is no data present of the given doctor with "+d_id+ "as doctor id " );
                }
            }

        }
    }

    private static void addPat (Connection con, Scanner input){
        try {
            System.out.println("enter the first name of the patient");
            String F_name = input.next();
            System.out.println("enter the last name of the patient");
            String L_name = input.next();
            System.out.println("enter the age of the patient");
            int age = input.nextInt();
            System.out.println("enter the name of the disease found in the patient");
            String dse = input.next();
            System.out.println("enter the gender of the patient");
            String gender = input.next();
            System.out.println("enter the phone number of the patient");
            String p_no = input.nextLine();
            System.out.println("enter the patient id of the patient");
            int pid = input.nextInt();

            String sql = "INSERT INTO patient( F_name, L_name, age, disease, gender, phone_number, patient_id)\n"
                    + "VALUES ('" + F_name + "','" + L_name + "'," + age + ",'" + dse + "','" + gender + "' ,'" + p_no + "', '" + pid + "');";

            try (Statement stmt = con.createStatement()) {
//                ResultSet rs = stmt.executeQuery(sql);
                int affectrows = stmt.executeUpdate(sql);
                if (affectrows > 0) {
                    System.out.println("added successful");
                } else {
                    System.out.println("failed to add data ");
                }
            }
        } catch (SQLException e) {
            System.out.println("error coming");
            System.out.println(e.getMessage());
        }
    }

    private static void delPat(Connection con) {
        try {
            System.out.println("enter the patient id to delete from the database");
            int pid = input.nextInt();
            String sql = "DELETE * \n" +
                    "FROM patient \n" +
                    "WHERE patient_id = " + pid;
            try (Statement stmt = con.createStatement()) {
                int affectrows = stmt.executeUpdate(sql);
                if (affectrows > 0) {
                    System.out.println("deletion successful");
                } else {
                    System.out.println("failed to delete data ");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showPat(Connection con) throws SQLException {
        String sql = "SELECT * FROM patient;";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("data of all patients in the database:");
            System.out.println("+------------+-----------+-----+---------+--------+---------------+--------------+");
            System.out.println("| First name | Last name | age | disease | gender | Phone_number  | patient_id  |");
            System.out.println("+------------+-----------+-----+---------+--------+---------------+--------------+");
            while (rs.next()) {
//                int s_no = rs.getInt("no");
                String Fname = rs.getString("F_name");
                String Lname = rs.getString("L_name");
                int age = rs.getInt("age");
                String dse = rs.getString("disease");
                String gen = rs.getString("gender");
                String p_no = rs.getString("phone_number");
                int pid = rs.getInt("patient_id");
                System.out.printf("| %-10s | %-8s | %-4d | %-10s | %-4s | %-10s | %-10d |\n", Fname, Lname, age, dse, gen, p_no, pid);
                System.out.println("+------------+-----------+-----+---------+--------+---------------+--------------+");
            }

        }
    }

    private static void updPat(Connection con, Scanner input) throws IOException {
        System.out.println("enter the patient id :");
        int id = input.nextInt();
        System.out.println("what do you want to change :");
        System.out.println("1. First name");
        System.out.println("2. Last name");
        System.out.println("3. Age");
        System.out.println("4. disease");
        System.out.println("5. phone number");
        System.out.print("enter your choice:");
        int ch = input.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        switch (ch) {
            case 1:
                System.out.println("enter the new first name");
                String fname = br.readLine();
                try {
                    String sql = "UPDATE patient SET F_name =" + fname + "WHERE patient_id = " + id;
//                    PreparedStatement ps = con.prepareStatement(sql);
//                    ps.setString(1,fname);

                    try (Statement stmt = con.createStatement()) {
                        int affectrows = stmt.executeUpdate(sql);
                        if (affectrows > 0) {
                            System.out.println("updated successfully ");
                        } else {
                            System.out.println("failed to update the data ");
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("error coming");
                    System.out.println(e.getMessage());
                }
                break;

            case 2:
                System.out.println("enter the new last name");
                String lname = br.readLine();
                try {
                    String sql = "UPDATE patient SET L_name =" + '?' + "\n" +
                            "WHERE patient_id =" + id;
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, lname);
                    try (Statement stmt = con.createStatement()) {
                        int affectrows = stmt.executeUpdate(sql);
                        if (affectrows > 0) {
                            System.out.println("updated successful");
                        } else {
                            System.out.println("failed to update data ");
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("error coming");
                    System.out.println(e.getMessage());
                }
                break;

            case 3:
                System.out.println("enter the new age");
                int age = Integer.parseInt(br.readLine());
                try {
                    String sql = "UPDATE patient SET age =" + '?' + "\n" +
                            "WHERE patient_id =" + id;
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, age);
                    try (Statement stmt = con.createStatement()) {
                        int affectrows = stmt.executeUpdate(sql);
                        if (affectrows > 0) {
                            System.out.println("updated successfully ");
                        } else {
                            System.out.println("failed to update the data ");
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("error coming");
                    System.out.println(e.getMessage());
                }
                break;

            case 4:
                System.out.println("enter the new disease");
                String dse = br.readLine();
                try {
                    String sql = "UPDATE patient SET disease =" + '?' +
                            "\n WHERE patient_id =" + id;
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, dse);
                    try (Statement stmt = con.createStatement()) {
                        int affectrows = stmt.executeUpdate(sql);
                        if (affectrows > 0) {
                            System.out.println("updated successfully ");
                        } else {
                            System.out.println("failed to update the data ");
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("error coming");
                    System.out.println(e.getMessage());
                }
                break;

            case 5:
                System.out.println("enter the new phone number");
                String p_no = br.readLine();
                try {
                    String sql = "UPDATE patient SET phone_number =" + p_no + "WHERE patient_id = " + id;
//                    PreparedStatement ps = con.prepareStatement(sql);
//                    ps.setString(1,p_no);

                    try (Statement stmt = con.createStatement()) {
                        int affectrows = stmt.executeUpdate(sql);
                        if (affectrows > 0) {
                            System.out.println("updated successfully ");
                        } else {
                            System.out.println("failed to update the data ");
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("error coming");
                    System.out.println(e.getMessage());
                }
                break;

        }
    }

    private static void getPat(Connection con) throws SQLException {

        System.out.println("enter the patient id you want to check");
        int d_id=input.nextInt();
        String sql = "SELECT * FROM patient where patient_id =" + d_id + " ;";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("data of the  patient you want to see:");
            System.out.println("+------------+-----------+-----+---------+--------+---------------+--------------+");
            System.out.println("| First name | Last name | age | disease | gender | Phone_number  | patient_id  |");
            System.out.println("+------------+-----------+-----+---------+--------+---------------+--------------+");
            while(rs.next()) {
                if(rs.getInt("patients_id")==d_id){
                    String Fname = rs.getString("F_name");
                    String Lname = rs.getString("L_name");
                    int age = rs.getInt("age");
                    String dse = rs.getString("disease");
                    String gen = rs.getString("gender");
                    String p_no = rs.getString("phone_number");
                    int pid = rs.getInt("patient_id");
                    System.out.printf("| %-10s | %-8s | %-4d | %-10s | %-4s | %-10s | %-10d |\n", Fname, Lname, age, dse, gen, p_no, pid);
                }else{
                    System.out.println("there is no data present of the given patient with "+d_id+ "as patient id " );
                }
            }

        }
    }

    private static void addHos (Connection con, Scanner input){
        try {
            System.out.println("enter the hospital name ");
            String H_name = input.next();
            System.out.println("enter the state name in which hospital is present");
            String S_name = input.next();
            System.out.println("enter the city name in which hospital is present");
            String C_name = input.next();
            System.out.println("enter the address of the address");
            String adr = input.nextLine();
            System.out.println("enter the hospital id ");
            int pid = input.nextInt();

            String sql = "INSERT INTO hospitals( hospital_name, state,city,address, hospital_id)\n"
                    + "VALUES ('" + H_name + "','" + S_name + "'," + C_name + ",'" + adr + "', '" + pid + "');";

            try (Statement stmt = con.createStatement()) {
//                ResultSet rs = stmt.executeQuery(sql);
                int affectrows = stmt.executeUpdate(sql);
                if (affectrows > 0) {
                    System.out.println("added successful");
                } else {
                    System.out.println("failed to add data ");
                }
            }
        } catch (SQLException e) {
            System.out.println("error coming");
            System.out.println(e.getMessage());
        }
    }

    private static void delHos(Connection con) {
        try {
            System.out.println("enter the Hospital id to delete from the database");
            int hid = input.nextInt();
            String sql = "DELETE * \n" +
                    "FROM hospital \n" +
                    "WHERE hospital_id = " + hid;
            try (Statement stmt = con.createStatement()) {
                int affectrows = stmt.executeUpdate(sql);
                if (affectrows > 0) {
                    System.out.println("deletion successful");
                } else {
                    System.out.println("failed to delete data ");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showHos(Connection con) throws SQLException {
        String sql = "SELECT * FROM hospitals;";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("all  hospitals from the database :");
            System.out.println("+---------------+-------+------+-----------------------------+--------------+");
            System.out.println("| hospital name | state | city |            address          | hospital_id  |");
            System.out.println("+---------------+-------+------+-----------------------------+--------------+");
            while (rs.next()) {
//                int s_no = rs.getInt("no");
                String Hname = rs.getString("hospital_name");
                String Sname = rs.getString("state");
                String Cname = rs.getString("city");
                String adr = rs.getString("address");
                int hid = rs.getInt("hospital_id");
                System.out.printf("| %-16s | %-8s | %-8s | %-20s | %-5d |\n", Hname, Sname, Cname, adr, hid);
                System.out.println("+---------------+-------+------+-----------------------------+--------------+");
            }

        }
    }

    private static void updHos(Connection con, Scanner input) throws IOException {
        System.out.println("enter the hospital id :");
        int id = input.nextInt();
        System.out.println("what do you want to change :");
        System.out.println("1. Hospital name");
        System.out.println("2. state name");
        System.out.println("3. address");
        System.out.print("enter your choice:");
        int ch = input.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        switch (ch) {
            case 1:
                System.out.println("enter the new Hospital name");
                String hname = br.readLine();
                try {
                    String sql = "UPDATE hospitals SET hospital_name =" + hname + "WHERE hospital_id = " + id+";";
//                    PreparedStatement ps = con.prepareStatement(sql);
//                    ps.setString(1,hname);

                    try (Statement stmt = con.createStatement()) {
                        int affectrows = stmt.executeUpdate(sql);
                        if (affectrows > 0) {
                            System.out.println("updated successfully ");
                        } else {
                            System.out.println("failed to update the data ");
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("error coming");
                    System.out.println(e.getMessage());
                }
                break;

            case 2:
                System.out.println("enter the new state name");
                String sname = br.readLine();
                try {
                    String sql = "UPDATE hospitals SET state =" + '?' + "\n" +
                            "WHERE hospital_id =" + id;
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, sname);
                    try (Statement stmt = con.createStatement()) {
                        int affectrows = stmt.executeUpdate(sql);
                        if (affectrows > 0) {
                            System.out.println("updated successful");
                        } else {
                            System.out.println("failed to update data ");
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("error coming");
                    System.out.println(e.getMessage());
                }
                break;

            case 3:
                System.out.println("enter the new address");
                String cname = br.readLine();
                try {
                    String sql = "UPDATE hospitals SET address =" + '?' + "\n" +
                            "WHERE hospital_id =" + id;
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, cname);
                    try (Statement stmt = con.createStatement()) {
                        int affectrows = stmt.executeUpdate(sql);
                        if (affectrows > 0) {
                            System.out.println("updated successfully ");
                        } else {
                            System.out.println("failed to update the data ");
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("error coming");
                    System.out.println(e.getMessage());
                }
                break;


        }
    }

    private static void getHos(Connection con) throws SQLException {

        System.out.println("enter the hospital id you want to check");
        int d_id=input.nextInt();
        String sql = "SELECT * FROM medical_record where hospital_id =" + d_id + " ;";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("all hospital data from the database:");
            System.out.println("+---------------+-------+------+-----------------------------+--------------+");
            System.out.println("| hospital name | state | city |            address          | hospital_id  |");
            System.out.println("+---------------+-------+------+-----------------------------+--------------+");
            while(rs.next()) {
                if(rs.getInt("hospital_id")==d_id){
                    String Hname = rs.getString("hospital_name");
                    String Sname = rs.getString("state");
                    String Cname = rs.getString("city");
                    String adr = rs.getString("address");
                    int hid = rs.getInt("hospital_id");
                    System.out.printf("| %-16s | %-8s | %-8s | %-20s | %-5d |\n", Hname, Sname, Cname, adr, hid);
                    System.out.println("+---------------+-------+------+-----------------------------+--------------+");
                }else{
                    System.out.println("there is no data present of the given hospital with "+d_id+ "as hospital id " );
                }
            }

        }
    }

    private static void addRec(Connection con, Scanner input){
        try {
            System.out.println("enter the record id ");
            int R_id = input.nextInt();
            System.out.println("enter the examination date in yyyy-mm-dd format");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String e_date = date.format(formatter);
            System.out.println("enter the problem diagnosed ");
            String p_found = input.next();
            System.out.println("enter the doctor id");
            int d_id = input.nextInt();
            System.out.println("enter the patient id ");
            int p_id = input.nextInt();
            System.out.println("enter the hospital id ");
            int h_id = input.nextInt();

            String sql = "INSERT INTO medical_record( record_id, examination_date, problem_found, doctor_id, patient_id, hospital_id)\n"
                    + "VALUES ('" + R_id + "','" + e_date + "'," + p_found + ",'" + d_id + "', '" + p_id + "','"+ h_id +"');";

            try (Statement stmt = con.createStatement()) {
//                ResultSet rs = stmt.executeQuery(sql);
                int affectrows = stmt.executeUpdate(sql);
                if (affectrows > 0) {
                    System.out.println("added successful");
                } else {
                    System.out.println("failed to add data ");
                }
            }
        } catch (SQLException e) {
            System.out.println("error coming");
            System.out.println(e.getMessage());
        }
    }

    private static void delRec(Connection con) {
        try {
            System.out.println("enter the Record id to delete from the database");
            int rid = input.nextInt();
            String sql = "DELETE * \n" +
                    "FROM medical_record \n" +
                    "WHERE record_id = " + rid;
            try (Statement stmt = con.createStatement()) {
                int affectrows = stmt.executeUpdate(sql);
                if (affectrows > 0) {
                    System.out.println("deletion successful");
                } else {
                    System.out.println("failed to delete data ");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showRec(Connection con) throws SQLException {
        String sql = "SELECT * FROM medical_record;";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Current records:");
            System.out.println("+-----------+------------------+-------------------+-----------+------------+--------------+");
            System.out.println("| Record id | Examination date | Problem diagnosed | Doctor id | patient id | hospital_id  |");
            System.out.println("+-----------+------------------+-------------------+-----------+------------+--------------+");
            while (rs.next()) {
//                int s_no = rs.getInt("no");
                int Rid = rs.getInt("record_id");
                String e_date = rs.getString("examination_date");
                String p_found = rs.getString("problem_found");
                int did = rs.getInt("doctor_id");
                int pid = rs.getInt("patient_id");
                int hid = rs.getInt("hospital_id");
                System.out.printf("| %-8d | %-10s | %-8s | %-8d | %-8d | %-8d |\n", Rid, e_date, p_found, did, pid, hid);
                System.out.println("+-----------+------------------+-------------------+-----------+------------+--------------+");
            }

        }
    }

    private static void updRec(Connection con, Scanner input) throws IOException {
        System.out.println("enter the record id :");
        int id = input.nextInt();
        System.out.println("what do you want to change :");
        System.out.println("1. problem found");
        System.out.println("2. doctor id");
        System.out.println("3. hospital id");
        System.out.print("enter your choice:");
        int ch = input.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        switch (ch) {
            case 1:
                System.out.println("enter the new problem diagnosed");
                String p_found = br.readLine();
                try {
                    String sql = "UPDATE medical_record SET problem_found =" + p_found + "WHERE record_id = " + id+";";
//                    PreparedStatement ps = con.prepareStatement(sql);
//                    ps.setString(1,hname);

                    try (Statement stmt = con.createStatement()) {
                        int affectrows = stmt.executeUpdate(sql);
                        if (affectrows > 0) {
                            System.out.println("updated successfully ");
                        } else {
                            System.out.println("failed to update the data ");
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("error coming");
                    System.out.println(e.getMessage());
                }
                break;

            case 2:
                System.out.println("enter the new doctor id");
                int did = Integer.parseInt(br.readLine());
                try {
                    String sql = "UPDATE medical_record SET  =" + '?' + "\n" +
                            "WHERE record_id =" + id;
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1,did);
                    try (Statement stmt = con.createStatement()) {
                        int affectrows = stmt.executeUpdate(sql);
                        if (affectrows > 0) {
                            System.out.println("updated successful");
                        } else {
                            System.out.println("failed to update data ");
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("error coming");
                    System.out.println(e.getMessage());
                }
                break;

            case 3:
                System.out.println("enter the new hospital");
                int hid = Integer.parseInt(br.readLine());
                try {
                    String sql = "UPDATE medical_record SET hospital_id =" + '?' + "\n" +
                            "WHERE record_id =" + id;
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1,hid);
                    try (Statement stmt = con.createStatement()) {
                        int affectrows = stmt.executeUpdate(sql);
                        if (affectrows > 0) {
                            System.out.println("updated successfully ");
                        } else {
                            System.out.println("failed to update the data ");
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("error coming");
                    System.out.println(e.getMessage());
                }
                break;


        }
    }

    private static void getRec(Connection con) throws SQLException {

        System.out.println("enter the record id you want to check");
        int d_id=input.nextInt();
        String sql = "SELECT * FROM medical_record where record_id =" + d_id + " ;";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Current records:");
            System.out.println("+-----------+------------------+-------------------+-----------+------------+--------------+");
            System.out.println("| Record id | Examination date | Problem diagnosed | Doctor id | patient id | hospital_id  |");
            System.out.println("+-----------+------------------+-------------------+-----------+------------+--------------+");
            while(rs.next()) {
                if(rs.getInt("record_id")==d_id){
                int Rid = rs.getInt("record_id");
                String e_date = rs.getString("examination_date");
                String p_found = rs.getString("problem_found");
                int did = rs.getInt("doctor_id");
                int pid = rs.getInt("patient_id");
                int hid = rs.getInt("hospital_id");
                System.out.printf("| %-10d | %-15s | %-10s | %-10d | %-10d | %-10d |\n", Rid, e_date, p_found, did, pid, hid);
                System.out.println("+-----------+------------------+-------------------+-----------+------------+--------------+");
//            }
                }else{
                    System.out.println("there is no data present of the given record with "+d_id+ "as record id " );
                }
            }

        }
    }

    private static void addRel(Connection con, Scanner input){
        try {
            System.out.println("enter the relative name ");
            String R_name = input.next();
            System.out.println("enter the patient name ");
            String p_name = input.next();
            System.out.println("enter the relation with the patient");
            int relation = input.nextInt();
            System.out.println("enter the patient id ");
            int p_id = input.nextInt();
            System.out.println("enter the relative id ");
            int r_id = input.nextInt();
            String sql = "INSERT INTO relative( record_id, examination_date, problem_found, doctor_id, patient_id, hospital_id)\n"
                    + "VALUES ('" + R_name + "','" + p_name + "'," + relation +  "', '" + p_id + "','"+ r_id +"');";
            try (Statement stmt = con.createStatement()) {
//                ResultSet rs = stmt.executeQuery(sql);
                int affectrows = stmt.executeUpdate(sql);
                if (affectrows > 0) {
                    System.out.println("added successful");
                } else {
                    System.out.println("failed to add data ");
                }
            }
        } catch (SQLException e) {
            System.out.println("error coming");
            System.out.println(e.getMessage());
        }
    }

    private static void delRel(Connection con) {
        try {
            System.out.println("enter the relative id to delete from the database");
            int rid = input.nextInt();
            String sql = "DELETE * \n" +
                    "FROM relative \n" +
                    "WHERE relative_id = " + rid;
            try (Statement stmt = con.createStatement()) {
                int affectrows = stmt.executeUpdate(sql);
                if (affectrows > 0) {
                    System.out.println("deletion successful");
                } else {
                    System.out.println("failed to delete data ");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showRel(Connection con) throws SQLException {
        String sql = "SELECT * FROM relative;";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Current relatives:");
            System.out.println("+---------------+--------------+----------+------------+--------------+");
            System.out.println("| Relative name | patient name | relation | patient id | relative id  |");
            System.out.println("+---------------+--------------+----------+------------+--------------+");
            while (rs.next()) {
                int r_name = rs.getInt("relative_name");
                String p_name = rs.getString("patient_name");
                String rel = rs.getString("relation");
                int pid = rs.getInt("patient_id");
                int rid = rs.getInt("relative_id");
                System.out.printf("| %-10s | %-10s | %-8s | %-8d | %-8d |\n", r_name, p_name, rel , pid, rid);
                System.out.println("+---------------+--------------+----------+------------+--------------+");
            }

        }
    }

    private static void updRel(Connection con, Scanner input) throws IOException {
        System.out.println("enter the relative id :");
        int id = input.nextInt();
        System.out.println("what do you want to change :");
        System.out.println("1. relative name ");
        System.out.println("2. relation");
        System.out.print("enter your choice:");
        int ch = input.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        switch (ch) {
            case 1:
                System.out.println("enter the new name of relative");
                String p_found = br.readLine();
                try {
                    String sql = "UPDATE relative SET relative_name =" + p_found + "WHERE relative_id = " + id+";";
//                    PreparedStatement ps = con.prepareStatement(sql);
//                    ps.setString(1,hname);

                    try (Statement stmt = con.createStatement()) {
                        int affectrows = stmt.executeUpdate(sql);
                        if (affectrows > 0) {
                            System.out.println("updated successfully ");
                        } else {
                            System.out.println("failed to update the data ");
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("error coming");
                    System.out.println(e.getMessage());
                }
                break;

            case 2:
                System.out.println("enter the new relation");
                String rel =br.readLine();
                try {
                    String sql = "UPDATE relative SET  =" + '?' + "\n" +
                            "WHERE record_id =" + id+";";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1,rel);
                    try (Statement stmt = con.createStatement()) {
                        int affectrows = stmt.executeUpdate(sql);
                        if (affectrows > 0) {
                            System.out.println("updated successful");
                        } else {
                            System.out.println("failed to update data ");
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("error coming");
                    System.out.println(e.getMessage());
                }
                break;


        }
    }

    private static void getRel(Connection con) throws SQLException {

        System.out.println("enter the relative id you want to check");
        System.out.println("it starts from 1101");
        int d_id=input.nextInt();
        String sql = "SELECT * FROM relative where relative_id =" + d_id + " ;";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Current records:");
            System.out.println("+---------------+--------------+----------+------------+--------------+");
            System.out.println("| Relative name | patient name | relation | patient id | relative id  |");
            System.out.println("+---------------+--------------+----------+------------+--------------+");
            while(rs.next()) {
                if(rs.getInt("record_id")==d_id){
                    int r_name = rs.getInt("relative_name");
                    String p_name = rs.getString("patient_name");
                    String rel = rs.getString("relation");
                    int pid = rs.getInt("patient_id");
                    int rid = rs.getInt("relative_id");
                    System.out.printf("| %-8s | %-10s | %-8s | %-8d | %-8d |\n", r_name, p_name, rel , pid, rid);
                    System.out.println("+---------------+--------------+----------+------------+--------------+");
                } else{
                    System.out.println("there is no data present of the given record with "+d_id+ "as relative id " );
                }
            }

        }
    }



}
