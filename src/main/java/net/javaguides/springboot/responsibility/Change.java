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
    public String PLNeuro(){
        String wynik="0";
        return wynik;
    }
    public void euroUSD(){
        double wynik=0;
        this.bike.setPrice(wynik);
    }
    public void USDeuro(){
        double wynik=0;
        this.bike.setPrice(wynik);
    }
    public void PLNusd(){
        double wynik=0;
        this.bike.setPrice(wynik);
    }
    public void usdPLN(){
        double wynik=0;
        this.bike.setPrice(wynik);
    }

}
