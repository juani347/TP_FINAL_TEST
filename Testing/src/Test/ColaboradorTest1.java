package Test;

import java.util.Date;

import modelo.Cliente;
import modelo.Colaborador;
import modelo.Servicio;

import modelo.Tarea;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

public class ColaboradorTest1
{
    ColaboradorTestFixture1 fixture1= new ColaboradorTestFixture1();
    public ColaboradorTest1()
    {
    }

    public static void main(String[] args)
    {
        String[] args2 = { ColaboradorTest1.class.getName() };
        JUnitCore.main(args2);
    }

    @Before
    public void setUp() throws Exception
    {
        this.fixture1.setUp();
    }

    @After
    public void tearDown() throws Exception
    {
        this.fixture1.tearDown();
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
            int size=this.fixture1.colab.getTareas().size();
            this.fixture1.colab.crearTarea(new Servicio("Limpiar","tipoA",52),new Cliente("Juan","juan@gmail.com","4324234","2121321312","123","grupo1"));
            assertTrue("No se agregó la tarea",size+1==this.fixture1.colab.getTareas().size());
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
            int size=this.fixture1.colab.getTareas().size();
            this.fixture1.colab.crearTarea(new Servicio("Limpiar","tipoA",52),new Cliente("Juan","juan@gmail.com","4324234","2121321312","123","grupo1"));
            assertTrue("No se agregó la tarea",size+1==this.fixture1.colab.getTareas().size());
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
            int size=this.fixture1.colab.getTareas().size();
            this.fixture1.colab.crearTarea(null,null);
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
    public void testEliminarTarea1()
    {
        try
        {
            int size=this.fixture1.colab.getTareas().size();
            this.fixture1.colab.eliminarTarea(this.fixture1.tareas.get(0));
            assertTrue("No se elimino la tarea",size-1==this.fixture1.colab.getTareas().size());
        }
        catch(final Exception e)
        {
            fail("Fallo inesperado");
        }
    }
    
    /**
     * @see modelo.Colaborador#eliminarTarea(modelo.Tarea)
     */
    @Test
    public void testEliminarTarea2()
    {
        try
        {
            //int size=this.fixture1.colab.getTareas().size();
            this.fixture1.colab.eliminarTarea(null);
            fail("No se verifica que la tarea sea null");
        }
        catch(final Exception e)
        {
            fail("Eliminar una tarea nula dispara excepcion");
        }
    }

    /**
     * @see modelo.Colaborador#cerrarTarea(modelo.Tarea)
     */
    @Test
    public void testCerrarTarea1()
    {
        try
        {
            this.fixture1.colab.cerrarTarea(this.fixture1.tareas.get(0));
            assertTrue("La tarea no fue cerrada",this.fixture1.colab.getTareas().get(fixture1.tareas.get(0).getCliente()).getEstado().devolverestado().equalsIgnoreCase("cerrada"));
        }
        catch(final Exception e)
        {
            fail("Error inesperado");
        }
    }
    
    /**
     * @see modelo.Colaborador#cerrarTarea(modelo.Tarea)
     */
    @Test
    public void testCerrarTarea2()
    {
        try
        {
            this.fixture1.colab.cerrarTarea(fixture1.tareas.get(3));
            fail("No se chequea que la tarea este cerrada");
        }
        catch(final Exception e)
        {
            fail("Se lanza excepcion pues se intenta cerrar una tarea cerrada");
        }
    }
    
    /**
     * @see modelo.Colaborador#cerrarTarea(modelo.Tarea)
     */
    @Test
    public void testCerrarTarea3()
    {
        try
        {
            this.fixture1.colab.cerrarTarea(null);
            fail("No se chequea que la tarea sea nula");
        }
        catch(final Exception e)
        {
            fail("Se lanza excepcion al cerrar una tarea null");
        }
    }
    
    /**
     * @see modelo.Colaborador#pausarTarea(modelo.Tarea)
     */
    @Test
    public void testPausarTarea1()
    {
        try
        {
            this.fixture1.colab.pausarTarea(this.fixture1.tareas.get(1));
            assertTrue("La tarea no esta pausada",this.fixture1.colab.getTareas().get(fixture1.tareas.get(1)).getEstado().devolverestado().equalsIgnoreCase("pausada"));
        }
        catch(final Exception e)
        {
            fail("No se verifica que este pausada");
        }
    }
    
    /**
     * @see modelo.Colaborador#pausarTarea(modelo.Tarea)
     */
    @Test
    public void testPausarTarea2()
    {
        try
        {
            this.fixture1.colab.pausarTarea(fixture1.tareas.get(2));
            fail("No se verifica que ya este pausada");
        }
        catch(final Exception e)
        {
            fail("Lanza excepcion al pausar una tarea ya pausada");
        }
    }
    
    /**
     * @see modelo.Colaborador#pausarTarea(modelo.Tarea)
     */
    @Test
    public void testPausarTarea3()
    {
        try
        {
            this.fixture1.colab.pausarTarea(fixture1.tareas.get(3));
            fail("No se verifica que este cerrada");
        }
        catch(final Exception e)
        {
            fail("Lanza excepcion al pausar una tarea cerrada");
        }
    }
    
    /**
     * @see modelo.Colaborador#pausarTarea(modelo.Tarea)
     */
    @Test
    public void testPausarTarea4()
    {
        try
        {
            this.fixture1.colab.pausarTarea(null);
            fail("No se verifica que la tarea sea nula");
        }
        catch(final Exception e)
        {
            fail("Lanza excepcion al pausar una tarea nula");
        }
    }

    /**
     * @see modelo.Colaborador#reanudarTarea(modelo.Tarea)
     */
    @Test
    public void testReanudarTarea1()
    {
        try
        {
            this.fixture1.colab.reanudarTarea(this.fixture1.tareas.get(0));
            fail("No se verifica si la tarea esta abierta");   
        }
        catch(final Exception e)
        {
            fail("Lanza excepcion al reanudar una tarea abierta");
        }
    }
    
    /**
     * @see modelo.Colaborador#reanudarTarea(modelo.Tarea)
     */
    @Test
    public void testReanudarTarea2()
    {
        try
        {
            this.fixture1.colab.reanudarTarea(this.fixture1.tareas.get(2));
            assertTrue("La tarea no se reanudo",this.fixture1.colab.getTareas().get(fixture1.tareas.get(2)).getEstado().devolverestado().equalsIgnoreCase("abierta"));
        }
        catch(final Exception e)
        {
            fail("Error inesperado");
        }
    }
    
    /**
     * @see modelo.Colaborador#reanudarTarea(modelo.Tarea)
     */
    @Test
    public void testReanudarTarea3()
    {
        try
        {
            this.fixture1.colab.reanudarTarea(fixture1.tareas.get(3));
            fail("No se verifica que la tarea este cerrada");
        }
        catch(final Exception e)
        {
            fail("Al abrir una tarea cerrada se lanza excepcion");
        }
    }
    
    /**
     * @see modelo.Colaborador#reanudarTarea(modelo.Tarea)
     */
    @Test
    public void testReanudarTarea4()
    {
        try
        {
            this.fixture1.colab.reanudarTarea(null);
            fail("No se verifica que la tarea sea nula");
        }
        catch(final Exception e)
        {
            fail("Al abrir una tarea nula se lanza excepcion");
        }
    }
    
    /**
     * @see modelo.Colaborador#solicitarITareasIntervalo(java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasIntervalo1()
    {
        try
        {
            Colaborador col1=this.fixture1.bdd.getColaboradores().get(0);
            Date d1= new Date(2018,10,1);
            Date d2= new Date(2018,10,30);
            long horas= (d2.getTime() - d1.getTime())/3600000;
            String resultado=col1.solicitarITareasIntervalo(d1, d2);
            String mensaje= /*"Cliente  |  Tarea de servicio  | Total horas\n" +*/ "Juan" + " " + "Limpiar" + " " + horas + "\n";
            assertEquals("Informe incorrecto",resultado,mensaje);
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
            Colaborador col1= new Colaborador("Peter","peter@gmail.com","111111111","111A","1234","Colaborador");
            Date d1= new Date(2018,10,1);
            Date d2= new Date(2018,10,20);
            long horas= (d2.getTime() - d1.getTime())/3600000;
            String resultado= col1.solicitarITareasIntervalo(d1, d2);
            //String mensaje= "Cliente  |  Tarea de servicio  | Total horas\n";
            String mensaje="";
            assertEquals("Informe incorrecto",resultado,mensaje);
        }
        catch( final Exception e )
        {
            fail("solicitarInformeColaboradorIntervalo dispara excepcion al utilizar un usuario no registrado");
        }
    }
    
    /**
     * @see modelo.Colaborador#solicitarITareasIntervalo(java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasIntervalo3()
    {
        try
        {
            Colaborador col1=this.fixture1.bdd.getColaboradores().get(0);
            Date d1= new Date(2018,9,1);
            Date d2= new Date(2018,10,20);
            long horas= (d2.getTime() - d1.getTime())/3600000;
            String resultado=col1.solicitarITareasIntervalo(d1, d2);
            //String mensaje= "Cliente  |  Tarea de servicio  | Total horas\n";
            String mensaje="";
            assertEquals("Informe incorrecto",resultado,mensaje);
        }
        catch( final Exception e )
        {
            fail("solicitarInformeColaboradorIntervalo dispara excepcion");
        }
    }
    
     /**
     * @see modelo.Colaborador#solicitarITareasIntervalo(java.util.Date,java.util.Date)
     *//*
    @Test
    public void testSolicitarITareasIntervalo4()
    {
        try
        {
            Colaborador col1= null;
            Date d1= new Date(2018,9,1);
            Date d2= new Date(2018,10,20);
            long horas= (d2.getTime() - d1.getTime())/3600000;
            String resultado=col1.solicitarITareasIntervalo(d1, d2);
            fail("No dispara excepcion por colaborador null");
        }
        catch( final Exception e )
        {
            fail("solicitarInformeColaboradorIntervalo no contempla colaborador null");
        }
    } */
    
    /**
     * @see modelo.Colaborador#solicitarITareasIntervalo(java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasIntervalo5()
    {
        try
        {
            Colaborador col1= new Colaborador("Peter","peter@gmail.com","111111111","111A","1234","Colaborador");
            Date d1= null;
            Date d2= null;
            long horas= (d2.getTime() - d1.getTime())/3600000;
            String resultado=col1.solicitarITareasIntervalo(d1, d2);
            fail("No dispara excepcion por fecha null");
        }
        catch( final Exception e )
        {
            fail("solicitarInformeColaboradorIntervalo no contempla fecha null");
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
            String resultado= fixture1.colab.solicitarITareasIntervaloCliente(c1, d1, d2);
            String mensaje=/* "Tarea de Servicio | Total horas  | Importe \n" + */"Investigar"+ " " + horas + " " + 5200 + "\n";
            assertEquals("Informe incorrecto",resultado,mensaje);
        }
        catch( final Exception e )
        {
            fail("solicitarInformeCliente dispara excepcion");
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
            Cliente c2= new Cliente("Adolfo","adolfo@gmail.com","345678","655432","4r3r21","grupo2");
            Date d1= new Date(2018,10,1);
            Date d2= new Date(2018,10,10);
            long horas= (d2.getTime() - d1.getTime())/3600000;
            double costo= (double) horas * 89;
            String resultado= this.fixture1.colab.solicitarITareasIntervaloCliente(c2, d1, d2);
            String mensaje= /*"Tarea de Servicio | Total horas  | Importe \n" +*/ "Pasear"+ " " + horas + " " + costo + "\n";
            assertEquals("Informe incorrecto",resultado,mensaje);
        }
        catch( final Exception e )
        {
            fail("solicitarInformeCliente dispara excepcion");
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
            Cliente c1= new Cliente("Peter","peter@gmail.com","4324234","2121321312","123","grupo1");
            Date d1= new Date(2018,10,1);
            Date d2= new Date(2018,10,20);
            String resultado= this.fixture1.colab.solicitarITareasIntervaloCliente(c1, d1, d2);
            //String mensaje= "Tarea de Servicio | Total horas  | Importe \n";
            String mensaje="";
            assertEquals("Informe incorrecto",resultado,mensaje);
        }
        catch( final Exception e )
        {
            fail("solicitarInformeCliente dispara excepcion");
        }
    }
    
    /**
     * @see modelo.Colaborador#solicitarITareasIntervaloCliente(modelo.Cliente,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasIntervaloCliente4()
    {
        try
        {
            Cliente c1=new Cliente("Lucrecia","Lucrecia@gmail.com","345234","434231","524455","grupo1");
            Date d1= new Date(2018,9,1);
            Date d2= new Date(2018,10,20);
            String resultado=this.fixture1.colab.solicitarITareasIntervaloCliente(c1, d1, d2);
            //String mensaje= "Tarea de Servicio | Total horas  | Importe \n";
            String mensaje="";
            assertEquals("Informe incorrecto",resultado,mensaje);
        }
        catch( final Exception e )
        {
            fail("solicitarInformeCliente dispara excepcion");
        }
    }
    
    /**
     * @see modelo.Colaborador#solicitarITareasIntervaloCliente(modelo.Cliente,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasIntervaloCliente5()
    {
        try
        {
            Cliente c1= null;
            Date d1= new Date(2018,10,1);
            Date d2= new Date(2018,10,20);
            String resultado=this.fixture1.colab.solicitarITareasIntervaloCliente(c1, d1, d2);
            fail("No dispara excepcion por cliente null");
        }
        catch( final Exception e )
        {
            fail("solicitarInformeCliente no contempla la excepcion cliente nulo");
        }
    }
    
    /**
     * @see modelo.Colaborador#solicitarITareasIntervaloCliente(modelo.Cliente,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasIntervaloCliente6()
    {
        try
        {
            Cliente c1= new Cliente("Juan","juan@gmail.com","4324234","2121321312","123","grupo1");
            Date d1= null;
            Date d2= null;
            long horas= (d2.getTime() - d1.getTime())/3600000;
            double costo= (double) horas * 89;
            String resultado= this.fixture1.colab.solicitarITareasIntervaloCliente(c1, d1, d2);
            fail("No dispara excepcion por fecha null");
        }
        catch( final Exception e )
        {
            fail("solicitarInformeCliente no contempla fechas nulas");
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
            String mensaje=this.fixture1.colab1.solicitarITareasEstadoIntervalo("cerrada", d1, d2);
            long horas=(d2.getTime()-d1.getTime())/3600000;
            resp+=this.fixture1.tareas.get(3).getCliente()+" "+fixture1.tareas.get(3).getServicio().getDescripcion()+" "+fixture1.tareas.get(3).getFechainicio()+" "+fixture1.tareas.get(3).getEstado().devolverestado()+" ";
            assertEquals("Informe incorrecto",resp,mensaje);
        }
        catch(final Exception e)
        {
            fail("SolicitarITareasEstadoIntervalo dispara excepción (error inesperado)");
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
            Colaborador col=new Colaborador();
            String resp = "Cliente  |  Tarea de Servicio  |  Inicio  |  Estado  |  Horas Acumuladas\n";
            Date d1= new Date(2018,10,1);
            Date d2= new Date(2018,10,20);
            String mensaje=col.solicitarITareasEstadoIntervalo("cerrada", d1, d2);
            long horas=(d2.getTime()-d1.getTime())/3600000;
            assertEquals("Informe incorrecto",resp,mensaje);
        }
        catch(final Exception e)
        {
            fail("SolicitarITareasEstadoIntervalo dispara excepción");
        }
    }
    
    /**
     * @see modelo.Colaborador#solicitarITareasEstadoIntervalo(String,java.util.Date,java.util.Date)
     */
    /* @Test
    public void testSolicitarITareasEstadoIntervalo3()
    {
        try
        {
            Colaborador col=null;
            String resp = "Cliente  |  Tarea de Servicio  |  Inicio  |  Estado  |  Horas Acumuladas\n";
            Date d1= new Date(2018,10,1);
            Date d2= new Date(2018,10,20);
            String mensaje=col.solicitarITareasEstadoIntervalo("cerrada", d1, d2);
            long horas=(d2.getTime()-d1.getTime())/3600000;
            fail("SolicitarITareasEstadoIntervalo no dispara excepcion");
        }
        catch(final Exception e)
        {
            fail("SolicitarITareasEstadoIntervalo dispara excepción");
        }
    } */
    
    /**
     * @see modelo.Colaborador#solicitarITareasEstadoIntervalo(String,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasEstadoIntervalo4()
    {
        try
        {
            String resp = "Cliente  |  Tarea de Servicio  |  Inicio  |  Estado  |  Horas Acumuladas\n";
            Date d1=null;
            Date d2=null;
            String mensaje=this.fixture1.colab1.solicitarITareasEstadoIntervalo("cerrada", d1, d2);
            long horas=(d2.getTime()-d1.getTime())/3600000;
            fail("SolicitarITareasEstadoIntervalo no dispara excepcion");
        }
        catch(final Exception e)
        {
            fail("SolicitarITareasEstadoIntervalo dispara excepción");
        }
    }
    
    /**
     * @see modelo.Colaborador#solicitarITareasEstadoIntervalo(String,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasEstadoIntervalo5()
    {
        try
        {
            String resp = "Cliente  |  Tarea de Servicio  |  Inicio  |  Estado  |  Horas Acumuladas\n";
            Date d1= new Date(2018,9,1);
            Date d2= new Date(2018,10,20);
            String mensaje=this.fixture1.colab1.solicitarITareasEstadoIntervalo("cerrada", d1, d2);
            long horas=(d2.getTime()-d1.getTime())/3600000;
            resp+=this.fixture1.tareas.get(3).getCliente()+" "+fixture1.tareas.get(3).getServicio().getDescripcion()+" "+fixture1.tareas.get(3).getFechainicio()+" "+fixture1.tareas.get(3).getEstado().devolverestado()+" ";
            assertEquals("Informe incorrecto",resp,mensaje);
        }
        catch(final Exception e)
        {
            fail("SolicitarITareasEstadoIntervalo dispara excepción (error inesperado)");
        }
    }
    
    /**
     * @see modelo.Colaborador#solicitarITareasEstadoIntervalo(String,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasEstadoIntervalo6()
    {
        try
        {
            String resp = "Cliente  |  Tarea de Servicio  |  Inicio  |  Estado  |  Horas Acumuladas\n";
            Date d1= new Date(2018,10,1);
            Date d2= new Date(2018,10,20);
            String mensaje=this.fixture1.colab1.solicitarITareasEstadoIntervalo("", d1, d2);
            long horas=(d2.getTime()-d1.getTime())/3600000;
            //resp+=this.fixture1.tareas.get(3).getCliente()+" "+fixture1.tareas.get(3).getServicio().getDescripcion()+" "+fixture1.tareas.get(3).getFechainicio()+" "+fixture1.tareas.get(3).getEstado().devolverestado()+" ";
            assertEquals("Informe incorrecto",resp,mensaje);
            fail("No lanza excepcion por estado vacio");
        }
        catch(final Exception e)
        {
            fail("SolicitarITareasEstadoIntervalo dispara excepción por estado vacio");
        }
    }
    
    /**
     * @see modelo.Colaborador#solicitarITareasEstadoIntervalo(String,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasEstadoIntervalo7()
    {
        try
        {
            String resp = "Cliente  |  Tarea de Servicio  |  Inicio  |  Estado  |  Horas Acumuladas\n";
            Date d1= new Date(2018,10,1);
            Date d2= new Date(2018,10,20);
            String mensaje=this.fixture1.colab1.solicitarITareasEstadoIntervalo(null, d1, d2);
            long horas=(d2.getTime()-d1.getTime())/3600000;
            //resp+=this.fixture1.tareas.get(3).getCliente()+" "+fixture1.tareas.get(3).getServicio().getDescripcion()+" "+fixture1.tareas.get(3).getFechainicio()+" "+fixture1.tareas.get(3).getEstado().devolverestado()+" ";
            assertEquals("Informe incorrecto",resp,mensaje);
            fail("No lanza excepcion por estado nulo");
        }
        catch(final Exception e)
        {
            fail("SolicitarITareasEstadoIntervalo dispara excepción por estado nulo");
        }
    }
    
    /**
     * @see modelo.Colaborador#solicitarITareasEnCurso()
     */
    @Test
    public void testSolicitarITareasEnCurso1()
    {
        try
        {
            Date d1= new Date(2018,10,20);
            Date d2= new Date(2018,10,1);
            long horas= (d2.getTime() - d1.getTime())/3600000;
            String resultado=this.fixture1.colab1.solicitarITareasEnCurso();
            Colaborador c1= fixture1.admin.getBdd().getColaboradores().get(0);
            String m1= "Pilar" + " " + "Watson" + " " + "Investigar" + " " + d1 + " " + "cerrada";
            String mensaje= " Colaborador   |   Cliente  | Servicio  | Inicio    | Estado    | Horas accumuladas | \n" + "" + "\n";
            assertEquals("Informe incorrecto",resultado,mensaje);
        }
        catch( final Exception e )
        {
            fail("solicitarTareasEnCursoColaboradores dispara excepcion");
        }
    }
}
