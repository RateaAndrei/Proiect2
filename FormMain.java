import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormMain {
    private JPanel rootForm;
    private JTextField txtUser;
    private JButton btnLogin;
    private JPasswordField txtpass;
    private JLabel lab1;

    public static boolean Viz=false;
    public static boolean Viz2=false;
    public static boolean Viz3=false;

    public static Student s1 = new Student("Ionescu","Ion","1111");   //student1
    public static Student s2 = new Student("Gheorghe","George","2222"); //student2
    public static Student s3 = new Student("Geni","Alin","3333");  //student3

    public FormMain() {
        btnLogin.addActionListener(new ActionListener() {
            @Override
          public void actionPerformed(ActionEvent e) {
                String user= txtUser.getText();                        //username
                String password=txtpass.getText();                     //parola
                if(user.equals("Ana")&&password.equals("123")){        //verificare
                  Viz=true;
                }
                else{lab1.setVisible(true);
                lab1.setText("incorect");
                }
            }
        });
    }
    public static class FormMain2 {
        private JPanel rootForm2;
        private JButton Btn1;
        private JButton btn2;

        public FormMain2() {
            Btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   Viz2=true;
                   Viz=false;
                }
            });
            btn2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Viz3=true;
                    Viz=false;
                    Viz2=false;
                }
            });
        }
    }
    public static class Form3 {
        private JTextField txtNrMat;
        private JPanel rootform3;
        private JButton btnCNR;
        private JLabel lbl2;
        private JLabel lbl3;
        private JLabel lbl4;

        public Form3() {
            btnCNR.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    s1.SetNota(10);  //nota student 1
                    s2.SetNota(8);   //nota student 2
                    s3.SetNota(7);   //nota student 3

                    String nr=txtNrMat.getText();

                    //verificare nr matricol
                    if(nr.equals("1111")){lbl2.setText(s1.toString());
                            lbl3.setText("numarul matricol: "+s1.getNrMatricol());
                            lbl4.setText("nota: "+s1.getNota());
                    }
                    if(nr.equals("2222")){lbl2.setText(s2.toString());
                        lbl3.setText("numarul matricol: "+s2.getNrMatricol());
                        lbl4.setText("nota: "+s2.getNota());}
                    if(nr.equals("3333")){lbl2.setText(s3.toString());
                        lbl3.setText("numarul matricol: "+s3.getNrMatricol());
                        lbl4.setText("nota: "+s3.getNota());}
                    if((!nr.equals("1111"))&&(!nr.equals("2222"))&&(!nr.equals("3333"))){lbl2.setText("numar incorect");
                        lbl3.setText("");
                        lbl4.setText("");}
                }
            });
        }
    }
    public static class Form4 {
        private JTextField txtNume;
        private JTextField txtPrenume;
        private JTextField txtNumarMatricol;
        private JPanel rootForm4;
        private JButton btnIStud;
        private JList list1;

        public Form4() {
            btnIStud.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ArrayList<Student> Studenti =new ArrayList<>();   //arratlist studenti
                    Studenti.add(s1);      //adaug student 1 in arraylist
                    Studenti.add(s2);      //adaug student 2 in arraylist
                    Studenti.add(s3);      //adaug student 3 in arraylist

                    //introducere nume ,prenume si nr Matricol pentru studentul 4
                    String txNume=txtNume.getText();
                    String txPrenume=txtPrenume.getText();
                    String txNrMat=txtNumarMatricol.getText();

                    Student s4 =new Student(txNume,txPrenume,txNrMat);    //student 4
                    Studenti.add(s4);                                     //adaug student 4 in arraylist
                    Student[] arr= new Student[Studenti.size()];      //Conversie Arraylist in Array
                    Studenti.toArray(arr);
                    list1.setListData(arr);                           //Adauga datele din Array in Jlist
                }
            });
        }
    }

    public static void main(String[] args) {
        JFrame frame= new JFrame("LogIn");              //frame 1
        frame.setContentPane(new FormMain().rootForm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(300,200);

        JFrame frame2= new JFrame(" ");                //frame 2
        frame2.setContentPane(new FormMain2().rootForm2);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.pack();
        frame2.setSize(300,200);

        JFrame frame3= new JFrame(" ");               //frame 3
        frame3.setContentPane(new Form3().rootform3);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.pack();
        frame3.setSize(300,200);

        JFrame frame4 = new JFrame(" ");           //frame 4
        frame4.setContentPane(new Form4().rootForm4);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.pack();
        frame4.setSize(410,250);

        //vizibilitate frame-uri
        while(!Viz){
            frame.setVisible(true);
        }
        while(Viz){
            frame.setVisible(false);
            frame2.setVisible(true);
        }
      while(Viz2){
          frame3.setVisible(true);
          frame2.setVisible(false);
      }
      while(!Viz3){
          frame4.setVisible(false);
      }
      while(Viz3){
          frame4.setVisible(true);
          frame2.setVisible(false);
      }
    }
}
