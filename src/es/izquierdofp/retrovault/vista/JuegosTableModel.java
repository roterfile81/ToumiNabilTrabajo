
package es.izquierdofp.retrovault.vista;

import es.izquierdofp.retrovault.modelo.Juego;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class JuegosTableModel extends AbstractTableModel {

    // Nombres de las columnas de la tabla
    private static final String[] COLS = {
        "#", "Título", "Consola", "Género",
        "Año", "Puntuación", "Estado"
    };

    private List<Juego> juegos;

    // Constructor
    public JuegosTableModel(List<Juego> juegos) {
        this.juegos = juegos;
    }

    // Reemplaza la lista y actualiza la tabla
    public void setJuegos(List<Juego> juegos) {
        this.juegos = juegos;
        fireTableDataChanged();
    }

    // Recupera un juego de una fila concreta
    public Juego getJuego(int fila) {
        return juegos.get(fila);
    }

    // Número de filas
    @Override
    public int getRowCount() {
        return juegos.size();
    }

    // Número de columnas
    @Override
    public int getColumnCount() {
        return COLS.length;
    }

    // Nombre de cada columna
    @Override
    public String getColumnName(int col) {
        return COLS[col];
    }

    // Impide editar directamente las celdas
    @Override
    public boolean isCellEditable(int r, int c) {
        return false;
    }

    // Obtiene el valor correspondiente a cada celda
    @Override
    public Object getValueAt(int row, int col) {

        Juego j = juegos.get(row);

        return switch (col) {

            // Número de fila
            case 0 -> row + 1;

            // Título del juego
            case 1 -> j.getTitulo();

            // Consola
            case 2 -> j.getConsola();

            // Género
            case 3 -> j.getGenero();

            // Año
            case 4 -> j.getAnio();

            // Puntuación representada con estrellas
            case 5 -> j.getPuntuacion() == 0
                    ? "—"
                    : "★".repeat(j.getPuntuacion())
                    + " (" + j.getPuntuacion() + "/5)";

            // Estado del juego
            case 6 -> j.getEstado();

            // Valor por defecto
            default -> "";
        };
    }
}
