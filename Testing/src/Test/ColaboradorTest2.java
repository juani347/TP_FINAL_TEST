package Test;

import java.util.Date;

import modelo.Cliente;
import modelo.Colaborador;
import modelo.Servicio;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

public class ColaboradorTest2
{
    ColaboradorTestFixture2 fixture2=new ColaboradorTestFixture2();
    public ColaboradorTest2()
    {
    }

    public static void main(String[] args)
    {
        String[] args2 = { ColaboradorTest2.class.getName() };
        JUnitCore.main(args2);
    }

    @Before
    public void setUp() throws Exception
    {
        this.fixture2.setUp();
    }

    @After
    public void tearDown() throws Exception
    {
        this.fixture2.tearDown();
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
      * @see modelo.Colaborador#crearTarea(modelo.Servicio,modelo.Cliente)
      */
     @Test
     public void testCrearTarea1()
     {
         try
         {
             int size=this.fixture2.colab.getTareas().size();
             this.fixture2.colab.crearTarea(new Servicio("Limpiar","tipoA",52),new Cliente("Juan","juan@gmail.com","4324234","2121321312","123","grupo1"));
             assertTrue("No se agregó la tarea",size+1==this.fixture2.colab.getTareas().size());
         }
         catch(final Exception e)
         {
             fail("Crear una tarea nueva dispara excepcion");
         }
     }
     
     /**
      * @see modelo.Colaborador#crearTarea(modelo.Servicio,modelo.Cliente)
      */
     @Test
     public void testCrearTarea2()
     {
         try
         {
             Colaborador col=null;
             col.crearTarea(new Servicio("Limpiar","tipoA",52),new Cliente("Fran","fran@gmail.com","1234234","2134536546","222","grupo3"));
             fail("Colaborador nulo no lanza excepción");
         }
         catch(final Exception e)
         {
             fail("Colaborador nulo lanza excepción");
         }
     }
     
     /**
      * @see modelo.Colaborador#crearTarea(modelo.Servicio,modelo.Cliente)
      */
     @Test
     public void testCrearTarea3()
     {
         try
         {
             int size=this.fixture2.colab.getTareas().size();
             this.fixture2.colab.crearTarea(new Servicio("Limpiar","tipoA",52),new Cliente("Juan","juan@gmail.com","4324234","2121321312","123","grupo1"));
             assertTrue("No se agregó la tarea",size+1==this.fixture2.colab.getTareas().size());
             fail("Se agrego una tarea repetida y no se disparo excepcion");
         }
         catch(final Exception e)
         {
             fail("Se agrego una tarea repetida y se disparo excepcion");
         }
     }

     /**
      * @see modelo.Colaborador#crearTarea(modelo.Servicio,modelo.Cliente)
      */
     @Test
     public void testCrearTarea4()
     {
         try
         {
             int size=this.fixture2.colab.getTareas().size();
             this.fixture2.colab.crearTarea(null,null);
             fail("Crear una tarea con contenido nulo no dispara excepcion");
         }
         catch(final Exception e)
         {
             fail("Crear una tarea con contenido nulo no dispara excepcion");
         }
     }
    
    /**
     * @see modelo.Colaborador#eliminarTarea(modelo.Tarea)
     */
    @Test
    public void testEliminarTarea()
    {
        try
        {
            this.fixture2.colab.eliminarTarea(null);
            fail("No se verifica que la tarea sea null");
        }
        catch(final Exception e)
        {
            fail("Se lanza excepcion por tarea null");
        }
    }

    /**
     * @see modelo.Colaborador#cerrarTarea(modelo.Tarea)
     */
    @Test
    public void testCerrarTarea()
    {
        fail("Unimplemented");
    }

    /**
     * @see modelo.Colaborador#pausarTarea(modelo.Tarea)
     */
    @Test
    public void testPausarTarea()
    {
        fail("Unimplemented");
    }

    /**
     * @see modelo.Colaborador#reanudarTarea(modelo.Tarea)
     */
    @Test
    public void testReanudarTarea()
    {
        fail("Unimplemented");
    }

    /**
     * @see modelo.Colaborador#solicitarITareasIntervalo(java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasIntervalo1()
    {
        try
        {
            Colaborador col1=this.fixture2.bdd.getColaboradores().get(0);
            Date d1= new Date(2018,10,1);
            Date d2= new Date(2018,10,30);
            long horas= (d2.getTime() - d1.getTime())/3600000;
            String resultado=col1.solicitarITareasIntervalo(d1, d2);
            String mensaje="";
            //String mensaje= /*"Cliente  |  Tarea de servicio  | Total horas\n" +*/ "Juan" + " " + "Limpiar" + " " + horas + "\n";
            assertEquals("Informe incorrecto",resultado,mensaje);
            fail("No lanza excepcion por lista vacia");
        }
        catch( final Exception e )
        {
            fail("solicitarInformeColaboradorIntervalo dispara excepcion");
        }
    }
    
    /**
     * @see modelo.Colaborador#solicitarITareasIntervalo(java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasIntervalo2()
    {
        try
        {
            Colaborador col1=this.fixture2.bdd.getColaboradores().get(0);
            Date d1=null;
            Date d2=null;
            long horas= (d2.getTime() - d1.getTime())/3600000;
            String resultado=col1.solicitarITareasIntervalo(d1, d2);
            String mensaje="";
            //String mensaje= /*"Cliente  |  Tarea de servicio  | Total horas\n" +*/ "Juan" + " " + "Limpiar" + " " + horas + "\n";
            assertEquals("Informe incorrecto",resultado,mensaje);
            fail("No lanza excepcion por lista vacia");
        }
        catch( final Exception e )
        {
            fail("solicitarInformeColaboradorIntervalo dispara excepcion por Dates nulos");
        }
    }

    /**
     * @see modelo.Colaborador#solicitarITareasIntervaloCliente(modelo.Cliente,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasIntervaloCliente1()
    {
        try
        {
            Cliente c1=new Cliente("Watson","Watson@gmail.com","34567","43902","52c52","grupo1");
            Date d1= new Date(2018,10,1);
            Date d2= new Date(2018,10,20);
            long horas= (d2.getTime() - d1.getTime())/3600000;
            String resultado= fixture2.colab.solicitarITareasIntervaloCliente(c1, d1, d2);
            String mensaje="";
            //String mensaje=/* "Tarea de Servicio | Total horas  | Importe \n" + */"Investigar"+ " " + horas + " " + 5200 + "\n";
            assertEquals("Informe incorrecto",resultado,mensaje);
            fail("No lanza excepcion por lista vacia");
        }
        catch( final Exception e )
        {
            fail("solicitarInformeCliente dispara excepcion (inesperado)");
        }
    }
    
    /**
     * @see modelo.Colaborador#solicitarITareasIntervaloCliente(modelo.Cliente,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasIntervaloCliente2()
    {
        try
        {
            Cliente c1=null;
            Date d1= new Date(2018,10,1);
            Date d2= new Date(2018,10,20);
            long horas= (d2.getTime() - d1.getTime())/3600000;
            String resultado= fixture2.colab.solicitarITareasIntervaloCliente(c1, d1, d2);
            String mensaje="";
            //String mensaje=/* "Tarea de Servicio | Total horas  | Importe \n" + */"Investigar"+ " " + horas + " " + 5200 + "\n";
            assertEquals("Informe incorrecto",resultado,mensaje);
            fail("No lanza excepcion por lista vacia");
        }
        catch( final Exception e )
        {
            fail("solicitarInformeCliente dispara excepcion por cliente nulo");
        }
    }
    
    /**
     * @see modelo.Colaborador#solicitarITareasIntervaloCliente(modelo.Cliente,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasIntervaloCliente3()
    {
        try
        {
            Cliente c1=new Cliente("Watson","Watson@gmail.com","34567","43902","52c52","grupo1");
            Date d1=null;
            Date d2=null;
            long horas= (d2.getTime() - d1.getTime())/3600000;
            String resultado= fixture2.colab.solicitarITareasIntervaloCliente(c1, d1, d2);
            String mensaje="";
            //String mensaje=/* "Tarea de Servicio | Total horas  | Importe \n" + */"Investigar"+ " " + horas + " " + 5200 + "\n";
            assertEquals("Informe incorrecto",resultado,mensaje);
            fail("No lanza excepcion por lista vacia");
        }
        catch( final Exception e )
        {
            fail("solicitarInformeCliente dispara excepcion por Dates nulos");
        }
    }

    /**
     * @see modelo.Colaborador#solicitarITareasEstadoIntervalo(String,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasEstadoIntervalo1()
    {
        try
        {
            String resp = "Cliente  |  Tarea de Servicio  |  Inicio  |  Estado  |  Horas Acumuladas\n";
            Date d1= new Date(2018,10,1);
            Date d2= new Date(2018,10,20);
            String mensaje=this.fixture2.colab.solicitarITareasEstadoIntervalo("cerrada", d1, d2);
            long horas=(d2.getTime()-d1.getTime())/3600000;
            //resp+=this.fixture2.tareas.get(3).getCliente()+" "+fixture2.tareas.get(3).getServicio().getDescripcion()+" "+fixture1.tareas.get(3).getFechainicio()+" "+fixture1.tareas.get(3).getEstado().devolverestado()+" ";
            assertEquals("Informe incorrecto",resp,mensaje);
            fail("No lanza excepcion por lista de tareas vacias");
        }
        catch(final Exception e)
        {
            fail("SolicitarITareasEstadoIntervalo dispara excepción por lista de tareas vacias");
        }
    }
    
    /**
     * @see modelo.Colaborador#solicitarITareasEstadoIntervalo(String,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasEstadoIntervalo2()
    {
        try
        {
            String resp = "Cliente  |  Tarea de Servicio  |  Inicio  |  Estado  |  Horas Acumuladas\n";
            Date d1=null;
            Date d2=null;
            String mensaje=this.fixture2.colab.solicitarITareasEstadoIntervalo("cerrada", d1, d2);
            long horas=(d2.getTime()-d1.getTime())/3600000;
            //resp+=this.fixture2.tareas.get(3).getCliente()+" "+fixture2.tareas.get(3).getServicio().getDescripcion()+" "+fixture1.tareas.get(3).getFechainicio()+" "+fixture1.tareas.get(3).getEstado().devolverestado()+" ";
            assertEquals("Informe incorrecto",resp,mensaje);
            fail("No lanza excepcion por lista de tareas vacias");
        }
        catch(final Exception e)
        {
            fail("SolicitarITareasEstadoIntervalo dispara excepción por lista de tareas vacias o Dates nulos");
        }
    }
    
    /**
     * @see modelo.Colaborador#solicitarITareasEstadoIntervalo(String,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasEstadoIntervalo3()
    {
        try
        {
            String resp = "Cliente  |  Tarea de Servicio  |  Inicio  |  Estado  |  Horas Acumuladas\n";
            Date d1= new Date(2018,10,1);
            Date d2= new Date(2018,10,20);
            String mensaje=this.fixture2.colab.solicitarITareasEstadoIntervalo("", d1, d2);
            long horas=(d2.getTime()-d1.getTime())/3600000;
            //resp+=this.fixture2.tareas.get(3).getCliente()+" "+fixture2.tareas.get(3).getServicio().getDescripcion()+" "+fixture1.tareas.get(3).getFechainicio()+" "+fixture1.tareas.get(3).getEstado().devolverestado()+" ";
            assertEquals("Informe incorrecto",resp,mensaje);
            fail("No lanza excepcion por lista de tareas vacias");
        }
        catch(final Exception e)
        {
            fail("SolicitarITareasEstadoIntervalo dispara excepción por lista de tareas vacias o estado vacio");
        }
    }

    /**
     * @see modelo.Colaborador#solicitarITareasEnCurso()
     */
    @Test
    public void testSolicitarITareasEnCurso()
    {
        fail("Unimplemented");
    }
}
