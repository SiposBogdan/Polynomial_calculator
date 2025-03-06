package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller implements ActionListener {
    private View view;
    private Polinom primul = new Polinom();
    private Polinom alDoilea = new Polinom();

    public Controller(View view) {
        this.view = view;
    }

    public Polinom makeThePolinoms(String first){
        Polinom intermediar = new Polinom();
       // String second = String.valueOf(view.polinomDoi.getText());
        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(first);
        int x=0;
        while (matcher.find()) {
            x=x+1;
            //System.out.println("Group "+x+": " + matcher.group(1));
            Monom aux = new Monom();
           // System.out.println(matcher.group(1));
            aux = aux.schimbaDinString(matcher.group(1));
            intermediar.putMonom(aux);
        }
        return intermediar;
    }
    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource() == view.Add) {
            primul.setPolinom(makeThePolinoms(String.valueOf(view.polinomUnu.getText())));
            alDoilea.setPolinom(makeThePolinoms(String.valueOf(view.polinomDoi.getText())));
            Polinom rezultat = primul.add(alDoilea);
            System.out.println(rezultat.afisareString());
            view.polinomRezultat.setText(rezultat.afisareString());
        }
        if(e.getSource() == view.Substract) {
            primul.setPolinom(makeThePolinoms(String.valueOf(view.polinomUnu.getText())));
            alDoilea.setPolinom(makeThePolinoms(String.valueOf(view.polinomDoi.getText())));
            Polinom rezultat = primul.substract(alDoilea);
            System.out.println(rezultat.afisareString());
            view.polinomRezultat.setText(rezultat.afisareString());
        }
        if(e.getSource()==view.Derivative){
            primul.setPolinom(makeThePolinoms(String.valueOf(view.polinomUnu.getText())));
            Polinom rezultat = primul.derivative();
            System.out.println(rezultat.afisareString());
            view.polinomRezultat.setText(rezultat.afisareString());
        }
        if(e.getSource()==view.Integral){
            primul.setPolinom(makeThePolinoms(String.valueOf(view.polinomUnu.getText())));
            Polinom rezultat = primul.integral();
            System.out.println(rezultat.afisareString());
            view.polinomRezultat.setText(rezultat.afisareString());
        }
        if(e.getSource()==view.Multiply){
            primul.setPolinom(makeThePolinoms(String.valueOf(view.polinomUnu.getText())));
            alDoilea.setPolinom(makeThePolinoms(String.valueOf(view.polinomDoi.getText())));
            Polinom rezultat = primul.multiply(alDoilea);
            System.out.println(rezultat.afisareString());
            view.polinomRezultat.setText(rezultat.afisareString());
        }
        if(e.getSource()==view.Divide){
            primul.setPolinom(makeThePolinoms(String.valueOf(view.polinomUnu.getText())));
            alDoilea.setPolinom(makeThePolinoms(String.valueOf(view.polinomDoi.getText())));
            String rezultat = primul.divide(alDoilea);
           // view.labPolinomRezultat.setText(rezultat);
            view.polinomRezultat.setText(rezultat);

        }


    }
}

