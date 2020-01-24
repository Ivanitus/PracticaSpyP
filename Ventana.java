import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.placeholder.PlaceHolder;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ventana {

	private GestionBBDD gesBBDD = new GestionBBDD();
	private JFrame frame;
	private JPanel menuPersonal;
	private JPanel menuPlantas;
	private JPanel menuInicial;
	private JPanel datosPersonal;
	private JPanel datosPlantas;
	private JPanel formularioVacio;
	private JButton botonConfirmarPersonal;
	private JButton botonConfirmarPlantas;
	private JTextField textFieldNumPlanta = new JTextField();
	private JTextField textFieldNombrePlanta = new JTextField();
	private JTextField textFieldNumEmpleado = new JTextField();
	private JTextField textFieldNombreEmpleado = new JTextField();
	private JTextField textFieldApellidos = new JTextField();
	private JTextField textFieldSueldo = new JTextField();
	private JComboBox comboBoxNumPlantasEmpleados;
	private JTable tabla;
	private DefaultTableModel modelo;
	private String[] cabeceraVacia = { "" };

	protected void ejecucion() {

		Color colorFondo = new Color(44, 44, 44);
		Color colorPlaceHolder = new Color(189, 189, 189);

		Font fuente = new Font("Arial", Font.PLAIN, 18);
		Font fuenteTabla = new Font("Arial", Font.PLAIN, 17);

		frame = new JFrame("Gestión Ivan Camps: Inicio");
		frame.addWindowListener(new EscuchadorVentana());
		frame.setSize(1303, 600);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		menuPersonal = new JPanel();
		menuPersonal.setBounds(0, 0, 1297, 130);
		menuPersonal.setBackground(colorFondo);
		frame.getContentPane().add(menuPersonal);
		menuPersonal.setLayout(new GridLayout(0, 5, 0, -50));

		menuPersonal.add(new JLabel());
		menuPersonal.add(new JLabel());
		menuPersonal.add(new JLabel());
		menuPersonal.add(new JLabel());
		menuPersonal.add(new JLabel());

		JButton botonAtrasPersonal = new JButton();
		botonAtrasPersonal.setIcon(new ImageIcon("atras.png"));
		botonAtrasPersonal.setContentAreaFilled(false);
		botonAtrasPersonal.setBorderPainted(false);
		botonAtrasPersonal.setFocusable(false);
		botonAtrasPersonal.setActionCommand("atras personal");
		botonAtrasPersonal.addActionListener(new EscuchadorBotones());
		menuPersonal.add(botonAtrasPersonal);

		JButton botonInsertarPersonal = new JButton();
		botonInsertarPersonal.setIcon(new ImageIcon("insertarpersonal.png"));
		botonInsertarPersonal.setContentAreaFilled(false);
		botonInsertarPersonal.setBorderPainted(false);
		botonInsertarPersonal.setFocusable(false);
		botonInsertarPersonal.setActionCommand("insertar personal");
		botonInsertarPersonal.addActionListener(new EscuchadorBotones());
		menuPersonal.add(botonInsertarPersonal);

		JButton botonEliminarEmpleado = new JButton();
		botonEliminarEmpleado.setIcon(new ImageIcon("eliminarpersonal.png"));
		botonEliminarEmpleado.setContentAreaFilled(false);
		botonEliminarEmpleado.setBorderPainted(false);
		botonEliminarEmpleado.setFocusable(false);
		botonEliminarEmpleado.setActionCommand("eliminar personal");
		botonEliminarEmpleado.addActionListener(new EscuchadorBotones());
		menuPersonal.add(botonEliminarEmpleado);

		JButton botonModificarSalario = new JButton();
		botonModificarSalario.setIcon(new ImageIcon("aumentarsalario.png"));
		botonModificarSalario.setFocusable(false);
		botonModificarSalario.setContentAreaFilled(false);
		botonModificarSalario.setBorderPainted(false);
		botonModificarSalario.setActionCommand("modificar salario");
		botonModificarSalario.addActionListener(new EscuchadorBotones());
		menuPersonal.add(botonModificarSalario);

		JButton botonMostrarEmpleadosPlantas = new JButton();
		botonMostrarEmpleadosPlantas.setIcon(new ImageIcon("mostrarempleados.png"));
		botonMostrarEmpleadosPlantas.setContentAreaFilled(false);
		botonMostrarEmpleadosPlantas.setBorderPainted(false);
		botonMostrarEmpleadosPlantas.setFocusable(false);
		botonMostrarEmpleadosPlantas.setActionCommand("mostrar personal");
		botonMostrarEmpleadosPlantas.addActionListener(new EscuchadorBotones());
		menuPersonal.add(botonMostrarEmpleadosPlantas);

		menuPersonal.add(new JLabel());
		menuPersonal.add(new JLabel());
		menuPersonal.add(new JLabel());
		menuPersonal.add(new JLabel());
		menuPersonal.add(new JLabel());

		menuPersonal.setVisible(false);

		menuPlantas = new JPanel();
		menuPlantas.setBounds(0, 0, 1297, 130);
		frame.getContentPane().add(menuPlantas);
		menuPlantas.setBackground(colorFondo);
		menuPlantas.setLayout(new GridLayout(0, 5, 0, -50));

		menuPlantas.add(new JLabel());
		menuPlantas.add(new JLabel());
		menuPlantas.add(new JLabel());
		menuPlantas.add(new JLabel());
		menuPlantas.add(new JLabel());

		JButton botonAtrasPlanta = new JButton();
		botonAtrasPlanta.setIcon(new ImageIcon("atras.png"));
		botonAtrasPlanta.setContentAreaFilled(false);
		botonAtrasPlanta.setBorderPainted(false);
		botonAtrasPlanta.setFocusable(false);
		botonAtrasPlanta.setActionCommand("atras plantas");
		botonAtrasPlanta.addActionListener(new EscuchadorBotones());
		menuPlantas.add(botonAtrasPlanta);

		JButton botonInsertarPlanta = new JButton();
		botonInsertarPlanta.setIcon(new ImageIcon("insertarplanta.png"));
		botonInsertarPlanta.setContentAreaFilled(false);
		botonInsertarPlanta.setBorderPainted(false);
		botonInsertarPlanta.setFocusable(false);
		botonInsertarPlanta.setActionCommand("insertar planta");
		botonInsertarPlanta.addActionListener(new EscuchadorBotones());
		menuPlantas.add(botonInsertarPlanta);

		JButton botonDevolverPlanta = new JButton();
		botonDevolverPlanta.setIcon(new ImageIcon("buscarplanta.png"));
		botonDevolverPlanta.setContentAreaFilled(false);
		botonDevolverPlanta.setBorderPainted(false);
		botonDevolverPlanta.setFocusable(false);
		botonDevolverPlanta.setActionCommand("devolver planta");
		botonDevolverPlanta.addActionListener(new EscuchadorBotones());
		menuPlantas.add(botonDevolverPlanta);

		JButton botonEliminarPlanta = new JButton();
		botonEliminarPlanta.setIcon(new ImageIcon("eliminarplanta.png"));
		botonEliminarPlanta.setContentAreaFilled(false);
		botonEliminarPlanta.setBorderPainted(false);
		botonEliminarPlanta.setFocusable(false);
		botonEliminarPlanta.setActionCommand("eliminar planta");
		botonEliminarPlanta.addActionListener(new EscuchadorBotones());
		menuPlantas.add(botonEliminarPlanta);

		JButton botonModificarNombrePlanta = new JButton();
		botonModificarNombrePlanta.setIcon(new ImageIcon("editarplanta.png"));
		botonModificarNombrePlanta.setContentAreaFilled(false);
		botonModificarNombrePlanta.setBorderPainted(false);
		botonModificarNombrePlanta.setFocusable(false);
		botonModificarNombrePlanta.setActionCommand("modificar planta");
		botonModificarNombrePlanta.addActionListener(new EscuchadorBotones());
		menuPlantas.add(botonModificarNombrePlanta);

		menuPlantas.add(new JLabel());
		menuPlantas.add(new JLabel());
		menuPlantas.add(new JLabel());
		menuPlantas.add(new JLabel());
		menuPlantas.add(new JLabel());

		menuPlantas.setVisible(false);

		menuInicial = new JPanel();

		menuInicial.setBounds(0, 0, 1297, 130);
		frame.getContentPane().add(menuInicial);
		menuInicial.setLayout(new GridLayout(0, 4, 0, -50));
		menuInicial.setBackground(colorFondo);

		menuInicial.add(new JLabel());
		menuInicial.add(new JLabel());
		menuInicial.add(new JLabel());
		menuInicial.add(new JLabel());

		JButton botonPlantas = new JButton();
		botonPlantas.setIcon(new ImageIcon("gestionplantas.png"));
		botonPlantas.setContentAreaFilled(false);
		botonPlantas.setBorderPainted(false);
		botonPlantas.setFocusable(false);
		botonPlantas.setActionCommand("gestion plantas");
		botonPlantas.addActionListener(new EscuchadorBotones());
		menuInicial.add(botonPlantas);

		JButton botonPersonal = new JButton();
		botonPersonal.setIcon(new ImageIcon("gestionpersonal.png"));
		botonPersonal.setContentAreaFilled(false);
		botonPersonal.setBorderPainted(false);
		botonPersonal.setFocusable(false);
		botonPersonal.setActionCommand("gestion personal");
		botonPersonal.addActionListener(new EscuchadorBotones());
		menuInicial.add(botonPersonal);

		JButton botonInformacionTabla = new JButton();
		botonInformacionTabla.setIcon(new ImageIcon("metadatostablas.png"));
		botonInformacionTabla.setContentAreaFilled(false);
		botonInformacionTabla.setBorderPainted(false);
		botonInformacionTabla.setFocusable(false);
		botonInformacionTabla.setActionCommand("informacion tabla");
		botonInformacionTabla.addActionListener(new EscuchadorBotones());
		menuInicial.add(botonInformacionTabla);

		JButton botonAyuda = new JButton();
		botonAyuda.setIcon(new ImageIcon("ayuda.png"));
		botonAyuda.setContentAreaFilled(false);
		botonAyuda.setBorderPainted(false);
		botonAyuda.setFocusable(false);
		botonAyuda.setActionCommand("ayuda");
		botonAyuda.addActionListener(new EscuchadorBotones());
		menuInicial.add(botonAyuda);

		menuInicial.add(new JLabel());
		menuInicial.add(new JLabel());
		menuInicial.add(new JLabel());
		menuInicial.add(new JLabel());

		datosPersonal = new JPanel();
		datosPersonal.setBounds(900, 130, 397, 435);
		datosPersonal.setBackground(colorFondo);
		frame.getContentPane().add(datosPersonal);
		datosPersonal.setLayout(new GridLayout(11, 3, -105, -20));

		datosPersonal.add(new JLabel());
		datosPersonal.add(textFieldNumEmpleado);
		datosPersonal.add(new JLabel());

		datosPersonal.add(new JLabel());
		datosPersonal.add(new JLabel());
		datosPersonal.add(new JLabel());

		datosPersonal.add(new JLabel());
		datosPersonal.add(textFieldNombreEmpleado);
		datosPersonal.add(new JLabel());

		datosPersonal.add(new JLabel());
		datosPersonal.add(new JLabel());
		datosPersonal.add(new JLabel());

		datosPersonal.add(new JLabel());
		datosPersonal.add(textFieldApellidos);
		datosPersonal.add(new JLabel());

		datosPersonal.add(new JLabel());
		datosPersonal.add(new JLabel());
		datosPersonal.add(new JLabel());

		datosPersonal.add(new JLabel());
		datosPersonal.add(textFieldSueldo);
		datosPersonal.add(new JLabel());

		datosPersonal.add(new JLabel());
		datosPersonal.add(new JLabel());
		datosPersonal.add(new JLabel());

		datosPersonal.add(new JLabel());
		ArrayList<Integer> listaNumPlantasEmpleados = new ArrayList<Integer>();

		listaNumPlantasEmpleados = gesBBDD.consultarNumerosPlantas(frame);

		comboBoxNumPlantasEmpleados = new JComboBox(listaNumPlantasEmpleados.toArray());
		datosPersonal.add(comboBoxNumPlantasEmpleados);
		datosPersonal.add(new JLabel());

		datosPersonal.add(new JLabel());
		datosPersonal.add(new JLabel());
		datosPersonal.add(new JLabel());

		datosPersonal.add(new JLabel());
		botonConfirmarPersonal = new JButton();
		botonConfirmarPersonal.setIcon(new ImageIcon("confirmar.png"));
		botonConfirmarPersonal.setContentAreaFilled(false);
		botonConfirmarPersonal.setBorderPainted(false);
		botonConfirmarPersonal.setFocusable(false);
		botonConfirmarPersonal.addActionListener(new EscuchadorBotones());
		datosPersonal.add(botonConfirmarPersonal);
		datosPersonal.add(new JLabel());

		textFieldNumEmpleado.setFont(fuente);
		textFieldNumEmpleado.setToolTipText("Introduce el numero del empleado");
		PlaceHolder holderNumEmpleado = new PlaceHolder(textFieldNumEmpleado, colorPlaceHolder, Color.black,
				"Introduce num empleado", false, "Arial", 18);
		textFieldNombreEmpleado.setFont(fuente);
		textFieldNombreEmpleado.setToolTipText("Introduce el nombre del empleado");
		PlaceHolder holderNombreEmpleado = new PlaceHolder(textFieldNombreEmpleado, colorPlaceHolder, Color.black,
				"Introduce nombre", false, "Arial", 18);
		textFieldNombreEmpleado.addKeyListener(new EscuchadorTextFields());
		textFieldApellidos.setFont(fuente);
		textFieldApellidos.setToolTipText("Introduce los apellidos del empleado");
		PlaceHolder holderApellidos = new PlaceHolder(textFieldApellidos, colorPlaceHolder, Color.black,
				"Introduce apellidos", false, "Arial", 18);
		textFieldApellidos.addKeyListener(new EscuchadorTextFields());
		textFieldSueldo.setFont(fuente);
		textFieldSueldo.setToolTipText("Introduce el sueldo del empleado");
		PlaceHolder holderSueldo = new PlaceHolder(textFieldSueldo, colorPlaceHolder, Color.black, "Introduce sueldo",
				false, "Arial", 18);
		comboBoxNumPlantasEmpleados.setFont(fuente);
		comboBoxNumPlantasEmpleados.setToolTipText("Selecciona la planta del empleado");

		datosPersonal.setVisible(false);

		datosPlantas = new JPanel();
		datosPlantas.setBounds(900, 130, 397, 435);
		datosPlantas.setBackground(colorFondo);
		frame.getContentPane().add(datosPlantas);
		datosPlantas.setLayout(new GridLayout(7, 3, -105, 0));

		datosPlantas.add(new JLabel());
		datosPlantas.add(new JLabel());
		datosPlantas.add(new JLabel());

		datosPlantas.add(new JLabel());
		datosPlantas.add(textFieldNumPlanta);
		datosPlantas.add(new JLabel());

		datosPlantas.add(new JLabel());
		datosPlantas.add(new JLabel());
		datosPlantas.add(new JLabel());

		datosPlantas.add(new JLabel());
		datosPlantas.add(textFieldNombrePlanta);
		datosPlantas.add(new JLabel());

		datosPlantas.add(new JLabel());
		datosPlantas.add(new JLabel());
		datosPlantas.add(new JLabel());

		datosPlantas.add(new JLabel());
		botonConfirmarPlantas = new JButton();
		botonConfirmarPlantas.setIcon(new ImageIcon("confirmar.png"));
		botonConfirmarPlantas.setContentAreaFilled(false);
		botonConfirmarPlantas.setBorderPainted(false);
		botonConfirmarPlantas.setFocusable(false);
		botonConfirmarPlantas.addActionListener(new EscuchadorBotones());
		datosPlantas.add(botonConfirmarPlantas);
		datosPlantas.add(new JLabel());

		datosPlantas.add(new JLabel());
		datosPlantas.add(new JLabel());
		datosPlantas.add(new JLabel());

		textFieldNumPlanta.setFont(fuente);
		textFieldNumPlanta.setToolTipText("Selecciona el numero de planta");
		PlaceHolder holderNumPlanta = new PlaceHolder(textFieldNumPlanta, colorPlaceHolder, Color.black,
				"Introduce num. planta", false, "Arial", 18);
		textFieldNombrePlanta.setFont(fuente);
		textFieldNombrePlanta.setToolTipText("Introduce el nombre de la planta");
		PlaceHolder holderNombrePlanta = new PlaceHolder(textFieldNombrePlanta, colorPlaceHolder, Color.black,
				"Introduce nombre planta", false, "Arial", 18);
		textFieldNombrePlanta.addKeyListener(new EscuchadorTextFields());

		datosPlantas.setVisible(false);

		formularioVacio = new JPanel();
		formularioVacio.setBounds(900, 130, 397, 435);
		formularioVacio.setBackground(colorFondo);
		frame.getContentPane().add(formularioVacio);

		modelo = new DefaultTableModel() {
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		};

		tabla = new JTable();

		tabla.getTableHeader().setReorderingAllowed(false);
		tabla.getTableHeader().setResizingAllowed(false);

		tabla.getTableHeader().setFont(fuenteTabla);

		tabla.setFont(fuenteTabla);

		// Para ordenar automáticamente al pulsar en la cabecera
		tabla.setAutoCreateRowSorter(true);

		// Elegimos el tipo de selección de los registros
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setModel(modelo);
		tabla.setVisible(true);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 130, 900, 435);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(tabla);

		frame.setVisible(true);

	}

	private void centrar() {

		int numeroFilas = tabla.getColumnCount();
		int numeroColumnas = tabla.getColumnCount();

		for (int i = 0; i < numeroFilas; i++) {

			DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
			modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);

			for (int j = 0; j < numeroColumnas; j++) {
				tabla.getColumnModel().getColumn(j).setCellRenderer(modelocentrar);
			}

		}

	}

	private void ayudaPrograma() {

		String ayuda = "Menú principal:\r\n" + "Hay 4 botones:\r\n"
				+ "	Gestión Plantas: abre el menú con todas las opciones de gestión de las plantas.\r\n"
				+ "	Gestión Personal: abre el menú con todas las opciones de gestión del personal.\r\n"
				+ "	Metadatos Plantas: abre una ventana emergente que te pide sobre que tabla quieres consultar sus metadatos. Una vez seleccionada una tabla, se mostrará otra ventana emergente con los metadatos de la misma.\r\n"
				+ "	Ayuda (F11): despliega esta ventana emergente.\r\n" + "Gestión Plantas:\r\n"
				+ "	Volver Atrás: botón que sirve para volver al menú principal.\r\n"
				+ "	Insertar Planta:  se mostrará un formulario en el lateral derecho del programa. Te pedirá el número de la planta y el nombre. El número de la planta no puede repetirse. Ambos datos no pueden ser nulos. Para insertar la planta, pulsa el botón confirmar.\r\n"
				+ "	Buscar Planta: se mostrará una ventana emergente con una lista desplegable que contienen los números de las plantas agregadas. Una vez seleccionada una, se mostrará una tabla en la mitad izquierda del programa con la información de la planta seleccionada.\r\n"
				+ "	Eliminar Planta: se mostrará un formulario en el lateral derecho del programa. Te pedirá el número de planta que quieres eliminar. Para eliminar esa planta, pulsa el botón confirmar. Se eliminarán todos los empleados de esa planta.\r\n"
				+ "	Editar Nombre Planta: se mostrará un formulario en el lateral derecho del programa. Te pedirá el número de la planta cuyo nombre quieres modificar, y el nuevo nombre de la planta. Para modificar el nombre, pulsa el botón confirmar.\r\n"
				+ "Gestión Personal:\r\n" + "	Volver Atrás: botón que sirve para volver al menú principal.\r\n"
				+ "	Insertar Personal: se mostrará un formulario en el lateral derecho del programa. Te pedirá el número del empleado (no puede repetirse), el nombre, los apellidos, el sueldo y el número de planta. Ninguno de estos campos puede ser nulos. Para insertar el empleado, pulsa el botón confirmar.\r\n"
				+ "	Eliminar Personal: se mostrará un formulario en el lateral derecho del programa. Te pedirá el número del empleado. Para eliminar el empleado, pulsa el botón confirmar.\r\n"
				+ "	Aumentar Salario: se mostrará un formulario en el lateral derecho del programa. Te pedirá el sueldo a aumentar (no el salario total, sino la cantidad que se va a aumentar) y el numero de planta. Se modificará el sueldo de todos los empleados de esa planta.\r\n"
				+ "	Mostrar Empleados: se mostrarán todos los empleados en la tabla situada en la mitad izquierda del programa.\r\n"
				+ "";
		
		JOptionPane.showMessageDialog(frame, ayuda, "Ayuda", JOptionPane.QUESTION_MESSAGE);

	}

	private class EscuchadorVentana extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}

	}

	private class EscuchadorBotones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String comando = e.getActionCommand();

			if (comando.equalsIgnoreCase("gestion plantas")) {

				menuInicial.setVisible(false);
				menuPlantas.setVisible(true);
				frame.setTitle("Gestión Ivan Camps: Plantas");
				consultarTodasPlantas();

			} else if (comando.equalsIgnoreCase("insertar planta")) {

				activarFormularioPlantas();
				botonConfirmarPlantas.setActionCommand("confirmar insertar planta");
				textFieldNombrePlanta.setEnabled(true);

			} else if (comando.equalsIgnoreCase("confirmar insertar planta")) {

				insertarPlanta();

			} else if (comando.equalsIgnoreCase("devolver planta")) {

				buscarPlanta();

			} else if (comando.equalsIgnoreCase("eliminar planta")) {

				activarFormularioPlantas();
				botonConfirmarPlantas.setActionCommand("confirmar eliminar planta");
				textFieldNombrePlanta.setEnabled(false);

			} else if (comando.equalsIgnoreCase("confirmar eliminar planta")) {

				eliminarPlanta();

			} else if (comando.equalsIgnoreCase("modificar planta")) {

				activarFormularioPlantas();
				botonConfirmarPlantas.setActionCommand("confirmar modificar planta");
				textFieldNombrePlanta.setEnabled(true);

			} else if (comando.equalsIgnoreCase("confirmar modificar planta")) {

				modificarPlanta();

			} else if (comando.equalsIgnoreCase("atras plantas")) {

				menuPlantas.setVisible(false);
				menuInicial.setVisible(true);
				desactivarFormularios();
				modelo.setRowCount(0);
				modelo.setColumnIdentifiers(cabeceraVacia);
				frame.setTitle("Gestión Ivan Camps: Inicio");

			} else if (comando.equalsIgnoreCase("gestion personal")) {

				menuInicial.setVisible(false);
				menuPersonal.setVisible(true);
				frame.setTitle("Gestión Ivan Camps: Personal");
				consultarTodosEmpleados();

			} else if (comando.equalsIgnoreCase("atras personal")) {

				menuPersonal.setVisible(false);
				menuInicial.setVisible(true);
				desactivarFormularios();
				frame.setTitle("Gestión Ivan Camps: Inicio");
				modelo.setRowCount(0);
				modelo.setColumnIdentifiers(cabeceraVacia);

			} else if (comando.equalsIgnoreCase("insertar personal")) {

				activarFormularioPersonal();
				botonConfirmarPersonal.setActionCommand("confirmar insertar personal");
				textFieldNumEmpleado.setEnabled(true);
				textFieldNombreEmpleado.setEnabled(true);
				textFieldApellidos.setEnabled(true);
				textFieldSueldo.setEnabled(true);
				comboBoxNumPlantasEmpleados.setEnabled(true);

			} else if (comando.equalsIgnoreCase("confirmar insertar personal")) {

				insertarPersonal();

			} else if (comando.equalsIgnoreCase("eliminar personal")) {

				activarFormularioPersonal();
				botonConfirmarPersonal.setActionCommand("confirmar eliminar personal");
				textFieldNumEmpleado.setEnabled(true);
				textFieldNombreEmpleado.setEnabled(false);
				textFieldApellidos.setEnabled(false);
				textFieldSueldo.setEnabled(false);
				comboBoxNumPlantasEmpleados.setEnabled(false);

			} else if (comando.equalsIgnoreCase("confirmar eliminar personal")) {

				eliminarPersonal();

			} else if (comando.equalsIgnoreCase("modificar salario")) {

				activarFormularioPersonal();
				botonConfirmarPersonal.setActionCommand("confirmar aumentar salario");
				textFieldNumEmpleado.setEnabled(false);
				textFieldNombreEmpleado.setEnabled(false);
				textFieldApellidos.setEnabled(false);
				textFieldSueldo.setEnabled(true);
				comboBoxNumPlantasEmpleados.setEnabled(true);

			} else if (comando.equalsIgnoreCase("confirmar aumentar salario")) {

				aumentarSalario();

			} else if (comando.equalsIgnoreCase("mostrar personal")) {

				consultarTodosEmpleados();

			} else if (comando.equalsIgnoreCase("informacion tabla")) {

				mostrarInfoTabla();

			} else if (comando.equalsIgnoreCase("ayuda")) {
				
				ayudaPrograma();
				
			}

		}

		private void activarFormularioPlantas() {

			formularioVacio.setVisible(false);
			datosPlantas.setVisible(true);

		}

		private void activarFormularioPersonal() {

			formularioVacio.setVisible(false);
			datosPersonal.setVisible(true);

		}

		private void desactivarFormularios() {

			datosPlantas.setVisible(false);
			datosPersonal.setVisible(false);
			formularioVacio.setVisible(true);

		}

		private void mostrarInfoTabla() {

			String[] listaTablas = { "personal", "planta" };
			JComboBox comboBoxListaTablas = new JComboBox(listaTablas);

			JOptionPane.showMessageDialog(frame, comboBoxListaTablas,
					"Selecciona la tabla de la que quieres saber la información", JOptionPane.QUESTION_MESSAGE);

			String opcionElegida = comboBoxListaTablas.getSelectedItem().toString();

			String infoTabla;

			infoTabla = gesBBDD.imprimirInformacionTabla(opcionElegida, frame);

			JOptionPane.showMessageDialog(frame, infoTabla, "Información tabla: " + opcionElegida,
					JOptionPane.INFORMATION_MESSAGE);

		}

		private void insertarPlanta() {

			int numPlanta;
			String nombrePlanta;

			boolean insertado = false;

			try {

				numPlanta = Integer.parseInt(textFieldNumPlanta.getText());

				nombrePlanta = textFieldNombrePlanta.getText();

				Planta p = new Planta(numPlanta, nombrePlanta);

				insertado = gesBBDD.insertarPlanta(p, frame);

				if (insertado) {

					JOptionPane.showMessageDialog(frame, "Planta insertada correctamente", "Insertada!",
							JOptionPane.INFORMATION_MESSAGE);

					consultarTodasPlantas();

				} else {

					JOptionPane.showMessageDialog(frame, "La planta no ha podido ser insertada", "Error",
							JOptionPane.ERROR_MESSAGE);

				}

			} catch (NumberFormatException e) {

				JOptionPane.showMessageDialog(frame, "Debes introducir un número", "Error", JOptionPane.ERROR_MESSAGE);

			}

		}

		private void eliminarPlanta() {

			int numPlanta;

			try {

				numPlanta = Integer.parseInt(textFieldNumPlanta.getText());

				int filasAfectadas = 0;

				filasAfectadas = gesBBDD.eliminarPlanta(numPlanta, frame);

				if (filasAfectadas > 0) {

					JOptionPane.showMessageDialog(frame,
							"Planta eliminada correctamente.\nFilas afectadas: " + filasAfectadas,
							"Elimanada correctamente!", JOptionPane.INFORMATION_MESSAGE);

					consultarTodasPlantas();

				}

			} catch (NumberFormatException e) {

				JOptionPane.showMessageDialog(frame, "Debes introducir un número", "Error", JOptionPane.ERROR_MESSAGE);

			}

		}

		private void modificarPlanta() {

			int numPlanta;

			String nombrePlanta;

			boolean modificado = false;

			try {

				numPlanta = Integer.parseInt(textFieldNumPlanta.getText());
				nombrePlanta = textFieldNombrePlanta.getText();

				Planta p = new Planta(numPlanta, nombrePlanta);

				modificado = gesBBDD.modificarNombrePlanta(p, frame);

				if (modificado) {

					JOptionPane.showMessageDialog(frame, "Nombre de la planta modificado correctamente", "Modificado!",
							JOptionPane.INFORMATION_MESSAGE);

					consultarUnaPlanta(numPlanta);

				} else {

					JOptionPane.showMessageDialog(frame, "La planta no ha podido ser modificada", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			} catch (NumberFormatException e) {

				JOptionPane.showMessageDialog(frame, "Debes introducir un número", "Error", JOptionPane.ERROR_MESSAGE);

			}

		}

		private void buscarPlanta() {

			ArrayList<Integer> listaNumPlantas = new ArrayList<Integer>();

			listaNumPlantas = gesBBDD.consultarNumerosPlantas(frame);

			JComboBox comboBox = new JComboBox(listaNumPlantas.toArray());

			JOptionPane.showMessageDialog(frame, comboBox, "Seleccione una planta", JOptionPane.QUESTION_MESSAGE);

			int numPlantaSeleccionado = Integer.parseInt(comboBox.getSelectedItem().toString());

			consultarUnaPlanta(numPlantaSeleccionado);

		}

		private void consultarUnaPlanta(int numPlanta) {

			String columnas[] = { "NUMERO PLANTA", "NOMBRE PLANTA" };

			modelo.setColumnIdentifiers(columnas);

			Planta p = gesBBDD.devolver(numPlanta, frame);

			String[] arrayPlanta = { String.valueOf(p.getNumeroPlanta()), p.getNombrePlanta() };

			modelo.setRowCount(0);

			centrar();

			modelo.addRow(arrayPlanta);

		}

		private void consultarTodasPlantas() {

			ArrayList<Planta> listaPlantas = new ArrayList<Planta>();

			String columnas[] = { "NUMERO PLANTA", "NOMBRE PLANTA" };

			modelo.setColumnIdentifiers(columnas);

			centrar();

			modelo.setRowCount(0);
			listaPlantas = gesBBDD.consultarTodasLasPlantas(frame);

			for (int i = 0; i < listaPlantas.size(); i++) {

				String[] datos = new String[2];
				datos[0] = String.valueOf(listaPlantas.get(i).getNumeroPlanta());
				datos[1] = listaPlantas.get(i).getNombrePlanta();

				modelo.addRow(datos);

			}

		}

		private void insertarPersonal() {

			int numEmpleado;
			String nombreEmpleado;
			String apellidosEmpleado;
			int sueldoEmpleado;
			int numPlantaEmpleado;

			boolean insertado = false;

			try {

				numEmpleado = Integer.parseInt(textFieldNumEmpleado.getText());
				nombreEmpleado = textFieldNombreEmpleado.getText();
				apellidosEmpleado = textFieldApellidos.getText();
				sueldoEmpleado = Integer.parseInt(textFieldSueldo.getText());
				numPlantaEmpleado = Integer.parseInt(comboBoxNumPlantasEmpleados.getSelectedItem().toString());

				Personal p = new Personal(numEmpleado, nombreEmpleado, apellidosEmpleado, sueldoEmpleado,
						numPlantaEmpleado);

				insertado = gesBBDD.insertarEmpleado(p, frame);

				if (insertado) {

					JOptionPane.showMessageDialog(frame, "Empleado insertado correctamente", "Insertado!",
							JOptionPane.INFORMATION_MESSAGE);
					consultarTodosEmpleados();

				} else {

					JOptionPane.showMessageDialog(frame, "El empleado no ha podido ser insertado", "Error",
							JOptionPane.ERROR_MESSAGE);

				}

			} catch (NumberFormatException e) {

				JOptionPane.showMessageDialog(frame, "Debes introducir un número", "Error", JOptionPane.ERROR_MESSAGE);

			}

		}

		private void consultarTodosEmpleados() {

			ArrayList<PersonalPlanta> listaPersonal = new ArrayList<PersonalPlanta>();

			String columnas[] = { "Nº EMPLEADO", "NOMBRE", "APELLIDOS", "SUELDO", "Nº PLANTA", "NOMBRE PLANTA" };

			modelo.setColumnIdentifiers(columnas);

			centrar();

			modelo.setRowCount(0);

			listaPersonal = gesBBDD.mostrarEmpleadosPlantas(frame);

			for (int i = 0; i < listaPersonal.size(); i++) {

				String[] datos = new String[6];
				datos[0] = String.valueOf(listaPersonal.get(i).getPersonal().getNumero());
				datos[1] = listaPersonal.get(i).getPersonal().getNombre();
				datos[2] = listaPersonal.get(i).getPersonal().getApellidos();
				datos[3] = String.valueOf(listaPersonal.get(i).getPersonal().getSueldo());
				datos[4] = String.valueOf(listaPersonal.get(i).getPlanta().getNumeroPlanta());
				datos[5] = listaPersonal.get(i).getPlanta().getNombrePlanta();

				modelo.addRow(datos);

			}

		}

		private void eliminarPersonal() {

			int numEmpleado;

			try {

				numEmpleado = Integer.parseInt(textFieldNumEmpleado.getText());

				boolean eliminado = false;

				eliminado = gesBBDD.eliminarEmpleado(numEmpleado, frame);

				if (eliminado) {

					JOptionPane.showMessageDialog(frame, "Empleado eliminado correctamente.",
							"Elimanado correctamente!", JOptionPane.INFORMATION_MESSAGE);

					consultarTodosEmpleados();

				}

			} catch (NumberFormatException e) {

				JOptionPane.showMessageDialog(frame, "Debes introducir un número", "Error", JOptionPane.ERROR_MESSAGE);

			}

		}

		private void aumentarSalario() {

			int salario;
			int numPlanta;

			try {

				salario = Integer.parseInt(textFieldSueldo.getText());
				numPlanta = Integer.parseInt(comboBoxNumPlantasEmpleados.getSelectedItem().toString());

				boolean modificado = false;

				modificado = gesBBDD.modificarSalario(numPlanta, salario, frame);

				if (modificado) {

					JOptionPane.showMessageDialog(frame,
							"Salario de todos los empleados de la planta seleccionada aumentado correctamente",
							"Salario aumentado correctamente!", JOptionPane.INFORMATION_MESSAGE);

					consultarEmpleadosUnaPlanta(numPlanta);

				}

			} catch (NumberFormatException e) {

				JOptionPane.showMessageDialog(frame, "Debes introducir un número", "Error", JOptionPane.ERROR_MESSAGE);

			}

		}

		private void consultarEmpleadosUnaPlanta(int numPlanta) {

			ArrayList<PersonalPlanta> listaPersonal = new ArrayList<PersonalPlanta>();

			String columnas[] = { "Nº EMPLEADO", "NOMBRE", "APELLIDOS", "SUELDO", "Nº PLANTA", "NOMBRE PLANTA" };

			modelo.setColumnIdentifiers(columnas);

			centrar();

			modelo.setRowCount(0);
			listaPersonal = gesBBDD.mostrarEmpleadosUnaPlanta(numPlanta, frame);

			for (int i = 0; i < listaPersonal.size(); i++) {

				String[] datos = new String[6];
				datos[0] = String.valueOf(listaPersonal.get(i).getPersonal().getNumero());
				datos[1] = listaPersonal.get(i).getPersonal().getNombre();
				datos[2] = listaPersonal.get(i).getPersonal().getApellidos();
				datos[3] = String.valueOf(listaPersonal.get(i).getPersonal().getSueldo());
				datos[4] = String.valueOf(listaPersonal.get(i).getPlanta().getNumeroPlanta());
				datos[5] = listaPersonal.get(i).getPlanta().getNombrePlanta();

				modelo.addRow(datos);

			}

		}

	}

	private class EscuchadorTextFields implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			if (textFieldNombrePlanta.isFocusOwner()) {
				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {

				} else if (textFieldNombrePlanta.getText().length() == 30) {
					e.consume();
				}
			} else if (textFieldNombreEmpleado.isFocusOwner()) {
				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {

				} else if (textFieldNombreEmpleado.getText().length() == 30) {
					e.consume();
				}
			} else if (textFieldApellidos.isFocusOwner()) {
				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {

				} else if (textFieldApellidos.getText().length() == 50) {
					e.consume();
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (textFieldNombrePlanta.isFocusOwner()) {
				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {

				} else if (textFieldNombrePlanta.getText().length() == 30) {
					e.consume();
				}
			} else if (textFieldNombreEmpleado.isFocusOwner()) {
				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {

				} else if (textFieldNombreEmpleado.getText().length() == 30) {
					e.consume();
				}
			} else if (textFieldApellidos.isFocusOwner()) {
				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {

				} else if (textFieldApellidos.getText().length() == 50) {
					e.consume();
				}
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			if (textFieldNombrePlanta.isFocusOwner()) {
				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {

				} else if (textFieldNombrePlanta.getText().length() == 30) {
					e.consume();
				}
			} else if (textFieldNombreEmpleado.isFocusOwner()) {
				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {

				} else if (textFieldNombreEmpleado.getText().length() == 30) {
					e.consume();
				}
			} else if (textFieldApellidos.isFocusOwner()) {
				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {

				} else if (textFieldApellidos.getText().length() == 50) {
					e.consume();
				}
			}
		}

	}

}
