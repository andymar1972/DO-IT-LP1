package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import interfaces.AlumnoInterface;
import model.Alumno;
import utils.MySQLConexion;

public class GestionAlumno implements AlumnoInterface {
	@Override
	public int Agregar(Alumno a) {
		int rs=0;
		Connection con=null;
		PreparedStatement pst =null;
		
		try {
			con= MySQLConexion.getConexion();
			String sql="INSERT INTO TB_ALUMNO VALUES(?,?,?,?,?,?,?,?,?,default)";
			pst =con.prepareStatement(sql);
			//parametros
			pst.setString(1, a.getDni());
			pst.setString(2,a.getNombre());
			pst.setString(3,a.getApellidoP());
			pst.setString(4,a.getApellidoM());
			pst.setString(5,a.getContraseña());
			pst.setString(6,a.getCelular());
			pst.setString(7, a.getTelefono());
			pst.setString(8,a.getCorreo());
			pst.setString(9,a.getFechaN());
			rs=pst.executeUpdate();
		}catch(Exception e) {
			System.out.print("Error en la sentencia" +e.getMessage());
		}finally {
			try {
			if(pst!=null) pst.close();
			if(con!=null) con.close();
			}
		catch(SQLException e) {
			System.out.print("Error al cerrar");
		}}
		return rs;
	}

	@Override
	public int eliminar(Alumno a) {
		int rs=0;
		Connection con=null;
		PreparedStatement pst =null;
		try {
			con=MySQLConexion.getConexion();
			String sql="delete TB_ALUMNO where DNI_ALUMNO=?;";
			pst=con.prepareStatement(sql);
			//parametros
			
			
			pst.setString(1, a.getDni());
			rs=pst.executeUpdate();
		}catch(Exception e) {
			System.out.print("Error en la sentencia ..." +e);
		}finally {
			try {
				if(pst!=null)
					pst.close();
				if(con!=null)
					con.close();
			}catch(SQLException e) {
				System.out.print("error al cerrar");
			}
		}
		return rs;
		
	}

	@Override
	public int modificar(Alumno a) {
		int rs=0;
		Connection con=null;
		PreparedStatement pst =null;
		try {
			con=MySQLConexion.getConexion();
			String sql="update TB_ALUMNO set NOMBRES_ALUMNO=?,APELLIDO_PATERNO=?, APELLIDO_MATERNO=?, CONTRASEÑA_ALUMNO=?,CELULAR_ALU_CONTACTO=?, FONO_ALU_CONTACTO=?,CORREO_ALU_CONTACTO=?,FECHA_NAC=?,ESTADO=? where DNI_ALUMNO=?;";
			pst=con.prepareStatement(sql);
			//parametros
			
			pst.setString(1,a.getNombre());
			pst.setString(2,a.getApellidoP());
			pst.setString(3,a.getApellidoM());
			pst.setString(4,a.getContraseña());
			pst.setString(5,a.getCelular());
			pst.setString(6, a.getTelefono());
			pst.setString(7,a.getCorreo());
			pst.setString(8,a.getFechaN());
			pst.setString(9,a.getEstado());
			pst.setString(10, a.getDni());
			rs=pst.executeUpdate();
		}catch(Exception e) {
			System.out.print("Error en la sentencia ..." +e);
		}finally {
			try {
				if(pst!=null)
					pst.close();
				if(con!=null)
					con.close();
			}catch(SQLException e) {
				System.out.print("error al cerrar");
			}
		}
		return rs;
	}
}
