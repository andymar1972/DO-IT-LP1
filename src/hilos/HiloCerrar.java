package hilos;
import javax.swing.JFrame;
import vista.Login;

public class HiloCerrar extends Thread {
	private JFrame ventana;
	public HiloCerrar(JFrame ventana) {
		this.ventana=ventana;
	}
	public void run() {
		for (int i = 5; i >= 0; i--) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
		for (int i = 10; i >= 0; i--) {
			Login.lblTiempo.setText("Esta ventana se cerrara en "+i+"s");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
		ventana.dispose();
	}
}
