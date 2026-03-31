package ElorrietaVending.modelo.entidades.Personas;

import ElorrietaVending.modelo.entidades.Persona;

public class Cliente extends Persona {

	@Override
	public String toString() {
		return "Cliente [getNombre()=" + getNombre() + ", getApellido()=" + getApellido() + ", getEmail()=" + getEmail()
				+ ", getTelefono()=" + getTelefono() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + "]";
	}

}
