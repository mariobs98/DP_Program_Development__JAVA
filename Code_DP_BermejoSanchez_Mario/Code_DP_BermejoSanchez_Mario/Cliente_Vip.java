import java.io.*;
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
public class Cliente_Vip extends Client
{

    /**
     * Constructor de la clase cliente vip.
     * Inicializa todos los atributos de dicha clase.
     * @param nombre Se trata del nombre del cliente.
     * @param idCliente Se trata del ID del cliente.
     * @param edad Se trata de la edad del cliente.
     * @param localidad Se trata de la ciudad en la que vive el cliente.
     */
    public Cliente_Vip(String nombre, int idCliente, int edad, String localidad)
    {
        super(nombre, idCliente, edad, localidad);
    }

    /**
     *Metodo que prepara un pedido de todos los productos favoritos.
     */
    @Override
    public void PrepararPedido()
    {  
        Product prod=null;
        for (String Clave : Map.keySet()) {    
            prod = getProductoFav(Clave);
            System.out.println(getNombre() + "se ha preparado un pedido " + prod.getName());
            ProductosVenta.add(prod);
        }
    }

    /**
     * Metodo que obtiene el precio total del pedido realizado.
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
            precioTotal = precioTotal + prod.getPrecio();
        }
        return precioTotal;
    }
*/
    
    /**
     * Metodo que realiza un pedido de la lista de producto favoritos en el stock manager.
     * @param writer utilizado para grabar las operaciones realizadas en el metodo.
     */
    @Override
    public void realizarPedido(FileWriter writer)
    {
        StockManager stockmanager = StockManager.getInstance();
        dineroGastado = dineroGastado + stockmanager.ventaListaProdFav(ProductosVenta, 1, writer, this);
        ProductosVenta.clear();
    }

    /**
     * Añade un comentario de un cliente sobre el producto.
     */
    @Override
    public void RealizarComentarioCliente(Product producto)
    {

        if(producto instanceof ProdComentable){
            String nombreCliente = getNombre();
            Comment comentario = new Comment(4, nombreCliente, "I really like this product");
            if(producto instanceof Ocio){
                Ocio o = (Ocio)producto;
                o.realizarComentario(comentario);
 
            }else{
                if(producto instanceof Hogar){
                Hogar h = (Hogar)producto;
                h.realizarComentario(comentario);
                h.like();
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
        if(!(obj instanceof Cliente_Vip)) {
            return false; //They have different types
        }
        Cliente_Vip other = (Cliente_Vip) obj;
        return getNombre().equals(other.getNombre()) &&
        getIdCliente()==other.getIdCliente() && getEdad()== other.getEdad() && getLocalidad().equals(other.getLocalidad());
    }

}
