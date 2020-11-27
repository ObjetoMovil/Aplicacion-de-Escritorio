/*
 * Clase para el Manejo del Panel en la Gui
 */
package gnz.frontend;

import gnz.backend.Matriz.ManejadorMatriz;
import gnz.backend.archivos.ManejadorDeArchivos;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import javax.swing.JPanel;

/**
 *
 * @author jesfrin
 */
public class ManejadorDePanel {

    //Colores disponibles
    public static Color COLOR_LISO = Color.GREEN;
    public static Color COLOR_RUGOSO = Color.DARK_GRAY;
    public static Color COLOR_SIN_SUPERFICIE = new Color(encontrarHexadecimal("EEEEEE"));
    public static Color COLOR_PARED = Color.BLACK;

    //Velocidades segun los colores
    public static int VELOCIDAD_LISO = 10;
    public static int VELOCIDAD_SIN_SUPERFICIE = 8;
    public static int VELOCIDAD_RUGOSO = 3;
    public static int VELOCIDAD_PARED = 0;

    private ManejadorMatriz manMatriz;
    private FrameOM frame;
    private int numeroDeCuadros;
    private Graphics2D g;

    public ManejadorDePanel(FrameOM frame, int numeroDeCuadros) {
        this.frame = frame;
        this.numeroDeCuadros = numeroDeCuadros;
        this.manMatriz = new ManejadorMatriz(numeroDeCuadros);

    }

    public void pintarCuadricula(Graphics g) {
        try{
            g.setColor(Color.GRAY);
            int longitudDeCuadro = ManejadorMatriz.LONGITUD_PANEL / numeroDeCuadros;
            for (int x = 0; x <= ManejadorMatriz.LONGITUD_PANEL; x += longitudDeCuadro) {
                g.drawLine(x, 0, x, ManejadorMatriz.ALTITUD_PANEL);
            }
            for (int y = 0; y <= ManejadorMatriz.ALTITUD_PANEL; y += longitudDeCuadro) {
                g.drawLine(0, y, ManejadorMatriz.LONGITUD_PANEL, y);
            }
        } catch(NullPointerException e){
            //DO NOTHING
        }
    }

    public void dibujarCuadriculaDeMatriz(ManejadorMatriz manMatriz, JPanel panel) {
        this.manMatriz = manMatriz;
        this.manMatriz.pintarCuadrosDeMatriz(g);
        this.numeroDeCuadros = this.manMatriz.getNumeroDeCuadros();
        pintarCuadricula(g);

    }

    public void accionParaClick(MouseEvent evt, Color color) {
        g = (Graphics2D) ((JPanel) evt.getSource()).getGraphics();
        this.manMatriz.pintarPared(evt.getX(), evt.getY(), g, color);
        System.out.println(evt.getX() + " " + evt.getY());
        pintarCuadricula(g);
        double n = (ManejadorMatriz.LONGITUD_REALCM + 0.0) / (ManejadorMatriz.LONGITUD_PANEL + 0.0);
        DecimalFormat df = new DecimalFormat("#");
        String texto = "Coordenada x:" + df.format((n * evt.getX())) + " Coordenada y:" + df.format(n * evt.getY());
        this.frame.cambiarTextoDeCoordenadas(texto);
    }

    public void accionParaMouseDragged(MouseEvent e, Color color) {
        g = (Graphics2D) ((JPanel) e.getSource()).getGraphics();
        this.manMatriz.pintarPared(e.getX(), e.getY(), g, color);
        System.out.println(e.getX() + " " + e.getY());
        double n = (ManejadorMatriz.LONGITUD_REALCM + 0.0) / (ManejadorMatriz.LONGITUD_PANEL + 0.0);
        DecimalFormat df = new DecimalFormat("#");
        String texto = "Coordenada x:" + df.format((n * e.getX())) + " Coordenada y:" + df.format(n * e.getY());
        this.frame.cambiarTextoDeCoordenadas(texto);
        pintarCuadricula(g);

    }
    
    public void cargando(Color color, ManejadorDeArchivos man){
        
        g = (Graphics2D)this.frame.getMatrizPanel().getGraphics();
        //this.manMatriz.pintarPared(0, 0, g, ManejadorDePanel.COLOR_SIN_SUPERFICIE); //color gris
        for (int i = 0; i < 8; i++) {
            
            try {
                switch (i) {
                    case 0:
                        man.abrirPalabraPorDefecto(this.frame.getMatrizPanel(),this.manMatriz ,"c1");
                    break;
                    case 1:
                        man.abrirPalabraPorDefecto(this.frame.getMatrizPanel(),this.manMatriz ,"c2");
                    break;
                    case 2:
                        man.abrirPalabraPorDefecto(this.frame.getMatrizPanel(),this.manMatriz ,"c3");
                    break;
                    case 3:
                        man.abrirPalabraPorDefecto(this.frame.getMatrizPanel(),this.manMatriz ,"c4");
                    break;
                    case 4:
                        man.abrirPalabraPorDefecto(this.frame.getMatrizPanel(),this.manMatriz ,"c5");
                    break;
                    case 5:
                        man.abrirPalabraPorDefecto(this.frame.getMatrizPanel(),this.manMatriz ,"c6");
                    break;
                    case 6:
                        man.abrirPalabraPorDefecto(this.frame.getMatrizPanel(),this.manMatriz ,"c7");
                    break;
                    case 7:
                        man.abrirPalabraPorDefecto(this.frame.getMatrizPanel(),this.manMatriz ,"c8");
                    break;
                    default:
                        throw new AssertionError();
                }
                
            } catch (Exception e) {   
            
            }
            this.frame.getMovil().delay(1000);
        }
        
        this.frame.limpiarPanel();     
    
    }
    
    private static int encontrarHexadecimal(String color){
        return Integer.parseInt(color, 16);
    }

    public int getNumeroDeCuadros() {
        return numeroDeCuadros;
    }

    public void setNumeroDeCuadros(int numeroDeCuadros) {
        this.numeroDeCuadros = numeroDeCuadros;
    }

    public ManejadorMatriz getManMatriz() {
        return manMatriz;
    }

    public void setManMatriz(ManejadorMatriz manMatriz) {
        this.manMatriz = manMatriz;
    }

    /*agregamos metodos get y set de Graphic2D*/
    public Graphics2D getG() {
        return g;
    }

    public void setG(Graphics2D g) {
        this.g = g;
    }

}
