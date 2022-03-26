import java.io.*;
  import java.util.*;  

/** 
 * Nombre del grupo: 
 * Mario_y_Kike.
 * 
 * Nombre y Apellidos de cada alumno:
 * Mario Bermejo Sánchez.
 * Enrique Moreno Ávila.
 * 
 * Esta clase almacena el rol de un cliente estandar de un stock manager.
 * Es decir, almacena sus datos, sus productos favoritos,etc.
 * Ademas, contiene todas las operaciones de dicho tipo de cliente.
 */

public class Cliente_Estandar extends Client
{
   
    /**
     * Constructor de la clase cliente estandar.
     * Inicializa todos los atributos de la clase.
     *    
     * @param nombre Se trata del nombre del cliente.
     * @param idCliente Se trata del ID del cliente.
     * @param edad Se trata de la edad del cliente.
     * @param localidad Se trata de la ciudad en la que vive el cliente.
     */
    public Cliente_Estandar(String nombre, int idCliente, int edad, String localidad)
    {
        super(nombre, idCliente, edad, localidad);
        
    }

    /**
     * Metodo que prepara un pedido de los dos productos mas caros.
     */
    @Override
    public void PrepararPedido()
    {   
        ArrayList<Product> productosCaros = new ArrayList<Product>(Map.values());
        Comparator <Product> comparador = Collections.reverseOrder(new priceComparator());
        Collections.sort(productosCaros, comparador);
        
        Product prod=null;
        
        for (int i = 0; i<2 && i<productosCaros.size(); i++) {    
            prod = productosCaros.get(i);
            ProductosVenta.add(prod);
            System.out.println(getNombre() + " se ha preparado un pedido " + prod.getName());
        }
    }

    /*
    /**
     * Metodo que calcula el precio total del pedido que se va a realizar.
     * @return precioTotal Se trata del precio total del pedido realizado.
     */
    
    /*
    @Override
    public Double ObtenerPrecioPedido()
    {
        Product prod = null;
        Double precioTotal = 0.0;
        for(int i = 0; i < ProductosVenta.size(); i++){
            prod = ProductosVenta.get(i);
            precioTotal = precioTotal + prod.getPrecio()*50;
        }
        return precioTotal;
    }
    */
    
    /**
     * Metodo que realiza un pedido de todos los productos favoritos.
     * @param writer utilizado para grabar las operaciones realizadas en el metodo.
     */
    @Override
    public void realizarPedido(FileWriter writer)
    {
        StockManager stockmanager = StockManager.getInstance();
        Product prod = null;
        Double dineroGastadoAnt = this.dineroGastado;
        
        for(int i = 0; i < ProductosVenta.size(); i++){
            prod = ProductosVenta.get(i);
            dineroGastado = dineroGastado + stockmanager.ventaProdFav(prod, 50, writer);
            if(dineroGastadoAnt < dineroGastado){
            RealizarComentarioCliente(prod);
            dineroGastadoAnt = dineroGastado;
            }
        }
        ProductosVenta.clear();
    }   

    /**
     * Añade un comentario de un cliente sobre el producto.
     * @param puntuacion dada.
     * @param comentario realizado.
     * @param producto sobre el que realiza el comentario que se ha comprado.
     */
    @Override
    public void RealizarComentarioCliente(Product producto)
    {
        if(producto instanceof ProdComentable){
            String nombreProducto = producto.getName();
            int longitud = (nombreProducto.length()%5)+1;
            String nombreCliente = getNombre();           
            String comentario = getComentario(longitud);
            Comment coment = new Comment(longitud, nombreCliente, comentario);
            if(producto instanceof Hogar){
              Hogar h = (Hogar)producto;  
              h.realizarComentario(coment);  
              if(longitud >= 4){
                    h.like();
                }else{
                    if(longitud <= 2){
                        h.unlike();
                    }
                }  
            }
            else{
              if(producto instanceof Ocio){
              Ocio o = (Ocio)producto;
              o.realizarComentario(coment);
              }
            }
      
        }else{
            System.out.println("No se puede realizar comentarios sobre este tipo de productos");
        }
      
    }

    /**
     * Metodo que modifica el toString.
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(' ');
        builder.append(super.toString());
        return builder.toString();
    }

    /**
     * Hashcode technique taken from
     * Effective Java by Joshua Bloch.
     */
    @Override
    public int hashCode()
    {
        StockManager stockmanager = StockManager.getInstance();
        int result = 17;
        result = 37 * result +  getNombre().hashCode();
        result = 37 * result +  ((Integer)getIdCliente()).hashCode();
        result = 37 * result +  ((Integer)getEdad()).hashCode();
        result = 37 * result +  getLocalidad().hashCode();

        return result;
    }

    /**
     * Metodo que modifica el equals.
     */
    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) {
            return true; 
        }
        if(!(obj instanceof Cliente_Estandar)) {
            return false; //They have different types
        }
        Cliente_Estandar other = (Cliente_Estandar) obj;
        return getNombre().equals(other.getNombre()) &&
        getIdCliente() == other.getIdCliente() && getEdad() == other.getEdad() && getLocalidad().equals(other.getLocalidad());
    }

}
