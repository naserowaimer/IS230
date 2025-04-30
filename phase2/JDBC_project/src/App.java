import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class App {
    // Scanner (Console input)
    static Scanner in = new Scanner(System.in);
    static String url = "jdbc:mariadb://localhost:3306/is_230_project";
    static String user = "root";
    static String pwd = "Naser-123";
    static String table = "EMPLOYEES";
    static DB db = new DB(url,user,pwd);
    public static void main(String[] args) {
        db.connect();
        db.statement();

        

        boolean isRunning = true;
        while(isRunning){
            System.out.println("Choos on option:");
            System.out.println("1) Insert a new employee\n" + 
                                "2) Display all the employees\n" +
                                "3) Give yearly raises\n" + 
                                "4) Exit");
            
            switch (in.nextInt()) {
                case 1:
                    boolean isAdding = true;
                    while(isAdding){
                        // Insert a new employee
                        db.update("INSERT INTO "+table+" VALUES ("+newEmployeeCall()+")");
                        System.out.print("Insert another record (Y for yes, N for no)?: ");
                        String input = in.next();
                        if(input.equals("Y")||input.equals("y") ) continue;
                        else isAdding=false;
                    }
                    break;
                case 2:
                    displayAllCall();
                    break;
                case 3:
                    System.out.println("Giving yearly raises: ");
                    System.out.print("What is the sales goal?: ");
                    double goal = in.nextDouble();
                    System.out.println("Emlpyees data before raising:");
                    displayAllCall();
                    
                    db.update("UPDATE "+ table + " SET Salary = CASE WHEN Sales>= "+ goal + " THEN Salary*1.1 ELSE Salary *1.05 END");
                    System.out.println("Emlpyees data after raising:");
                    displayAllCall();
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    throw new AssertionError();
            }
        }
        
    }
    public static String newEmployeeCall(){
        String[] res = new String[4];
        System.out.println("Inserting a new employee:");
        System.out.print("EmployeeID: ");
        res[0] = in.next();
        System.out.print("Employee Name: ");
        res[1] = in.next();
        System.out.print("Salary: ");
        res[2] = in.next();
        System.out.print("sales: ");
        res[3] = in.next();
        return res[0]+",'"+res[1]+"',"+res[2]+","+res[3];
    }
    public static void displayAllCall(){
        ResultSet result = db.query("SELECT * FROM "+table);
        try {
            System.out.printf("| %12s | %12s | %12s | %12s |%n","EmployeeId","Name", "Salary","Sales");
            while(result.next()){
                System.out.printf(
                    "| %12d | %12s | %12.2f | %12.2f |%n",
                    result.getInt("EmployeeId"),
                    result.getString("Name"),
                    result.getDouble("Salary"),
                    result.getDouble("Sales")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
