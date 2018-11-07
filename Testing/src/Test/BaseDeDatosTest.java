package Test;

import java.io.File;

import modelo.BaseDeDatos;

import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BaseDeDatosTest
{
    BaseDeDatosTestFixture1 fixture;

    public BaseDeDatosTest()
    {
    }

    @Before
    public void setUp() throws Exception
    {
        this.fixture.setUp();

    }

    @After
    public void tearDown() throws Exception
    {
    }

    /**
     * @see BaseDeDatos#serializarBDD()
     * Test Creacion de un archivo
     */
    @Test
    public void testSerializarBDD1()
    {
        try
        {
            this.fixture
                .bdd
                .serializarBDD();
            File archivo = new File(BaseDeDatos.nombreArchivo);
            Assert.assertTrue("Deberia existir el archivo ", archivo.exists());
        } catch (Exception e)
        {
            Assert.fail("No deberia lanzar excepcion: " + e.getMessage());
        }
    }

    /**
     * @see BaseDeDatos#deserializarBDD()
     * Test deserializar archivo vacio
     */
    @Test
    public void testDeserializarBDD()
    {
        try
        {
            this.fixture
                .bdd
                .serializarBDD1();
            BaseDeDatos bdd2 = this.fixture
                                   .bdd
                                   .deserializarBDD();
            Assert.assertEquals("La base de datos deben ser vacios", bdd2, this.fixture.bdd);
        } catch (Exception e)
        {
            Assert.fail("No deberia lanzar excepcion: " + e.getMessage());

        }
    }

    /**
     * @see BaseDeDatos#deserializarBDD()
     * Test deserializar archivo no existe
     */
    @Test
    public void testDeserializarBDD2()
    {
        try
        {
            this.fixture
                .bdd
                .deserializarBDD();
            Assert.fail("Deberia haber lanzado una excepcion de tipo FilaNotFound");
        } catch (Exception e)
        {
        }
    }
}
