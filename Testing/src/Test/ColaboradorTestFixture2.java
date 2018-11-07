package Test;

import java.util.ArrayList;

import modelo.Administrador;
import modelo.BaseDeDatos;
import modelo.Colaborador;
import modelo.Tarea;

public class ColaboradorTestFixture2
{
    public Administrador admin=new Administrador();
    public Colaborador colab=new Colaborador();
    public BaseDeDatos bdd=new BaseDeDatos();
    public ArrayList<Tarea> tareas=new ArrayList<Tarea>();
    
    public ColaboradorTestFixture2()
    {
    }

    public void setUp()
    {
        this.bdd.setAdmin(admin);
        this.colab.getTareas().clear();
        this.bdd.getClientes().clear();
        this.bdd.getColaboradores().clear();
        this.bdd.getGrupos().clear();
        this.bdd.getServicios().clear();
        this.tareas.clear();
    }

    public void tearDown()
    {
        this.colab.getTareas().clear();
        this.bdd.getClientes().clear();
        this.bdd.getColaboradores().clear();
        this.bdd.getGrupos().clear();
        this.bdd.getServicios().clear();
        this.tareas.clear();
    }
}
