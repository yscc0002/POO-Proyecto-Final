package logico;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {

	public static void EnviarBackup() {
		try {
			Socket socket = new Socket("127.0.0.1", 7000);

			Controladora control = Controladora.getInstance();

			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(control);

			oos.close();
			socket.close();
			System.out.println("Copia de respaldo enviada exitosamente.");
			JOptionPane.showMessageDialog(null, "Respaldo enviado exitosamente", "Respaldo",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
