package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame{

    Controller controller = new Controller(this);
    JTextField polinomUnu;
    JTextField polinomDoi;
    JTextField polinomRezultat;

    JLabel labRez;
    JLabel labFirstPoli;
    JLabel labSecondPoli;
    JLabel labOp;

    //JLabel labPolinomRezultat;


    JButton Submit;

    JPanel panelPoli;
    JPanel pannelUnu;
    JPanel pannelDoi;
    JPanel pannelTrei;
    JPanel pannelPolUnu;
    JPanel pannelPolDoi;
    JPanel pannelOperatii;
    JPanel pannelPolRez;

    JRadioButton Add;
    JRadioButton Substract;
    JRadioButton Multiply;
    JRadioButton Derivative;
    JRadioButton Integral;
    JRadioButton Divide;
    public View() {

        this.panelPoli();
        this.panelUnu();
        //this.panelDoi();
        this.panelTrei();
        this.panelPolUnu();
        this.panelPolDoi();
        this.panelPolOp();
        this.panelRez();
        this.putPanels();
    }
        //JFrame frame = new JFrame();
        public void panelPoli () {
            panelPoli = new JPanel();
            polinomUnu = new JTextField();
            polinomDoi = new JTextField();
            panelPoli.setBounds(100, 20, 400, 100);
            panelPoli.setVisible(true);
            panelPoli.setBackground(Color.PINK);
            polinomUnu.setPreferredSize(new Dimension(300, 40));
            polinomDoi.setPreferredSize(new Dimension(300, 40));
            panelPoli.add(polinomUnu);
            panelPoli.add(polinomDoi);
            //this.add(panelPoli);
        }
        public void panelUnu(){
            pannelUnu = new JPanel();
            pannelUnu.setBounds(100, 120, 400, 70);
            pannelUnu.setBackground(Color.BLUE);
            pannelUnu.setVisible(true);
            pannelUnu.setLayout(new FlowLayout());
            Add = new JRadioButton("Add");
            Add.addActionListener(this.controller);
            Substract = new JRadioButton("Substract");
            Substract.addActionListener(this.controller);
            Multiply = new JRadioButton("Multiply");
            Multiply.addActionListener(this.controller);
            Divide = new JRadioButton("Divide");
            Divide.addActionListener(this.controller);
            Integral = new JRadioButton("Integral");
            Integral .addActionListener(this.controller);
            Derivative = new JRadioButton("Derivative");
            Derivative.addActionListener(this.controller);

            ButtonGroup operatiiAles = new ButtonGroup();

            operatiiAles.add(Add);
            operatiiAles.add(Substract);
            operatiiAles.add(Multiply);
            operatiiAles.add(Divide);
            operatiiAles.add(Integral);
            operatiiAles.add(Derivative);


            pannelUnu.add(Add);
            pannelUnu.add(Substract);
            pannelUnu.add(Multiply);
            pannelUnu.add(Divide);
            pannelUnu.add(Derivative);
            pannelUnu.add(Integral);

           // this.add(pannelUnu);
        }
        /*public void panelDoi(){
            pannelDoi = new JPanel();
            pannelDoi.setBounds(400, 20, 80, 160);
            pannelDoi.setBackground(Color.gray);
            pannelDoi.setVisible(true);
            pannelDoi.setLayout(new FlowLayout());
            Submit = new JButton();
            Submit.setPreferredSize(new Dimension(80, 50));
            //Submit.addActionListener(this);
            Submit.setText("Submit");
            this.Submit.setActionCommand("SUBMIT");
            this.Submit.addActionListener(this.controller);
            pannelDoi.add(Submit);
           // this.add(pannelDoi);
        }*/
        public void panelTrei(){
            pannelTrei = new JPanel();
            pannelTrei.setBounds(100, 190, 400, 70);
            pannelTrei.setBackground(Color.lightGray);
            pannelTrei.setVisible(true);
            pannelTrei.setLayout(new FlowLayout());
            //labPolinomRezultat = new JLabel();
            //labPolinomRezultat.setPreferredSize(new Dimension(400, 70));

            //pannelTrei.add(labPolinomRezultat);
            polinomRezultat = new JTextField("The result");
            polinomRezultat.setPreferredSize(new Dimension(300, 40));
            polinomRezultat.setBorder(BorderFactory.createLineBorder(Color.black));
            pannelTrei.add(polinomRezultat);

           // this.add(pannelTrei);
        }
        public void panelPolUnu(){
            pannelPolUnu = new JPanel();
            labFirstPoli = new JLabel();
            labFirstPoli.setText("Polynom1:");
            labFirstPoli.setPreferredSize(new Dimension(80, 50));
            labFirstPoli.setFont(new Font("", Font.PLAIN, 15));
            pannelPolUnu.setBounds(10, 20, 90, 50);
            pannelPolUnu.setBackground(Color.ORANGE);
            pannelPolUnu.add(labFirstPoli);
           // this.add(pannelPolUnu);
        }
        public void panelPolDoi(){
            pannelPolDoi = new JPanel();
            labSecondPoli = new JLabel();
            labSecondPoli.setText("Polynom 2:");
            labSecondPoli.setPreferredSize(new Dimension(80, 50));
            labSecondPoli.setFont(new Font("", Font.PLAIN, 15));
            pannelPolDoi.setBounds(10, 70, 90, 50);
            pannelPolDoi.setBackground(Color.RED);
            pannelPolDoi.add(labSecondPoli);
           // this.add(pannelPolDoi);
        }
        public void panelPolOp(){
            pannelOperatii = new JPanel();
            labOp = new JLabel();
            pannelOperatii.setBounds(10, 120, 90, 70);
            pannelOperatii.setBackground(Color.magenta);
            labOp.setText("Operations");
            labOp.setPreferredSize(new Dimension(80, 70));
            labOp.setFont(new Font("", Font.PLAIN, 15));
            pannelOperatii.add(labOp);
           // this.add(pannelOperatii);
        }
        public void panelRez(){
            pannelPolRez = new JPanel();
            labRez = new JLabel();
            labRez.setText("Answear");
            labRez.setPreferredSize(new Dimension(80, 70));
            labRez.setFont(new Font("", Font.PLAIN, 15));
            pannelPolRez.setBounds(10, 190, 90, 70);
            pannelPolRez.setBackground(Color.GREEN);
            pannelPolRez.add(labRez);
           // this.add(pannelPolRez);
        }
        public void putPanels(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(500, 500);
            this.setVisible(true);
            this.setLayout(null);
            this.add(panelPoli);
            this.add(pannelUnu);
            //this.add(pannelDoi);
            this.add(pannelTrei);
            this.add(pannelPolUnu);
            this.add(pannelPolDoi);
            this.add(pannelPolRez);
            this.add(pannelOperatii);
        }

   /* @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Submit){
            System.out.println("Merge");
        }
    }*/
    }

