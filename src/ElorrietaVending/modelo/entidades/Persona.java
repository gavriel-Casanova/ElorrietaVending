package ElorrietaVending.modelo.entidades;

import java.util.Objects;

public abstract class Persona {
	private int id =0;
	private String Nombre = null;
	private String Apellido = null;
	private String Email = null;
	private int Telefono = 0;
	private Credencial credencial = null;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getTelefono() {
		return Telefono;
	}
	public void setTelefono(int telefono) {
		Telefono = telefono;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Credencial getCredencial() {
		return credencial;
	}
	public void setCredencial(Credencial credencial) {
		this.credencial = credencial;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Apellido, Email, Nombre, Telefono, credencial, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(Apellido, other.Apellido) && Objects.equals(Email, other.Email)
				&& Objects.equals(Nombre, other.Nombre) && Telefono == other.Telefono
				&& Objects.equals(credencial, other.credencial) && id == other.id;
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Email=" + Email
				+ ", Telefono=" + Telefono + ", credencial=" + credencial + "]";
	}
	
}
