package Vistas;

import static Motor.EmpleadoMotor.Habitacion;
import static Motor.EmpleadoMotor.Huesped;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

class VerHuespedes extends JFrame implements ActionListener, MouseListener {
    EmpleadoMotor aux;  
    JPanel principal, panel, panelfecha;
    Font letras;
    JTable tabla;
    JLabel instruccion2;
    JTextArea caracteristicas_txt;
    JButton regresar, cerrarcambio;
    DefaultTableModel modelo;
    JScrollPane scrollpane, scroll;
    BorderLayout bl;
    FlowLayout fl;
    Dimension db;
    Color color, fuente;
    String tipoemp;
    String[] columnNames = {"ID Huesped", "Nombre", "Apellido", "Habitacion", "Fecha Llegada", "Fecha Salida"};
    int id_tipo, tt;
    String usua;
    
    public VerHuespedes() throws ClassNotFoundException{
        aux = new EmpleadoMotor();
        aux.archivohab();
        aux.archivohuesped();
    }
     void us(int tipo) {
        this.tt=tipo;
         System.out.println(tt);
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
        
        instruccion2 = new JLabel("           Seleccione el huesped para ver los detalles       ");
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
                 
        for(int i=0; i<Huesped.size(); i++){            
            for(int j=0; j<Habitacion.size(); j++){
                if(Huesped.get(i).getHabitacion()==Habitacion.get(j).getId()){                   
                    modelo.addRow(new Object[]{Huesped.get(i).getId(),Huesped.get(i).getNombre(),Huesped.get(i).getApellidos() ,
                        Habitacion.get(j).getNombre(), Huesped.get(i).getFecha_i(), Huesped.get(i).getFecha_f()});            
       
                }
            }
        }
  
        caracteristicas_txt = new JTextArea();
        caracteristicas_txt.setLineWrap(true);
        caracteristicas_txt.setFont(letras);
        caracteristicas_txt.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        scroll = new JScrollPane(caracteristicas_txt);
        caracteristicas_txt.setEnabled(false);
        caracteristicas_txt.setDisabledTextColor(Color.BLACK);
        scroll.setBounds(100, 50, 600, 300);
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
            regresar.setVisible(true);
            cerrarcambio.setVisible(false);
            instruccion2.setText("         Seleccione la habitacion que quiere ver        ");
            panelfecha.setVisible(false);
            scrollpane.setVisible(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = tabla.getSelectedRow();
        int codigo = parseInt(tabla.getValueAt(row, 0).toString());
        for(int i=0; i<Huesped.size(); i++){            
            for(int j=0; j<Habitacion.size(); j++){
                if(Huesped.get(i).getHabitacion()==Habitacion.get(j).getId()){ 
                    if(Huesped.get(i).getId()==codigo){
                        caracteristicas_txt.setText(Huesped.get(i).getId()+ " " +Huesped.get(i).getNombre() +" "+Huesped.get(i).getApellidos() +
                        " tiene reservacion en "+Habitacion.get(j).getNombre()+" para "+Habitacion.get(j).getPersonas()+ " personas, del "
                        +Huesped.get(i).getFecha_i()+" al "+Huesped.get(i).getFecha_f());
                    }
                }
            }
        }
        
        
        instruccion2.setText("         Detalles de la Habitacion        ");
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
