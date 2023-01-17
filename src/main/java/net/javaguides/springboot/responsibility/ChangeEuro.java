package net.javaguides.springboot.responsibility;

import net.javaguides.springboot.model.Bike;
import net.javaguides.springboot.model.current;

public class ChangeEuro extends Change{
    public String euroPLN;

    public ChangeEuro(){

    }

    @Override
    public String euroPLN(current cur,Bike bike){
        double resul =bike.getPrice() / cur.getCurre();
        resul*=100;
        resul=Math.round(resul);
        resul/=100;
       return String.valueOf(resul);
   }

}
