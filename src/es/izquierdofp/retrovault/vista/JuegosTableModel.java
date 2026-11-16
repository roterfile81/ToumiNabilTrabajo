package es.izquierdofp.retrovault.vista; 
import es.izquierdofp.retrovault.modelo.Juego; 
import java.util.List; 
import javax.swing.table.AbstractTableModel; 
public class JuegosTableModel extends AbstractTableModel { 
 // Nombres de columnas que mostrará la cabecera de la tabla 
 private static final String[] COLS = 
 { "#", "Título", "Consola", "Género", "Año", "Puntuación", "Estado" };  private List<Juego> juegos; 
 public JuegosTableModel(List<Juego> juegos) { 
 this.juegos = juegos; 
 } 
 /** Reemplaza la lista y avisa a la tabla para que se repinte. */ 
 public void setJuegos(List<Juego> juegos) { 
 this.juegos = juegos; 
 fireTableDataChanged(); // <-- Swing repinta la tabla 
 } 
 /** Permite recuperar el objeto Juego de una fila (útil en listeners). */  public Juego getJuego(int fila) { 
 return juegos.get(fila); 
 } 
 // Métodos obligatorios de AbstractTableModel: 
 @Override public int getRowCount() { return juegos.size(); } 
 @Override public int getColumnCount() { return COLS.length; } 
 @Override public String getColumnName(int col) { return COLS[col]; }  @Override public boolean isCellEditable(int r, int c) { return false; } 
 @Override 
 public Object getValueAt(int row, int col) { 
 Juego j = juegos.get(row); 
 // switch decide qué dato del Juego va en cada columna 
 return switch (col) { 
 case 0 -> row + 1; // número de fila  case 1 -> j.getTitulo(); 
 case 2 -> j.getConsola(); 
 case 3 -> j.getGenero(); 
 case 4 -> j.getAnio(); 
 // Si las no se renderizan en tu JDK/fuente, aparece al menos (n/5) ★  case 5 -> j.getPuntuacion() == 0 
 ? "—" 
 : " ".repeat(j.getPuntuacion()) + " (" + j.getPuntuacion() + "/5)"; ★  case 6 -> j.getEstado(); 
 default -> ""; 
 };
 } 
} 
