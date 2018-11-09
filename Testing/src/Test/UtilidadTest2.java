package Test;

import modelo.Utilidad;

import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UtilidadTest2
{
    UtilidadTestFixture2 fixture;
    public UtilidadTest2()
    {
    }

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    /**
     * @see Utilidad#getUtilidad()
     * no null
     */
    @Test
    public void testGetUtilidad()
    {
        try{
        this.fixture.utilidad=Utilidad.getUtilidad();
                Assert.assertNotNull("Deberian ser distinto a null",this.fixture.utilidad);     
            }
        catch(Exception e){
        fail("Unimplemented");
        }
    }
}
