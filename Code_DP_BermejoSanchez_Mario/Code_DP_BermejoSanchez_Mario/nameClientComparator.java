import java.util.*;
/** 
 * Nombre del grupo: 
 * Mario_y_Kike.
 * 
 * Nombre y Apellidos de cada alumno:
 * Mario Bermejo Sánchez.
 * Enrique Moreno Ávila.
 * 
 * Clase creada para poder realizar un comparator de nombres de los clientes.
 */
public class nameClientComparator implements Comparator<Client>
{
    public int compare(Client c1,Client c2){   
    return c1.getNombre().compareTo(c2.getNombre());
    }
}
