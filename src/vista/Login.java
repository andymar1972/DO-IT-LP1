package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hilos.HiloCerrar;
import mantenimientos.GestionUsuario;
import model.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	public static JLabel lblTiempo;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setTitle("Inicio sesi\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 373);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblInicioDeSesin = new JLabel("Inicio De Sesi\u00F3n");
		lblInicioDeSesin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInicioDeSesin.setBounds(451, 58, 169, 44);
		contentPane.add(lblInicioDeSesin);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(428, 129, 232, 32);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(333, 133, 77, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContrasea.setBounds(333, 184, 100, 20);
		contentPane.add(lblContrasea);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(428, 180, 232, 32);
		contentPane.add(txtPassword);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validaAcceso();
			}
		});
		btnIngresar.setBounds(478, 245, 111, 32);
		contentPane.add(btnIngresar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/img/logo.jpg")));
		lblNewLabel_1.setBounds(37, 98, 252, 140);
		contentPane.add(lblNewLabel_1);
		
		lblTiempo = new JLabel("");
		lblTiempo.setForeground(new Color(255, 165, 0));
		lblTiempo.setBackground(SystemColor.menu);
		lblTiempo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTiempo.setBounds(236, 298, 232, 20);
		contentPane.add(lblTiempo);
		iniciaTiempo();
	}
	//public static String nombre,contra;
	void validaAcceso() {
		String usuario,contraseña;
		usuario=txtUsuario.getText();
		//nombre=usuario;
		contraseña=txtPassword.getText();
		//contra=contraseña;
		GestionUsuario gu=new GestionUsuario();
		Usuario u=gu.validaAcceso(usuario, contraseña);
		if(u==null) {
			JOptionPane.showMessageDialog(null,"Usuario o clave incorrecta");
		}else {
			JOptionPane.showMessageDialog(null,u.saludo());
			FrmPrincipal p=new FrmPrincipal();
			p.setVisible(true);
			p.setExtendedState(MAXIMIZED_BOTH);
			dispose();
		}
	}
	void iniciaTiempo() {
		HiloCerrar hilo=new HiloCerrar(Login.this);
		hilo.start();
	}
}
