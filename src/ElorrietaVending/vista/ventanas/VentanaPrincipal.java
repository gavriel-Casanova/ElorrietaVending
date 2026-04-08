package ElorrietaVending.vista.ventanas;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ElorrietaVending.vista.paneles.PanelLogin;
import ElorrietaVending.vista.paneles.panelAdministrador.PanelAdministrador;

public class VentanaPrincipal extends JFrame {
	private ArrayList<JPanel> paneles = new ArrayList<JPanel>();
 
	public VentanaPrincipal() {
		setResizable(false);
		setSize(600, 800);
		PanelLogin panelLogin = new PanelLogin(this);
		add(panelLogin);
		paneles.add(panelLogin);
		PanelAdministrador panelAdministrador = new PanelAdministrador(this);
		paneles.add(panelAdministrador);
	}

	public void hacerVisible() {
		setVisible(true);
	}
	public void cambiarPanel(int posicion) {
		setContentPane(paneles.get(posicion));
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
