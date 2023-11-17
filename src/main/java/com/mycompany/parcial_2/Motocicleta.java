package com.mycompany.parcial_2;

public class Motocicleta extends Vehiculo {

    private int cilindrada;


    // Constructores, getters y setters

    public Motocicleta(int cilindrada, String marca, String modelo, String placa, int horaIngreso) {
        super(marca, modelo, placa, horaIngreso);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

}
