
public class Planta {

	private int numeroPlanta;
	private String nombrePlanta;
	
	protected Planta() {
		
	}
	
	protected Planta(int numeroPlanta, String nombrePlanta) {
		
		this.numeroPlanta = numeroPlanta;
		this.nombrePlanta = nombrePlanta;
	}
	

	protected int getNumeroPlanta() {
		
		return numeroPlanta;
		
	}

	protected void setNumeroPlanta(int numeroPlanta) {
		
		this.numeroPlanta = numeroPlanta;
		
	}

	protected String getNombrePlanta() {
		
		return nombrePlanta;
		
	}

	protected void setNombrePlanta(String nombrePlanta) {
		
		this.nombrePlanta = nombrePlanta;
		
	}
	
}
