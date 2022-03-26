import java.util.*;
/** 
 * Nombre del grupo: 
 * Mario_y_Kike.
 * 
 * Nombre y Apellidos de cada alumno:
 * Mario Bermejo Sánchez.
 * Enrique Moreno Ávila.
 * 
 * Clase creada para poder realizar un comparator de likes de comments.
 */
public class likesComparator implements Comparator<Product>
{
    @Override
    public int compare(Product p1,Product p2)
    {
        int likes1 = 0; int likes2 = 0;
        if(p1 instanceof Hogar){
            Hogar h = (Hogar)p1;
            likes1 = h.getLikes();
        }
        else{
            if(p1 instanceof Alimentacion){
                Alimentacion h = (Alimentacion)p1;
                likes1 = h.getLikes();

            }
        }

        if(p2 instanceof Hogar){
            Hogar h = (Hogar)p2;
            likes2 = h.getLikes();
        }
        else{
            if(p2 instanceof Alimentacion){
                Alimentacion h = (Alimentacion)p2;
                likes2 = h.getLikes();

            }
        }

        if(likes1 == likes2){
            return 0;
        }else {
            if(likes1>likes2){
                return 1;
            }else{
                return -1;
            }
        }
    }
}
