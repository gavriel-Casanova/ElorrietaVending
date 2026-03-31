package ElorrietaVending.modelo.entidades;

import java.util.List;

public class Carrito {
	private List<Producto> productos = null;

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Carrito [productos=" + productos + "]";
	}

	public Carrito(List<Producto> productos) {
		super();
		this.productos = productos;
	}
}
