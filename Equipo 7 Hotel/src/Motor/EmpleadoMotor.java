package Motor;

import Datos.Empleados;
import Datos.Habitaciones;
import Datos.Huespedes;
import Datos.Reportes;
import Datos.Tareas;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

public class EmpleadoMotor {
    String err;
    public static ArrayList<Empleados> Empleado = new ArrayList<Empleados>();
    public static ArrayList<Tareas> Tarea = new ArrayList<Tareas>();
    public static ArrayList<Reportes> Reporte = new ArrayList<Reportes>();
    public static ArrayList<Huespedes> Huesped = new ArrayList<Huespedes>();
    public static ArrayList<Habitaciones> Habitacion = new ArrayList<Habitaciones>();
    
    public void archivoagregarempleados(){
        try {
            FileOutputStream archivosalida = new FileOutputStream("Empleados.txt");
            ObjectOutputStream salida = new ObjectOutputStream(archivosalida);
            salida.writeObject(Empleado);
            salida.close();  
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }         
    }

    public void archivoconsultarempleados() throws ClassNotFoundException{
        try {
            FileInputStream archivoentrada = new FileInputStream("Empleados.txt");
            ObjectInputStream entrada = new ObjectInputStream(archivoentrada);
            Empleado = (ArrayList<Empleados>)entrada.readObject();
            entrada.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } 
    }
    
    public boolean agregar(int tipo, String n, String a, String cargo, String user, String pass, int id) {
        Empleados e = new Empleados();
        e.setNombre(n);
        e.setApellidos(a);
        e.setCargo(cargo);
        e.setUsuario(user);
        e.setContrasena(pass);
        e.setId(id);
        e.setTipo(tipo);
        int d=1;
        for(int i=0; i<Empleado.size(); i++){
            if(Empleado.get(i).getUsuario().equals(user)){
                err="El NSS ya fue registrado";
                d=0;  
            }
        }
        if(d==1){ 
            Empleado.add(e);           
            archivoagregarempleados();
            err="Empleado agregado";
            return true;
        }else{
            return false;
        }
    }   
    
    public void userd(int tipo, String n, String a, String cargo, String user, String pass, int id) throws ClassNotFoundException{        
        archivoconsultarempleados();
        if(Empleado.size()==0){
            agregar(tipo, n, a, cargo, user, pass, id);
            System.out.println("Empleado Agregadopor Default");
            archivoagregarempleados();
        }if(Empleado.size()!=0){
            if(Empleado.get(0).getId()!=1){
                agregar(tipo, n, a, cargo, user, pass, id);
                System.out.println("Empleado Agregadopor Default");
                archivoagregarempleados();                
            }
        }       
    }
    
    public void eliminar(String nss) throws ClassNotFoundException{
        archivoconsultarempleados();
        for(int i=0; i<Empleado.size(); i++){
            if(Empleado.get(i).getUsuario().equals(nss)){
                Empleado.remove(i);
            }
        }
        System.out.println("Empleado Eliminado");
        archivoagregarempleados();
    }

    public void consultas() throws ClassNotFoundException {
        archivoconsultarempleados();
        for(int i=0; i<Empleado.size(); i++){
            System.out.println("ID: "+Empleado.get(i).getId()+" Nombre: "+Empleado.get(i).getNombre()
                    +" "+Empleado.get(i).getApellidos()+" Cargo: "+Empleado.get(i).getCargo() 
                    +" NSS: " +Empleado.get(i).getUsuario());
        }
        
    }
       
    public void editar(int tipo, String n, String a, String cargo, String nss, String pass, int id, int i) throws ClassNotFoundException {
        archivoconsultarempleados();
        Empleado.get(i).setNombre(n);
        Empleado.get(i).setTipo(tipo);
        Empleado.get(i).setApellidos(a);
        Empleado.get(i).setCargo(cargo);
        Empleado.get(i).setUsuario(nss);
        Empleado.get(i).setContrasena(pass);
        Empleado.get(i).setId(id);
        System.out.println("Cambios guardados");
        archivoagregarempleados();
    }
    
    public boolean editarcontra(String passnueva, String passant, int i) throws ClassNotFoundException {
       archivoconsultarempleados();
        if(Empleado.get(i).getContrasena().equals(passant)){
            Empleado.get(i).setContrasena(passnueva);
            err= "Cambios de contraseña guardados";
            System.out.println(err);   
            archivoagregarempleados();
            return true;
        }else{
            err= "La contraseña anterior no coincide";
            return false;
        }
    }
    
    public void archivoguardartarea(){
        try {
            FileOutputStream archivosalida = new FileOutputStream("Tareas.txt");
            ObjectOutputStream salida = new ObjectOutputStream(archivosalida);
            salida.writeObject(Tarea);
            salida.close();  
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }         
    }
    
    public void archivotarea() throws ClassNotFoundException{
        try {
            FileInputStream archivoentrada = new FileInputStream("Tareas.txt");
            ObjectInputStream entrada = new ObjectInputStream(archivoentrada);
            Tarea = (ArrayList<Tareas>)entrada.readObject();
            entrada.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } 
    }    
    
    public void tareas(String tarea, int emp) {
        Date now = new Date(System.currentTimeMillis());
        String fecha=now.toString();
        Tareas t = new Tareas();
        t.setTarea(tarea);
        t.setFecha(fecha);
        t.setId_empleado(emp);
        Tarea.add(t);    
        System.out.println("Tarea añadida");
        archivoguardartarea();
    }
    
    public boolean registrarh(String nombre, String apellido, int valor_i, int valor_f, int id, int id_hab, String user, String pass, String f1, String f2, int dia_i, int mes_i, int anio_i, int dia_f, int mes_f, int anio_f) {
        int disponible=1;
        int indice=0;
        int dias[] = new int[365];
        for(int i=0; i<Habitacion.size(); i++){
            if(Habitacion.get(i).getId()==id_hab){
                dias=Habitacion.get(i).getReservas();
                indice=i;
                for(int j=valor_i; j<=valor_f; j++){
                    if(dias[j]==1){
                        disponible=0;
                    }
                }
            }
        }
        if(disponible==1){
            err="Cliente Registrado\nSu usuario del huesped es: "+user+"\nSu contraseña es: "+pass;
            System.out.println(err);
                for(int i=0; i<Habitacion.size(); i++){
                    if(Habitacion.get(i).getId()==id_hab){
                        dias=Habitacion.get(i).getReservas();
                        indice=i;
                            for(int k=valor_i; k<=valor_f;k++){
                                    dias[k]=1;
                            }
                        }
                    }
            Habitacion.get(indice).setReservas(dias);
            archivoguardarhab();
            agregarreservacion(nombre, apellido, valor_i, valor_f, id, id_hab, user, pass, f1, f2, dia_i, mes_i, anio_i, dia_f, mes_f, anio_f);
            return true;
        }
        else{
            err ="Habitacion no disponible en esas fechas";
            System.out.println(err);
            return false;
        }
    }
    
    public boolean agregarreservacion(String nombre, String apellido, int valor_i, int valor_f, int id, int id_hab, String user, String pass, String f1, String f2, int dia_i, int mes_i, int anio_i, int dia_f, int mes_f, int anio_f){
        if(!nombre.equals("")){
            Huespedes hu = new Huespedes();
            hu.setNombre(nombre);
            hu.setApellidos(apellido);
            hu.setId(id);
            hu.setUsuario(user);
            hu.setContrasena(pass);
            hu.setHabitacion(id_hab);
            hu.setFecha_i(f1);
            hu.setFecha_f(f2);
            hu.setA1(anio_i);
            hu.setA2(anio_f);
            hu.setM1(mes_i);
            hu.setM2(mes_f);
            hu.setD1(dia_i);
            hu.setD2(dia_f);
            Huesped.add(hu);
            archivoguardarhuesped();
            return true;
        }else
            return false;
    }
   
    public void habitaciones() {
        int aux[]= new int[365];
        for(int i=0; i<Habitacion.size(); i++){
            aux=Habitacion.get(i).getReservas();
            System.out.println("ID: "+Habitacion.get(i).getId()+" "+Habitacion.get(i).getPiso() +" "+ 
                    "para "+Habitacion.get(i).getPersonas()+" personas, cuenta con "+Habitacion.get(i).getCaracteristicas()
                    +" y tiene un costo de $"+Habitacion.get(i).getCosto());
            for(int j=0; j<aux.length; j++){
                System.out.print(aux[j]);
            }
            System.out.println("\n");
        }
    }
    
    public void vertareas(String user) {
        String usuario_e=user;
        int id_e=0;
        for(int i=0; i<Empleado.size(); i++){
            if(Empleado.get(i).getUsuario().equals(usuario_e)){
                id_e=Empleado.get(i).getId();
            }
        }
        for(int i=0; i<Tarea.size(); i++){
            if(Tarea.get(i).getId_empleado()==id_e){
                System.out.println(Tarea.get(i).getFecha()+"Tarea: "+Tarea.get(i).getTarea());
            }
        }        
    }
    
    public void agregarhab(int id_hab, int personas, String nombre, String caracteristicas, int costo, int piso) {
        Habitaciones ha = new Habitaciones();
        ha.setCaracteristicas(caracteristicas);
        ha.setId(id_hab);
        ha.setCosto(costo);
        ha.setPersonas(personas);
        ha.setNombre(nombre);
        ha.setPiso(piso);
        ha.setImg(id_hab+".jpg");
        Habitacion.add(ha);
        archivoguardarhab();
        System.out.println("Habitacion agregada Correctamente");
    }

    public void registrarp(String msj, String us) {
        Date now = new Date(System.currentTimeMillis());
        String fecha=now.toString();
        String nombre="", habitacion="";
        int iduser=0, idhab=0;
        for(int i=0; i<Huesped.size(); i++){
            if(Huesped.get(i).getUsuario().equals(us)){
                nombre = Huesped.get(i).getNombre()+" "+Huesped.get(i).getApellidos();
                iduser=Huesped.get(i).getId();
                idhab=Huesped.get(i).getHabitacion();
            } 
        }
        for(int i=0; i<Habitacion.size(); i++){
            if(Habitacion.get(i).getId()==idhab){
                habitacion = Habitacion.get(i).getNombre();
            }
        }
        Reportes r = new Reportes();
        r.setFecha(fecha);
        r.setId_cliente(iduser);
        r.setId_habitacion(idhab);
        r.setHabitacion(habitacion);
        r.setNombre(nombre);
        r.setReporte(msj);
        Reporte.add(r);
        archivoguardarreporte();
        System.out.println("Reporte enviado correctamente");
    }
        
    public void verreportes() {
        for(int o=0; o<Reporte.size(); o++){
            System.out.println(Reporte.get(o).getFecha() +"Habitacion: "+Reporte.get(o).getHabitacion()
            +"Huesped: "+Reporte.get(o).getNombre()+ ": "+Reporte.get(o).getReporte());
        }
    }
    
    public void verinformacion(String usa) {
        int iduser=0;
        for(int i=0; i<Huesped.size(); i++){
            if(Huesped.get(i).getUsuario().equals(usa)){
                iduser=Huesped.get(i).getId();
            } 
        }
        for(int i=0; i<Habitacion.size(); i++){
            if(Habitacion.get(i).getId()==iduser){
                System.out.println(Habitacion.get(i).getPiso() +" para " +Habitacion.get(i).getPersonas()+" personas, cuenta con "
                +Habitacion.get(i).getCaracteristicas());
            }
        }
        for(int j=0; j<Huesped.size(); j++){
            if(Huesped.get(j).getId()==iduser){
                System.out.println("Tu estancia empieza "+Huesped.get(j).getFecha_i()+
                        " y termina en "+Huesped.get(j).getFecha_f());
            }
        }
    }

    public int login(String user, String pass) throws ClassNotFoundException {
        archivoconsultarempleados();
        int tipo=0;
        for(int i=0; i<Empleado.size(); i++){
            if(Empleado.get(i).getUsuario().equals(user) &&Empleado.get(i).getContrasena().equals(pass)){
                if(Empleado.get(i).getTipo()==2){
                    tipo=2;
                }else if(Empleado.get(i).getTipo()==1){
                    tipo=1;
                }
            }
        }
        archivohuesped();
        for(int k=0; k<Huesped.size(); k++){
            if(Huesped.get(k).getUsuario().equals(user) && Huesped.get(k).getContrasena().equals(pass)){
                tipo=3;
            }
        }
        return tipo;
    }

    public void vertareasas() {
        for(int i=0; i<Tarea.size(); i++){
            for(int j=0; j<Empleado.size(); j++){
                if(Tarea.get(i).getId_empleado()==Empleado.get(j).getId())
                System.out.println(Tarea.get(i).getFecha()+" Tarea: "+Tarea.get(i).getTarea()+ 
                    " para "+Empleado.get(j).getNombre() +" "+Empleado.get(j).getApellidos());    
            }           
        }   
    }

    public void verhuespedes() {
        for(int i=0; i<Huesped.size(); i++){            
            for(int j=0; j<Habitacion.size(); j++){
                if(Huesped.get(i).getHabitacion()==Habitacion.get(j).getId()){                   
                System.out.println(Huesped.get(i).getId()+ " " +Huesped.get(i).getNombre() +" "+Huesped.get(i).getApellidos() +
                        " tiene reservacion en "+Habitacion.get(j).getPiso()+" del "
                +Huesped.get(i).getFecha_i()+" al "+Huesped.get(i).getFecha_f());
                }
            }
        }
    } 

    public void eliminarha(int idel) {
       for(int i=0; i<Huesped.size(); i++){
            if(Huesped.get(i).getHabitacion()==idel){
                Huesped.remove(i);
                archivoguardarhuesped();
            }
        } 
        for(int i=0; i<Habitacion.size(); i++){
            if(Habitacion.get(i).getId()==idel){
                Habitacion.remove(i);
                archivoguardarhab();
            }
        }
        System.out.println("Habitacion Eliminada");
    }

    public void eliminarhues(int ideh, int entrada, int salida, int habitaciona) {
        int days[] = new int[365];
        int indice=0;
        for(int i=0; i<Huesped.size(); i++){
            if(Huesped.get(i).getId()==ideh){ 
                Huesped.remove(i);
                archivoguardarhuesped();
            }
        }
        for(int j=0; j<Habitacion.size(); j++){
            if(Habitacion.get(j).getId()==habitaciona){
                days=Habitacion.get(j).getReservas();
                indice=j;
                for(int k=entrada; k<=salida; k++){
                    if(days[k]==1){
                        days[k]=0;
                    }
                }
            }
        }    
        Habitacion.get(indice).setReservas(days);
        archivoguardarhab();
        System.out.println("Reservacion Eliminada");
    }
        
    public void guardaredithab(String piso, String c, int costo, int cap, int indice, int ps){
        Habitacion.get(indice).setCosto(costo);
        Habitacion.get(indice).setNombre(piso);
        Habitacion.get(indice).setCaracteristicas(c);
        Habitacion.get(indice).setPersonas(cap);   
        Habitacion.get(indice).setPiso(ps);
        archivoguardarhab();
        System.out.println("Cambios guardados");
    }

    public boolean guardarcambio(int entrada, int salida, int idhuesped, int id_hab, String fecha_i, String fecha_f, int diai, int mesi, int anioi, int diaf, int mesf, int aniof, int index, int e, int s) {       
        int disponible=1;
        int indice=0;
        int dias[] = new int[365];
        for(int i=0; i<Habitacion.size(); i++){
            if(Habitacion.get(i).getId()==id_hab){
                dias=Habitacion.get(i).getReservas();
                indice=i;
                for(int j=entrada; j<=salida; j++){
                    if(dias[j]==1){
                        disponible=0;
                    }
                }
            }
        }
        if(disponible==1){
            Huesped.get(index).setFecha_i(fecha_i);
            Huesped.get(index).setFecha_f(fecha_f);
            Huesped.get(index).setHabitacion(id_hab);
            Huesped.get(index).setD1(diai);
            Huesped.get(index).setD2(diaf);
            Huesped.get(index).setM1(mesi);
            Huesped.get(index).setM2(mesf);
            Huesped.get(index).setA1(anioi);
            Huesped.get(index).setA2(aniof);
            archivoguardarhuesped();
            for(int i=0; i<Habitacion.size(); i++){
                if(Habitacion.get(i).getId()==id_hab){
                    dias=Habitacion.get(i).getReservas();
                    indice=i;
                        for(int k=entrada; k<=salida;k++){
                            dias[k]=1;
                        }
                }
            }
            Habitacion.get(indice).setReservas(dias);
            archivoguardarhab();
            err="Cambios Guardados correctamente";
            System.out.println(err);
            return true;
        }
        else{
            for(int i=0; i<Habitacion.size(); i++){
                if(Habitacion.get(i).getId()==id_hab){
                    dias=Habitacion.get(i).getReservas();
                    indice=i;
                        for(int k=e; k<=s;k++){
                            dias[k]=1;
                        }
                }
            }
            Habitacion.get(indice).setReservas(dias);
            archivoguardarhab();
            err="Habitacion no disponible en esas fechas";
            System.out.println(err);
            return false;
        }
    }

    public void eliminarres1(int ideh, int entrada, int salida, int ii) {
        int days[] = new int[365];
        int indice=0;
        for(int j=0; j<Habitacion.size(); j++){
            if(Habitacion.get(j).getId()==ii){
                days=Habitacion.get(j).getReservas();
                indice=j;
                for(int k=entrada; k<=salida; k++){
                    if(days[k]==1){
                        days[k]=0;
                    }
                }
            }
        }    
        Habitacion.get(indice).setReservas(days);
        archivoguardarhab();
    }
    
    public int obtenerid() throws ClassNotFoundException{
        archivoconsultarempleados();
        int idemp=Empleado.size();
        if(Empleado.size()==0){
            idemp=1;
        }else{
            idemp=Empleado.get(Empleado.size()-1).getId();
            idemp++;
        }
        return idemp;
    }
    
    public int obeteneridhab() throws ClassNotFoundException{
        archivohab();
        int idemp=Habitacion.size();
        if(Habitacion.size()==0){
            idemp=1;
        }else{
            idemp=Habitacion.get(Habitacion.size()-1).getId();
            idemp++;
        }
        return idemp;
    }
    
    public int obeteneridhues() throws ClassNotFoundException{
        archivohuesped();
        int idemp=Huesped.size();
        if(Huesped.size()==0){
            idemp=1;
        }else{
            idemp=Huesped.get(Huesped.size()-1).getId();
            idemp++;
        }
        return idemp;
    }
    
    public String error(){
        return err;
    }
    
    public void archivoguardarhuesped(){
        try {
            FileOutputStream archivosalida = new FileOutputStream("Huespedes.txt");
            ObjectOutputStream salida = new ObjectOutputStream(archivosalida);
            salida.writeObject(Huesped);
            salida.close();  
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }         
    }
    
    public void archivohuesped() throws ClassNotFoundException{
        try {
            FileInputStream archivoentrada = new FileInputStream("Huespedes.txt");
            ObjectInputStream entrada = new ObjectInputStream(archivoentrada);
            Huesped = (ArrayList<Huespedes>)entrada.readObject();
            entrada.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } 
    } 
    
    public void archivoguardarreporte(){
        try {
            FileOutputStream archivosalida = new FileOutputStream("Reporte.txt");
            ObjectOutputStream salida = new ObjectOutputStream(archivosalida);
            salida.writeObject(Reporte);
            salida.close();  
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }         
    }
    
    public void archivoreporte() throws ClassNotFoundException{
        try {
            FileInputStream archivoentrada = new FileInputStream("Reporte.txt");
            ObjectInputStream entrada = new ObjectInputStream(archivoentrada);
            Reporte = (ArrayList<Reportes>)entrada.readObject();
            entrada.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } 
    }   
    
    public void archivoguardarhab(){
        try {
            FileOutputStream archivosalida = new FileOutputStream("Habitacion.txt");
            ObjectOutputStream salida = new ObjectOutputStream(archivosalida);
            salida.writeObject(Habitacion);
            salida.close();  
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }         
    }
    
    public void archivohab() throws ClassNotFoundException{
        try {
            FileInputStream archivoentrada = new FileInputStream("Habitacion.txt");
            ObjectInputStream entrada = new ObjectInputStream(archivoentrada);
            Habitacion = (ArrayList<Habitaciones>)entrada.readObject();
            entrada.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } 
    }   
}