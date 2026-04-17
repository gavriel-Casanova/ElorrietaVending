package ElorrietaVending.vista.ventanas;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ElorrietaVending.vista.paneles.PanelLogin;
import ElorrietaVending.vista.paneles.panelAdministrador.PanelAdministrador;
import ElorrietaVending.vista.paneles.panelCliente.PanelCliente;

public class VentanaPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<JPanel> paneles = new ArrayList<JPanel>();
 
	public VentanaPrincipal() {
		setResizable(false);
		setSize(600, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		PanelLogin panelLogin = new PanelLogin(this);
		add(panelLogin);
		paneles.add(panelLogin);
		PanelAdministrador panelAdministrador = new PanelAdministrador(this);
		paneles.add(panelAdministrador);
		PanelCliente panelCliente = new PanelCliente(this);
		paneles.add(panelCliente);
	}

	public void hacerVisible() {
		setVisible(true);
	}
	public void cambiarPanel(int posicion) {
		setContentPane(paneles.get(posicion));
	}

	

}
