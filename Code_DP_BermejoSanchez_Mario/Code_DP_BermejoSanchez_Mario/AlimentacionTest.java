
/**
 * METODOS DE PRODUCTS PROBADOS EN OCIO
 */

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AlimentacionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AlimentacionTest
{
    /**
     * Default constructor for test class AlimentacionTest
     */
    public AlimentacionTest()
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
        Alimentacion product1 = new Alimentacion(123, "bebida", 12.3,"December");
        Alimentacion product2 = new Alimentacion(456, "latas",23.4, "November");

        assertEquals(123, product1.getID());
        assertEquals(0, product1.getCantidadMinima());
        assertEquals("bebida", product1.getName());
        assertEquals("December", product1.getMesCaducidad());
        assertEquals(0, product1.getQuantity());
        assertEquals(0, product1.getCantidadMinima());
        assertEquals((Double)12.3, product1.getPrecio());
        assertEquals(0, product1.getVendido());
        assertEquals(0, product1.getCantidadVendida());

        assertEquals(456, product2.getID());
        assertEquals(0, product2.getCantidadMinima());
        assertEquals("latas", product2.getName());
        assertEquals("November", product2.getMesCaducidad());
        assertEquals(0, product2.getQuantity());
        assertEquals(0, product2.getCantidadMinima());
        assertEquals((Double)23.4, product2.getPrecio());
        assertEquals(0, product2.getVendido());
        assertEquals(0, product2.getCantidadVendida());
    }

        @Test
    public void DarLikePrueba()
    {
         Alimentacion product1 = new Alimentacion(123, "bebida", 12.3,"December");
        Alimentacion product2 = new Alimentacion(456, "latas",23.4, "November");

        product1.like();

        assertEquals(1, product1.getLikes());
        assertEquals(0, product2.getLikes());
    }

    @Test
    public void DarUnLikePrueba()
    {
        Alimentacion product1 = new Alimentacion(123, "bebida", 12.3,"December");
        Alimentacion product2 = new Alimentacion(456, "latas",23.4, "November");
       product1.like();
        product1.unlike();

        assertEquals(0, product1.getLikes());
        assertEquals(0, product2.getLikes());
    }

        @Test
    public void GetLikePrueba()
    {
        Alimentacion product1 = new Alimentacion(123, "bebida", 12.3,"December");
        Alimentacion product2 = new Alimentacion(456, "latas",23.4, "November");
        assertEquals(0, product1.getLikes());
        assertEquals(0, product2.getLikes());
    }

        @Test
    public void ComentariosTotalPrueba(){
        Alimentacion product1 = new Alimentacion(123, "bebida", 12.3,"December");
        Alimentacion product2 = new Alimentacion(456, "latas",23.4, "November");
        assertEquals(0, product1.comentariosTotales());
        assertEquals(0, product2.comentariosTotales());

    }

    @Test
    public void RealizarCommentPrueba(){
        Alimentacion product1 = new Alimentacion(123, "bebida", 12.3,"December");
        Alimentacion product2 = new Alimentacion(456, "latas",23.4, "November");
       Comment comentario = new Comment(2,"pepe", "muy malo");
        product1.realizarComentario(comentario);
        product2.realizarComentario(comentario);
        assertEquals(0, product1.comentariosTotales());
        assertEquals(0, product2.comentariosTotales());

 
}
    @Test
    public void GetMesCaducidadPrueba(){
        Alimentacion product1 = new Alimentacion(123, "bebida", 12.3,"December");
        Alimentacion product2 = new Alimentacion(456, "latas",23.4, "November");
       

        assertEquals("December", product1.getMesCaducidad());
        assertEquals("November", product2.getMesCaducidad());

 
}

    @Test
    public void CompMesCaducidadPrueba(){
        Alimentacion product1 = new Alimentacion(123, "bebida", 12.3,"December");
        Alimentacion product2 = new Alimentacion(456, "latas",23.4, "November");
       

        assertEquals(true, product1.comprobarMes("December"));
        assertEquals(true, product2.comprobarMes("November"));

 
}

    @Test
    public void ToStringPrueba(){
        Alimentacion product1 = new Alimentacion(123, "bebida", 12.3,"December");
        Alimentacion product2 = new Alimentacion(456, "latas",23.4, "November");

        product1.toString();
        product2.toString();
    }
}