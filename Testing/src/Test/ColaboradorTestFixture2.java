package Test;

import java.util.ArrayList;

import java.util.Date;

import modelo.Administrador;
import modelo.BaseDeDatos;
import modelo.Cliente;
import modelo.Colaborador;
import modelo.Servicio;
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
        Tarea t1=new Tarea(new Servicio("Investigar","Fijo",5200),new Cliente("Watson","Watson@gmail.com","34567","43902","52c52","grupo1"),colab);
        Tarea t2=new Tarea(new Servicio("Rellenar","Porhora",52),new Cliente("Lucrecia","Lucrecia@gmail.com","345234","434231","524455","grupo1"),colab);
        Tarea t3=new Tarea(new Servicio("Procesar","Fijo",1000),new Cliente("Jeremias","Jeremias@gmail.com","4567890","12908","09876545","grupo2"),colab);
        Tarea t4=new Tarea(new Servicio("Transportar","Fijo",1500),new Cliente("Claudio","Claudio@gmail.com","45678","54345","657828i","grupo3"),colab);
        Tarea t5=new Tarea(new Servicio("Pasear","Porhora",89),new Cliente("Adolfo","adolfo@gmail.com","345678","655432","4r3r21","grupo2"),colab);
        t4.setFechacierre(new Date(2018,10,20));t4.setFechainicio(new Date(2018,10,1));
        t5.setFechacierre(new Date(2018,10,10));t5.setFechainicio(new Date(2018,10,1));
        this.tareas.add(t1);
        this.tareas.add(t2);
        this.tareas.add(t3);
        this.tareas.add(t4);
        this.tareas.add(t5);
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
