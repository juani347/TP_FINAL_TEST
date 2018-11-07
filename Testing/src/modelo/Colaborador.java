 package modelo;


import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**
 * Clase que representa a los Colaboradores del sistema.<br>
 */
public class Colaborador extends Usuario {
    
   
    private HashMap<Cliente,Tarea> tareas = new HashMap<Cliente,Tarea>();
    private boolean tareaActiva=false;
    
    public Colaborador() {
        super();
    }

    public Colaborador(String nombre, String email, String telefono, String id, String contrasena,String perfil) {
        super(nombre, email, telefono, id, contrasena,perfil);
    }

    /**
     *Metodo que crea una tarea con un servicio y cliente predeterminado.<br>
     * @param servicio: servicio para la nueva tarea.<br>
     * @param cliente: cliente para la nueva tarea.<br>
     * <b>pre:</b> El servicio y cliente existian con anterioridad.<br>
     * <b>pos:</b> Se crea una nueva tarea.<br>
     */

    

    public void crearTarea(Servicio servicio, Cliente cliente) throws HayTareaAbiertaException {
        if(this.tareaActiva==false){
        Tarea tarea = new Tarea(servicio,cliente,this);
        this.tareas.put(cliente, tarea);
            this.tareaActiva=true;
    }
        else
        {
            throw new HayTareaAbiertaException();
        }
    }
    
    /**
     *Metodo que elimina una tarea con un servicio y cliente predeterminado.<br>
     * @param tarea: tarea a ser eliminada.<br>
     * <b>pre:</b> La tarea ya existia con anterioridad.<br>
     * <b>pos:</b> Se elimina la tarea del array en el colaborador.<br>
     */
    public void eliminarTarea(Tarea tarea){
        if(this.tareas.containsKey(tarea))
            this.tareas.remove(tarea);
    }
    /**
     *Metodo que cierra la tarea enviada como parametro.<br>
     * @param tarea: tarea a cerrar.<br>
     * <b>pre:</b> La tarea ya existia con anterioridad.<br>
     * <b>pos:</b> Se cambia el estado de la tarea a cerrado.<br>
     */
    public void cerrarTarea(Tarea tarea){
        if(this.tareas.containsKey(tarea.getCliente())){
            this.tareas.get(tarea.getCliente()).getEstado().cerrar();
            this.tareaActiva=false;
    }
    }
    
    /**
     *Metodo que pausa la tarea enviada como parametro.<br>
     * @param tarea: tarea a pausar.<br>
     * <b>pre:</b> La tarea ya existia con anterioridad.<br>
     * <b>pos:</b> Se cambia el estado de la tarea a pausado.<br>
     */
    
    public void pausarTarea(Tarea tarea){
        if(this.tareas.containsKey(tarea.getCliente())){
            this.tareas.get(tarea.getCliente()).getEstado().pausado();
            this.tareaActiva=false;
    }
    }
    
    /**
     *Metodo que reanuda la tarea enviada como parametro.<br>
     * @param tarea: tarea a reanudar.<br>
     * <b>pre:</b> La tarea ya existia con anterioridad.<br>
     * <b>pos:</b> Se cambia el estado de la tarea a abierta.<br>
     */
    
    public void reanudarTarea(Tarea tarea){
        if(this.tareas.containsKey(tarea.getCliente()))
            this.tareas.get(tarea.getCliente()).getEstado().abrir();                                  
    }
    /**
     * Metodo que informa el calculo por un periodo de tiempo, las tareas de servicios y horas de los colaboradores dedicadas a ls clientes.<br>
     * Requeriemiento 3.2.2 SRS.<br>
     * @param x Inicio del intervalo<br>
     * @param y Fin del intervalo.<br>
     * @return Retorna el informe propio del colaborador.<br>
     */
    
    public String solicitarITareasIntervalo(Date x, Date y){
         String resp = "";
         if(!this.tareas.isEmpty()){    
            Iterator it = this.tareas.entrySet().iterator();
            while(it.hasNext()) {
                Map.Entry map = (Map.Entry) it.next();
                Tarea aux = (Tarea) map.getValue();
                if(aux.getFechainicio().after(x) && (aux.getFechainicio().before(y))){
                    Date fecha_actual = new Date(); 
                    resp +=aux.getCliente().getNombre() +" "+ aux.getServicio().getDescripcion() + " " + ((fecha_actual.getTime() - aux.getFechainicio().getTime())/3600000) + "\n";                                            
                }
            }  
        }
        return resp;
    } //3.2.2
    /**
     * Informe con los servicios brindados a un solo cliente en particular en un intervalo de tiempo.<br>
     * Requeriemiento 3.2.1 SRS.<br>
     * @param cliente Cliente del cual se pide el informe.<br>
     * @param x Inicio del intervalo.<br>
     * @param y Fin del intervalo.<br>
     * @return Retorna el informe de los servicios brindados a ese cliente en particular.<br>
     */
    public String solicitarITareasIntervaloCliente(Cliente cliente, Date x, Date y){
         String resp = "";
         if(!this.tareas.isEmpty()){    
            Iterator it = this.tareas.entrySet().iterator();
            while(it.hasNext()) {
                Map.Entry map = (Map.Entry) it.next();
                Tarea aux = (Tarea) map.getValue();
                if(aux.getCliente().getNombre().equalsIgnoreCase(cliente.getNombre()) && (aux.getFechainicio().after(x) && (aux.getFechainicio().before(y)))){
                    Date fecha_actual = new Date();
                    int costo = 0;
                    if(!aux.getServicio().getTipo().equals("Fijo"))
                        costo =(int) (aux.getServicio().getCosto()*((fecha_actual.getTime() - aux.getFechainicio().getTime()) / 3600000));
                    else
                        costo = aux.getServicio().getCosto();
                    resp += aux.getServicio().getDescripcion() + " " + ((fecha_actual.getTime() - aux.getFechainicio().getTime())/ 3600000) + " " + costo + "\n";                                            
                }
            }  
        }
        return resp;
    } // 3.2.1
    /**
     * Metodo que permite al colaborador visualizar sus tareas a cargo.<br>
     * Requeriemiento 3.2.6 SRS.<br>
     * @param estado Estado de tareas que se pide el informe.<br>
     * @param x Inicio de intervalor temporal.<br>
     * @param y Fin del intervalo temporal.<br>
     * @return Retorna el informe correspondiente.<br>
     */
    public String solicitarITareasEstadoIntervalo(String estado, Date x, Date y){
         String resp = "Cliente  |  Tarea de Servicio  |  Inicio  |  Estado  |  Horas Acumuladas\n";
         if(!this.tareas.isEmpty()){    
            Iterator it = this.tareas.entrySet().iterator();
            while(it.hasNext()) {
                Map.Entry map = (Map.Entry) it.next();
                Tarea aux = (Tarea) map.getValue();
                if(aux.getEstado().devolverestado().equalsIgnoreCase(estado) && (aux.getFechainicio().after(x) && (aux.getFechainicio().before(y)))){
                    Date fecha_actual = new Date();
                    resp += aux.getCliente().getNombre() +" "+ aux.getServicio().getDescripcion() +
                           " " + aux.getFechainicio() + " " + aux.getEstado().devolverestado() + " "+
                           ((fecha_actual.getTime() - aux.getFechainicio().getTime())/3600000) + "\n";                                             
                }
                else if(estado.equalsIgnoreCase("todos")){
                    Date fecha_actual = new Date();
                    resp += aux.getCliente().getNombre() +" "+ aux.getServicio().getDescripcion() +
                           " " + aux.getFechainicio() + " " + aux.getEstado().devolverestado() + " "+
                           ((fecha_actual.getTime() - aux.getFechainicio().getTime())/3600000) + "\n";
                    }
            }  
        }
        return resp;
    } //3.2.6
    /**
     * Metodo que muestra las tareas abiertas o en pausa del colaborador.<br>
     * Requeriemiento 3.2.3 SRS.<br>
     * @return Retorna el informe solicitado.<br>
     */
    public String solicitarITareasEnCurso(){
         String resp = "";
         if(!this.tareas.isEmpty()){
           
            Iterator it = this.tareas.entrySet().iterator();
            while(it.hasNext()) {
                Map.Entry map = (Map.Entry) it.next();
                Tarea aux = (Tarea) map.getValue();
                if(aux.getEstado().devolverestado().equalsIgnoreCase("abierta") || aux.getEstado().devolverestado().equalsIgnoreCase("pausada")){                    
                    Date fecha_actual = new Date();
                    resp += this.getNombre()+" "+ aux.getCliente().getNombre() +" "+ aux.getServicio().getDescripcion() +
                           " " + aux.getFechainicio() + " " + aux.getEstado().devolverestado() + " "+
                           ((fecha_actual.getTime() - aux.getFechainicio().getTime())/3600000) + "\n";
                }
            }  
        }
        return resp;
    } //3.2.3

    public void setTareas(HashMap<Cliente, Tarea> tareas) {
        this.tareas = tareas;
    }

    public HashMap<Cliente, Tarea> getTareas() {
        return tareas;
    }


}
