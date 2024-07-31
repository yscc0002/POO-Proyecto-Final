package servidor;

import java.io.*;
import java.net.*;

import logico.Controladora;

public class ServidorReal extends Thread {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            System.out.println("Iniciando Conexion");
            serverSocket = new ServerSocket(7000);
            System.out.println("Aceptando conexiones por la IP: " + serverSocket.getInetAddress());
        } catch (IOException ioe) {
            System.out.println("Comunicación rechazada." + ioe);
            System.exit(1);
        }

        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Conexión aceptada de: " + clientSocket.getInetAddress());

                // Flujos para recibir el objeto enviado por el cliente
                try (ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream())) {
                    // Lee el objeto recibido
                    Object obj = ois.readObject();
                    
                    // Verifica que el objeto sea una instancia de Controladora
                    if (obj instanceof Controladora) {
                        Controladora controladora = (Controladora) obj;
                        // Procesa el objeto según sea necesario
                        System.out.println("Objeto recibido: " + controladora);
                    } else {
                        System.out.println("El objeto recibido no es una instancia de Controladora");
                    }
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Error al recibir el objeto: " + e.getMessage());
                }
                
            } catch (IOException ioe) {
                System.out.println("Error en la conexión: " + ioe);
            }
        }
    }
}
