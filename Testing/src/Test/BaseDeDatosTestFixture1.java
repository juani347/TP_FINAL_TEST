package Test;

import java.io.File;

import modelo.BaseDeDatos;

import org.junit.Before;

public class BaseDeDatosTestFixture1
{
    BaseDeDatos bdd;
    public BaseDeDatosTestFixture1()
    {
        super();
    }

    @Before 
    public void setUp() 
    {
        this.bdd= new BaseDeDatos();
        File archivo = new File(BaseDeDatos.nombreArchivo);
        if (archivo.exists())
            archivo.delete();
    }
    
}
