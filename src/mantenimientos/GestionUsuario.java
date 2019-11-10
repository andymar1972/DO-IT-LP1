package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfaces.UsuarioInterface;
import model.Usuario;
import utils.MySQLConexion;

public class GestionUsuario implements UsuarioInterface {

	@Override
	public Usuario validaAcceso(String usuario, String contraseña) {
		Usuario u=null;
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLConexion.getConexion();
			String sql="call usp_validaUsuario(?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, usuario);
			pst.setString(2, contraseña);
			rs=pst.executeQuery();
			while(rs.next()) {
				u=new Usuario();
				u.setCodUsuario(rs.getString(1));
				u.setContraseña(rs.getString(2));
				u.setPrimerNombre(rs.getString(3));
				u.setApellidoPaterno(rs.getString(5));
			}
		} catch (Exception e) {
			System.out.println("Error en la sentencia "+e.getMessage());
		}finally {
			try {
				if(pst!=null)pst.close();
				if(con!=null)con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar "+e.getMessage());
			}
		}
		return u;
	}
}
