package ElorrietaVending.modelo.entidades.Productos;

import ElorrietaVending.modelo.entidades.Producto;

public class Bolleria extends Producto{

	@Override
	public String toString() {
		return "Bolleria [getNombre()=" + getNombre() + ", getPrecio()=" + getPrecio() + ", getTipo()=" + getTipo()
				+ ", getId()=" + getId() + ", toString()=" + super.toString() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + "]";
	}

}
