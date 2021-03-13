package Vistas;

import static Motor.EmpleadoMotor.Empleado;
import Datos.ValidarCampos;
import Motor.EmpleadoMotor;
import Motor.Parametros;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Integer.parseInt;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.bolivia.combo.SComboBox;

class EditarEmpleado extends JFrame implements ActionListener, MouseListener {
    EmpleadoMotor aux;   
    JPanel principal, panel, panelfecha;
    Font letras;
    JTable tabla;
    JLabel instruccion, instruccion2, idprov;
    JButton regresar, confirmar, cerrarcambio;
    JTextField user_txt, nombre_txt, apellido_txt, ocupacion_txt;
    JPasswordField pass_txt;
    JLabel user_lbl, pass_lbl, nombre_lbl, apellido_lbl, id_lbl, cargo_lbl, tipo_lbl, eli;
    SComboBox tipo;
    DefaultTableModel modelo;
    JScrollPane scrollpane;
    BorderLayout bl;
    FlowLayout fl;
    Dimension db;
    Color color, fuente;
    String tipoemp;
    String[] columnNames = {"ID Empleado", "Nombre", "Apellido", "Cargo", "Tipo", "NSS"};
    int id_tipo;
    
    public EditarEmpleado() throws ClassNotFoundException{
        aux = new EmpleadoMotor();
        aux.archivoconsultarempleados();
    }
    
    void init() {
        principal = new JPanel();
        principal.setLayout(null);
        bl = new BorderLayout();
        fl = new FlowLayout();
        principal.setLayout(fl);        
        setLayout(bl);
        
        panelfecha = new JPanel();
        panelfecha.setLayout(null);
        panelfecha.setVisible(false);
        
        panelfecha.setBackground(Color.WHITE);
        principal.setBackground(Color.WHITE);

        db = new Dimension();
        letras = new Font("Consolas", Font.PLAIN, 18);
        color = new Color(41, 100, 185);
        fuente = new Color(120, 115, 200);
        db.width=190;
        db.height=40;
               
        regresar = new JButton("<html><center>Regresar</center></html>");
        regresar.setFont(letras);
        regresar.setBackground(color);
        regresar.setForeground(Color.WHITE);        
        regresar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        regresar.addActionListener(this); 
        regresar.setPreferredSize(db);
        principal.add(regresar);
                      
        cerrarcambio = new JButton("<html><center>Regresar</center></html>");
        cerrarcambio.setFont(letras);
        cerrarcambio.setBackground(color);
        cerrarcambio.setForeground(Color.WHITE);        
        cerrarcambio.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        cerrarcambio.addActionListener(this); 
        cerrarcambio.setPreferredSize(db);
        cerrarcambio.setVisible(false);
        principal.add(cerrarcambio);       
        
        instruccion2 = new JLabel("           Seleccione el empleado que quiere editar       ");
        instruccion2.setFont(letras);
        principal.add(instruccion2);
               
        modelo = new DefaultTableModel();
        tabla = new JTable(modelo);
        tabla.addMouseListener(this);
        scrollpane = new JScrollPane(tabla);
        modelo.setColumnIdentifiers(columnNames);
        tabla.addMouseListener(this);
        tabla.setAutoCreateRowSorter(true);       
        tabla.getTableHeader().setOpaque(false);
        tabla.getTableHeader().setBackground(fuente);
        tabla.getTableHeader().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        tabla.getTableHeader().setForeground(Color.WHITE);
        tabla.setRowHeight(20);

        tabla.getColumnModel().getColumn(0).setPreferredWidth(30);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(110);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(30);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(100);
              		               
        for(int i=0; i<Empleado.size(); i++){
            if(Empleado.get(i).getTipo()==1){
                tipoemp="Empleado General";
            }else{
                tipoemp="Administrativo";
            }
            modelo.addRow(new Object[]{Empleado.get(i).getId(),Empleado.get(i).getNombre(),Empleado.get(i).getApellidos(),
            Empleado.get(i).getCargo(), tipoemp, Empleado.get(i).getUsuario()});            
        }
       
        instruccion = new JLabel("Complete con datos del empleado y luego de click en confirmar");
        instruccion.setFont(letras);
        instruccion.setBounds(100, 60, 720, 40);
        panelfecha.add(instruccion);
        
        nombre_lbl = new JLabel("Nombre(s):");
        nombre_lbl.setFont(letras);
        nombre_lbl.setBounds(60, 109, 220, 40);
        panelfecha.add(nombre_lbl);
        
        nombre_txt = new JTextField();
        nombre_txt.setFont(letras);
        nombre_txt.setBounds(170, 100, 280, 40);
        nombre_txt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
        panelfecha.add(nombre_txt);
        
        apellido_lbl = new JLabel("Apellidos:");
        apellido_lbl.setFont(letras);
        apellido_lbl.setBounds(55, 189, 240, 40);
        panelfecha.add(apellido_lbl);
       
        apellido_txt = new JTextField();
        apellido_txt.setFont(letras);
        apellido_txt.setBounds(170, 180, 280, 40);
        apellido_txt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
        panelfecha.add(apellido_txt);
        
        user_lbl = new JLabel("NSS:");
        user_lbl.setFont(letras);
        user_lbl.setBounds(120, 269, 240, 40);
        panelfecha.add(user_lbl);
        
        user_txt = new JTextField();
        user_txt.setFont(letras);
        user_txt.setBounds(170, 260, 280, 40);
        user_txt.setEnabled(false);
        user_txt.setDisabledTextColor(Color.BLACK);
        user_txt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
        panelfecha.add(user_txt);
        
        pass_lbl = new JLabel("Contraseña:");
        pass_lbl.setFont(letras);
        pass_lbl.setBounds(55, 349, 240, 40);
        panelfecha.add(pass_lbl);
        
        pass_txt = new JPasswordField();
        pass_txt.setFont(letras);
        pass_txt.setBounds(170, 340, 280, 40);
        pass_txt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
        panelfecha.add(pass_txt);
        
        id_lbl = new JLabel();
        id_lbl.setFont(letras);
        id_lbl.setBounds(550, 100, 240, 40);
        panelfecha.add(id_lbl);
        
        idprov=new JLabel();
        eli=new JLabel();
        
        
        cargo_lbl = new JLabel("Cargo: ");
        cargo_lbl.setFont(letras);
        cargo_lbl.setBounds(550, 189, 80, 40);
        panelfecha.add(cargo_lbl);
        
        ocupacion_txt = new JTextField();
        ocupacion_txt.setFont(letras);
        ocupacion_txt.setBounds(630, 180, 220, 40);
        ocupacion_txt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
        panelfecha.add(ocupacion_txt);

        tipo = new SComboBox();  
        tipo.setBounds(550, 260, 300, 40);
        tipo.addItem("Selecciona el tipo de empleado");
        tipo.addItem("1. Empleado General");
        tipo.addItem("2. Administrativo");
        tipo.setSelectedIndex(id_tipo);
        panelfecha.add(tipo);
        
        confirmar = new JButton("Guardar cambios");
        confirmar.setFont(letras);
        confirmar.setBackground(color);
        confirmar.setForeground(Color.WHITE);
        confirmar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        confirmar.addActionListener(this); 
        confirmar.setBounds(340, 430, 220, 40);
        panelfecha.add(confirmar);
        
        add(principal, BorderLayout.NORTH);
        add(scrollpane, BorderLayout.CENTER);
        
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
            MenuAdmin ma = new MenuAdmin();
            ma.init();
            ma.us(2);
        }
        if(e.getSource()==cerrarcambio){
            regresar.setVisible(true);
            cerrarcambio.setVisible(false);
            instruccion2.setText("             Seleccione el empleado            ");
            panelfecha.setVisible(false);
            scrollpane.setVisible(true);
        }
        if(e.getSource()==confirmar){
            
            ValidarCampos v = new ValidarCampos();
            int t = tipo.getSelectedIndex();
            String user = user_txt.getText();
            String nombre = nombre_txt.getText();
            String apellido = apellido_txt.getText();
            String cargo = ocupacion_txt.getText();
            String pass = pass_txt.getText();
            int indice = Integer.parseInt(eli.getText());
            int ide = Integer.parseInt(idprov.getText());
            if(v.Letras(nombre, "el nombre")){
                if(v.Letras(apellido, "el apellido")){
                    if(v.SinEspacios(user, "el NSS")){
                        if(v.SinEspacios(pass, "la contraseña")){
                            if(v.Vacio(cargo, "el cargo")){
                                if(t != 0){
                                    try {
                                        aux.editar(t, nombre, apellido, cargo, user, pass, ide, indice);
                                    } catch (ClassNotFoundException ex) {
                                        Logger.getLogger(EditarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    JOptionPane.showMessageDialog(null, "Cambios Guardados");
                                        this.dispose();
                                        MenuAdmin ma = new MenuAdmin();
                                        ma.init();
                                        ma.us(2);
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

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = tabla.getSelectedRow();
        int codigo = parseInt(tabla.getValueAt(row, 0).toString());
        
        for(int i=0; i<Empleado.size(); i++){
            if(Empleado.get(i).getId()==codigo){
                nombre_txt.setText(Empleado.get(i).getNombre());
                apellido_txt.setText(Empleado.get(i).getApellidos());
                user_txt.setText(Empleado.get(i).getUsuario());
                id_lbl.setText("ID: "+codigo);
                idprov.setText(""+codigo);
                pass_txt.setText(Empleado.get(i).getContrasena());
                ocupacion_txt.setText(Empleado.get(i).getCargo()); 
                eli.setText(""+i);
                if(Empleado.get(i).getTipo()==1){
                    tipo.setSelectedIndex(1);
                }else{
                    tipo.setSelectedIndex(2);
                }
            }
        }
        
        panelfecha.setVisible(true);
        scrollpane.setVisible(false);
        instruccion2.setText("         Escribe los nuevos datos          ");

        regresar.setVisible(false);
        add(panelfecha, BorderLayout.CENTER);
        cerrarcambio.setVisible(true);        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
