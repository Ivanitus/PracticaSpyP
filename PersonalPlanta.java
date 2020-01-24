
public class PersonalPlanta {
	
	private Personal personal;
	private Planta planta;
	
	protected PersonalPlanta(Personal personal, Planta planta) {
		this.personal = personal;
		this.planta = planta;
	}

	protected Personal getPersonal() {
		return personal;
	}

	protected void setPersonal(Personal personal) {
		this.personal = personal;
	}

	protected Planta getPlanta() {
		return planta;
	}

	protected void setPlanta(Planta planta) {
		this.planta = planta;
	}
	
}
