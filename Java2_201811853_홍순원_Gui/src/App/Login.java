package App;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame{
    private JPanel topPanel, centerPanel, bottomPanel;
    private JLabel userIdLabel, passwordLabel, message;
    private JTextField userId;
    private JPasswordField password;

    public String id;

    public Login(){
        setSize(450, 300);
        setTitle("로그인 프로그램");

        //화면 상단 구성
        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        userIdLabel = new JLabel("사용자명");
        //userIdLabel.setSize(50, 10);
        userIdLabel.setBounds(50, 10, 50, 10);

        userId = new JTextField();
        userId.setSize(100, 30);

        topPanel.add(userIdLabel, BorderLayout.WEST);
        topPanel.add(userId, BorderLayout.CENTER);

        //화면 중간 구성
        centerPanel = new JPanel();

        //화면 하단 구성
        bottomPanel = new JPanel();
        message = new JLabel("메시지");
        message.setSize(50, 10);

        bottomPanel.add(message);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public String getUserId(){
        return userId.getText();
    }
}
