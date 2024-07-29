package visual;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logico.Controladora; 
import logico.Cliente;

public class ActualizarClienteDialog extends JDialog {
    private static final long serialVersionUID = 1L;
    private JTextField txtNombre;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtEmail;
    private Cliente cliente;

    public ActualizarClienteDialog(Cliente cliente) {
        this.cliente = cliente;
        setTitle("Actualizar Cliente");
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new FlowLayout());
        
        panel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField(20);
        txtNombre.setText(cliente.getNombre());
        panel.add(txtNombre);

        panel.add(new JLabel("Direccion:"));
        txtDireccion = new JTextField(20);
        txtDireccion.setText(cliente.getDireccion());
        panel.add(txtDireccion);

        panel.add(new JLabel("Telefono:"));
        txtTelefono = new JTextField(20);
        txtTelefono.setText(cliente.getTelefono());
        panel.add(txtTelefono);

        panel.add(new JLabel("Email:"));
        txtEmail = new JTextField(20);
        txtEmail.setText(cliente.getEmail());
        panel.add(txtEmail);

        JPanel buttonPane = new JPanel();
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton btnSave = new JButton("Guardar");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cliente.setNombre(txtNombre.getText());
                cliente.setDireccion(txtDireccion.getText());
                cliente.setTelefono(txtTelefono.getText());
                cliente.setEmail(txtEmail.getText());

                Controladora.getInstance().actualizarCliente(cliente);
                dispose();
            }
        });
        buttonPane.add(btnSave);

        JButton btnCancel = new JButton("Cancelar");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonPane.add(btnCancel);
    }
    public static void setClienteSeleccionado(Cliente cliente) {
        //just in case
    }
}
