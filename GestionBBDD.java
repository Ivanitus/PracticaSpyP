import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GestionBBDD {

	protected boolean insertarPlanta(Planta p, JFrame frame) { // b

		boolean insertado = false;

		int filas;

		String sql = "INSERT INTO planta VALUES ( ?, ? )";

		try {

			Conexion conexion = new Conexion(frame);
			Connection con = conexion.getConnection();

			try {

				PreparedStatement sentencia = con.prepareStatement(sql);

				sentencia.setInt(1, p.getNumeroPlanta());
				sentencia.setString(2, p.getNombrePlanta());

				filas = sentencia.executeUpdate();

				if (filas > 0) {
					insertado = true;
				} else {
					insertado = false;
				}

				sentencia.close();

			} catch (SQLException e) {

				String error = "Ha ocurrido una excepción:";
				error += "\n\tMensaje: " + e.getMessage();
				error += "\n\tEstado SQL: " + e.getSQLState();
				error += "\n\tCódigo error: " + e.getErrorCode();

				JOptionPane.showMessageDialog(frame, error, "Error", JOptionPane.ERROR_MESSAGE);

			} catch (NullPointerException e) {

			}

			con.close();

		} catch (SQLException e) {

		} catch (NullPointerException e) {

		}

		return insertado;

	}

	protected Planta devolver(int numPlanta, JFrame frame) { // c

		Planta p = new Planta();

		String sql = "SELECT * FROM PLANTA WHERE numero=?";

		try {

			Conexion conexion = new Conexion(frame);
			Connection con = conexion.getConnection();

			try {

				PreparedStatement sentencia = con.prepareStatement(sql);
				sentencia.setInt(1, numPlanta);

				ResultSet rs = sentencia.executeQuery();

				if (rs.next()) {

					p.setNumeroPlanta(rs.getInt(1));
					p.setNombrePlanta(rs.getString(2));

				}

				rs.close();
				sentencia.close();

			} catch (SQLException e) {

				String error = "Ha ocurrido una excepción:";
				error += "\n\tMensaje: " + e.getMessage();
				error += "\n\tEstado SQL: " + e.getSQLState();
				error += "\n\tCódigo error: " + e.getErrorCode();

				JOptionPane.showMessageDialog(frame, error, "Error", JOptionPane.ERROR_MESSAGE);

			} catch (NullPointerException e) {

			}

			con.close();

		} catch (SQLException e) {

			String error = "Ha ocurrido una excepción:";
			error += "\n\tMensaje: " + e.getMessage();
			error += "\n\tEstado SQL: " + e.getSQLState();
			error += "\n\tCódigo error: " + e.getErrorCode();

			JOptionPane.showMessageDialog(frame, error, "Error", JOptionPane.ERROR_MESSAGE);

		} catch (NullPointerException e) {

		}

		return p;

	}

	protected int eliminarPlanta(int numPlanta, JFrame frame) { // d

		int filas = 0;

		String sql = "DELETE FROM planta WHERE numero=?";

		try {

			Conexion conexion = new Conexion(frame);
			Connection con = conexion.getConnection();

			try {

				PreparedStatement sentencia = con.prepareStatement(sql);

				sentencia.setInt(1, numPlanta);

				filas = sentencia.executeUpdate();

				sentencia.close();

			} catch (SQLException e) {

				String error = "Ha ocurrido una excepción:";
				error += "\n\tMensaje: " + e.getMessage();
				error += "\n\tEstado SQL: " + e.getSQLState();
				error += "\n\tCódigo error: " + e.getErrorCode();

				JOptionPane.showMessageDialog(frame, error, "Error", JOptionPane.ERROR_MESSAGE);

			} catch (NullPointerException e) {

			}

			con.close();

		} catch (SQLException e) {

			String error = "Ha ocurrido una excepción:";
			error += "\n\tMensaje: " + e.getMessage();
			error += "\n\tEstado SQL: " + e.getSQLState();
			error += "\n\tCódigo error: " + e.getErrorCode();

			JOptionPane.showMessageDialog(frame, error, "Error", JOptionPane.ERROR_MESSAGE);

		} catch (NullPointerException e) {

		}

		return filas;

	}

	protected boolean modificarNombrePlanta(Planta p, JFrame frame) { // e

		boolean modificado = false;

		String sql = "{ call  modificarNombrePlanta (?, ?) }";

		try {

			Conexion conexion = new Conexion(frame);
			Connection con = conexion.getConnection();

			CallableStatement llamada = con.prepareCall(sql);

			llamada.setInt(1, p.getNumeroPlanta());
			llamada.setString(2, p.getNombrePlanta());

			llamada.executeUpdate();

			modificado = true;

			llamada.close();
			con.close();

		} catch (SQLException e) {

			String error = "Ha ocurrido una excepción:";
			error += "\n\tMensaje: " + e.getMessage();
			error += "\n\tEstado SQL: " + e.getSQLState();
			error += "\n\tCódigo error: " + e.getErrorCode();

			JOptionPane.showMessageDialog(frame, error, "Error", JOptionPane.ERROR_MESSAGE);

		} catch (NullPointerException e) {

		}

		return modificado;

	}

	protected boolean modificarSalario(int numPlanta, int subida, JFrame frame) { // f

		boolean modificado = false;

		String sql = "{ call  subir_sal (?, ?) }";

		try {

			Conexion conexion = new Conexion(frame);
			Connection con = conexion.getConnection();

			CallableStatement llamada = con.prepareCall(sql);

			llamada.setInt(1, numPlanta);
			llamada.setInt(2, subida);

			llamada.executeUpdate();

			modificado = true;

			llamada.close();
			con.close();

		} catch (SQLException e) {

			String error = "Ha ocurrido una excepción:";
			error += "\n\tMensaje: " + e.getMessage();
			error += "\n\tEstado SQL: " + e.getSQLState();
			error += "\n\tCódigo error: " + e.getErrorCode();

			JOptionPane.showMessageDialog(frame, error, "Error", JOptionPane.ERROR_MESSAGE);

		} catch (NullPointerException e) {

		}

		return modificado;

	}

	protected String imprimirInformacionTabla(String tabla, JFrame frame) { // g

		Conexion conexion = new Conexion(frame);
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;

		String infoTabla = "";

		String sql = "SELECT * FROM " + tabla;

		try {

			st = con.createStatement();
			rs = st.executeQuery(sql);
			ResultSetMetaData rsmd;

			rsmd = rs.getMetaData();
			int nColumnas = rsmd.getColumnCount();
			infoTabla = "Numero de columnas recuperadas: " + nColumnas;

			for (int i = 1; i <= nColumnas; i++) {

				infoTabla += "\nColumna: " + rsmd.getColumnName(i);
				infoTabla += "\nTipo: " + rsmd.getColumnTypeName(i);
				infoTabla += "\nTamaño: " + rsmd.getColumnDisplaySize(i);

			}
		} catch (SQLException e) {

			String error = "Ha ocurrido una excepción:";
			error += "\n\tMensaje: " + e.getMessage();
			error += "\n\tEstado SQL: " + e.getSQLState();
			error += "\n\tCódigo error: " + e.getErrorCode();

			JOptionPane.showMessageDialog(frame, error, "Error", JOptionPane.ERROR_MESSAGE);

		} catch (NullPointerException e) {

		}

		return infoTabla;

	}

	protected ArrayList<Integer> consultarNumerosPlantas(JFrame frame) {

		ArrayList<Integer> listaPlantas = new ArrayList<Integer>();

		String sql = "SELECT numero FROM planta";

		int numPlanta;

		try {

			Conexion conexion = new Conexion(frame);
			Connection con = conexion.getConnection();
			Statement st;
			ResultSet rs;

			try {

				st = con.createStatement();

				rs = st.executeQuery(sql);

				while (rs.next()) {

					numPlanta = rs.getInt(1);

					listaPlantas.add(numPlanta);

				}

				rs.close();
				st.close();

			} catch (SQLException e) {

				String error = "Ha ocurrido una excepción:";
				error += "\n\tMensaje: " + e.getMessage();
				error += "\n\tEstado SQL: " + e.getSQLState();
				error += "\n\tCódigo error: " + e.getErrorCode();

				JOptionPane.showMessageDialog(frame, error, "Error", JOptionPane.ERROR_MESSAGE);

			} catch (NullPointerException e) {

			}

			con.close();

		} catch (SQLException e) {

			String error = "Ha ocurrido una excepción:";
			error += "\n\tMensaje: " + e.getMessage();
			error += "\n\tEstado SQL: " + e.getSQLState();
			error += "\n\tCódigo error: " + e.getErrorCode();

			JOptionPane.showMessageDialog(frame, error, "Error", JOptionPane.ERROR_MESSAGE);

		} catch (NullPointerException e) {

		}

		return listaPlantas;

	}

	protected ArrayList<Planta> consultarTodasLasPlantas(JFrame frame) {

		ArrayList<Planta> listaPlantas = new ArrayList<Planta>();

		String sql = "SELECT * FROM planta ORDER BY numero ASC";

		int numPlanta;
		String nombrePlanta;

		try {

			Conexion conexion = new Conexion(frame);
			Connection con = conexion.getConnection();
			Statement st;
			ResultSet rs;

			try {

				st = con.createStatement();

				rs = st.executeQuery(sql);

				while (rs.next()) {

					numPlanta = rs.getInt(1);
					nombrePlanta = rs.getString(2);

					Planta p = new Planta(numPlanta, nombrePlanta);

					listaPlantas.add(p);

				}

				rs.close();
				st.close();

			} catch (SQLException e) {

				String error = "Ha ocurrido una excepción:";
				error += "\n\tMensaje: " + e.getMessage();
				error += "\n\tEstado SQL: " + e.getSQLState();
				error += "\n\tCódigo error: " + e.getErrorCode();

				JOptionPane.showMessageDialog(frame, error, "Error", JOptionPane.ERROR_MESSAGE);

			} catch (NullPointerException e) {

			}

			con.close();

		} catch (SQLException e) {

			String error = "Ha ocurrido una excepción:";
			error += "\n\tMensaje: " + e.getMessage();
			error += "\n\tEstado SQL: " + e.getSQLState();
			error += "\n\tCódigo error: " + e.getErrorCode();

			JOptionPane.showMessageDialog(frame, error, "Error", JOptionPane.ERROR_MESSAGE);

		} catch (NullPointerException e) {

		}

		return listaPlantas;

	}

	protected boolean insertarEmpleado(Personal p, JFrame frame) {

		boolean insertado = false;

		String sql = "INSERT INTO personal VALUES ( ?, ?, ?, ?, ? )";

		int filas;

		try {

			Conexion conexion = new Conexion(frame);
			Connection con = conexion.getConnection();

			try {

				PreparedStatement sentencia = con.prepareStatement(sql);

				sentencia.setInt(1, p.getNumero());
				sentencia.setString(2, p.getNombre());
				sentencia.setString(3, p.getApellidos());
				sentencia.setInt(4, p.getSueldo());
				sentencia.setInt(5, p.getNumPlanta());

				filas = sentencia.executeUpdate();

				if (filas > 0) {
					insertado = true;
				} else {
					insertado = false;
				}

				sentencia.close();

			} catch (SQLException e) {

				String error = "Ha ocurrido una excepción:";
				error += "\n\tMensaje: " + e.getMessage();
				error += "\n\tEstado SQL: " + e.getSQLState();
				error += "\n\tCódigo error: " + e.getErrorCode();

				JOptionPane.showMessageDialog(frame, error, "Error", JOptionPane.ERROR_MESSAGE);

			} catch (NullPointerException e) {

			}

			con.close();

		} catch (SQLException e) {

			String error = "Ha ocurrido una excepción:";
			error += "\n\tMensaje: " + e.getMessage();
			error += "\n\tEstado SQL: " + e.getSQLState();
			error += "\n\tCódigo error: " + e.getErrorCode();

			JOptionPane.showMessageDialog(frame, error, "Error", JOptionPane.ERROR_MESSAGE);

		} catch (NullPointerException e) {

		}

		return insertado;

	}

	protected boolean eliminarEmpleado(int numeroEmpleado, JFrame frame) {

		boolean eliminado = false;

		int filas = 0;

		String sql = "DELETE FROM personal WHERE numero=?";

		try {

			Conexion conexion = new Conexion(frame);
			Connection con = conexion.getConnection();

			try {

				PreparedStatement sentencia = con.prepareStatement(sql);

				sentencia.setInt(1, numeroEmpleado);

				filas = sentencia.executeUpdate();

				if (filas > 0) {

					eliminado = true;

				} else {

					eliminado = false;

				}

				sentencia.close();

			} catch (SQLException e) {

				String error = "Ha ocurrido una excepción:";
				error += "\n\tMensaje: " + e.getMessage();
				error += "\n\tEstado SQL: " + e.getSQLState();
				error += "\n\tCódigo error: " + e.getErrorCode();

				JOptionPane.showMessageDialog(frame, error, "Error", JOptionPane.ERROR_MESSAGE);

			} catch (NullPointerException e) {

			}

			con.close();

		} catch (SQLException e) {

			String error = "Ha ocurrido una excepción:";
			error += "\n\tMensaje: " + e.getMessage();
			error += "\n\tEstado SQL: " + e.getSQLState();
			error += "\n\tCódigo error: " + e.getErrorCode();

			JOptionPane.showMessageDialog(frame, error, "Error", JOptionPane.ERROR_MESSAGE);

		} catch (NullPointerException e) {

		}

		return eliminado;

	}

	protected ArrayList<PersonalPlanta> mostrarEmpleadosPlantas(JFrame frame) {

		ArrayList<PersonalPlanta> listaPersonalPlanta = new ArrayList<PersonalPlanta>();

		String sql = "SELECT * from personal inner join planta on personal.num_planta=planta.numero ORDER BY personal.numero ASC";

		int numeroPersonal;
		String nombrePersonal;
		String apellidosPersonal;
		int sueldoPersonal;
		int numPlantaPersonal;
		int numeroPlanta;
		String nombrePlanta;

		try {

			Conexion conexion = new Conexion(frame);
			Connection con = conexion.getConnection();
			Statement st;
			ResultSet rs;

			try {

				st = con.createStatement();

				rs = st.executeQuery(sql);

				while (rs.next()) {

					numeroPersonal = rs.getInt(1);
					nombrePersonal = rs.getString(2);
					apellidosPersonal = rs.getString(3);
					sueldoPersonal = rs.getInt(4);
					numPlantaPersonal = rs.getInt(5);
					numeroPlanta = rs.getInt(6);
					nombrePlanta = rs.getString(7);

					Personal personal = new Personal(numeroPersonal, nombrePersonal, apellidosPersonal, sueldoPersonal);

					Planta planta = new Planta(numeroPlanta, nombrePlanta);

					PersonalPlanta pp = new PersonalPlanta(personal, planta);

					listaPersonalPlanta.add(pp);

				}

				rs.close();
				st.close();

			} catch (SQLException e) {

				String error = "Ha ocurrido una excepción:";
				error += "\n\tMensaje: " + e.getMessage();
				error += "\n\tEstado SQL: " + e.getSQLState();
				error += "\n\tCódigo error: " + e.getErrorCode();

				JOptionPane.showMessageDialog(frame, error, "Error", JOptionPane.ERROR_MESSAGE);

			} catch (NullPointerException e) {

			}

			con.close();

		} catch (SQLException e) {

			String error = "Ha ocurrido una excepción:";
			error += "\n\tMensaje: " + e.getMessage();
			error += "\n\tEstado SQL: " + e.getSQLState();
			error += "\n\tCódigo error: " + e.getErrorCode();

			JOptionPane.showMessageDialog(frame, error, "Error", JOptionPane.ERROR_MESSAGE);

		} catch (NullPointerException e) {

		}

		return listaPersonalPlanta;

	}

	protected ArrayList<PersonalPlanta> mostrarEmpleadosUnaPlanta(int numPlanta, JFrame frame) {

		ArrayList<PersonalPlanta> listaPersonalPlanta = new ArrayList<PersonalPlanta>();

		String sql = "SELECT * from personal inner join planta on personal.num_planta=planta.numero WHERE num_planta="
				+ numPlanta + " ORDER BY personal.numero ASC";

		int numeroPersonal;
		String nombrePersonal;
		String apellidosPersonal;
		int sueldoPersonal;
		int numPlantaPersonal;
		int numeroPlanta;
		String nombrePlanta;

		try {

			Conexion conexion = new Conexion(frame);
			Connection con = conexion.getConnection();
			Statement st;
			ResultSet rs;

			try {

				st = con.createStatement();

				rs = st.executeQuery(sql);

				while (rs.next()) {

					numeroPersonal = rs.getInt(1);
					nombrePersonal = rs.getString(2);
					apellidosPersonal = rs.getString(3);
					sueldoPersonal = rs.getInt(4);
					numPlantaPersonal = rs.getInt(5);
					numeroPlanta = rs.getInt(6);
					nombrePlanta = rs.getString(7);

					Personal personal = new Personal(numeroPersonal, nombrePersonal, apellidosPersonal, sueldoPersonal);

					Planta planta = new Planta(numeroPlanta, nombrePlanta);

					PersonalPlanta pp = new PersonalPlanta(personal, planta);

					listaPersonalPlanta.add(pp);

				}

				rs.close();
				st.close();

			} catch (SQLException e) {

				String error = "Ha ocurrido una excepción:";
				error += "\n\tMensaje: " + e.getMessage();
				error += "\n\tEstado SQL: " + e.getSQLState();
				error += "\n\tCódigo error: " + e.getErrorCode();

				JOptionPane.showMessageDialog(frame, error, "Error", JOptionPane.ERROR_MESSAGE);

			} catch (NullPointerException e) {

			}

			con.close();

		} catch (SQLException e) {

			String error = "Ha ocurrido una excepción:";
			error += "\n\tMensaje: " + e.getMessage();
			error += "\n\tEstado SQL: " + e.getSQLState();
			error += "\n\tCódigo error: " + e.getErrorCode();

			JOptionPane.showMessageDialog(frame, error, "Error", JOptionPane.ERROR_MESSAGE);

		} catch (NullPointerException e) {

		}

		return listaPersonalPlanta;

	}

}
