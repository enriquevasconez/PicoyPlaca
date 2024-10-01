package com.mycompany.picoplaca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas automaticas
 * 
 * @author ENRIQUE
 */
public class PredictorTest {
    
    public PredictorTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    

    /**
     * Prueba para fericiar si tiene pico y placa el día martes 01-10-2024
     */
    @org.junit.jupiter.api.Test
    public void test1_VerificarPicoPlaca() throws Exception {
       System.out.println("Verificar si tiene pico y placa");
        String numeroPlaca = "AAA-1234";
        String fecha = "01-10-2024";
        String hora = "7:30";
        Predictor instance = new Predictor(numeroPlaca, fecha, hora);
        Boolean resultadoObtenido = instance.verificarPicoPlaca();
        assertTrue(resultadoObtenido);
    }

    /**
     * Prueba para verificar si no tiene pico y placa el día martes 01-10-2024
     */
    @org.junit.jupiter.api.Test
    public void test2_verificarNoPicoPlaca() throws Exception {
       System.out.println("Verificar si no tiene pico y placa");
        String numeroPlaca = "AAA-1234";
        String fecha = "01-10-2024";
        String hora = "12:00";
        Predictor instance = new Predictor(numeroPlaca, fecha, hora);
        Boolean resultadoObtenido = instance.verificarPicoPlaca();
        assertFalse(resultadoObtenido);
    }
    
    /**
     * Prueba para verificar que una paca que termine en 3 no tenga pico y plava el día miércoles 02-10-2024
     */
    @org.junit.jupiter.api.Test
    public void test3_verificarPicoPlacaNumeroPlaca() throws Exception {
       System.out.println("Verificar si no tiene pico y placa en un día que no le corresponde");
        String numeroPlaca = "AAA-1234";
        String fecha = "02-10-2024";
        String hora = "7:30";
        Predictor instance = new Predictor(numeroPlaca, fecha, hora);
        Boolean resultadoObtenido = instance.verificarPicoPlaca();
        assertFalse(resultadoObtenido);
    }
    
    /**
     * Prueba para verificar qun formato de fecha incorrecto
     */
    @org.junit.jupiter.api.Test
    public void test4_verificarFormatoFechaIncorrecto() throws Exception {
       System.out.println("Verificar formato fecha");
        String numeroPlaca = "AAA-1234";
        String fecha = "2024-02-02";
        String hora = "7:30";
        Predictor instance = new Predictor(numeroPlaca, fecha, hora);
        Boolean resultadoObtenido = instance.verificarPicoPlaca();
        assertFalse(resultadoObtenido);
    }
    
    /**
     * Prueba para verificar que el código de la placa sea inccorecto
     */
    @org.junit.jupiter.api.Test
    public void test5_verificarCodigoPlacaIncorrecto() throws Exception {
       System.out.println("Verificar código de placa incorrecto");
        String numeroPlaca = "DAA-1234";
        String fecha = "01-10-2024";
        String hora = "7:30";
        Predictor instance = new Predictor(numeroPlaca, fecha, hora);
        Boolean resultadoObtenido = instance.verificarPicoPlaca();
        assertFalse(resultadoObtenido);
    }
    
    /**
     * Prueba para verificar que no existe pico y placa el fin de semana
     */
    @org.junit.jupiter.api.Test
    public void test6_verificarFinSemana() throws Exception {
       System.out.println("Verificar que no exista pico y placa fin de semana");
        String numeroPlaca = "BAC-1230";
        String fecha = "05-10-2024";
        String hora = "7:30";
        Predictor instance = new Predictor(numeroPlaca, fecha, hora);
        Boolean resultadoObtenido = instance.verificarPicoPlaca();
        assertFalse(resultadoObtenido);
    }
}
