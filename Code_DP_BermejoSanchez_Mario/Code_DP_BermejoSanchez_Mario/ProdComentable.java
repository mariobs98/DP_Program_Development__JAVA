import java.util.*;
/** 
 * Nombre del grupo: 
 * Mario_y_Kike.
 * 
 * Nombre y Apellidos de cada alumno:
 * Mario Bermejo Sánchez.
 * Enrique Moreno Ávila.
 * 
 * Esta clase trata de manejar todos los comentarios que se pueden hacer de un producto.
 */
public abstract class ProdComentable extends Product
{   
    //Lista de comentarios sobre los productos
    protected ArrayList<Comment> comentarios;

    /**
     * Constructor de la clase ProdComentable.
     * Aqui se inicializan todos los atirbutos de la clase.
     * @param id Se trata del ID del producto.
     * @param name Se trata del nombre del producto.
     * @param Precio Se trata del precio del producto.
     */
    public ProdComentable(int id,String name,Double Precio)
    {
        super(id,name,Precio);
        this.comentarios = new ArrayList<Comment>();
    }

    /**
     * Este metodo añade un comentario de un cliente sobre el producto.
     * @param coment Se trata del comentario realizado por el cliente.
     */
    @Override
    public void realizarComentario(Comment coment){
        Boolean encontrado = false;
        Comment comentario = null;
        if(comentarios.size()==0){
            comentarios.add(coment);
            System.out.println("Comentario realizado");
        }else{    
            for(int i = 0;i<comentarios.size() && !encontrado;i++){
                comentario = comentarios.get(i);
                if(coment.getNombreCliente()==comentario.getNombreCliente()){
                    encontrado = true;
                    System.out.println("Ya ha realizado un comentario, Solo se permite uno por usuario y producto.");
                }
            }
            if(!encontrado){
                comentarios.add(coment);
                System.out.println("Comentario realizado");
            }
        }
    }

    /**
     * Este metodo devuelve el numero total de comentarios sobre el producto.
     * @return comentarios.size() Devuelve el numero de comentarios totales.
     */
    @Override
    public int comentariosTotales(){        
        return comentarios.size();
    }

    /**
     * Este metodo devuelve un comentario de la lista segun una posicion dada.
     * @param i Se trata del numero correspondiente al comentario en el ArrayList.
     * @return comment Devuelve comentario de la lista segun una posicion dada.
     */
    public Comment devComentario(int i){
        Comment comment = null;
        comment = comentarios.get(i);
        return comment;
    }

    /**
     * Metodo toString (de mayor a menor).
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("\n");
        Comment comentario = null;
        
        Comparator <Comment> comparador = Collections.reverseOrder(new puntComentComparator());
        Collections.sort(comentarios, comparador);

        for(int i=0; i<comentarios.size(); i++){
            comentario = comentarios.get(i);
            builder.append(comentario.toString()+"\n");
        }
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
        result = 37 * result +  ((Double)getPrecio()).hashCode();;
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
        if(!(obj instanceof ProdComentable)) {
            return false; //They have different types
        }
        ProdComentable other = (ProdComentable) obj;
        return ((Integer)getID()) == (other.getID()) &&
        getName().equals(other.getName()) && ((Double)getPrecio()) == other.getPrecio();

    }
}
