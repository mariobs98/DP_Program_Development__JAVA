import java.util.*;
import java.io.*;
import java.nio.*;                
/** 
 * Nombre del grupo: 
 * Mario_y_Kike
 * 
 * Nombre y Apellidos de cada alumno:
 * Mario Bermejo Sánchez
 * Enrique Moreno Ávila
 * 
 * Esta clase ha sido creada para que se escriba todas las operaciones en un fichero, segun una serie de operaciones.
 */
public class CargarDatos
{

    private ArrayList<String> Fichero;  

    private static final String nomFich = "init.txt";
    public static final int MAXCAMPOS  = 10; 

    private String[] mapeo;

    private StockManager stockmanager;

    /**
     * Constructor para los objetos de CargarDatos.
     */
    public CargarDatos()
    {
        Fichero = new ArrayList<String>();
        mapeo = new String[7];
        mapeo[0] = "STOCKMANAGER";
        mapeo[1] = "PRODUCTENTERTAINMENT";
        mapeo[2] = "PRODUCTHOME";
        mapeo[3] = "PRODUCTFOOD";
        mapeo[4] = "CLIENTSTANDARD";
        mapeo[5] = "CLIENTVIP";
        mapeo[6] = "PRODUCTCLIENT";

        LeerFichero();
        escribirRegistroLog();

    }

    /**
     * Metodo que se encarga de ir leyendo el fichero para inicializar los objetos.
     */
    public void LeerFichero(){
        //lectura de fichero
        try (BufferedReader br = new BufferedReader(new FileReader(nomFich))){
            String sCurrentLine;
            int posDato;
            int numCampos = 0;

            //Elimino primero las 14 primeras lienas de informacion  
            for(int i = 0; i<14; i++){
                sCurrentLine = br.readLine();
            }
            //Ahora alamcenamos los datos importantes para crear instancias
            while ((sCurrentLine = br.readLine()) != null) {
                if (!sCurrentLine.startsWith("--"))  {
                    Fichero.clear();
                    numCampos = trocearLinea(sCurrentLine, Fichero);
                    posDato = comprobarMapeo(Fichero.get(0));
                    crear(posDato, numCampos, Fichero);
                }
            }

        }catch (IOException e) {
            e.printStackTrace();
        }//FinTry
    }

    /**
     * Metodo para trocear cada línea y separarla por campos.
     * @param sCurrentLine Se trata de la cadena con la línea completa leída.
     * @param Fichero Se trata del Array de String que contiene en cada posición un campo distinto.
     * @return numCampos. Se trata del número campos encontrados.
     */
    private static int trocearLinea(String sCurrentLine,List<String> Fichero) {
        boolean eol = false;
        int pos=0,posini=0, numCampos=0;

        while (!eol) {
            pos = sCurrentLine.indexOf("#");
            if(pos!=-1) {
                Fichero.add(new String(sCurrentLine.substring(posini,pos)));
                sCurrentLine = sCurrentLine.substring(pos+1, sCurrentLine.length());
                numCampos++;
            }
            else eol = true;
        }
        return numCampos;
    }

    /**
     * Metodo que se encarga de comprobar el mapeo segun el tipo de dato introducido.
     * @param tipoDato Se trata del tipo de dato del que se quiere realizar el mapeo.
     * @return posicionDato Se trata de la posicion del dato donde se ha realizado el mapeo.
     */
    private int comprobarMapeo(String tipoDato){
        int posicionDato = -1;
        boolean enc=false;  
        for (int i = 0; i<7 && !enc; i++){
            if(mapeo[i].equals(tipoDato)){
                posicionDato = i;
                enc = true;
            }
        }       
        return posicionDato;
    }

    /**
     * Metodo que segun la posicion dada se crea un tipo de objeto.
     * @param posDato Se trata de la posicion del dato que queremos crear. 
     * @param numCampos. Se trata del número campos encontrados.
     * @param Fichero Se trata del Array de String que contiene en cada posición un campo distinto.
     */
    private void crear(int posDato, int numCampos, List<String> Fichero){

        switch(posDato){
            case 0:    
            crearStockManager(Fichero);
            break;
            case 1:
            crearEntertainmentProduct(numCampos,Fichero);
            break;
            case 2:
            crearHomeProduct(numCampos,Fichero);
            break;
            case 3:
            crearFoodProduct(numCampos,Fichero);
            break;
            case 4:
            crearStandardClient(numCampos,Fichero);
            break;
            case 5:
            crearVipClient(numCampos,Fichero);
            break;
            case 6:
            anadirFavProductClient(numCampos,Fichero);
            break;
            case 7:
            //crearComment(numCampos,Fichero);
            break;
        }
    }

    /**
     *  Método que crea una instancia de la clase StockManager.
     *  @param numCampos número de atributos que tendrá la instancia.
     *  @param vCampos array que contiene los valores de cada atributo.
     */
    private void crearStockManager(List<String> Fichero){
        System.out.println("Creado StockManager: " + Fichero.get(1) + "\n");
        //inicializar StockManager, cambiar por patron Singleton
        stockmanager = StockManager.getInstance();
    }

    /**
     *  Método que crea una instancia de la clase EntertainmentProduct.
     *  @param numCampos número de atributos que tendrá la instancia.
     *  @param vCampos array que contiene los valores de cada atributo.
     */
    private void crearEntertainmentProduct(int numCampos, List<String> Fichero){
        System.out.println("Creado EntertainmentProduct: " + Fichero.get(2) + "\n");
        //inicializar EntertainmentProduct
        Product product = new Ocio(Integer.parseInt(Fichero.get(1)),
                Fichero.get(2), Double.parseDouble(Fichero.get(5)));
        product.setCantidadMinima(Integer.parseInt(Fichero.get(4)));
        stockmanager.addProduct(product);
        stockmanager.delivery(Integer.parseInt(Fichero.get(1)), 
            Integer.parseInt(Fichero.get(3)));
    }

    /**
     *  Método que crea una instancia de la clase HomeProduct.
     *  @param numCampos número de atributos que tendrá la instancia.
     *  @param vCampos array que contiene los valores de cada atributo.
     */
    private void crearHomeProduct(int numCampos, List<String> Fichero){
        System.out.println("Creado HomeProduct: " + Fichero.get(2) + "\n");
        //inicializar HomeProduct
        Product product = new Hogar(Integer.parseInt(Fichero.get(1)),
                Fichero.get(2), Double.parseDouble(Fichero.get(5)), Fichero.get(6));
        product.setCantidadMinima(Integer.parseInt(Fichero.get(4)));
        stockmanager.addProduct(product);
        stockmanager.delivery(Integer.parseInt(Fichero.get(1)), 
            Integer.parseInt(Fichero.get(3)));
    }

    /**
     *  Método que crea una instancia de la clase FoodProduct.
     *  @param numCampos número de atributos que tendrá la instancia.
     *  @param vCampos array que contiene los valores de cada atributo.
     */
    private void crearFoodProduct(int numCampos, List<String> Fichero){
        System.out.println("Creado FoodProduct: " + Fichero.get(2) + "\n");
        //inicializar FoodProduct
        Product product = new Alimentacion(Integer.parseInt(Fichero.get(1)),
                Fichero.get(2), Double.parseDouble(Fichero.get(5)), Fichero.get(6));
        product.setCantidadMinima(Integer.parseInt(Fichero.get(4)));
        stockmanager.addProduct(product);
        stockmanager.delivery(Integer.parseInt(Fichero.get(1)), 
            Integer.parseInt(Fichero.get(3)));
    }

    /**
     *  Método que crea una instancia de la clase StandardClient.
     *  @param numCampos número de atributos que tendrá la instancia.
     *  @param vCampos array que contiene los valores de cada atributo.
     */
    private void crearStandardClient(int numCampos, List<String> Fichero){
        System.out.println("Creado StandardClient: " + Fichero.get(2) + "\n");
        //inicializar StandardClient
        Cliente_Estandar client = new Cliente_Estandar(Fichero.get(2),
                Integer.parseInt(Fichero.get(1)), Integer.parseInt(Fichero.get(3)), Fichero.get(4));
        stockmanager.addCliente(client);
    }

    /**
     *  Método que crea una instancia de la clase VipClient.
     *  @param numCampos número de atributos que tendrá la instancia.
     *  @param vCampos array que contiene los valores de cada atributo.
     */
    private void crearVipClient(int numCampos, List<String> Fichero){
        System.out.println("Creado VipClient: " + Fichero.get(2) + "\n");
        //inicializar VipClient
        Cliente_Vip client = new Cliente_Vip(Fichero.get(2),
                Integer.parseInt(Fichero.get(1)), Integer.parseInt(Fichero.get(3)), Fichero.get(4));
        stockmanager.addCliente(client);
    }

    /**
     *  Método que asocia una instancia de la clase Product a una de la clase Client.
     *  @param numCampos número de atributos que tendrá la instancia.
     *  @param vCampos array que contiene los valores de cada atributo.
     */
    private void anadirFavProductClient(int numCampos, List<String> Fichero){
        System.out.println("Leido ProductClient: " + Fichero.get(3) + "\n");
        Product p = stockmanager.findProduct(Integer.parseInt(Fichero.get(2)));
        Client c = stockmanager.GetCliente(Integer.parseInt(Fichero.get(1)));
        c.AñadirProdFav(Integer.parseInt(Fichero.get(2)), Fichero.get(3));
    }  

    /**
     * Metodo que se encarga realmente de grabar todas las operaciones en el fichero.
     */
    private void escribirRegistroLog(){
        Client c = null;
        Product p = null;
        Comment com = null;
        try (FileWriter writer = new FileWriter("registro.log.txt")){
            //Linea para escribir en registro.log
            String linea = ""; int turnos = 10; int cliente; int numClientes = stockmanager.DevolverNumeroClientes(); int mod;

            for(int i = 1; i <= turnos ; i++){
                if(i > numClientes){ 
                    mod = i % numClientes ;
                }else{
                    if(i == numClientes){
                        mod = numClientes; 
                    }else{
                        mod = i % numClientes ; 
                    }
                }

                linea = "TURN: "+ i +"----------------------------------------------------------------------------------------\n";
                writer.write(linea);

                c = stockmanager.GetCliente(mod);
                writer.write(c.toString());
                writer.write('\n');
                c.PrepararPedido();
                for(int j = 0; j<c.ProductosVenta.size(); j++){
                    p = c.getProductoPVentas(j);
                    writer.write(p.toString());
                    writer.write('\n');
                }
                c.realizarPedido(writer);
            }

            stockmanager.productosVendidos(writer);
            writer.write('\n');
            writer.write('\n');
            writer.write('\n');
            linea = "mostSoldProduct:" + "\n";
            writer.write(linea);

            p = stockmanager.productoMasVendido();
            writer.write(p.toString());
            writer.write('\n');

            linea = "mostCommentedProduct:" + "\n";
            writer.write(linea);

            p = stockmanager.MasComentarios();
            writer.write(p.toString());
            writer.write('\n');

            linea = "clientWhoSpentMore:" + "\n";
            writer.write(linea);

            c = stockmanager.clienteMasDineroGastado();
            writer.write(c.toString());
            writer.write('\n');

            linea = "END OF SIMULATION"+"\n";
            writer.write(linea);

        }catch (Exception ex) {
            System.out.println("Mensaje de la excepción: " + ex.getMessage());
        }
    }
}
