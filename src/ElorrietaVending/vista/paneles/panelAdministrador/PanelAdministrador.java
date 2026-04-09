package ElorrietaVending.vista.paneles.panelAdministrador;

import javax.swing.JPanel;

import ElorrietaVending.modelo.DAO.DAOProductos;
import ElorrietaVending.modelo.entidades.Producto;
import ElorrietaVending.modelo.entidades.Productos.Bebida;
import ElorrietaVending.vista.ventanas.VentanaPrincipal;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import javax.swing.JTextField;
import javax.swing.JLabel;

public class PanelAdministrador extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldCbxNombre;
	private JTextField textField_1CbxPrecio;
	private DAOProductos daoProductos = new DAOProductos();
	private JComboBox<String> comboBoxCbxTipo = null;
	JComboBox<String> comboBoxCbxBebidas = null;
	JComboBox<String> comboBox_1CbxBolleria = null;
	JComboBox<String> comboBox_2CbxFrituras = null;
	JComboBox<String> comboBox_3CbxDulces = null;
	private Producto productoSeleccionado = null;

	public PanelAdministrador(VentanaPrincipal ventana) {
		setBackground(Color.PINK);
		setSize(598, 798);
		setLayout(null);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarPanel(0);
			}
		});
		btnAtras.setBounds(29, 59, 89, 23);
		add(btnAtras);

		ArrayList<Producto> bebidas = daoProductos.getByTipo("bebidas");
		comboBoxCbxBebidas = new JComboBox();
		comboBoxCbxBebidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxCbxBebidas.getSelectedItem() == null) {
					return;
				}
				
				for (int i = 0; i < bebidas.size(); i++) {
					if (comboBoxCbxBebidas.getSelectedItem().toString().equalsIgnoreCase(bebidas.get(i).getNombre())) {
						mostrarProductos(bebidas.get(i), 0);
						productoSeleccionado = bebidas.get(i);
					}
				}
			}
		});
		comboBoxCbxBebidas.addItem("");
		for (int i = 0; i < bebidas.size(); i++) {
			comboBoxCbxBebidas.addItem(bebidas.get(i).getNombre());
		}
		comboBoxCbxBebidas.setToolTipText("");
		comboBoxCbxBebidas.setBounds(30, 186, 134, 23);
		add(comboBoxCbxBebidas);

		ArrayList<Producto> bolleria = daoProductos.getByTipo("bolleria");
		comboBox_1CbxBolleria = new JComboBox();
		comboBox_1CbxBolleria.addItem("");
		for (int i = 0; i < bolleria.size(); i++) {
			comboBox_1CbxBolleria.addItem(bolleria.get(i).getNombre());
		}
		comboBox_1CbxBolleria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_1CbxBolleria.getSelectedItem() == null) {
					return;
				}
				
				for (int i = 0; i < bolleria.size(); i++) {
					if (comboBox_1CbxBolleria.getSelectedItem().toString()
							.equalsIgnoreCase(bolleria.get(i).getNombre())) {
						mostrarProductos(bolleria.get(i), 1);
						productoSeleccionado = bolleria.get(i);
					}
				}
			}
		});

		comboBox_1CbxBolleria.setBounds(30, 277, 134, 23);
		add(comboBox_1CbxBolleria);

		ArrayList<Producto> frituras = daoProductos.getByTipo("frituras");
		comboBox_2CbxFrituras = new JComboBox();
		comboBox_2CbxFrituras.addItem("");
		for (int i = 0; i < frituras.size(); i++) {
			comboBox_2CbxFrituras.addItem(frituras.get(i).getNombre());
		}
		comboBox_2CbxFrituras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_2CbxFrituras.getSelectedItem() == null) {
					return;
				}
				
				for (int i = 0; i < frituras.size(); i++) {
					if (comboBox_2CbxFrituras.getSelectedItem().toString()
							.equalsIgnoreCase(frituras.get(i).getNombre())) {
						mostrarProductos(frituras.get(i), 2);
						productoSeleccionado = frituras.get(i);
					}
				}
			}
		});

		comboBox_2CbxFrituras.setBounds(29, 387, 134, 23);
		add(comboBox_2CbxFrituras);

		ArrayList<Producto> dulces = daoProductos.getByTipo("dulces");
		comboBox_3CbxDulces = new JComboBox();
		comboBox_3CbxDulces.addItem("");
		for (int i = 0; i < dulces.size(); i++) {
			comboBox_3CbxDulces.addItem(dulces.get(i).getNombre());
		}
		comboBox_3CbxDulces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_3CbxDulces.getSelectedItem() == null) {
					return;
				}
				
				for (int i = 0; i < dulces.size(); i++) {
					if (comboBox_3CbxDulces.getSelectedItem().toString().equalsIgnoreCase(dulces.get(i).getNombre())) {
						mostrarProductos(dulces.get(i), 3);
						productoSeleccionado = dulces.get(i);
					}
				}
			}
		});
		comboBox_3CbxDulces.setBounds(29, 476, 135, 23);
		add(comboBox_3CbxDulces);

		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productoSeleccionado.setNombre(textFieldCbxNombre.getText());
				productoSeleccionado.setPrecio(Double.parseDouble(textField_1CbxPrecio.getText()));
				productoSeleccionado.setTipo(comboBoxCbxTipo.getSelectedItem().toString());
				daoProductos.Update(productoSeleccionado);
				reiniciarCombos();
			}
		});
		btnGuardar.setBounds(462, 737, 84, 20);
		add(btnGuardar);

		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(320, 737, 84, 20);
		add(btnEliminar);

		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.setBounds(173, 737, 84, 20);
		add(btnNuevo);

		JLabel lblTipo = new JLabel("TIPO:");
		lblTipo.setBounds(269, 374, 44, 12);
		add(lblTipo);

		JLabel lblPrecio = new JLabel("PRECIO:");
		lblPrecio.setBounds(269, 313, 44, 12);
		add(lblPrecio);

		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setBounds(256, 255, 68, 12);
		add(lblNombre);

		textFieldCbxNombre = new JTextField();
		textFieldCbxNombre.setBounds(334, 252, 134, 18);
		add(textFieldCbxNombre);
		textFieldCbxNombre.setColumns(10);

		textField_1CbxPrecio = new JTextField();
		textField_1CbxPrecio.setBounds(334, 310, 96, 18);
		add(textField_1CbxPrecio);
		textField_1CbxPrecio.setColumns(10);

		comboBoxCbxTipo = new JComboBox();
		comboBoxCbxTipo.setBounds(337, 370, 131, 23);
		comboBoxCbxTipo.addItem("Bebidas");
		comboBoxCbxTipo.addItem("Bolleria");
		comboBoxCbxTipo.addItem("Frituras");
		comboBoxCbxTipo.addItem("Dulces");
		add(comboBoxCbxTipo);

		JLabel lblBebida = new JLabel("BEBIDA");
		lblBebida.setBounds(65, 161, 53, 14);
		add(lblBebida);

		JLabel lblBolleria = new JLabel("BOLLERIA");
		lblBolleria.setBounds(65, 254, 68, 14);
		add(lblBolleria);

		JLabel lblFrituras = new JLabel("FRITURAS");
		lblFrituras.setBounds(65, 358, 68, 18);
		add(lblFrituras);

		JLabel lblDulces = new JLabel("DULCES");
		lblDulces.setBounds(72, 451, 46, 14);
		add(lblDulces);

	}

	public void mostrarProductos(Producto producto, int tipo) {
		textFieldCbxNombre.setText(producto.getNombre());
		textField_1CbxPrecio.setText("" + producto.getPrecio());
		comboBoxCbxTipo.setSelectedIndex(tipo);

	}
	
	public void reiniciarCombos() {
		ArrayList<Producto> bebidas = daoProductos.getByTipo("bebidas");
		comboBoxCbxBebidas.removeAllItems();
		comboBoxCbxBebidas.addItem("");
		for (int i = 0; i < bebidas.size(); i++) {
			comboBoxCbxBebidas.addItem(bebidas.get(i).getNombre());
		}
		comboBoxCbxBebidas.revalidate();
		
		ArrayList<Producto> bolleria = daoProductos.getByTipo("bolleria");
		comboBox_1CbxBolleria.removeAllItems();
		comboBox_1CbxBolleria.addItem("");
		for (int i = 0; i < bolleria.size(); i++) {
			comboBox_1CbxBolleria.addItem(bolleria.get(i).getNombre());
		}
		comboBox_1CbxBolleria.revalidate();
		
		ArrayList<Producto> frituras = daoProductos.getByTipo("frituras");
		comboBox_2CbxFrituras.removeAllItems();
		comboBox_2CbxFrituras.addItem("");
		for (int i = 0; i < frituras.size(); i++) {
			comboBox_2CbxFrituras.addItem(frituras.get(i).getNombre());
		}
		comboBox_2CbxFrituras.revalidate();
		
		
		ArrayList<Producto> dulces = daoProductos.getByTipo("dulces");
		comboBox_3CbxDulces.removeAllItems();
		comboBox_3CbxDulces.addItem("");
		for (int i = 0; i < dulces.size(); i++) {
			comboBox_3CbxDulces.addItem(dulces.get(i).getNombre());
		}
		comboBox_3CbxDulces.revalidate();
	}
	
	
}
