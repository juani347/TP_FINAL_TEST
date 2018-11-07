package Test;

import java.util.ArrayList;

import java.util.Date;

import modelo.Administrador;
import modelo.BaseDeDatos;
import modelo.CerradaState;
import modelo.Cliente;
import modelo.Colaborador;
import modelo.PausadaState;
import modelo.Servicio;
import modelo.Tarea;

public class ColaboradorTestFixture1
{
    public Administrador admin=new Administrador();
    public Colaborador colab=new Colaborador();
    public BaseDeDatos bdd=new BaseDeDatos();
    public ArrayList<Tarea> tareas=new ArrayList<Tarea>();
    
    public ColaboradorTestFixture1()
    {
    }

    public void setUp()
    {
        this.bdd.setAdmin(admin);
        this.bdd.getClientes().add(new Cliente("Juan","juan@gmail.com","4324234","2121321312","123","grupo1"));
        this.bdd.getClientes().add(new Cliente("Fran","fran@gmail.com","1234234","2134536546","222","grupo3"));
        this.bdd.getClientes().add(new Cliente("Nico","nico@gmail.com","54354234","12111112","333","grupo2"));
        this.bdd.getClientes().add(new Cliente("Pedro","pedro@gmail.com","1124234","0123212","443","grupo2"));
        this.bdd.getColaboradores().add(45678,new Colaborador("Pilar","Pilar@gmail.com","4567893","12332","svhbjdlk","Colaborador"));
        this.bdd.getColaboradores().add(9890,new Colaborador("Guillermo","Guille@gmail.com","67890","4r567890","s4e5r68t79uo","Colaborador"));
        this.bdd.getColaboradores().add(45678,new Colaborador("Oscar","Oscar@gmail.com","23456","765123","bg3yvr8","Colaborador"));
        this.bdd.getColaboradores().add(45678,new Colaborador("Gustavo","Gustavo@gmail.com","094582","095456789","wg0wr3389","Colaborador"));
        this.bdd.getServicios().add(new Servicio("Limpiar","tipoA",52));
        this.bdd.getServicios().add(new Servicio("Cocinar","tipoA",100));
        this.bdd.getServicios().add(new Servicio("Barrer","tipoA",150));
        this.tareas.add(new Tarea(new Servicio("Investigar","Fijo",5200),new Cliente("Watson","Watson@gmail.com","34567","43902","52c52","grupo1"),colab));
        this.tareas.add(new Tarea(new Servicio("Rellenar","Porhora",52),new Cliente("Lucrecia","Lucrecia@gmail.com","345234","434231","524455","grupo1"),colab));
        this.tareas.add(new Tarea(new Servicio("Procesar","Fijo",1000),new Cliente("Jeremias","Jeremias@gmail.com","4567890","12908","09876545","grupo2"),colab));
        this.tareas.add(new Tarea(new Servicio("Transportar","Fijo",1500),new Cliente("Claudio","Claudio@gmail.com","45678","54345","657828i","grupo3"),colab));
        this.colab.getTareas().put(this.tareas.get(0).getCliente(), this.tareas.get(0));
        this.colab.getTareas().put(this.tareas.get(1).getCliente(), this.tareas.get(1));
        this.tareas.get(2).setEstado(new PausadaState(this.tareas.get(2)));
        this.colab.getTareas().put(this.tareas.get(2).getCliente(), this.tareas.get(2));
        this.tareas.get(3).setFechacierre(new Date());
        this.tareas.get(3).setEstado(new CerradaState(this.tareas.get(3)));
        this.colab.getTareas().put(this.tareas.get(3).getCliente(), this.tareas.get(3));
    }

    public void tearDown()
    {
        this.bdd.getClientes().clear();
        this.bdd.getGrupos().clear();
        this.bdd.getServicios().clear();
        this.bdd.getColaboradores().clear();
        this.tareas.clear();
    }
}
