package Motor;

import static Motor.EmpleadoMotor.Empleado;
import static Motor.EmpleadoMotor.Habitacion;
import static Motor.EmpleadoMotor.Huesped;

import Datos.Calendario;
import java.util.Random;
import java.util.Scanner;

public class EmpleadoConsola {
    Scanner leer = new Scanner(System.in);
    EmpleadoMotor aux = new EmpleadoMotor();
    Calendario c = new Calendario();
    int id, idhuesped, id_hab;
    /*    
    public void userdefault(){
        aux.agregar(2, "Alexis", "Diego", "Administrador", "admin", "admin", 1);
    }
    
    public int login(String user, String pass){
        int t=aux.login(user, pass);
        return t;
    }
    
    public void registro(){
        String nom, a, cargo, user, pass;
        int tipo;
        id=aux.obtenerid();
        System.out.println("ID Usuario:"+id);
        System.out.println("Ingrese el nombre del empleado");
        nom=leer.nextLine();
        System.out.println("Ingrese los apellidos del empleado");
        a=leer.nextLine();
        System.out.println("Ingrese el cargo del empleado");
        cargo=leer.nextLine();
        System.out.println("Ingrese el NSS del empleado");
        user=leer.nextLine();
        System.out.println("Ingrese la contraseña del empleado");
        pass=leer.nextLine();       
        System.out.println("Ingrese el tipo de empleado(1-Empleado General/2-Administrativo)");
        tipo=Integer.parseInt(leer.nextLine());
        aux.agregar(tipo, nom, a, cargo, user, pass, id);
        System.out.println("Usuario registrado!");
    }

    public void eliminar(){
        System.out.println("Ingresa el NSS del usuario a eliminar");
        String nss=leer.nextLine();
        aux.eliminar(nss);
    }
    
    public void consultas(){
        aux.consultas();
    }
    
    public void cambios(){
        System.out.println("Ingresa el NSS del usuario a editar");
        String ns=leer.nextLine();
        String n, a, cargo, pass;
        int tipo;
        for(int i=0; i<Empleado.size(); i++){
            if(Empleado.get(i).getUsuario().equals(ns)){
                int id_emp = Empleado.get(i).getId(); 
                System.out.println("ID Usuario:"+id_emp);
                System.out.println("Ingrese el tipo de empleado(1-Empleado General/2-Administrativo)");
                tipo=Integer.parseInt(leer.nextLine());
                System.out.println("Ingrese el nombre del empleado");
                n=leer.nextLine();
                System.out.println("Ingrese los apellidos del empleado");
                a=leer.nextLine();
                System.out.println("Ingrese el cargo del empleado");
                cargo=leer.nextLine();
                System.out.println("Ingrese la contraseña del empleado");
                pass=leer.nextLine();
                aux.editar(tipo, n, a, cargo, ns, pass, id_emp, i);
            }
        }
    }
    
    public void tareas(){
        System.out.println("Ingresa la tarea");
        String tarea = leer.nextLine();
        System.out.println("Ingresa el id del empleado que lo hará");
        int emp = Integer.parseInt(leer.nextLine());
        aux.tareas(tarea, emp);
    }
    
    public void tareas(String user){
        aux.vertareas(user);
    }
    
    public void reportes(){
        aux.verreportes();
    }
    
    public void registrohuesped(){        
        String nombre, apellido, usuario, contrasena, fecha_i, fecha_f;
        int id_hab, user, pass;
        int diai, mesi, anioi, diaf, mesf, aniof;
        Random rnd = new Random();
        idhuesped=aux.obeteneridhues();
        System.out.println("ID Huesped: "+idhuesped);
        System.out.println("Ingresa el nombre del huesped");
        nombre = leer.nextLine();
        System.out.println("Ingresa los apellidos del huesped");
        apellido = leer.nextLine();
        user = (int) (rnd.nextDouble() * 100000 + 999999);
        usuario= Integer.toString(user);
        pass = (int) (rnd.nextDouble() * 100000 + 999999);
        contrasena=Integer.toString(pass);
        System.out.println("Ingresa el id de la habitacion");
        id_hab = Integer.parseInt(leer.nextLine());
        if(Habitacion.size()>=id_hab){
            System.out.println("Ingresa el dia de llegada del cliente");
            diai= Integer.parseInt(leer.nextLine());
            System.out.println("Ingresa el mes de llegada del cliente");
            mesi= Integer.parseInt(leer.nextLine());
            System.out.println("Ingresa el año de llegada del cliente");
            anioi= Integer.parseInt(leer.nextLine());
            System.out.println("Ingresa el dia de salida del cliente");
            diaf= Integer.parseInt(leer.nextLine());
            System.out.println("Ingresa el mes de salida del cliente");
            mesf= Integer.parseInt(leer.nextLine());
            System.out.println("Ingresa el año de salida del cliente");
            aniof= Integer.parseInt(leer.nextLine());
            fecha_i= diai +" "+mesi+" "+anioi;
            fecha_f= diaf +" "+mesf+" "+aniof;
            int r=c.validacion(diai, mesi, anioi, diaf, mesf, aniof);
            if(r>0){
                int entrada=c.entrada();
                int salida=c.salida();
                if(aux.registrarh(nombre, apellido, entrada, salida, idhuesped, id_hab, usuario, contrasena, fecha_i, fecha_f, diai, mesi, anioi, diaf, mesf, aniof)){
                    System.out.println("");
                }else{
                    System.out.println("");
                }     
            }else{ 
                System.out.println("Fecha Invalida");              
            }
        }else{
            System.out.println("No existe esa habitacion");
        }
    }
    
    public void agregarhab(){
        int personas, costo, piso;
        String nombre, caracteristicas;
        id_hab = aux.obeteneridhab();
        System.out.println("ID Habitacion: "+id_hab);
        System.out.println("Ingrese el nombre de la habitacion");
        nombre = leer.nextLine();
        System.out.println("Escribe las caracteristicas de la habitacion");
        caracteristicas = leer.nextLine();
        System.out.println("Ingresa el numero de personas que caben en la habitacion");
        personas = Integer.parseInt(leer.nextLine());
        System.out.println("Ingresa el costo de la habitacion");
        costo = Integer.parseInt(leer.nextLine());
        System.out.println("Ingresa el piso de la habitacion");
        piso = Integer.parseInt(leer.nextLine());
        aux.agregarhab(id_hab, personas, nombre, caracteristicas, costo, piso);
    }
    
    public void verhab(){
        aux.habitaciones();
    }    
    
    public void obtener(String us){
        System.out.println("Escribe la falla/peticion");
        String msj = leer.nextLine();
        aux.registrarp(msj, us);
    }
        
    public void informacion(String us){
        aux.verinformacion(us);
    }

    public void vertareasas() {
        aux.vertareasas();
    }
    
    public void verhuesped() {
        aux.verhuespedes();
    }

    public void eliminarhab() {
        int idel;
        System.out.println("Escribe el ID de la habitacion que desea remover");
        idel= Integer.parseInt(leer.nextLine());
        aux.eliminarha(idel);
    }

    public void removerhuesped() {
        int ideh;
        System.out.println("Escribe el ID de el huesped que desea eliminar la reserva");
        ideh= Integer.parseInt(leer.nextLine());
        for(int i=0; i<Huesped.size(); i++){
            if(Huesped.get(i).getId()==ideh){
                int f=Huesped.get(i).getA1();
                int g=Huesped.get(i).getA2();
                int d=Huesped.get(i).getM1();
                int e=Huesped.get(i).getM2();
                int a=Huesped.get(i).getD1();
                int b=Huesped.get(i).getD2();
                int ii=Huesped.get(i).getHabitacion();
                int r=c.validacion(a, d, f, b, e, g);
                int entrada=c.entrada();
                int salida=c.salida();
                
                if(r>0){
                    aux.eliminarhues(ideh, entrada, salida,ii);    
                }
            }
        }
    }

    public void edicionhab() {
        int idpp;
        System.out.println("Escribe el ID de la habitacion que desea editar");
        idpp= Integer.parseInt(leer.nextLine());
        String piso, caracteristicas;
        int costo, capacidad, ps;
        for(int i=0; i<Habitacion.size(); i++){
            if(Habitacion.get(i).getId()==idpp){
                int id_emp = Habitacion.get(i).getId(); 
                System.out.println("ID Habitacion:"+id_emp);
                System.out.println("Ingrese la capacidad de la habitacion");
                capacidad=Integer.parseInt(leer.nextLine());
                System.out.println("Ingrese el costo de la habitacion");
                costo=Integer.parseInt(leer.nextLine());
                System.out.println("Ingrese el nombre de la habitacion");
                piso=leer.nextLine();
                System.out.println("Ingrese las caracteristicas de la habitacion");
                caracteristicas=leer.nextLine();
                System.out.println("Ingrese el piso de la habitacion");
                ps=Integer.parseInt(leer.nextLine());                
                aux.guardaredithab(piso, caracteristicas, costo, capacidad, i, ps);
            }
        }
    }

    public void editarhuesped(){
        int ideh;
        System.out.println("Escribe el ID de el huesped que desea cambiar la fecha de reserva");
        ideh= Integer.parseInt(leer.nextLine());
        for(int i=0; i<Huesped.size(); i++){
            if(Huesped.get(i).getId()==ideh){
                int f=Huesped.get(i).getA1();
                int g=Huesped.get(i).getA2();
                int d=Huesped.get(i).getM1();
                int e=Huesped.get(i).getM2();
                int a=Huesped.get(i).getD1();
                int b=Huesped.get(i).getD2();
                int ii=Huesped.get(i).getHabitacion();
                int r=c.validacion(a, d, f, b, e, g);
                int entrada=c.entrada();
                int salida=c.salida();
                
                if(r>0){
                    aux.eliminarres1(ideh, entrada, salida,ii); 
                    editarhues(ideh, i, entrada, salida);
                }
            }
        }
    }
    
    void editarhues(int ideh, int index, int e, int s){
        String fecha_i, fecha_f;
        int id_habi;
        int diai, mesi, anioi, diaf, mesf, aniof;
        System.out.println("Ingresa el id de la habitacion nueva");
        id_habi = Integer.parseInt(leer.nextLine());
        System.out.println("Ingresa el dia de llegada del cliente");
        diai= Integer.parseInt(leer.nextLine());
        System.out.println("Ingresa el mes de llegada del cliente");
        mesi= Integer.parseInt(leer.nextLine());
        System.out.println("Ingresa el año de llegada del cliente");
        anioi= Integer.parseInt(leer.nextLine());
        System.out.println("Ingresa el dia de salida del cliente");
        diaf= Integer.parseInt(leer.nextLine());
        System.out.println("Ingresa el mes de salida del cliente");
        mesf= Integer.parseInt(leer.nextLine());
        System.out.println("Ingresa el año de salida del cliente");
        aniof= Integer.parseInt(leer.nextLine());
        fecha_i= diai +" "+mesi+" "+anioi;
        fecha_f= diaf +" "+mesf+" "+aniof;
        
        int r=c.validacion(diai, mesi, anioi, diaf, mesf, aniof);
        if(r>0){
            int entrada=c.entrada();
            int salida=c.salida();
            if(aux.guardarcambio(entrada, salida, ideh, id_habi, fecha_i, fecha_f, diai, mesi, anioi, diaf, mesf, aniof, index, e, s)){
                System.out.println("");
            }else{
                System.out.println("");
            }     
        }
        else{ 
            System.out.println("Fecha Invalida");               
        }
    }*/
}