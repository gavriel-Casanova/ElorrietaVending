package ElorrietaVending.vista.paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import ElorrietaVending.controlador.Controlador;
import ElorrietaVending.modelo.entidades.Persona;
import ElorrietaVending.modelo.entidades.Personas.Administrador;
import ElorrietaVending.modelo.entidades.Personas.Cliente;
import ElorrietaVending.vista.ventanas.VentanaPrincipal;

public class PanelLogin extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textUsuario;
	private JTextField textContraseña;
	
	public PanelLogin(VentanaPrincipal ventana ) {
		setSize(598, 798);
		setLayout(null);

		JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setBounds(77, 172, 72, 25);
		add(lblUsuario);

		JLabel lblNewLabel = new JLabel("CONTRASEÑA:");
		lblNewLabel.setBounds(58, 240, 105, 25);
		add(lblNewLabel);

		textUsuario = new JTextField();
		textUsuario.setText("Ingrese usuario");
		textUsuario.setBounds(192, 175, 130, 18);
		add(textUsuario);
		textUsuario.setColumns(10);

		textContraseña = new JTextField();
		textContraseña.setText("Ingrese contraseña");
		textContraseña.setBounds(192, 240, 141, 18);
		add(textContraseña);
		textContraseña.setColumns(10);

		JButton btnIngreso = new JButton("Login");
		btnIngreso.setBounds(105, 305, 141, 38);
		btnIngreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador controlador = new Controlador();

				String usuario = textUsuario.getText();
				String contraseña = textContraseña.getText();
				Persona persona = controlador.validarLogin(usuario, contraseña);

				if (persona == null) {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta", "Error",
							JOptionPane.ERROR_MESSAGE);
				}else if(persona instanceof Administrador ) {
					ventana.cambiarPanel(1);
				}else if(persona instanceof Cliente ) {
					ventana.cambiarPanel(2);
				}

				System.out.println(persona);
				vaciarCamposText();
			}
		});

		add(btnIngreso);
	}
	
	public void vaciarCamposText() {
		textUsuario.setText("");
		textContraseña.setText("");
	}
	

	
}
