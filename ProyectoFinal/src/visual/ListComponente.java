package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import logico.Cliente;
import logico.Componente;
import logico.Controladora;


import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListComponente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static JTable tblComponentes;
	
	private String codSeleccionado = "";
	private static DefaultTableModel modelo; // Modelo de la tabla
	private static Object row[]; // Carga datos de fila
	private static JButton btnActualizar;
	private static JButton btnEliminar;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListComponente dialog = new ListComponente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListComponente() {
		setTitle("Listado Componentes");
		setLocationRelativeTo(null);
		setBounds(100, 100, 715, 528);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pnlDeTrabajo = new JPanel();
			contentPanel.add(pnlDeTrabajo, BorderLayout.CENTER);
			pnlDeTrabajo.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				pnlDeTrabajo.add(scrollPane, BorderLayout.CENTER);
				{
					modelo = new DefaultTableModel();
					tblComponentes = new JTable();
					tblComponentes.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) { // Saber cual se selecciono
							int index = tblComponentes.getSelectedRow();
							if(index>=0) {
								codSeleccionado = tblComponentes.getValueAt(index, 0).toString();
								btnActualizar.setEnabled(true);
								btnEliminar.setEnabled(true);

							}
						}
					});
					String[] headerIdentifiers = {"NumSer", "Marca", "Modelo","Cantidad Disponible"};
					modelo.setColumnIdentifiers(headerIdentifiers);
					tblComponentes.setModel(modelo);

					tblComponentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(tblComponentes);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnActualizar = new JButton("Actualizar");
				btnActualizar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(codSeleccionado!=""){
							Componente tempComponente = Controladora.getInstance().buscarComponentePorNumeroDeSerie(codSeleccionado);
							if(tempComponente!= null){
								RegComponente updateComponente = new RegComponente(tempComponente);
								updateComponente.setModal(true);;
								updateComponente.setVisible(true);
							}
						}
					}
				});
				buttonPane.add(btnActualizar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(codSeleccionado!=""){
							int option = JOptionPane.showConfirmDialog(null, "Seguro desea eliminar el componente con el código: "+codSeleccionado, "Confirmación", JOptionPane.WARNING_MESSAGE);
							if(option == JOptionPane.YES_OPTION){
								Controladora.getInstance().eliminarComponente(codSeleccionado);
								btnEliminar.setEnabled(false);
								loadTblComponentes();
							}
						}
					}
				});
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		loadTblComponentes();
	}
	
	public static void loadTblComponentes() {
		ArrayList<Componente> tempComponentes = Controladora.getInstance().getLosComponentes();
		modelo.setRowCount(0);
		row = new Object[tblComponentes.getColumnCount()];
		for(Componente tempComponente : tempComponentes) {
			row[0] = tempComponente.getNumeroDeSerie();
			row[1] = tempComponente.getMarca();
			row[2] = tempComponente.getModelo();
			row[3] = tempComponente.getCantDisponible();
			modelo.addRow(row);
		}
		btnActualizar.setEnabled(false);
		btnEliminar.setEnabled(false);
	}

}
