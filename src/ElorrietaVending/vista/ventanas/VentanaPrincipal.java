package ElorrietaVending.vista.ventanas;

import javax.swing.JFrame;

import ElorrietaVending.vista.paneles.PanelLogin;

public class VentanaPrincipal extends JFrame{
	public VentanaPrincipal() {
		setResizable(false);
		setSize(600, 800);
		PanelLogin panelLogin = new PanelLogin();
		add(panelLogin);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
