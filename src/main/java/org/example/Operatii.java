package org.example;

import java.util.Map;

public abstract interface Operatii{
    /*public default Polinom add(Polinom b) {
        Polinom c = new Polinom();
        for (int rank : this.polinom.keySet()) {
            if (b.notEmpty(rank) == true) {
                Monom aux = new Monom(rank, b.getMonom(rank).coef + a.getMonom(rank).coef);
                c.putMonom(aux);
                b.getMonom(rank).coef = 0;
            } else {
                if(a.getMonom(rank).coef != 0) {
                    Monom aux = new Monom(rank, a.getMonom(rank).coef);
                    c.putMonom(aux);
                }
            }
            //a.getMonom(rank).coef = 0;
        }
        for(int rank: b.polinom.keySet()){
            if(b.getMonom(rank).coef != 0) {
                Monom aux = new Monom(rank, b.getMonom(rank).coef);
                c.putMonom(aux);
            }
            //b.getMonom(rank).coef = 0;
        }
        //a.polinom.clear();
        //b.polinom.clear();
        return c;
    }*/
}

