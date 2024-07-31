package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Controladora;
import logico.Factura;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ListFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable tblPrestamos;

	private String codSeleccion = "";
	private static DefaultTableModel modelo; // Modelo de la tabla
	private static Object row[]; // Carga datos de fila

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListFactura dialog = new ListFactura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListFactura() {
		setTitle("Listado de Facturas");
		setBounds(100, 100, 1077, 819);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pnlDeTrabajp = new JPanel();
			pnlDeTrabajp.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(pnlDeTrabajp, BorderLayout.CENTER);
			pnlDeTrabajp.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				pnlDeTrabajp.add(scrollPane, BorderLayout.CENTER);
				{
					modelo = new DefaultTableModel();
					tblPrestamos = new JTable();
					tblPrestamos.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int index = tblPrestamos.getSelectedRow();
							if(index>=0) {
								codSeleccion = new String(tblPrestamos.getValueAt(index, 0).toString());
							}
						}
					});
					String[] columnIdentifiers = {"ID Prestamo", "ID Cliente", "Marca", "Modelo", "Fecha de Facturacion"};
					modelo.setColumnIdentifiers(columnIdentifiers);
					tblPrestamos.setModel(modelo);
					tblPrestamos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(tblPrestamos);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadTableFacturas();
	}




	public static void loadTableFacturas() {
		ArrayList<Factura> tempFacturas = Controladora.getInstance().getLasFacturas();
		modelo.setRowCount(0);
		row = new Object[tblPrestamos.getColumnCount()];
		for(Factura tempFactura : tempFacturas) {
			row[0] = tempFactura.getIdFactura();
			row[1] = tempFactura.getIdCliente();
			row[2] = tempFactura.getComponente().getMarca();
			row[3] = tempFactura.getComponente().getModelo();
			row[4] = tempFactura.getFechaFacturacion();
			modelo.addRow(row);
		}
	}

}
