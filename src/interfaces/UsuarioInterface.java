package interfaces;
import model.Usuario;

public interface UsuarioInterface{
	public Usuario validaAcceso(String usuario,String contraseña);
	public Usuario actualizaPerfil(Usuario u);
}
