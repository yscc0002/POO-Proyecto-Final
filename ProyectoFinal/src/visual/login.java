package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Controladora;
import logico.UserC;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2779150856989848125L;
	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPass;

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

				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(39, 39, 117, 14);
		panel.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(39, 98, 105, 14);
		panel.add(lblContrasea);

		txtUser = new JTextField();
		txtUser.setBounds(39, 64, 191, 20);
		panel.add(txtUser);
		txtUser.setColumns(10);

		txtPass = new JTextField();
		txtPass.setBounds(39, 128, 191, 20);
		panel.add(txtPass);
		txtPass.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Controladora.getInstance().confirmLogin(txtUser.getText(),txtPass.getText())){
					Principal principal = new Principal();
					dispose();
					principal.setVisible(true);
				};

			}
		});
		btnLogin.setBounds(37, 175, 89, 23);
		panel.add(btnLogin);
	}
}

