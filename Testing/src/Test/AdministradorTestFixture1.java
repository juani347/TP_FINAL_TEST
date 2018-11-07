package Test;

import java.util.Date;

import modelo.Administrador;
import modelo.BaseDeDatos;
import modelo.CerradaState;
import modelo.Cliente;
import modelo.Colaborador;
import modelo.GrupoClientes;
import modelo.HayTareaAbiertaException;
import modelo.Servicio;

public class AdministradorTestFixture1
{
     public Administrador admin=new Administrador();

     public AdministradorTestFixture1()
     {
         this.admin.setBdd(new BaseDeDatos());
     }

     public void setUp()
     {
         this.admin.getBdd().setAdmin(admin);
         Cliente c1= new Cliente("Juan","juan@gmail.com","4324234","2121321312","123","grupo1");
         Cliente c2= new Cliente("Fran","fran@gmail.com","1234234","2134536546","222","grupo1");
         Cliente c3= new Cliente("Pedro","pedro@gmail.com","1124234","0123212","443","grupo2");
         this.admin.getBdd().getClientes().add(c1);
         this.admin.getBdd().getClientes().add(c2);
         this.admin.getBdd().getClientes().add(c3);
         Servicio s1= new Servicio("Limpiar","Fijo",100);
         Servicio s2= new Servicio("Cocinar","Por hora",25);
         this.admin.getBdd().getServicios().add(s1);
         this.admin.getBdd().getServicios().add(s2);
         Colaborador col1= new Colaborador("Pilar","pili@gmail.com","111111111","111A","1234","Colaborador");
         Colaborador col2= new Colaborador("Sanchez","sanchez@gmail.com","222222222","222B","2345","Colaborador");
         this.admin.getBdd().getColaboradores().add(col1);
         this.admin.getBdd().getColaboradores().add(col2);
         GrupoClientes g1=new GrupoClientes();
         GrupoClientes g2=new GrupoClientes();
         g1.setNombre("grupo1");
         g1.setNombre("grupo2");
         this.admin.getBdd().getGrupos().add(g1);
         this.admin.getBdd().getGrupos().add(g2);
        try
        {
            this.admin.crearTarea(s1, c1, col1);
        } catch (HayTareaAbiertaException e)
        {
        }
        try
        {
            this.admin.crearTarea(s2, c2, col2);
        } catch (HayTareaAbiertaException e)
        {
        }
        col1.getTareas().get(c1).setFechainicio(new Date(2018,10,1));
        col1.getTareas().get(c1).setFechacierre(new Date(2018,10,30));
        col1.getTareas().get(c1).setEstado(new CerradaState(col1.getTareas().get(c1)));
        col2.getTareas().get(c2).setFechainicio(new Date(2018,10,1));
        col2.getTareas().get(c2).setFechacierre(new Date(2018,10,10));
         col1.getTareas().get(c2).setEstado(new CerradaState(col1.getTareas().get(c2)));
     }

     public void tearDown()
     {
         this.admin.getBdd().getClientes().clear();
         this.admin.getBdd().getColaboradores().clear();
         this.admin.getBdd().getGrupos().clear();
         this.admin.getBdd().getServicios().clear();
     }
}