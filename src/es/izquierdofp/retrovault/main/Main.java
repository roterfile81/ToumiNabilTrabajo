package es.izquierdofp.retrovault.main;
import com.formdev.flatlaf.FlatDarkLaf;
import es.izquierdofp.retrovault.datos.DatabaseManager;
import es.izquierdofp.retrovault.vista.VentanaPrincipal;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
public class Main {
public static void main(String[] args) {
// 1. Aplicar FlatLaf ANTES de crear ningún componente Swing
try {
UIManager.setLookAndFeel(new FlatDarkLaf());
} catch (Exception e) {
System.err.println("No se pudo cargar FlatLaf: " + e.getMessage());
}
// 2. Crear la tabla SQLite si todavía no existe
DatabaseManager.inicializar();
// 3. Abrir la ventana en el hilo de eventos de Swing
SwingUtilities.invokeLater(() -> {
new VentanaPrincipal().setVisible(true);
});
}
}