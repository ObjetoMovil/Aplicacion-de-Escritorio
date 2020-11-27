/*
 * Gui
 */
package gnz.frontend;

import com.panamahitek.ArduinoException;
import gnz.analizadores.CommunicationLexer;
import gnz.analizadores.CommunicationParser;
import gnz.analizadores.Lexico;
import gnz.analizadores.Lexico3;
import gnz.analizadores.parser1;
import gnz.analizadores.parser3;
import gnz.backend.Matriz.ManejadorMatriz;
import gnz.backend.Matriz.Run;
import gnz.backend.archivos.ManejadorDeArchivos;
import gnz.backend.manejadores.ManejadorDeSesiones;
import gnz.backend.manejadores.RFCommunicationDriver;
import gnz.backend.objetoMovil.Coordenada;
import gnz.backend.objetoMovil.Movement;
import gnz.backend.objetoMovil.Movil;
import gnz.backend.sockets.Cliente;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author jesfrin
 */
public class FrameOM extends javax.swing.JFrame {
    
    //Variables e instancias utilizadas para la comunicacion con el transceptorA.
    private RFCommunicationDriver RFDriver = new RFCommunicationDriver();
    private boolean connected = false;
    
    //Variables para el usuario
    public static String idUsuario;
    public static int idSesion;
    
    //VARIABLES NECESARIAS
    private Movil movil;
    JFileChooser seleccionar = new JFileChooser();
    File Archivo;
    FileOutputStream salida;
    
    //Variables para mapa
    private ManejadorDePanel manPanel;
    private ManejadorDeArchivos manArchivos;
    protected static final String ICON_URL = "/gnz/frontend/Imagenes/coche3.png";
    private boolean socket = false;
    
    public FrameOM(String user) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.movil = new Movil(this);
        idUsuario = user;
        colocarUsuario();
        this.setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Objeto Movil");
        //Elementos para creacion de mapa
        this.manPanel = new ManejadorDePanel(this, 50);
        actualizarEquivalencia();
        this.manArchivos = new ManejadorDeArchivos(this);
        //Elementos para movimieto libre del objeto movil
        movil.getObjetoMovil().setIcon(new ImageIcon(getClass().getResource("Imagenes/coche3.png")));
        movil.getObjetoMovil().setOpaque(true);
        System.out.println(getClass().getResource(""));
        //movil.getObjetoMovil().setSize((26 * Run.MULT), (16 * Run.MULT));
        //movil.getObjetoMovil().setVisible(true);
        this.matrizPanel.add(movil.getObjetoMovil(), 0, 0);
        matrizPanel.setOpaque(false);
        agregarGrupoDeBotones();
        //cargando();
        
        //Inicializar los elementos del panel de Comuniacion Directa
        statusLabel.setText("Estado: No Conectado");
        statusPanel.setBackground(Color.red);
        RFDriver.fillAvailableConnections(availableConnectionsComboBox);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoDeBotones = new javax.swing.ButtonGroup();
        grupoOpciones = new javax.swing.ButtonGroup();
        matrizPanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        coordenadasjLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cambiarCuadriculajComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        equivalenciajLabel = new javax.swing.JLabel();
        guardarMapajButton = new javax.swing.JButton();
        abrirMapaButton = new javax.swing.JButton();
        guardarComojButton = new javax.swing.JButton();
        nuevoMapajButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        borrarMapajButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        paredjRadioButton = new javax.swing.JRadioButton();
        sinSuperficiejRadioButton = new javax.swing.JRadioButton();
        rugosojRadioButton = new javax.swing.JRadioButton();
        lisojRadioButton = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        comandsTextArea = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        complexMovements = new javax.swing.JRadioButton();
        baseMovements = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        leftBorder = new javax.swing.JPanel();
        rightBoder = new javax.swing.JPanel();
        topBorder = new javax.swing.JPanel();
        bottomBorder = new javax.swing.JPanel();
        leftCorner = new javax.swing.JPanel();
        rightCorner = new javax.swing.JPanel();
        statusPanel = new javax.swing.JPanel();
        statusLabel = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        connectionPanel = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        availableConnectionsComboBox = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        connectButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        disconnectButton = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        send = new javax.swing.JButton();
        commandsArea = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        messagesArea = new javax.swing.JTextArea();
        jPanel14 = new javax.swing.JPanel();
        clearButton = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        send1 = new javax.swing.JButton();
        commandstxt = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jPanel16 = new javax.swing.JPanel();
        connectButton1 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        disconnectButton1 = new javax.swing.JButton();
        userjLabel = new javax.swing.JLabel();
        cerrarSesionjButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OM_V1.0");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(ICON_URL)));
        setResizable(false);

        matrizPanel.setBackground(new java.awt.Color(254, 254, 254));
        matrizPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        matrizPanel.setName(""); // NOI18N
        matrizPanel.setOpaque(false);
        matrizPanel.setPreferredSize(new java.awt.Dimension(601, 601));
        matrizPanel.setRequestFocusEnabled(false);
        matrizPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                matrizPanelMouseDragged(evt);
            }
        });
        matrizPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                matrizPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout matrizPanelLayout = new javax.swing.GroupLayout(matrizPanel);
        matrizPanel.setLayout(matrizPanelLayout);
        matrizPanelLayout.setHorizontalGroup(
            matrizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        matrizPanelLayout.setVerticalGroup(
            matrizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        coordenadasjLabel.setText("Coordenadas:");

        jLabel1.setText("Cambio de cuadricula");

        cambiarCuadriculajComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5", "10", "30", "50", "100", "150", "200" }));
        cambiarCuadriculajComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarCuadriculajComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Equivalencia:");

        equivalenciajLabel.setText("cm");

        guardarMapajButton.setText("Guardar mapa");
        guardarMapajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarMapajButtonActionPerformed(evt);
            }
        });

        abrirMapaButton.setText("Abrir mapa");
        abrirMapaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirMapaButtonActionPerformed(evt);
            }
        });

        guardarComojButton.setText("Guardar como");
        guardarComojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarComojButtonActionPerformed(evt);
            }
        });

        nuevoMapajButton.setText("Nuevo mapa");
        nuevoMapajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoMapajButtonActionPerformed(evt);
            }
        });

        jButton2.setText("Log");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        borrarMapajButton.setText("Borrar todo");
        borrarMapajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarMapajButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(130, 226, 33));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        jPanel1.setForeground(javax.swing.UIManager.getDefaults().getColor("MenuBar.highlight"));

        jLabel10.setText("Texturas disponibles");

        paredjRadioButton.setForeground(new java.awt.Color(1, 1, 1));
        paredjRadioButton.setText("Pared");

        sinSuperficiejRadioButton.setText("Sin superficie(Blanco)");

        rugosojRadioButton.setText("Rugoso(Gris Oscuro)");

        lisojRadioButton.setForeground(java.awt.Color.green);
        lisojRadioButton.setText("Liso");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(paredjRadioButton)
                            .addComponent(lisojRadioButton)
                            .addComponent(sinSuperficiejRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(rugosojRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel10)))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(paredjRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sinSuperficiejRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rugosojRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lisojRadioButton)
                .addGap(0, 45, Short.MAX_VALUE))
        );

        jButton1.setText("Facil");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton10.setText("Medio");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Dificil");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel31.setText("Ejemplos de Mapas:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(coordenadasjLabel)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cambiarCuadriculajComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(equivalenciajLabel)))
                        .addGap(62, 62, 62)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(borrarMapajButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(guardarComojButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(abrirMapaButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nuevoMapajButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(guardarMapajButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel31))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(coordenadasjLabel)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cambiarCuadriculajComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(equivalenciajLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(borrarMapajButton)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abrirMapaButton)
                    .addComponent(nuevoMapajButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarComojButton)
                    .addComponent(guardarMapajButton))
                .addGap(47, 47, 47)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton11)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Mapa", jPanel3);

        jLabel3.setText("COMANDOS");

        jButton3.setText("ABRIR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        comandsTextArea.setColumns(20);
        comandsTextArea.setRows(5);
        jScrollPane1.setViewportView(comandsTextArea);

        jLabel5.setText("COORDENADA X");

        jLabel6.setText("COORDENADA Y");

        jButton4.setText("EJECUTAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextField1.setText("0");

        jTextField2.setText("0");

        jButton5.setText("POSICIONAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(15, 216, 49));
        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel7.setText("0");

        jLabel8.setBackground(new java.awt.Color(15, 216, 49));
        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel8.setText("0");

        jButton6.setText("POINT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("OBSTACULO");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel9.setText("MOVIMIENTOS QUE SE REALIZARAN");

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jButton8.setText("GUARDAR HISTORICO");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("LIMPIAR");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        grupoOpciones.add(complexMovements);
        complexMovements.setText("Estoy en Movimientos Complejos");
        complexMovements.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                complexMovementsActionPerformed(evt);
            }
        });

        grupoOpciones.add(baseMovements);
        baseMovements.setText("Estoy en Movimientos Base");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(43, 43, 43))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(51, 51, 51)))
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(complexMovements)
                                .addGap(69, 69, 69)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jButton3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(baseMovements))))
                        .addGap(0, 30, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(complexMovements)
                    .addComponent(baseMovements))
                .addGap(2, 2, 2)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addGap(71, 71, 71))
        );

        jTabbedPane1.addTab("Movimiento Libre", jPanel4);

        jPanel7.setLayout(new java.awt.BorderLayout());

        leftBorder.setMaximumSize(new java.awt.Dimension(20, 32767));
        leftBorder.setMinimumSize(new java.awt.Dimension(20, 100));
        leftBorder.setPreferredSize(new java.awt.Dimension(20, 667));

        javax.swing.GroupLayout leftBorderLayout = new javax.swing.GroupLayout(leftBorder);
        leftBorder.setLayout(leftBorderLayout);
        leftBorderLayout.setHorizontalGroup(
            leftBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        leftBorderLayout.setVerticalGroup(
            leftBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 628, Short.MAX_VALUE)
        );

        jPanel7.add(leftBorder, java.awt.BorderLayout.LINE_START);

        rightBoder.setMaximumSize(new java.awt.Dimension(20, 32767));
        rightBoder.setMinimumSize(new java.awt.Dimension(20, 100));
        rightBoder.setPreferredSize(new java.awt.Dimension(20, 667));

        javax.swing.GroupLayout rightBoderLayout = new javax.swing.GroupLayout(rightBoder);
        rightBoder.setLayout(rightBoderLayout);
        rightBoderLayout.setHorizontalGroup(
            rightBoderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        rightBoderLayout.setVerticalGroup(
            rightBoderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 628, Short.MAX_VALUE)
        );

        jPanel7.add(rightBoder, java.awt.BorderLayout.LINE_END);

        topBorder.setPreferredSize(new java.awt.Dimension(659, 20));

        javax.swing.GroupLayout topBorderLayout = new javax.swing.GroupLayout(topBorder);
        topBorder.setLayout(topBorderLayout);
        topBorderLayout.setHorizontalGroup(
            topBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 659, Short.MAX_VALUE)
        );
        topBorderLayout.setVerticalGroup(
            topBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel7.add(topBorder, java.awt.BorderLayout.PAGE_START);

        bottomBorder.setMaximumSize(new java.awt.Dimension(32767, 20));
        bottomBorder.setMinimumSize(new java.awt.Dimension(100, 20));
        bottomBorder.setPreferredSize(new java.awt.Dimension(659, 20));
        bottomBorder.setLayout(new java.awt.BorderLayout());

        leftCorner.setMaximumSize(new java.awt.Dimension(20, 32767));
        leftCorner.setMinimumSize(new java.awt.Dimension(20, 100));
        leftCorner.setPreferredSize(new java.awt.Dimension(20, 20));

        javax.swing.GroupLayout leftCornerLayout = new javax.swing.GroupLayout(leftCorner);
        leftCorner.setLayout(leftCornerLayout);
        leftCornerLayout.setHorizontalGroup(
            leftCornerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        leftCornerLayout.setVerticalGroup(
            leftCornerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        bottomBorder.add(leftCorner, java.awt.BorderLayout.LINE_START);

        rightCorner.setMaximumSize(new java.awt.Dimension(20, 32767));
        rightCorner.setMinimumSize(new java.awt.Dimension(20, 100));
        rightCorner.setPreferredSize(new java.awt.Dimension(20, 20));
        rightCorner.setLayout(new java.awt.GridBagLayout());

        statusPanel.setMaximumSize(new java.awt.Dimension(10, 10));
        statusPanel.setMinimumSize(new java.awt.Dimension(10, 10));
        statusPanel.setPreferredSize(new java.awt.Dimension(10, 10));

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        rightCorner.add(statusPanel, new java.awt.GridBagConstraints());

        bottomBorder.add(rightCorner, java.awt.BorderLayout.LINE_END);

        statusLabel.setMaximumSize(new java.awt.Dimension(20, 20));
        statusLabel.setMinimumSize(new java.awt.Dimension(20, 20));
        statusLabel.setPreferredSize(new java.awt.Dimension(20, 20));
        bottomBorder.add(statusLabel, java.awt.BorderLayout.CENTER);

        jPanel7.add(bottomBorder, java.awt.BorderLayout.PAGE_END);

        jPanel8.setLayout(new java.awt.BorderLayout());

        connectionPanel.setMaximumSize(new java.awt.Dimension(50, 2147483647));
        connectionPanel.setMinimumSize(new java.awt.Dimension(50, 0));
        connectionPanel.setPreferredSize(new java.awt.Dimension(50, 100));
        connectionPanel.setLayout(new java.awt.BorderLayout());

        jPanel9.setMaximumSize(new java.awt.Dimension(250, 85));
        jPanel9.setMinimumSize(new java.awt.Dimension(250, 85));
        jPanel9.setPreferredSize(new java.awt.Dimension(250, 85));
        jPanel9.setLayout(new java.awt.GridBagLayout());

        availableConnectionsComboBox.setMaximumSize(new java.awt.Dimension(200, 32767));
        availableConnectionsComboBox.setMinimumSize(new java.awt.Dimension(200, 23));
        availableConnectionsComboBox.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel9.add(availableConnectionsComboBox, new java.awt.GridBagConstraints());

        connectionPanel.add(jPanel9, java.awt.BorderLayout.LINE_START);

        jPanel11.setMaximumSize(new java.awt.Dimension(2147483647, 85));
        jPanel11.setMinimumSize(new java.awt.Dimension(270, 85));
        jPanel11.setPreferredSize(new java.awt.Dimension(369, 85));
        jPanel11.setLayout(new java.awt.GridBagLayout());

        connectButton.setText("Conectar");
        connectButton.setMaximumSize(new java.awt.Dimension(115, 23));
        connectButton.setMinimumSize(new java.awt.Dimension(115, 23));
        connectButton.setPreferredSize(new java.awt.Dimension(115, 23));
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });
        jPanel11.add(connectButton, new java.awt.GridBagConstraints());

        jLabel4.setText("          ");
        jPanel11.add(jLabel4, new java.awt.GridBagConstraints());

        disconnectButton.setText("Desconectar");
        disconnectButton.setMaximumSize(new java.awt.Dimension(115, 23));
        disconnectButton.setMinimumSize(new java.awt.Dimension(115, 23));
        disconnectButton.setPreferredSize(new java.awt.Dimension(115, 23));
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });
        jPanel11.add(disconnectButton, new java.awt.GridBagConstraints());

        connectionPanel.add(jPanel11, java.awt.BorderLayout.CENTER);

        jPanel8.add(connectionPanel, java.awt.BorderLayout.PAGE_START);

        jPanel10.setLayout(new java.awt.BorderLayout());

        jPanel12.setMaximumSize(new java.awt.Dimension(32767, 30));
        jPanel12.setMinimumSize(new java.awt.Dimension(100, 30));
        jPanel12.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel12.setLayout(new java.awt.BorderLayout());

        send.setText("Enviar");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });
        jPanel12.add(send, java.awt.BorderLayout.LINE_START);

        commandsArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                commandsAreaKeyPressed(evt);
            }
        });
        jPanel12.add(commandsArea, java.awt.BorderLayout.CENTER);

        jPanel10.add(jPanel12, java.awt.BorderLayout.PAGE_START);

        jPanel13.setLayout(new java.awt.BorderLayout());

        messagesArea.setEditable(false);
        messagesArea.setColumns(20);
        messagesArea.setRows(5);
        jScrollPane3.setViewportView(messagesArea);

        jPanel13.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel14.setMaximumSize(new java.awt.Dimension(32767, 25));
        jPanel14.setMinimumSize(new java.awt.Dimension(0, 25));
        jPanel14.setPreferredSize(new java.awt.Dimension(613, 25));
        jPanel14.setLayout(new javax.swing.BoxLayout(jPanel14, javax.swing.BoxLayout.LINE_AXIS));

        clearButton.setText("Borrar Mensajes");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        jPanel14.add(clearButton);

        jPanel13.add(jPanel14, java.awt.BorderLayout.PAGE_END);

        jPanel10.add(jPanel13, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel8, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Comunicacion Directa", jPanel7);

        jLabel32.setText("Enviados");

        jLabel33.setText("Respuesta");

        send1.setText("Enviar");
        send1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send1ActionPerformed(evt);
            }
        });

        commandstxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                commandstxtKeyPressed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane5.setViewportView(jTextArea3);

        jPanel16.setMaximumSize(new java.awt.Dimension(2147483647, 85));
        jPanel16.setMinimumSize(new java.awt.Dimension(270, 85));
        jPanel16.setPreferredSize(new java.awt.Dimension(369, 85));
        jPanel16.setLayout(new java.awt.GridBagLayout());

        connectButton1.setText("Conectar");
        connectButton1.setMaximumSize(new java.awt.Dimension(115, 23));
        connectButton1.setMinimumSize(new java.awt.Dimension(115, 23));
        connectButton1.setPreferredSize(new java.awt.Dimension(115, 23));
        connectButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButton1ActionPerformed(evt);
            }
        });
        jPanel16.add(connectButton1, new java.awt.GridBagConstraints());

        jLabel34.setText("          ");
        jPanel16.add(jLabel34, new java.awt.GridBagConstraints());

        disconnectButton1.setText("Desconectar");
        disconnectButton1.setMaximumSize(new java.awt.Dimension(115, 23));
        disconnectButton1.setMinimumSize(new java.awt.Dimension(115, 23));
        disconnectButton1.setPreferredSize(new java.awt.Dimension(115, 23));
        disconnectButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButton1ActionPerformed(evt);
            }
        });
        jPanel16.add(disconnectButton1, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel32)
                                .addGap(249, 249, 249)
                                .addComponent(jLabel33))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(send1)
                                .addGap(0, 0, 0)
                                .addComponent(commandstxt, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 28, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(send1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(commandstxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Comunicación desde Raspi", jPanel15);

        userjLabel.setText("Usuario:");

        cerrarSesionjButton.setText("Cerrar Sesion");
        cerrarSesionjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionjButtonActionPerformed(evt);
            }
        });

        jPanel5.setLayout(new java.awt.GridLayout(1, 20, 0, 10));

        jLabel30.setBackground(new java.awt.Color(15, 159, 230));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("20");
        jLabel30.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel30.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel30.setOpaque(true);
        jPanel5.add(jLabel30);

        jLabel11.setBackground(new java.awt.Color(243, 55, 1));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("40");
        jLabel11.setOpaque(true);
        jPanel5.add(jLabel11);

        jLabel15.setBackground(new java.awt.Color(15, 159, 230));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("60");
        jLabel15.setOpaque(true);
        jPanel5.add(jLabel15);

        jLabel16.setBackground(new java.awt.Color(243, 55, 1));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("80");
        jLabel16.setOpaque(true);
        jPanel5.add(jLabel16);

        jLabel18.setBackground(new java.awt.Color(15, 159, 230));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("100");
        jLabel18.setOpaque(true);
        jPanel5.add(jLabel18);

        jLabel19.setBackground(new java.awt.Color(243, 55, 1));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("120");
        jLabel19.setOpaque(true);
        jPanel5.add(jLabel19);

        jLabel17.setBackground(new java.awt.Color(15, 159, 230));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("140");
        jLabel17.setOpaque(true);
        jPanel5.add(jLabel17);

        jLabel12.setBackground(new java.awt.Color(243, 55, 1));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("160");
        jLabel12.setOpaque(true);
        jPanel5.add(jLabel12);

        jLabel13.setBackground(new java.awt.Color(15, 159, 230));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("180");
        jLabel13.setOpaque(true);
        jPanel5.add(jLabel13);

        jLabel14.setBackground(new java.awt.Color(243, 55, 1));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("200");
        jLabel14.setOpaque(true);
        jPanel5.add(jLabel14);

        jPanel6.setLayout(new java.awt.GridLayout(10, 1));

        jLabel20.setBackground(new java.awt.Color(2, 208, 52));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("20");
        jLabel20.setOpaque(true);
        jPanel6.add(jLabel20);

        jLabel24.setBackground(new java.awt.Color(146, 242, 11));
        jLabel24.setText("40");
        jLabel24.setOpaque(true);
        jPanel6.add(jLabel24);

        jLabel21.setBackground(new java.awt.Color(2, 208, 52));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("60");
        jLabel21.setOpaque(true);
        jPanel6.add(jLabel21);

        jLabel23.setBackground(new java.awt.Color(146, 242, 11));
        jLabel23.setText("80");
        jLabel23.setOpaque(true);
        jPanel6.add(jLabel23);

        jLabel26.setBackground(new java.awt.Color(2, 208, 52));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("100");
        jLabel26.setOpaque(true);
        jPanel6.add(jLabel26);

        jLabel27.setBackground(new java.awt.Color(146, 242, 11));
        jLabel27.setText("120");
        jLabel27.setOpaque(true);
        jPanel6.add(jLabel27);

        jLabel25.setBackground(new java.awt.Color(2, 208, 52));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("140");
        jLabel25.setOpaque(true);
        jPanel6.add(jLabel25);

        jLabel28.setBackground(new java.awt.Color(146, 242, 11));
        jLabel28.setText("160");
        jLabel28.setOpaque(true);
        jPanel6.add(jLabel28);

        jLabel29.setBackground(new java.awt.Color(2, 208, 52));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("180");
        jLabel29.setOpaque(true);
        jPanel6.add(jLabel29);

        jLabel22.setBackground(new java.awt.Color(146, 242, 11));
        jLabel22.setText("200");
        jLabel22.setOpaque(true);
        jPanel6.add(jLabel22);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(matrizPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userjLabel)
                        .addGap(6, 6, 6)
                        .addComponent(cerrarSesionjButton)))
                .addGap(6, 6, 6)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(matrizPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(userjLabel))
                    .addComponent(cerrarSesionjButton)))
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void matrizPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_matrizPanelMouseClicked
        this.manArchivos.setMapaEstaGuardado(false);
        this.manPanel.accionParaClick(evt, averiguarColorSeleccionado());
//        System.out.println("PRECIONANDO(" + evt.getX() + "," + evt.getY() + ")");
    }//GEN-LAST:event_matrizPanelMouseClicked

    private void matrizPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_matrizPanelMouseDragged
        this.manArchivos.setMapaEstaGuardado(false);
        this.manPanel.accionParaMouseDragged(evt, averiguarColorSeleccionado());
    }//GEN-LAST:event_matrizPanelMouseDragged
    
    private void cerrarSesionjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionjButtonActionPerformed
        this.dispose();
        new inicioSesionFrame();
    }//GEN-LAST:event_cerrarSesionjButtonActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        movil.getObjetoMovil().setSize((26 * Run.MULT), (16 * Run.MULT));
        movil.getObjetoMovil().setVisible(true);

        if (movil.getObjetoMovil().getX()==0) {
            //movil.repos(0, 0, jTextArea2);
            movil.getObjetoMovil().setLocation(0, 0);
        }
        movil.limpiar();
        movil.getObjetoMovil().repaint();
        //System.out.print("XACTUAL:" + movil.getObjetoMovil().getX() + " ");
        //System.out.println("YACTUAL:" + movil.getObjetoMovil().getY());
        /**
        * **********Accion para no pintar sobre el objeto
        * movil***************
        */
        this.manPanel.getManMatriz().ocuparDesocuparPosicion(movil.getObjetoMovil().getX(), movil.getObjetoMovil().getY());

        this.manPanel.pintarCuadricula(this.manPanel.getG());
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void complexMovementsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_complexMovementsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_complexMovementsActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jTextArea2.setText("");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        if (seleccionar.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
            Archivo = seleccionar.getSelectedFile();
            String Documento = jTextArea2.getText();
            String mensaje = guardar(Archivo, Documento);
            if (mensaje != null) {
                JOptionPane.showMessageDialog(null, mensaje);
            } else {
                JOptionPane.showMessageDialog(null, "Extencion no comaptible");
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if ((!jTextField1.getText().equals("")) && (!jTextField2.getText().equals(""))) {
            int cordenadax = (Integer.parseInt(jTextField1.getText()));
            int cordenaday = (Integer.parseInt(jTextField2.getText()));
            movil.limpiar();
            movil.coordenadas.add(new Coordenada(cordenadax, cordenaday));
            jTextField1.setText("");
            jTextField2.setText("");
            JOptionPane.showMessageDialog(null, "SE AGREGO EL OBSTACULO");

        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jLabel7.setText("" + movil.getObjetoMovil().getX() / Run.MULT);
        jLabel8.setText("" + (movil.getObjetoMovil().getY()) / Run.MULT);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        /*mostrando el OM hasta aui cambio 1*/
        movil.getObjetoMovil().setSize((26 * Run.MULT), (16 * Run.MULT));
        movil.getObjetoMovil().setVisible(true);
        if ((!jTextField1.getText().equals("")) && (!jTextField2.getText().equals(""))) {
            int cordenadax = (Integer.parseInt(jTextField1.getText()) * Run.MULT);
            int cordenaday = (Integer.parseInt(jTextField2.getText()) * Run.MULT);
            movil.repos(cordenadax, cordenaday, jTextArea2);
            movil.limpiar();
            movil.getObjetoMovil().repaint();
            this.manPanel.dibujarCuadriculaDeMatriz(this.manPanel.getManMatriz(), matrizPanel);
            //System.out.print("XACTUAL:" + movil.getObjetoMovil().getX() + " ");
            //System.out.println("YACTUAL:" + movil.getObjetoMovil().getY());
            /**
            * **********Accion para no pintar sobre el objeto
            * movil***************
            */
            this.manPanel.pintarCuadricula(this.manPanel.getG());
            this.manPanel.getManMatriz().ocuparDesocuparPosicion(movil.getObjetoMovil().getX(), movil.getObjetoMovil().getY());
            this.manPanel.pintarCuadricula(this.manPanel.getG());
        }
        limpiarPanel();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try{
            if (!complexMovements.isSelected() && !baseMovements.isSelected()) {
                JOptionPane.showMessageDialog(this, "Seleccione el tipo de movimiento");
            } else if(comandsTextArea.getText().isBlank() || comandsTextArea.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "No se ha indicado ningun comando.");
            } else {
                //Movimientos Complejos
                if (complexMovements.isSelected()) {
                    parser1 parser1 = new parser1(new Lexico(new StringReader(comandsTextArea.getText())));
                    parser1.parse();
                    movil.limpiar();
                    if (parser1.listavalores != null) {
                        movil.enviar(parser1.listavalores, 30, jLabel7, jLabel8, jTextArea2);
                    } else {
                        JOptionPane.showMessageDialog(null, "Existen errores en sus comandos, arreglelos y pruebe nuevamente.");
                    }
                    //Movimientos Base
                } else {
                    parser3 parser3 = new parser3(new Lexico3(new StringReader(comandsTextArea.getText())));
                    parser3.parse();

                    this.jTextArea2.append("\n --------------SE ENVIO AL OM LA SIGUIENTE INSTRUCCION:---------------\n" + parser3.cadena);
                }
                this.manPanel.dibujarCuadriculaDeMatriz(this.manPanel.getManMatriz(), matrizPanel);
            }
        } catch(Exception e){
            System.out.println("Error al analizar.");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //ABRIR EL ARCHIVO
        comandsTextArea.setText("");
        ManejadorDeArchivos arc = new ManejadorDeArchivos(this);
        File f = arc.Abrir();
        if (f != null) {
            comandsTextArea.setText(arc.leer(f.toString()));
        } else {
            JOptionPane.showMessageDialog(null, "NO SE SELECCIONO NINGUN FICHERO");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        try {
            this.manArchivos.abrirMapaPorDefecto(this.matrizPanel, this.manPanel.getManMatriz(), "dificil");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Por favor de click en el panel antes de abrir el archivo");
            //Logger.getLogger(FrameOM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        try {
            this.manArchivos.abrirMapaPorDefecto(this.matrizPanel, this.manPanel.getManMatriz(), "intermedio");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Por favor de click en el panel antes de abrir el archivo");
            //Logger.getLogger(FrameOM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            this.manArchivos.abrirMapaPorDefecto(this.matrizPanel, this.manPanel.getManMatriz(), "facil");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Por favor de click en el panel antes de abrir el archivo");
            //Logger.getLogger(FrameOM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void borrarMapajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarMapajButtonActionPerformed
        limpiarPanel();
    }//GEN-LAST:event_borrarMapajButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (idUsuario == null) {
            JOptionPane.showMessageDialog(this, "Debe haber iniciado sesion para esta opcion");
        } else {
            LogJDialog log = new LogJDialog(this, true);
            log.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void nuevoMapajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoMapajButtonActionPerformed
        try {
            this.manArchivos.crearNuevoMapa(this.manPanel.getManMatriz(), this.matrizPanel);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Mo se pudo crear un nuevo mapa");
            Logger.getLogger(FrameOM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nuevoMapajButtonActionPerformed

    private void guardarComojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarComojButtonActionPerformed
        try {
            this.manArchivos.guardarMapaComo(this.manPanel.getManMatriz());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar el mapa");
            Logger.getLogger(FrameOM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_guardarComojButtonActionPerformed

    private void abrirMapaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirMapaButtonActionPerformed
        try {
            this.manArchivos.abrirMapa(this.matrizPanel, this.manPanel.getManMatriz());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Por favor de click en el panel antes de abrir el archivo");
            //Logger.getLogger(FrameOM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_abrirMapaButtonActionPerformed

    private void guardarMapajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarMapajButtonActionPerformed
        try {
            this.manArchivos.guardarMapaEnArchivo(this.manPanel.getManMatriz());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No se pudo guardar el mapa");
            Logger.getLogger(FrameOM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_guardarMapajButtonActionPerformed

    private void cambiarCuadriculajComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarCuadriculajComboBoxActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this, "Se borrara el mapa actual");
        System.out.println("OPCION:" + opcion);
        switch (opcion) {
            case 0:
            this.matrizPanel.setBackground(Color.BLACK);
            this.matrizPanel.setBackground(Color.WHITE);
            this.manPanel = new ManejadorDePanel(this, Integer.valueOf(String.valueOf(this.cambiarCuadriculajComboBox.getSelectedItem())));
            JOptionPane.showMessageDialog(this, "Cuadricula cambiada");
            actualizarEquivalencia();
            break;
            default:
            break;
        }
    }//GEN-LAST:event_cambiarCuadriculajComboBoxActionPerformed

    /**
     * Metodo encargado de establecer la conexion entre la aplicacion java y el traceptor conectado
     * al puerto seleccionado en el JComboBox.
     * @param evt 
     */
    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        if(connected){
            JOptionPane.showMessageDialog(this, "Ya existe una conexion activa.");
        } else if(availableConnectionsComboBox.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna conexion.");
        } else{
            try {
                RFDriver.connect(availableConnectionsComboBox, statusPanel, statusLabel, messagesArea);
                JOptionPane.showMessageDialog(this, "Conexion establecida con exito.");
                connected = true;
            } catch (ArduinoException ex) {
                //Do nothing
            }   
        }
    }//GEN-LAST:event_connectButtonActionPerformed

    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButtonActionPerformed
        try{
            if(connected){
                RFDriver.disconnect(availableConnectionsComboBox, statusPanel, statusLabel);
                JOptionPane.showMessageDialog(this, "Conexion desactivada.");
                connected = false;
            } else{
                JOptionPane.showMessageDialog(this, "No existe ninguna conexion activa.");
            }
        } catch(ArduinoException e){
            //Do nothing
        } 
    }//GEN-LAST:event_disconnectButtonActionPerformed

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        if(!connected){
            JOptionPane.showMessageDialog(this, "No se ha iniciado ninguna conexion para enviar el comando.");
        } else if(commandsArea.getText().isEmpty() || commandsArea.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "No se ha ingresado ningun comando.");
        } else{
            analyse(commandsArea.getText());
        }
    }//GEN-LAST:event_sendActionPerformed

    private void commandsAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_commandsAreaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(!connected){
                JOptionPane.showMessageDialog(this, "No se ha iniciado ninguna conexion para enviar el comando.");
            } else if(commandsArea.getText().isEmpty() || commandsArea.getText().isBlank()){
                JOptionPane.showMessageDialog(this, "No se ha ingresado ningun comando.");
            } else{
                analyse(commandsArea.getText());
            }
        }    
    }//GEN-LAST:event_commandsAreaKeyPressed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        messagesArea.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void send1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send1ActionPerformed
         if(!connected){
            JOptionPane.showMessageDialog(this, "No se ha iniciado ninguna conexion para enviar el comando.");
        } else if(commandsArea.getText().isEmpty() || commandsArea.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "No se ha ingresado ningun comando.");
        } else{
            analyse(commandstxt.getText());
        }
    }//GEN-LAST:event_send1ActionPerformed

    private void commandstxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_commandstxtKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(!connected){
                JOptionPane.showMessageDialog(this, "No se ha iniciado ninguna conexion para enviar el comando.");
            } else if(commandsArea.getText().isEmpty() || commandsArea.getText().isBlank()){
                JOptionPane.showMessageDialog(this, "No se ha ingresado ningun comando.");
            } else{
                analyse(commandstxt.getText());
            }
        } 
    }//GEN-LAST:event_commandstxtKeyPressed

    private void connectButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButton1ActionPerformed
        Cliente.crearConexion();        
    }//GEN-LAST:event_connectButton1ActionPerformed

    private void disconnectButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButton1ActionPerformed
        Cliente.cerrarConexion();
    }//GEN-LAST:event_disconnectButton1ActionPerformed

    /**
     * Metodo que realiza el analisis lexico y sintactico del comando que se desea enviar al OM
     */
    private void analyse(String txt){
        try {
            CommunicationParser parser = new CommunicationParser(new CommunicationLexer(new StringReader(txt)));
            parser.parse();
            if(parser.getMovement() != null){
                createPackegeData(parser.getMovement());
            } else{
                JOptionPane.showMessageDialog(this, "El comando ingresado no es correcto.");
            }
        } catch (Exception ex) {
            Logger.getLogger(FrameOM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metodo que se encarga de obtener los datos del movimiento que se recibe como parametro y llama al 
     * metodo de envio de datos hacia el OM.
     * @param movement Instancia que contiene los datos del movimiento a realizar.
     */
    private void createPackegeData(Movement movement){
        switch(movement.getType()){
            case BASE:
                sendData(movement.getType().ordinal() +"|"+ movement.getMotor().ordinal() +"|"+ movement.getDistance() +"|"+ movement.getSpeed().ordinal() +"|"+ movement.getOrientation1().ordinal() +"|");
                break;
            case STRAIGHT:
                sendData(movement.getType().ordinal() +"|"+ movement.getDistance() +"|"+ movement.getSpeed().ordinal() +"|"+ movement.getOrientation1().ordinal() +"|");
                break;
            case DIAGONAL:
                sendData(movement.getType().ordinal() +"|"+ movement.getDistance() +"|"+ movement.getSpeed().ordinal() +"|"+ movement.getAngle() +"|");
                break;
            case CURVED:
                sendData(movement.getType().ordinal() +"|"+ movement.getRadio() +"|"+ movement.getSpeed().ordinal() +"|"+ movement.getOrientation1().ordinal() +"|"+ movement.getOrientation2().ordinal() +"|");
                break;
        }
        messagesArea.setText(messagesArea.getText() + "Enviado: " + commandsArea.getText() + "\n");
        commandsArea.setText("");
    }
    
    private void sendData(String data){
        if(socket){
            Cliente.enviarMensaje(data);
        }else{
            RFDriver.sendData(data);
        }
    }
    
    public String guardar(File Archivo, String documento) {
        String mensaje = null;
        try {
            salida = new FileOutputStream(Archivo);
            byte[] bytext = documento.getBytes();
            salida.write(bytext);
            mensaje = "Se guardo el proyecto";
        } catch (Exception e) {
        }
        return mensaje;
    }
    public void cargando(){
        this.manPanel.cargando(averiguarColorSeleccionado(), this.manArchivos);
    }
    
    public void limpiarPanel(){
        this.matrizPanel.setBackground(Color.BLACK);
        this.matrizPanel.setBackground(Color.WHITE);
        this.manPanel = new ManejadorDePanel(this, 50);    
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrirMapaButton;
    private javax.swing.JComboBox<String> availableConnectionsComboBox;
    private javax.swing.JRadioButton baseMovements;
    private javax.swing.JButton borrarMapajButton;
    private javax.swing.JPanel bottomBorder;
    private javax.swing.JComboBox<String> cambiarCuadriculajComboBox;
    private javax.swing.JButton cerrarSesionjButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextArea comandsTextArea;
    private javax.swing.JTextField commandsArea;
    private javax.swing.JTextField commandstxt;
    private javax.swing.JRadioButton complexMovements;
    private javax.swing.JButton connectButton;
    private javax.swing.JButton connectButton1;
    private javax.swing.JPanel connectionPanel;
    private javax.swing.JLabel coordenadasjLabel;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JButton disconnectButton1;
    private javax.swing.JLabel equivalenciajLabel;
    private javax.swing.ButtonGroup grupoDeBotones;
    private javax.swing.ButtonGroup grupoOpciones;
    private javax.swing.JButton guardarComojButton;
    private javax.swing.JButton guardarMapajButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel leftBorder;
    private javax.swing.JPanel leftCorner;
    private javax.swing.JRadioButton lisojRadioButton;
    private javax.swing.JPanel matrizPanel;
    private javax.swing.JTextArea messagesArea;
    private javax.swing.JButton nuevoMapajButton;
    private javax.swing.JRadioButton paredjRadioButton;
    private javax.swing.JPanel rightBoder;
    private javax.swing.JPanel rightCorner;
    private javax.swing.JRadioButton rugosojRadioButton;
    private javax.swing.JButton send;
    private javax.swing.JButton send1;
    private javax.swing.JRadioButton sinSuperficiejRadioButton;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JPanel topBorder;
    private javax.swing.JLabel userjLabel;
    // End of variables declaration//GEN-END:variables

    private void colocarUsuario() {
        if (idUsuario != null) {
            this.userjLabel.setText("Ingreso como:" + idUsuario);
            try {
                ManejadorDeSesiones.guardarSesion(idUsuario);
                idSesion = ManejadorDeSesiones.consultarUltimaSesion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            this.userjLabel.setText("NO SE HA INICIADO SESION");
        }
    }

    public void agregarGrupoDeBotones() {
        grupoDeBotones.add(paredjRadioButton);
        grupoDeBotones.add(sinSuperficiejRadioButton);
        grupoDeBotones.add(rugosojRadioButton);
        grupoDeBotones.add(lisojRadioButton);
    }

    private Color averiguarColorSeleccionado() {
        if (paredjRadioButton.isSelected()) {
            return ManejadorDePanel.COLOR_PARED;
        } else if (sinSuperficiejRadioButton.isSelected()) {
            return ManejadorDePanel.COLOR_SIN_SUPERFICIE;
        } else if (rugosojRadioButton.isSelected()) {
            return ManejadorDePanel.COLOR_RUGOSO;
        } else if (lisojRadioButton.isSelected()) {
            return ManejadorDePanel.COLOR_LISO;
        } else {
            return ManejadorDePanel.COLOR_SIN_SUPERFICIE;
        }
    }

    public void cambiarTextoDeCoordenadas(String texto) {
        this.coordenadasjLabel.setText(texto);
    }

    public void actualizarEquivalencia() {
        jLabel2.setText("Equivalencia para " + this.manPanel.getNumeroDeCuadros() + " cuadros:");
        DecimalFormat df = new DecimalFormat("#");
        this.equivalenciajLabel.setText(df.format(ManejadorMatriz.LONGITUD_REALCM / this.manPanel.getNumeroDeCuadros()) + " cm");
    }

    public ManejadorDePanel getManPanel() {
        return manPanel;
    }

    public void setManPanel(ManejadorDePanel manPanel) {
        this.manPanel = manPanel;
    }

    public JPanel getMatrizPanel() {
        return matrizPanel;
    }

    public Movil getMovil() {
        return movil;
    }

    public void setMovil(Movil movil) {
        this.movil = movil;
    }

    public static String getIdUsuario() {
        return idUsuario;
    }

    public static int getIdSesion() {
        return idSesion;
    }
    
}
