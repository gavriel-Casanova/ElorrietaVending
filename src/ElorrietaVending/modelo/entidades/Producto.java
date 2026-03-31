package ElorrietaVending.modelo.entidades;

import java.util.Objects;

public class Producto {
	private String Nombre = null;
	private int precio = 0;
	private String tipo = null;
	private int id= 0;
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Producto [Nombre=" + Nombre + ", precio=" + precio + ", tipo=" + tipo + ", id=" + id + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Nombre, id, precio, tipo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(Nombre, other.Nombre) && id == other.id && precio == other.precio
				&& Objects.equals(tipo, other.tipo);
	}
	
}
