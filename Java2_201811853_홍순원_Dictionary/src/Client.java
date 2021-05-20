import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client extends JFrame implements ActionListener {
    private JTextArea area;
    private JTextField engField, hgField;
    private JButton btn;
    private JPanel top;

    public Client(){
        setTitle("번역 클라이언트");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        top = new JPanel();
        top.setLayout(new GridLayout(1, 3));
        add(top, BorderLayout.NORTH);

        engField = new JTextField();
        hgField = new JTextField();
        top.add(engField);
        top.add(hgField);

        btn = new JButton();
        btn.addActionListener(this);
        top.add(btn);


        area = new JTextArea(10, 50);
        area.setEditable(false);

        add(area, BorderLayout.CENTER);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] arg){
        Client client = new Client();
    }
}
