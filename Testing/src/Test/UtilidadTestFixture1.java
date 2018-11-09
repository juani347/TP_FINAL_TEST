package Test;

import modelo.Utilidad;

public class UtilidadTestFixture1
{
    Utilidad utilidad;
    public UtilidadTestFixture1()
    {
    }

    public void setUp()
    {
        this.utilidad=Utilidad.getUtilidad();
    }

    public void tearDown()
    {
    }
}
