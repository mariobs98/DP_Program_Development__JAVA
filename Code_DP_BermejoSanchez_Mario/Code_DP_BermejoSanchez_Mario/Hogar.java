 import java.util.Comparator;
/** 
 * Nombre del grupo: 
 * Mario_y_Kike.
 * 
 * Nombre y Apellidos de cada alumno:
 * Mario Bermejo Sánchez.
 * Enrique Moreno Ávila.
 * 
 * Clase que maneja los productos de tipo Hogar.
 */
public class Hogar extends ProdComentable  implements ProdConLikes 
{
    //Almacena el numero de likes que tiene el producto.
    private int likes;   

    //Almacena la parte de la casa a la que pertenecen.
    private String parteCasa;

    //mapeo de las partes de la casa.
    private String[] mapeo;

    /**
     * Constructor de la clase Hogar.
     * @param id Se trata del identificador del producto.
     * @param name Se trata del nombre del producto.
     * @param precio Se trata del precio del producto.
     * @param parteCasa Se trata de la parte de la casa del producto.
     */
    public Hogar(int id, String name, Double Precio, String parteCasa)
    {
        super(id,name,Precio);
        mapeo = new String[5];
        mapeo[0] = "livingroom";
        mapeo[1] = "kitchen";
        mapeo[2] = "bedroom";
        mapeo[3] = "bathroom";
        mapeo[4] = "garden";
        if(comprobarParteCasa(parteCasa)){
            Precio = Precio - (Precio*0.05);
            this.likes = 0;
            this.parteCasa = parteCasa;
        }
        else{
            throw new IllegalArgumentException(" el nombre es incorrecto");
        }

    }

    /**
     * Metodo que devuelve el numero de likes del producto.
     * @return Numero de likes totales del producto.
     */
    @Override
    public int getLikes(){
        return this.likes;
    }

    /**
     *Metodo que suma uno el numero de likes del producto.   
     */
    @Override
    public void like(){
        this.likes++;
    }

    /**
     *Metodo que resta uno el numero de likes del producto.
     *Permite tener un numero negativo de likes.
     */
    @Override
    public void unlike(){ 
        this.likes--;
    }

    /**
     * Metodo que devuelve la parte de la casa.
     * @return parteCasa Se trata de la parte de la casa a la que pertenece el objeto.
     */
    public String getPcasa(){
        return this.parteCasa;    
    }

    /**
     * Metodo que comprueba la parte casa.
     * @return Devuelve "true" si pertenece al vector permitido, "false" si no pertenece.
     */
    public Boolean comprobarParteCasa(String parteCasa){
        for (int i = 0; i<5; i++){
            if(mapeo[i].equals(parteCasa)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodo que compara el actual objeto con otro objeto que se le pase por parametro.
     * @param p1 Producto de hogar que queremos comparar con el actual.
     */
    public int compareTo(Hogar p1)
    {
      return this.Precio.compareTo(p1.Precio);  
    }
    
    /**
     * Metodo que realiza toString.
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(' ');
        builder.append(getPcasa());
        builder.append(' ');
        return builder.toString();
    }

    /**
     * Hashcode 
     */
    @Override
    public int hashCode()
    {
        int result = 17;
        result = 37 * result +  ((Integer)getID()).hashCode();
        result = 37 * result +  getName().hashCode();
        result = 37 * result +  ((Double)getPrecio()).hashCode();
        result = 37 * result +  ((Integer)getLikes()).hashCode();
        result = 37 * result +  getPcasa().hashCode();
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
        if(!(obj instanceof Hogar)) {
            return false; //They have different types
        }
        Hogar other = (Hogar) obj;
        return ((Integer)getID()) == (other.getID()) &&
        getName().equals(other.getName()) && ((Double)getPrecio()) == other.getPrecio() && getLikes() == other.getLikes() && getPcasa().equals(other.getPcasa());

    }
}
