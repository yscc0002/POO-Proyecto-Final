package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import logico.Controladora;
import logico.UserC;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	static Socket sfd = null;
	static DataInputStream EntradaSocket;
	static DataOutputStream SalidaSocket;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream tienda;
				FileOutputStream tienda2;
				ObjectInputStream tiendaRead;
				ObjectOutputStream tiendaWrite;
				try {
					tienda = new FileInputStream ("tienda.dat");
					tiendaRead = new ObjectInputStream(tienda);
					Controladora temp = (Controladora)tiendaRead.readObject();
					Controladora.setControladora(temp);
					tienda.close();
					tiendaRead.close();
				} catch (FileNotFoundException e) {
					try {
						tienda2 = new  FileOutputStream("tienda.dat");
						tiendaWrite = new ObjectOutputStream(tienda2);
						UserC aux = new UserC("Administrador", "admin", "admin");
						Controladora.getInstance().regUser(aux);
						tiendaWrite.writeObject(Controladora.getInstance());
						tienda2.close();
						tiendaWrite.close();
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {


				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				//


				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {


		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try (FileOutputStream tienda2 = new FileOutputStream("tienda.dat");
						ObjectOutputStream tiendaWrite = new ObjectOutputStream(tienda2)) {
					if (Controladora.getInstance() != null) {
						tiendaWrite.writeObject(Controladora.getInstance());
						System.out.println("Objeto guardado en el archivo.");
					} else {
						System.out.println("La instancia de Controladora es null.");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});


		///////
		setTitle("Tienda de Computacion Alonso y Asociado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 631);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Componente");
		menuBar.add(mnNewMenu);

		JMenuItem itemRegistroComponente = new JMenuItem("Registro");
		itemRegistroComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegComponente regComponente = new RegComponente(null);
				regComponente.setModal(true);
				regComponente.setVisible(true);
			}
		});
		mnNewMenu.add(itemRegistroComponente);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listado");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListComponente listComponente = new ListComponente();
				listComponente.setModal(true);
				listComponente.setVisible(true);
			}

		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_2 = new JMenu("Ventas");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem = new JMenuItem("Facturar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegFactura regFactura = new RegFactura();
				regFactura.setModal(true);
				regFactura.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Consultar Factura");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListFactura listFactura = new ListFactura();
				listFactura.setModal(true);
				listFactura.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);

		JMenu mnNewMenu_3 = new JMenu("Cliente");
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Registro");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroCliente registroCliente = new RegistroCliente(null);
				registroCliente.setModal(true);
				registroCliente.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Listado");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarClientes listarClientes = new ListarClientes(true);
				listarClientes.setModal(true);
				listarClientes.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_4);

		JMenu mnNewMenu_4 = new JMenu("Tienda");
		menuBar.add(mnNewMenu_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Guardar");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// Guarda el objeto en un archivo
					try (FileOutputStream tienda2 = new FileOutputStream("C:\\tempFiles\\tienda.dat");
							ObjectOutputStream tiendaWrite = new ObjectOutputStream(tienda2)) {
						tiendaWrite.writeObject(Controladora.getInstance());
					} catch (IOException ex) {
						ex.printStackTrace();
					}

					// Envía el objeto a través del socket
					try (Socket socket = new Socket("127.0.0.1", 7000);
							ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {
						oos.writeObject(Controladora.getInstance());
						oos.flush();
						System.out.println("Objeto enviado");
					} catch (IOException ex) {
						System.out.println("Error al enviar el objeto: " + ex.getMessage());
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnlDeTrabajo = new JPanel();
		contentPane.add(pnlDeTrabajo, BorderLayout.CENTER);
		pnlDeTrabajo.setLayout(new BorderLayout(0, 0));
	}

}
