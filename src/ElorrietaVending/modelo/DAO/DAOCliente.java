package ElorrietaVending.modelo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ElorrietaVending.modelo.entidades.Credencial;
import ElorrietaVending.modelo.entidades.Producto;
import ElorrietaVending.modelo.entidades.Personas.Cliente;
import ElorrietaVending.modelo.interfaces.DaoInterfaces;
import ElorrietaVending.modelo.ultils.DBUtils;

public class DAOCliente implements DaoInterfaces <Cliente> {

	@Override
	public ArrayList<Cliente> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Cliente log) {
		// TODO Auto-generated method stub
		
	}
	
	public Cliente getByLogin(String uss, String pass) {
		Cliente ret = null;

		String sql = "select * from clientes c join credenciales x on c.idCredencia = x.id where usuaio = '"+uss+"' and contraseña = '"+pass+"'";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {


				ret = new Cliente();

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
