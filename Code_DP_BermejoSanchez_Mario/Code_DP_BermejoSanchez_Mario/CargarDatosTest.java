

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CargarDatosTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CargarDatosTest
{
    private Cliente_Estandar cliente_1;
    private Cliente_Vip cliente_2;
    private Ocio ocio1;
    private Hogar hogar1;
    private StockManager stockMan1;

    /**
     * Default constructor for test class CargarDatosTest
     */
    public CargarDatosTest()
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
        cliente_1 = new Cliente_Estandar("hola", 1, 12, "CC");
        cliente_2 = new Cliente_Vip("hola2", 12, 12, "CC");
        ocio1 = new Ocio(1, "asdsad", 123.0);
        hogar1 = new Hogar(124, "as", 12.0, "bedroom");
        stockMan1 = StockManager.getInstance();
        stockMan1.addCliente(cliente_1);
        stockMan1.addCliente(cliente_2);
        stockMan1.addProduct(ocio1);
        stockMan1.addProduct(hogar1);
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
}
