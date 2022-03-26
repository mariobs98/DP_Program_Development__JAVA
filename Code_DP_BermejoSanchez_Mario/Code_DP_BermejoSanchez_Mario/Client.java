import java.util.*;
import java.io.*;
/** 
 * Nombre del grupo: 
 * Mario_y_Kike.
 * 
 * Nombre y Apellidos de cada alumno:
 * Mario Bermejo Sánchez.
 * Enrique Moreno Ávila.
 * 
 * Esta clase almacena el rol de un cliente de un stock manager.
 * Es decir, almacena sus datos, sus productos favoritos,etc.
 * 
 */
public abstract class Client
{
    //Nombre del cliente.
    protected String nombre;

    //identificador unico del cliente.
    protected int idCliente;

    //Edad del cliente.
    protected int edad;

    //Localidad en la que reside el cliente.
    protected String localidad;

    //Vector con los comentarios a realizar.
    protected ArrayList<String> comentarios;

    //Guarda el dinero gastado por el cliente.
    protected Double dineroGastado;

    //HashMap para almacenar los productos favoritos de cliente.
    protected HashMap<String, Product > Map;

    //Lista para almacenar productos favoritos preparados para la venta.
    protected ArrayList<Product> ProductosVenta;

    /**
     * Constructor de la clase cliente.
     * Inicializa los objetos de la clase cliente.
     * @param nombre Se trata del nombre del cliente.
     * @param idCliente Se trata del ID del cliente.
     * @param edad Se trata de la edad del cliente.
     * @param localidad Se trata de la ciudad en la que vive el cliente.
     */
    public Client(String nombre, int idCliente, int edad, String localidad)
    {
        this.nombre = nombre;
        this.idCliente = idCliente;
        this.edad = edad;
        this.localidad = localidad;
        this.comentarios = new ArrayList<String>();
        comentarios.add("Bad product");
        comentarios.add("Not very good product");
        comentarios.add("Good product");
        comentarios.add("Very good product");
        comentarios.add("Excellent product");
        this.dineroGastado = 0.0;
        Map = new HashMap<String, Product>();
        ProductosVenta = new ArrayList<Product>();
    }

    /**
     * Devuelve el nombre del cliente.
     * @return nombre Se trata del nombre del cliente.
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Devuelve el id del cliente.
     * @return id Se trata del identificador del cliente.
     */
    public int getIdCliente(){
        return this.idCliente;
    }

    /**
     * Devuelve la edad del cliente.
     * @return edad Se trata de la edad del cliente.
     */
    public int getEdad(){
        return this.edad;
    }

    /**
     * Devuelve la localidad en la que reside el cliente.
     * @return localidad Se trata de la localidad en la que reside el cliente.
     */
    public String getLocalidad(){
        return this.localidad;
    }

    /**
     * Devuelve el dinero que se ha gastado un cliente.
     * @return dineroGastado Se trata del dinero que se ha gastado un cliente.
     */
    public Double getDineroGastado(){
        return this.dineroGastado;
    }

    /**
     * Metodo que devuelve uno de los cinco comentarios segun el valor de pos.
     *@param pos Variable que indica una posicion para devolver un comentario en concreto.
     *@return comentarios.get(pos-1) Devuelve un comentario segun la posicion dada.
     */
    public String getComentario(int pos){
        return comentarios.get(pos-1);
    }   

    /**
     * Añade un producto favorito al mapa con nombre una clave dada por el cliente.
     * @param id del producto a añadir.
     * @param Clave  Se trata de la clave dada por el cliente al producto.
     */
    public void AñadirProdFav(int id, String Clave)
    {   
        StockManager stockmanager = StockManager.getInstance();
        Product producto=null;
        producto= stockmanager.findProduct(id);
        Map.put(Clave, producto);  
        System.out.println(Clave+" añadido");
    }

    /**
     * Elimina del mapa de favoritos del cliente el producto indicado segun la clave que le dio.
     * @param Clave dada por el cliente al producto.
     */
    public void EliminaProdFav(String Clave)
    {
        Map.remove(Clave);      
    }

    /**
     * Devuelve el producto buscado de la lista favoritos.
     * @param Clave Contiene la clave para acceder a un producto.
     * @return producto Se trata del producto favorito segun una clave dada.
     */

    public Product getProductoFav(String Clave){
        Product producto=null; 
        producto=Map.get(Clave);
        if(producto != null){       
            return producto;
        }else{
            System.out.println("No existe/no esta en productos favoritos");
            return producto;
        }
    }

    /**
     * Devuelve el producto buscado de la lista de productos para venta.
     * @param i Posicion del producto del arraylist productoVenta que queremos devolver.
     * @return producto Se trata del producto buscado en el ArrayList productoVenta.
     */

    public Product getProductoPVentas(int i){
        Product producto=null;
        producto = ProductosVenta.get(i);
        return producto;
    }

    /**
     * Hace un pedido de un producto en el mapa de favoritos.
     * @param Clave Clave dada por el cliente al producto.
     * @param cantidad Cantidad de la que se va a realizar el pedido.
     * @param writer utilizado para grabar las operaciones realizadas en el metodo.
     * @return dineroGastado Se trata del dinero total que se ha gastado el cliente.
     */
    public Double hacerPedidoFav(String Clave, int cantidad,FileWriter writer)
    {  
        StockManager stockmanager = StockManager.getInstance();
        Double dineroGastado = 0.0;
        Product producto=null; 
        producto = getProductoFav(Clave);
        dineroGastado = stockmanager.ventaProdFav(producto,cantidad,writer); 
        return dineroGastado;
    }

    /**
     * Hace un pedido de una unidad de todos los productos en favoritos.
     * @param writer utilizado para grabar las operaciones realizadas en el metodo.
     * @return dineroGastado Se trata del dinero total que se ha gastado el cliente.
     */
    public Double hacerPedidoTodosFav(FileWriter writer){
        StockManager stockmanager = StockManager.getInstance();
        Double dineroGastado = 0.0;
        Product prod = null;
        for (String Clave : Map.keySet()) {
            // System.out.println("Key = " + Clave);
            prod = getProductoFav(Clave);
            dineroGastado = dineroGastado + stockmanager.ventaProdFav(prod, 1,writer);
        }

        return dineroGastado;
    }
    
    /**
     * Metodo que se encarga de preparar el pedido de un cliente.
     */
    abstract void PrepararPedido();
    
    
    
    /**
     * Metodo que devuelve el precio del pedido realizado por el cliente.
     * @return Devuelve el precio del pedido realizado por el cliente.
     */
    /*
    abstract Double ObtenerPrecioPedido();
    */
    
    /**
     * Metodo que se encarga de realizar el pedido.
     * @param writer utilizado para grabar las operaciones realizadas en el metodo.
     */
    abstract void realizarPedido(FileWriter writer);
    
    /**
     * Metodo que se encarga de realizar un comentario indicado por el cliente.
     */
    abstract void RealizarComentarioCliente(Product producto);

    /**
     * Metodo que realiza un toString.
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(getNombre());
        builder.append(' ');
        builder.append(getIdCliente());
        builder.append(' ');
        builder.append(getEdad());
        builder.append(' ');
        builder.append(getLocalidad());
        builder.append(' ');
        builder.append(getDineroGastado());
        builder.append(' ');
        return builder.toString();
    }

    /**
     * Hashcode technique taken from
     * Effective Java by Joshua Bloch.
     * Metodo que modifica el hashCode.
     */
    @Override
    public int hashCode()
    {
        int result = 17;
        result = 37 * result +  getNombre().hashCode();
        result = 37 * result +  ((Integer)getIdCliente()).hashCode();
        result = 37 * result +  ((Integer)getEdad()).hashCode();
        result = 37 * result +  getLocalidad().hashCode();

        return result;
    }

    @Override
    /**
     * Metodo que modifica el equals.
     */
    public boolean equals(Object obj)
    {
        if(this == obj) {
            return true;
        }
        if(!(obj instanceof Client)) {
            return false; //They have different types
        }
        Client other = (Client) obj;
        return getNombre().equals(other.getNombre()) &&
        getIdCliente() == other.getIdCliente() && getEdad() == other.getEdad() && getLocalidad().equals(other.getLocalidad());
    }

}
