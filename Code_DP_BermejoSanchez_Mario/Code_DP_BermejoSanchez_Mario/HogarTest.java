
/**
 * METODOS DE PRODUCTS PROBADOS EN OCIO
 */

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HogarTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HogarTest
{
    /**
     * Default constructor for test class HogarTest
     */
    public HogarTest()
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
        Hogar product1 = new Hogar(123, "lampara", 12.3,"bedroom");
        Hogar product2 = new Hogar(456, "latas",23.4, "livingroom");

        assertEquals(123, product1.getID());
        assertEquals(0, product1.getCantidadMinima());
        assertEquals("lampara", product1.getName());
        assertEquals("bedroom", product1.getPcasa());
        assertEquals(0, product1.getQuantity());
        assertEquals(0, product1.getCantidadMinima());
        assertEquals((Double)12.3, product1.getPrecio());
        assertEquals(0, product1.getVendido());
        assertEquals(0, product1.getCantidadVendida());

        assertEquals(456, product2.getID());
        assertEquals(0, product2.getCantidadMinima());
        assertEquals("latas", product2.getName());
        assertEquals("livingroom", product2.getPcasa());
        assertEquals(0, product2.getQuantity());
        assertEquals(0, product2.getCantidadMinima());
        assertEquals((Double)23.4, product2.getPrecio());
        assertEquals(0, product2.getVendido());
        assertEquals(0, product2.getCantidadVendida());
    }

    @Test
    public void DarLikePrueba()
    {
        Hogar product1 = new Hogar(123, "lampara", 12.3,"bedroom");
        Hogar product2 = new Hogar(456, "latas",23.4, "livingroom");

        product1.like();

        assertEquals(1, product1.getLikes());
        assertEquals(0, product2.getLikes());
    }

    @Test
    public void DarUnLikePrueba()
    {
        Hogar product1 = new Hogar(123, "lampara", 12.3,"bedroom");
        Hogar product2 = new Hogar(456, "latas",23.4, "livingroom");
        product1.like();
        product1.unlike();

        assertEquals(0, product1.getLikes());
        assertEquals(0, product2.getLikes());
    }

    @Test
    public void GetPcasaPrueba()
    {
        Hogar product1 = new Hogar(123, "lampara", 12.3,"bedroom");
        Hogar product2 = new Hogar(456, "latas",23.4, "livingroom");
        assertEquals("bedroom", product1.getPcasa());
        assertEquals("livingroom", product2.getPcasa());
    }

    @Test
    public void CompPcasaPrueba()
    {
        Hogar product1 = new Hogar(123, "lampara", 12.3,"bedroom");
        Hogar product2 = new Hogar(456, "latas",23.4, "livingroom");
        assertEquals(true, product1.comprobarParteCasa("bedroom"));
        assertEquals(true, product1.comprobarParteCasa("livingroom"));
    }

    @Test
    public void ToStringPrueba(){
        Hogar product1 = new Hogar(123, "lampara", 12.3,"bedroom");
        Hogar product2 = new Hogar(456, "latas",23.4, "livingroom");
        product1.toString();
        product2.toString();
    }

    @Test
    public void ComentariosTotalPrueba(){
        Hogar product1 = new Hogar(123, "lampara", 12.3,"bedroom");
        Hogar product2 = new Hogar(456, "latas",23.4, "livingroom");
        assertEquals(0, product1.comentariosTotales());
        assertEquals(0, product2.comentariosTotales());

    }

    @Test
    public void RealizarCommentPrueba(){
        Hogar product1 = new Hogar(123, "lampara", 12.3,"bedroom");
        Hogar product2 = new Hogar(456, "latas",23.4, "livingroom");
        Comment comentario = new Comment(2,"pepe", "muy malo");
        product1.realizarComentario(comentario);
        product1.realizarComentario(comentario);
        assertEquals(1, product1.comentariosTotales());
        assertEquals(0, product2.comentariosTotales());

    }

    @Test
    public void GetLikePrueba()
    {
        Hogar product1 = new Hogar(123, "lampara", 12.3,"bedroom");
        Hogar product2 = new Hogar(456, "latas",23.4, "livingroom");
        assertEquals(0, product1.getLikes());
        assertEquals(0, product2.getLikes());
    }

}
