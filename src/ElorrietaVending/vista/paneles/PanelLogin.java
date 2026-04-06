package ElorrietaVending.vista.paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ElorrietaVending.controlador.Controlador;
import ElorrietaVending.modelo.entidades.Persona;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelLogin extends JPanel {
	public PanelLogin() {
		setSize(598, 798);
		setLayout(null);

		JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setBounds(77, 172, 72, 25);
		add(lblUsuario);

		JLabel lblNewLabel = new JLabel("CONTRASEÑA:");
		lblNewLabel.setBounds(77, 240, 72, 25);
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

		JButton btnIngreso = new JButton("Click");
		btnIngreso.setBounds(164, 348, 84, 20);
		btnIngreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador controlador = new Controlador();

				String usuario = textUsuario.getText();
				String contraseña = textContraseña.getText();
				Persona persona = controlador.validarLogin(usuario, contraseña);
				
				if(persona == null) {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				System.out.println(persona);
			}
		});

		add(btnIngreso);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textUsuario;
	private JTextField textContraseña;
}
