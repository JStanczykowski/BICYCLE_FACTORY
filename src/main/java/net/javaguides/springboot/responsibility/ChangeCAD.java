package net.javaguides.springboot.responsibility;

import net.javaguides.springboot.model.current;

public class ChangeCAD implements ChangeInterface{

    public ChangeCAD(){

    }

    @Override
    public String change(current cur, double price){
        double resul =price / cur.getCurre();
        resul*=100;
        resul=Math.round(resul);
        resul/=100;
        return String.valueOf(resul);
    }
}
