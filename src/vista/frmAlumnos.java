package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import com.toedter.calendar.JDateChooser;

import mantenimientos.GestionAlumno;
import mantenimientos.GestionUsuario;
import model.Alumno;
import utils.MySQLConexion;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class frmAlumnos extends JInternalFrame {
	
	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtNombres;
	private JTextField txtApPaterno;
	private JTextField txtContraseña;
	private JTextField txtCelular;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JDateChooser FechaNac;
	//tipo de operacion
	private int tipoOperacion;
	
	public final static int ADICIONAR=0;
	public final static int MODIFICAR=1;
	public final static int ELIMINAR=2;
	private JTextField txtMaterno;
	private JTextField txtEstado;
	private JTable tblRegistro;
	

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
		setClosable(true);
		setIconifiable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1179, 497);
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
		panel.setBounds(10, 52, 319, 339);
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
		
		JLabel lblApMaterno = new JLabel("Ap Materno");
		lblApMaterno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblApMaterno.setBounds(10, 125, 86, 19);
		panel.add(lblApMaterno);
		
		txtMaterno = new JTextField();
		txtMaterno.setColumns(10);
		txtMaterno.setBounds(113, 127, 184, 20);
		panel.add(txtMaterno);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(113, 310, 86, 20);
		panel.add(txtEstado);
		txtEstado.setColumns(10);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adicionar();
			}
		});

		btnNewButton.setBounds(30, 402, 118, 37);
		contentPane.add(btnNewButton);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Actualizar();
			}
		});
		btnModificar.setBounds(158, 402, 118, 37);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(289, 402, 118, 37);
		contentPane.add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(339, 64, 814, 302);
		contentPane.add(scrollPane);
		
		tblRegistro = new JTable();
		scrollPane.setViewportView(tblRegistro);
		 mostrar();
	}
	void mostrar() {
		MySQLConexion cc=new MySQLConexion();
		Connection con=MySQLConexion.getConexion();
		String[] titulos= {"DNI","Nombre","AplellidoP","ApellidoM","Contraseña","celular","telefono","correo","fechaN","estado"};
		String[] registros=new String[10];
		
		DefaultTableModel modelo =new DefaultTableModel(null,titulos);
		String sql ="select * from TB_ALUMNO";
		
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next()) {
				registros[0]=rs.getString("DNI_ALUMNO");
				registros[1]=rs.getString("NOMBRES_ALUMNO");
				registros[2]=rs.getString("APELLIDO_PATERNO");
				registros[3]=rs.getString("APELLIDO_MATERNO");
				registros[4]=rs.getString("CONTRASEÑA_ALUMNO");
				registros[5]=rs.getString("CELULAR_ALU_CONTACTO");
				registros[6]=rs.getString("FONO_ALU_CONTACTO");
				registros[7]=rs.getString("CORREO_ALU_CONTACTO");
				registros[8]=rs.getString("FECHA_NAC");
				registros[9]=rs.getString("ESTADO");
				modelo.addRow(registros);
			}
			tblRegistro.setModel(modelo);
			tblRegistro.getColumnModel().getColumn(0).setPreferredWidth(200);
			tblRegistro.getColumnModel().getColumn(1).setPreferredWidth(250);
			tblRegistro.getColumnModel().getColumn(2).setPreferredWidth(250);
			tblRegistro.getColumnModel().getColumn(3).setPreferredWidth(250);
			tblRegistro.getColumnModel().getColumn(4).setPreferredWidth(200);
			tblRegistro.getColumnModel().getColumn(5).setPreferredWidth(200);
			tblRegistro.getColumnModel().getColumn(6).setPreferredWidth(200);
			tblRegistro.getColumnModel().getColumn(7).setPreferredWidth(350);
			tblRegistro.getColumnModel().getColumn(8).setPreferredWidth(200);
			tblRegistro.getColumnModel().getColumn(9).setPreferredWidth(200);
		} catch (Exception e) {
			System.out.print("error al cargar " +e.getMessage());
		}
		
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
		mostrar();
		//intanciamos la clase gestion
		GestionAlumno ga=new GestionAlumno();
		int ok=ga.Agregar(a);
		if(ok==0) {
			System.out.print("Error");
		}else {
			System.out.print("Registro ok");
		}
	}
	
	void Actualizar() {
Alumno a=new Alumno();
		
		String dni,nombre,apellidoP,apellidoM,contraseña,
		celular,telefono,correo,estado,fechaN;
		//leendo
		dni=leerDni();
		nombre=leerNombre();
		apellidoP=leerApellioP();
		apellidoM=leerApellidoM();
		contraseña=leerContraseña();
		celular=leerCelular();
		telefono=leerTelefono();
		correo=leerCorreo();
		estado=leerestado();
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
		a.setEstado(estado);
		a.setFechaN(fechaN);
		//intanciamos la clase gestion
		GestionAlumno ga=new GestionAlumno();
		int ok=ga.modificar(a);
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
	String leerestado() {
		return txtEstado.getText();
	}
	String leerFecha() {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(FechaNac.getDate());
	}
}
