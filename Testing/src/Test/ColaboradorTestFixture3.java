package Test;

import java.util.ArrayList;

import modelo.Administrador;
import modelo.BaseDeDatos;
import modelo.Colaborador;
import modelo.Tarea;

public class ColaboradorTestFixture3
{
    public Administrador admin=new Administrador();
    public Colaborador colab=new Colaborador();
    public BaseDeDatos bdd=new BaseDeDatos();
    public ArrayList<Tarea> tareas=new ArrayList<Tarea>();
    
    public ColaboradorTestFixture3()
    {
        
    }

    public void setUp()
    {
    }

    public void tearDown()
    {
    }
}
