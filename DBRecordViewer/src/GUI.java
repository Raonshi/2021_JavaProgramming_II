import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class GUI extends JFrame {

    private JTextField id, title, publisher, year, price, search;
    private JButton nextBtn, preBtn;

    Statement stmt;
    ResultSet resultSet;

    public GUI() {
        super("DataBase Viewer");
        setLayout(new GridLayout(0,2));

        //db연결
        Connection connection = Main.makeConnection();
        try{
            String SQL = "SELECT * FROM books";
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            resultSet = stmt.executeQuery(SQL);
        }
        catch (SQLException sqlException){
            System.out.println("쿼리 실행에 실패하여 프로그램을 종료합니다.");
            System.exit(0);
        }


        add(new JLabel("ID", JLabel.CENTER));
        add(id = new JTextField());

        add(new JLabel("TITLE", JLabel.CENTER));
        add(title = new JTextField());

        add(new JLabel("PUBLISHER", JLabel.CENTER));
        add(publisher = new JTextField());

        add(new JLabel("YEAR", JLabel.CENTER));
        add(year = new JTextField());

        add(new JLabel("PRICE", JLabel.CENTER));
        add(price = new JTextField());

        add(new JLabel("저자검색", JLabel.CENTER));
        add(search = new JTextField());

        nextBtn = new JButton("NEXT");
        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    resultSet.next();
                    id.setText(resultSet.getString("book_id"));
                    title.setText(resultSet.getString("title"));
                    publisher.setText(resultSet.getString("publisher"));
                    year.setText(resultSet.getString("year"));
                    price.setText(resultSet.getString("price"));
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });
        add(nextBtn);

        preBtn = new JButton("PREVIOUS");
        preBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    resultSet.previous();
                    id.setText(resultSet.getString("book_id"));
                    title.setText(resultSet.getString("title"));
                    publisher.setText(resultSet.getString("publisher"));
                    year.setText(resultSet.getString("year"));
                    price.setText(resultSet.getString("price"));
                }
                catch (SQLException sqlException){
                    sqlException.printStackTrace();
                }
            }
        });
        add(preBtn);

        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
