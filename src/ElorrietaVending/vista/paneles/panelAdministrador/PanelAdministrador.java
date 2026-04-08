package ElorrietaVending.vista.paneles.panelAdministrador;

import javax.swing.JPanel;

import ElorrietaVending.vista.ventanas.VentanaPrincipal;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class PanelAdministrador extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTipoUno;
	private JTextField txtTipoDos;
	private JTextField txtTipoTres;
	private JTextField txtTipoCuatro;
	private JTextField textFieldCbxNombre;
	private JTextField textField_1CbxPrecio;
	
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
		
		JComboBox comboBoxCbxBebidas = new JComboBox();
		comboBoxCbxBebidas.setToolTipText("");
		comboBoxCbxBebidas.setBounds(30, 186, 134, 23);
		add(comboBoxCbxBebidas);
		
		JComboBox comboBox_1CbxBolleria = new JComboBox();
		comboBox_1CbxBolleria.setBounds(30, 277, 134, 23);
		add(comboBox_1CbxBolleria);
		
		JComboBox comboBox_2CbxFrituras = new JComboBox();
		comboBox_2CbxFrituras.setBounds(29, 387, 134, 23);
		add(comboBox_2CbxFrituras);
		
		txtTipoUno = new JTextField();
		txtTipoUno.setText("BEBIDAS");
		txtTipoUno.setBounds(59, 154, 59, 22);
		add(txtTipoUno);
		txtTipoUno.setColumns(10);
		
		JComboBox comboBox_3CbxDulces = new JComboBox();
		comboBox_3CbxDulces.setBounds(29, 476, 135, 23);
		add(comboBox_3CbxDulces);
		
		txtTipoDos = new JTextField();
		txtTipoDos.setText("BOLLERIA");
		txtTipoDos.setBounds(66, 249, 52, 18);
		add(txtTipoDos);
		txtTipoDos.setColumns(10);
		
		txtTipoTres = new JTextField();
		txtTipoTres.setText("FRITURAS");
		txtTipoTres.setBounds(59, 359, 59, 18);
		add(txtTipoTres);
		txtTipoTres.setColumns(10);
		
		txtTipoCuatro = new JTextField();
		txtTipoCuatro.setText("DULCES");
		txtTipoCuatro.setBounds(59, 452, 59, 14);
		add(txtTipoCuatro);
		txtTipoCuatro.setColumns(10);
		
		JButton btnGuardar = new JButton("GUARDAR");
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
		lblNombre.setBounds(269, 255, 44, 12);
		add(lblNombre);
		
		textFieldCbxNombre = new JTextField();
		textFieldCbxNombre.setBounds(334, 252, 96, 18);
		add(textFieldCbxNombre);
		textFieldCbxNombre.setColumns(10);
		
		textField_1CbxPrecio = new JTextField();
		textField_1CbxPrecio.setBounds(334, 310, 96, 18);
		add(textField_1CbxPrecio);
		textField_1CbxPrecio.setColumns(10);
		
		JComboBox comboBoxCbxTipo = new JComboBox();
		comboBoxCbxTipo.setBounds(337, 370, 102, 23);
		add(comboBoxCbxTipo);
		
		
	}
}
