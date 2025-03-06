package org.example;

import org.apache.commons.lang3.StringUtils;

import java.util.StringTokenizer;


public class Monom {
    private double coef;
    private int rank;

    public Monom(int rank, double coef) {
        this.coef = coef;
        this.rank = rank;
    }

    public Monom() {
        this.coef = 0;
        this.rank = 0;
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public int getRank() {
        return rank;
    }

    public void setMonom(int rank, int coef){
        this.rank = rank;
        this.coef = coef;
    }
    public static int verificaString(String sir){
       // System.out.println(sir.substring(0,1));
        if(sir.equals("x"))
            return 5;
        String aux = sir.substring(1);
        if((StringUtils.isNumeric(aux)==true && StringUtils.isNumeric(sir)!=true) || StringUtils.isNumeric(sir) == true)
            return 2;
        if(sir.substring(sir.length() - 1).equals("x") && (sir.substring(0,2).equals("+x")))
            return 5;
        if(sir.substring(sir.length() - 1).equals("x") && (sir.substring(0,2).equals("-x")))
            return 6;
        if(sir.substring(0,2) .equals("-x"))
            return 3;
        if(sir.substring(0,2).equals(("+x")) || sir.substring(0,1).equals("x"))
            return 4;
        if(sir.substring(sir.length() - 1).equals("x"))
            return 1;
        return 0;
    }
    public Monom schimbaDinString(String sir){
        StringTokenizer raspuns = new StringTokenizer(sir,"x^");
        String coef = new String();
        String putere = new String();
        int ctrl = verificaString(sir);
        if(ctrl == 0) {
            coef = raspuns.nextToken();
            putere = raspuns.nextToken();}
        if(ctrl == 1) {
            putere = "1";
            coef = raspuns.nextToken();}
        if(ctrl == 2) {
            putere = "0";
            coef = raspuns.nextToken();}
        if(ctrl == 3) {
            coef = "-1";
            raspuns.nextToken();
            putere = raspuns.nextToken();}
        if(ctrl == 4) {
           if(sir.substring(0,1).equals("x")!=true)
                raspuns.nextToken();
            coef = "+1";
            putere = raspuns.nextToken();}
        if(ctrl == 5){
            coef = "+1";
            putere = "+1";}
        if(ctrl == 6){
            coef = "-1";
            putere = "1";}
        return new Monom(Integer.parseInt(putere),Double.parseDouble(coef));}

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String afisareString(){
        String t = new String();
        if(this.coef == 0) {
            t = "";
            return t;
        }
        if (this.coef >= 0)
            t = "+";
        if(this.rank == 1) {
            t = t + this.coef + "x";
            return t;
        }
        if(this.rank == 0) {
            t = t + this.coef;
            return t;
        }

        t = t+this.coef+"x^"+this.rank;

        return t;
    }

    @Override
    public String toString() {
        return "" + this.coef + "x^" + this.rank;
    }
}
