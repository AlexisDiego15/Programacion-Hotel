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

class MenuEmpleado extends JFrame implements ActionListener{
    BorderLayout principal;
    GridLayout grid;
    JPanel panel;
    JMenuBar barramenu;
    JMenu nuevo, ver, edicion, eliminar, cerrar;
    JMenuItem nuevo_hues, nueva_hab;
    JMenuItem ver_huesp, ver_hab, ver_rep, ver_tar;
    JMenuItem eli_huesp, eli_hab;
    JMenuItem edi_huesp, edi_hab;
    JMenuItem cerrar_sesion;
    JButton a_hue, a_hab;
    JButton v_hue, v_hab, v_tar, v_rep;
    JButton el_hue, el_hab, cerrars;
    JButton ed_hue, ed_hab, disponibilidad;
    Font letras;
    String usuario;
    Color color, fuente;
    KeyStroke ks, ks2, ks5, ks6, ks8, ks9, ks10, ks11, ks13, ks14, ks16;
    int t;

    void us(int tipo){
        this.t=tipo;
    }
    void usua(String user){
        this.usuario=user;
    }
    
    void init() {
        principal = new BorderLayout();
        setLayout(principal); 
        
        panel = new JPanel();
        grid = new GridLayout(3,4);
        barramenu = new JMenuBar();
        nuevo = new JMenu("Registrar");
        ver = new JMenu("Ver");
        edicion = new JMenu("Editar");
        eliminar = new JMenu("Eliminar");
        cerrar = new JMenu("Cerrar");
        
        nuevo_hues = new JMenuItem("Registrar Huesped");
        nueva_hab = new JMenuItem("Registrar Habitacion");
        ver_huesp = new JMenuItem("Ver Huespedes");
        ver_hab = new JMenuItem("Ver Habitaciones");
        ver_rep = new JMenuItem("Ver Reportes");
        ver_tar = new JMenuItem("Ver Tareas Asignadas");
        eli_huesp = new JMenuItem("Eliminar Reservacion");
        eli_hab = new JMenuItem("Eliminar Habitacion");
        edi_huesp = new JMenuItem("Editar Reservacion");
        edi_hab = new JMenuItem("Editar Habitacion");
        cerrar_sesion = new JMenuItem("Cerrar Sesion");
        
        ks = KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK);
        ks2 = KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK);
        ks5 = KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_MASK);
        ks6 = KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_MASK);
        ks8 = KeyStroke.getKeyStroke(KeyEvent.VK_J, KeyEvent.CTRL_MASK);
        ks9 = KeyStroke.getKeyStroke(KeyEvent.VK_K, KeyEvent.CTRL_MASK);
        ks10 = KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_MASK);
        ks11 = KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_MASK);
        ks13 = KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_MASK);
        ks14 = KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.CTRL_MASK);
        ks16 = KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_MASK);
        letras = new Font("Consolas", Font.PLAIN, 22);
        color = new Color(41, 100, 185 );
        fuente = new Color(120, 115, 200);
        
        a_hue = new JButton("<html><center>Agregar <br>Reservaciones</center></html>");
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
        
        disponibilidad = new JButton("<html><center>Editar <br>Contraseña</center></html>");
        disponibilidad.addActionListener(this);
        disponibilidad.setFont(letras);
        disponibilidad.setBackground(Color.WHITE);
        disponibilidad.setForeground(fuente);
        disponibilidad.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        
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
        ver.add(ver_huesp);
        ver.add(ver_hab);
        ver.add(ver_rep);
        ver.add(ver_tar);
        eliminar.add(eli_huesp);
        eliminar.add(eli_hab);
        edicion.add(edi_huesp);
        edicion.add(edi_hab);
        cerrar.add(cerrar_sesion);
        
        nuevo_hues.setAccelerator(ks);
        nueva_hab.setAccelerator(ks2);
        ver_huesp.setAccelerator(ks5);
        ver_hab.setAccelerator(ks6);
        ver_rep.setAccelerator(ks8);
        ver_tar.setAccelerator(ks9);
        eli_huesp.setAccelerator(ks10);
        eli_hab.setAccelerator(ks11);
        edi_huesp.setAccelerator(ks13);
        edi_hab.setAccelerator(ks14);
        cerrar_sesion.setAccelerator(ks16);
        
        nuevo_hues.setMnemonic(KeyEvent.VK_Q);
        nueva_hab.setMnemonic(KeyEvent.VK_A);
        ver_huesp.setMnemonic(KeyEvent.VK_F);
        ver_hab.setMnemonic(KeyEvent.VK_G);
        ver_rep.setMnemonic(KeyEvent.VK_J);
        ver_tar.setMnemonic(KeyEvent.VK_K);
        eli_huesp.setMnemonic(KeyEvent.VK_L);
        eli_hab.setMnemonic(KeyEvent.VK_W);
        edi_huesp.setMnemonic(KeyEvent.VK_R);
        edi_hab.setMnemonic(KeyEvent.VK_T);
        cerrar_sesion.setMnemonic(KeyEvent.VK_U);      
        
        panel.setLayout(grid);

        panel.add(a_hab);
        panel.add(v_hab);
        panel.add(ed_hab);
        panel.add(el_hab);
        panel.add(a_hue);
        panel.add(v_hue);
        panel.add(ed_hue);
        panel.add(el_hue);
        panel.add(v_tar);
        panel.add(v_rep);
        panel.add(disponibilidad);
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
        if(e.getSource()==cerrar_sesion || e.getSource()==cerrars){
            this.dispose();
            Login l = new Login();
            l.init();
        }else if(e.getSource()==nuevo_hues || e.getSource()==a_hue){
            this.dispose();
            AgregarHuesped a = null;
            try {
                a = new AgregarHuesped();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            a.us(t);
            a.usua(usuario);
            a.init();
        }else if(e.getSource()==nueva_hab || e.getSource()==a_hab){
            this.dispose();
            AgregarHabitacion b = new AgregarHabitacion();
            b.us(t);
            b.usua(usuario);
            try {
                b.init();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else  if(e.getSource()==ver_huesp || e.getSource()==v_hue){
            this.dispose();
            VerHuespedes f = null;    
            try {
                f = new VerHuespedes();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            f.us(t);
            f.usua(usuario);
            f.init();
        }else if(e.getSource()==ver_hab || e.getSource()==v_hab){
            this.dispose();
            VerHabitaciones g = null;
            try {
                g = new VerHabitaciones();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            g.us(t);
            g.usua(usuario);
            g.init();
        }else if(e.getSource()==v_tar || e.getSource()==ver_tar){
            this.dispose();
            VerTareas i = null;
            try {
                i = new VerTareas();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            i.us(t);
            i.usua(usuario);
            i.init();
        }else if(e.getSource()==ver_rep || e.getSource()==v_rep){
            this.dispose();
            VerReportes j = null;
            try {
                j = new VerReportes();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            j.us(t);
            j.usua(usuario);
            j.init();
        }else if(e.getSource()==eli_huesp || e.getSource()==el_hue){
            this.dispose();
            EliminarHuesped k = null;
            try {
                k = new EliminarHuesped();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            k.us(t);
            k.usua(usuario); 
            k.init();           
        }else if(e.getSource()==eli_hab || e.getSource()==el_hab){
            this.dispose();
            EliminarHab m = null;
            try {
                m = new EliminarHab();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            m.us(t);
            m.usua(usuario);
            m.init();
        }else if(e.getSource()==edi_huesp || e.getSource()==ed_hue){
            this.dispose();
            EditarHuesped o = null;
            try {
                o = new EditarHuesped();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            o.us(t);
            o.usua(usuario);
            o.init();
        }else if(e.getSource()==edi_hab || e.getSource()==ed_hab){
            this.dispose();
            EditarHabitacion p = null;  
            try {
                p = new EditarHabitacion();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            p.us(1);
            p.usua(usuario);
            p.init();
        }else if(e.getSource()==disponibilidad){
            this.dispose();
            EditarCon q = null;      
            try {
                q = new EditarCon();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            q.us(1);
            q.usua(usuario);
            q.init();
        } 
    }
}
