package Vistas;

import static Motor.EmpleadoMotor.Habitacion;
import static Motor.EmpleadoMotor.Huesped;
import Datos.Calendario;
import Motor.EmpleadoMotor;
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
import javax.swing.table.DefaultTableModel;
import org.bolivia.combo.SComboBox;

class EditarHuesped extends JFrame implements ActionListener, MouseListener {
    EmpleadoMotor aux;   
    JPanel principal, panelhab, panel, panelfecha;
    Font letras, letrasp;
    JTable tabla, tabla2;
    JLabel instruccion2, prov;
    JButton regresar, cerrarcambio, cerrarcambio2, confirmar;
    DefaultTableModel modelo, modelo2;
    JScrollPane scrollpane, scrollpane2, scroll, scroll2;
    JTextArea caracteristicas_txt, caracteristicas_txt2;
    BorderLayout bl;
    FlowLayout fl;
    Dimension db;
    Color color, fuente;
    String tipoemp;   
    int mesinicio, diainicio, anoinicio, mesfinal, diafinal, anofinal;
    SComboBox dia_i, mes_i, anio_i, dia_f, mes_f, anio_f;
    String[] columnNames = {"ID Huesped", "Nombre", "Apellido", "Habitacion", "Fecha Llegada", "Fecha Salida"};
    String[] columnNames2 = {"ID Habitacion", "Nombre", "Precio(Pesos)", "Capacidad(personas)", "Caracteristicas"}; 
    int id_tipo, tt, cod, ent, sal, ind, newhab, index;
    String usua;
    
    public EditarHuesped() throws ClassNotFoundException{
        aux = new EmpleadoMotor();
        aux.archivohab();
        aux.archivohuesped();
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
        letrasp = new Font("Consolas", Font.PLAIN, 13);
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
        
        cerrarcambio2 = new JButton("<html><center>Regresar</center></html>");
        cerrarcambio2.setFont(letras);
        cerrarcambio2.setBackground(color);
        cerrarcambio2.setForeground(Color.WHITE);        
        cerrarcambio2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        cerrarcambio2.addActionListener(this); 
        cerrarcambio2.setPreferredSize(db);
        cerrarcambio2.setVisible(false);
        principal.add(cerrarcambio2);    
        
        instruccion2 = new JLabel("           Seleccione el huesped para editar la reservacion     ");
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
                        Habitacion.get(j).getPiso(), Huesped.get(i).getFecha_i(), Huesped.get(i).getFecha_f()});            
       
                }
            }
        }
        
        modelo2 = new DefaultTableModel();
        tabla2 = new JTable(modelo2);
        tabla2.addMouseListener(this);
        scrollpane2 = new JScrollPane(tabla2);
        scrollpane2.setVisible(false);
        modelo2.setColumnIdentifiers(columnNames2);
        tabla2.addMouseListener(this);     
        tabla2.setAutoCreateRowSorter(true);
        tabla2.getTableHeader().setFont(letrasp);
        tabla2.getTableHeader().setOpaque(false);
        tabla2.getTableHeader().setBackground(fuente);
        tabla2.getTableHeader().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        tabla2.getTableHeader().setForeground(Color.WHITE);
        tabla2.setRowHeight(20);
    
        tabla2.getColumnModel().getColumn(0).setPreferredWidth(30);
        tabla2.getColumnModel().getColumn(1).setPreferredWidth(110);
        tabla2.getColumnModel().getColumn(2).setPreferredWidth(30);
        tabla2.getColumnModel().getColumn(3).setPreferredWidth(60);
        tabla2.getColumnModel().getColumn(4).setPreferredWidth(300);
               
        for(int i=0; i<Habitacion.size(); i++){
            modelo2.addRow(new Object[]{Habitacion.get(i).getId(), Habitacion.get(i).getNombre(), Habitacion.get(i).getCosto(),
                Habitacion.get(i).getPersonas(),Habitacion.get(i).getCaracteristicas()});            
        }
         
        caracteristicas_txt = new JTextArea();
        caracteristicas_txt.setLineWrap(true);
        caracteristicas_txt.setFont(letras);
        caracteristicas_txt.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        scroll = new JScrollPane(caracteristicas_txt);
        caracteristicas_txt.setEnabled(false);
        caracteristicas_txt.setDisabledTextColor(Color.BLACK);
        scroll.setBounds(100, 30, 700, 120);
        panelfecha.add(scroll);
        
        caracteristicas_txt2 = new JTextArea();
        caracteristicas_txt2.setLineWrap(true);
        caracteristicas_txt2.setFont(letras);
        caracteristicas_txt2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        scroll2 = new JScrollPane(caracteristicas_txt2);
        caracteristicas_txt2.setEnabled(false);
        caracteristicas_txt2.setDisabledTextColor(Color.BLACK);
        scroll2.setBounds(100, 160, 700, 120);
        panelfecha.add(scroll2);
        
        dia_i = new SComboBox();  
        dia_i.setBounds(10, 300, 230, 40);
        dia_i.addItem("Selecciona el dia de llegada");
        for(int f=1; f<32; f++){
            dia_i.addItem(f);
        }
        dia_i.setSelectedIndex(diainicio);
        panelfecha.add(dia_i);
        
        mes_i = new SComboBox();  
        mes_i.setBounds(270, 300, 230, 40);
        mes_i.addItem("Selecciona el mes de llegada");
        mes_i.addItem("Enero");
        mes_i.addItem("Febrero");
        mes_i.addItem("Marzo");
        mes_i.addItem("Abril");
        mes_i.addItem("Mayo");
        mes_i.addItem("Junio");
        mes_i.addItem("Julio");
        mes_i.addItem("Agosto");
        mes_i.addItem("Septiembre");
        mes_i.addItem("Octubre");
        mes_i.addItem("Noviembre");
        mes_i.addItem("Diciembre");
        mes_i.setSelectedIndex(mesinicio);
        panelfecha.add(mes_i);
        
        anio_i = new SComboBox();  
        anio_i.setBounds(530, 300, 230, 40);
        anio_i.addItem("Selecciona el año de llegada");
        anio_i.addItem("2019");
        anio_i.addItem("2020");
        anio_i.setSelectedIndex(anoinicio);
        panelfecha.add(anio_i);
        
        dia_f = new SComboBox();  
        dia_f.setBounds(10, 360, 230, 40);
        dia_f.addItem("Selecciona el dia de salida");
        for(int f=1; f<32; f++){
            dia_f.addItem(f);
        }
        dia_f.setSelectedIndex(diafinal);
        panelfecha.add(dia_f);
        
        mes_f = new SComboBox();  
        mes_f.setBounds(270, 360, 230, 40);
        mes_f.addItem("Selecciona el mes de salida");
        mes_f.addItem("Enero");
        mes_f.addItem("Febrero");
        mes_f.addItem("Marzo");
        mes_f.addItem("Abril");
        mes_f.addItem("Mayo");
        mes_f.addItem("Junio");
        mes_f.addItem("Julio");
        mes_f.addItem("Agosto");
        mes_f.addItem("Septiembre");
        mes_f.addItem("Octubre");
        mes_f.addItem("Noviembre");
        mes_f.addItem("Diciembre");
        mes_f.setSelectedIndex(mesfinal);
        panelfecha.add(mes_f);
        
        anio_f = new SComboBox();  
        anio_f.setBounds(530, 360, 230, 40);
        anio_f.addItem("Selecciona el año de llegada");
        anio_f.addItem("2019");
        anio_f.addItem("2020");
        anio_f.setSelectedIndex(anofinal);
        panelfecha.add(anio_f);
        
        
        confirmar = new JButton("Confirmar");        
        confirmar.setFont(letras);
        confirmar.setBackground(color);
        confirmar.setForeground(Color.WHITE);
        confirmar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        confirmar.addActionListener(this); 
        confirmar.setBounds(340, 420, 220, 40);
        panelfecha.add(confirmar);
        
        add(principal, BorderLayout.NORTH);
        add(scrollpane, BorderLayout.CENTER);
        
        setSize(900, 620);
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
            instruccion2.setText("           Seleccione el huesped para editar la reservacion     ");
            scrollpane.setVisible(true);
            scrollpane2.setVisible(false);
        }
        if(e.getSource()==cerrarcambio2){
            regresar.setVisible(false);
            cerrarcambio.setVisible(true);
            cerrarcambio2.setVisible(false);
            instruccion2.setText("       Seleccione la habitacion que desea ocupar     ");
            panelfecha.setVisible(false);
            scrollpane2.setVisible(true);
        }
        if(e.getSource()==confirmar){ 
            Calendario c = new Calendario();
            int a = dia_i.getSelectedIndex();
            int b = mes_i.getSelectedIndex();
            int cc = anio_i.getSelectedIndex();
            int d = dia_f.getSelectedIndex(); 
            int ee= mes_f.getSelectedIndex();
            int f = anio_f.getSelectedIndex();
            int aniof=0, anioi=0;
            if(cc==1){
                anioi=2019;
            }if(cc==2){
                anioi=2020;
            }
            if(f==1){
                aniof=2019;
            }if(f==2){
                aniof=2020;
            }
            String fi = a +"/"+ b + "/"+anioi;
            String ff= d+"/"+ee+"/"+aniof;
            
            int r = c.validacion(a, b, anioi, d, ee, aniof);
            int entrada=c.entrada();
            int salida=c.salida();
            if(a != 0){
                if(b!=0){
                    if(cc!=0){
                        if(d!=0){
                            if(ee!=0){
                                if(f!=0){
                                    if(r>0){
                                        if(aux.guardarcambio(entrada, salida, cod, newhab, fi, ff, a, b, anioi, d, ee, aniof,index, ent, sal)){
                                            JOptionPane.showMessageDialog(null, "Reservacion cambiada");
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
                                            JOptionPane.showMessageDialog(null, "No está disponible la habitacion en esa fecha");
                                        }    
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Introduce una fecha valida");
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "Selecciona el año de salida");
                                    anio_f.requestFocus();
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "Selecciona el mes de salida");
                                mes_f.requestFocus();
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Selecciona el dia de salida");
                            dia_f.requestFocus(); 
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Selecciona el año de llegada");
                        anio_i.requestFocus(); 
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Selecciona el mes de llegada");
                    mes_i.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Selecciona el dia de llegada");
                dia_i.requestFocus();   
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Calendario c = new Calendario();
        if(e.getSource()==tabla){
            int row = tabla.getSelectedRow();
            cod = parseInt(tabla.getValueAt(row, 0).toString());

            for(int i=0; i<Huesped.size(); i++){
                if(Huesped.get(i).getId()==cod){
                    int f=Huesped.get(i).getA1();
                    int g=Huesped.get(i).getA2();
                    int d=Huesped.get(i).getM1();
                    int ee=Huesped.get(i).getM2();
                    int a=Huesped.get(i).getD1();
                    int b=Huesped.get(i).getD2();
                    ind=Huesped.get(i).getHabitacion();
                    int r=c.validacion(a, d, f, b, ee, g);
                    ent=c.entrada();
                    sal=c.salida();
                    index=i;
                    if(r>0){
                        aux.eliminarres1(cod, ent, sal, ind); 
                    }
                }
            }
            for(int i=0; i<Huesped.size(); i++){            
                for(int j=0; j<Habitacion.size(); j++){
                    if(Huesped.get(i).getHabitacion()==Habitacion.get(j).getId()){ 
                        if(Huesped.get(i).getId()==cod){
                            caracteristicas_txt.setText("Reservacion anterior:  " +Huesped.get(i).getNombre() +" "+Huesped.get(i).getApellidos() +
                                " tiene reservacion en "+Habitacion.get(j).getNombre()+" para "+Habitacion.get(j).getPersonas()+ " personas, del "
                                +Huesped.get(i).getFecha_i()+" al "+Huesped.get(i).getFecha_f());
                            }
                        }
                    }
            }
            instruccion2.setText("       Seleccione la habitacion que desea ocupar     ");
            scrollpane.setVisible(false);
            scrollpane2.setVisible(true);
            regresar.setVisible(false);
            cerrarcambio.setVisible(true); 
            add(scrollpane2, BorderLayout.CENTER);
        }
        if(e.getSource()==tabla2){
            int row2 = tabla2.getSelectedRow();
            newhab = parseInt(tabla2.getValueAt(row2, 0).toString());
            for(int i=0; i<Habitacion.size(); i++){
                if(Habitacion.get(i).getId()==newhab){
                    caracteristicas_txt2.setText("Nueva Habitacion:   "+Habitacion.get(i).getNombre()+ 
                        " para "+Habitacion.get(i).getPersonas()+" personas, cuenta con "+Habitacion.get(i).getCaracteristicas()
                        +" y tiene un costo de $"+Habitacion.get(i).getCosto());   
                }
            }
            instruccion2.setText("       Seleccione la fecha de la nueva reservacion    ");
            scrollpane.setVisible(false);
            scrollpane2.setVisible(false);
            panelfecha.setVisible(true);
            regresar.setVisible(false);
            add(panelfecha, BorderLayout.CENTER);
            cerrarcambio.setVisible(false);
            cerrarcambio2.setVisible(true);
        }    
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