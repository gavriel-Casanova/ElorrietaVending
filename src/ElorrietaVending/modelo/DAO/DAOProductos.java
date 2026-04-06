package ElorrietaVending.modelo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ElorrietaVending.modelo.entidades.Producto;
import ElorrietaVending.modelo.interfaces.DaoInterfaces;
import ElorrietaVending.modelo.ultils.DBUtils;

public class DAOProductos implements DaoInterfaces <Producto>{

	@Override
	public ArrayList<Producto> getAll() {
		ArrayList<Producto> ret = null;

		String sql = "select * from producto";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			// El Driver que vamos a usar
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				if (null == ret)
					ret = new ArrayList<Producto>();

				Producto producto = new Producto();

				int id = resultSet.getInt("id");
				String nombre = resultSet.getString("nombre");
				double precio = resultSet.getDouble("precio");
				String tipo = resultSet.getString("tipo");
				
				producto.setId(id);
				producto.setNombre(nombre);
				producto.setPrecio(precio);
				producto.setTipo(tipo);
				
				

				ret.add(producto);
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

	@Override
	public Producto getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Producto> getByTipo(String tipo) {
		ArrayList<Producto> ret = null;

		String sql = "select * from producto where tipo = '"+tipo+"'";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			// El Driver que vamos a usar
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				if (null == ret)
					ret = new ArrayList<Producto>();

				Producto producto = new Producto();

				int id = resultSet.getInt("id");
				String nombre = resultSet.getString("nombre");
				double precio = resultSet.getDouble("precio");
				String tipo2 = resultSet.getString("tipo");
				
				producto.setId(id);
				producto.setNombre(nombre);
				producto.setPrecio(precio);
				producto.setTipo(tipo2);

				ret.add(producto);
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


	@Override
	public void insert(Producto log) {
		// TODO Auto-generated method stub
		
	}

}
