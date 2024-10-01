package com.mycompany.picoplaca;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author ENRIQUE
 */
public class PicoPlaca {

    public static void main(String[] args) throws ParseException {
        //Variables
        String numeroPlaca;    //Número de la placa del vehículo
        String fecha;          //Fecha en la que se debe buscar siel vehículo tiene pico y placa
        String hora;           //hora para verificar pico y placa

        //Hora exacta 
        Scanner informacion = new Scanner(System.in);
        System.out.println("Ingrese número de placa");
        numeroPlaca = informacion.nextLine();
        System.out.println("Ingrese hora");
        hora = informacion.nextLine();
        System.out.println("Ingrese fecha en formato dd-mm-aaaa");
        fecha = informacion.nextLine();
        //vericia que el rango de la hora es el correcto
        if (hora.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")) {
            Predictor predictor = new Predictor(numeroPlaca, fecha, hora);
            predictor.verificarPicoPlaca();
        } else {
            System.out.print("Rango de la hora debe ser 00:00-23:59 ");
        }

    }
}
