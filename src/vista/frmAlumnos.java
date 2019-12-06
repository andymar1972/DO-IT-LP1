package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import com.toedter.calendar.JDateChooser;

import mantenimientos.GestionUsuario;
import model.Alumno;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class frmAlumnos extends JFrame {
	
	
//nel
	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtNombres;
	private JTextField txtApPaterno;
	private JTextField txtContraseña;
	private JTextField txtCelular;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JDateChooser FechaNac;
	private JComboBox cboEstado;
	private JTable table;
	//tipo de operacion
	private int tipoOperacion;
	
	public final static int ADICIONAR=0;
	public final static int MODIFICAR=1;
	public final static int ELIMINAR=2;
	private JTextField txtMaterno;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAlumnos frame = new frmAlumnos();
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
	public frmAlumnos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1075, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMantenimientoDeAlumnos = new JLabel("Mantenimiento de Alumnos");
		lblMantenimientoDeAlumnos.setFont(new Font("Tahoma", Font.ITALIC, 24));
		lblMantenimientoDeAlumnos.setBounds(289, 11, 325, 42);
		contentPane.add(lblMantenimientoDeAlumnos);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 52, 362, 339);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDni.setBounds(10, 34, 46, 14);
		panel.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(113, 33, 86, 20);
		panel.add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombres.setBounds(10, 65, 86, 19);
		panel.add(lblNombres);
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(113, 64, 184, 20);
		panel.add(txtNombres);
		
		JLabel lblApPaterno = new JLabel("Ap Paterno");
		lblApPaterno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblApPaterno.setBounds(10, 95, 86, 19);
		panel.add(lblApPaterno);
		
		txtApPaterno = new JTextField();
		txtApPaterno.setBounds(113, 95, 184, 20);
		panel.add(txtApPaterno);
		txtApPaterno.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContrasea.setBounds(10, 159, 86, 19);
		panel.add(lblContrasea);
		
		txtContraseña = new JTextField();
		txtContraseña.setBounds(113, 158, 86, 20);
		panel.add(txtContraseña);
		txtContraseña.setColumns(10);
		
		JLabel lblNumero = new JLabel("Contacto CEL");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumero.setBounds(10, 189, 105, 19);
		panel.add(lblNumero);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(113, 188, 86, 20);
		panel.add(txtCelular);
		txtCelular.setColumns(10);
		
		JLabel lblContactoFono = new JLabel("Contacto Fono");
		lblContactoFono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContactoFono.setBounds(10, 219, 105, 19);
		panel.add(lblContactoFono);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(113, 220, 86, 20);
		panel.add(txtTelefono);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCorreo.setBounds(10, 249, 105, 19);
		panel.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(113, 250, 184, 20);
		panel.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JLabel lblFechaNac = new JLabel("Fecha Naca");
		lblFechaNac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFechaNac.setBounds(10, 279, 105, 19);
		panel.add(lblFechaNac);
		
		FechaNac = new JDateChooser();
		FechaNac.setBounds(113, 278, 95, 20);
		panel.add(FechaNac);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEstado.setBounds(10, 309, 105, 19);
		panel.add(lblEstado);
		
		cboEstado = new JComboBox();
		cboEstado.setBounds(113, 310, 95, 20);
		panel.add(cboEstado);
		
		JLabel lblApMaterno = new JLabel("Ap Materno");
		lblApMaterno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblApMaterno.setBounds(10, 125, 86, 19);
		panel.add(lblApMaterno);
		
		txtMaterno = new JTextField();
		txtMaterno.setColumns(10);
		txtMaterno.setBounds(113, 127, 184, 20);
		panel.add(txtMaterno);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(382, 58, 667, 306);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DNI", "Nombres", "Ap Paterno", "Contrase\u00F1a", "Celular", "Telefono", "Correo", "Fecha", "Estado"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				habilitarEntradas(true);
			}
		});
		btnNewButton.setBounds(53, 402, 118, 37);
		contentPane.add(btnNewButton);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(181, 402, 118, 37);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(309, 402, 118, 37);
		contentPane.add(btnEliminar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			   switch(tipoOperacion) {
			   case ADICIONAR:
				   adicionar();
				   break;
			   }
			}
		});
		btnAceptar.setBounds(629, 380, 118, 37);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(785, 380, 118, 37);
		contentPane.add(btnCancelar);
	}
	
	void habilitarEntradas(boolean sino) {
		txtDni.setEditable(sino);
		txtNombres.setEditable(sino);
		txtApPaterno.setEditable(sino);
		txtMaterno.setEditable(sino);
		txtContraseña.setEditable(sino);
		txtCelular.setEditable(sino);
		txtTelefono.setEditable(sino);
		txtCorreo.setEditable(sino);
	}
	void adicionar(){
		Alumno a=new Alumno();
		Date date;
		String dni,nombre,apellidoP,apellidoM,contraseña,
		celular,telefono,correo,fechaN;
		//leendo
		dni=leerDni();
		nombre=leerNombre();
		apellidoP=leerApellioP();
		apellidoM=leerApellidoM();
		contraseña=leerContraseña();
		celular=leerCelular();
		telefono=leerTelefono();
		correo=leerCorreo();
		fechaN=leerFecha();
		//intanciamos alumnos
		a.setDni(dni);
		a.setNombre(nombre);
		a.setApellidoP(apellidoP);
		a.setApellidoM(apellidoM);
		a.setContraseña(contraseña);
		a.setCelular(celular);
		a.setTelefono(telefono);
		a.setCorreo(correo);
		a.setFechaN(fechaN);
		//intanciamos la clase gestion
		GestionUsuario gu=new GestionUsuario();
		int ok=gu.Agregar(a);
		if(ok==0) {
			System.out.print("Error");
		}else {
			System.out.print("Registro ok");
		}
	}
	
	String leerDni() {
		return txtDni.getText();
	}
	String leerNombre() {
		return txtNombres.getText();
	}
	String leerApellioP() {
		return txtApPaterno.getText();
	}
	String leerApellidoM() {
		return txtMaterno.getText();
	}
	String leerContraseña() {
		return txtContraseña.getText();
	}
	String leerCelular() {
		return txtCelular.getText();
	}
	String leerTelefono() {
		return txtTelefono.getText();
	}
	String leerCorreo() {
		return txtCorreo.getText();
	}
	String leerFecha() {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(FechaNac.getDate());
	}
}
