package interfaces;
import model.Alumno;
import model.Usuario;

public interface UsuarioInterface{
	public Usuario validaAcceso(String usuario,String contrase�a);
	public int actualizaPerfil(Usuario u);
}
