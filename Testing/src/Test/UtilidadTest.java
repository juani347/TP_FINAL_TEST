package Test;

import modelo.Utilidad;

import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class UtilidadTest
{
    UtilidadTestFixture1 fixture;
    public UtilidadTest()
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
     * @see modelo.Utilidad#getInstance()
     * Probando con una intancia existente
     */
    @Test
    public void getUtilidad()
    {
        try{
        Utilidad utilidad=Utilidad.getUtilidad();
                Assert.assertEquals("Deberian ser igualies las intancias utilidad",utilidad,this.fixture.utilidad);     
            }
        catch(Exception e){
        fail("Unimplemented");
        }
    }
}
