package Test;

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
    public void testSolicitarInformeCliente()
    {
        fail("Unimplemented");
    }

    /**
     * @see modelo.Administrador#solicitarInformeColaboradorIntervalo(modelo.Colaborador,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarInformeColaboradorIntervalo()
    {
        fail("Unimplemented");
    }

    /**
     * @see modelo.Administrador#solicitarTareasEnCursoColaboradores()
     */
    @Test
    public void testSolicitarTareasEnCursoColaboradores()
    {
        fail("Unimplemented");
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
