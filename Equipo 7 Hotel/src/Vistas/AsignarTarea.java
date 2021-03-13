package Vistas;
import Datos.Empleados;
import static Motor.EmpleadoMotor.Empleado;
import Datos.ValidarCampos;
import Motor.EmpleadoMotor;
import static Motor.EmpleadoMotor.Empleado;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

class AsignarTarea extends JFrame implements ActionListener, MouseListener{
    EmpleadoMotor aux; 
    JPanel principal, panel, panelfecha;
    Font letras;
    JScrollPane scroll;
    JButton regresar, confirmarfecha, cerrarfecha;
    JTable tabla;
    JLabel instruccion, idemp, nomemp, empleado;
    JTextArea tarea;
    DefaultTableModel modelo;
    JScrollPane scrollpane;
    BorderLayout bl;
    FlowLayout fl;
    Dimension db;
    Color color, fuente;
    String[] columnNames = {"ID Empleado", "Nombre", "Apellido", "Ocupacion"};
    
    public AsignarTarea(){
        aux = new EmpleadoMotor();
        try {
            FileInputStream archivoentrada = new FileInputStream("Empleados.txt");
            ObjectInputStream entrada = new ObjectInputStream(archivoentrada);
            Empleado = (ArrayList<Empleados>)entrada.readObject();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        } 
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
        
        instruccion = new JLabel("             Seleccione el empleado que hará la tarea      ");
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
        tabla.getColumnModel().getColumn(2).setPreferredWidth(150);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(60);
        
        for(int i=0; i<Empleado.size(); i++){
            if(Empleado.get(i).getTipo()==1){
                modelo.addRow(new Object[]{Empleado.get(i).getId(), Empleado.get(i).getNombre(), 
                    Empleado.get(i).getApellidos(), Empleado.get(i).getCargo()});    
            }           
        }

        idemp = new JLabel("");
        idemp.setBounds(10, 10, 50, 40);
        idemp.setFont(letras);
        panelfecha.add(idemp);
        
        empleado = new JLabel("");
        empleado.setBounds(10, 10, 50, 40);
        empleado.setFont(letras);
        empleado.setVisible(false);
        panelfecha.add(empleado);
        
        nomemp = new JLabel("");
        nomemp.setBounds(90, 10, 500, 40);
        nomemp.setFont(letras);
        panelfecha.add(nomemp);
        
        tarea = new JTextArea();
        tarea.setLineWrap(true);
        tarea.setFont(letras);        
        tarea.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        scroll = new JScrollPane(tarea);
        scroll.setBounds(10, 70, 700, 250);
        panelfecha.add(scroll);
                
        confirmarfecha = new JButton("Agregar tarea");
        confirmarfecha.setBounds(250, 390, 250, 40);
        confirmarfecha.setFont(letras);
        confirmarfecha.setBackground(color);
        confirmarfecha.setForeground(Color.WHITE);        
        confirmarfecha.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, color));
        confirmarfecha.addActionListener(this); 
        panelfecha.add(confirmarfecha);
        
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
        if(e.getSource()==cerrarfecha){
            regresar.setVisible(true);
            cerrarfecha.setVisible(false);
            instruccion.setText("             Seleccione el empleado que hará la tarea      ");
            panelfecha.setVisible(false);
            scrollpane.setVisible(true);
        }
        if(e.getSource()==confirmarfecha){
            ValidarCampos v = new ValidarCampos();
            String t = tarea.getText();
            int d = Integer.parseInt(empleado.getText());
                if(v.Vacio(t, "la tarea")){
                    aux.tareas(t, d);
                    JOptionPane.showMessageDialog(this, "Tarea Agregada");
                    MenuAdmin ma = new MenuAdmin();
                    ma.init();
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(this, v.err(), "Error", JOptionPane.ERROR_MESSAGE);
                    tarea.requestFocus();
                }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = tabla.getSelectedRow();
        int codigo = parseInt(tabla.getValueAt(row, 0).toString());
        String name = tabla.getValueAt(row, 1).toString();
        String last = tabla.getValueAt(row, 2).toString();
        panelfecha.setVisible(true);
        scrollpane.setVisible(false);
        instruccion.setText("         Escriba la tarea           ");
        idemp.setText("ID: "+codigo);
        empleado.setText(""+codigo);
        nomemp.setText("Empleado: "+ name+" "+last);
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