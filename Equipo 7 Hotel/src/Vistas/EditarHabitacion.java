package Vistas;

import static Motor.EmpleadoMotor.Habitacion;
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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class EditarHabitacion extends JFrame implements ActionListener, MouseListener {
    EmpleadoMotor aux;
    JPanel principal, panel, panelfecha;
    Font letras;
    JTable tabla;
    JTextField nombre_txt, costo_txt, capacidad_txt, piso_txt;
    JTextArea caracteristicas_txt;
    JLabel nombre_lbl, costo_lbl, cap_lbl, carac_lbl, id_lbl, instruccion, piso;
    JLabel instruccion2, eli;
    JButton regresar, confirmar, cerrarcambio;
    JScrollPane scroll;
    DefaultTableModel modelo;
    JScrollPane scrollpane;
    BorderLayout bl;
    FlowLayout fl;
    Dimension db;
    Color color, fuente;
    String[] columnNames = {"ID Habitacion", "Nombre", "Precio(Pesos)", "Capacidad(personas)", "Caracteristicas"};   
    int tt;
    String usua;
    
    public EditarHabitacion() throws ClassNotFoundException{
        aux = new EmpleadoMotor();
        aux.archivohab();
    }
    
    void us(int tipo) {
        this.tt=tipo;
    }
    void usua(String user){
        this.usua=user;
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
        
        instruccion2 = new JLabel("           Seleccione la habitacion que quiere editar       ");
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
        tabla.getColumnModel().getColumn(4).setPreferredWidth(300);
               
        for(int i=0; i<Habitacion.size(); i++){
            modelo.addRow(new Object[]{Habitacion.get(i).getId(), Habitacion.get(i).getNombre(), Habitacion.get(i).getCosto(),
                Habitacion.get(i).getPersonas(),Habitacion.get(i).getCaracteristicas()});            
        }
       
        instruccion = new JLabel("Cambio los datos de la habitacion y luego de click en confirmar");
        instruccion.setFont(letras);
        instruccion.setBounds(100, 60, 720, 40);
        panelfecha.add(instruccion);
        
        id_lbl = new JLabel();
        id_lbl.setFont(letras);
        id_lbl.setBounds(60, 100, 220, 40);
        panelfecha.add(id_lbl);
        
        eli = new JLabel();
        
        nombre_lbl = new JLabel("Nombre de la habitacion");
        nombre_lbl.setFont(new Font("Consolas", Font.PLAIN, 15));
        nombre_lbl.setBounds(15, 170, 240, 40);
        panelfecha.add(nombre_lbl);
        
        nombre_txt = new JTextField();
        nombre_txt.setFont(letras);
        nombre_txt.setBounds(210, 170, 260, 40);
        nombre_txt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
        panelfecha.add(nombre_txt);
                
        costo_lbl = new JLabel("Costo por noche");
        costo_lbl.setFont(letras);
        costo_lbl.setBounds(40, 250, 240, 40);
        panelfecha.add(costo_lbl);
        
        costo_txt = new JTextField();
        costo_txt.setFont(letras);
        costo_txt.setBounds(210, 250, 260, 40);
        costo_txt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
        panelfecha.add(costo_txt);
        
        
        cap_lbl = new JLabel("Capacidad ");
        cap_lbl.setFont(letras);
        cap_lbl.setBounds(69, 330, 240, 40);
        panelfecha.add(cap_lbl);
        
        capacidad_txt = new JTextField();
        capacidad_txt.setFont(letras);
        capacidad_txt.setBounds(210, 330, 260, 40);
        capacidad_txt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
        panelfecha.add(capacidad_txt);
        
        piso = new JLabel("Piso: ");
        piso.setFont(letras);
        piso.setBounds(69, 400, 240, 40);
        panelfecha.add(piso);
        
        piso_txt = new JTextField();
        piso_txt.setFont(letras);
        piso_txt.setBounds(210, 400, 250, 40);
        piso_txt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
        panelfecha.add(piso_txt);
        
        carac_lbl = new JLabel("Caracteristicas");
        carac_lbl.setFont(letras);
        carac_lbl.setBounds(550, 100, 240, 40);
        panelfecha.add(carac_lbl);
        
        caracteristicas_txt = new JTextArea();
        caracteristicas_txt.setLineWrap(true);
        caracteristicas_txt.setFont(letras);
        caracteristicas_txt.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        scroll = new JScrollPane(caracteristicas_txt);
        caracteristicas_txt.setFont(letras);
        scroll.setBounds(550, 140, 240, 240);
        panelfecha.add(scroll);
        
        confirmar = new JButton("Confirmar");        
        confirmar.setFont(letras);
        confirmar.setBackground(color);
        confirmar.setForeground(Color.WHITE);
        confirmar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        confirmar.addActionListener(this); 
        confirmar.setBounds(340, 470, 220, 40);
        panelfecha.add(confirmar);
        
        add(principal, BorderLayout.NORTH);
        add(scrollpane, BorderLayout.CENTER);
        
        setSize(900, 650);
        setLocation(180, 50);
        setTitle("Drake & Josh Inn");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); 
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.png")).getImage());
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
        if(e.getSource()==cerrarcambio){
            regresar.setVisible(true);
            cerrarcambio.setVisible(false);
            instruccion2.setText("             Seleccione la habitacion          ");
            panelfecha.setVisible(false);
            scrollpane.setVisible(true);
        }
        if(e.getSource()==confirmar){
            ValidarCampos v = new ValidarCampos();
            String c = caracteristicas_txt.getText();
            String nombre = nombre_txt.getText();
            String cap = capacidad_txt.getText();
            String costo = costo_txt.getText();
            String ps = piso_txt.getText();
            int capac, cos, piso;
            int indice = Integer.parseInt(eli.getText());
            
            if(v.Letras(nombre, "el nombre")){
                if(v.Numeros(cap, "la capacidad")){
                    if(v.Vacio(c, "las caracteristicas")){
                        if(v.Numeros(costo, "el costo")){
                            if(v.Numeros(ps, "el piso")){
                                capac = Integer.parseInt(cap);
                                cos = Integer.parseInt(costo);
                                piso = Integer.parseInt(ps);
                                aux.guardaredithab(nombre, c, cos, capac, indice, piso);
                                JOptionPane.showMessageDialog(null, "Cambios Guardados");
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
                            }else{
                                JOptionPane.showMessageDialog(this, v.err(), "Error", JOptionPane.ERROR_MESSAGE);
                                piso_txt.requestFocus();
                            }}else{
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
    

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = tabla.getSelectedRow();
        int codigo = parseInt(tabla.getValueAt(row, 0).toString());
        for(int i=0; i<Habitacion.size(); i++){
            if(Habitacion.get(i).getId()==codigo){
                nombre_txt.setText(Habitacion.get(i).getNombre());
                costo_txt.setText(""+Habitacion.get(i).getCosto());
                capacidad_txt.setText(""+Habitacion.get(i).getPersonas());
                caracteristicas_txt.setText(Habitacion.get(i).getCaracteristicas());
                id_lbl.setText("ID: "+codigo);
                piso_txt.setText(""+Habitacion.get(i).getPiso());
                eli.setText(""+i);
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

    
