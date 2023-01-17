package net.javaguides.springboot.model;

public class current {
    double curre =4.7;
    double usd=4.33;
    double CAD =3.26;

    public current() {
    }
    public current(double curre) {
    this.curre=curre;
    }


    public double getCurre() {
        return curre;
    }

    public void setCurre(double curre) {
        this.curre = curre;
    }

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public double getCAD() {
        return CAD;
    }

    public void setCAD(double CAD) {
        this.CAD = CAD;
    }

    public current(double euro, double usd, double canada) {
        this.curre = euro;
        this.usd = usd;
        this.CAD = canada;
    }

}
