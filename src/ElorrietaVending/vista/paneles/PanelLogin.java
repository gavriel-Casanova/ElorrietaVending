package ElorrietaVending.vista.paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelLogin extends JPanel{
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
		btnIngreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIngreso.setBounds(164, 348, 84, 20);
		add(btnIngreso);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textUsuario;
	private JTextField textContraseña;
}
