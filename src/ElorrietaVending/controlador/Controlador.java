
package ElorrietaVending.controlador;

import ElorrietaVending.modelo.DAO.DAOAdministrador;
import ElorrietaVending.modelo.DAO.DAOCliente;
import ElorrietaVending.modelo.entidades.Persona;
import ElorrietaVending.modelo.entidades.Personas.Administrador;
import ElorrietaVending.modelo.entidades.Personas.Cliente;

public class Controlador {
	public Persona validarLogin(String usuario, String contraseña) {
		Persona ret = null;
		DAOAdministrador daoAdministrador = new DAOAdministrador();
		DAOCliente daoCliente = new DAOCliente();

		Administrador administrador = daoAdministrador.getByLogin(usuario, contraseña);
		Cliente cliente = daoCliente.getByLogin(usuario, contraseña);
		if (administrador == null && cliente == null) {
			ret = null;
		} else if (administrador == null && cliente != null) {
			ret = cliente;
		} else if (administrador != null && cliente == null) {
			ret = administrador;
		}
		return ret;
	}
}
