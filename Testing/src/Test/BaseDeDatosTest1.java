package Test;

import java.io.File;

import modelo.BaseDeDatos;
import modelo.Cliente;
import modelo.Colaborador;
import modelo.Servicio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BaseDeDatosTest1 
{
    BaseDeDatos bdd;
    public BaseDeDatosTest1()
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
    @Test 
    public void testCrearArchivo()
    {
        this.bdd.serializarBDD();
        File archivo=new File(BaseDeDatos.nombreArchivo);
        Assert.assertTrue("Deberia existir el archivo ", archivo.exists());
        
        
    }
    @Test
    public void testBaseDeDatosVacioArchivo()
    {
        this.bdd.serializarBDD();
        BaseDeDatos bdd2=this.bdd.deserializarBDD();
        Assert.assertEquals("La base de datos deben ser vacios", bdd2, this.bdd);
    }
    @Test
    public void testBaseDeDatosCargados()
    {
        this.llevarBaseDeDatos(this.bdd);
        this.bdd.serializarBDD();
        BaseDeDatos bdd2=this.bdd.deserializarBDD();
        Assert.assertEquals("Las base de datos deberian estar cargadas con 3 Colaboradores/Clientes/Servicios", this.bdd, bdd2);
    }
    @Test
    public void tesDeserializarSinArchivo()
    {
        this.bdd.deserializarBDD();
        Assert.fail("Deberia haber lanzado una excepcion de tipo FilaNotFound");
    }
    private void llevarBaseDeDatos(BaseDeDatos bdd)
    {
        bdd.getColaboradores().add(new Colaborador("c3", "email", "telefono", "id", "contrasena","a"));
        bdd.getColaboradores().add(new Colaborador("c4", "email", "telefono", "id", "contrasena","a"));
        bdd.getColaboradores().add(new Colaborador("c5", "email", "telefono", "id", "contrasena","a"));
        
        bdd.getClientes().add(new Cliente("cl1","email","telefono","cuit","razonsocial","grupo"));
        bdd.getClientes().add(new Cliente("cl2","email","telefono","cuit","razonsocial","grupo"));
        bdd.getClientes().add(new Cliente("cl3","email","telefono","cuit","razonsocial","grupo"));
        
        bdd.getServicios().add(new Servicio("Barrer","Por hora",200));
        bdd.getServicios().add(new Servicio("Cambiar piso","Fijo",1200));
        bdd.getServicios().add(new Servicio("Mudanza","Fijo",2000));
    }
}
