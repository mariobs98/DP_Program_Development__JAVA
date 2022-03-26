import java.util.*;
/** 
 * Nombre del grupo: 
 * Mario_y_Kike.
 * 
 * Nombre y Apellidos de cada alumno:
 * Mario Bermejo Sánchez.
 * Enrique Moreno Ávila.
 * 
 * Clase creada para poder realizar un comparator de ids de clientes.
 */
public class idClientComparator implements Comparator<Client>
{
    @Override
    public int compare(Client p1,Client p2)
    {
        if(p1.getIdCliente() == p2.getIdCliente()){
        return 0;
        }else {
            if(p1.getIdCliente()>p2.getIdCliente()){
            return 1;
            }else{
            return -1;
            }
        }
    }
}
