import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Conexion {

	private final String servidor = "jdbc:mysql://localhost/empleados";
	private final String user = "root";
	private final String pass = "";
	private final String driver = "com.mysql.jdbc.Driver";
	private Connection conexion;

	public Conexion(JFrame frame) {

		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(servidor, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(frame, "Fallo en la conexión. Inicia el servidor de la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public Connection getConnection() {
		return conexion;// Devuelvo el objeto Connection
	}
	
}
