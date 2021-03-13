package Vistas;

import static Motor.EmpleadoMotor.Reporte;
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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

class VerReportes extends JFrame implements ActionListener, MouseListener {
    EmpleadoMotor aux;
    JPanel principal, panel, panelfecha;
    Font letras;
    JTable tabla;
    JLabel instruccion2;
    JButton regresar, cerrarcambio;
    JLabel nombre_txt, fecha, habitacion;
    JTextArea caracteristicas_txt;
    DefaultTableModel modelo;
    JScrollPane scrollpane, scroll;
    BorderLayout bl;
    FlowLayout fl;
    Dimension db;
    Color color, fuente;
    String tipoemp;
    String[] columnNames = {"Fecha", "Habitacion", "Huesped","Reporte"};
    int id_tipo;
    int tt;
    String usua;
    
    public VerReportes() throws ClassNotFoundException{
        aux = new EmpleadoMotor();
        aux.archivoreporte();
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
        
        instruccion2 = new JLabel("           Seleccione el reporte para ver los detalles       ");
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
		
        tabla.getColumnModel().getColumn(0).setPreferredWidth(70);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(130);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(150);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(350);
        
        for(int o=0; o<Reporte.size(); o++){
           modelo.addRow(new Object[]{Reporte.get(o).getFecha(), Reporte.get(o).getHabitacion(),
                        Reporte.get(o).getNombre(), Reporte.get(o).getReporte()});
        }
                    
                           
        nombre_txt = new JLabel();
        nombre_txt.setFont(letras);
        nombre_txt.setBounds(10, 100, 400, 40);
        nombre_txt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
        panelfecha.add(nombre_txt);
        
        fecha = new JLabel();
        fecha.setFont(letras);
        fecha.setBounds(10, 200, 350, 40);
        fecha.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
        panelfecha.add(fecha);
        
        habitacion = new JLabel();
        habitacion.setFont(letras);
        habitacion.setBounds(10, 150, 350, 40);
        habitacion.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
        panelfecha.add(habitacion);
        
        caracteristicas_txt = new JTextArea();
        caracteristicas_txt.setLineWrap(true);
        caracteristicas_txt.setFont(letras);
        caracteristicas_txt.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        scroll = new JScrollPane(caracteristicas_txt);
        caracteristicas_txt.setEnabled(false);
        caracteristicas_txt.setDisabledTextColor(Color.BLACK);
        scroll.setBounds(500, 100, 300, 300);
        panelfecha.add(scroll);
        
                
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
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = tabla.getSelectedRow();
        String fechat = tabla.getValueAt(row, 0).toString();
        String hab = tabla.getValueAt(row, 1).toString();
        String name = tabla.getValueAt(row, 2).toString();
        String tarea = tabla.getValueAt(row, 3).toString();
        
        nombre_txt.setText("Huesped: "+name);
        fecha.setText("Fecha: "+fechat);
        caracteristicas_txt.setText("Reporte: "+tarea);
        habitacion.setText(hab);
         
        panelfecha.setVisible(true);
        scrollpane.setVisible(false);
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
