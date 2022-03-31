package es.unican.is2.ImpuestoCirculacionGUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;


@SuppressWarnings("serial")
public class VistaFuncionarioTest extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtSaludo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaFuncionarioTest frame = new VistaFuncionarioTest();
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
	public VistaFuncionarioTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 165);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(10, 42, 143, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.setName("txtNombre");
		
		JLabel lblIntroduceTuNombre = new JLabel("Introduce tu nombre");
		lblIntroduceTuNombre.setBounds(10, 22, 143, 14);
		contentPane.add(lblIntroduceTuNombre);
		
		JButton btnPulsar = new JButton("\u00A1Pulsa!");
		btnPulsar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = txtNombre.getText();
				if (nombre.equals(""))  {
					txtSaludo.setText("¡Hola!");
				} else {
					txtSaludo.setText("¡Hola "+txtNombre.getText()+"!");
				}
			}
		});
		btnPulsar.setBounds(37, 79, 89, 23);
		contentPane.add(btnPulsar);
		btnPulsar.setName("btnPulsar");
		
		txtSaludo = new JTextField();
		txtSaludo.setForeground(Color.RED);
		txtSaludo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSaludo.setBounds(198, 42, 171, 60);
		contentPane.add(txtSaludo);
		txtSaludo.setColumns(10);
		txtSaludo.setName("txtSaludo");
	}
}
