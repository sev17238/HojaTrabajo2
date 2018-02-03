
package calculadora;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase para puebas unitarias de la clase Calculos.
 * @author Guillermo Sandoval 17577
 * @author Diego Sevilla 17238
 */
public class CalculosTest {
    
    public CalculosTest() {
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

    /**
     * Test of Operar method, of class Calculos.
     */
    @Test
    public void testOperar() {
        System.out.println("2.0");
        String linea = "2 2 + 2 / ";
        Calculos instance = new Calculos();
        double expResult = 2.0;
        double result = instance.Operar(linea);
        assertEquals(expResult, result, 0.0);        
    }
    
    /**
     * Test of suma method, of class Calculos.
     */
    @Test
    public void testsuma() {
        System.out.println("4.0");
        double num1 = 2;
        double num2 = 3;
        Calculos instance = new Calculos();
        double expResult = 5.0;
        double result = instance.suma(num1,num2);
        assertEquals(expResult, result, 0.0); 
    }
    
    /**
     * Test of producto method, of class Calculos.
     */
    @Test
    public void testproducto() {
        System.out.println("16.0");
        double num1 = 4;
        double num2 = 4;
        Calculos instance = new Calculos();
        double expResult = 16.0;
        double result = instance.producto(num1,num2);
        assertEquals(expResult, result, 0.0);        
    }    
}
