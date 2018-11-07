package Test;

import modelo.BaseDeDatos;
import modelo.Cliente;
import modelo.Colaborador;
import modelo.Servicio;

public class BaseDeDatosTestFixture2
{
    BaseDeDatos bdd;
    public BaseDeDatosTestFixture2()
    {
    }

    public void setUp()
    {
        bdd.getColaboradores().add(new Colaborador("c3", "email", "telefono", "id", "contrasena","a"));
        bdd.getColaboradores().add(new Colaborador("c4", "email", "telefono", "id", "contrasena","a"));
        bdd.getColaboradores().add(new Colaborador("c5", "email", "telefono", "id", "contrasena","a"));
        
        bdd.getClientes().add(new Cliente("cl1","email","telefono","cuit","razonsocial","grupo"));
        bdd.getClientes().add(new Cliente("cl2","email","telefono","cuit","razonsocial","grupo"));
        bdd.getClientes().add(new Cliente("cl3","email","telefono","cuit","razonsocial","grupo"));
        
        bdd.getServicios().add(new Servicio("Barrer","Por hora",200));
        bdd.getServicios().add(new Servicio("Cambiar piso","Fijo",1200));
        bdd.getServicios().add(new Servicio("Mudanza","Fijo",2000));   
    }

    public void tearDown()
    {
    }
}
