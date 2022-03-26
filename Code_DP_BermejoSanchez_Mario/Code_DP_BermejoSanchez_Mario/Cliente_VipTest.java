
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Cliente_VipTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Cliente_VipTest
{
    /**
     * Default constructor for test class Cliente_VipTest
     */
    public Cliente_VipTest()
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
    public void CrearClientePrueba()
    {
        Cliente_Vip client1 = new  Cliente_Vip("Pepe", 1234, 20, "Caceres" );
        Cliente_Vip client2 = new  Cliente_Vip("Juan", 4567, 78, "Barcelona");
        Cliente_Vip client3 = new  Cliente_Vip("Luisa", 13254562, 56, "Sevilla");
        assertEquals("Pepe", client1.getNombre());
        assertEquals("Caceres", client1.getLocalidad());
        assertEquals(1234, client1.getIdCliente());
        assertEquals(20, client1.getEdad());
        assertEquals("Juan", client2.getNombre());
        assertEquals("Barcelona", client2.getLocalidad());
        assertEquals(4567, client2.getIdCliente());
        assertEquals(78, client2.getEdad());
        assertEquals("Luisa", client3.getNombre());
        assertEquals("Sevilla", client3.getLocalidad());
        assertEquals(13254562, client3.getIdCliente());
        assertEquals(56, client3.getEdad());
    }

        @Test
    public void PrepararPedidoPrueba()
    {
        StockManager stockMan1 = StockManager.getInstance();
        assertEquals(stockMan1, stockMan1);
        
        Cliente_Vip cliente_1 = new Cliente_Vip("pepe", 12, 14, "CC");
        Product ocio1 = new Ocio(45, "gafitas", 123.0);
        Product hogar1 = new Hogar(46, "lampara", 120.0, "bedroom");
        Product alimenta1 = new Alimentacion(47, "patatas", 50.0, "December");
        stockMan1.addProduct(ocio1);
        stockMan1.addProduct(hogar1);
        stockMan1.addProduct(alimenta1);
        stockMan1.addCliente(cliente_1);
        cliente_1.AñadirProdFav(45, "gafitas");
        cliente_1.AñadirProdFav(46, "lampara");
        cliente_1.AñadirProdFav(47, "patatas");
        cliente_1.PrepararPedido();
        Product pro1 = cliente_1.ProductosVenta.get(0);
        Product pro2 = cliente_1.ProductosVenta.get(1);
        Product pro3 = cliente_1.ProductosVenta.get(2);
        
        assertEquals(45, pro3.getID());
        assertEquals("gafitas", pro3.getName());
        assertEquals((Double)123.0, pro3.getPrecio());
        
        assertEquals(46, pro1.getID());
        assertEquals("lampara", pro1.getName());
        assertEquals((Double)120.0, pro1.getPrecio());
        Hogar productHogar = (Hogar)pro1;
        assertEquals("bedroom", productHogar.getPcasa());

        assertEquals(47, pro2.getID());
        assertEquals("patatas", pro2.getName());
        assertEquals((Double)50.0, pro2.getPrecio());
          Alimentacion productAlimentacion = (Alimentacion)pro2;
        assertEquals("December", productAlimentacion.getMesCaducidad());

    }

      @Test
    public void ObtenerPrecioPedidoPrueba()
    {
        StockManager stockMan1 = StockManager.getInstance();
        assertEquals(stockMan1, stockMan1);
        Cliente_Vip cliente_1 = new Cliente_Vip("pepe", 12, 14, "CC");
        Ocio ocio1 = new Ocio(55, "gafitas", 123.0);
        Hogar hogar1 = new Hogar(56, "lampara", 120.0, "bedroom");
        Alimentacion alimenta1 = new Alimentacion(57, "patatas", 50.0, "December");
        
        stockMan1.addProduct(ocio1);
        stockMan1.addProduct(hogar1);
        stockMan1.addProduct(alimenta1);
        stockMan1.addCliente(cliente_1);
        cliente_1.AñadirProdFav(45, "gafitas");
        cliente_1.AñadirProdFav(46, "lampara");
        cliente_1.AñadirProdFav(47, "patatas");
        cliente_1.PrepararPedido();
        Product pro1 = cliente_1.ProductosVenta.get(0);
        Product pro2 = cliente_1.ProductosVenta.get(1);
        Product pro3 = cliente_1.ProductosVenta.get(2);
        
        assertEquals(45, pro3.getID());
        assertEquals("gafitas", pro3.getName());
        assertEquals((Double)123.0, pro3.getPrecio());
        
        assertEquals(46, pro1.getID());
        assertEquals("lampara", pro1.getName());
        assertEquals((Double)120.0, pro1.getPrecio());
        Hogar productHogar = (Hogar)pro1;
        assertEquals("bedroom", productHogar.getPcasa());

        assertEquals(47, pro2.getID());
        assertEquals("patatas", pro2.getName());
        assertEquals((Double)50.0, pro2.getPrecio());
          Alimentacion productAlimentacion = (Alimentacion)pro2;
        assertEquals("December", productAlimentacion.getMesCaducidad());


        Double precio = (pro2.getPrecio()) + (pro1.getPrecio()) + (pro3.getPrecio());
        //assertEquals(precio, cliente_1.ObtenerPrecioPedido());

    }

    
           @Test
    public void RealizarPedidoPrueba()
    {            
        StockManager stockMan1 = StockManager.getInstance();
        assertEquals(stockMan1, stockMan1);
        Cliente_Vip cliente_1 = new Cliente_Vip("pepe", 12, 14, "CC");
        Ocio ocio1 = new Ocio(55, "gafitas", 123.0);
        Hogar hogar1 = new Hogar(56, "lampara", 120.0, "bedroom");
        Alimentacion alimenta1 = new Alimentacion(57, "patatas", 50.0, "December");
        stockMan1.addProduct(ocio1);
        stockMan1.addProduct(hogar1);
        stockMan1.addProduct(alimenta1);
        stockMan1.addCliente(cliente_1);
        cliente_1.AñadirProdFav(55, "gafitas");
        cliente_1.AñadirProdFav(56, "lampara");
        cliente_1.AñadirProdFav(57, "patatas");
        cliente_1.PrepararPedido();
        Product pro1 = cliente_1.ProductosVenta.get(0);
        Product pro2 = cliente_1.ProductosVenta.get(1);
        Product pro3 = cliente_1.ProductosVenta.get(2);
        
        stockMan1.delivery(46, 150);
        stockMan1.delivery(47, 150);
        //cliente_1.realizarPedido();

                assertEquals(0, pro1.getCantidadVendida());
        assertEquals(149, pro2.getCantidadVendida());
        assertEquals(149, pro2.getCantidadVendida());

    }

    @Test
            public void RealizarComentarioPrueba()
    {
        StockManager stockMan1 = StockManager.getInstance();
        assertEquals(stockMan1, stockMan1);
        Cliente_Vip cliente_1 = new Cliente_Vip("pepe", 12, 14, "CC");
        Ocio ocio1 = new Ocio(45, "gafitas", 123.0);
        Hogar hogar1 = new Hogar(46, "lampara", 120.0, "bedroom");
        Alimentacion alimenta1 = new Alimentacion(47, "patatas", 50.0, "December");
        stockMan1.addProduct(ocio1);
        stockMan1.addProduct(hogar1);
        stockMan1.addProduct(alimenta1);
        stockMan1.addCliente(cliente_1);
        cliente_1.AñadirProdFav(45, "gafitas");
        cliente_1.AñadirProdFav(46, "lampara");
        cliente_1.AñadirProdFav(47, "patatas");
        cliente_1.RealizarComentarioCliente(ocio1);
        cliente_1.RealizarComentarioCliente(hogar1);
        cliente_1.RealizarComentarioCliente(alimenta1);
        /*
        cliente_1.RealizarComentarioCliente("gafitas"); //de este si se realiza comentario
        cliente_1.RealizarComentarioCliente("lampara");//de este si se realiza comentario
        cliente_1.RealizarComentarioCliente("patatas");// de este no se realiza comentario
        */
    }
}
