package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logico.Cliente;
import logico.Controladora;

public class RegistroCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldId;
	private JTextField textFieldNombre;
	private JTextField textFieldDireccion;
	private JTextField textFieldTelefono;
	private JTextField textFieldEmail;
	private JTextField textFieldProvincia;
	private JTextField textFieldPais;
	private JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroCliente dialog = new RegistroCliente(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroCliente(Cliente cliente) {
		setTitle("Cliente");
		setResizable(false);
		setBounds(100, 100, 470, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			panel.setBounds(0, 0, 464, 320);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				textFieldId = new JTextField();
				textFieldId.setEnabled(false);
				textFieldId.setEditable(false);
				textFieldId.setText(generateID());
				textFieldId.setBounds(90, 13, 70, 22);
				panel.add(textFieldId);
				textFieldId.setColumns(10);
			}

			JLabel idLabel = new JLabel("ID:");
			idLabel.setBounds(12, 16, 49, 16);
			panel.add(idLabel);

			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(12, 51, 64, 16);
			panel.add(lblNombre);

			textFieldNombre = new JTextField();
			textFieldNombre.setColumns(10);
			textFieldNombre.setBounds(90, 48, 186, 22);
			panel.add(textFieldNombre);

			JLabel lblDireccion = new JLabel("Direccion:");
			lblDireccion.setBounds(12, 91, 64, 16);
			panel.add(lblDireccion);

			textFieldDireccion = new JTextField();
			textFieldDireccion.setColumns(10);
			textFieldDireccion.setBounds(90, 88, 186, 22);
			panel.add(textFieldDireccion);

			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setBounds(12, 131, 64, 16);
			panel.add(lblTelefono);

			textFieldTelefono = new JTextField();
			textFieldTelefono.setColumns(10);
			textFieldTelefono.setBounds(90, 128, 186, 22);
			panel.add(textFieldTelefono);

			JLabel lblEmail = new JLabel("Email:");
			lblEmail.setBounds(12, 171, 64, 16);
			panel.add(lblEmail);

			textFieldEmail = new JTextField();
			textFieldEmail.setColumns(10);
			textFieldEmail.setBounds(90, 168, 186, 22);
			panel.add(textFieldEmail);

			JLabel lblProvincia = new JLabel("Provincia:");
			lblProvincia.setBounds(12, 211, 64, 16);
			panel.add(lblProvincia);

			textFieldProvincia = new JTextField();
			textFieldProvincia.setColumns(10);
			textFieldProvincia.setBounds(90, 208, 186, 22);
			panel.add(textFieldProvincia);

			JLabel lblPais = new JLabel("Pais:");
			lblPais.setBounds(12, 251, 64, 16);
			panel.add(lblPais);

			textFieldPais = new JTextField();
			textFieldPais.setColumns(10);
			textFieldPais.setBounds(90, 248, 186, 22);
			panel.add(textFieldPais);

			initializeFields(cliente);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Agregar");
				if (cliente != null)
					okButton.setText("Actualizar");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!validateFields()) {
							return;
						}

						if (cliente == null) {
							boolean logrado = addCliente();
							if (logrado) {
								JOptionPane.showMessageDialog(null, "Se ha agregado el cliente exitosamente.", "Registro", JOptionPane.INFORMATION_MESSAGE);
								resetFields();
							} else {
								JOptionPane.showMessageDialog(null, "Algo salio mal.", "Error", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							if (updateCliente()) {
								JOptionPane.showMessageDialog(null, "Se ha actualizado el cliente exitosamente.", "Registro", JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null, "Algo salio mal.", "Error", JOptionPane.ERROR_MESSAGE);
							}
							dispose();
						}
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private boolean validateFields() {
		if (textFieldNombre.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "El campo Nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (textFieldDireccion.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "El campo Direccion no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (textFieldTelefono.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "El campo Telefono no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (textFieldEmail.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "El campo Email no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (textFieldProvincia.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "El campo Provincia no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (textFieldPais.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "El campo Pais no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	private void initializeFields(Cliente cliente) {
		if (cliente == null)
			return;

		textFieldId.setText(cliente.getIdCliente());
		textFieldNombre.setText(cliente.getNombre());
		textFieldDireccion.setText(cliente.getDireccion());
		textFieldTelefono.setText(cliente.getTelefono());
		textFieldEmail.setText(cliente.getEmail());
		textFieldProvincia.setText(cliente.getProvincia());
		textFieldPais.setText(cliente.getPais());
	}

	private boolean addCliente() {
		String id = textFieldId.getText();
		String nombre = textFieldNombre.getText();
		String direccion = textFieldDireccion.getText();
		String telefono = textFieldTelefono.getText();
		String email = textFieldEmail.getText();
		String provincia = textFieldProvincia.getText();
		String pais = textFieldPais.getText();

		Cliente cliente = new Cliente(id, nombre, direccion, telefono, email, provincia, pais);
		return Controladora.getInstance().getLosClientes().add(cliente);
	}

	private boolean updateCliente() {
		String id = textFieldId.getText();
		String nombre = textFieldNombre.getText();
		String direccion = textFieldDireccion.getText();
		String telefono = textFieldTelefono.getText();
		String email = textFieldEmail.getText();
		String provincia = textFieldProvincia.getText();
		String pais = textFieldPais.getText();

		Cliente cliente = new Cliente(id, nombre, direccion, telefono, email, provincia, pais);
		// Encuentra el cliente en la lista y actualiza sus datos
		for (int i = 0; i < Controladora.getInstance().getLosClientes().size(); i++) {
			if (Controladora.getInstance().getLosClientes().get(i).getIdCliente().equals(id)) {
				Controladora.getInstance().getLosClientes().set(i, cliente);
				return true;
			}
		}
		return false;
	}

	private void resetFields() {
		textFieldId.setText(generateID());
		textFieldNombre.setText("");
		textFieldDireccion.setText("");
		textFieldTelefono.setText("");
		textFieldEmail.setText("");
		textFieldProvincia.setText("");
		textFieldPais.setText("");
	}

	private String generateID() {
		return UUID.randomUUID().toString();
	}

}
