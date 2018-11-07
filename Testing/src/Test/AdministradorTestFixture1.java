package Test;

import modelo.Administrador;
import modelo.BaseDeDatos;
import modelo.Cliente;
import modelo.Servicio;

public class AdministradorTestFixture1
{
    public Administrador admin=new Administrador();
     

     public AdministradorTestFixture1()
     {this.admin.setBdd(new BaseDeDatos());
         
     }

     public void setUp()
     {
         this.admin.getBdd().setAdmin(admin);
         this.admin.getBdd().getClientes().add(new Cliente("Juan","juan@gmail.com","4324234","2121321312","123","grupo1"));
         this.admin.getBdd().getClientes().add(new Cliente("Fran","fran@gmail.com","1234234","2134536546","222","grupo3"));
         this.admin.getBdd().getClientes().add(new Cliente("Nico","nico@gmail.com","54354234","12111112","333","grupo2"));
         this.admin.getBdd().getClientes().add(new Cliente("Pedro","pedro@gmail.com","1124234","0123212","443","grupo2"));
         this.admin.getBdd().getServicios().add(new Servicio("Limpiar","tipoA",52));
         this.admin.getBdd().getServicios().add(new Servicio("Cocinar","tipoA",100));
         this.admin.getBdd().getServicios().add(new Servicio("Barrer","tipoA",150));
     }

     public void tearDown()
     {
         this.admin.getBdd().getClientes().clear();
         this.admin.getBdd().getColaboradores().clear();
         this.admin.getBdd().getGrupos().clear();
         this.admin.getBdd().getServicios().clear();
     }
}