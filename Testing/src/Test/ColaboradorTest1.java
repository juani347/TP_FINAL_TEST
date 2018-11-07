package Test;

import modelo.Cliente;
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
            assertTrue(size+1==this.fixture1.colab.getTareas().size());
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
            int size=this.fixture1.colab.getTareas().size();
            this.fixture1.colab.crearTarea(new Servicio("Limpiar","tipoA",52),new Cliente("Fran","fran@gmail.com","1234234","2134536546","222","grupo3"));
            assertTrue(size+1==this.fixture1.colab.getTareas().size());
        }
        catch(final Exception e)
        {
            fail("Crear una tarea existente dispara excepcion");
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
            this.fixture1.colab.crearTarea(new Servicio("Cocinar","tipoA",100),new Cliente("Juan","juan@gmail.com","4324234","2121321312","123","grupo1"));
            assertTrue(size+1==this.fixture1.colab.getTareas().size());
        }
        catch(final Exception e)
        {
            fail("Crear una tarea con un cliente atendido en otra tarea dispara excepcion");
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
            this.fixture1.colab.crearTarea(new Servicio("Cocinar","tipoA",100),new Cliente("Nico","nico@gmail.com","54354234","12111112","333","grupo2"));
            assertTrue(size+1==this.fixture1.colab.getTareas().size());   
        }
        catch(final Exception e)
        {
            fail("Crear una tarea existente dispara excepcion");
        }
    }
    
    /**
     * @see modelo.Colaborador#crearTarea(modelo.Servicio,modelo.Cliente)
     */
    @Test
    public void testCrearTarea5()
    {
        try
        {
            int size=this.fixture1.colab.getTareas().size();
            this.fixture1.colab.crearTarea(null,null);
            assertTrue(size+1==this.fixture1.colab.getTareas().size());   
        }
        catch(final Exception e)
        {
            fail("Crear una tarea nula dispara excepcion");
        }
    }
    
    /**
     * @see modelo.Colaborador#crearTarea(modelo.Servicio,modelo.Cliente)
     */
    @Test
    public void testCrearTarea6()
    {
        try
        {
            int size=this.fixture1.colab.getTareas().size();
            this.fixture1.colab.crearTarea(new Servicio("Barrer","tipoA",150),new Cliente("Fran","fran@gmail.com","1234234","2134536546","222","grupo3"));
            assertTrue(size+1==this.fixture1.colab.getTareas().size());   
        }
        catch(final Exception e)
        {
            fail("Crear una tarea repetida y con un cliente atendido en otra tarea dispara excepcion");
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
            assertTrue(size-1==this.fixture1.colab.getTareas().size());
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
            int size=this.fixture1.colab.getTareas().size();
            this.fixture1.colab.eliminarTarea(this.fixture1.tareas.get(0));
            assertTrue(size-1==this.fixture1.colab.getTareas().size());
            
        }
        catch(final Exception e)
        {
            fail("No se verifica que se quite una tarea eliminada previamente");
        }
    }
    
    /**
     * @see modelo.Colaborador#eliminarTarea(modelo.Tarea)
     */
    @Test
    public void testEliminarTarea3()
    {
        try
        {
            int size=this.fixture1.colab.getTareas().size();
            this.fixture1.colab.eliminarTarea(null);
            assertTrue(size-1==this.fixture1.colab.getTareas().size());
            
        }
        catch(final Exception e)
        {
            fail("No se verifica que la tarea sea null");
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
            assertTrue("La tarea no fue cerrada",this.fixture1.colab.getTareas().get(fixture1.tareas.get(3).getCliente()).getEstado().devolverestado().equalsIgnoreCase("cerrada"));
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
            assertTrue("La tarea no fue cerrada",this.fixture1.colab.getTareas().get(null).getEstado().devolverestado().equalsIgnoreCase("cerrada"));
        }
        catch(final Exception e)
        {
            fail("No se chequea que la tarea sea nula");
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
            assertTrue("La tarea no esta pausada",this.fixture1.colab.getTareas().get(fixture1.tareas.get(2)).getEstado().devolverestado().equalsIgnoreCase("pausada"));
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
            assertTrue("La tarea no esta pausada",this.fixture1.colab.getTareas().get(fixture1.tareas.get(3)).getEstado().devolverestado().equalsIgnoreCase("pausada"));
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
            assertTrue("La tarea no se reanudo",this.fixture1.colab.getTareas().get(fixture1.tareas.get(0)).getEstado().devolverestado().equalsIgnoreCase("abierta"));
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
            assertTrue("La tarea se reanudo",this.fixture1.colab.getTareas().get(fixture1.tareas.get(3)).getEstado().devolverestado().equalsIgnoreCase("cerrada"));
        }
    }
    
    /**
     * @see modelo.Colaborador#solicitarITareasIntervalo(java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasIntervalo()
    {
        fail("Unimplemented");
    }

    /**
     * @see modelo.Colaborador#solicitarITareasIntervaloCliente(modelo.Cliente,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasIntervaloCliente()
    {
        fail("Unimplemented");
    }

    /**
     * @see modelo.Colaborador#solicitarITareasEstadoIntervalo(String,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasEstadoIntervalo()
    {
        fail("Unimplemented");
    }

    /**
     * @see modelo.Colaborador#solicitarITareasEnCurso()
     */
    @Test
    public void testSolicitarITareasEnCurso()
    {
        fail("Unimplemented");
    }

    /**
     * @see modelo.Colaborador#setTareas(java.util.HashMap<modelo.Cliente, modelo.Tarea>)
     */
    @Test
    public void testSetTareas()
    {
        fail("Unimplemented");
    }

    /**
     * @see modelo.Colaborador#getTareas()
     */
    @Test
    public void testGetTareas()
    {
        fail("Unimplemented");
    }
}
