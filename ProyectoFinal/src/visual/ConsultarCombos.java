
package visual;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import logico.Combo;
import logico.Controladora;

public class ConsultarCombos extends JDialog {
    private final JPanel contentPanel = new JPanel();
    private JTextField txtCodigo;
    private JComboBox<String> comboBoxDescuento;
    private JTextField txtCantidadComponentes;

    public ConsultarCombos() {
        setTitle("Consultar Combos");
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblCodigo = new JLabel("Ingrese el código del combo:");
        lblCodigo.setBounds(50, 50, 200, 25);
        contentPanel.add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(250, 50, 100, 25);
        contentPanel.add(txtCodigo);
        txtCodigo.setColumns(10);

        JLabel lblCantidadComponentes = new JLabel("Cantidad de componentes:");
        lblCantidadComponentes.setBounds(50, 90, 200, 25);
        contentPanel.add(lblCantidadComponentes);

        txtCantidadComponentes = new JTextField();
        txtCantidadComponentes.setBounds(250, 90, 100, 25);
        contentPanel.add(txtCantidadComponentes);
        txtCantidadComponentes.setColumns(10);

        JLabel lblSeleccionarDescuento = new JLabel("Seleccionar porcentaje de descuento:");
        lblSeleccionarDescuento.setBounds(50, 130, 200, 25);
        contentPanel.add(lblSeleccionarDescuento);

        comboBoxDescuento = new JComboBox<>();
        comboBoxDescuento.setModel(new DefaultComboBoxModel<>(new String[]{"20%", "30%", "40%", "50%"}));
        comboBoxDescuento.setBounds(250, 130, 100, 25);
        contentPanel.add(comboBoxDescuento);

        JButton btnAplicar = new JButton("Aplicar");
        btnAplicar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String codigo = txtCodigo.getText();
                String cantidadComponentesTexto = txtCantidadComponentes.getText();
                String porcentajeSeleccionado = (String) comboBoxDescuento.getSelectedItem();
                double porcentajeDescuento = Double.parseDouble(porcentajeSeleccionado.replace("%", ""));

                try {
                    int cantidadComponentes = Integer.parseInt(cantidadComponentesTexto);
                    Combo combo = Controladora.getInstance().verificarCombo(codigo);

                    if (combo != null && combo.getNumComponentes() == cantidadComponentes && combo.getPorcentajeDescuento() == porcentajeDescuento) {
                        JOptionPane.showMessageDialog(null, "Descuento aplicado: " + combo.getPorcentajeDescuento() + "% en la compra de " + combo.getNumComponentes() + " componentes");
                    } else {
                        JOptionPane.showMessageDialog(null, "Código no válido, cantidad de componentes o porcentaje de descuento incorrecto");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese una cantidad válida de componentes");
                }
            }
        });
        btnAplicar.setBounds(150, 180, 100, 25);
        contentPanel.add(btnAplicar);
    }
}