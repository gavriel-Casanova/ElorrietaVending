package ElorrietaVending.modelo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ElorrietaVending.modelo.entidades.Credencial;
import ElorrietaVending.modelo.entidades.Personas.Administrador;
import ElorrietaVending.modelo.entidades.Personas.Cliente;
import ElorrietaVending.modelo.interfaces.DaoInterfaces;
import ElorrietaVending.modelo.ultils.DBUtils;

public class DAOAdministrador implements DaoInterfaces <Administrador> {

	@Override
	public ArrayList<Administrador> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administrador getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Administrador log) {
		// TODO Auto-generated method stub
		
	}
	
	public Administrador getByLogin(String uss, String pass) {
		Administrador ret = null;

		String sql = "select * from administrador a join credenciales x on a.idCredencia = x.id where usuaio = '"+uss+"' and contraseña = '"+pass+"'";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {


				ret = new Administrador();

				int id = resultSet.getInt("id");
				String nombre = resultSet.getString("nombre");
				String apellido = resultSet.getString("apellido");
				int telefono = resultSet.getInt("telefono");
				String correo = resultSet.getString("correo");
				int idCredencial = resultSet.getInt("idCredencial");
				String usuario = resultSet.getString("usuario");
				String contraseña = resultSet.getString("contraseña");
				
				ret.setId(id);
				ret.setNombre(nombre);
				ret.setApellido(apellido);
				ret.setTelefono(telefono);
				ret.setEmail(correo);

				Credencial cred = new Credencial();
				
				cred.setId(idCredencial);
				cred.setUsuario(usuario);
				cred.setContraseña(contraseña);
				
				ret.setCredencial(cred);
				
				
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
			}
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				// No hace falta
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// No hace falta
			}
		}
		return ret;
	}

}
