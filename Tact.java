import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Tact extends JFrame implements ActionListener {
     JPanel panel,tp;
    Random ran;
    JButton[] buttons=new JButton[9];
    JLabel tf;
    Boolean p;
    Tact(){
        setTitle("TictacToe");
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setVisible(true);
        ran=new Random();
        tp=new JPanel();
        tf=new JLabel();
        tf.setBackground(new Color(25,25,25));
        tf.setForeground(new Color(25,255,0));
        tf.setText("Tic-Tac-Toe");
        tf.setOpaque(true);
        tp.setBounds(0,0,800,100);
        tp.setBackground(Color.black);
        tf.setFont(new Font("Arial", Font.BOLD,75));
        tf.setHorizontalAlignment(JLabel.CENTER);

        panel=new JPanel();
        panel.setLayout(new GridLayout(3,3));
        panel.setBackground(Color.green);
        panel.setBounds(0,100,800,700);

        for (int i=0;i<9;i++){
            buttons[i]=new JButton();
            panel.add(buttons[i]);
            buttons[i].setFont(new Font("Mv Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        tp.add(tf);
        add(tp,BorderLayout.NORTH);
        add(panel);
        firstTurn();
    }
    public void actionPerformed(ActionEvent e){
        for (int i=0;i<9;i++){
           if( e.getSource()==buttons[i]){
               if(p){
                   if (buttons[i].getText()==""){
                       buttons[i].setForeground(new Color(255,0,0));
                       buttons[i].setText("X");
                       p=false;
                       tf.setText("0-turn");
                       check();
                   }
               }
               else {
                   if (buttons[i].getText()==""){
                       buttons[i].setForeground(new Color(0,0,255));
                       buttons[i].setText("0");
                       p=true;
                       tf.setText("X-turn");
                       check();
                   }
               }
           }
        }

    }
    public void firstTurn(){
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        if(ran.nextInt(2)==0){
            p=true;
            tf.setText("X-turn");
        }
        else {
            p=false;
            tf.setText("0-turn");
        }
    }
    public void check(){
        if (
                (buttons[0].getText()=="X")&&
                        (buttons[1].getText()=="X")&&
                        (buttons[2].getText()=="X")
        ){
            xwins(0,1,2);
        }
        if (
                (buttons[3].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[5].getText()=="X")
        ){
            xwins(3,4,5);
        }
        if (
                (buttons[6].getText()=="X")&&
                        (buttons[7].getText()=="X")&&
                        (buttons[8].getText()=="X")
        ){
            xwins(6,7,8);
        }
        if (
                (buttons[0].getText()=="X")&&
                        (buttons[3].getText()=="X")&&
                        (buttons[6].getText()=="X")
        ){
            xwins(0,3,6);
        }
        if (
                (buttons[1].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[7].getText()=="X")
        ){
            xwins(1,4,7);
        }
        if (
                (buttons[2].getText()=="X")&&
                        (buttons[5].getText()=="X")&&
                        (buttons[8].getText()=="X")
        ){
            xwins(2,5,8);
        }
        if (
                (buttons[0].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[8].getText()=="X")
        ){
            xwins(0,4,8);
        }
        if (
                (buttons[2].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[6].getText()=="X")
        ){
            xwins(2,4,6);
        }
        if (
                (buttons[0].getText()=="0")&&
                        (buttons[1].getText()=="0")&&
                        (buttons[2].getText()=="0")
        ){
            owins(0,1,2);
        }
        if (
                (buttons[3].getText()=="0")&&
                        (buttons[4].getText()=="0")&&
                        (buttons[5].getText()=="0")
        ){
            owins(3,4,5);
        }
        if (
                (buttons[6].getText()=="0")&&
                        (buttons[7].getText()=="0")&&
                        (buttons[8].getText()=="0")
        ){
            owins(6,7,8);
        }
        if (
                (buttons[0].getText()=="0")&&
                        (buttons[3].getText()=="0")&&
                        (buttons[6].getText()=="0")
        ){
            owins(0,3,6);
        }
        if (
                (buttons[1].getText()=="0")&&
                        (buttons[4].getText()=="0")&&
                        (buttons[7].getText()=="0")
        ){
            owins(1,4,7);
        }
        if (
                (buttons[2].getText()=="0")&&
                        (buttons[5].getText()=="0")&&
                        (buttons[8].getText()=="0")
        ){
            owins(2,5,8);
        }
        if (
                (buttons[0].getText()=="0")&&
                        (buttons[4].getText()=="0")&&
                        (buttons[8].getText()=="0")
        ){
            owins(0,4,8);
        }
        if (
                (buttons[2].getText()=="0")&&
                        (buttons[4].getText()=="0")&&
                        (buttons[6].getText()=="0")
        ){
            owins(2,4,6);
        }
    }
    public void xwins(int a,int b,int c){
    buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i=0;i<9;i++){
        buttons[i].setEnabled(false);
        }
        tf.setText("X-Won");
    }
    public void owins(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        tf.setText("0-Won");
    }
    public static void main(String[] args) {
       new Tact();
    }
}