package interfaces;
import model.Alumno;
import model.Usuario;

public interface UsuarioInterface{
	public Usuario validaAcceso(String usuario,String contraseña);
	public int actualizaPerfil(Usuario u);
}
