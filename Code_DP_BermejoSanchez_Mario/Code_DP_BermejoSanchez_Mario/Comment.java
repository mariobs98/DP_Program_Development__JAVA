/** 
 * Nombre del grupo: 
 * Mario_y_Kike.
 * 
 * Nombre y Apellidos de cada alumno:
 * Mario Bermejo Sánchez.
 * Enrique Moreno Ávila.
 * 
 * Esta clase almacena todo aquello relacionado con un comentario que un cliente puede realizar acerca de un producto en un stock manager.
 */
public class Comment
{
    //Puntuacion dada por el cliente. Entre 1 y 5.
    private int puntuacion;

    //Nombre del cliente que realizo el comentario.
    private String nombreCliente;

    //Comentario realizado por el cliente.
    private String comentario;

    /**
     * Constructor de la clase comentario.
     * Este metodo inicializa los objetos de la clase comentario.
     * @param puntuacion Se trata de la puntuacion del comentario.
     * @param nombreCliente Se trata del nombre del cliente que va a poner el comentario.
     * @param comentario Se trata del comentario que va a realizar el cliente.
     */
    public Comment(int puntuacion,String nombreCliente, String comentario)
    {   
        if(puntuacion >= 1 && puntuacion <= 5 ){
            this.puntuacion = puntuacion;
        }else{
            if(puntuacion>5){
                puntuacion=5;
                this.puntuacion = puntuacion;
            }else{
                if(puntuacion<1){
                    puntuacion=1;           
                    this.puntuacion = puntuacion;
                }
            }
        }

        this.nombreCliente = nombreCliente;
        this.comentario = comentario;

    }

    /**
     * Este metodo devuelve la puntuacion dada a un comentario.
     * @return puntuacion Puntuacion del comentario. Entre 1 y 5.
     */
    public int getPuntuacion()
    {
        return  this.puntuacion;
    }

    /**
     * Este metodo, devuelve el nombre del cliente que realizo el comentario.
     * @return nombreCliente Nombre del cliente que realizo el comentario.
     */
    public String getNombreCliente(){
        return this.nombreCliente;
    }

    /**
     * Este metodo, devuelve el comentario realizado por un cliente.
     * @return comentario Comentario realizado por el cliente.
     */
    public String getComentario(){
        return this.comentario;
    }

    /**
     * Metodo que realiza toString.
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(getPuntuacion());
        builder.append(' ');
        builder.append(getNombreCliente());
        builder.append(' ');
        builder.append(getComentario());
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
        result = 37 * result +  ((Integer)getPuntuacion()).hashCode();
        result = 37 * result +  getNombreCliente().hashCode();
        result = 37 * result +  getComentario().hashCode();
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
        if(!(obj instanceof Comment)) {
            return false; //They have different types
        }
        Comment other = (Comment) obj;
        return ((Integer)getPuntuacion()) == (other.getPuntuacion()) &&
        getNombreCliente().equals(other.getNombreCliente()) && getComentario().equals(other.getComentario()) ;

    }
}
