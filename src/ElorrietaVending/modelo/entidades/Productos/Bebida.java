package ElorrietaVending.modelo.entidades.Productos;

import ElorrietaVending.modelo.entidades.Producto;

public class Bebida extends Producto {

	@Override
	public String toString() {
		return "Bebida [getNombre()=" + getNombre() + ", getPrecio()=" + getPrecio() + ", getTipo()=" + getTipo()
				+ ", getId()=" + getId() + ", toString()=" + super.toString() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + "]";
	}
	
}
