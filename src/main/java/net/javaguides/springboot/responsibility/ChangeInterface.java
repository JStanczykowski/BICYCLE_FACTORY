package net.javaguides.springboot.responsibility;

import net.javaguides.springboot.model.Bike;
import net.javaguides.springboot.model.current;

public interface ChangeInterface {
    String euroPLN(current cur, Bike bike);
    String usdPLN(current cur, Bike bike);
    String cadPLN(current cur, Bike bike);
    String chfPLN(current cur, Bike bike);

}
