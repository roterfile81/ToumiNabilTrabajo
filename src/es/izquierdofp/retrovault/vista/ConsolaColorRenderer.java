
package es.izquierdofp.retrovault.vista;

import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class ConsolaColorRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(
            JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {

        // Preparamos el componente usando el renderer padre
        JLabel label = (JLabel) super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);

        // Solo aplicamos nuestros colores si la fila no está seleccionada
        if (!isSelected) {

            // Convertimos la fila visual a la fila del modelo
            int modelRow = table.convertRowIndexToModel(row);

            // Obtenemos la consola de la columna 2
            Object val = table.getModel().getValueAt(modelRow, 2);

            String consola = val != null ? val.toString() : "";

            // Colores de fondo según la consola
            Color bg = switch (consola) {

                // Rojo oscuro
                case "NES" -> new Color(70, 20, 20);

                // Morado oscuro
                case "SNES" -> new Color(45, 20, 65);

                // Azul oscuro
                case "Mega Drive" -> new Color(20, 30, 75);

                // Verde oscuro
                case "Game Boy" -> new Color(20, 55, 30);

                // Azul marino
                case "PlayStation" -> new Color(15, 40, 70);

                // Morado medio
                case "Nintendo 64" -> new Color(55, 20, 55);

                // Naranja oscuro
                case "Game Gear" -> new Color(65, 35, 10);

                // Dorado oscuro
                case "Arcade" -> new Color(60, 50, 10);

                // Gris oscuro para otras consolas
                default -> new Color(35, 35, 35);
            };

            // Aplicamos los colores
            label.setBackground(bg);
            label.setForeground(Color.WHITE);
        }

        return label;
    }
}
