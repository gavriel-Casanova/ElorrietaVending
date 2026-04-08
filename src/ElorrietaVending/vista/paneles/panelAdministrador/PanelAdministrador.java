package ElorrietaVending.vista.paneles.panelAdministrador;

import javax.swing.JPanel;

import ElorrietaVending.vista.ventanas.VentanaPrincipal;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAdministrador extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
		
		
	}
}
