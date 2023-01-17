package net.javaguides.springboot.responsibility;

import net.javaguides.springboot.model.Bike;
import net.javaguides.springboot.model.current;

public class ChangeCAD extends Change{

    public ChangeCAD(){

    }

    @Override
    public String cadPLN(current cur, Bike bike){
        double resul =bike.getPrice() / cur.getCurre();
        resul*=100;
        resul=Math.round(resul);
        resul/=100;
        return String.valueOf(resul);
    }
}
