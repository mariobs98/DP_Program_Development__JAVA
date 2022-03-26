import java.util.*;
/** 
 * Nombre del grupo: 
 * Mario_y_Kike.
 * 
 * Nombre y Apellidos de cada alumno:
 * Mario Bermejo Sánchez.
 * Enrique Moreno Ávila.
 * 
 * Clase creada para poder realizar un comparator de puntuacion de comentarios.
 */
public class puntComentComparator implements Comparator<Comment>
{
    @Override
    public int compare(Comment c1,Comment c2){
        if(c1.getPuntuacion() == c2.getPuntuacion()){
        return 0;
        }else{
            if(c1.getPuntuacion() > c2.getPuntuacion()){
            return 1;
            }else{
            return -1;
            }
        }
    }
}
