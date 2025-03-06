package org.example;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Polinom implements Operatii{
    private Map<Integer, Monom> polinom;

    public Polinom() {
       polinom = new HashMap<>();
    }

    public Polinom(Map<Integer, Monom> polinom) {
        this.polinom = polinom;
    }

    public Map<Integer, Monom> getPolinom() {
        return polinom;
    }

    public void setPolinom(Polinom x) {
        this.polinom = x.polinom;
    }
    //Aici avem functiile pentru monoamele din polinoame
    public void putMonom(Monom x){
        this.polinom.put(x.getRank(), x);
    }
    public Monom getMonom(int rank){
        return this.polinom.get(rank);
    }
    public boolean notEmpty(int rank){
        return this.polinom.containsKey(rank);
    }
    public int getRank(){
        int x = 0;
        for (int rank: this.polinom.keySet()){
            //System.out.println(rank);
            if(this.getMonom(rank).getCoef()!=0)
                x = rank;
        }
        return x;
    }
    public void afiseaza() {
        for(int rank: this.polinom.keySet()){
            System.out.print(this.getMonom(rank)+"+");
        }
        System.out.println("");
    }

    public String afisareString(){
        String sir = new String();
        for (int rank: this.polinom.keySet()){
            sir = polinom.get(rank).afisareString() + sir;
        }
        //System.out.println(sir);
        if(sir.equals(""))
            sir = "0";
        return sir;
    }

    public Polinom copiazaPolinom(){
        Polinom c = new Polinom();
        for(int rank: this.polinom.keySet()){
            c.putMonom(this.getMonom(rank));
        }
        return c;
    }
    public Polinom add(Polinom b) {
        Polinom c = new Polinom();
        for (int rank : this.polinom.keySet()) {
            if (b.notEmpty(rank) == true) {
                Monom aux = new Monom(rank, b.getMonom(rank).getCoef() + this.getMonom(rank).getCoef());
                c.putMonom(aux);
                b.getMonom(rank).setCoef(0);
            } else {
                if(this.getMonom(rank).getCoef() != 0) {
                    Monom aux = new Monom(rank, this.getMonom(rank).getCoef());
                    c.putMonom(aux);
                }
            }
            //a.getMonom(rank).coef = 0;
        }
        for(int rank: b.polinom.keySet()){
            if(b.getMonom(rank).getCoef() != 0) {
                Monom aux = new Monom(rank, b.getMonom(rank).getCoef());
                c.putMonom(aux);
            }
            //b.getMonom(rank).coef = 0;
            }
        this.polinom.clear();
        b.polinom.clear();
        return c;
    }

    public Polinom substract(Polinom b) {
        Polinom c = new Polinom();
        for (int rank : this.polinom.keySet()) {
            if (b.notEmpty(rank) == true) {
                Monom aux = new Monom(rank, this.getMonom(rank).getCoef() - b.getMonom(rank).getCoef());
                c.putMonom(aux);
                b.getMonom(rank).setCoef(0);
            } else {
                if(this.getMonom(rank).getCoef() != 0) {
                    Monom aux = new Monom(rank, this.getMonom(rank).getCoef());
                    c.putMonom(aux);
                }
            }
            //a.getMonom(rank).coef = 0;
        }
        for(int rank: b.polinom.keySet()){
            if(b.getMonom(rank).getCoef() != 0) {
                Monom aux = new Monom(rank, -1*b.getMonom(rank).getCoef());
                c.putMonom(aux);
            }
            //b.getMonom(rank).coef = 0;
        }
        this.polinom.clear();
        b.polinom.clear();
        return c;
    }
    public Polinom derivative(){
        Polinom c =new Polinom();
        for(int rank: this.polinom.keySet()){
            if(rank != 0) {
                Monom aux = new Monom(rank - 1, rank*this.getMonom(rank).getCoef());
                c.putMonom(aux);
            }
        }
        this.polinom.clear();
        return c;
    }
    public Polinom integral(){
        Polinom c =new Polinom();
        for(int rank: this.polinom.keySet()){
                Monom aux = new Monom(rank + 1, this.getMonom(rank).getCoef()/(rank + 1));
                c.putMonom(aux);
        }
        this.polinom.clear();
        return c;
    }
    public Polinom multiply(Polinom b){
        Polinom f =new Polinom();
        Polinom c = new Polinom();
        for(int rank: this.polinom.keySet()){
            for(int rank1: b.polinom.keySet()) {
                Monom aux = new Monom(this.getMonom(rank).getRank() + b.getMonom(rank1).getRank(), this.getMonom(rank).getCoef() * b.getMonom(rank1).getCoef());
                f.putMonom(aux);
                //System.out.println(aux);
            }
            //System.out.println(f.afisareString());
            c = c.add(f);
        }
        //c.afiseaza();
        b.polinom.clear();
        this.polinom.clear();
        return c;
    }

    public Polinom multiplyFaraClear(Polinom b){
        Polinom f =new Polinom();
        Polinom c = new Polinom();
        for(int rank: this.polinom.keySet()){
            for(int rank1: b.polinom.keySet()) {
                Monom aux = new Monom(this.getMonom(rank).getRank() + b.getMonom(rank1).getRank(), this.getMonom(rank).getCoef() * b.getMonom(rank1).getCoef());
                f.putMonom(aux);
                //System.out.println(aux);

            }
            //System.out.println(f.afisareString());
            c = c.add(f);
        }
        c.afiseaza();
        //b.polinom.clear();
        //this.polinom.clear();
        return c;
    }
    public static String calculePentruDivide(Polinom a, Polinom b){
        Polinom c = new Polinom();
        String result;
        if(a.getRank() == 0){
            for (int rank: b.polinom.keySet()){
                b.getMonom(rank).setCoef(b.getMonom(rank).getCoef() / a.getMonom(0).getCoef());
            }
            c.setPolinom(b);
            return c.afisareString();
        }
        while (b.getRank() >= a.getRank()) {
            //System.out.println(b.getRank() + " " + a.getRank());
            Monom aux = new Monom(b.getMonom(b.getRank()).getRank() - a.getMonom(a.getRank()).getRank(), b.getMonom(b.getRank()).getCoef() / a.getMonom(a.getRank()).getCoef());
            c.putMonom(aux);
            //System.out.println(aux.afisareString());
            Polinom dinMonom = new Polinom();
            dinMonom.putMonom(aux);
            //System.out.println(dinMonom.multiplyFaraClear(a).afisareString());
            b.setPolinom(b.substract(dinMonom.multiplyFaraClear(a)));
            dinMonom.polinom.clear();
            //b.afiseaza();
            //a.afiseaza();
        }
        if(b.afisareString().equals("0")!=true)
            result = c.afisareString()+"+("+b.afisareString() +")/" +"("+ a.afisareString()+")";
        else result = c.afisareString();
        return result;
    }
    public String divide(Polinom b){
        Polinom c = new Polinom();
        String result = new String();
        if(b.getRank() <= this.getRank()){
            result = calculePentruDivide(b,this);
        }
        else {
            result = calculePentruDivide(this,b);

        }
        return result;
    }



}
