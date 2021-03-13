package Vistas;

import static Motor.EmpleadoMotor.Empleado;
import static Motor.EmpleadoMotor.Tarea;
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

class VerTareas extends JFrame implements ActionListener, MouseListener {
    EmpleadoMotor aux;
    JPanel principal, panel, panelfecha;
    Font letras;
    JTable tabla;
    JLabel instruccion2;
    JButton regresar, cerrarcambio;
    JLabel fecha;
    JTextArea caracteristicas_txt;
    DefaultTableModel modelo;
    JScrollPane scrollpane, scroll;
    BorderLayout bl;
    FlowLayout fl;
    Dimension db;
    Color color, fuente;
    String tipoemp;
    String[] columnNames = {"Fecha", "Tarea"};
    int tt, id_e;
    String usua;
    
    public VerTareas() throws ClassNotFoundException{
        aux = new EmpleadoMotor();
        aux.archivoconsultarempleados();
        aux.archivotarea();
    }
    void us(int tipo) {
        tt=tipo;
    }
    void usua(String user){
        usua=user;
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
        
        instruccion2 = new JLabel("           Seleccione la tarea para ver los detalles       ");
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
		
        tabla.getColumnModel().getColumn(0).setPreferredWidth(120);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(580);
        
        for(int i=0; i<Empleado.size(); i++){
            if(Empleado.get(i).getUsuario().equals(usua)){
                id_e=Empleado.get(i).getId();
            }
        }
        for(int i=0; i<Tarea.size(); i++){
            if(Tarea.get(i).getId_empleado()==id_e){
                 modelo.addRow(new Object[]{Tarea.get(i).getFecha(), Tarea.get(i).getTarea()});
            }
        }        
                                  
        fecha = new JLabel();
        fecha.setFont(letras);
        fecha.setBounds(10, 160, 320, 40);
        panelfecha.add(fecha);
        
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
            this.dispose();
            MenuEmpleado ma = new MenuEmpleado();
            ma.init();
            ma.us(1);
            ma.usua(usua);
        }
        if(e.getSource()==cerrarcambio){
            this.dispose();
            MenuEmpleado ma = new MenuEmpleado();
            ma.init();
            ma.us(1);
            ma.usua(usua);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = tabla.getSelectedRow();
        String fechat = tabla.getValueAt(row, 0).toString();
        String tarea = tabla.getValueAt(row, 1).toString();
        
        fecha.setText("Fecha: "+fechat);
        caracteristicas_txt.setText("Tarea: "+tarea);
          
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
