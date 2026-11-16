
package es.izquierdofp.retrovault.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    // URL de conexión SQLite
    // El archivo se crea en el directorio de trabajo de la aplicación.
    private static final String DB_URL = "jdbc:sqlite:retrovault.db";

    /**
     * Devuelve una nueva conexión a la BD.
     * El caller es responsable de cerrarla.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    /**
     * Crea la tabla "juegos" si todavía no existe.
     * Se llama una sola vez al arrancar la aplicación.
     */
    public static void inicializar() {

        String sql = """
                CREATE TABLE IF NOT EXISTS juegos (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    titulo TEXT NOT NULL,
                    consola TEXT NOT NULL,
                    genero TEXT NOT NULL,
                    anio INTEGER NOT NULL,
                    puntuacion INTEGER NOT NULL DEFAULT 0,
                    estado TEXT NOT NULL DEFAULT 'Pendiente'
                )
                """;

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);

        } catch (SQLException e) {
            System.err.println("Error al inicializar BD: " + e.getMessage());
        }
    }
}
