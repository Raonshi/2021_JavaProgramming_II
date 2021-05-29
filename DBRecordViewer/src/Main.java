import java.sql.*;

public class Main {

    public static void main(String[] arg){
        GUI gui = new GUI();
    }

    public static Connection makeConnection(){
        Connection connection = null;

        String url = "jdbc:mysql://localhost/book_db";
        String user = "root";
        String password = "tnsdnjs2@";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC 드라이버 로드에 성공하였습니다.");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("데이터베이스 연결에 성공하였습니다.");
        }
        catch (ClassNotFoundException classNotFoundException){
            System.out.println("JDBC 드라이버 로드에 실패하였습니다 : " + classNotFoundException.getMessage());
        }
        catch (SQLException sqlException){
            System.out.println("데이터베이스 연결에 실패하였습니다 : " + sqlException.getMessage());
        }
        return connection;
    }
}
