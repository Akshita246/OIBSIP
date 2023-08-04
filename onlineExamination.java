import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Exception;

class count {
    static int[] selectedAnswers = new int[5]; 
    static void setSelectedAnswer(int questionNumber, int answer) {
        selectedAnswers[questionNumber - 1] = answer; 
    }
    static int calculateScore() {
        int[] correctAnswers = {1, 3, 1, 4, 2}; 
        int score = 0;

        for (int i = 0; i < selectedAnswers.length; i++) {
            if (selectedAnswers[i] == correctAnswers[i]) {
                score++;
            }
        }
        return score;
    }
}

class login extends JFrame implements ActionListener{
    JPanel p;
    JButton sub;
    JLabel user,pass;
    JTextField user_t,pass_t;
    boolean examStarted = false;
    static JLabel remainingTime;
    static Timer timer;
    static int remainingSeconds=1800;

    login(){
        user=new JLabel("Username");
        user_t=new JTextField(15);
        pass=new JLabel("Password");
        pass_t=new JTextField(15);
        sub=new JButton("Submit");
        p=new JPanel(new GridLayout(3, 1));
        p.add(user);
        p.add(user_t);
        p.add(pass);
        p.add(pass_t);
        p.add(sub);
        remainingTime = new JLabel("Remaining Time: 30:00");
        p.add(remainingTime);
        timer = new Timer(1000, this::updateTimer);
        add(p,BorderLayout.CENTER);
        sub.addActionListener(this);
        setTitle("Login");
    }
    public void actionPerformed(ActionEvent ae){
        String value1=user_t.getText();
        String value2=pass_t.getText();
        if(value1.equals("java") && value2.equals("task04")){
            examStarted = true;
            timer.start();
            test t=new test(timer);
            t.setSize(800,400);
            t.setVisible(true);
        }
        else{
            JFrame f;
            f=new JFrame();  
            JOptionPane.showMessageDialog(f,"Invalid username or password"); 
        }
    }
     void updateTimer(ActionEvent e) {
        remainingSeconds--;
        if (remainingSeconds <= 0) {
            timer.stop();
            examEnded();
        } else {
            int minutes = remainingSeconds / 60;
            int seconds = remainingSeconds % 60;
            String timeString = String.format("%02d:%02d", minutes, seconds);
            remainingTime.setText("Remaining Time: " + timeString);
        }
    }
    void examEnded() {
        JFrame f;
        f = new JFrame();
        JOptionPane.showMessageDialog(f, "Time's up! Exam ended.");
        System.exit(0);
    }
}
class test extends JFrame implements ActionListener{
    JPanel tp;
    JLabel l1;
    JRadioButton r1,r2,r3,r4;
    JButton next;
    ButtonGroup bg;
    Timer timer;
    test(Timer timer){
        this.timer = timer;
        l1=new JLabel("1) Which of the following option leads to the portability and security of Java?");
        r1=new JRadioButton("Bytecode is executed by JVM");
        r2=new JRadioButton("The applet makes the Java code secure and portable");
        r3=new JRadioButton("Use of exception handling");
        r4=new JRadioButton("Dynamic binding between objects");
        bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);
        next=new JButton("Next");
        tp=new JPanel(new GridLayout(7,0));
        tp.add(l1);
        tp.add(r1);
        tp.add(r2);
        tp.add(r3);
        tp.add(r4);
        tp.add(next);
        add(tp,BorderLayout.CENTER);
        r1.addActionListener(this);
        r2.addActionListener(this);
        r3.addActionListener(this);
        r4.addActionListener(this);
        next.addActionListener(this);
        setTitle("test");
    }
    public void actionPerformed(ActionEvent ae){
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            int selectedAnswer = 0;
                if (r1.isSelected()) selectedAnswer = 1;
                else if (r2.isSelected()) selectedAnswer = 2;
                else if (r3.isSelected()) selectedAnswer = 3;
                else if (r4.isSelected()) selectedAnswer = 4;
                count.setSelectedAnswer(1, selectedAnswer);
                test2 t2=new test2(timer);
                t2.setSize(800,400);
                t2.setVisible(true);
            }
        });
    }
}

class test2 extends JFrame implements ActionListener{
    JPanel tp;
    JLabel l1;
    JRadioButton r1,r2,r3,r4;
    JButton next,prev;
    ButtonGroup bg;
    Timer timer;
    test2(Timer timer){
        this.timer = timer;
        l1=new JLabel("2) Which of the following is not a Java features?");
        r1=new JRadioButton("Dynamic");
        r2=new JRadioButton("Architecture Neutral");
        r3=new JRadioButton("Use of pointers");
        r4=new JRadioButton("Object-oriented");
        prev=new JButton("Prevoius");
        bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);
        next=new JButton("Next");
        tp=new JPanel(new GridLayout(7,0));
        tp.add(l1);
        tp.add(r1);
        tp.add(r2);
        tp.add(r3);
        tp.add(r4);
        tp.add(prev);
        tp.add(next);
        add(tp,BorderLayout.CENTER);
        r1.addActionListener(this);
        r2.addActionListener(this);
        r3.addActionListener(this);
        r4.addActionListener(this);
        prev.addActionListener(this);
        next.addActionListener(this);
        setTitle("test");
    }
    public void actionPerformed(ActionEvent ae){
        prev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               test t=new test(timer);
               t.setSize(800,400);
               t.setVisible(true);
            }
        });
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int selectedAnswer = 0;
                if (r1.isSelected()) selectedAnswer = 1;
                else if (r2.isSelected()) selectedAnswer = 2;
                else if (r3.isSelected()) selectedAnswer = 3;
                else if (r4.isSelected()) selectedAnswer = 4;
                count.setSelectedAnswer(2, selectedAnswer);
                test3 t3=new test3(timer);
                t3.setSize(800,400);
                t3.setVisible(true);
            }
        });
    }
}

class test3 extends JFrame implements ActionListener{
    JPanel tp;
    JLabel l1;
    JRadioButton r1,r2,r3,r4;
    JButton next,prev;
    ButtonGroup bg;
    Timer timer;
    test3(Timer timer){
        this.timer=timer;
        l1=new JLabel("3) The \\u0021 article referred to as a :");
        r1=new JRadioButton("Unicode escape sequence");
        r2=new JRadioButton("Octal escape");
        r3=new JRadioButton("Hexadecimal");
        r4=new JRadioButton("Line feed");
        bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);
        prev=new JButton("Prevoius");
        next=new JButton("Next");
        tp=new JPanel(new GridLayout(7,0));
        tp.add(l1);
        tp.add(r1);
        tp.add(r2);
        tp.add(r3);
        tp.add(r4);
        tp.add(prev);
        tp.add(next);
        add(tp,BorderLayout.CENTER);
        r1.addActionListener(this);
        r2.addActionListener(this);
        r3.addActionListener(this);
        r4.addActionListener(this);
        prev.addActionListener(this);
        next.addActionListener(this);
        setTitle("test");
    }
    public void actionPerformed(ActionEvent ae){
        prev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               test2 t2=new test2(timer);
               t2.setSize(800,400);
               t2.setVisible(true);
            }
        });
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int selectedAnswer = 0;
                if (r1.isSelected()) selectedAnswer = 1;
                else if (r2.isSelected()) selectedAnswer = 2;
                else if (r3.isSelected()) selectedAnswer = 3;
                else if (r4.isSelected()) selectedAnswer = 4;
                count.setSelectedAnswer(3, selectedAnswer);
               test4 t4=new test4(timer);
               t4.setSize(800,400);
               t4.setVisible(true);
            }
        });
    }
}
class test4 extends JFrame implements ActionListener{
    JPanel tp;
    JLabel l1;
    JRadioButton r1,r2,r3,r4;
    JButton next,prev;
    ButtonGroup bg;
    Timer timer;
    test4(Timer timer){
        this.timer=timer;
        l1=new JLabel("4) _____ is used to find and fix bugs in the Java programs.");
        r1=new JRadioButton("JVM");
        r2=new JRadioButton("JRE");
        r3=new JRadioButton("JDK");
        r4=new JRadioButton("JDB");
        bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);
        prev=new JButton("Prevoius");
        next=new JButton("Next");
        tp=new JPanel(new GridLayout(7,0));
        tp.add(l1);
        tp.add(r1);
        tp.add(r2);
        tp.add(r3);
        tp.add(r4);
        tp.add(prev);
        tp.add(next);
        add(tp,BorderLayout.CENTER);
        r1.addActionListener(this);
        r2.addActionListener(this);
        r3.addActionListener(this);
        r4.addActionListener(this);
        prev.addActionListener(this);
        next.addActionListener(this);
        setTitle("test");
    }
    public void actionPerformed(ActionEvent ae){
        prev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               test3 t3=new test3(timer);
               t3.setSize(800,400);
               t3.setVisible(true);
            }
        });
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int selectedAnswer = 0;
                if (r1.isSelected()) selectedAnswer = 1;
                else if (r2.isSelected()) selectedAnswer = 2;
                else if (r3.isSelected()) selectedAnswer = 3;
                else if (r4.isSelected()) selectedAnswer = 4;
                count.setSelectedAnswer(4, selectedAnswer);
               test5 t5=new test5(timer);
               t5.setSize(800,400);
               t5.setVisible(true);
            }
        });
    }
}
class test5 extends JFrame implements ActionListener{
    JPanel tp;
    JLabel l1;
    JRadioButton r1,r2,r3,r4;
    JButton sub,prev;
    ButtonGroup bg;
    Timer timer;
    test5(Timer timer){
        this.timer=timer;
        l1=new JLabel("5) What is the return type of the hashCode() method in the Object class?");
        r1=new JRadioButton("Object");
        r2=new JRadioButton("int");
        r3=new JRadioButton("long");
        r4=new JRadioButton("void");
        bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);
        prev=new JButton("Prevoius");
        sub=new JButton("Submit");
        tp=new JPanel(new GridLayout(7,0));
        tp.add(l1);
        tp.add(r1);
        tp.add(r2);
        tp.add(r3);
        tp.add(r4);
        tp.add(prev);
        tp.add(sub);
        add(tp,BorderLayout.CENTER);
        r1.addActionListener(this);
        r2.addActionListener(this);
        r3.addActionListener(this);
        r4.addActionListener(this);
        prev.addActionListener(this);
        sub.addActionListener(this);
        setTitle("test");
    }
    public void actionPerformed(ActionEvent ae){
        prev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               test4 t4=new test4(timer);
               t4.setSize(800,400);
               t4.setVisible(true);
            }
        });
        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int selectedAnswer = 0;
                if (r1.isSelected()) selectedAnswer = 1;
                else if (r2.isSelected()) selectedAnswer = 2;
                else if (r3.isSelected()) selectedAnswer = 3;
                else if (r4.isSelected()) selectedAnswer = 4;
                count.setSelectedAnswer(5, selectedAnswer);
                int totalScore = count.calculateScore();
                JFrame f;
                f=new JFrame();  
                JOptionPane.showMessageDialog(f,"Submitted!!!!\nYour Total score is:"+totalScore); 
                login.remainingTime.setText("Exam Submitted!");
                login.timer.stop();
                System.exit(0);
            }
        });
    }
}
public class onlineExamination{
    public static void main(String[] args){
        try{
            login l=new login();
            l.setSize(400, 200);
            l.setVisible(true);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
