package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.border.TitledBorder;

import logico.Cliente;
import logico.Componente;
import logico.Controladora;
import logico.DiscoDuro;
import logico.MemoriaRAM;
import logico.Microprocesador;
import logico.MotherBoard;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class RegComponente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtID;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtPrecio;
	private JTextField txtTipoMemoriaRAMMotherBoard;
	private JTable table;
	private JRadioButton rdbMotherBoard;
	private JRadioButton rdbDiscoDuro;
	private JRadioButton rdbMicroprocesador;
	private JRadioButton rdbMemoriaRAM;
	private JTextField txtTipoDeConectorMotherBoard;
	private JComboBox cbxTipoConexionDiscoDuroMotherBoard;
	private JSpinner jSpinnerCapacidadAlmacenamientoDiscoDuro;
	private JPanel pnlMotherBoard;
	private JPanel pnlDiscoDuro;
	private JPanel pnlMicroprocesador;
	private JPanel pnlMemoriaRAM;
	private JSpinner jSpinnerCantDisponible;
	private JSpinner jSpinnerCantidadMemoriaRAM;
	private JComboBox cbxTipoConexionMicroprocesador;
	private JSpinner jSpinnerVelocidadProcesamiento;
	private JComboBox cbxTipoConexionDiscoDuro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegComponente dialog = new RegComponente(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegComponente(Componente componente) {
		if(componente!=null){
			setTitle("Actualizar componente");
		}else{
			setTitle("Registro de componente");
		}

		setTitle("Registro de Componente");
		setBounds(100, 100, 842, 572);
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

			JLabel lblNewLabel = new JLabel("Numero de Serie:");
			lblNewLabel.setBounds(12, 37, 125, 20);
			pnlDeTrabajo.add(lblNewLabel);
			{
				txtID = new JTextField();
				txtID.setEditable(false);
				txtID.setBounds(144, 34, 146, 26);
				txtID.setText("NumSer#" + Controladora.codComponente);
				pnlDeTrabajo.add(txtID);
				txtID.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Marca:");
				lblNewLabel_1.setBounds(305, 37, 55, 20);
				pnlDeTrabajo.add(lblNewLabel_1);
			}
			{
				txtMarca = new JTextField();
				txtMarca.setColumns(10);
				txtMarca.setBounds(362, 34, 146, 26);
				pnlDeTrabajo.add(txtMarca);
			}
			{
				txtModelo = new JTextField();
				txtModelo.setColumns(10);
				txtModelo.setBounds(586, 34, 146, 26);
				pnlDeTrabajo.add(txtModelo);
			}
			{
				JLabel lblModelo = new JLabel("Modelo:");
				lblModelo.setBounds(523, 37, 57, 20);
				pnlDeTrabajo.add(lblModelo);
			}

			rdbMotherBoard = new JRadioButton("MotherBoard");
			rdbMotherBoard.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbMotherBoard.setSelected(true);
					rdbDiscoDuro.setSelected(false);
					rdbMemoriaRAM.setSelected(false);
					rdbMicroprocesador.setSelected(false);
					pnlDiscoDuro.setVisible(false);
					pnlMemoriaRAM.setVisible(false);
					pnlMicroprocesador.setVisible(false);
					pnlMotherBoard.setVisible(true);

				}
			});
			rdbMotherBoard.setBounds(33, 126, 155, 29);
			pnlDeTrabajo.add(rdbMotherBoard);

			rdbDiscoDuro = new JRadioButton("Disco Duro");
			rdbDiscoDuro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbMotherBoard.setSelected(false);
					rdbDiscoDuro.setSelected(true);
					rdbMemoriaRAM.setSelected(false);
					rdbMicroprocesador.setSelected(false);
					pnlDiscoDuro.setVisible(true);
					pnlMemoriaRAM.setVisible(false);
					pnlMicroprocesador.setVisible(false);
					pnlMotherBoard.setVisible(false);
				}
			});
			rdbDiscoDuro.setBounds(221, 126, 155, 29);
			pnlDeTrabajo.add(rdbDiscoDuro);

			rdbMemoriaRAM = new JRadioButton("Memoria RAM");
			rdbMemoriaRAM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbMotherBoard.setSelected(false);
					rdbDiscoDuro.setSelected(false);
					rdbMemoriaRAM.setSelected(true);
					rdbMicroprocesador.setSelected(false);
					pnlDiscoDuro.setVisible(false);
					pnlMemoriaRAM.setVisible(true);
					pnlMicroprocesador.setVisible(false);
					pnlMotherBoard.setVisible(false);
				}
			});
			rdbMemoriaRAM.setBounds(409, 126, 155, 29);
			pnlDeTrabajo.add(rdbMemoriaRAM);

			JLabel lblNewLabel_2 = new JLabel("Precio:");
			lblNewLabel_2.setBounds(15, 76, 69, 20);
			pnlDeTrabajo.add(lblNewLabel_2);

			JLabel lblNewLabel_1 = new JLabel("Cantidad Disponible:");
			lblNewLabel_1.setBounds(231, 76, 169, 20);
			pnlDeTrabajo.add(lblNewLabel_1);

			jSpinnerCantDisponible = new JSpinner();
			jSpinnerCantDisponible.setBounds(385, 73, 69, 26);
			pnlDeTrabajo.add(jSpinnerCantDisponible);

			rdbMicroprocesador = new JRadioButton("Microprocesador");
			rdbMicroprocesador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbMotherBoard.setSelected(false);
					rdbDiscoDuro.setSelected(false);
					rdbMemoriaRAM.setSelected(false);
					rdbMicroprocesador.setSelected(true);
					pnlDiscoDuro.setVisible(false);
					pnlMemoriaRAM.setVisible(false);
					pnlMicroprocesador.setVisible(true);
					pnlMotherBoard.setVisible(false);
				}
			});
			rdbMicroprocesador.setBounds(597, 126, 155, 29);
			pnlDeTrabajo.add(rdbMicroprocesador);

			txtPrecio = new JTextField();
			txtPrecio.setColumns(10);
			txtPrecio.setBounds(70, 73, 146, 26);
			pnlDeTrabajo.add(txtPrecio);

			pnlMotherBoard = new JPanel();
			pnlMotherBoard.setBounds(15, 167, 726, 205);
			pnlDeTrabajo.add(pnlMotherBoard);
			pnlMotherBoard.setLayout(null);

			JLabel lblTipoDeConector = new JLabel("Tipo de Conector:");
			lblTipoDeConector.setBounds(19, 19, 134, 20);
			pnlMotherBoard.add(lblTipoDeConector);

			txtTipoDeConectorMotherBoard = new JTextField();
			txtTipoDeConectorMotherBoard.setBounds(172, 16, 146, 26);
			pnlMotherBoard.add(txtTipoDeConectorMotherBoard);
			txtTipoDeConectorMotherBoard.setColumns(10);

			JLabel lblTipoDeMemoria = new JLabel("Tipo de Memoria RAM:");
			lblTipoDeMemoria.setBounds(337, 19, 173, 20);
			pnlMotherBoard.add(lblTipoDeMemoria);

			txtTipoMemoriaRAMMotherBoard = new JTextField();
			txtTipoMemoriaRAMMotherBoard.setBounds(529, 16, 146, 26);
			pnlMotherBoard.add(txtTipoMemoriaRAMMotherBoard);
			txtTipoMemoriaRAMMotherBoard.setColumns(10);

			JPanel pnlDiscoDurosAceptados = new JPanel();
			pnlDiscoDurosAceptados.setBounds(19, 104, 656, 85);
			pnlMotherBoard.add(pnlDiscoDurosAceptados);
			pnlDiscoDurosAceptados.setLayout(new BorderLayout(0, 0));

			JScrollPane scrollPane = new JScrollPane();
			pnlDiscoDurosAceptados.add(scrollPane, BorderLayout.CENTER);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

			table = new JTable();
			scrollPane.setViewportView(table);

			JLabel lblDiscoDuroCompatible = new JLabel("Tipo De Conexion Disco Duro:");
			lblDiscoDuroCompatible.setBounds(19, 65, 231, 20);
			pnlMotherBoard.add(lblDiscoDuroCompatible);

			JButton btnAgregarDiscoDuroMotherBoard = new JButton("Agregar Disco Duro");
			btnAgregarDiscoDuroMotherBoard.setBounds(445, 59, 208, 29);
			pnlMotherBoard.add(btnAgregarDiscoDuroMotherBoard);

			cbxTipoConexionDiscoDuroMotherBoard = new JComboBox();
			cbxTipoConexionDiscoDuroMotherBoard
			.setModel(new DefaultComboBoxModel(new String[] { "IDE", "SATA", "SATA-2", "SATA-3" }));
			cbxTipoConexionDiscoDuroMotherBoard.setBounds(250, 62, 180, 26);
			pnlMotherBoard.add(cbxTipoConexionDiscoDuroMotherBoard);

			pnlDiscoDuro = new JPanel();
			pnlDiscoDuro.setLayout(null);
			pnlDiscoDuro.setBounds(15, 167, 726, 205);
			pnlDeTrabajo.add(pnlDiscoDuro);

			JLabel lblCapacidadDeAlmacenamiento = new JLabel("Capacidad de Almacenamiento (GB):");
			lblCapacidadDeAlmacenamiento.setBounds(6, 19, 279, 20);
			pnlDiscoDuro.add(lblCapacidadDeAlmacenamiento);

			cbxTipoConexionDiscoDuro = new JComboBox();
			cbxTipoConexionDiscoDuro
			.setModel(new DefaultComboBoxModel(new String[] { "IDE", "SATA", "SATA-2", "SATA-3" }));
			cbxTipoConexionDiscoDuro.setBounds(503, 16, 180, 26);
			pnlDiscoDuro.add(cbxTipoConexionDiscoDuro);

			JLabel lblTipoDeConexion = new JLabel("Tipo De Conexion:");
			lblTipoDeConexion.setBounds(358, 19, 146, 20);
			pnlDiscoDuro.add(lblTipoDeConexion);

			jSpinnerCapacidadAlmacenamientoDiscoDuro = new JSpinner();
			jSpinnerCapacidadAlmacenamientoDiscoDuro.setBounds(274, 16, 61, 26);
			pnlDiscoDuro.add(jSpinnerCapacidadAlmacenamientoDiscoDuro);

			pnlMicroprocesador = new JPanel();
			pnlMicroprocesador.setLayout(null);
			pnlMicroprocesador.setBounds(15, 167, 726, 205);
			pnlDeTrabajo.add(pnlMicroprocesador);

			JLabel lblVelocidadDeProcesamiento = new JLabel("Velocidad Procesamiento (GHz):");
			lblVelocidadDeProcesamiento.setBounds(15, 16, 258, 20);
			pnlMicroprocesador.add(lblVelocidadDeProcesamiento);

			jSpinnerVelocidadProcesamiento = new JSpinner();
			jSpinnerVelocidadProcesamiento.setBounds(259, 13, 99, 26);
			pnlMicroprocesador.add(jSpinnerVelocidadProcesamiento);

			cbxTipoConexionMicroprocesador = new JComboBox();
			cbxTipoConexionMicroprocesador.setModel(new DefaultComboBoxModel(new String[] { "PGA", "LGA", "BGA" }));
			cbxTipoConexionMicroprocesador.setBounds(515, 13, 146, 26);
			pnlMicroprocesador.add(cbxTipoConexionMicroprocesador);

			JLabel label_1 = new JLabel("Tipo De Conexion:");
			label_1.setBounds(370, 16, 146, 20);
			pnlMicroprocesador.add(label_1);

			pnlMemoriaRAM = new JPanel();
			pnlMemoriaRAM.setBounds(15, 167, 726, 205);
			pnlDeTrabajo.add(pnlMemoriaRAM);
			pnlMemoriaRAM.setLayout(null);

			JLabel lblCantidadDeMemoria = new JLabel("Cantidad de Memoria (MB):");
			lblCantidadDeMemoria.setBounds(19, 19, 210, 20);
			pnlMemoriaRAM.add(lblCantidadDeMemoria);

			jSpinnerCantidadMemoriaRAM = new JSpinner();
			jSpinnerCantidadMemoriaRAM.setBounds(221, 16, 99, 26);
			pnlMemoriaRAM.add(jSpinnerCantidadMemoriaRAM);

			rdbMotherBoard.setSelected(true);
			rdbDiscoDuro.setSelected(false);
			rdbMemoriaRAM.setSelected(false);
			rdbMicroprocesador.setSelected(false);
			pnlDiscoDuro.setVisible(false);
			pnlMemoriaRAM.setVisible(false);
			pnlMicroprocesador.setVisible(false);
			pnlMotherBoard.setVisible(true);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				if(componente!=null){
					btnRegistrar.setText("Actualizar");
				}
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {


						String numeroDeSerie = txtID.getText();
						String marca = txtMarca.getText();
						String modelo = txtModelo.getText();

						float precio = Float.parseFloat(txtPrecio.getText().toString());
						int cantDisponible = Integer.parseInt(jSpinnerCantDisponible.getValue().toString());

						if(componente==null) {
							if (rdbMotherBoard.isSelected()) {
								String tipoDeConectorMotherboard = txtTipoDeConectorMotherBoard.getText();
								String tipoMemoriaRAM = txtTipoMemoriaRAMMotherBoard.getText();
								ArrayList<DiscoDuro> discoDurosAceptados = new ArrayList<>();
								Componente motherBoard = new MotherBoard(numeroDeSerie, marca, modelo, precio,
										cantDisponible, tipoDeConectorMotherboard, tipoMemoriaRAM, discoDurosAceptados);
								Controladora.getInstance().agregarComponente(motherBoard);
							} else if (rdbDiscoDuro.isSelected()) {
								int capacidadAlmacenamientoDiscoDuro = new Integer(
										jSpinnerCapacidadAlmacenamientoDiscoDuro.getValue().toString());
								String tipoDeConexionDiscoDuro = cbxTipoConexionDiscoDuro.getSelectedItem()
										.toString();
								Componente discoDuro = new DiscoDuro(numeroDeSerie, marca, modelo, precio, cantDisponible,
										capacidadAlmacenamientoDiscoDuro, tipoDeConexionDiscoDuro);
								Controladora.getInstance().agregarComponente(discoDuro);
							} else if (rdbMemoriaRAM.isSelected()) {
								int cantMemoriaRAM = new Integer(jSpinnerCantidadMemoriaRAM.getValue().toString());
								Componente memoriaRam = new MemoriaRAM(numeroDeSerie, marca, modelo, precio, cantDisponible,
										cantMemoriaRAM, "");
								Controladora.getInstance().agregarComponente(memoriaRam);
							} else if (rdbMicroprocesador.isSelected()) {
								String tipoDeConexion = cbxTipoConexionMicroprocesador.getSelectedItem().toString();
								float velocidadGHZ = new Float(jSpinnerVelocidadProcesamiento.getValue().toString());
								Componente microprocesador = new Microprocesador(numeroDeSerie, marca, modelo, precio,
										cantDisponible, velocidadGHZ, tipoDeConexion);
								Controladora.getInstance().agregarComponente(microprocesador);

							}

							System.out.println(Controladora.getInstance().getLosComponentes().size());
							JOptionPane.showMessageDialog(null, "Registro Completo!", "Informacion",
									JOptionPane.INFORMATION_MESSAGE);
							nextDataIncoming();
						}else {

							componente.setNumeroDeSerie(numeroDeSerie);
							componente.setMarca(marca);
							componente.setModelo(modelo);
							componente.setPrecio(precio);
							componente.setCantDisponible(cantDisponible);

							if (componente instanceof MotherBoard) {
								String tipoDeConectorMotherboard = txtTipoDeConectorMotherBoard.getText();
								String tipoMemoriaRAM = txtTipoMemoriaRAMMotherBoard.getText();
								ArrayList<DiscoDuro> discoDurosAceptados = new ArrayList<>();

								((MotherBoard) componente).setTipoDeConector(tipoDeConectorMotherboard);
								((MotherBoard) componente).setTipoDeMemoriaRAM(tipoMemoriaRAM);
								((MotherBoard) componente).setDiscoDurosAceptados(discoDurosAceptados);

							} else if (componente instanceof DiscoDuro) {
								int capacidadAlmacenamientoDiscoDuro = new Integer(
										jSpinnerCapacidadAlmacenamientoDiscoDuro.getValue().toString());
								String tipoDeConexionDiscoDuro = cbxTipoConexionDiscoDuro.getSelectedItem()
										.toString();
								
								((DiscoDuro) componente).setCapacidadDeAlmacenamientoGB(capacidadAlmacenamientoDiscoDuro);
								((DiscoDuro) componente).setTipoDeConexion(tipoDeConexionDiscoDuro);
								
							} else if (componente instanceof MemoriaRAM) {
								int cantMemoriaRAM = new Integer(jSpinnerCantidadMemoriaRAM.getValue().toString());
								
								((MemoriaRAM) componente).setCantMemoriaRAM(cantMemoriaRAM);
								
							} else if (componente instanceof Microprocesador) {
								String tipoDeConexion = cbxTipoConexionMicroprocesador.getSelectedItem().toString();
								float velocidadGHZ = new Float(jSpinnerVelocidadProcesamiento.getValue().toString());
								
								((Microprocesador) componente).setSocket(tipoDeConexion);
								((Microprocesador) componente).setVelocidadGHZ(velocidadGHZ);
							}

							Controladora.getInstance().updateComponente(componente);
							JOptionPane.showMessageDialog(null, "Operación satisfactoria", "Actualizacion", JOptionPane.INFORMATION_MESSAGE);
							ListComponente.loadTblComponentes();
							dispose();
						}

					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
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
		loadComponente(componente);
	}// Fin registro

	private void loadComponente(Componente componente) {
		if(componente!=null){
			txtID.setText(componente.getNumeroDeSerie());
			txtMarca.setText(componente.getMarca());
			txtModelo.setText(componente.getModelo());
			txtPrecio.setText(new Float(componente.getPrecio()).toString());
			jSpinnerCantDisponible.setValue(componente.getCantDisponible());
			if(componente instanceof MotherBoard) {
				txtTipoDeConectorMotherBoard.setText(((MotherBoard)componente).getTipoDeConector());
				txtTipoMemoriaRAMMotherBoard.setText(((MotherBoard)componente).getTipoDeMemoriaRAM());
			}else if(componente instanceof DiscoDuro) {
				jSpinnerCapacidadAlmacenamientoDiscoDuro.setValue(((DiscoDuro)componente).getCapacidadDeAlmacenamientoGB());
				cbxTipoConexionDiscoDuro.setSelectedItem(((DiscoDuro)componente).getTipoDeConexion());
			}else if(componente instanceof MemoriaRAM) {
				jSpinnerCantidadMemoriaRAM.setValue(((MemoriaRAM)componente).getCantMemoriaRAM());
			}else if (componente instanceof Microprocesador) {
				cbxTipoConexionMicroprocesador.setSelectedItem(((Microprocesador)componente).getSocket());
				jSpinnerVelocidadProcesamiento.setValue(((Microprocesador)componente).getVelocidadGHZ());
			}
		}
	}

	private void nextDataIncoming() {
		txtID.setText("NumSer#" + Controladora.codComponente);
		txtMarca.setText("");
		txtModelo.setText("");
		txtPrecio.setText("");
		jSpinnerCantDisponible.setValue(new Integer(0));

		txtTipoDeConectorMotherBoard.setText("");
		txtTipoMemoriaRAMMotherBoard.setText("");

		jSpinnerCapacidadAlmacenamientoDiscoDuro.setValue(new Integer(0));
		cbxTipoConexionDiscoDuro.setSelectedIndex(0);

		cbxTipoConexionDiscoDuroMotherBoard.setSelectedIndex(0);

		jSpinnerCantidadMemoriaRAM.setValue(new Integer(0));

		cbxTipoConexionMicroprocesador.setSelectedIndex(0);
		jSpinnerVelocidadProcesamiento.setValue(new Integer(0));

	}
}
