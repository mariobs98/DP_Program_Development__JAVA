import java.util.Comparator;
/** 
 * Nombre del grupo: 
 * Mario_y_Kike.
 * 
 * Nombre y Apellidos de cada alumno:
 * Mario Bermejo Sánchez.
 * Enrique Moreno Ávila.
 * 
 * Esta clase maneja los detalles sobre el producto que quiere vender una compañia.
 */
public abstract class Product extends Exception 
{
    // Identificador del producto.
    protected int id;

    // Nombre del producto.
    protected String name;

    // Precio del producto.
    protected Double Precio;

    // Cantidad en stock del producto.
    protected int quantity;

    //Cantidad minima en stock del producto.
    protected int cantidadMinima;

    //Cantidad vendida del producto durante la simulacion.
    protected int cantidadVendida;

    //Indica si ha sido vendido dicho producto durante la simulacion.
    //0=no ha sido vendido , 1= si ha sido vendido.
    protected int vendido;

    /**
     * Constructor de la clase producto.
     * Inicialmente todo esta a cero.
     * @param id Se trata del identificador del producto.
     * @param name Se trata del nombre del producto.
     * @param Precio Se trata del precio del producto.
     * @param quantity Se trata de la cantidad del producto.
     * @param cantidadMinima Se trata de la cantidad minima que debe de haber del producto.
     * @param cantidadVendida Se trata de la cantidad de este producto que ha sido vendida.
     * @param vendido Indica si se ha vendido este producto. 0=no ha sido vendido , 1= si ha sido vendido.
     */
      public Product(int _id, String name, Double Precio) 
    {
        this.id = _id;
        this.name = name;
        this.Precio = Precio;
        this.quantity = 0;
        this.cantidadMinima = 0;
        this.cantidadVendida = 0;
        this.vendido = 0;

    }

    /**
     * Este metodo, devuelve el id asociado al producto.
     * @return id Devuelve el id del producto.
     */
    public int getID()
    {
        return id;
    }

    /**
     * Este metodo, devuelve el nombre asociado al producto.
     * @return name Devuelve el nombre del producto.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Este metodo, devuelve el precio del producto.
     * @return precio Devuelve el precio del producto
     */
    public Double getPrecio(){
        return this.Precio;
    }

    /**
     * Este metodo, devuelve la cantidad asociada a ese producto.
     * @return quantity Devuelve la cantidad de productos en stock.
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * Este metodo, devuelve la cantidad minima asociada al producto.
     * @return cantidadMinima Devuelve la cantidad minima en stock del producto.
     */

    public int getCantidadMinima(){
        return this.cantidadMinima;
    }

    /**
     * Este metodo, devuelve la cantidad vendida asociada al producto.
     * @return cantidadVendida Devuelve la cantidad minima en stock del producto.
     */

    public int getCantidadVendida(){
        return this.cantidadVendida;
    }

    /**
     * Este metodo, devuelve si ha sido vendido el producto producto.
     * @return vendido Devuelve la cantidad minima en stock del producto.
     */

    public int getVendido(){
        return this.vendido;
    }

    /**
     * Metodo que mete una cantidad minima al producto para cumplir el stock minimo.
     * @param cantidad Se trata de la cantidad minima que queremos establecer que debe de haber como stock de un producto en la tienda.
     */
    public void setCantidadMinima(int cantidad){
        if(cantidad>0)
            this.cantidadMinima = cantidad;
        else{
            System.out.println("Tiene que ser una cantidad minima mayor que 0"); 
        }
    }

    /**
     * Aumenta la cantidad en stock de un producto segun amount.
     * Es decir, amount incrementa la cantidad de stock.
     * @param amount Se trata de la nueva "cantidad" que queremos meter en stock.
     *               ***DEBE SER POSITIVO***
     */
    public void increaseQuantity(int amount)
    {
        if(amount > 0) {
            quantity += amount;
        }
        else {
            System.out.println("Attempt to restock " +
                name +
                " with a non-positive amount: " +
                amount);
        }
    }

    /**
     * Vende un producto de toda la cantidad que haya en stock.
     * En caso de que no haya productos en stock mandara un mensaje de error.
     */
    public void sellOne()
    {
        if(quantity > 0) {
            quantity--;
            this.vendido=1;
            cantidadVendida= cantidadVendida + 1;
        }
        else {
            System.out.println(
                "El siguiente producto esta fuera de stock: " + name);
        }
    }

    /**
     * Vende el numero de productos indicado por el usuario.
     * @param cantidad De productos a vender.
     */
    public void venderProductos(int cantidad){
        if (quantity>0){
            quantity = quantity-cantidad;
            cantidadVendida = cantidadVendida + cantidad;
            this.vendido=1;
        }else{
            System.out.println(
                "El siguiente producto esta fuera de stock: " + name);
        }
    }

    /**
     * Metodo que nos permite realizar un comentario de un producto.
     * param coment Comentario que queremos que se realice.
     */
    public abstract void realizarComentario(Comment coment);

    /**
     * Metodo que nos devuelve el numero total de un producto.
     * @return Devuelve el numero de comentarios totales.
     */
    public abstract int comentariosTotales();
   
    /**
     *  Este metodo muestra el id,el nombre y la cantidad en stock del producto.
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(getID());
        builder.append(' ');
        builder.append(getName());
        builder.append(' ');
        builder.append(getPrecio());
        builder.append(' ');
        builder.append(getQuantity());
        builder.append(' ');
        builder.append(getCantidadMinima());
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

        result = 37 * result +  ((Integer)getID()).hashCode();
        result = 37 * result +  getName().hashCode();
        result = 37 * result +  ((Double)getPrecio()).hashCode();
        result = 37 * result +  ((Integer)getQuantity()).hashCode();
        result = 37 * result +  ((Integer)getCantidadMinima()).hashCode();

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
        if(!(obj instanceof Product)) {
            return false; //They have different types
        }
        Product other = (Product) obj;
        return ((Integer)getID()) == (other.getID()) &&
        getName().equals(other.getName()) && ((Double)getPrecio()) == other.getPrecio() && 
        ((Integer)getQuantity()) == other.getQuantity() && ((Integer)getCantidadMinima()) == other.getCantidadMinima();

    }
}