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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.bolivia.combo.SComboBox;

public class AgregarEmpleado extends JFrame implements ActionListener {
    EmpleadoMotor aux;
    JTextField user_txt, nombre_txt, apellido_txt, ocupacion_txt;
    JPasswordField pass_txt;
    JLabel user_lbl, pass_lbl, nombre_lbl, apellido_lbl, id_lbl, cargo_lbl, tipo_lbl, instruccion;
    SComboBox tipo;
    JButton confirmar, regresar;
    JPanel panel;
    Font letras;
    Color color, fuente;
    int id;
    int id_tipo;
    Dimension d;
    
    void init() throws ClassNotFoundException {
        panel = new JPanel();
        setLayout(null);  
        ((JPanel)getContentPane()).setBackground(Color.WHITE);      
        d = new Dimension();
        aux = new EmpleadoMotor();
        id=aux.obtenerid();
        letras = new Font("Consolas", Font.PLAIN, 18);
        color = new Color(41, 100, 185);
        fuente = new Color(120, 115, 200);
        d.width=600;
        d.height=550;
        
        instruccion = new JLabel("Complete con datos del empleado y luego de click en confirmar");
        instruccion.setFont(letras);
        instruccion.setBounds(100, 60, 720, 40);
        add(instruccion);
        
        nombre_lbl = new JLabel("Nombre(s):");
        nombre_lbl.setFont(letras);
        nombre_lbl.setBounds(60, 109, 220, 40);
        add(nombre_lbl);
        
        nombre_txt = new JTextField();
        nombre_txt.setFont(letras);
        nombre_txt.setBounds(170, 100, 280, 40);
        nombre_txt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
        add(nombre_txt);
        
        apellido_lbl = new JLabel("Apellidos:");
        apellido_lbl.setFont(letras);
        apellido_lbl.setBounds(55, 189, 240, 40);
        add(apellido_lbl);
       
        apellido_txt = new JTextField();
        apellido_txt.setFont(letras);
        apellido_txt.setBounds(170, 180, 280, 40);
        apellido_txt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
        add(apellido_txt);
        
        user_lbl = new JLabel("NSS:");
        user_lbl.setFont(letras);
        user_lbl.setBounds(120, 269, 240, 40);
        add(user_lbl);
        
        user_txt = new JTextField();
        user_txt.setFont(letras);
        user_txt.setBounds(170, 260, 280, 40);
        user_txt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
        add(user_txt);
        
        pass_lbl = new JLabel("Contraseña:");
        pass_lbl.setFont(letras);
        pass_lbl.setBounds(55, 349, 240, 40);
        add(pass_lbl);
        
        pass_txt = new JPasswordField();
        pass_txt.setFont(letras);
        pass_txt.setBounds(170, 340, 280, 40);
        pass_txt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
        add(pass_txt);
        
        id_lbl = new JLabel("ID: "+id);
        id_lbl.setFont(letras);
        id_lbl.setBounds(550, 100, 240, 40);
        add(id_lbl);
        
        cargo_lbl = new JLabel("Cargo: ");
        cargo_lbl.setFont(letras);
        cargo_lbl.setBounds(550, 189, 80, 40);
        add(cargo_lbl);
        
        ocupacion_txt = new JTextField();
        ocupacion_txt.setFont(letras);
        ocupacion_txt.setBounds(630, 180, 220, 40);
        ocupacion_txt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
        add(ocupacion_txt);

        tipo = new SComboBox();  
        tipo.setBounds(550, 260, 300, 40);
        tipo.addItem("Selecciona el tipo de empleado");
        tipo.addItem("1. Empleado General");
        tipo.addItem("2. Administrativo");
        tipo.setSelectedIndex(id_tipo);
        add(tipo);
        
        confirmar = new JButton("Confirmar");
        confirmar.setFont(letras);
        confirmar.setBackground(color);
        confirmar.setForeground(Color.WHITE);
        confirmar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        confirmar.addActionListener(this); 
        confirmar.setBounds(340, 430, 220, 40);
        add(confirmar);
        
        regresar = new JButton("Regresar");
        regresar.setFont(letras);
        regresar.setBackground(color);
        regresar.setForeground(Color.WHITE);        
        regresar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        regresar.addActionListener(this); 
        regresar.setBounds(10, 10, 189, 40);
        add(regresar);
        
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
            this.dispose();
            MenuAdmin ma = new MenuAdmin();
            ma.init();
            ma.us(2);
        }
        if(e.getSource()==confirmar){
            ValidarCampos v = new ValidarCampos();
            int t = tipo.getSelectedIndex();
            String user = user_txt.getText();
            String nombre = nombre_txt.getText();
            String apellido = apellido_txt.getText();
            String cargo = ocupacion_txt.getText();
            String pass = pass_txt.getText();
            if(v.Letras(nombre, "el nombre")){
                if(v.Letras(apellido, "el apellido")){
                    if(v.SinEspacios(user, "el NSS")){
                        if(v.SinEspacios(pass, "la contraseña")){
                            if(v.Vacio(cargo, "el cargo")){
                                if(t != 0){
                                    if(aux.agregar(t, nombre, apellido, cargo, user, pass, id)){
                                       int ax = JOptionPane.showConfirmDialog(null, "Empleado agregado correctamente ¿Desea agregar otro?");
                                    if (ax == JOptionPane.YES_OPTION) {
                                        user_txt.setText("");
                                        nombre_txt.setText("");
                                        apellido_txt.setText("");
                                        ocupacion_txt.setText("");
                                        pass_txt.setText("");
                                        id++;
                                        id_lbl.setText("ID: "+id);
                                    }else if(ax==JOptionPane.NO_OPTION){
                                        this.dispose();
                                        MenuAdmin ma = new MenuAdmin();
                                        ma.init();   
                                        ma.us(2);
                                    } 
                                    }else{
                                        JOptionPane.showMessageDialog(null, aux.error());
                                    }
                                    
                                }else{
                                    JOptionPane.showMessageDialog(null, "Selecciona el tipo de empleado");
                                    tipo.requestFocus();
                                }
                            }else{
                                JOptionPane.showMessageDialog(this, v.err(), "Error", JOptionPane.ERROR_MESSAGE);
                                ocupacion_txt.requestFocus();
                            }
                        }else{
                            JOptionPane.showMessageDialog(this, v.err(), "Error", JOptionPane.ERROR_MESSAGE);
                            pass_txt.requestFocus();
                        }
                    }else{
                        JOptionPane.showMessageDialog(this, v.err(), "Error", JOptionPane.ERROR_MESSAGE);
                        user_txt.requestFocus();
                    }
                }else{
                    JOptionPane.showMessageDialog(this, v.err(), "Error", JOptionPane.ERROR_MESSAGE);
                    apellido_txt.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(this, v.err(), "Error", JOptionPane.ERROR_MESSAGE);
                nombre_txt.requestFocus();
            }
        }
    } 
}