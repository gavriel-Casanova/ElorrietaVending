package ElorrietaVending.vista.paneles.panelCliente;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ElorrietaVending.modelo.DAO.DAOProductos;
import ElorrietaVending.modelo.entidades.Producto;
import ElorrietaVending.vista.ventanas.VentanaPrincipal;

public class PanelCliente extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> cbxBebidas = null;
	private JComboBox<String> cbxBolleria = null;
	private JComboBox<String> cbxFrituras = null;
	private JComboBox<String> cbxDulces = null;
	private ArrayList<Producto> bebidas = null;
	private ArrayList<Producto> bolleria = null;
	private ArrayList<Producto> frituras = null;
	private ArrayList<Producto> dulces = null;
	private DAOProductos daoProductos = null;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JComboBox<String> cbxTipo = null;
	private Producto productoSeleccionado = null;
	
	
	public PanelCliente(VentanaPrincipal ventana) {
		setBackground(Color.GREEN);
		setSize(598, 798);
		setLayout(null);
		daoProductos = new DAOProductos();
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarPanel(0);
			}
		});
		btnAtras.setBounds(29, 59, 89, 23);
		add(btnAtras);
		
		/**
		 * El carrito se puede hacer con una ventana nueva o con una tabla o en un panel diferente 
		 */
		
		bebidas = daoProductos.getByTipo("bebidas");
		cbxBebidas = new JComboBox();
		cbxBebidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbxBebidas.getSelectedItem() == null) {
					return;
				}
				bebidas = daoProductos.getByTipo("bebidas");
				for (int i = 0; i < bebidas.size(); i++) {
					if (cbxBebidas.getSelectedItem().toString().equalsIgnoreCase(bebidas.get(i).getNombre())) {
						mostrarProductos(bebidas.get(i), 0);
						productoSeleccionado = bebidas.get(i);
					}
				}
			}
		});
		cbxBebidas.addItem("");
		for (int i = 0; i < bebidas.size(); i++) {
			cbxBebidas.addItem(bebidas.get(i).getNombre());
		}
		cbxBebidas.setToolTipText("");
		cbxBebidas.setBounds(30, 186, 134, 23);
		add(cbxBebidas);

		bolleria = daoProductos.getByTipo("bolleria");
		cbxBolleria = new JComboBox();
		cbxBolleria.addItem("");
		for (int i = 0; i < bolleria.size(); i++) {
			cbxBolleria.addItem(bolleria.get(i).getNombre());
		}
		cbxBolleria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bolleria = daoProductos.getByTipo("bolleria");
				if(cbxBolleria.getSelectedItem() == null) {
					return;
				}
				
				for (int i = 0; i < bolleria.size(); i++) {
					if (cbxBolleria.getSelectedItem().toString()
							.equalsIgnoreCase(bolleria.get(i).getNombre())) {
						mostrarProductos(bolleria.get(i), 1);
						productoSeleccionado = bolleria.get(i);
					}
				}
			}
		});

		cbxBolleria.setBounds(30, 277, 134, 23);
		add(cbxBolleria);

		frituras = daoProductos.getByTipo("frituras");
		cbxFrituras = new JComboBox();
		cbxFrituras.addItem("");
		for (int i = 0; i < frituras.size(); i++) {
			cbxFrituras.addItem(frituras.get(i).getNombre());
		}
		cbxFrituras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frituras = daoProductos.getByTipo("frituras");
				if(cbxFrituras.getSelectedItem() == null) {
					return;
				}
				
				for (int i = 0; i < frituras.size(); i++) {
					if (cbxFrituras.getSelectedItem().toString()
							.equalsIgnoreCase(frituras.get(i).getNombre())) {
						mostrarProductos(frituras.get(i), 2);
						productoSeleccionado = frituras.get(i);
					}
				}
			}
		});

		cbxFrituras.setBounds(29, 387, 134, 23);
		add(cbxFrituras);

		dulces = daoProductos.getByTipo("dulces");
		cbxDulces = new JComboBox();
		cbxDulces.addItem("");
		for (int i = 0; i < dulces.size(); i++) {
			cbxDulces.addItem(dulces.get(i).getNombre());
		}
		cbxDulces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dulces = daoProductos.getByTipo("dulces");
				if(cbxDulces.getSelectedItem() == null) {
					return;
				}
				
				for (int i = 0; i < dulces.size(); i++) {
					if (cbxDulces.getSelectedItem().toString().equalsIgnoreCase(dulces.get(i).getNombre())) {
						mostrarProductos(dulces.get(i), 3);
						productoSeleccionado = dulces.get(i);
					}
				}
			}
		});
		cbxDulces.setBounds(29, 476, 135, 23);
		add(cbxDulces);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(334, 252, 134, 18);
		add(txtNombre);
		txtNombre.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(334, 310, 96, 18);
		add(txtPrecio);
		txtPrecio.setColumns(10);
		
		cbxTipo = new JComboBox();
		cbxTipo.setBounds(337, 370, 131, 23);
		cbxTipo.addItem("Bebidas");
		cbxTipo.addItem("Bolleria");
		cbxTipo.addItem("Frituras");
		cbxTipo.addItem("Dulces");
		add(cbxTipo);
		
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
		
		JLabel lblTipo = new JLabel("TIPO:");
		lblTipo.setBounds(269, 374, 44, 12);
		add(lblTipo);

		JLabel lblPrecio = new JLabel("PRECIO:");
		lblPrecio.setBounds(256, 313, 57, 12);
		add(lblPrecio);

		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setBounds(256, 255, 68, 12);
		add(lblNombre);
	}
	
	public void mostrarProductos(Producto producto, int tipo) {
		txtNombre.setText(producto.getNombre());
		txtPrecio.setText("" + producto.getPrecio());
		cbxTipo.setSelectedIndex(tipo);

	}
	

	
}
