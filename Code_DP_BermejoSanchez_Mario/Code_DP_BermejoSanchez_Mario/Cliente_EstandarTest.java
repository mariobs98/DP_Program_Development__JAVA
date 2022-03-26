import java.io.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Cliente_EstandarTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Cliente_EstandarTest
{       
    FileWriter writer = null;
    /**
     * Default constructor for test class Cliente_EstandarTest
     */
    public Cliente_EstandarTest()
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
                try{writer = new FileWriter("registropruebas.log.txt");
            }catch(Exception e){
            } 
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
        Cliente_Estandar client1 = new  Cliente_Estandar("Pepe", 1234, 20, "Caceres" );
        Cliente_Estandar client2 = new  Cliente_Estandar("Juan", 4567, 78, "Barcelona");
        Cliente_Estandar client3 = new  Cliente_Estandar("Luisa", 13254562, 56, "Sevilla");
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
    public void GetNombreClientePrueba()
    {

        Cliente_Estandar client1 = new  Cliente_Estandar("Pepe", 1234, 20, "Caceres");
        Cliente_Estandar client2 = new  Cliente_Estandar("Juan", 4567, 78, "Barcelona");
        Cliente_Estandar client3 = new  Cliente_Estandar("Luisa", 13254562, 56, "Sevilla");
        assertEquals("Pepe", client1.getNombre());
        assertEquals("Juan", client2.getNombre());
        assertEquals("Luisa", client3.getNombre());
    }

    @Test
    public void GetIDClientePrueba()
    {

        Cliente_Estandar client1 = new  Cliente_Estandar("Pepe", 1234, 20, "Caceres");
        Cliente_Estandar client2 = new  Cliente_Estandar("Juan", 4567, 78, "Barcelona");
        Cliente_Estandar client3 = new  Cliente_Estandar("Luisa", 13254562, 56, "Sevilla");
        assertEquals(1234, client1.getIdCliente());
        assertEquals(4567, client2.getIdCliente());
        assertEquals(13254562, client3.getIdCliente());
    }

    @Test
    public void GetEdadClientePrueba()
    {

        Cliente_Estandar client1 = new  Cliente_Estandar("Pepe", 1234, 20, "Caceres");
        Cliente_Estandar client2 = new  Cliente_Estandar("Juan", 4567, 78, "Barcelona");
        Cliente_Estandar client3 = new  Cliente_Estandar("Luisa", 13254562, 56, "Sevilla");
        assertEquals(20, client1.getEdad());
        assertEquals(78, client2.getEdad());
        assertEquals(56, client3.getEdad());
    }

    @Test
    public void GetLocalidadClientePrueba()
    {

        Cliente_Estandar client1 = new  Cliente_Estandar("Pepe", 1234, 20, "Caceres");
        Cliente_Estandar client2 = new  Cliente_Estandar("Juan", 4567, 78, "Barcelona");
        Cliente_Estandar client3 = new  Cliente_Estandar("Luisa", 13254562, 56, "Sevilla");
        assertEquals("Caceres", client1.getLocalidad());
        assertEquals("Barcelona", client2.getLocalidad());
        assertEquals("Sevilla", client3.getLocalidad());
    }

    @Test
    public void GetDineroGastadoPrueba()
    {

        Cliente_Estandar client1 = new  Cliente_Estandar("Pepe", 1234, 20, "Caceres");
        Cliente_Estandar client2 = new  Cliente_Estandar("Juan", 4567, 78, "Barcelona");
        Cliente_Estandar client3 = new  Cliente_Estandar("Luisa", 13254562, 56, "Sevilla");
        assertEquals((Double)0.0, client1.getDineroGastado());
        assertEquals((Double)0.0, client2.getDineroGastado());
        assertEquals((Double)0.0, client3.getDineroGastado());
    }

    @Test
    public void GetcomentarioPrueba()
    {

        Cliente_Estandar client1 = new  Cliente_Estandar("Pepe", 1234, 20, "Caceres");
        Cliente_Estandar client2 = new  Cliente_Estandar("Juan", 4567, 78, "Barcelona");

        assertEquals("Bad product", client1.getComentario(1));
        assertEquals("Not very good product", client2.getComentario(2));

    }

    @Test
    public void anadirProfavPrueba()
    {

        Cliente_Estandar client1 = new  Cliente_Estandar("Pepe", 1234, 20, "Caceres");
        
        
        Product pro= client1.getProductoFav("gafas");
        Ocio product2 = new Ocio(456, "latas",23.4);
        client1.AñadirProdFav(456,"latas");
        Product pro2= client1.getProductoFav("latas");
        assertEquals(123, pro.getID());
        assertEquals(0, pro.getCantidadMinima());
        assertEquals("gafas", pro.getName());
        assertEquals(0, pro.getQuantity());
        assertEquals(0, pro.getCantidadMinima());
        assertEquals(456, pro2.getID());
        assertEquals("latas", pro2.getName());
        assertEquals(0, pro2.getQuantity());
        assertEquals(0, pro2.getCantidadMinima());
        assertEquals((Double)12.3, pro.getPrecio());
        assertEquals((Double)23.4, pro2.getPrecio());
        assertEquals(0, pro.getVendido());
        assertEquals(0, pro2.getVendido());
        assertEquals(0, pro.getCantidadVendida());
        assertEquals(0, pro2.getCantidadVendida());

    }
    @Test
    public void BuscarProfavPrueba()
    {

        Cliente_Estandar client1 = new  Cliente_Estandar("Pepe", 1234, 20, "Caceres");
        Ocio product1 = new Ocio(123, "gafas", 12.3);
        client1.AñadirProdFav(123,"gafas");
        Product pro= client1.getProductoFav("gafas");
        Ocio product2 = new Ocio(456, "latas",23.4);
        client1.AñadirProdFav(456,"latas");
        Product pro2= client1.getProductoFav("latas");
        assertEquals(123, pro.getID());
        assertEquals(0, pro.getCantidadMinima());
        assertEquals("gafas", pro.getName());
        assertEquals(0, pro.getQuantity());
        assertEquals(0, pro.getCantidadMinima());
        assertEquals(456, pro2.getID());
        assertEquals("latas", pro2.getName());
        assertEquals(0, pro2.getQuantity());
        assertEquals(0, pro2.getCantidadMinima());
        assertEquals((Double)12.3, pro.getPrecio());
        assertEquals((Double)23.4, pro2.getPrecio());
        assertEquals(0, pro.getVendido());
        assertEquals(0, pro2.getVendido());
        assertEquals(0, pro.getCantidadVendida());
        assertEquals(0, pro2.getCantidadVendida());

    }
    @Test
    public void EliminarProfavPrueba()
    {

        Cliente_Estandar client1 = new  Cliente_Estandar("Pepe", 1234, 20, "Caceres");
        Ocio product1 = new Ocio(123, "gafas", 12.3);
        client1.AñadirProdFav(123,"gafas");

        client1.AñadirProdFav(456,"latas");
        client1.EliminaProdFav("gafas");
        client1.EliminaProdFav("latas");

        assertEquals(null, client1.getProductoFav("gafas"));
        assertEquals(null,client1.getProductoFav("latas"));

    }
    
    
    @Test
    public void ObtenerProfavPrueba()
    {

        Cliente_Estandar client1 = new  Cliente_Estandar("Pepe", 1234, 20, "Caceres");
Ocio product1 = new Ocio(123, "gafas", 12.3);
        client1.AñadirProdFav(123,"gafas");
        Product pro =  client1.getProductoFav("gafas");
           
        assertEquals(123, pro.getID());
        assertEquals(0, pro.getCantidadMinima());
        assertEquals("gafas", pro.getName());
        assertEquals(0, pro.getQuantity());
        assertEquals(0, pro.getCantidadMinima());

        assertEquals((Double)12.3, pro.getPrecio());

        assertEquals(0, pro.getVendido());

        assertEquals(0, pro.getCantidadVendida());
        

        
        client1.AñadirProdFav(456,"latas");
       
        client1.EliminaProdFav("latas");

        assertEquals(null,client1.getProductoFav("latas"));

    }
    
        public void hacerPedidoFavPrueba()
    {

        Cliente_Estandar client1 = new  Cliente_Estandar("Pepe", 1234, 20, "Caceres");
        Ocio product1 = new Ocio(123, "gafas", 12.3);
        client1.AñadirProdFav(123,"gafas");
                
        product1.increaseQuantity(3);
        assertEquals(3, product1.getQuantity());
        client1.hacerPedidoFav("gafas", 1, writer);
        assertEquals(2, product1.getQuantity());


    }
    
            public void  hacerPedidoTodosFavPrueba()
    {

        Cliente_Estandar client1 = new  Cliente_Estandar("Pepe", 1234, 20, "Caceres");
        Ocio product1 = new Ocio(123, "gafas", 12.3);
        client1.AñadirProdFav(123,"gafas");
        Ocio product2 = new Ocio(456, "latas",23.4);
        client1.AñadirProdFav(456,"latas");
        
        product1.increaseQuantity(3);
        product2.increaseQuantity(3);
        assertEquals(3, product1.getQuantity());
        assertEquals(3, product2.getQuantity());
        client1.hacerPedidoTodosFav(writer);
        assertEquals(2, product1.getQuantity());
        assertEquals(2, product2.getQuantity());

    }
   
        @Test
    public void ToStringPrueba(){
        Cliente_Estandar client1 = new  Cliente_Estandar("Pepe", 1234, 20, "Caceres");
        Cliente_Estandar client2 = new  Cliente_Estandar("Juan", 4567, 78, "Barcelona");

        client1.toString();
        client2.toString();
        
    }
    
    @Test
    public void PrepararPedidoPrueba()
    {
        StockManager stockMan1 = StockManager.getInstance();
        assertEquals(stockMan1, stockMan1);
        Cliente_Estandar cliente_1 = new Cliente_Estandar("pepe", 12, 14, "CC");
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
        cliente_1.PrepararPedido();
        Product pro1 = cliente_1.ProductosVenta.get(0);
        Product pro2 = cliente_1.ProductosVenta.get(1);
        
        assertEquals(45, pro1.getID());
        assertEquals("gafitas", pro1.getName());
        assertEquals((Double)123.0, pro1.getPrecio());
        
        assertEquals(46, pro2.getID());
        assertEquals("lampara", pro2.getName());
        assertEquals((Double)120.0, pro2.getPrecio());
        Hogar productHogar = (Hogar)pro2;
        assertEquals("bedroom", productHogar.getPcasa());


    }
    
    @Test
    public void ObtenerPrecioPedidoPrueba()
    {
        StockManager stockMan1 = StockManager.getInstance();
        assertEquals(stockMan1, stockMan1);
        Cliente_Estandar cliente_1 = new Cliente_Estandar("pepe", 12, 14, "CC");
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
        cliente_1.PrepararPedido();
        Product pro1 = cliente_1.ProductosVenta.get(0);
        Product pro2 = cliente_1.ProductosVenta.get(1);
        
        assertEquals(45, pro1.getID());
        assertEquals("gafitas", pro1.getName());
        assertEquals((Double)123.0, pro1.getPrecio());
        
        assertEquals(46, pro2.getID());
        assertEquals("lampara", pro2.getName());
        assertEquals((Double)120.0, pro2.getPrecio());
        Hogar productHogar = (Hogar)pro2;
        assertEquals("bedroom", productHogar.getPcasa());
            
        Double precio = (pro2.getPrecio()*50) + (pro1.getPrecio()*50);
       // assertEquals(precio, cliente_1.ObtenerPrecioPedido());
    }

        @Test
    public void RealizarPedidoPrueba()
    {
        StockManager stockMan1 = StockManager.getInstance();
        assertEquals(stockMan1, stockMan1);
        Cliente_Estandar cliente_1 = new Cliente_Estandar("pepe", 12, 14, "CC");
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
        cliente_1.PrepararPedido();
        Product pro1 = cliente_1.ProductosVenta.get(0);
        Product pro2 = cliente_1.ProductosVenta.get(1);
        
        assertEquals(45, pro1.getID());
        assertEquals("gafitas", pro1.getName());
        assertEquals((Double)123.0, pro1.getPrecio());
        
        assertEquals(46, pro2.getID());
        assertEquals("lampara", pro2.getName());
        assertEquals((Double)120.0, pro2.getPrecio());
        Hogar productHogar = (Hogar)pro2;
        assertEquals("bedroom", productHogar.getPcasa());
            
        stockMan1.delivery(46, 150);
        stockMan1.delivery(47, 150);
        cliente_1.realizarPedido(writer);
        
        assertEquals(0, pro1.getCantidadVendida());
        assertEquals(50, pro2.getCantidadVendida());
    }
    
        public void RealizarComentarioPrueba()
    {
        StockManager stockMan1 = StockManager.getInstance();
        assertEquals(stockMan1, stockMan1);
        Cliente_Estandar cliente_1 = new Cliente_Estandar("pepe", 12, 14, "CC");
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

