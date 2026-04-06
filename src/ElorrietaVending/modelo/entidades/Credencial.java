package ElorrietaVending.modelo.entidades;

public class Credencial {
	private int id = 0;
	private String usuario = null;
	private String contraseña = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Credencial [id=" + id + ", usuario=" + usuario + ", contraseña=" + contraseña + "]";
	}

	public Credencial(int id, String usuario, String contraseña) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.contraseña = contraseña;
	}
}
