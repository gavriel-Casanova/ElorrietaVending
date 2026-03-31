package ElorrietaVending.modelo.entidades.Productos;

import ElorrietaVending.modelo.entidades.Producto;

public class Fritura extends Producto {

	@Override
	public String toString() {
		return "Fritura [getNombre()=" + getNombre() + ", getPrecio()=" + getPrecio() + ", getTipo()=" + getTipo()
				+ ", getId()=" + getId() + ", toString()=" + super.toString() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + "]";
	}

}
