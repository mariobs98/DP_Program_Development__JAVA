import java.util.Comparator;
/** 
 * Nombre del grupo: 
 * Mario_y_Kike.
 * 
 * Nombre y Apellidos de cada alumno:
 * Mario Bermejo Sánchez.
 * Enrique Moreno Ávila.
 * 
 * Clase que maneja los productos de tipo Alimentacion.
 */
public class Alimentacion extends Product implements ProdConLikes
{
    //Almacena el numero de likes que tiene el producto.
    private int likes;

    //Almacena el mes de caducidad del producto.
    private String mesCaducidad;
    
    //Mapeo de los meses.
    private String[] mapeo;

    /**
     * Constructor de la clase Alimentacion.
     * @param id Se trata del identificador del producto.
     * @param name Se trata del nombre del producto.
     * @param precio Se trata del precio del producto
     * @param mesCaducidad Se trata del mes de caducidad del producto.
     */
    public Alimentacion(int id, String name, Double Precio,
    String mesCaducidad)
    {
        super(id,name,Precio);
        mapeo = new String[12];
        mapeo[0] = "January";
        mapeo[1] = "February";
        mapeo[2] = "March";
        mapeo[3] = "April";
        mapeo[4] = "May";
        mapeo[5] = "June";
        mapeo[6] = "July";
        mapeo[7] = "August";
        mapeo[8] = "September";
        mapeo[9] = "October";
        mapeo[10] = "November";
        mapeo[11] = "December";
        if(comprobarMes(mesCaducidad)){
            Precio = Precio - (Precio*0.1);
            this.likes = 0;
            this.mesCaducidad = mesCaducidad;
        }
        else{
            throw new IllegalArgumentException(" el mes es incorrecto");
        }        
    }

    /**
     * Devuelve el numero de likes del producto.
     * @return likes Numero de likes totales del producto.
     */
    @Override
    public int getLikes(){
        return this.likes;
    }

    /**
     *Suma uno el numero de likes del producto.   
     */
    @Override
    public void like(){
        this.likes++;
    }

    /**
     *Resta uno el numero de likes del producto.
     *Permite tener un numero negativo de likes.
     */
    @Override
    public void unlike(){ 
        this.likes--;
    }

    /**
     * Metodo modificado para que no se pueda realizar un comentario.
     */
    @Override
    public void realizarComentario(Comment coment){ 
    }

    /**
     * Metodo modificado para que no se pueda realizar un comentario.
     */
    @Override
    public int comentariosTotales(){
        //System.out.println("No es comentable");
        return 0;
    }

    /**
     * Metodo que devuelve el mes de caducidad de un producto.
     * @return mesCaducidad Se trata del mes de caducidad que tiene el producto actual.
     */
    public String getMesCaducidad()
    {
        return this.mesCaducidad;
    }
    
        public Boolean comprobarMes(String mesCaducidad){
        for (int i = 0; i<12; i++){
            if(mapeo[i].equals(mesCaducidad)){
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que sobreescribe toString.
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(getMesCaducidad());
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
        result = 37 * result +  ((Integer)getID()).hashCode();
        result = 37 * result +  getName().hashCode();
        result = 37 * result +  ((Double)getPrecio()).hashCode();
        result = 37 * result +  getMesCaducidad().hashCode();
        result = 37 * result +  ((Integer)getLikes()).hashCode();       
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
        if(!(obj instanceof Alimentacion)) {
            return false; //They have different types
        }
        Alimentacion other = (Alimentacion) obj;
        return ((Integer)getID()) == (other.getID()) &&
        getName().equals(other.getName()) && ((Double)getPrecio()) == other.getPrecio() && getMesCaducidad().equals(other.getMesCaducidad()) ;

    }
}
