package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

import mantenimientos.GestionUsuario;
import model.Usuario;

import com.toedter.calendar.JMonthChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmConfigurarPerfil extends JInternalFrame {
	private JTextField txtNombres;
	private JTextField txtApellidoPaterno;
	private JTextField txtApellidoMaterno;
	private JDateChooser txtFecha;
	private JTextField txtUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConfigurarPerfil frame = new FrmConfigurarPerfil();
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
	public FrmConfigurarPerfil() {
		setTitle("Configurar Perfil");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 369, 337);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Personales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(153, 180, 209)));
		panel.setBounds(10, 11, 336, 221);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombres");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 36, 94, 22);
		panel.add(lblNewLabel);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(134, 38, 189, 20);
		panel.add(txtNombres);
		txtNombres.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellido Paterno");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApellidos.setBounds(10, 103, 114, 22);
		panel.add(lblApellidos);
		
		txtApellidoPaterno = new JTextField();
		txtApellidoPaterno.setColumns(10);
		txtApellidoPaterno.setBounds(134, 105, 189, 20);
		panel.add(txtApellidoPaterno);
		
		txtApellidoMaterno = new JTextField();
		txtApellidoMaterno.setColumns(10);
		txtApellidoMaterno.setBounds(134, 138, 189, 20);
		panel.add(txtApellidoMaterno);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno");
		lblApellidoMaterno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApellidoMaterno.setBounds(10, 136, 114, 22);
		panel.add(lblApellidoMaterno);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaNacimiento.setBounds(10, 177, 101, 22);
		panel.add(lblFechaNacimiento);
		
		txtFecha = new JDateChooser();
		txtFecha.setBounds(134, 177, 189, 20);
		panel.add(txtFecha);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsuario.setBounds(10, 69, 94, 22);
		panel.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setText((String) null);
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(134, 71, 189, 20);
		panel.add(txtUsuario);
		
		JButton btnNewButton = new JButton("holo");
		btnNewButton.setBounds(122, 243, 114, 43);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(leerFecha());
			}
		});
		listarPerfil();
	}
	void listarPerfil() {
		Usuario u=new Usuario();
		GestionUsuario gu=new GestionUsuario();
		u=gu.validaAcceso(u.getCodUsuario(),u.getContraseña());
		txtNombres.setText(u.getNombresUsuario());
		txtUsuario.setText(u.getCodUsuario());
		txtApellidoPaterno.setText(u.getApellidoPaterno());
		txtApellidoMaterno.setText(u.getApellidoMaterno());
		txtFecha.setDateFormatString("yyyy-MM-dd");
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(u.getFechaNacimiento());
			txtFecha.setDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void cambiarPerfil() {
		String nombres,usuario,apellidoPaterno,apellidoMaterno,fecha;
		nombres=leerNombres();
		usuario=leerUsuario();
		apellidoPaterno=leerApellidoPaterno();
		apellidoMaterno=leerApellidoMaterno();
		fecha=leerFecha();
	}
	String leerNombres() {
		return txtNombres.getText();
	}
	String leerUsuario() {
		return txtUsuario.getText();
	}
	String leerApellidoPaterno() {
		return txtApellidoPaterno.getText();
	}
	String leerApellidoMaterno() {
		return txtApellidoMaterno.getText();
	}
	String leerFecha() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(txtFecha.getDate());
	}
}
