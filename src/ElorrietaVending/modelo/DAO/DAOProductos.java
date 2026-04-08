package ElorrietaVending.modelo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ElorrietaVending.modelo.entidades.Producto;
import ElorrietaVending.modelo.interfaces.DaoInterfaces;
import ElorrietaVending.modelo.ultils.DBUtils;

public class DAOProductos implements DaoInterfaces<Producto> {

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

		String sql = "select * from producto where tipo = '" + tipo + "'";

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
		Connection connection = null;

		// Vamos a lanzar una sentencia SQL contra la BBDD
		Statement statement = null;

		try {
			// El Driver que vamos a usar
			Class.forName(DBUtils.DRIVER);

			// Abrimos la conexion con BBDD
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			// Vamos a lanzar la sentencia...
			statement = connection.createStatement();

			// Montamos la SQL. Esta es una forma simple de hacerlo, hay otra mejor...
			String sql = "INSERT INTO `producto`( `nombre`, `precio`, `tipo`) VALUES (?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, log.getNombre());
			ps.setDouble(2, log.getPrecio());
			ps.setString(3, log.getTipo());

			ps.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			// Cerramos al reves de como las abrimos
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

	}

	public void UpdateProyecto(Producto log) {

		Connection connection = null;

		PreparedStatement preparedStatement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = "UPDATE `producto` SET `nombre`= ?,`precio`= ?,`tipo`= ? WHERE id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, log.getNombre());
			preparedStatement.setDouble(2, log.getPrecio());
			preparedStatement.setString(3, log.getTipo());
			preparedStatement.setInt(4, log.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
		}
	}

	public void delete(Producto log) {
		Connection connection = null;

		PreparedStatement preparedStatement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = "DELETE FROM `producto` WHERE id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, log.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
		}
	}

}
