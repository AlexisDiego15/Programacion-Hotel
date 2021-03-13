package proyectohotel;
import Motor.EmpleadoMotor;
import java.util.Scanner;

public class ProyectoHotel {
    public static void main(String[] args) throws ClassNotFoundException{
        EmpleadoMotor aux = new EmpleadoMotor();     
        aux.userd(2, "Alexis", "Diego", "Administrador", "admin", "admin", 1);  
        
        Vistas.Login v = new Vistas.Login();
        v.init();

      /*Scanner leer = new Scanner(System.in);
       
        String user, pass;
        int interruptor=1, opc, tipo;
        Motor.EmpleadoConsola me=new Motor.EmpleadoConsola();
        me.userdefault();
        
        do{
            System.out.println("Ingresa tu usuario");
            user=leer.nextLine();
            System.out.println("Ingresa tu contraseña");
            pass=leer.nextLine();
            tipo=me.login(user, pass);
            

            if(tipo==2){
                do{
                    System.out.println("1. Agregar Empleado");
                    System.out.println("2. Remover Empleado");
                    System.out.println("3. Ver Información de Empleados");
                    System.out.println("4. Cambiar Información de Empleados");
                    System.out.println("5. Asignar Tareas a Empleados");
                    System.out.println("6. Ver Tareas Asignadas");
                    System.out.println("7. Agregar Información de Habitaciones"); 
                    System.out.println("8. Ver Informacion de Habitaciones");
                    System.out.println("9. Editar Informacion de Habitaciones");
                    System.out.println("10. Eliminar Informacion de Habitaciones");
                    System.out.println("11. Agregar Huespedes");
                    System.out.println("12. Ver Informacion de Huespedes");
                    System.out.println("13. Remover Reservaciones");
                    System.out.println("14. Cambiar Fechas de Reservaciones");
                    System.out.println("15. Ver Reportes de Huespedes");
                    System.out.println("0. Salir");
                    System.out.println("Seleccione una opcion (1-15)");
                    opc=Integer.parseInt(leer.nextLine());
                        switch(opc){
                            case 1: me.registro(); break;
                            case 2: me.eliminar(); break;
                            case 3: me.consultas(); break;
                            case 4: me.cambios(); break;
                            case 5: me.tareas(); break;
                            case 6: me.vertareasas(); break;
                            case 7: me.agregarhab(); break;
                            case 8: me.verhab(); break; 
                            case 9: me.edicionhab();break;
                            case 10: me.eliminarhab(); break;
                            case 11: me.registrohuesped();break;
                            case 12: me.verhuesped(); break;
                            case 13: me.removerhuesped(); break;
                            case 14: me.editarhuesped(); break;
                            case 15: me.reportes(); break;
                        }
                }while (opc!=0);  
            }else if(tipo==1){
                do{
                    System.out.println("Bienvenido, Selecciona una opción");
                    System.out.println("1. Ver tareas");
                    System.out.println("2. Ver Reportes de Huespedes");
                    System.out.println("3. Agregar Información de Habitaciones"); 
                    System.out.println("4. Ver Informacion de Habitaciones");
                    System.out.println("5. Editar Informacion de Habitaciones");
                    System.out.println("6. Eliminar Informacion de Habitaciones");
                    System.out.println("7. Agregar Huespedes");
                    System.out.println("8. Ver Informacion de Huespedes");
                    System.out.println("9. Remover Reservaciones");
                    System.out.println("10. Editar Fecha de Reservaciones");
                    System.out.println("0. Salir");
                    System.out.println("Seleccione una opcion (1-10)");
                    opc=Integer.parseInt(leer.nextLine());
                        switch(opc){
                            case 1: me.tareas(user); break;
                            case 2: me.reportes(); break;
                            case 3: me.agregarhab(); break;
                            case 4: me.verhab(); break; 
                            case 5: me.edicionhab(); break;
                            case 6: me.eliminarhab(); break; 
                            case 7: me.registrohuesped();break;
                            case 8: me.verhuesped(); break;
                            case 9: me.removerhuesped();break;
                            case 10: me.editarhuesped();break;
                        }
                }while (opc!=0);
            }else if(tipo==3){
                do{ 
                    System.out.println("Bienvenido, Selecciona una opción");
                    System.out.println("1. Hacer un reporte/petición");
                    System.out.println("2. Ver información de habitación");
                    System.out.println("0. Salir");
                    System.out.println("Seleccione una opcion (1/2)");
                    opc=Integer.parseInt(leer.nextLine());
                        switch(opc){
                            case 1: me.obtener(user); break;
                            case 2: me.informacion(user); break;
                        }
                }while (opc!=0);
            }else System.out.println("Usuario o contraseña invalida");  
        }while(interruptor==1);
    */}     
}