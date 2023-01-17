package net.javaguides.springboot.responsibility;

import net.javaguides.springboot.model.Bike;
import net.javaguides.springboot.model.current;

public interface ChangeInterface {
    String euroPLN(current cur, Bike bike);
    String PLNeuro();
    void euroUSD();
    void USDeuro();
    void PLNusd();
    void usdPLN();
}
