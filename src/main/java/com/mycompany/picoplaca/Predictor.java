package com.mycompany.picoplaca;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;

/**
 * Clase para verificiar si el vehículo tiene pico y placa
 * @author ENRIQUE
 */
public class Predictor {

    //Variables
    private String numeroPlaca;    //Número de la placa del vehículo
    private String fecha;          //Fecha en la que se debe buscar siel vehículo tiene pico y placa
    private String horaMinuto;          //Hora exacta 
    private char[] codigosProvincias = new char[]{'A', 'B', 'C', 'E', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'}; //Códigos usados para identificar la provincia
    private String respuestaTienePicoyPlaca = ""; //Variable para almacenar si hay pico y placa
    private String respuestaNoTienePicoyPlaca = ""; //Variable para almacenar si no  hay pico y placa

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
    public Boolean verificarPicoPlaca() throws ParseException {
        Boolean tienePicoPlaca = Boolean.FALSE;
        if (validar()) {
            Calendar calendario = Calendar.getInstance();
            DateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
            calendario.setTime(formatoFecha.parse(fecha));
            int diaSemana = calendario.get(Calendar.DAY_OF_WEEK);
            String ultimoNumeroPlaca = numeroPlaca.substring(numeroPlaca.length() - 1);
            String[] separarHora = horaMinuto.split(":");
            int hora = Integer.parseInt(separarHora[0]);
            int minutos = Integer.parseInt(separarHora[1]);
            respuestaTienePicoyPlaca = "Su vehículo no puede circular";
            respuestaNoTienePicoyPlaca = "Su vehículo  puede circular";

            switch (diaSemana) {

                case 2: {
                    if (ultimoNumeroPlaca.equals("1") || ultimoNumeroPlaca.equals("2")) {
                        if (verificarHora(hora, minutos)) {
                            System.out.println(respuestaTienePicoyPlaca);
                            tienePicoPlaca = Boolean.TRUE;
                        } else {
                            System.out.println(respuestaNoTienePicoyPlaca);
                        };
                    } else {
                        System.out.println(respuestaNoTienePicoyPlaca);
                    }
                    break;
                }
                case 3: {
                    if (ultimoNumeroPlaca.equals("3") || ultimoNumeroPlaca.equals("4")) {
                        if (verificarHora(hora, minutos)) {
                            System.out.println(respuestaTienePicoyPlaca);
                            tienePicoPlaca = Boolean.TRUE;
                        } else {
                            System.out.println(respuestaNoTienePicoyPlaca);
                        };
                    } else {
                        System.out.println(respuestaNoTienePicoyPlaca);
                    }
                    break;
                }
                case 4: {
                    if (ultimoNumeroPlaca.equals("5") || ultimoNumeroPlaca.equals("6")) {
                        if (verificarHora(hora, minutos)) {
                            System.out.println(respuestaTienePicoyPlaca);
                            tienePicoPlaca = Boolean.TRUE;
                        } else {
                            System.out.println(respuestaNoTienePicoyPlaca);
                        };
                    } else {
                        System.out.println(respuestaNoTienePicoyPlaca);
                    }
                    break;
                }
                case 5: {
                    if (ultimoNumeroPlaca.equals("7") || ultimoNumeroPlaca.equals("8")) {
                        if (verificarHora(hora, minutos)) {
                            System.out.println(respuestaTienePicoyPlaca);
                            tienePicoPlaca = Boolean.TRUE;
                        } else {
                            System.out.println(respuestaNoTienePicoyPlaca);
                        };
                    } else {
                        System.out.println(respuestaNoTienePicoyPlaca);
                    }
                    break;
                }
                case 6: {
                    if (ultimoNumeroPlaca.equals("9") || ultimoNumeroPlaca.equals("0")) {
                        if (verificarHora(hora, minutos)) {
                            System.out.println(respuestaTienePicoyPlaca);
                            tienePicoPlaca = Boolean.TRUE;
                        } else {
                            System.out.println(respuestaNoTienePicoyPlaca);
                        };
                    } else {
                        System.out.println(respuestaNoTienePicoyPlaca);
                    }
                    break;
                }
                default: {
                    System.out.println("Este día no hay pico y placa");
                }
            }
        }
        return tienePicoPlaca;
    }

    /**
     * Método para verificar si la hora ingresa está en el rango de pico y placa
     *
     * @param hora
     * @param minutos
     * @return 
     */
    public Boolean verificarHora(int hora, int minutos) {
        Boolean picoPlaca = Boolean.FALSE;
        if (hora >= 6 && hora <= 9 || hora >= 16 && hora < 20) {
            if ((hora == 9 || hora == 20) && minutos <= 30) {
                picoPlaca = Boolean.TRUE;
            } else {
                if (hora >= 6 && hora <= 8 || hora >= 16 && hora <= 20) {
                    if (minutos >= 00) {
                        picoPlaca = Boolean.TRUE;
                    }
                } else {
                    picoPlaca = Boolean.FALSE;
                }
            }
        } else {
            picoPlaca = Boolean.FALSE;
        }
        return picoPlaca;
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
