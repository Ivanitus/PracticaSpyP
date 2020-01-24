
public class Personal {

	private int numero;
	private String nombre;
	private String apellidos;
	private int sueldo;
	private int numPlanta;

	protected Personal(int numero, String nombre, String apellidos, int sueldo) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sueldo = sueldo;
	}

	protected Personal(int numero, String nombre, String apellidos, int sueldo, int numPlanta) {
		this.numero = numero;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sueldo = sueldo;
		this.numPlanta = numPlanta;
	}

	protected int getNumero() {
		return numero;
	}

	protected void setNumero(int numero) {
		this.numero = numero;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected String getApellidos() {
		return apellidos;
	}

	protected void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	protected int getSueldo() {
		return sueldo;
	}

	protected void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	protected int getNumPlanta() {
		return numPlanta;
	}

	protected void setNumPlanta(int numPlanta) {
		this.numPlanta = numPlanta;
	}

}
