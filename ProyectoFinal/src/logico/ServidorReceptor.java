package logico;

import java.io.*;
import java.net.*;

public class ServidorReceptor {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(7000);
			System.out.println("Servidor listo para recibir conexiones...");

			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("Cliente conectado desde: " + socket.getInetAddress());

				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				Controladora control = (Controladora) ois.readObject();

				ois.close();
				socket.close();

				HacerBackup(control);
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void HacerBackup(Controladora control) {
		try {
			FileOutputStream fileOut = new FileOutputStream("Backup.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fileOut);
			oos.writeObject(control);
			oos.close();
			fileOut.close();
			System.out.println("Copia de respaldo  guardada exitosamente.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
