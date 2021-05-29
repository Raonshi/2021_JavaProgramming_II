import java.sql.*;

public class SQLInsertTest {

    public static Connection makeConnection(){
        Connection con = null;

        String url = "jdbc:mysql://localhost/book_db";
        String id = "root";
        String password = "tnsdnjs2@";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, id, password);
        }catch (ClassNotFoundException classNotFoundException){
            System.out.println("드라이버 로드에 실패하였습니다 : " + classNotFoundException.getMessage());
        }
        catch (SQLException sqlException){
            System.out.println("DB연결에 실패하였습니다 : " + sqlException.getMessage());
        }

        return con;
    }



    public static void main(String[] arg)throws SQLException{
        searchBook();
        addBook("Artificial Intellegence", "Addison Wesley", "2002", 35000);
        searchBook();
    }

    private static void addBook(String title, String publisher, String year, int price){
        Connection con = makeConnection();

        try{
            String SQL = "INSERT INTO books(title, publisher, year, price) VALUES ";
            SQL += "('" + title + "', '" + publisher + "', '" + year + "', '" + price + "')";

            System.out.println("쿼리 : " + SQL);

            Statement stmt = con.createStatement();
            int i = stmt.executeUpdate(SQL);

            //반환이 1이면 정상
            if(i == 1){
                System.out.println("레코드를 정상적으로 추가하였습니다.");
            }
            else{
                System.out.println("레코드 추가 실패");
            }
        }
        catch (SQLException sqlException){
            System.out.println("쿼리 실행이 실패하였습니다 : " + sqlException.getMessage());
            System.exit(0);
        }
    }

    private static void searchBook() throws SQLException{
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
