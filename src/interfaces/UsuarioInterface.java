package interfaces;
import model.Alumno;
import model.Usuario;

public interface UsuarioInterface{
	public Usuario validaAcceso(String usuario,String contrase�a);
	public Usuario actualizaPerfil(Usuario u);
	public int Agregar(Alumno a);
}
