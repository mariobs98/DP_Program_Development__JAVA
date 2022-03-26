
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CommentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CommentTest
{
    /**
     * Default constructor for test class CommentTest
     */
    public CommentTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {    
    
    }
        @Test
    public void CrearCommentPrueba()
    {    
     Comment comentario = new Comment(2,"pepe", "muy malo");
     Comment comentario2 = new Comment(4,"marisa", "bueno");
     
     assertEquals("muy malo", comentario.getComentario());
     assertEquals("pepe", comentario.getNombreCliente());
     assertEquals(2, comentario.getPuntuacion());
    
          assertEquals("bueno", comentario2.getComentario());
     assertEquals("marisa", comentario2.getNombreCliente());
     assertEquals(4, comentario2.getPuntuacion());

    }
    
            @Test
    public void getPuntuacionPrueba()
    {    
     Comment comentario = new Comment(2,"pepe", "muy malo");
     Comment comentario2 = new Comment(4,"marisa", "bueno");
    assertEquals(2, comentario.getPuntuacion());
     assertEquals(4, comentario2.getPuntuacion());

    }
           
                @Test
    public void getNombreClientePrueba()
    {    
     Comment comentario = new Comment(2,"pepe", "muy malo");
     Comment comentario2 = new Comment(4,"marisa", "bueno");
assertEquals("marisa", comentario2.getNombreCliente());

      assertEquals("pepe", comentario.getNombreCliente());

    }
                @Test
    public void getComentarioPrueba()
    {    
     Comment comentario = new Comment(2,"pepe", "muy malo");
     Comment comentario2 = new Comment(4,"marisa", "bueno");
    assertEquals("muy malo", comentario.getComentario());
     assertEquals("bueno", comentario2.getComentario());

    }
    
        @Test
    public void ToStringPrueba(){
     Comment comentario = new Comment(2,"pepe", "muy malo");
     Comment comentario2 = new Comment(4,"marisa", "bueno");
        comentario.toString();
        comentario2.toString();
    }

}

