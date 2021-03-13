package Vistas;

import static Motor.EmpleadoMotor.Habitacion;
import Datos.Calendario;
import Datos.ValidarCampos;
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
import java.util.Random;
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
import org.bolivia.combo.SComboBox;

class AgregarHuesped extends JFrame implements ActionListener, MouseListener {
    EmpleadoMotor aux;    
    JPanel principal, panel, panelfecha;
    Font letras;
    JButton regresar, confirmar, confirmarfecha, cerrarfecha;
    JTable tabla;
    JLabel instruccion, instruccion2, idhues, idhab, nombrehab, preciohab, caphab, carachab, nombrehues, apellihues;
    SComboBox dia_i, mes_i, anio_i, dia_f, mes_f, anio_f;
    JTextField nombre, apellidos;
    DefaultTableModel modelo;
    JScrollPane scrollpane, scroll;
    JTextArea caracteristicas_txt;
    BorderLayout bl;
    FlowLayout fl;
    Dimension db;
    Random rnd = new Random();
    int user = (int) (rnd.nextDouble() * 100000 + 999999);
    String usuario= Integer.toString(user);
    int pass = (int) (rnd.nextDouble() * 100000 + 999999);
    String contrasena=Integer.toString(pass);
    Color color, fuente;
    int mesinicio, diainicio, anoinicio, mesfinal, diafinal, anofinal;
    int huesped, tt;
    String usua;
    String[] columnNames = {"ID Habitacion", "Nombre", "Precio(Pesos)", "Capacidad(personas)", "Caracteristicas"};
    
    public AgregarHuesped() throws ClassNotFoundException{
        aux = new EmpleadoMotor();
        huesped = aux.obeteneridhues();
        aux.archivohab();
        aux.archivoguardarhuesped();
    }
    void us(int t) {
        this.tt=t;
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
                      
        cerrarfecha = new JButton("<html><center>Regresar</center></html>");
        cerrarfecha.setFont(letras);
        cerrarfecha.setBackground(color);
        cerrarfecha.setForeground(Color.WHITE);        
        cerrarfecha.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        cerrarfecha.addActionListener(this); 
        cerrarfecha.setPreferredSize(db);
        cerrarfecha.setVisible(false);
        principal.add(cerrarfecha);       
        
        instruccion = new JLabel("             Seleccione la habitacion                 ");
        instruccion.setFont(letras);
        principal.add(instruccion);

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

        idhab = new JLabel("");
        idhab.setBounds(10, 10, 50, 40);
        idhab.setFont(letras);
        panelfecha.add(idhab);
        
        nombrehab = new JLabel("");
        nombrehab.setBounds(90, 10, 220, 40);
        nombrehab.setFont(letras);
        panelfecha.add(nombrehab);
        
        preciohab = new JLabel("");
        preciohab.setBounds(320, 10, 160, 40);
        preciohab.setFont(letras);
        panelfecha.add(preciohab);
        
        caphab = new JLabel("");
        caphab.setBounds(500, 10, 230, 40);
        caphab.setFont(letras);
        panelfecha.add(caphab);
        
        caracteristicas_txt = new JTextArea();
        caracteristicas_txt.setLineWrap(true);
        caracteristicas_txt.setFont(letras);
        caracteristicas_txt.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        scroll = new JScrollPane(caracteristicas_txt);
        caracteristicas_txt.setEnabled(false);
        caracteristicas_txt.setDisabledTextColor(Color.BLACK);
        scroll.setBounds(10, 60, 800, 40);
        panelfecha.add(scroll);        

        
        dia_i = new SComboBox();  
        dia_i.setBounds(10, 120, 230, 40);
        dia_i.addItem("Selecciona el dia de llegada");
        for(int f=1; f<32; f++){
            dia_i.addItem(f);
        }
        dia_i.setSelectedIndex(diainicio);
        panelfecha.add(dia_i);
        
        mes_i = new SComboBox();  
        mes_i.setBounds(250, 120, 230, 40);
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
        anio_i.setBounds(490, 120, 230, 40);
        anio_i.addItem("Selecciona el año de llegada");
        anio_i.addItem("2019");
        anio_i.addItem("2020");
        anio_i.setSelectedIndex(anoinicio);
        panelfecha.add(anio_i);
        
        dia_f = new SComboBox();  
        dia_f.setBounds(10, 170, 230, 40);
        dia_f.addItem("Selecciona el dia de salida");
        for(int f=1; f<32; f++){
            dia_f.addItem(f);
        }
        dia_f.setSelectedIndex(diafinal);
        panelfecha.add(dia_f);
        
        mes_f = new SComboBox();  
        mes_f.setBounds(250, 170, 230, 40);
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
        anio_f.setBounds(490, 170, 230, 40);
        anio_f.addItem("Selecciona el año de llegada");
        anio_f.addItem("2019");
        anio_f.addItem("2020");
        anio_f.setSelectedIndex(anofinal);
        panelfecha.add(anio_f);
        
        confirmarfecha = new JButton("Buscar disponibilidad");
        confirmarfecha.setBounds(250, 230, 250, 40);
        confirmarfecha.setFont(letras);
        confirmarfecha.setBackground(color);
        confirmarfecha.setForeground(Color.WHITE);        
        confirmarfecha.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        confirmarfecha.addActionListener(this); 
        panelfecha.add(confirmarfecha);
        
        instruccion2 = new JLabel("             Escriba los datos del huesped                 ");
        instruccion2.setFont(letras);
        instruccion2.setBounds(50, 300, 600, 40);
        instruccion2.setVisible(false);
        panelfecha.add(instruccion2);
        
        nombrehues = new JLabel("Nombre: ");
        nombrehues.setBounds(10, 340, 80, 40);
        nombrehues.setFont(letras);
        nombrehues.setVisible(false);
        panelfecha.add(nombrehues);
                
        nombre = new JTextField();
        nombre.setBounds(100, 340, 220, 40);
        nombre.setFont(letras);
        nombre.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
        nombre.setVisible(false);
        panelfecha.add(nombre);
        
        apellihues = new JLabel("Apellidos: ");
        apellihues.setBounds(350, 340, 110, 40);
        apellihues.setFont(letras);
        apellihues.setVisible(false);
        panelfecha.add(apellihues);             
                
        apellidos = new JTextField();
        apellidos.setBounds(450, 340, 260, 40);
        apellidos.setFont(letras);
        apellidos.setVisible(false);
        apellidos.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
        panelfecha.add(apellidos);
        
        confirmar = new JButton("Confirmar datos");
        confirmar.setBounds(250, 410, 250, 40);
        confirmar.setFont(letras);
        confirmar.setVisible(false);
        confirmar.setBackground(color);
        confirmar.setForeground(Color.WHITE);        
        confirmar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        confirmar.addActionListener(this); 
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
        int salida;
        int entrada;
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
        if(e.getSource()==cerrarfecha){
            regresar.setVisible(true);
            cerrarfecha.setVisible(false);
            instruccion.setText("             Seleccione la habitacion                 ");
            panelfecha.setVisible(false);
            scrollpane.setVisible(true);
        }
        if(e.getSource()==confirmarfecha){
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
            int g = huesped;
            int idh = Integer.parseInt(idhab.getText());
            int r = c.validacion(a, b, anioi, d, ee, aniof);
            entrada=c.entrada();
            salida=c.salida();
            System.out.println(entrada+" "+salida);
            if(a != 0){
                if(b!=0){
                    if(cc!=0){
                        if(d!=0){
                            if(ee!=0){
                                if(f!=0){
                                    if(r>0){
                                        if(aux.registrarh("", "", entrada, salida, g, idh, usuario, contrasena, fi, ff, a, b, anioi, d, ee, aniof)){
                                            dia_i.setEnabled(false);
                                            mes_i.setEnabled(false);
                                            anio_i.setEnabled(false);
                                            dia_f.setEnabled(false);
                                            mes_f.setEnabled(false);
                                            anio_f.setEnabled(false);
                                            instruccion2.setVisible(true);  
                                            nombrehues.setVisible(true);    
                                            nombre.setVisible(true);
                                            apellihues.setVisible(true); 
                                            apellidos.setVisible(true);
                                            confirmar.setVisible(true);
                                        }else{
                                            JOptionPane.showMessageDialog(null, "No está disponible la habitacion");
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
        if(e.getSource()==confirmar){
            ValidarCampos v = new ValidarCampos(); 
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
            
            int g = huesped;
            int idh = Integer.parseInt(idhab.getText());
            String name= nombre.getText();
            String ape = apellidos.getText();
            c.validacion(a, b, anioi, d, ee, aniof);
            entrada=c.entrada();
            salida=c.salida();
        
            if(v.Letras(name, "el nombre")){
                if(v.Letras(ape, "el apellido")){
                    if(aux.agregarreservacion(name, ape, entrada, salida, g, idh, usuario, contrasena, fi, ff, a, b, anioi, d, ee, aniof)){
                        JOptionPane.showMessageDialog(this, "Huesped registrado correctamente\n"
                               + "Su usario es "+usuario+" su contraseña es "+contrasena+"\n"
                                + "El ID de la reserva es "+huesped);
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
                       JOptionPane.showMessageDialog(this, aux.error(), "Error", JOptionPane.ERROR_MESSAGE); 
                    }
                }else{
                    JOptionPane.showMessageDialog(this, v.err(), "Error", JOptionPane.ERROR_MESSAGE);
                    nombre.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(this, v.err(), "Error", JOptionPane.ERROR_MESSAGE);
                apellidos.requestFocus();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = tabla.getSelectedRow();
        int codigo = parseInt(tabla.getValueAt(row, 0).toString());
        String name = tabla.getValueAt(row, 1).toString();
        int precio = parseInt(tabla.getValueAt(row, 2).toString());
        int capacidad = parseInt(tabla.getValueAt(row, 3).toString());
        String carac = tabla.getValueAt(row, 4).toString();
        panelfecha.setVisible(true);
        scrollpane.setVisible(false);
        instruccion.setText("         Selecciona las fechas de llegada y salida           ");
        idhab.setText(""+codigo);
        nombrehab.setText(name);
        preciohab.setText("$"+precio+" por noche");
        caphab.setText("Capacidad: "+capacidad+ " personas");
        caracteristicas_txt.setText("Cuenta con : "+carac);
        regresar.setVisible(false);
        add(panelfecha, BorderLayout.CENTER);
        cerrarfecha.setVisible(true);        
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