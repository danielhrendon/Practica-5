/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logic.IteradorLista;
import Logic.ListaDoble;
import Logic.ListaEnRango;
import Logic.Nodo;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author danie
 */
public class Gui extends JFrame{
    JLabel lblTitulo, lblNumAl, lblDefRan, lblValU, lblValD,lblNumRan, lblBuscar, lblEncontrado;
    JButton btnIniciar, btnSiguiente, btnReiniciar, btnBuscar;
    JTextArea   txtNumerosAl, txtNumerosRan, txtEncontrado;
    JTextField tfValU, tfValD, tfBuscar;
    ListaDoble listaDb = new ListaDoble();
    public Gui(){
        setTitle("Practica - Lista Doble Enlace");
        getContentPane().setBackground( new Color(192, 192, 192));
        setSize(800,720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        init();
        setVisible(true);
    }
    
    public void init(){
        lblTitulo = new JLabel("LISTA DOBLE ENLACE");
        btnIniciar = new JButton("INICIAR");
        lblNumAl = new JLabel("NUMEROS ALEATORIOS:");
        txtNumerosAl = new JTextArea();
        lblDefRan = new JLabel("DEFINE EL RANGO:");
        lblValU = new JLabel ("Valor 1: ");
        lblValD = new JLabel ("Valor 2: ");
        tfValU = new JTextField();
        tfValD = new JTextField();
        btnSiguiente = new JButton("SIGUIENTE");
        lblNumRan = new JLabel("NUMEROS DENTRO DEL RANGO:");
        txtNumerosRan = new JTextArea();
        btnReiniciar = new JButton("REINICIAR");
        lblBuscar = new JLabel("NUMERO A BUSCAR:");
        tfBuscar = new JTextField();
        btnBuscar = new JButton("BUSCAR");
        lblEncontrado = new JLabel("EL NUMERO FUE:");
        txtEncontrado = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(txtNumerosAl);
        
        lblNumAl.setVisible(false);
        txtNumerosAl.setVisible(false);
        lblDefRan.setVisible(false);
        lblValU.setVisible(false);    
        lblValD.setVisible(false);        
        tfValU.setVisible(false); 
        tfValD.setVisible(false);        
        btnSiguiente.setVisible(false);       
        lblNumRan.setVisible(false);
        txtNumerosRan.setVisible(false);       
        btnReiniciar.setVisible(false);
        lblBuscar.setVisible(false);        
        tfBuscar.setVisible(false);        
        btnBuscar.setVisible(false);
        lblEncontrado.setVisible(false);
        txtEncontrado.setVisible(false);
                
        lblTitulo.setBounds(235, 2, 500, 100);
        lblTitulo.setFont(new Font("Aptos", Font.BOLD, 30));
        lblTitulo.setForeground(Color.white);
        
        btnIniciar.setBounds(310, 80, 150, 40);
        btnIniciar.setBackground(Color.blue);
        btnIniciar.setForeground(Color.white);
        btnIniciar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                btnIniciar.setEnabled(false);
                lblNumAl.setVisible(true);
                txtNumerosAl.setVisible(true);
                lblDefRan.setVisible(true);
                lblValU.setVisible(true);    
                lblValD.setVisible(true);        
                tfValU.setVisible(true); 
                tfValD.setVisible(true);        
                btnSiguiente.setVisible(true);       
                lblNumRan.setVisible(true);
                txtNumerosRan.setVisible(true);       
                btnReiniciar.setVisible(false);
                lblBuscar.setVisible(false);        
                tfBuscar.setVisible(false);
                btnBuscar.setVisible(false);
                lblEncontrado.setVisible(false);
                txtEncontrado.setVisible(false);
                mostrarNumerosAleatorios();

                    
            }  
        });
        
        lblNumAl.setBounds(100, 125, 150, 30);
        
        
        txtNumerosAl.setBounds(100, 150, 600, 50);
        txtNumerosAl.setEnabled(false);
        
        scrollPane.setBounds(100, 150, 600, 50);
        
        lblDefRan.setBounds(100, 200, 150, 30);
        
        
        lblValU.setBounds(150, 230, 60, 40);
        
        
        lblValD.setBounds(450, 230, 60, 40);
        
        btnSiguiente.setEnabled(false);
        tfValU.setBounds(200, 235, 50, 30);
        tfValU.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                btnSiguiente.setEnabled(false);
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    e.consume();  // ignorar el evento si no es un número, retroceso o suprimir
                }
                String currentText = tfValU.getText();

        // Si se intenta ingresar un número y el campo tiene longitud 3, evita que se agregue más dígitos
                if (Character.isDigit(c) && currentText.length() >= 3) {
                    e.consume();
                }
                
                }
            });

        tfValD.setBounds(500, 235, 50, 30);
        tfValD.addKeyListener(new KeyAdapter() {
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                e.consume();  // ignorar el evento si no es un número, retroceso o suprimir
            }
            String currentText = tfValD.getText();

        // Si se intenta ingresar un número y el campo tiene longitud 3, evita que se agregue más dígitos
                if (Character.isDigit(c) && currentText.length() >= 3) {
                    e.consume();
                }
                btnSiguiente.setEnabled(true);
            }
        });
        
        btnSiguiente.setBounds(600, 230, 100, 40);
        btnSiguiente.setBackground(Color.blue);
        btnSiguiente.setForeground(Color.white);
        btnSiguiente.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            
            int valorU, valorD;
            
                // Obtener los valores de los campos de texto y convertirlos a enteros
                valorU = Integer.parseInt(tfValU.getText());
                valorD = Integer.parseInt(tfValD.getText());

                // Validar que valorD sea mayor que valorU
                if (valorD > valorU) {


                    // Filtrar los números dentro del rango especificado en la listaDb
                    filtrarNumerosEnRango(listaDb, valorU, valorD);

                    // Mostrar los números filtrados en el JTextArea
                    txtNumerosRan.setText(listaDb.toString());


                    btnReiniciar.setVisible(true);
                    lblBuscar.setVisible(true);        
                    tfBuscar.setVisible(true);
                    btnBuscar.setVisible(true);
                    lblEncontrado.setVisible(false);
                    txtEncontrado.setVisible(false);

                } else {
                    // Si valorD no es mayor que valorU mostrar un mensaje de error
                    JOptionPane.showMessageDialog(Gui.this, "El Valor 2 debe ser mayor que el Valor 1.", "Error", JOptionPane.ERROR_MESSAGE);
                    // Evitar que se avance si la validación no se cumple
                    return;
                
            } 
        }  
    });

        lblNumRan.setBounds(100, 280, 200, 30);
        
        
        txtNumerosRan.setBounds(100, 320, 600, 50);
        txtNumerosRan.setEnabled(false);
        
        lblBuscar.setBounds(100, 390, 200, 30);
        
        tfBuscar.setBounds(100, 420, 80, 30);
        tfBuscar.addKeyListener(new KeyAdapter() {
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                e.consume();  
            }
            String textocorregir = tfBuscar.getText();

        
                if (Character.isDigit(c) && textocorregir.length() >= 3) {
                    e.consume();
                }
            }
        });
        
        btnBuscar.setBounds(200, 420, 100, 30);
        btnBuscar.setBackground(Color.blue);
        btnBuscar.setForeground(Color.white);
        btnBuscar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                lblEncontrado.setVisible(true);
                txtEncontrado.setVisible(true);
                btnSiguiente.setEnabled(false);
                int numeroABuscar = Integer.parseInt(tfBuscar.getText());
        
                // busca el número en la lista
                boolean encontrado = listaDb.buscarLista(numeroABuscar);

                // muestra el resultado en txtEncontrado
                if (encontrado) {
                    txtEncontrado.setText("Encontrado");
                } else {
                    txtEncontrado.setText("No encontrado");
                }
            }
        });
        lblEncontrado.setBounds(400, 390, 200, 30);
        
        txtEncontrado.setBounds(400, 420, 250, 30);
        txtEncontrado.setEnabled(false);
        
        btnReiniciar.setBounds(340, 500, 100, 40);
        btnReiniciar.setBackground(Color.blue);
        btnReiniciar.setForeground(Color.white);
        btnReiniciar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                // Restablecer estado inicial de la GUI
                lblNumAl.setVisible(false);
                txtNumerosAl.setVisible(false);
                lblDefRan.setVisible(false);
                lblValU.setVisible(false);    
                lblValD.setVisible(false);        
                tfValU.setVisible(false); 
                tfValD.setVisible(false);        
                btnSiguiente.setVisible(false);       
                lblNumRan.setVisible(false);
                txtNumerosRan.setVisible(false);       
                btnReiniciar.setVisible(false);
                lblBuscar.setVisible(false);        
                tfBuscar.setVisible(false);        
                btnBuscar.setVisible(false);
                lblEncontrado.setVisible(false);
                txtEncontrado.setVisible(false);

                // Limpiar campos de texto
                tfValU.setText("");
                tfValD.setText("");
                tfBuscar.setText("");
                txtNumerosAl.setText("");
                txtNumerosRan.setText("");
                txtEncontrado.setText("");

                // Habilitar botón Iniciar
                btnIniciar.setEnabled(true);

                // Reiniciar listaDb
                listaDb = new ListaDoble();
                }  
            });
        add(lblTitulo);
        add(btnIniciar);
        add(lblNumAl);
        add(scrollPane);
        //add(txtNumerosAl);
        add(lblDefRan);
        add(lblValU);
        add(lblValD);
        add(tfValU);
        add(tfValD);
        add(btnSiguiente);
        add(lblNumRan);
        add(txtNumerosRan);
        add(lblBuscar);
        add(tfBuscar);
        add(btnBuscar);
        add(lblEncontrado);
        add(txtEncontrado);
        add(btnReiniciar);
    }
    
    private void mostrarNumerosAleatorios() {
        Random r = new Random();
        
        
        int d;
        final int M = 29;
        final int MX = 999;

        for (int i = 1; i <= M; i++) {
            d = r.nextInt(MX) + 1;
            listaDb.insertarCabezaLista(d);
        }

        // Mostrar los números aleatorios en el JTextArea
        txtNumerosAl.setText(listaDb.toString());
    }
    
    private void filtrarNumerosEnRango(ListaDoble listaDb, int valorU, int valorD) {
    IteradorLista iterador = new IteradorLista(listaDb);
    Nodo actual;
   
    actual = iterador.siguiente();
    while (actual != null) {
        int w;
         w = actual.getDato();
        if (!(w >= valorU && w <= valorD)) { // fuera de rango
            listaDb.eliminar(w);
        }
        actual = iterador.siguiente();
        }
    }

}
