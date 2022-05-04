import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ScientificCalculator {
    private JFrame frame;
    private JTextField textField;
    double first;
    double second;
    double result;
    String operation;

    JPanel panelNormal;
    JPanel panelScintific;
    JPanel panelLogIn;
    JTabbedPane tp;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ScientificCalculator window = new ScientificCalculator();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    public ScientificCalculator() {
        initialize();
    }
    private void initialize() {
        frame = new JFrame();
        frame.setForeground(Color.WHITE);
        frame.getContentPane().setForeground(Color.BLACK);
        frame.setBounds(100, 100, 357, 700);
//        frame.setSize(400,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        scientificCal();
        normalCalculator();

        JLabel lblNewLabel = new JLabel("SCIENTIFIC CALCULATOR");
        lblNewLabel.setBounds(10, 11, 310, 23);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
//        frame.getContentPane().add(lblNewLabel);
        panelScintific.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.BOLD, 15));
        textField.setBounds(10, 39, 320, 63);
//        frame.getContentPane().add(textField);
        textField.setColumns(10);
        panelScintific.add(textField);



//         button 2
        JButton btn2 = new JButton("2");
        btn2.addActionListener(arg0 -> {
            String number=textField.getText()+btn2.getText();
            textField.setText(number);
        });

        btn2.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn2.setBounds(139, 398, 64, 50);
//        frame.getContentPane().add(btn2);
        panelScintific.add(btn2);


        //         button 5
        JButton btn5 = new JButton("5");
        btn5.addActionListener(arg0 -> {
            String number=textField.getText()+btn5.getText();
            textField.setText(number);
        });
        btn5.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn5.setBounds(139, 347, 64, 50);
//        frame.getContentPane().add(btn5);
        panelScintific.add(btn5);




        //         button 8
        JButton btn8 = new JButton("8");
        btn8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number=textField.getText()+btn8.getText();
                textField.setText(number);
            }
        });
        btn8.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn8.setBounds(139, 295, 64, 50);
//        frame.getContentPane().add(btn8);
        panelScintific.add(btn8);

        //         button C
        JButton btnC = new JButton("C");
        btnC.setFont(new Font("Tahoma", Font.PLAIN, 19));
        btnC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                textField.setText(null);
            }
        });
        btnC.setBounds(139, 243, 64, 50);
        panelScintific.add(btnC);
//        frame.getContentPane().add(btnC);


        //         button sinH
        JButton btnLn = new JButton("sinh");
        btnLn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a = Math.sinh(Double.parseDouble(textField.getText()));
                textField.setText("");
                textField.setText(textField.getText()+a);
            }
        });
        btnLn.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnLn.setBounds(139, 191, 64, 50);
        panelScintific.add(btnLn);
//        frame.getContentPane().add(btnLn);


        //         button 0
        JButton btn0 = new JButton("0");
        btn0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number=textField.getText()+btn0.getText();
                textField.setText(number);
            }
        });
        btn0.setFont(new Font("Tahoma", Font.BOLD, 21));
        btn0.setBounds(74, 449, 129, 50);
        panelScintific.add(btn0);
//        frame.getContentPane().add(btn0);


        //         button SIN
        JButton btnSin = new JButton("sin");
        btnSin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a = Math.sin(Double.parseDouble(textField.getText()));
                textField.setText("");
                textField.setText(textField.getText()+a);

            }
        });
        btnSin.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnSin.setBounds(139, 139, 64, 50);
        panelScintific.add(btnSin);
//        frame.getContentPane().add(btnSin);

        //         button .
        JButton btnDot = new JButton(".");
        btnDot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number=textField.getText()+btnDot.getText();
                textField.setText(number);
            }
        });
        btnDot.setFont(new Font("Tahoma", Font.PLAIN, 21));
        btnDot.setBounds(202, 449, 64, 50);
        panelScintific.add(btnDot);
//        frame.getContentPane().add(btnDot);


        //         button =
        JButton btnEqual = new JButton("=");
        btnEqual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String answer;
                second=Double.parseDouble(textField.getText());
                if(operation=="+")
                {
                    result=first+second;
                    answer=String.format("%.2f", result);
                    textField.setText(answer);
                }
                else if(operation=="-")
                {
                    result=first-second;
                    answer=String.format("%.2f", result);
                    textField.setText(answer);
                }
                else if(operation=="*")
                {
                    result=first*second;
                    answer=String.format("%.2f", result);
                    textField.setText(answer);
                }
                else if(operation=="/")
                {
                    result=first/second;
                    answer=String.format("%.2f", result);
                    textField.setText(answer);
                }
                else if(operation=="%")
                {
                    result=first%second;
                    answer=String.format("%.2f", result);
                    textField.setText(answer);
                }
                else if(operation=="X^Y")
                {
                    double resultt=1;
                    for(int i=0;i<second;i++)
                    {
                        resultt=first*resultt;
                        answer=String.format("%.2f", resultt);
                        textField.setText(answer);
                    }
                }

            }
        });
        btnEqual.setFont(new Font("Tahoma", Font.PLAIN, 21));
        btnEqual.setBounds(266, 449, 64, 50);
        panelScintific.add(btnEqual);
//        frame.getContentPane().add(btnEqual);


    // Button X^Y
        JButton btnXrx = new JButton("X^Y");
        btnXrx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                first=Double.parseDouble(textField.getText());
                textField.setText("");
                operation="X^Y";
            }
        });
        btnXrx.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnXrx.setBounds(10, 243, 64, 50);
        panelScintific.add(btnXrx);
//        frame.getContentPane().add(btnXrx);



        // Button log
        JButton btnLog = new JButton("log");
        btnLog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a = Math.log(Double.parseDouble(textField.getText()));
                textField.setText("");
                textField.setText(textField.getText()+a);
            }
        });
        btnLog.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnLog.setBounds(74, 192, 64, 50);
        panelScintific.add(btnLog);
//        frame.getContentPane().add(btnLog);

        // Button CE
        JButton btnCe = new JButton("CE");
        btnCe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                textField.setText(null);
            }
        });
        btnCe.setFont(new Font("Tahoma", Font.PLAIN, 19));
        btnCe.setBounds(74, 243, 64, 50);
        panelScintific.add(btnCe);
//        frame.getContentPane().add(btnCe);

        // Button 7
        JButton btn7 = new JButton("7");
        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number=textField.getText()+btn7.getText();
                textField.setText(number);
            }
        });
        btn7.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn7.setBounds(74, 295, 64, 50);
        panelScintific.add(btn7);
//        frame.getContentPane().add(btn7);


        // Button 4
        JButton btn4 = new JButton("4");
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number=textField.getText()+btn4.getText();
                textField.setText(number);
            }
        });
        btn4.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn4.setBounds(74, 347, 64, 50);
        panelScintific.add(btn4);
//        frame.getContentPane().add(btn4);

        // Button 1
        JButton btn1 = new JButton("1");
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number=textField.getText()+btn1.getText();
                textField.setText(number);
            }
        });
        btn1.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn1.setBounds(74, 398, 64, 50);
        panelScintific.add(btn1);
//        frame.getContentPane().add(btn1);


        // Button x^3
        JButton btnX = new JButton("x3");
        btnX.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a = (Double.parseDouble(textField.getText()));
                a=a*a*a;
                textField.setText("");
                textField.setText(textField.getText()+a);
            }
        });
        btnX.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnX.setBounds(10, 295, 64, 50);
        panelScintific.add(btnX);
//        frame.getContentPane().add(btnX);


        // Button ex
        JButton btnEx = new JButton("ex");
        btnEx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a = Math.exp(Double.parseDouble(textField.getText()));
                textField.setText("");
                textField.setText(textField.getText()+a);
            }
        });
        btnEx.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnEx.setBounds(74, 139, 64, 50);
        panelScintific.add(btnEx);
//        frame.getContentPane().add(btnEx);


        // Button decimal to binary
        JButton btnBinary = new JButton("bin");
        btnBinary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int a =Integer.parseInt(textField.getText());
                textField.setText("");
                textField.setText(textField.getText()+Integer.toBinaryString(a));
            }
        });
        btnBinary.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnBinary.setBounds(9, 191, 64, 50);
        panelScintific.add(btnBinary);
//        frame.getContentPane().add(btnBinary);



        // Button square root
        JButton btnSqrt = new JButton("\u221A");
        btnSqrt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a = Math.sqrt(Double.parseDouble(textField.getText()));
                textField.setText("");
                textField.setText(textField.getText()+a);
            }
        });
        btnSqrt.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnSqrt.setBounds(10, 139, 64, 50);
        panelScintific.add(btnSqrt);
//        frame.getContentPane().add(btnSqrt);

        // Button cos
        JButton btnCos = new JButton("cos");
        btnCos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a = Math.cos(Double.parseDouble(textField.getText()));
                textField.setText("");
                textField.setText(textField.getText()+a);
            }
        });
        btnCos.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnCos.setBounds(202, 139, 64, 50);
        panelScintific.add(btnCos);
//        frame.getContentPane().add(btnCos);

        // Button cosh
        JButton btnCos_1 = new JButton("cosh");
        btnCos_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a = Math.cosh(Double.parseDouble(textField.getText()));
                textField.setText("");
                textField.setText(textField.getText()+a);
            }
        });
        btnCos_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnCos_1.setBounds(202, 191, 64, 50);
        panelScintific.add(btnCos_1);
//        frame.getContentPane().add(btnCos_1);

        // Button B to clear number by number
        JButton btnBackSpace = new JButton("B");
        btnBackSpace.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String backSpace=null;
                if(textField.getText().length()>0)
                {
                    StringBuilder str=new StringBuilder(textField.getText());
                    str.deleteCharAt(textField.getText().length()-1);
                    backSpace=str.toString();
                    textField.setText(backSpace);
                }
            }
        });
        btnBackSpace.setFont(new Font("Tahoma", Font.PLAIN, 19));
        btnBackSpace.setBounds(202, 243, 64, 50);
        panelScintific.add(btnBackSpace);
//        frame.getContentPane().add(btnBackSpace);


        // Button 9
        JButton btn9 = new JButton("9");
        btn9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number=textField.getText()+btn9.getText();
                textField.setText(number);
            }
        });
        btn9.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn9.setBounds(202, 295, 64, 50);
        panelScintific.add(btn9);
//        frame.getContentPane().add(btn9);


        // Button 6
        JButton btn6 = new JButton("6");
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number=textField.getText()+btn6.getText();
                textField.setText(number);
            }
        });
        btn6.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn6.setBounds(202, 347, 64, 50);
        panelScintific.add(btn6);
//        frame.getContentPane().add(btn6);


        // Button 3
        JButton btn3 = new JButton("3");
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number=textField.getText()+btn3.getText();
                textField.setText(number);
            }
        });
        btn3.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn3.setBounds(202, 398, 64, 50);
        panelScintific.add(btn3);
//        frame.getContentPane().add(btn3);


        // Button tan
        JButton btnTan = new JButton("tan");
        btnTan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a = Math.tan(Double.parseDouble(textField.getText()));
                textField.setText("");
                textField.setText(textField.getText()+a);
            }
        });
        btnTan.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnTan.setBounds(266, 139, 64, 50);
        panelScintific.add(btnTan);
//        frame.getContentPane().add(btnTan);


        // Button tanh
        JButton btnTan_1 = new JButton("tanh");
        btnTan_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a = Math.tanh(Double.parseDouble(textField.getText()));
                textField.setText("");
                textField.setText(textField.getText()+a);
            }
        });
        btnTan_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnTan_1.setBounds(266, 191, 64, 50);
        panelScintific.add(btnTan_1);
//        frame.getContentPane().add(btnTan_1);

        // Button +
        JButton btnPlus = new JButton("+");
        btnPlus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                first=Double.parseDouble(textField.getText());
                textField.setText("");
                operation="+";
            }
        });
        btnPlus.setFont(new Font("Tahoma", Font.PLAIN, 21));
        btnPlus.setBounds(266, 243, 64, 50);
        panelScintific.add(btnPlus);
 //        frame.getContentPane().add(btnPlus);


        // Button -
        JButton btnSub = new JButton("-");
        btnSub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                first=Double.parseDouble(textField.getText());
                textField.setText("");
                operation="-";
            }
        });
        btnSub.setFont(new Font("Tahoma", Font.PLAIN, 21));
        btnSub.setBounds(266, 295, 64, 50);
        panelScintific.add(btnSub);
 //        frame.getContentPane().add(btnSub);


        // Button *
        JButton btnMul = new JButton("*");
        btnMul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                first=Double.parseDouble(textField.getText());
                textField.setText("");
                operation="*";
            }
        });
        btnMul.setFont(new Font("Tahoma", Font.PLAIN, 21));
        btnMul.setBounds(266, 347, 64, 50);
        panelScintific.add(btnMul);
 //        frame.getContentPane().add(btnMul);


        // Button /
        JButton btnDivide = new JButton("/");
        btnDivide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                first=Double.parseDouble(textField.getText());
                textField.setText("");
                operation="/";
            }
        });
        btnDivide.setFont(new Font("Tahoma", Font.PLAIN, 21));
        btnDivide.setBounds(266, 398, 64, 50);
        panelScintific.add(btnDivide);
 //        frame.getContentPane().add(btnDivide);


        // Button x^2
        JButton btnP_1 = new JButton("x2");
        btnP_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a = (Double.parseDouble(textField.getText()));
                a=a*a;
                textField.setText("");
                textField.setText(textField.getText()+a);
            }
        });
        btnP_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnP_1.setBounds(10, 347, 64, 50);
        panelScintific.add(btnP_1);
//        frame.getContentPane().add(btnP_1);


        // Button n!
        JButton btnN = new JButton("n!");
        btnN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a =(Double.parseDouble(textField.getText()));
                double f=1;
                while(a!=0)
                {
                    f=f*a;
                    a--;
                }
                textField.setText("");
                textField.setText(textField.getText()+f);
            }
        });
        btnN.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnN.setBounds(10, 398, 64, 50);
        panelScintific.add(btnN);
//        frame.getContentPane().add(btnN);


        JSeparator separator = new JSeparator();
        separator.setBounds(72, 291, 1, 2);
        frame.getContentPane().add(separator);
//        panelScintific.add(separator);
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(19, 191, 1, 2);
        frame.getContentPane().add(separator_1);
//        panelScintific.add(separator_1);
        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(10, 191, 320, 2);
//        panelScintific.add(separator_2);
        frame.getContentPane().add(separator_2);



        // Button ON
        JRadioButton rdbtnNewRadioButton = new JRadioButton("ON");
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btn1.setEnabled(true);
                btn2.setEnabled(true);
                btn3.setEnabled(true);
                btn4.setEnabled(true);
                btn5.setEnabled(true);
                btn6.setEnabled(true);
                btn7.setEnabled(true);
                btn8.setEnabled(true);
                btn9.setEnabled(true);
            }
        });
        buttonGroup.add(rdbtnNewRadioButton);
        rdbtnNewRadioButton.setBounds(10, 109, 63, 23);
        panelScintific.add(rdbtnNewRadioButton);
//        frame.getContentPane().add(rdbtnNewRadioButton);

        // Button OFF
        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("OFF");
        rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
                btn5.setEnabled(false);
                btn6.setEnabled(false);
                btn7.setEnabled(false);
                btn8.setEnabled(false);
                btn9.setEnabled(false);
            }
        });
        buttonGroup.add(rdbtnNewRadioButton_1);
        rdbtnNewRadioButton_1.setBounds(74, 109, 64, 23);
        panelScintific.add(rdbtnNewRadioButton_1);
//        frame.getContentPane().add(rdbtnNewRadioButton_1);


        // Button binary to dec
        JButton button = new JButton("dec");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String a = textField.getText();
//                double a=Double.parseDouble(String.valueOf(textField.getText()));
//                a=a*(-1);

                textField.setText(String.valueOf(Integer.parseInt(a,2)));

            }
        });
        button.setFont(new Font("Tahoma", Font.PLAIN, 18));
        button.setBounds(10, 449, 64, 50);
        panelScintific.add(button);
 //        frame.getContentPane().add(button);


        JLabel copyRight = new JLabel("© Shiva Kumar 21MCA2200, Inc. All rights reserved.");
        copyRight.setBounds(10, 520, 310, 27);
        copyRight.setFont(new Font("Tahoma", Font.PLAIN, 13));
        panelScintific.add(copyRight);
//         frame.getContentPane().add(copyRight);
    }

    private void scientificCal(){
        panelScintific = new JPanel();
        panelNormal = new JPanel();
        panelLogIn = new JPanel();
        tp = new JTabbedPane();
        tp.setBounds(0,0,357,600);
        tp.add("Normal Calculator", panelNormal);
        tp.add("Scientific Calculator", panelScintific);
//        tp.add("LogIn", panelLogIn);
//        panelLogIn.setLayout(null);

        panelScintific.setLayout(null);

        frame.add(tp);
    }



    /*************** Normal Caclulator r***********************/
    private void normalCalculator(){
        JLabel lbl = new JLabel("NORMAL CALCULATOR");
        lbl.setBounds(10, 11, 310, 23);
        lbl.setFont(new Font("Tahoma", Font.BOLD, 20));
        panelNormal.add(lbl);

        JTextField textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.BOLD, 15));
        textField.setBounds(10, 39, 320, 63);
//        frame.getContentPane().add(textField);
        textField.setColumns(10);
         panelNormal.add(textField);






//         button 2
        JButton btn2 = new JButton("2");
        btn2.addActionListener(arg0 -> {
            String number=textField.getText()+btn2.getText();
            textField.setText(number);
        });

        btn2.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn2.setBounds(75, 398, 64, 50);
//        frame.getContentPane().add(btn2);
         panelNormal.add(btn2);


        //         button 5
        JButton btn5 = new JButton("5");
        btn5.addActionListener(arg0 -> {
            String number=textField.getText()+btn5.getText();
            textField.setText(number);
        });
        btn5.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn5.setBounds(75, 347, 64, 50);
//        frame.getContentPane().add(btn5);
         panelNormal.add(btn5);




        //         button 8
        JButton btn8 = new JButton("8");
        btn8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number=textField.getText()+btn8.getText();
                textField.setText(number);
            }
        });
        btn8.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn8.setBounds(75, 295, 64, 50);
//        frame.getContentPane().add(btn8);
         panelNormal.add(btn8);

        //         button C
        JButton btnC = new JButton("C");
        btnC.setFont(new Font("Tahoma", Font.PLAIN, 19));
        btnC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                textField.setText(null);
            }
        });
        btnC.setBounds(75, 243, 64, 50);
         panelNormal.add(btnC);
//        frame.getContentPane().add(btnC);





        //         button 0
        JButton btn0 = new JButton("0");
        btn0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number=textField.getText()+btn0.getText();
                textField.setText(number);
            }
        });
        btn0.setFont(new Font("Tahoma", Font.BOLD, 21));
        btn0.setBounds(10, 449, 129, 50);
         panelNormal.add(btn0);
//        frame.getContentPane().add(btn0);




        //         button .
        JButton btnDot = new JButton(".");
        btnDot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number=textField.getText()+btnDot.getText();
                textField.setText(number);
            }
        });
        btnDot.setFont(new Font("Tahoma", Font.PLAIN, 21));
        btnDot.setBounds(138, 449, 64, 50);
         panelNormal.add(btnDot);
//        frame.getContentPane().add(btnDot);


        //         button =
        JButton btnEqual = new JButton("=");
        btnEqual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String answer;
                second=Double.parseDouble(textField.getText());
                if(operation=="+")
                {
                    result=first+second;
                    answer=String.format("%.2f", result);
                    textField.setText(answer);
                }
                else if(operation=="-")
                {
                    result=first-second;
                    answer=String.format("%.2f", result);
                    textField.setText(answer);
                }
                else if(operation=="*")
                {
                    result=first*second;
                    answer=String.format("%.2f", result);
                    textField.setText(answer);
                }
                else if(operation=="/")
                {
                    result=first/second;
                    answer=String.format("%.2f", result);
                    textField.setText(answer);
                }
                else if(operation=="%")
                {
                    result=first%second;
                    answer=String.format("%.2f", result);
                    textField.setText(answer);
                }
                else if(operation=="X^Y")
                {
                    double resultt=1;
                    for(int i=0;i<second;i++)
                    {
                        resultt=first*resultt;
                        answer=String.format("%.2f", resultt);
                        textField.setText(answer);
                    }
                }

            }
        });
        btnEqual.setFont(new Font("Tahoma", Font.PLAIN, 21));
        btnEqual.setBounds(266, 449, 64, 50);
         panelNormal.add(btnEqual);
//        frame.getContentPane().add(btnEqual);




        // Button CE
        JButton btnCe = new JButton("CE");
        btnCe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                textField.setText(null);
            }
        });
        btnCe.setFont(new Font("Tahoma", Font.PLAIN, 19));
        btnCe.setBounds(10, 243, 64, 50);
         panelNormal.add(btnCe);
//        frame.getContentPane().add(btnCe);

        // Button 7
        JButton btn7 = new JButton("7");
        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number=textField.getText()+btn7.getText();
                textField.setText(number);
            }
        });
        btn7.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn7.setBounds(10, 295, 64, 50);
         panelNormal.add(btn7);
//        frame.getContentPane().add(btn7);


        // Button 4
        JButton btn4 = new JButton("4");
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number=textField.getText()+btn4.getText();
                textField.setText(number);
            }
        });
        btn4.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn4.setBounds(10, 347, 64, 50);
         panelNormal.add(btn4);
//        frame.getContentPane().add(btn4);

        // Button 1
        JButton btn1 = new JButton("1");
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number=textField.getText()+btn1.getText();
                textField.setText(number);
            }
        });
        btn1.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn1.setBounds(10, 398, 64, 50);
         panelNormal.add(btn1);
//        frame.getContentPane().add(btn1);











        // Button B to clear number by number
        JButton btnBackSpace = new JButton("B");
        btnBackSpace.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String backSpace=null;
                if(textField.getText().length()>0)
                {
                    StringBuilder str=new StringBuilder(textField.getText());
                    str.deleteCharAt(textField.getText().length()-1);
                    backSpace=str.toString();
                    textField.setText(backSpace);
                }
            }
        });
        btnBackSpace.setFont(new Font("Tahoma", Font.PLAIN, 19));
        btnBackSpace.setBounds(138, 243, 64, 50);
         panelNormal.add(btnBackSpace);
//        frame.getContentPane().add(btnBackSpace);


        // Button 9
        JButton btn9 = new JButton("9");
        btn9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number=textField.getText()+btn9.getText();
                textField.setText(number);
            }
        });
        btn9.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn9.setBounds(138, 295, 64, 50);
         panelNormal.add(btn9);
//        frame.getContentPane().add(btn9);


        // Button 6
        JButton btn6 = new JButton("6");
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number=textField.getText()+btn6.getText();
                textField.setText(number);
            }
        });
        btn6.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn6.setBounds(138, 347, 64, 50);
         panelNormal.add(btn6);
//        frame.getContentPane().add(btn6);


        // Button 3
        JButton btn3 = new JButton("3");
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number=textField.getText()+btn3.getText();
                textField.setText(number);
            }
        });
        btn3.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn3.setBounds(138, 398, 64, 50);
         panelNormal.add(btn3);
//        frame.getContentPane().add(btn3);



        // Button +
        JButton btnPlus = new JButton("+");
        btnPlus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                first=Double.parseDouble(textField.getText());
                textField.setText("");
                operation="+";
            }
        });
        btnPlus.setFont(new Font("Tahoma", Font.PLAIN, 21));
        btnPlus.setBounds(266, 243, 64, 50);
         panelNormal.add(btnPlus);
//        frame.getContentPane().add(btnPlus);


        // Button -
        JButton btnSub = new JButton("-");
        btnSub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                first=Double.parseDouble(textField.getText());
                textField.setText("");
                operation="-";
            }
        });
        btnSub.setFont(new Font("Tahoma", Font.PLAIN, 21));
        btnSub.setBounds(266, 295, 64, 50);
         panelNormal.add(btnSub);
//        frame.getContentPane().add(btnSub);


        // Button *
        JButton btnMul = new JButton("*");
        btnMul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                first=Double.parseDouble(textField.getText());
                textField.setText("");
                operation="*";
            }
        });
        btnMul.setFont(new Font("Tahoma", Font.PLAIN, 21));
        btnMul.setBounds(266, 347, 64, 50);
         panelNormal.add(btnMul);
//        frame.getContentPane().add(btnMul);


        // Button /
        JButton btnDivide = new JButton("/");
        btnDivide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                first=Double.parseDouble(textField.getText());
                textField.setText("");
                operation="/";
            }
        });
        btnDivide.setFont(new Font("Tahoma", Font.PLAIN, 21));
        btnDivide.setBounds(266, 398, 64, 50);
         panelNormal.add(btnDivide);
//        frame.getContentPane().add(btnDivide);




//
//        JSeparator separator = new JSeparator();
//        separator.setBounds(72, 291, 1, 2);
////        frame.getContentPane().add(separator);
//        panelScintific.add(separator);
//        JSeparator separator_1 = new JSeparator();
//        separator_1.setBounds(19, 191, 1, 2);
////        frame.getContentPane().add(separator_1);
//        panelScintific.add(separator_1);
//        JSeparator separator_2 = new JSeparator();
//        separator_2.setBounds(10, 191, 320, 2);
//        panelScintific.add(separator_2);
////        frame.getContentPane().add(separator_2);






        JLabel copyRight = new JLabel("© Shiva Kumar 21MCA2200, Inc. All rights reserved.");
        copyRight.setBounds(10, 520, 310, 27);
        copyRight.setFont(new Font("Tahoma", Font.PLAIN, 13));
         panelNormal.add(copyRight);


        panelNormal.setLayout(null);
    }
}