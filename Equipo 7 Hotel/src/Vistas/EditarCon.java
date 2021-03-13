package Vistas;
import static Motor.EmpleadoMotor.Empleado;
import Motor.EmpleadoMotor;
import Datos.ValidarCampos;
import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JPasswordField;

public class EditarCon extends JFrame implements ActionListener {
    EmpleadoMotor aux;   
    JPasswordField anterior, nueva, nuevacon;
    JButton confirmar, regresar;
    JLabel uno, dos, tres;
    JPanel panel;
    Font letras;
    Color color, fuente;
    int tt;
    String usua;
    
    public EditarCon() throws ClassNotFoundException{
        aux = new EmpleadoMotor();
        aux.archivoconsultarempleados();
    }
    
    void us(int tipo) {
        this.tt=tipo;
    }
    void usua(String user){
        this.usua=user;
    }
    void init(){
        panel = new JPanel();
        setLayout(null);
        ((JPanel)getContentPane()).setBackground(Color.WHITE);
        letras = new Font("Consolas", Font.PLAIN, 18);
        color = new Color(41, 100, 185);
        fuente = new Color(120, 115, 200);
        
        uno = new JLabel("Escriba su contraseña anterior");
        uno.setFont(letras);
        uno.setBounds(50, 109, 300, 40);
        add(uno);
        
        anterior = new JPasswordField();
        anterior.setFont(letras);
        anterior.setBounds(360, 100, 280, 40);
        anterior.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
        add(anterior);
        
        dos = new JLabel("Escriba su contraseña nueva");
        dos.setFont(letras);
        dos.setBounds(50, 189, 300, 40);
        add(dos);
       
        nueva = new JPasswordField();
        nueva.setFont(letras);
        nueva.setBounds(360, 180, 280, 40);
        nueva.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
        add(nueva);
        
        tres = new JLabel("Confirme su contraseña nueva");
        tres.setFont(letras);
        tres.setBounds(50, 269, 300, 40);
        add(tres);
        
        nuevacon = new JPasswordField();
        nuevacon.setFont(letras);
        nuevacon.setBounds(360, 260, 280, 40);
        nuevacon.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
        add(nuevacon);
        
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==regresar){
            this.dispose();
            MenuEmpleado ma = new MenuEmpleado();
            ma.init();
            ma.us(1);
            ma.usua(usua);
        }
        if(e.getSource()==confirmar){
            ValidarCampos v = new ValidarCampos();
            String passnueva = nuevacon.getText();
            String passant = anterior.getText();
            String passcon = nueva.getText();
                if(v.SinEspacios(passnueva, "la nueva contraseña")){
                    if(v.SinEspacios(passcon, "la nueva contraseña")){
                        if(v.SinEspacios(passant, "la anterior contraseña")){
                            if(passnueva.equals(passcon)){
                                for(int i=0; i<Empleado.size(); i++){
                                    if(Empleado.get(i).getContrasena().equals(usua)){
                                        if(Empleado.get(i).getContrasena().equals(passant)){
                                            try {
                                                if(aux.editarcontra(passnueva, passant, i)){
                                                    JOptionPane.showMessageDialog(null, aux.error());
                                                    this.dispose();
                                                    MenuEmpleado ma = new MenuEmpleado();
                                                    ma.init();
                                                    ma.us(1);
                                                    ma.usua(usua); 
                                                }   } catch (ClassNotFoundException ex) {
                                                Logger.getLogger(EditarCon.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }else{
                                            JOptionPane.showMessageDialog(null, "No coincide la contraseña anterioir");
                                        }
                                    }
                                }
                            }else{
                                JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
                        }}else{
                            JOptionPane.showMessageDialog(this, v.err(), "Error", JOptionPane.ERROR_MESSAGE);
                            anterior.requestFocus();
                        }
                    }else{
                        JOptionPane.showMessageDialog(this, v.err(), "Error", JOptionPane.ERROR_MESSAGE);
                        nueva.requestFocus();
                    }
                }else{
                    JOptionPane.showMessageDialog(this, v.err(), "Error", JOptionPane.ERROR_MESSAGE);
                    nuevacon.requestFocus();
                }                
            }
        }
    }
