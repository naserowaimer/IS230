import java.sql.*;
public class DB {
    private Connection conn = null;
    private Statement stmt = null;
    private String url;
    private String user;
    private String pwd;

    public DB(String url, String user, String pwd) {
        this.url = url;
        this.user = user;
        this.pwd = pwd;
    }

    public Connection connect(){
        if(conn==null){
            try {
                conn = DriverManager.getConnection(url, user, pwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Successfully connected to database");
            return conn;
        }else return conn;
    }

    public Statement statement(){
        if(stmt==null){
            try {
                stmt = this.connect().createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return stmt;
        }else return stmt;
    }

    public boolean update(String sql){
        try{
            statement().executeUpdate(sql);
            return true;
        }catch(SQLException e){
            System.out.println("Error: "+e.getMessage());
            return false;
        }
    }

    public ResultSet query(String sql){
        try {
            return statement().executeQuery(sql);
        } catch (Exception e) {
            System.err.println("Error: "+e.getMessage());
            return null;
        }
    }

    public void close(){
        try {
            statement().close();
            connect().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
