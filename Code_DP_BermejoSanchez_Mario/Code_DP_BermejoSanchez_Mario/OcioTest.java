

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class OcioTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class OcioTest
{
    /**
     * Default constructor for test class OcioTest
     */
    public OcioTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
        @Test
    public void CrearProdPrueba()
    {
        Ocio product1 = new Ocio(123, "gafas", 12.3);
        Ocio product2 = new Ocio(456, "latas",23.4);
        Ocio product3 = new Ocio(789, "teclado", 34.5);
        assertEquals(123, product1.getID());
        assertEquals(0, product1.getCantidadMinima());
        assertEquals("gafas", product1.getName());
        assertEquals(0, product1.getQuantity());
        assertEquals(0, product2.getCantidadMinima());
        assertEquals(456, product2.getID());
        assertEquals("latas", product2.getName());
        assertEquals(0, product2.getQuantity());
        assertEquals(0, product3.getCantidadMinima());
        assertEquals(789, product3.getID());
        assertEquals("teclado", product3.getName());
        assertEquals(0, product3.getQuantity());
            assertEquals((Double)12.3, product1.getPrecio());
        assertEquals((Double)23.4, product2.getPrecio());
        assertEquals((Double)34.5, product3.getPrecio());
                assertEquals(0, product1.getVendido());
        assertEquals(0, product2.getVendido());
        assertEquals(0, product3.getVendido());
                assertEquals(0, product1.getCantidadVendida());
        assertEquals(0, product2.getCantidadVendida());
        assertEquals(0, product3.getCantidadVendida());
    }
    
    @Test
    public void GetIDPrueba(){
        Ocio product1 = new Ocio(123, "gafas", 12.3);
        Ocio product2 = new Ocio(456, "latas", 12.3);
       Ocio product3 = new Ocio(789, "teclado", 12.3);
        assertEquals(123, product1.getID());
        assertEquals(456, product2.getID());
        assertEquals(789, product3.getID());
    }
    
    @Test
    public void GetNombrePrueba(){
        Ocio product1 = new Ocio(123, "gafas", 12.3);
        Ocio product2 = new Ocio(456, "latas",23.4);
        Ocio product3 = new Ocio(789, "teclado", 34.5);
        assertEquals("gafas", product1.getName());
        assertEquals("latas", product2.getName());
        assertEquals("teclado", product3.getName());
    }
    
    @Test
    public void GetQuantityPrueba(){
        Ocio product1 = new Ocio(123, "gafas", 12.3);
        Ocio product2 = new Ocio(456, "latas",23.4);
        Ocio product3 = new Ocio(789, "teclado", 34.5);
         assertEquals(0, product1.getQuantity());
        assertEquals(0, product2.getQuantity());
        assertEquals(0, product3.getQuantity());
    }
    
    @Test
    public void GetCantMinPrueba(){
        Ocio product1 = new Ocio(123, "gafas", 12.3);
        Ocio product2 = new Ocio(456, "latas",23.4);
        Ocio product3 = new Ocio(789, "teclado", 34.5);
        assertEquals(0, product1.getCantidadMinima());
        assertEquals(0, product2.getCantidadMinima());
        assertEquals(0, product3.getCantidadMinima());
    }
    
    @Test
    public void ToStringPrueba(){
        Ocio product1 = new Ocio(123, "gafas", 12.3);
        Ocio product2 = new Ocio(456, "latas",23.4);
        Ocio product3 = new Ocio(789, "teclado", 34.5);
        product1.toString();
        product2.toString();
        product3.toString();
    }
    
    @Test
    public void SetCantMinPrueba(){
        Ocio product1 = new Ocio(123, "gafas", 12.3);
        Ocio product2 = new Ocio(456, "latas",23.4);

        product1.setCantidadMinima(2);
        product2.setCantidadMinima(-1);
        assertEquals(2, product1.getCantidadMinima());
        assertEquals(0, product2.getCantidadMinima());
    }
    
    @Test
    public void IncreasePrueba(){
        Ocio product1 = new Ocio(123, "gafas", 12.3);
        Ocio product2 = new Ocio(456, "latas",23.4);
        
        product1.increaseQuantity(2);
        product2.increaseQuantity(-6);
        assertEquals(2, product1.getQuantity());
        assertEquals(0, product2.getQuantity());
    }
    
    @Test
    public void SellONEPrueba(){
        Ocio product1 = new Ocio(123, "gafas", 12.3);
        Ocio product2 = new Ocio(456, "latas",23.4);
        
        product1.increaseQuantity(2);
        product2.increaseQuantity(0);
        product1.sellOne();
        product2.sellOne();
        assertEquals(1, product1.getQuantity());
        assertEquals(0, product2.getQuantity());
    }
    
    @Test
    public void VenderProdsPrueba(){
        Ocio product1 = new Ocio(123, "gafas", 12.3);
        Ocio product2 = new Ocio(456, "latas",23.4);
        
        product1.increaseQuantity(8);
        product2.increaseQuantity(0);
        product1.venderProductos(4);
        product2.venderProductos(4);
        assertEquals(4, product1.getQuantity());
        assertEquals(0, product2.getQuantity());
    }
    
    @Test
    public void PruebaGetPrecio(){
        Ocio product1 = new Ocio(123, "gafas", 12.3);
        Ocio product2 = new Ocio(456, "latas",23.4);
        Ocio product3 = new Ocio(789, "teclado", 34.5);
        assertEquals((Double)12.3, product1.getPrecio());
        assertEquals((Double)23.4, product2.getPrecio());
        assertEquals((Double)34.5, product3.getPrecio());
    }
    
        @Test
    public void GetCantVendPrueba(){
        Ocio product1 = new Ocio(123, "gafas", 12.3);
        Ocio product2 = new Ocio(456, "latas",23.4);
        Ocio product3 = new Ocio(789, "teclado", 34.5);
        assertEquals(0, product1.getCantidadVendida());
        assertEquals(0, product2.getCantidadVendida());
        assertEquals(0, product3.getCantidadVendida());
    }
    
            @Test
    public void GetVendPrueba(){
        Ocio product1 = new Ocio(123, "gafas", 12.3);
        Ocio product2 = new Ocio(456, "latas",23.4);
        Ocio product3 = new Ocio(789, "teclado", 34.5);
        assertEquals(0, product1.getVendido());
        assertEquals(0, product2.getVendido());
        assertEquals(0, product3.getVendido());
    }
}
