package com.mycompany.picoplaca;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;

/**
 *
 * @author ENRIQUE
 */
public class Predictor {

    //Variables
    private String numeroPlaca;    //Número de la placa del vehículo
    private String fecha;          //Fecha en la que se debe buscar siel vehículo tiene pico y placa
    private String horaMinuto;          //Hora exacta 
    private char[] codigosProvincias = new char[]{'A', 'B', 'C', 'E', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'}; //Códigos usados para identificar la provincia

    /**
     * Método constructor
     *
     * @param numeroPlaca
     * @param fecha
     * @param hora
     */
    public Predictor(String numeroPlaca, String fecha, String hora) {
        super();
        this.numeroPlaca = numeroPlaca;
        this.fecha = fecha;
        this.horaMinuto = hora;
    }

    /**
     * Métido para verificar si el vehículo tiene pico y placa
     *
     * @throws ParseException
     */
    public void verificarPicoPlaca() throws ParseException {
        if (validar()) {
            Calendar calendario = Calendar.getInstance();
            DateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
            calendario.setTime(formatoFecha.parse(fecha));
            int diaSemana = calendario.get(Calendar.DAY_OF_WEEK);
            String ultimoNumeroPlaca = numeroPlaca.substring(numeroPlaca.length() - 1);
            String[] separarHora = horaMinuto.split(":");
            int hora = Integer.parseInt(separarHora[0]);
            int minutos = Integer.parseInt(separarHora[1]);
            switch (diaSemana) {

                case 2: {
                    if (ultimoNumeroPlaca.equals("1") || ultimoNumeroPlaca.equals("2")) {
                        verificarHora(hora, minutos);
                    } else {
                        System.out.println("Su vehículo puede circular");
                    }
                    break;
                }
                case 3: {
                    if (ultimoNumeroPlaca.equals("3") || ultimoNumeroPlaca.equals("4")) {
                        verificarHora(hora, minutos);
                    } else {
                        System.out.println("Su vehículo puede circular");
                    }
                    break;
                }
                case 4: {
                    if (ultimoNumeroPlaca.equals("5") || ultimoNumeroPlaca.equals("6")) {
                        verificarHora(hora, minutos);
                    } else {
                        System.out.println("Su vehículo puede circular");
                    }
                    break;
                }
                case 5: {
                    if (ultimoNumeroPlaca.equals("7") || ultimoNumeroPlaca.equals("8")) {
                        verificarHora(hora, minutos);
                    } else {
                        System.out.println("Su vehículo puede circular");
                    }
                    break;
                }
                case 6: {
                    if (ultimoNumeroPlaca.equals("9") || ultimoNumeroPlaca.equals("0")) {
                        verificarHora(hora, minutos);
                    } else {
                        System.out.println("Su vehículo puede circular");
                    }
                    break;
                }

                default: {
                    System.out.println("Este día no hay pico y placa");
                }
            }
        }
    }

    /**
     * Método para verificar si la hora ingresa está en el rango de pico y placa
     *
     * @param hora
     * @param minutos
     */
    public void verificarHora(int hora, int minutos) {
        if (hora >= 6 && hora <= 9 || hora >= 16 && hora < 20) {
            if ((hora == 9 || hora == 20) && minutos <= 30) {
                System.out.println("Su vehículo no puede circular");
            } else {
                if (hora >= 6 && hora <= 8 || hora >= 16 && hora <= 20) {
                    if (minutos >= 00) {
                        System.out.println("Su vehículo no puede circular");
                    }
                } else {
                    System.out.println("Su vehículo  puede circular");
                }
            }
        } else {
            System.out.println("Su vehículo  puede circular");
        }
    }

    /**
     * Método para validar errores
     *
     * @return
     * @throws ParseException
     */
    public Boolean validar() throws ParseException {
        boolean validar = Boolean.TRUE;
        DateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        String fechaFormato = formatoFecha.format(formatoFecha.parse(fecha));

        //Valida que la fecha esté en formato dd-mm-yyyy
        if (!fechaFormato.equals(fecha)) {
            System.out.println("Formato de la fecha debe ser dd-mm-yyyy");
            validar = Boolean.FALSE;
        }

        //Verifica que el número de placa esté en formato AAA-1234
        if (!numeroPlaca.matches("^[A-Z0-9]{3} ?\\- ?[A-Z0-9]{4}")) {
            System.out.println("Formato de placa incorrecto");
            validar = Boolean.FALSE;
        }

        //Verifica si la primera letra de la mátricula corresponde a un código aceptado 
        if (new String(codigosProvincias).indexOf(numeroPlaca.charAt(0)) == -1) {
            System.out.println("El código de la placa" + " " + numeroPlaca.charAt(0) + " " + "no corresponde a los códigos permitidos");
            validar = Boolean.FALSE;
        }
        return validar;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return horaMinuto;
    }

    public void setHora(String hora) {
        this.horaMinuto = hora;
    }

}
