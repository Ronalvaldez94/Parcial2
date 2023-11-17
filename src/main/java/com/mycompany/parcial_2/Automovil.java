
package com.mycompany.parcial_2;

public class Automovil extends Vehiculo {

    private int numeroPuertas;

    // Constructores, getters y setters

    public Automovil(int numeroPuertas, String marca, String modelo, String placa, int horaIngreso) {
        super(marca, modelo, placa, horaIngreso);
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }
 
}
