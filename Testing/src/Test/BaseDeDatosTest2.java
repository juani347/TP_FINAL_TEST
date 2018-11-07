package Test;

import modelo.BaseDeDatos;

import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BaseDeDatosTest2
{
    BaseDeDatosTestFixture2 fixture;
    public BaseDeDatosTest2()
    {
    }

    @Before
    public void setUp() throws Exception
    {
        fixture.setUp();
    }

    @After
    public void tearDown() throws Exception
    {
    }

    /**
     * @see BaseDeDatos#deserializarBDD()
     */
    @Test
    public void testDeserializarBDD()
    {
        try{
        this.fixture.setUp();
        this.fixture.bdd.serializarBDD();
        BaseDeDatos bdd2=this.fixture.bdd.deserializarBDD();
        Assert.assertEquals("Las base de datos deberian estar cargadas con 3 Colaboradores/Clientes/Servicios", this.fixture.bdd, bdd2);
        }
        catch(Exception e)
        {
        Assert.fail("No deberia lanzar excepcion: "+e.getMessage());
        }
    }

    /**
     * @see BaseDeDatos#serializarBDD()
     */
    @Test
    public void testSerializarBDD()
    {
        fail("Unimplemented");
    }
}
