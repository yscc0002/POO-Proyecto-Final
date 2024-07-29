package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import logico.Controladora;
import logico.Cliente;

public class ListarClientes extends JDialog {
    private static final long serialVersionUID = 1L;

    private final JPanel contentPanel = new JPanel();
    private static JTable table;
    private static DefaultTableModel tableModel;
    private static Object row[];
    private static JButton updateBtn = new JButton("Actualizar");
    private static JButton deleteBtn = new JButton("Eliminar");
    private static JButton selectBtn = new JButton("Seleccionar");
    private JPanel buttonPane = new JPanel();
    private static String selectedClienteId = "";

    public static void main(String[] args) {
        try {
            ListarClientes dialog = new ListarClientes(false);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ListarClientes(Boolean retornarCliente) {
        setResizable(false);
        setBounds(100, 100, 725, 474);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPanel.add(panel);
        panel.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panel.add(scrollPane, BorderLayout.CENTER);

        tableModel = new DefaultTableModel();
        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    selectedClienteId = table.getValueAt(selectedRow, 0).toString();
                    deleteBtn.setEnabled(true);
                    updateBtn.setEnabled(true);
                    selectBtn.setEnabled(true);
                }
            }
        });
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        String[] headers = {"ID", "Nombre", "Direccion", "Telefono", "Email"};
        tableModel.setColumnIdentifiers(headers);
        table.setModel(tableModel);
        scrollPane.setViewportView(table);

        renderButtons(retornarCliente);
        renderClientes();

        getContentPane().add(buttonPane, BorderLayout.SOUTH);
    }

    public void renderButtons(Boolean retornarCliente) {
        buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));

        if (retornarCliente != null && retornarCliente) {
            selectBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!selectedClienteId.isEmpty()) {
                        Cliente cliente = Controladora.getInstance().buscarClientePorId(selectedClienteId);
                        ActualizarClienteDialog.setClienteSeleccionado(cliente);
                        dispose();
                    }
                }
            });
            buttonPane.add(selectBtn);
        } else {
            updateBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!selectedClienteId.isEmpty()) {
                        Cliente cliente = Controladora.getInstance().buscarClientePorId(selectedClienteId);
                        if (cliente != null) {
                            ActualizarClienteDialog updateClienteDialog = new ActualizarClienteDialog(cliente);
                            updateClienteDialog.setModal(true);
                            updateClienteDialog.setVisible(true);
                        }
                    }
                }
            });
            updateBtn.setEnabled(false);
            updateBtn.setActionCommand("OK");
            buttonPane.add(updateBtn);
            getRootPane().setDefaultButton(updateBtn);

            deleteBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!selectedClienteId.isEmpty()) {
                        int option = JOptionPane.showConfirmDialog(null, "Seguro desea eliminar este cliente con codigo: " + selectedClienteId, "Confirmacion", JOptionPane.WARNING_MESSAGE);
                        if (option == JOptionPane.YES_OPTION) {
                            Controladora.getInstance().getLosClientes().removeIf(cliente -> cliente.getIdCliente().equals(selectedClienteId));
                            deleteBtn.setEnabled(false);
                            renderClientes();
                        }
                    }
                }
            });
            deleteBtn.setEnabled(false);
            buttonPane.add(deleteBtn);
        }

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonPane.add(cancelButton);
    }

    public static void renderClientes() {
        ArrayList<Cliente> clientes = Controladora.getInstance().getLosClientes();
        tableModel.setRowCount(0);
        row = new Object[table.getColumnCount()];
        for (Cliente cliente : clientes) {
            row[0] = cliente.getIdCliente();
            row[1] = cliente.getNombre();
            row[2] = cliente.getDireccion();
            row[3] = cliente.getTelefono();
            row[4] = cliente.getEmail();
            tableModel.addRow(row);
        }
        deleteBtn.setEnabled(false);
        updateBtn.setEnabled(false);
        selectBtn.setEnabled(false);
        selectedClienteId = "";
    }
}
