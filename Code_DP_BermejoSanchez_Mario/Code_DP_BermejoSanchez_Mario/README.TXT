
Somos Enrique Moreno Ávila y Mario Bermejo Sánchez, y vamos a hacer un pequeño resumen acerca de que hemos hecho en el proyecto.

// TEXTO_EC1:
// Como se puede ver el proyecto se compone de 5 clases, StockDemo, Product, Client, Comment y StockManager, además de sus respectivas pruebas.

// -Stockdemo: Contiene todas aquellos modulos que permitirán hacer un funcionamiento similar a una tienda, pero sin tener que meter ningún parametro por teclado. 
// Así, tenemos el demoEC1, en el que hemos realizado unas pruebas como si fuese una tienda normal y corriente, cabe decir que estas se nos han ocurrido a nosotros, 
// y por otra parte tenemos demoGameDP, que es un modulo con las pruebas propuestas por los profesores para comprobar que sin meter ningún parámetro por teclado el proyecto puede realizar todas las funciones propuestas.
// Los demás módulos estaban desde un principio para mostrarnos como eran unas pequeñas pruebas.

// -Product: Esta clase contiene todos aquellos detalles que debería contener un producto. 
// Esta clase tiene varios métodos, desde devolver el id, el nombre del producto, la cantidad en stock y la cantidad mínima, hasta mostrar los detalles de un producto, 
// seleccionar una cantidad mínima de stock que debería haber en una tienda, incrementar la cantidad en stock de la tienda, vender un producto o varios y realizar un comentario sobre ese producto.

// -Client: Esta clase se caracteriza por interpretar un cliente, y sus datos, en una tienda. 
// Esta clase contiene varios métodos, como puede ser, devolver el nombre del cliente, el id, la edad, la localidad, y la tienda a la que están asociados sus datos. 
// Incluso, contiene métodos de añadir productos favoritos a una lista de favoritos, buscarlos en dicha lista o borrarlos de la lista. También se puede hacer un pedido de un producto favorito indicando cuanta cantidad quiere,
// o pedir la cantidad de uno de todos los productos favoritos, y por último, realizar un comentario de un producto.

// -Comment: En esta clase se crean los datos de aquellos comentarios que realizan los clientes de una tienda sobre un producto.
// Cabe decir que esta clase es muy simple, ya que solo contiene métodos para devolver el nombre del cliente, la valoración del producto y su comentario.
// Por supuesto, está contemplado el caso de que si un cliente pone menos de 1 en la valoración se valorará como 1, y si sobrepasa el 5, se asociará a un 5.

// -Stockmanager: En esta clase se simula las accciones que realiza una tienda. 
// Podemos ver, que tenemos funciones tales como añadir un producto, aumentar la cantidad de stock de un producto que hay en la tienda, 
// buscar si existe un producto en la tienda, saber el número de stock de productos que hay en la tienda, imprimir los detalles de un producto de la tienda, 
// vender un producto sin ser favorito de ningún cliente o venderle a un cliente uno o varios productos de sus favoritos, reponer el stock de un producto en caso de que se supere la cantidad mínima, y realizar un comentario de un producto.

// Estas son todas las clases que hemos empleado para realizar esta primera entrega del proyecto, y podemos decir que no ha resultado muy costoso gracias a la ayuda de los profesores por sus conocimientos impartidos, sin embargo, podemos aportar que BlueJ tiene algunos bugs como no poder poner tildes.

TEXTO_EC2:
La clase principal para la simular los datos es CargarDatos, con lo la cual simplemente solo hay que hacer un new de CargarDatos, es decir, instanciarla,y con esto conseguimos tanto leer el fichero init.txt
como escribir el fichero registro.log.txt con la simulacion realizada.
En stockDemo tenemos una pequeña prueba para comprobar el funcionamiento del proyecto, hemos hecho tres objetos de productos distintos, y creamos dos clientes, standard y vip, y con esto procedemos a la 
simulacion de un par de ventas y la realizacion de un par de comentarios.
El programa ha mejorado gracias a sus actualizaciones, pero las pruebas dejan cosas que desear, ya que generan fallos donde no los hay y de hecho no borra algunos objetos y los sigue dejando en memoria
lo que provoca el mal funcionamiento de algunos objetos si se vuelven a crear. De hecho, si realizamos las pruebas de un objeto en especifico, y no compilamos otra vez antes de hacer otras pruebas o ejecutamos
CargarDatos, este lo hace mal porque supone que esos objetos ya estan creados.
