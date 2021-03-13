package Vistas;

import Motor.EmpleadoMotor;
import Motor.Parametros;
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
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
    EmpleadoMotor aux;
    JTextField user_txt;
    JPasswordField pass_txt;
    JLabel user_lbl, pass_lbl;
    JButton confirmar;
    JPanel panel;
    Font letras, letrasb;
    
    public Login(){
        aux = new EmpleadoMotor();         
    }
    
    public void init(){
        panel = new JPanel();
        setLayout(null);
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/Imagenes/fondos.png"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, 900, 600);
        
        letras = new Font("Consolas", Font.PLAIN, 22);
        letrasb = new Font("Consolas", Font.PLAIN, 25);
        
        confirmar = new JButton("Confirmar");       
        confirmar.addActionListener(this);
        confirmar.setFont(letrasb);
        confirmar.setBackground(Color.WHITE);
        confirmar.setForeground(Color.BLUE);
        confirmar.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLUE));
        confirmar.setBounds(360, 420, 180, 40);
        add(confirmar);
        
        user_lbl = new JLabel("Usuario");
        user_lbl.setFont(letras);
        user_lbl.setBounds(310, 120, 220, 40); 
        add(user_lbl);

        pass_lbl = new JLabel("Contraseña");
        pass_lbl.setFont(letras);
        pass_lbl.setBounds(310, 230, 200, 40); 
        add(pass_lbl);
        
        user_txt = new JTextField();
        user_txt.setFont(letras);
        user_txt.setOpaque(false);
        user_txt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLUE));
        user_txt.setBounds(300, 160, 300, 40); 
        add(user_txt);
        
        pass_txt = new JPasswordField();
        pass_txt.setFont(letras);
        pass_txt.setOpaque(false);
        pass_txt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLUE));
        pass_txt.setBounds(300, 270, 300, 40); 
        add(pass_txt);
        
        add(panel);
        setResizable(false);
        setSize(900, 600);
        setLocation(180, 50);
        setTitle("Drake & Josh Inn");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);   
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.png")).getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==confirmar){
            String user, pass;
            int tipo=0;
            user=user_txt.getText();
            pass=pass_txt.getText();
            try {
                tipo=aux.login(user, pass);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(tipo==1){
               MenuEmpleado menu1 = new MenuEmpleado();
                this.dispose();
                menu1.init();
                menu1.us(tipo);
                menu1.usua(user);
            }else if(tipo==2){
                MenuAdmin menu2 = new MenuAdmin();
                this.dispose();
                menu2.init();
                menu2.us(tipo);
            }else if(tipo==3){
               MenuHuesped menu3 = null;
                try {
                    menu3 = new MenuHuesped();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
               this.dispose();
               menu3.us(user);
               menu3.init();
            }else{
               JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta");
            }
        }
    }    
}