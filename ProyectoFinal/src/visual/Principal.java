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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.TitledBorder;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import logico.Controladora;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {
// Hola
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        deserializarControladora();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Principal frame = new Principal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            serializarControladora();
        }));
    }

    private static void deserializarControladora() {
        try (FileInputStream fileIn = new FileInputStream("Controladora.dat");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Controladora temp = (Controladora) in.readObject();
            Controladora.setControladora(temp);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, se creará un nuevo archivo al cerrar la aplicación.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void serializarControladora() {
        try (FileOutputStream fileOut = new FileOutputStream("Controladora.dat");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(Controladora.getInstance());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the frame.
     */
    public Principal() {
        setTitle("Tienda de Computacion Los Charlatanes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 653, 498);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnComponentes = new JMenu("Componentes");
        menuBar.add(mnComponentes);

        JMenuItem menuItemRegistro = new JMenuItem("Registro");
        mnComponentes.add(menuItemRegistro);

        JMenuItem menuItemListado = new JMenuItem("Listado");
        mnComponentes.add(menuItemListado);

        JMenu mnCombos = new JMenu("Combos");
        menuBar.add(mnCombos);

        JMenuItem menuItemEnsamblaje = new JMenuItem("Ensamblaje");
        mnCombos.add(menuItemEnsamblaje);

        JMenuItem menuItemConsultarCombos = new JMenuItem("Consultar Combos");
        mnCombos.add(menuItemConsultarCombos);

        JMenu mnVentas = new JMenu("Ventas");
        menuBar.add(mnVentas);

        JMenuItem menuItemFacturar = new JMenuItem("Facturar");
        mnVentas.add(menuItemFacturar);

        JMenuItem menuItemConsultarFacturas = new JMenuItem("Consultar Facturas");
        mnVentas.add(menuItemConsultarFacturas);

        JMenu mnClientes = new JMenu("Clientes");
        menuBar.add(mnClientes);

        JMenuItem menuItemRegistroCliente = new JMenuItem("Registro");
        mnClientes.add(menuItemRegistroCliente);

        menuItemRegistroCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegistroCliente dialog = new RegistroCliente(null);
                dialog.setVisible(true);
            }
        });

        JMenuItem menuItemListadoCliente = new JMenuItem("Listado");
        mnClientes.add(menuItemListadoCliente);
        menuItemListadoCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListarClientes dialog = new ListarClientes(false);
                dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            }
        });

        JMenu mnTienda = new JMenu("Tienda");
        menuBar.add(mnTienda);

        JMenuItem menuItemNull = new JMenuItem("Null");
        mnTienda.add(menuItemNull);

        JMenuItem menuItemMostrarGrafico = new JMenuItem("Rango de ventas por zona");
        mnTienda.add(menuItemMostrarGrafico);
        menuItemMostrarGrafico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarGrafico();
            }
        });

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel pnlDeTrabajo = new JPanel();
        pnlDeTrabajo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        contentPane.add(pnlDeTrabajo, BorderLayout.CENTER);

        menuItemRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegComponente dialog = new RegComponente();
                dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            }
        });
    }

    private void mostrarGrafico() {
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Nacional", 60);
        data.setValue("Internacional", 40);

        JFreeChart chart = ChartFactory.createPieChart(
                "Rango de ventas por zona",
                data,
                true,
                true,
                false);

        ChartFrame frame = new ChartFrame("JFreeChart", chart);
        frame.pack();
        frame.setVisible(true);

        try {
            ChartUtilities.saveChartAsJPEG(new File("rango_ventas_por_zona.jpg"), chart, 500, 500);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
