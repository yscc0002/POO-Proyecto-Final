package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


import logico.Cliente;
import logico.Componente;
import logico.Controladora;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.ZoneId;

public class RegFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTextField txtIDCliente;
	private static JTextField txtNombreCliente;
	private static JTextField txtIDFactura;
	private static JTextField txtDireccionCliente;
	private static JButton btnQuitarFactura;
	private static JButton btnAgregarFactura;
	private static JTable tblComponentesDisponibles;
	private static JTable tblCarrito;
	private static boolean clienteEncontrado;
	private static JTextField txtEmail;


	// Tabla Publicaciones Disponibles
	private String codSeleccionTblComponentesDisponibles = "";
	private static DefaultTableModel modeloTblComponentesDisponibles;
	private static Object rowTblComponentesDisponibles[];
	private static int indexTblComponentesDisponibles;

	// Tabla Carrito
	private String codSeleccionTblCarrito = "";
	private static DefaultTableModel modeloTblCarrito;
	private static Object rowTblCarrito[];
	private static int indexTblCarrito;
	private JSpinner jSpinnerFechaFacturacion;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegFactura dialog = new RegFactura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegFactura() {
		setTitle("Registro de Factura");
		setBounds(100, 100, 937, 807);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pnlDeTrabajo = new JPanel();
			pnlDeTrabajo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(pnlDeTrabajo, BorderLayout.CENTER);
			pnlDeTrabajo.setLayout(null);

			JPanel pnlDatosCliente = new JPanel();
			pnlDatosCliente.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlDatosCliente.setBounds(15, 40, 829, 282);
			pnlDeTrabajo.add(pnlDatosCliente);
			pnlDatosCliente.setLayout(null);

			txtIDCliente = new JTextField();
			txtIDCliente.setBounds(94, 13, 84, 26);
			pnlDatosCliente.add(txtIDCliente);
			txtIDCliente.setColumns(10);

			JLabel lblIdCliente = new JLabel("ID Cliente:");
			lblIdCliente.setBounds(15, 16, 84, 20);
			pnlDatosCliente.add(lblIdCliente);

			txtNombreCliente = new JTextField();
			txtNombreCliente.setEnabled(false);
			txtNombreCliente.setColumns(10);
			txtNombreCliente.setBounds(390, 13, 401, 26);
			pnlDatosCliente.add(txtNombreCliente);

			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(322, 16, 77, 20);
			pnlDatosCliente.add(lblNombre);

			JLabel lblDireccion = new JLabel("Direccion:");
			lblDireccion.setBounds(15, 54, 77, 20);
			pnlDatosCliente.add(lblDireccion);

			txtDireccionCliente = new JTextField();
			txtDireccionCliente.setEnabled(false);
			txtDireccionCliente.setColumns(10);
			txtDireccionCliente.setBounds(13, 87, 338, 176);
			pnlDatosCliente.add(txtDireccionCliente);


			JButton btnBuscarCliente = new JButton("Buscar");
			btnBuscarCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Cliente cliente = Controladora.getInstance().buscarClientePorId(txtIDCliente.getText());
					if(cliente!=null) { // Existe
						txtIDCliente.setText(cliente.getIdCliente());
						txtNombreCliente.setText(cliente.getNombre());
						txtDireccionCliente.setText(cliente.getDireccion());
						clienteEncontrado = true;
					}else if(txtIDCliente.getText().length()>0){ // No existe
						txtIDCliente.setText("Cli#"+Controladora.codCliente);
						txtNombreCliente.setEnabled(true);
						txtDireccionCliente.setEnabled(true);
						clienteEncontrado = false;
					}


				}
			});
			btnBuscarCliente.setBounds(192, 12, 115, 29);
			pnlDatosCliente.add(btnBuscarCliente);

			JLabel lblEmail = new JLabel("Email:");
			lblEmail.setBounds(322, 51, 70, 20);
			pnlDatosCliente.add(lblEmail);

			txtEmail = new JTextField();
			txtEmail.setEnabled(false);
			txtEmail.setColumns(10);
			txtEmail.setBounds(371, 48, 420, 26);
			pnlDatosCliente.add(txtEmail);

			JLabel lblNewLabel = new JLabel("Datos del Cliente");
			lblNewLabel.setBounds(15, 16, 127, 20);
			pnlDeTrabajo.add(lblNewLabel);

			JLabel lblIdPrestamo = new JLabel("ID Factura:");
			lblIdPrestamo.setBounds(394, 389, 104, 20);
			pnlDeTrabajo.add(lblIdPrestamo);

			txtIDFactura = new JTextField();
			txtIDFactura.setEditable(false);
			txtIDFactura.setText("Fac#"+Controladora.codFactura);
			txtIDFactura.setBounds(493, 386, 84, 26);
			pnlDeTrabajo.add(txtIDFactura);
			txtIDFactura.setColumns(10);

			JPanel pnlPublicacionesDisponibles = new JPanel();
			pnlPublicacionesDisponibles.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlPublicacionesDisponibles.setBounds(15, 389, 352, 289);
			pnlDeTrabajo.add(pnlPublicacionesDisponibles);
			pnlPublicacionesDisponibles.setLayout(new BorderLayout(0, 0));

			JScrollPane scrlPnlComponentesDisponibles = new JScrollPane();
			scrlPnlComponentesDisponibles.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			pnlPublicacionesDisponibles.add(scrlPnlComponentesDisponibles, BorderLayout.CENTER);

			modeloTblComponentesDisponibles = new DefaultTableModel();
			tblComponentesDisponibles = new JTable();
			tblComponentesDisponibles.addMouseListener(new MouseAdapter() {// Saber cual se selecciona
				@Override
				public void mouseClicked(MouseEvent e) {
					indexTblComponentesDisponibles = tblComponentesDisponibles.getSelectedRow();
					if(indexTblComponentesDisponibles >= 0) {
						codSeleccionTblComponentesDisponibles = new String(tblComponentesDisponibles.getValueAt(indexTblComponentesDisponibles, 0).toString());
						btnAgregarFactura.setEnabled(true);
						btnQuitarFactura.setEnabled(false);
					}
				}
			});
			String[] headersTblComponentesDisponibles = {"NumSer", "Marca", "Modelo","Cant. Disponible"};
			modeloTblComponentesDisponibles.setColumnIdentifiers(headersTblComponentesDisponibles);
			tblComponentesDisponibles.setModel(modeloTblComponentesDisponibles);
			tblComponentesDisponibles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrlPnlComponentesDisponibles.setViewportView(tblComponentesDisponibles);

			JLabel lblPublicacionesDisponibles = new JLabel("Componentes Disponibles:");
			lblPublicacionesDisponibles.setBounds(15, 364, 207, 20);
			pnlDeTrabajo.add(lblPublicacionesDisponibles);

			btnAgregarFactura = new JButton("Agregar");
			btnAgregarFactura.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Controladora.getInstance().getComponentesNoSeleccionados().get(indexTblComponentesDisponibles).setSeleccionado(true);
					btnAgregarFactura.setEnabled(false);
					loadTableComponentesDisponibles();
					loadTableCarrito();
				}
			});
			btnAgregarFactura.setBounds(349, 347, 115, 29);
			pnlDeTrabajo.add(btnAgregarFactura);

			btnQuitarFactura = new JButton("Quitar");
			btnQuitarFactura.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Controladora.getInstance().getComponentesSeleccionados().get(indexTblCarrito).setSeleccionado(false);
					btnQuitarFactura.setEnabled(false);
					loadTableComponentesDisponibles();
					loadTableCarrito();
				}
			});
			btnQuitarFactura.setBounds(474, 347, 115, 29);
			pnlDeTrabajo.add(btnQuitarFactura);

			JLabel lblCarrito = new JLabel("Carrito:");
			lblCarrito.setBounds(394, 532, 70, 20);
			pnlDeTrabajo.add(lblCarrito);

			JPanel pnlCarrito = new JPanel();
			pnlCarrito.setBounds(392, 557, 452, 121);
			pnlDeTrabajo.add(pnlCarrito);
			pnlCarrito.setLayout(new BorderLayout(0, 0));

			JScrollPane scrlPnlCarrito = new JScrollPane();
			scrlPnlCarrito.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			pnlCarrito.add(scrlPnlCarrito, BorderLayout.CENTER);

			modeloTblCarrito = new DefaultTableModel();
			tblCarrito = new JTable();
			tblCarrito.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					indexTblCarrito = tblCarrito.getSelectedRow();
					if(indexTblCarrito >= 0) {
						codSeleccionTblCarrito = new String(tblCarrito.getValueAt(indexTblCarrito,0).toString());
						btnAgregarFactura.setEnabled(false);
						btnQuitarFactura.setEnabled(true);
					}
				}
			});
			String[] headersTblCarrito = {"NumSer", "Marca", "Modelo"};
			modeloTblCarrito.setColumnIdentifiers(headersTblCarrito);
			tblCarrito.setModel(modeloTblCarrito);
			tblCarrito.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrlPnlCarrito.setViewportView(tblCarrito);

			JLabel lblFechaDeSolicitud = new JLabel("Fecha de Facturacion:");
			lblFechaDeSolicitud.setBounds(394, 425, 161, 20);
			pnlDeTrabajo.add(lblFechaDeSolicitud);


			jSpinnerFechaFacturacion = new JSpinner();
			jSpinnerFechaFacturacion.setModel(new SpinnerDateModel(new java.util.Date(1720065600000L), null, null, Calendar.YEAR));
			JSpinner.DateEditor dateSpinnerFechaDeSolicitud = new JSpinner.DateEditor(jSpinnerFechaFacturacion, "yyyy"); // Formateador Spinner a "YYYY"
			jSpinnerFechaFacturacion.setBounds(567, 422, 161, 26);
			jSpinnerFechaFacturacion.setEditor(dateSpinnerFechaDeSolicitud); // Aplicar nuevo formato
			pnlDeTrabajo.add(jSpinnerFechaFacturacion);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnFacturar = new JButton("Facturar");
				btnFacturar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {					

						Cliente cliente = null;

						// Realizar prestamo si hay algo en el buscador de id de Cliente
						if(txtIDCliente.getText().length()>0) {
							String idCliente = "";

							// Por si se actualizo algo de un cliente existente
							if(clienteEncontrado) {
								cliente = Controladora.getInstance().buscarClientePorId(txtIDCliente.getText());
								cliente.setNombre(txtNombreCliente.getText());
								cliente.setDireccion(txtDireccionCliente.getText());
								cliente.setEmail(txtEmail.getText());
								Controladora.getInstance().actualizarClienteV(cliente);
							}

							// Cierre actualizacion

							//Creacion si no habia cliente

							if(!clienteEncontrado) {
								cliente = new Cliente(txtIDCliente.getText(), txtNombreCliente.getText(), txtDireccionCliente.getText(), txtEmail.getText(), "NA","NA","NA");
								Controladora.getInstance().insertarCliente(cliente);
							}else {
								idCliente = "Cli#"+Controladora.codCliente;
							}

							String idFactura = txtIDFactura.getText();

							// De fecha entera a "YYYY"
							Date date = (Date) jSpinnerFechaFacturacion.getValue();// Obtengo Valor bruto
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy"); // Formateador
							String dateString = dateFormat.format(date); // f(date) = Formateador + String 
							int fechaFacturacion = new Integer(dateString); // String to int
							// Cierre convertir de Fecha a "YYYY"

							// Obtener la cantidad de elementos en el carrito, para pasarselo a condicion al for
							DefaultTableModel tempModel = (DefaultTableModel) tblCarrito.getModel();
							int rowCount = tempModel.getRowCount();

							for (int i = 0; i < rowCount; i++) {
								String idComponente = new String(tblCarrito.getValueAt(i, 0).toString());

								Componente tempComponente = Controladora.getInstance().buscarComponentePorNumeroDeSerie(idComponente);


								if (tempComponente != null) {// Realizar prestamo
									Controladora.getInstance().realizarFactura(idFactura, cliente.getIdCliente(), fechaFacturacion, tempComponente);
								}
							}
							JOptionPane.showMessageDialog(null, "Facturacion satisfatoria!", "Registro de Factura", JOptionPane.INFORMATION_MESSAGE);
							System.out.println("Factura"+Controladora.getInstance().getLasFacturas().get(0).getIdCliente());
							System.out.println("Factura"+Controladora.getInstance().getLasFacturas().size());
							nextDateIncomingFactura();
							loadTableCarrito();
							loadTableComponentesDisponibles();
						}
					}
				});
				btnFacturar.setActionCommand("OK");
				buttonPane.add(btnFacturar);
				getRootPane().setDefaultButton(btnFacturar);
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
		loadTableComponentesDisponibles();
		loadTableCarrito();

	}// Fin registro factura


	// Cargar tablas
	public static void loadTableComponentesDisponibles() {
		modeloTblComponentesDisponibles.setRowCount(0); // Inicializar las filas
		rowTblComponentesDisponibles = new Object[tblComponentesDisponibles.getColumnCount()];
		for(Componente tempComponente: Controladora.getInstance().getComponentesNoSeleccionados()) {
			rowTblComponentesDisponibles[0] = tempComponente.getNumeroDeSerie();
			rowTblComponentesDisponibles[1] = tempComponente.getMarca();
			rowTblComponentesDisponibles[2] = tempComponente.getModelo();
			rowTblComponentesDisponibles[3] = tempComponente.getCantDisponible();
			modeloTblComponentesDisponibles.addRow(rowTblComponentesDisponibles); // Agregar fila a tabla
		}
		btnAgregarFactura.setEnabled(false);
		btnQuitarFactura.setEnabled(false);
	}

	public static void loadTableCarrito() {
		modeloTblCarrito.setRowCount(0); // Inicializar las filas
		rowTblCarrito = new Object[tblCarrito.getColumnCount()];
		for(Componente tempComponente: Controladora.getInstance().getComponentesSeleccionados()) {
			rowTblCarrito[0] = tempComponente.getNumeroDeSerie();
			rowTblCarrito[1] = tempComponente.getMarca();
			rowTblCarrito[2] = tempComponente.getModelo();
			modeloTblCarrito.addRow(rowTblCarrito); // Agregar fila a tabla
		}
		btnAgregarFactura.setEnabled(false);
		btnQuitarFactura.setEnabled(false);
	}


	//Cierre cargar tablas

	// Limpiadores

	public static void nextDataIncomingCliente() {
		txtIDCliente.setText("");
		txtNombreCliente.setText("");
		txtDireccionCliente.setText("");
		txtEmail.setText("");
	}

	public static void nextDateIncomingFactura() {
		txtIDCliente.setText("");
		txtNombreCliente.setText("");
		txtDireccionCliente.setText("");
		txtEmail.setText("");
		txtIDFactura.setText("Fac#"+Controladora.codFactura);
	}
}

