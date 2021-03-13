package Vistas;

import Datos.ValidarCampos;
import Motor.EmpleadoMotor;
import Motor.Parametros;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class AgregarHabitacion extends JFrame implements ActionListener {
    EmpleadoMotor aux;
    JTextField nombre_txt, costo_txt, capacidad_txt, piso_txt;
    JTextArea caracteristicas_txt;
    JLabel nombre_lbl, costo_lbl, cap_lbl, carac_lbl, id_lbl, instruccion, person, piso;
    JButton confirmar, regresar;
    JPanel panel;
    Font letras;
    Color color, fuente;
    JScrollPane scroll;
    Dimension d;
    int id;
    int tt;
    String usua;
    
    void us(int tipo) {
        this.tt=tipo;
    }
    void usua(String user){
        this.usua=user;
    }
    void init() throws ClassNotFoundException {
        panel = new JPanel();
        setLayout(null);
        ((JPanel)getContentPane()).setBackground(Color.WHITE);
        setLayout(null);
        aux = new EmpleadoMotor();
        id=aux.obeteneridhab();
        d = new Dimension();
        letras = new Font("Consolas", Font.PLAIN, 18);
        color = new Color(41, 100, 185);
        fuente = new Color(120, 115, 200);
        d.width=100;
        d.height=100;
        
        regresar = new JButton("Regresar");
        regresar.setFont(letras);
        regresar.setBackground(color);
        regresar.setForeground(Color.WHITE);        
        regresar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        regresar.addActionListener(this); 
        regresar.setBounds(10, 10, 189, 40);
        add(regresar);
        
        instruccion = new JLabel("Complete los datos de la habitacion y luego de click en confirmar");
        instruccion.setFont(letras);
        instruccion.setBounds(100, 60, 720, 40);
        add(instruccion);
        
        id_lbl = new JLabel("ID: "+id);
        id_lbl.setFont(letras);
        id_lbl.setBounds(60, 100, 220, 40);
        add(id_lbl);
        
        nombre_lbl = new JLabel("Nombre de la habitacion");
        nombre_lbl.setFont(new Font("Consolas", Font.PLAIN, 15));
        nombre_lbl.setBounds(15, 170, 240, 40);
        add(nombre_lbl);
        
        nombre_txt = new JTextField();
        nombre_txt.setFont(letras);
        nombre_txt.setBounds(210, 170, 260, 40);
        nombre_txt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
        add(nombre_txt);
                
        costo_lbl = new JLabel("Costo por noche");
        costo_lbl.setFont(letras);
        costo_lbl.setBounds(40, 250, 240, 40);
        add(costo_lbl);
        
        costo_txt = new JTextField();
        costo_txt.setFont(letras);
        costo_txt.setBounds(210, 250, 260, 40);
        costo_txt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
        add(costo_txt);
        
        cap_lbl = new JLabel("Capacidad ");
        cap_lbl.setFont(letras);
        cap_lbl.setBounds(69, 320, 240, 40);
        add(cap_lbl);
        
        capacidad_txt = new JTextField();
        capacidad_txt.setFont(letras);
        capacidad_txt.setBounds(210, 320, 50, 40);
        capacidad_txt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
        add(capacidad_txt);
        
        person = new JLabel(" personas ");
        person.setFont(letras);
        person.setBounds(260, 320, 240, 40);
        add(person);
        
        piso = new JLabel("     Piso ");
        piso.setFont(letras);
        piso.setBounds(69, 390, 240, 40);
        add(piso);
        
        piso_txt = new JTextField();
        piso_txt.setFont(letras);
        piso_txt.setBounds(210, 390, 240, 40);
        piso_txt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
        add(piso_txt);

        carac_lbl = new JLabel("Caracteristicas");
        carac_lbl.setFont(letras);
        carac_lbl.setBounds(550, 100, 240, 40);
        add(carac_lbl);
        
        caracteristicas_txt = new JTextArea();
        caracteristicas_txt.setLineWrap(true);
        caracteristicas_txt.setFont(letras);
        caracteristicas_txt.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        scroll = new JScrollPane(caracteristicas_txt);
        caracteristicas_txt.setFont(letras);
        scroll.setBounds(550, 140, 240, 240);
        add(scroll);
        
        confirmar = new JButton("Confirmar");        
        confirmar.setFont(letras);
        confirmar.setBackground(color);
        confirmar.setForeground(Color.WHITE);
        confirmar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        confirmar.addActionListener(this); 
        confirmar.setBounds(340, 460, 220, 40);
        add(confirmar);
        
        add(panel);
        setSize(900, 600);
        setLocation(180, 50);
        setTitle("Drake & Josh Inn");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);   
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.png")).getImage()); 
        setMinimumSize(d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==regresar){
            if(tt==1){
                this.dispose();
                MenuEmpleado me = new MenuEmpleado();
                me.init();
                me.us(1);
                me.usua(usua);
            }else if(tt==2){
                this.dispose();
                MenuAdmin ma = new MenuAdmin();
                ma.init();
                ma.us(2);
            }   
        }
        if(e.getSource()==confirmar){
            ValidarCampos v = new ValidarCampos();
            String c = caracteristicas_txt.getText();
            String nombre = nombre_txt.getText();
            String cap = capacidad_txt.getText();
            String costo = costo_txt.getText();
            String ps = piso_txt.getText();
            int capac, cos, piso;
            
            if(v.Letras(nombre, "el nombre")){
                if(v.Numeros(cap, "la capacidad")){
                    if(v.Vacio(c, "las caracteristicas")){
                        if(v.Numeros(costo, "el costo")){
                            if(v.Numeros(ps, "el piso")){
                                capac = Integer.parseInt(cap);
                                cos = Integer.parseInt(costo);
                                piso = Integer.parseInt(ps);
                                aux.agregarhab(id, capac, nombre, c, cos, piso);
                                int ax = JOptionPane.showConfirmDialog(null, "Habitacion agregada correctamente ¿Desea agregar otra?");
                            if (ax == JOptionPane.YES_OPTION) {
                                nombre_txt.setText("");
                                caracteristicas_txt.setText("");
                                capacidad_txt.setText("");
                                costo_txt.setText("");
                                piso_txt.setText("");
                                id++;
                                id_lbl.setText("ID: "+id);
                            }else if(ax==JOptionPane.NO_OPTION){
                                this.dispose();
                                if(tt==1){
                                    this.dispose();
                                    MenuEmpleado me = new MenuEmpleado();
                                    me.init();
                                    me.us(1);
                                    me.usua(usua);
                                }else if(tt==2){
                                    this.dispose();
                                    MenuAdmin ma = new MenuAdmin();
                                    ma.init();
                                    ma.us(2);
                                }   
                            }
                            }else{
                                JOptionPane.showMessageDialog(this, v.err(), "Error", JOptionPane.ERROR_MESSAGE);
                                piso_txt.requestFocus();
                            }
                        }else{
                            JOptionPane.showMessageDialog(this, v.err(), "Error", JOptionPane.ERROR_MESSAGE);
                            costo_txt.requestFocus();
                        }
                    }else{
                        JOptionPane.showMessageDialog(this, v.err(), "Error", JOptionPane.ERROR_MESSAGE);
                        caracteristicas_txt.requestFocus();
                    }
                }else{
                    JOptionPane.showMessageDialog(this, v.err(), "Error", JOptionPane.ERROR_MESSAGE);
                    capacidad_txt.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(this, v.err(), "Error", JOptionPane.ERROR_MESSAGE);
                nombre_txt.requestFocus();
            }
        }
    }
} 