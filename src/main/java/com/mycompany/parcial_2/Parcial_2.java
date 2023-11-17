package com.mycompany.parcial_2;

import static spark.Spark.*;
import com.google.gson.Gson;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        /*
    * Esto nos sirve para generar un formato json para retornar la data del array
    * sin tener que acomodarla bonita de manera manual
         */
        Gson gson = new Gson();

        LinkedList<Automovil> automoviles = new LinkedList<>();
        LinkedList<Motocicleta> motos = new LinkedList<>();
        LinkedList<Vehiculo> AutomovilesActuales = new LinkedList<>();

        // Automovil creado por defecto
        Automovil auto = new Automovil(4, "Mazda", "3", "ZYX987", 6);
        automoviles.add(auto);
        AutomovilesActuales.add(auto);

        Motocicleta moto = new Motocicleta(600, "Honda", "CBR600", "XYZ789", 6);
        motos.add(moto);
        AutomovilesActuales.add(moto);

        // Definir endpoints
        // Por defecto 
        get("/motos", (req, res) -> {
            res.type("application/json");
            return gson.toJson(motos);
        });

        // Listado de automovile
        get("/automoviles", (req, res) -> {
            res.type("application/json");
            return gson.toJson(automoviles);
        });

        // Guardar automovil
        // endpoint GET para agregar un automóvil
        get("/agregarAutomovil/:marca/:modelo/:placa/:numeroPuertas/:horaIngreso", (req, res) -> {

            // Añadimos esto para retornar en formato Json
            res.type("application/json");

            // Obtener parámetros de la URL
            String marca = req.params(":marca");
            String modelo = req.params(":modelo");
            String placa = req.params(":placa");

            // No olvidar convertir en integer los string numericos que llegan por url
            int numeroPuertas = Integer.parseInt(req.params(":numeroPuertas"));
            int horaIngreso = Integer.parseInt(req.params(":horaIngreso"));

            // Crear un nuevo automóvil y agregarlo al parqueadero
            Automovil nuevoAuto = new Automovil(numeroPuertas, marca, modelo, placa, horaIngreso);
            automoviles.add(nuevoAuto);
            AutomovilesActuales.add(nuevoAuto);

            return gson.toJson(nuevoAuto);
        });
        get("/agregarMoto/:marca/:modelo/:placa/:cilindrada/:horaIngreso", (req, res) -> {

            // Añadimos esto para retornar en formato Json
            res.type("application/json");

            // Obtener parámetros de la URL
            String marca = req.params(":marca");
            String modelo = req.params(":modelo");
            String placa = req.params(":placa");

            // No olvidar convertir en integer los string numericos que llegan por url
            int cilindrada = Integer.parseInt(req.params(":cilindrada"));
            int horaIngreso = Integer.parseInt(req.params(":horaIngreso"));

            // Crear un nuevo automóvil y agregarlo al parqueadero
            Motocicleta nuevaMoto = new Motocicleta(cilindrada, marca, modelo, placa, horaIngreso);
            motos.add(nuevaMoto);
            AutomovilesActuales.add(nuevaMoto);

            return gson.toJson(nuevaMoto);
        });

        get("/sacarAutomovil/:placa/:horaSalida", (req, res) -> {
            String placa = (req.params(":placa"));
            int horaSalida = Integer.parseInt(req.params(":horaSalida"));
            res.type("application/json");
            String mensaje = "0";
            for (Vehiculo vehiculo : automoviles) {
                if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                    vehiculo.setHoraSalida(horaSalida);
                    AutomovilesActuales.remove(vehiculo);
                    mensaje = "Vehiculo sacado con exito";
                    break;
                } else {
                    mensaje = "No se encontro vehiculo";
                }
            }
            return gson.toJson(mensaje);
        });
        get("/sacarMoto/:placa/:horaSalida", (req, res) -> {
            String placa = (req.params(":placa"));
            int horaSalida = Integer.parseInt(req.params(":horaSalida"));
            res.type("application/json");
            String mensaje = "0";
            for (Vehiculo vehiculo : motos) {
                if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                    vehiculo.setHoraSalida(horaSalida);
                    AutomovilesActuales.remove(vehiculo);
                    mensaje = "Vehiculo sacado con exito";
                    break;
                } else {
                    mensaje = "No se encontro vehiculo";
                }
            }
            return gson.toJson(mensaje);
        });
        // Listado de automovile
        get("/AutomovilesActuales", (req, res) -> {
            res.type("application/json");
            return gson.toJson(AutomovilesActuales);
        });

    }
}
