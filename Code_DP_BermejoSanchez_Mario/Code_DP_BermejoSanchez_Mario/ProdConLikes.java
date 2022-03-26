
/** 
 * Nombre del grupo: 
 * Mario_y_Kike.
 * 
 * Nombre y Apellidos de cada alumno:
 * Mario Bermejo Sánchez.
 * Enrique Moreno Ávila.
 * 
 * Interfaz para los productos que pueden tener likes y unlikes.
 * Permite tener un numero negativo de likes.
 */
public interface ProdConLikes
{   
    /**
     * Devuelve el numero de likes del producto.
     * @return Numero de likes totales del producto.
     */
    public int getLikes();

    /**
     * Metodo que suma en uno el numero de likes del producto.  
     */
    public void like();

    /**
     *Resta uno el numero de likes del producto.
     *Permite tener un numero negativo de likes.
     */
    public void unlike();
}
