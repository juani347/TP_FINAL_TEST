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
    public Colaborador colab1=new Colaborador();
    public Colaborador colab2=new Colaborador();
    public Colaborador colab3=new Colaborador();
    public BaseDeDatos bdd=new BaseDeDatos();
    public ArrayList<Tarea> tareas=new ArrayList<Tarea>();
    
    public ColaboradorTestFixture1()
    {
    }

    public void setUp()
    {
        this.bdd.setAdmin(admin);
        Cliente cli1=new Cliente("Juan","juan@gmail.com","4324234","2121321312","123","grupo1");
        Cliente cli2=new Cliente("Fran","fran@gmail.com","1234234","2134536546","222","grupo3");
        Cliente cli3=new Cliente("Nico","nico@gmail.com","54354234","12111112","333","grupo2");
        Cliente cli4=new Cliente("Pedro","pedro@gmail.com","1124234","0123212","443","grupo2");
        this.bdd.getClientes().add(cli1);
        this.bdd.getClientes().add(cli2);
        this.bdd.getClientes().add(cli3);
        this.bdd.getClientes().add(cli4);
        Colaborador colab1=new Colaborador("Pilar","Pilar@gmail.com","4567893","12332","svhbjdlk","Colaborador");
        Colaborador colab2=new Colaborador("Guillermo","Guille@gmail.com","67890","4r567890","s4e5r68t79uo","Colaborador");
        Colaborador colab3=new Colaborador("Oscar","Oscar@gmail.com","23456","765123","bg3yvr8","Colaborador");
        Colaborador colab4=new Colaborador("Gustavo","Gustavo@gmail.com","094582","095456789","wg0wr3389","Colaborador");
        Servicio s1=new Servicio("Limpiar","Porhora",52);
        Servicio s2=new Servicio("Cocinar","Fijo",100);
        Servicio s3=new Servicio("Barrer","Fijo",150);
        this.bdd.getServicios().add(s1);
        this.bdd.getServicios().add(s2);
        this.bdd.getServicios().add(s3);
        Tarea ta1=new Tarea(s1,cli1,colab1);ta1.setEstado(new CerradaState(ta1));ta1.setFechacierre(new Date(2018,10,30));ta1.setFechainicio(new Date(2018,10,1));
        colab1.getTareas().put(cli1,ta1);
        this.bdd.getColaboradores().add(colab1);
        this.bdd.getColaboradores().add(colab2);
        this.bdd.getColaboradores().add(colab3);
        this.bdd.getColaboradores().add(colab4);
        Tarea t1=new Tarea(new Servicio("Investigar","Fijo",5200),new Cliente("Watson","Watson@gmail.com","34567","43902","52c52","grupo1"),colab);
        Tarea t2=new Tarea(new Servicio("Rellenar","Porhora",52),new Cliente("Lucrecia","Lucrecia@gmail.com","345234","434231","524455","grupo1"),colab);
        Tarea t3=new Tarea(new Servicio("Procesar","Fijo",1000),new Cliente("Jeremias","Jeremias@gmail.com","4567890","12908","09876545","grupo2"),colab);
        Tarea t4=new Tarea(new Servicio("Transportar","Fijo",1500),new Cliente("Claudio","Claudio@gmail.com","45678","54345","657828i","grupo3"),colab);
        Tarea t5=new Tarea(new Servicio("Pasear","Porhora",89),new Cliente("Adolfo","adolfo@gmail.com","345678","655432","4r3r21","grupo2"),colab);
        t1.setFechacierre(new Date(2018,10,20));t1.setFechainicio(new Date(2018,10,1));
        t5.setFechacierre(new Date(2018,10,10));t5.setFechainicio(new Date(2018,10,1));
        this.tareas.add(t1);
        this.tareas.add(t2);
        this.tareas.add(t3);
        this.tareas.add(t4);
        this.tareas.add(t5);
        this.colab.getTareas().put(this.tareas.get(0).getCliente(), this.tareas.get(0));
        this.colab.getTareas().put(this.tareas.get(1).getCliente(), this.tareas.get(1));
        this.tareas.get(2).setEstado(new PausadaState(this.tareas.get(2)));
        this.colab.getTareas().put(this.tareas.get(2).getCliente(), this.tareas.get(2));
        this.tareas.get(3).setEstado(new CerradaState(this.tareas.get(3)));
        this.colab.getTareas().put(this.tareas.get(3).getCliente(), this.tareas.get(3));
        this.tareas.get(4).setEstado(new CerradaState(this.tareas.get(4)));
        this.colab.getTareas().put(this.tareas.get(4).getCliente(), this.tareas.get(4));
        this.colab1.setNombre("Pilar");
        this.colab1.getTareas().put(this.tareas.get(0).getCliente(), this.tareas.get(0));
        this.colab2.getTareas().put(this.tareas.get(3).getCliente(),this.tareas.get(3));
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
