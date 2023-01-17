package net.javaguides.springboot.responsibility;

import net.javaguides.springboot.model.Bike;
import net.javaguides.springboot.model.current;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import java.text.DecimalFormat;

public abstract class Change implements ChangeInterface {
    Bike bike;


    public Change() {

    }
    public String euroPLN(current cur, Bike bike){
        String wynik="0";
        return wynik;
    }
    public String usdPLN(current cur, Bike bike){
        String wynik="0";
        return wynik;
    }
    public String chfPLN(current cur, Bike bike){
        String wynik="0";
        return wynik;
    }
    public String cadPLN(current cur, Bike bike){
        String wynik="0";
        return wynik;
    }

}
