package ElorrietaVending.modelo.entidades.Productos;

import ElorrietaVending.modelo.entidades.Producto;

public class Dulce extends Producto{

	@Override
	public String toString() {
		return "Dulce [getNombre()=" + getNombre() + ", getPrecio()=" + getPrecio() + ", getTipo()=" + getTipo()
				+ ", getId()=" + getId() + ", toString()=" + super.toString() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + "]";
	}

}
