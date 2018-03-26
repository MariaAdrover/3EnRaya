/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3enraya;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author miaad
 */
public class TaulellTest {
    
    public TaulellTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAddMoviment() {
        System.out.println("addMoviment");
        Taulell instance = null;
        instance.addMoviment();
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarMovimiento() {
        System.out.println("validarMovimiento");
        Moviment moviment = null;
        Taulell instance = null;
        boolean expResult = false;
        boolean result = instance.validarMoviment(moviment);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testComprovarGuanyador() {
        System.out.println("comprovarGuanyador");
        Taulell instance = null;
        Jugador expResult = null;
        Jugador result = instance.comprovarGuanyador();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testComprovarPle() {
        System.out.println("comprovarPle");
        Taulell instance = null;
        boolean expResult = false;
        boolean result = instance.comprovarPle();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCasillaLibre() {
        System.out.println("getCasillaLibre");
        Taulell instance = null;
        int[][] expResult = null;
        int[][] result = instance.getCasillaLibre();
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarCasillaBuida() {
        System.out.println("validarCasillaBuida");
        Moviment moviment = null;
        Taulell instance = null;
        boolean expResult = false;
        boolean result = instance.validarCasillaBuida(moviment);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testMostrarTaulell() {
        System.out.println("mostrarTaulell");
        Taulell instance = null;
        instance.mostrarTaulell();
        fail("The test case is a prototype.");
    }
    
}
