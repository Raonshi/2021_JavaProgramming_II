import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main {
    private JTextField userIdInput;
    private JPasswordField passwordInput;
    private JButton loginBtn;
    private JLabel message;
    private JPanel panel;

    ArrayList<UserData> userList = new ArrayList();

    String idInput = null;
    String pwInput = null;

    boolean isFail = false;

    public Main() {

        //버튼 클릭했을 때
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //gui에서 입력한 값을 받아온다.
                idInput = userIdInput.getText().trim();
                pwInput = new String(passwordInput.getPassword()).trim();

                try{
                    //사용자 정보가 저정된 파일을 읽어온다.
                    String filePath = System.getProperty("user.dir") + "/login.txt";
                    FileReader reader = new FileReader(filePath);
                    String line = "";
                    BufferedReader buffer = new BufferedReader(reader, 4096);

                    //한줄 씩 읽으면서 UserData객체로 만든 뒤 userList 배열에 저장
                    while((line = buffer.readLine()) != null){
                        String[] lineArray = line.split(":");
                        UserData tmp = new UserData(lineArray[0], lineArray[1], lineArray[2]);
                        userList.add(tmp);
                    }//end of while

                    //UserData의 값을 순서대로 비교하면서 로그인 여부 확인
                    for(int i = 0; i < userList.size(); i++){
                        UserData user = userList.get(i);

                        if(idInput.equals(user.id) && pwInput.equals(user.pw)){
                            isFail = false;
                            message.setText(user.name + "님, 반갑습니다!");
                            break;
                        }
                        else{
                            isFail = true;
                        }
                    }//end of for
                    
                    if(isFail == true){
                        message.setText("로그인실패");
                    }
                }//end of try
                catch(Exception exception){
                    exception.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args){
        //GUI화면 로드
        JFrame app = new JFrame("Login App");
        app.setContentPane(new Main().panel);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.pack();
        app.setVisible(true);
    }
}

//UserData 객체
class UserData{
    String id, pw, name;

    UserData(String id, String pw, String name){
        this.id = id;
        this.pw = pw;
        this.name = name;
    }
}


