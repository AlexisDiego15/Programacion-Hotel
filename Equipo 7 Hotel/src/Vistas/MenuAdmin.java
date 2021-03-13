package Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

class MenuAdmin extends JFrame implements ActionListener{
    BorderLayout principal;
    GridLayout grid;
    JPanel panel;
    JMenuBar barramenu;
    JMenu nuevo, ver, edicion, eliminar, cerrar;
    JMenuItem nuevo_hues, nueva_hab, nuevo_emp, nueva_tar;
    JMenuItem ver_huesp, ver_hab, ver_emp, ver_rep, ver_tar;
    JMenuItem eli_huesp, eli_hab, eli_emp;
    JMenuItem edi_huesp, edi_hab, edi_emp;
    JMenuItem cerrar_sesion;
    JButton a_hue, a_hab, a_emp, a_tar;
    JButton v_hue, v_hab, v_emp, v_tar, v_rep;
    JButton el_hue, el_hab, el_emp, cerrars;
    JButton ed_hue, ed_hab, ed_emp;
    Font letras;
    KeyStroke ks, ks2, ks3, ks4, ks5, ks6, ks7, ks8, ks9, ks10, ks11, ks12, ks13, ks14, ks15, ks16;
    Color color, fuente;
    int tt;

    void us(int tipo) {
        this.tt=tipo;
    }
    void init() {
        principal = new BorderLayout();
        setLayout(principal); 
        
        panel = new JPanel();
        grid = new GridLayout(4,4);
        barramenu = new JMenuBar();
        nuevo = new JMenu("Registrar");
        ver = new JMenu("Ver");
        edicion = new JMenu("Editar");
        eliminar = new JMenu("Eliminar");
        cerrar = new JMenu("Cerrar");
        
        nuevo_hues = new JMenuItem("Registrar Huesped");
        nueva_hab = new JMenuItem("Registrar Habitacion");
        nuevo_emp = new JMenuItem("Registrar Empleado");
        nueva_tar = new JMenuItem("Asignar Tarea");
        ver_huesp = new JMenuItem("Ver Huespedes");
        ver_hab = new JMenuItem("Ver Habitaciones");
        ver_emp = new JMenuItem("Ver Empleados");
        ver_rep = new JMenuItem("Ver Reportes");
        ver_tar = new JMenuItem("Ver Tareas Asignadas");
        eli_huesp = new JMenuItem("Eliminar Reservacion");
        eli_hab = new JMenuItem("Eliminar Habitacion");
        eli_emp = new JMenuItem("Eliminar Empleado");
        edi_huesp = new JMenuItem("Editar Reservacion");
        edi_hab = new JMenuItem("Editar Habitacion");
        edi_emp = new JMenuItem("Editar Empleado");
        cerrar_sesion = new JMenuItem("Cerrar Sesion");
        ks = KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK);
        ks2 = KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK);
        ks3 = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK);
        ks4 = KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK);
        ks5 = KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_MASK);
        ks6 = KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_MASK);
        ks7 = KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_MASK);
        ks8 = KeyStroke.getKeyStroke(KeyEvent.VK_J, KeyEvent.CTRL_MASK);
        ks9 = KeyStroke.getKeyStroke(KeyEvent.VK_K, KeyEvent.CTRL_MASK);
        ks10 = KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_MASK);
        ks11 = KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_MASK);
        ks12 = KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK);
        ks13 = KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_MASK);
        ks14 = KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.CTRL_MASK);
        ks15 = KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_MASK);
        ks16 = KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_MASK);
        letras = new Font("Consolas", Font.PLAIN, 22);
        color = new Color(41, 100, 185 );
        fuente = new Color(120, 115, 200);
        
        a_hue = new JButton("<html><center>Agregar <br>Huespedes</center></html>");
        a_hue.addActionListener(this);
        a_hue.setFont(letras);
        a_hue.setBackground(Color.WHITE);
        a_hue.setForeground(fuente);
        a_hue.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        
        a_hab = new JButton("<html><center>Agregar <br>Habitaciones</center></html>");
        a_hab.addActionListener(this);
        a_hab.setFont(letras);
        a_hab.setBackground(Color.WHITE);
        a_hab.setForeground(fuente);
        a_hab.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
              
        a_emp = new JButton("<html><center>Agregar <br>Empleado</center></html>");
        a_emp.addActionListener(this);
        a_emp.setFont(letras);
        a_emp.setBackground(Color.WHITE);
        a_emp.setForeground(fuente);
        a_emp.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));        
        
        a_tar = new JButton("<html><center>Asignar <br>Tareas</center></html>");
        a_tar.addActionListener(this);
        a_tar.setFont(letras);
        a_tar.setBackground(Color.WHITE);
        a_tar.setForeground(fuente);
        a_tar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        
        v_hue = new JButton("<html><center>Ver <br>Reservaciones</center></html>");
        v_hue.addActionListener(this);
        v_hue.setFont(letras);
        v_hue.setBackground(Color.WHITE);
        v_hue.setForeground(fuente);
        v_hue.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        
        v_hab = new JButton("<html><center>Ver <br>Habitaciones</center></html>");
        v_hab.addActionListener(this);
        v_hab.setFont(letras);
        v_hab.setBackground(Color.WHITE);
        v_hab.setForeground(fuente);
        v_hab.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        
        v_emp = new JButton("<html><center>Ver <br>Empleados</center></html>");
        v_emp.addActionListener(this);
        v_emp.setFont(letras);
        v_emp.setBackground(Color.WHITE);
        v_emp.setForeground(fuente);
        v_emp.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));        

        v_tar = new JButton("<html><center>Ver Tareas<br>Asignadas</center></html>");
        v_tar.addActionListener(this);
        v_tar.setFont(letras);
        v_tar.setBackground(Color.WHITE);
        v_tar.setForeground(fuente);
        v_tar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        
        v_rep = new JButton("<html><center>Ver Reportes<br>de Huespedes</center></html>");
        v_rep.addActionListener(this);
        v_rep.setFont(letras);
        v_rep.setBackground(Color.WHITE);
        v_rep.setForeground(fuente);
        v_rep.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));

        el_hue = new JButton("<html><center>Eliminar <br>Reservaciones</center></html>");
        el_hue.addActionListener(this);
        el_hue.setFont(letras);
        el_hue.setBackground(Color.WHITE);
        el_hue.setForeground(fuente);
        el_hue.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        
        el_hab = new JButton("<html><center>Eliminar <br>Habitaciones</center></html>");
        el_hab.addActionListener(this);
        el_hab.setFont(letras);
        el_hab.setBackground(Color.WHITE);
        el_hab.setForeground(fuente);
        el_hab.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        
        el_emp = new JButton("<html><center>Eliminar <br>Empleados</center></html>");
        el_emp.addActionListener(this);
        el_emp.setFont(letras);
        el_emp.setBackground(Color.WHITE);
        el_emp.setForeground(fuente);
        el_emp.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        
        ed_hue = new JButton("<html><center>Editar <br>Reservaciones</center></html>");
        ed_hue.addActionListener(this);
        ed_hue.setFont(letras);
        ed_hue.setBackground(Color.WHITE);
        ed_hue.setForeground(fuente);
        ed_hue.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));                

        ed_hab = new JButton("<html><center>Editar <br>Habitaciones</center></html>");
        ed_hab.addActionListener(this);
        ed_hab.setFont(letras);
        ed_hab.setBackground(Color.WHITE);
        ed_hab.setForeground(fuente);
        ed_hab.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        
        ed_emp = new JButton("<html><center>Editar <br>Empleados</center></html>");        
        ed_emp.addActionListener(this);
        ed_emp.setFont(letras);
        ed_emp.setBackground(Color.WHITE);
        ed_emp.setForeground(fuente);
        ed_emp.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        
        cerrars = new JButton("<html><center>Cerrar <br>Sesion</center></html>");
        cerrars.addActionListener(this);
        cerrars.setFont(letras);
        cerrars.setBackground(Color.WHITE);
        cerrars.setForeground(fuente);
        cerrars.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
                
        barramenu.add(nuevo);
        barramenu.add(ver);
        barramenu.add(edicion);
        barramenu.add(eliminar);
        barramenu.add(cerrar);
        
        nuevo.add(nuevo_hues);
        nuevo.add(nueva_hab);
        nuevo.add(nuevo_emp);
        nuevo.add(nueva_tar);
        ver.add(ver_huesp);
        ver.add(ver_hab);
        ver.add(ver_emp);
        ver.add(ver_rep);
        ver.add(ver_tar);
        eliminar.add(eli_huesp);
        eliminar.add(eli_hab);
        eliminar.add(eli_emp);
        edicion.add(edi_huesp);
        edicion.add(edi_hab);
        edicion.add(edi_emp);
        cerrar.add(cerrar_sesion);
        
        nuevo_hues.setAccelerator(ks);
        nueva_hab.setAccelerator(ks2);
        nuevo_emp.setAccelerator(ks3);
        nueva_tar.setAccelerator(ks4);
        ver_huesp.setAccelerator(ks5);
        ver_hab.setAccelerator(ks6);
        ver_emp.setAccelerator(ks7);
        ver_rep.setAccelerator(ks8);
        ver_tar.setAccelerator(ks9);
        eli_huesp.setAccelerator(ks10);
        eli_hab.setAccelerator(ks11);
        eli_emp.setAccelerator(ks12);
        edi_huesp.setAccelerator(ks13);
        edi_hab.setAccelerator(ks14);
        edi_emp.setAccelerator(ks15);
        cerrar_sesion.setAccelerator(ks16);
        
        nuevo_hues.setMnemonic(KeyEvent.VK_Q);
        nueva_hab.setMnemonic(KeyEvent.VK_A);
        nuevo_emp.setMnemonic(KeyEvent.VK_S);
        nueva_tar.setMnemonic(KeyEvent.VK_D);
        ver_huesp.setMnemonic(KeyEvent.VK_F);
        ver_hab.setMnemonic(KeyEvent.VK_G);
        ver_emp.setMnemonic(KeyEvent.VK_H);
        ver_rep.setMnemonic(KeyEvent.VK_J);
        ver_tar.setMnemonic(KeyEvent.VK_K);
        eli_huesp.setMnemonic(KeyEvent.VK_L);
        eli_hab.setMnemonic(KeyEvent.VK_W);
        eli_emp.setMnemonic(KeyEvent.VK_E);
        edi_huesp.setMnemonic(KeyEvent.VK_R);
        edi_hab.setMnemonic(KeyEvent.VK_T);
        edi_emp.setMnemonic(KeyEvent.VK_Y);
        cerrar_sesion.setMnemonic(KeyEvent.VK_U);      
        
        panel.setLayout(grid);

        panel.add(a_emp);
        panel.add(v_emp);
        panel.add(ed_emp);
        panel.add(el_emp);
        panel.add(a_hab);
        panel.add(v_hab);
        panel.add(ed_hab);
        panel.add(el_hab);
        panel.add(a_hue);
        panel.add(v_hue);
        panel.add(ed_hue);
        panel.add(el_hue);
        panel.add(a_tar);
        panel.add(v_tar);
        panel.add(v_rep);
        panel.add(cerrars);
        
        cerrar_sesion.addActionListener(this);
       
        add(barramenu, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        setSize(900, 600);
        setLocation(180, 50);
        setTitle("Drake & Josh Inn");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); 
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.png")).getImage());
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cerrars || e.getSource()==cerrar_sesion){
            this.dispose();
            Login l = new Login();
            l.init();
        }else if(e.getSource()==nuevo_hues || e.getSource()==a_hue){
            this.dispose();
            AgregarHuesped a = null;
            try {
                a = new AgregarHuesped();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            a.init();
            a.us(tt);
        }else if(e.getSource()==nueva_hab || e.getSource()==a_hab){
            this.dispose();
            AgregarHabitacion b = new AgregarHabitacion();
            try {
                b.init();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            b.us(tt);
        }else if(e.getSource()==nuevo_emp || e.getSource()==a_emp){
            this.dispose();
            AgregarEmpleado c = new AgregarEmpleado();
            try {
                c.init();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource()==ver_huesp || e.getSource()==v_hue){
            this.dispose();
            VerHuespedes f = null;
            try {
                f = new VerHuespedes();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            f.init();
            f.us(tt);
        }else if(e.getSource()==ver_hab || e.getSource()==v_hab){
            this.dispose();
            VerHabitaciones g = null;
            try {
                g = new VerHabitaciones();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            g.init();
            g.us(tt);
        }else if(e.getSource()==ver_emp || e.getSource()==v_emp){
            this.dispose();
            VerEmpleados h = new VerEmpleados();
            h.init();
        }else if(e.getSource()==nueva_tar || e.getSource()==a_tar){
            this.dispose();
            AsignarTarea d = new AsignarTarea();
            d.init();
        }else if(e.getSource()==v_tar || e.getSource()==ver_tar){
            this.dispose();
            VerTareasAs i = null;
            try {
                i = new VerTareasAs();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            i.init();
        }else if(e.getSource()==ver_rep || e.getSource()==v_rep){
            this.dispose();
            VerReportes j = null;
            try {
                j = new VerReportes();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            j.init();
            j.us(tt);
        }else if(e.getSource()==eli_huesp || e.getSource()==el_hue){
            this.dispose();
            EliminarHuesped k = null;
            try {
                k = new EliminarHuesped();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            k.init();
            k.us(tt);
        }else if(e.getSource()==eli_hab || e.getSource()==el_hab){
            this.dispose();
            EliminarHab m = null;
            try {
                m = new EliminarHab();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            m.init();
            m.us(tt);
        }else if(e.getSource()==eli_emp || e.getSource()==el_emp){
            this.dispose();
            EliminarEmp n = null;
            try {
                n = new EliminarEmp();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            n.init();
        }else if(e.getSource()==edi_huesp || e.getSource()==ed_hue){
            this.dispose();
            EditarHuesped o = null;
            try {
                o = new EditarHuesped();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            o.init();
            o.us(tt);
        }else if(e.getSource()==edi_hab || e.getSource()==ed_hab){
            this.dispose();
            EditarHabitacion p = null;
            try {
                p = new EditarHabitacion();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            p.init();
            p.us(tt);
        }else if(e.getSource()==edi_emp || e.getSource()==ed_emp){
            this.dispose();
            EditarEmpleado q = null;
            try {
                q = new EditarEmpleado();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            q.init();
        } 
    }
}
