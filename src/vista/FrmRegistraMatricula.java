package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class FrmRegistraMatricula extends JInternalFrame {
	private JTextField txtDni;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistraMatricula frame = new FrmRegistraMatricula();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public FrmRegistraMatricula() {
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		setBounds(100, 100, 651, 470);
		getContentPane().setLayout(null);
		
		txtDni = new JTextField();
		txtDni.setBounds(81, 46, 96, 20);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("DNI");
		lblNewLabel.setBounds(34, 49, 48, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(34, 82, 48, 14);
		getContentPane().add(lblNombres);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(81, 79, 96, 20);
		getContentPane().add(textField);
	}
}
