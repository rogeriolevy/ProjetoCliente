package sistema.gui;
 
import java.awt.BorderLayout;
 
import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
public class Principal extends JFrame {
	
	private JPanel contentPane;
 
	/**
	 * * Launch the application.
	 * */
 
	public static void main(String[] args) {
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
		}

	/**
	 * * Create the frame.
	 * */
	public Principal() {
		setTitle("Tela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 336);
   
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
   
		JMenu mnGerenciamento = new JMenu("Gerenciamento");
		menuBar.add(mnGerenciamento);
   
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				new ClienteGui().setVisible(true);
				}
			});
  
		mnGerenciamento.add(mntmCliente);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		}
	}