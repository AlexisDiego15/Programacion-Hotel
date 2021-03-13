package Vistas;

import static Motor.EmpleadoMotor.Habitacion;
import static Motor.EmpleadoMotor.Huesped;
import Datos.ValidarCampos;
import Motor.EmpleadoMotor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class MenuHuesped extends JFrame implements ActionListener{
    String use;
    BorderLayout principal;
    GridLayout grid, grid2;
    JPanel panel, panelrep, paneldet, bienvenido;
    JButton reporte, verhab, cerrarsesion;
    Font letras, letras3;
    Color color, fuente;
    JTextArea caracteristicas_txt;
    JLabel instruccion, welcome;
    JButton confirmar;
    JScrollPane scroll; 
    EmpleadoMotor aux;
    int iduser, idhab;
    JTextArea hab, res;
    
    public MenuHuesped() throws ClassNotFoundException{
        aux = new EmpleadoMotor();
        aux.archivohab();
        aux.archivohuesped();
    }
    void us(String user) {
        this.use=user;
    }
    void init() {
        principal = new BorderLayout();
        setLayout(principal); 
        
        panel = new JPanel();
        grid = new GridLayout(1,3);
        
        bienvenido = new JPanel();
        bienvenido.setLayout(null);
        bienvenido.setVisible(true);
        bienvenido.setBackground(Color.WHITE);
        
        panelrep = new JPanel();
        panelrep.setLayout(null);
        panelrep.setVisible(false);
        panelrep.setBackground(Color.WHITE);
        
        paneldet = new JPanel();
        paneldet.setLayout(null);
        paneldet.setVisible(false);
        paneldet.setBackground(Color.WHITE);
                
        letras = new Font("Consolas", Font.PLAIN, 22);
        letras3 = new Font("Consolas", Font.PLAIN, 60);
        color = new Color(41, 100, 185 );
        fuente = new Color(120, 115, 200);
        
        reporte = new JButton("<html><center>Enviar <br>Reporte</center></html>");
        reporte.addActionListener(this);
        reporte.setFont(letras);
        reporte.setBackground(Color.WHITE);
        reporte.setForeground(fuente);
        reporte.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        
        verhab = new JButton("<html><center>Ver Detalles <br>de Reservacion</center></html>");
        verhab.addActionListener(this);
        verhab.setFont(letras);
        verhab.setBackground(Color.WHITE);
        verhab.setForeground(fuente);
        verhab.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        
        cerrarsesion = new JButton("<html><center>Cerrar <br>Sesion</center></html>");
        cerrarsesion.addActionListener(this);
        cerrarsesion.setFont(letras);
        cerrarsesion.setBackground(Color.WHITE);
        cerrarsesion.setForeground(fuente);
        cerrarsesion.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        
        panel.setLayout(grid);
        panel.add(reporte);
        panel.add(verhab);
        panel.add(cerrarsesion);
        
        welcome = new JLabel("BIENVENIDO!");
        welcome.setFont(letras3);
        welcome.setBounds(100, 200, 720, 100);
        bienvenido.add(welcome);
        
        instruccion = new JLabel("Escriba la falla o reporte");
        instruccion.setFont(letras);
        instruccion.setBounds(100, 60, 720, 40);
        panelrep.add(instruccion);
        
        caracteristicas_txt = new JTextArea();
        caracteristicas_txt.setLineWrap(true);
        caracteristicas_txt.setFont(letras);
        caracteristicas_txt.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        scroll = new JScrollPane(caracteristicas_txt);
        caracteristicas_txt.setFont(letras);
        scroll.setBounds(100, 140, 600, 250);
        panelrep.add(scroll);
        
        confirmar = new JButton("Confirmar");        
        confirmar.setFont(letras);
        confirmar.setBackground(color);
        confirmar.setForeground(Color.WHITE);
        confirmar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        confirmar.addActionListener(this); 
        confirmar.setBounds(340, 440, 220, 40);
        panelrep.add(confirmar);
        
        hab = new JTextArea();
        hab.setLineWrap(true);
        hab.setFont(letras);
        hab.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        hab.setDisabledTextColor(Color.BLACK);
        hab.setFont(letras);
        hab.setBounds(100, 50, 600, 200);
        paneldet.add(hab);
        
        res = new JTextArea();
        res.setLineWrap(true);
        res.setFont(letras);
        res.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        res.setDisabledTextColor(Color.BLACK);
        res.setFont(letras);
        res.setBounds(100, 270, 600, 200);
        paneldet.add(res);
        
        for(int i=0; i<Huesped.size(); i++){
            if(Huesped.get(i).getUsuario().equals(use)){
                iduser=Huesped.get(i).getId();
                idhab=Huesped.get(i).getHabitacion();
            } 
        }
        for(int i=0; i<Habitacion.size(); i++){
            if(Habitacion.get(i).getId()==idhab){
               hab.setText(Habitacion.get(i).getNombre()+" para " +Habitacion.get(i).getPersonas()+" personas, cuenta con "
                +Habitacion.get(i).getCaracteristicas()+" ubicada en el piso "+Habitacion.get(i).getPiso());
            }
        }
        for(int j=0; j<Huesped.size(); j++){
            if(Huesped.get(j).getId()==iduser){
                res.setText("Tu estancia empieza el dia "+Huesped.get(j).getFecha_i()+
                        " y termina el dia "+Huesped.get(j).getFecha_f());
            }
        }
        
        add(panel, BorderLayout.NORTH);
        add(bienvenido, BorderLayout.CENTER);
        setSize(900, 600);
        setLocation(180, 50);
        setTitle("Drake & Josh Inn");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); 
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.png")).getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cerrarsesion){
            this.dispose();
            Login l = new Login();
            l.init();
        }
        if(e.getSource()==verhab){
            bienvenido.setVisible(false);
            panelrep.setVisible(false);
            paneldet.setVisible(true);
            add(paneldet, BorderLayout.CENTER);
        }
        if(e.getSource()==reporte){
            bienvenido.setVisible(false);
            paneldet.setVisible(false);
            panelrep.setVisible(true);
            add(panelrep, BorderLayout.CENTER);            
        }
        if(e.getSource()==confirmar){
            ValidarCampos v = new ValidarCampos();
            String rep = caracteristicas_txt.getText();
            if(v.Vacio(rep, "la falla o reporte")){
                aux.registrarp(rep, use);
                JOptionPane.showMessageDialog(this, "Tu mensaje se envió correctamente");
            }else{
                JOptionPane.showMessageDialog(this, v.err(), "Error", JOptionPane.ERROR_MESSAGE);
                caracteristicas_txt.requestFocus();
            }
        }
        
    }
}
