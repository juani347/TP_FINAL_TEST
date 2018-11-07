package Test;

import java.util.Date;

import modelo.Cliente;

import modelo.Colaborador;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AdministradorTest1
{
    AdministradorTestFixture1 fixture1= new AdministradorTestFixture1();
    
    public AdministradorTest1()
    {
    }

    @Before
    public void setUp() throws Exception
    {
        fixture1.setUp();
    }

    @After
    public void tearDown() throws Exception
    {
        fixture1.tearDown();
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {
    }

    /**
     * @see modelo.Administrador#solicitarInformeCliente(modelo.Cliente,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarInformeCliente1()
    {
        try
        {
            Cliente c1= new Cliente("Juan","juan@gmail.com","4324234","2121321312","123","grupo1");
            Date d1= new Date(2018,10,1);
            Date d2= new Date(2018,10,20);
            long horas= (d2.getTime() - d1.getTime())/3600000;
            String resultado= fixture1.admin.solicitarInformeCliente(c1, d1, d2);
            String mensaje= "Tarea de Servicio | Total horas  | Importe \n" + "Limpiar"+ " " + horas + " " + 100 + "\n";
            assertEquals("Informe incorrecto",resultado,mensaje);
        }
        catch( final Exception e )
        {
            fail("solicitarInformeCliente dispara excepcion");
        }
    }
    
    /**
     * @see modelo.Administrador#solicitarInformeCliente(modelo.Cliente,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarInformeCliente2()
    {
        try
        {
            Cliente c2= new Cliente("Fran","fran@gmail.com","1234234","2134536546","222","grupo1");
            Date d1= new Date(2018,10,1);
            Date d2= new Date(2018,10,10);
            long horas= (d2.getTime() - d1.getTime())/3600000;
            double costo= (double) horas * 25;
            String resultado= fixture1.admin.solicitarInformeCliente(c2, d1, d2);
            String mensaje= "Tarea de Servicio | Total horas  | Importe \n" + "Cocinar"+ " " + horas + " " + costo + "\n";
            assertEquals("Informe incorrecto",resultado,mensaje);
        }
        catch( final Exception e )
        {
            fail("solicitarInformeCliente dispara excepcion");
        }
    }
    
    /**
     * @see modelo.Administrador#solicitarInformeCliente(modelo.Cliente,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarInformeCliente3()
    {
        try
        {
            Cliente c3= new Cliente("Pedro","pedro@gmail.com","1124234","0123212","443","grupo2");
            Date d1= new Date(2018,11,1);
            Date d2= new Date();
            long horas= (d2.getTime() - d1.getTime())/3600000;
            double costo= (double) horas * 50;
            String resultado= fixture1.admin.solicitarInformeCliente(c3, d1, d2);
            String mensaje= "Tarea de Servicio | Total horas  | Importe \n" + "Cocinar"+ " " + horas + " " + costo + "\n";
            assertEquals("Informe incorrecto",resultado,mensaje);
        }
        catch( final Exception e )
        {
            fail("solicitarInformeCliente dispara excepcion");
        }
    }
    
    /**
     * @see modelo.Administrador#solicitarInformeCliente(modelo.Cliente,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarInformeCliente4()
    {
        try
        {
            Cliente c1= new Cliente("Peter","peter@gmail.com","4324234","2121321312","123","grupo1");
            Date d1= new Date(2018,10,1);
            Date d2= new Date(2018,10,20);
            String resultado= fixture1.admin.solicitarInformeCliente(c1, d1, d2);
            String mensaje= "Tarea de Servicio | Total horas  | Importe \n";
            assertEquals("Informe incorrecto",resultado,mensaje);
        }
        catch( final Exception e )
        {
            fail("solicitarInformeCliente dispara excepcion");
        }
    }
    
    /**
     * @see modelo.Administrador#solicitarInformeCliente(modelo.Cliente,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarInformeCliente5()
    {
        try
        {
            Cliente c1= new Cliente("Juan","juan@gmail.com","4324234","2121321312","123","grupo1");
            Date d1= new Date(2018,9,1);
            Date d2= new Date(2018,10,20);
            String resultado= fixture1.admin.solicitarInformeCliente(c1, d1, d2);
            String mensaje= "Tarea de Servicio | Total horas  | Importe \n";
            assertEquals("Informe incorrecto",resultado,mensaje);
        }
        catch( final Exception e )
        {
            fail("solicitarInformeCliente dispara excepcion");
        }
    }
    
    
    /**
     * @see modelo.Administrador#solicitarInformeCliente(modelo.Cliente,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarInformeCliente6()
    {
        try
        {
            Cliente c1= null;
            Date d1= new Date(2018,10,1);
            Date d2= new Date(2018,10,20);
            String resultado= fixture1.admin.solicitarInformeCliente(c1, d1, d2);
            fail("No dispara excepcion por cliente null");
        }
        catch( final Exception e )
        {
           // fail("solicitarInformeCliente no contempla la excepcion cliente nulo");
        }
    }
    
    /**
     * @see modelo.Administrador#solicitarInformeCliente(modelo.Cliente,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarInformeCliente7()
    {
        try
        {
            Cliente c1= new Cliente("Juan","juan@gmail.com","4324234","2121321312","123","grupo1");
            Date d1= null;
            Date d2= null;
            String resultado= fixture1.admin.solicitarInformeCliente(c1, d1, d2);
            fail("No dispara excepcion por fecha null");
        }
        catch( final Exception e )
        {
            //fail("solicitarInformeCliente no contempla fechas nulas");
        }
    }

    /**
     * @see modelo.Administrador#solicitarInformeColaboradorIntervalo(modelo.Colaborador,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarInformeColaboradorIntervalo1()
    {
        try
        {
            Colaborador col1= new Colaborador("Pilar","pili@gmail.com","111111111","111A","1234","Colaborador");
            Date d1= new Date(2018,10,1);
            Date d2= new Date(2018,10,30);
            long horas= (d2.getTime() - d1.getTime())/3600000;
            String resultado= fixture1.admin.solicitarInformeColaboradorIntervalo(col1, d1, d2);
            String mensaje= "Cliente  |  Tarea de servicio  | Total horas\n" + "Juan" + " " + "Limpiar" + " " + horas + "\n";
            assertEquals("Informe incorrecto",resultado,mensaje);
        }
        catch( final Exception e )
        {
            fail("solicitarInformeColaboradorIntervalo dispara excepcion");
        }
        
    }
    
    /**
     * @see modelo.Administrador#solicitarInformeColaboradorIntervalo(modelo.Colaborador,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarInformeColaboradorIntervalo2()
    {
        try
        {
            Colaborador col1= new Colaborador("Peter","peter@gmail.com","111111111","111A","1234","Colaborador");
            Date d1= new Date(2018,10,1);
            Date d2= new Date(2018,10,20);
            long horas= (d2.getTime() - d1.getTime())/3600000;
            String resultado= fixture1.admin.solicitarInformeColaboradorIntervalo(col1, d1, d2);
            String mensaje= "Cliente  |  Tarea de servicio  | Total horas\n";
            assertEquals("Informe incorrecto",resultado,mensaje);
        }
        catch( final Exception e )
        {
            fail("solicitarInformeColaboradorIntervalo dispara excepcion");
        }
    }
    
    /**
     * @see modelo.Administrador#solicitarInformeColaboradorIntervalo(modelo.Colaborador,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarInformeColaboradorIntervalo3()
    {
        try
        {
            Colaborador col1= new Colaborador("Pilar","pili@gmail.com","111111111","111A","1234","Colaborador");
            Date d1= new Date(2018,9,1);
            Date d2= new Date(2018,10,20);
            long horas= (d2.getTime() - d1.getTime())/3600000;
            String resultado= fixture1.admin.solicitarInformeColaboradorIntervalo(col1, d1, d2);
            String mensaje= "Cliente  |  Tarea de servicio  | Total horas\n";
            assertEquals("Informe incorrecto",resultado,mensaje);
        }
        catch( final Exception e )
        {
            fail("solicitarInformeColaboradorIntervalo dispara excepcion");
        }
    }
    
    /**
     * @see modelo.Administrador#solicitarInformeColaboradorIntervalo(modelo.Colaborador,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarInformeColaboradorIntervalo4()
    {
        try
        {
            Colaborador col1= null;
            Date d1= new Date(2018,9,1);
            Date d2= new Date(2018,10,20);
            long horas= (d2.getTime() - d1.getTime())/3600000;
            String resultado= fixture1.admin.solicitarInformeColaboradorIntervalo(col1, d1, d2);
            fail("No dispara excepcion por colaborador null");
        }
        catch( final Exception e )
        {
            //fail("solicitarInformeColaboradorIntervalo no contempla colaborador null");
        }
    }
    
    /**
     * @see modelo.Administrador#solicitarInformeColaboradorIntervalo(modelo.Colaborador,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarInformeColaboradorIntervalo5()
    {
        try
        {
            Colaborador col1= new Colaborador("Peter","peter@gmail.com","111111111","111A","1234","Colaborador");
            Date d1= null;
            Date d2= null;
            long horas= (d2.getTime() - d1.getTime())/3600000;
            String resultado= fixture1.admin.solicitarInformeColaboradorIntervalo(col1, d1, d2);
            fail("No dispara excepcion por fecha null");
        }
        catch( final Exception e )
        {
            //fail("solicitarInformeColaboradorIntervalo no contempla fecha null");
        }
    }
    

    /**
     * @see modelo.Administrador#solicitarTareasEnCursoColaboradores()
     */
    @Test
    public void testSolicitarTareasEnCursoColaboradores()
    {
        try
        {
            Date d1= new Date(2018,11,1);
            Date d2= new Date();
            long horas= (d2.getTime() - d1.getTime())/3600000;
            String resultado= fixture1.admin.solicitarTareasEnCursoColaboradores();
            String m1= "Guille" + " " + "Pedro" + " " + "Ordenar" + " " + d1 + " " + "abierta" + " " + horas + "\n";
            String mensaje= " Colaborador   |   Cliente  | Servicio  | Inicio    | Estado    | Horas accumuladas | \n" + m1;
            assertEquals("Informe incorrecto",resultado,mensaje);
        }
        catch( final Exception e )
        {
            fail("solicitarTareasEnCursoColaboradores dispara excepcion");
        }
    }
    

    /**
     * @see modelo.Administrador#crearCliente(String,String,String,String,String,String)
     */
    @Test
    public void testCrearCliente()
    {
        fail("Unimplemented");
    }

    /**
     * @see modelo.Administrador#crearServicio(String,String,int)
     */
    @Test
    public void testCrearServicio()
    {
        fail("Unimplemented");
    }

    /**
     * @see modelo.Administrador#crearColaborador(String,String,String,String,String,String)
     */
    @Test
    public void testCrearColaborador()
    {
        fail("Unimplemented");
    }

    /**
     * @see modelo.Administrador#eliminarCliente(modelo.Cliente)
     */
    @Test
    public void testEliminarCliente()
    {
        fail("Unimplemented");
    }

    /**
     * @see modelo.Administrador#eliminarServicio(modelo.Servicio)
     */
    @Test
    public void testEliminarServicio()
    {
        fail("Unimplemented");
    }

    /**
     * @see modelo.Administrador#eliminarColaborador(modelo.Colaborador)
     */
    @Test
    public void testEliminarColaborador()
    {
        fail("Unimplemented");
    }

    /**
     * @see modelo.Administrador#crearTarea(modelo.Servicio,modelo.Cliente,modelo.Colaborador)
     */
    @Test
    public void testCrearTarea()
    {
        fail("Unimplemented");
    }

    /**
     * @see modelo.Administrador#eliminarTarea(modelo.Tarea,modelo.Colaborador)
     */
    @Test
    public void testEliminarTarea()
    {
        fail("Unimplemented");
    }

    /**
     * @see modelo.Administrador#cerrarTarea(modelo.Tarea,modelo.Colaborador)
     */
    @Test
    public void testCerrarTarea()
    {
        fail("Unimplemented");
    }

    /**
     * @see modelo.Administrador#pausarTarea(modelo.Tarea,modelo.Colaborador)
     */
    @Test
    public void testPausarTarea()
    {
        fail("Unimplemented");
    }

    /**
     * @see modelo.Administrador#reanudarTarea(modelo.Tarea,modelo.Colaborador)
     */
    @Test
    public void testReanudarTarea()
    {
        fail("Unimplemented");
    }
}
