import java.util.Comparator;
/** 
 * Nombre del grupo: 
 * Mario_y_Kike.
 * 
 * Nombre y Apellidos de cada alumno:
 * Mario Bermejo Sánchez.
 * Enrique Moreno Ávila.
 * 
 * Clase que maneja los productos de tipo Ocio.
 */
public class Ocio extends ProdComentable
{
    /**
     * Constructor de la clase ocio.
     * @param id Se trata del identificador del producto.
     * @param name Se trata del nombre del producto.
     * @param Precio Se trata del precio del producto
     */
    public Ocio(int id, String name,Double Precio)
    {    
        super(id,name,Precio);
        Precio = Precio + (Precio*0.2);
    }

    /**
     * Metodo que hace el toString.
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
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
        if(!(obj instanceof Ocio)) {
            return false; //They have different types
        }
        Ocio other = (Ocio) obj;
        return ((Integer)getID()) == (other.getID()) &&
        getName().equals(other.getName()) && ((Double)getPrecio()) == other.getPrecio();

    }
}
