import java.util.*;
/** 
 * Nombre del grupo: 
 * Mario_y_Kike.
 * 
 * Nombre y Apellidos de cada alumno:
 * Mario Bermejo Sánchez.
 * Enrique Moreno Ávila.
 * 
 * Clase creada para poder realizar un comparator de precios de productos.
 */
public class priceComparator implements Comparator<Product>
{
    @Override
    public int compare(Product p1,Product p2)
    {
        if(p1.Precio == p2.Precio){
        return 0;
        }else {
            if(p1.Precio>p2.Precio){
            return 1;
            }else{
            return -1;
            }
        }
    }
}
