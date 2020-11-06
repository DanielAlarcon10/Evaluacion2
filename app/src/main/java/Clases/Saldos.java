package Clases;

public class Saldos {

    private int saldoAxel;
    private int saldoRoxana;
    private int valorHipotecario;
    private int valorAutomotriz;
    private int deudaHipotecario;
    private int deudaAutomotriz;

    public Saldos()
    {
        saldoAxel = 750000;
        saldoRoxana = 900000;
        valorHipotecario = 1000000;
        valorAutomotriz = 500000;
        deudaHipotecario = 12;
        deudaAutomotriz = 8;
    }

    public int getSaldoAxel() {
        return saldoAxel;
    }

    public void setSaldoAxel(int saldoAxel) {
        this.saldoAxel = saldoAxel;
    }

    public int getSaldoRoxana() {
        return saldoRoxana;
    }

    public void setSaldoRoxana(int saldoRoxana) {
        this.saldoRoxana = saldoRoxana;
    }

    public int getValorHipotecario() {
        return valorHipotecario;
    }

    public void setValorHipotecario(int valorHipotecario) {
        this.valorHipotecario = valorHipotecario;
    }

    public int getValorAutomotriz() {
        return valorAutomotriz;
    }

    public void setValorAutomotriz(int valorAutomotriz) {
        this.valorAutomotriz = valorAutomotriz;
    }

    public int getDeudaHipotecario() {
        return deudaHipotecario;
    }

    public void setDeudaHipotecario(int deudaHipotecario) {
        this.deudaHipotecario = deudaHipotecario;
    }

    public int getDeudaAutomotriz() {
        return deudaAutomotriz;
    }

    public void setDeudaAutomotriz(int deudaAutomotriz) {
        this.deudaAutomotriz = deudaAutomotriz;
    }
}
