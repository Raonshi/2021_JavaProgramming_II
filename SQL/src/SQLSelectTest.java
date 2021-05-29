import java.sql.*;

public class SQLSelectTest {
    public static Connection makeConnection(){
        String url = "jdbc:mysql://localhost/book_db";

        String id = "root";
        String password = "tnsdnjs2@";
        Connection con = null;


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 로드 성공");
            con = DriverManager.getConnection(url, id, password);
            System.out.println("데이터베이스 연결 성공");
        }
        catch(ClassNotFoundException classNotFoundException){
            System.out.println("드라이버를 찾을 수 없습니다.");
        }
        catch (SQLException sqlException){
            System.out.println("연결에 실패하였습니다.");
        }

        return con;
    }

    public static void main(String[] arg) throws SQLException{
        Connection connection = makeConnection();

        String SQL = "SELECT * FROM books";
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(SQL);

        while(resultSet.next()){
            int id = resultSet.getInt("book_id");
            String title = resultSet.getString("title");

            System.out.println(id + " " + title);
        }
    }


}
