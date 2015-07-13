package sistema.gui;
 
import java.awt.BorderLayout;
 
import java.awt.EventQueue;
 

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
 

import sistema.bin.ClienteBin;
import sistema.control.ClienteControl;
 

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
public class ClienteGui extends JFrame {
	private JPanel contentPane;
	private JTextField jtfNome;
	private JTextField jtfPlaca;
	private JTextField jtfMarca;
	private JTextField jtfModelo;
	private JTextField jtfCor;
	
	ClienteControl CliControl = new ClienteControl();
	ClienteBin CliBin = new ClienteBin();
	
	/**
	 * * Launch the application.
	 * */
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteGui frame = new ClienteGui();
					frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
						}
				}
			}
		);
		}
 
  
  
	/**
	 * * Create the frame.
	 * * */
	
	public ClienteGui() {
		setTitle("Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 509, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
   
		JLabel lblNewLabel = new JLabel("Cadastro de Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(27, 11, 233, 45);
		contentPane.add(lblNewLabel);
   
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(27, 79, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(27, 104, 46, 14);
		contentPane.add(lblPlaca);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(27, 129, 71, 14);
		contentPane.add(lblMarca);
   
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(27, 156, 71, 14);
		contentPane.add(lblModelo);
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setBounds(27, 181, 46, 14);
		contentPane.add(lblCor);

		
		jtfNome = new JTextField();
		jtfNome.setBounds(117, 76, 351, 20);
		contentPane.add(jtfNome);
		jtfNome.setColumns(10);
		
		jtfPlaca = new JTextField();
		jtfPlaca.setColumns(10);
		jtfPlaca.setBounds(117, 101, 351, 20);
		contentPane.add(jtfPlaca);
		
		jtfMarca = new JTextField();
		jtfMarca.setColumns(10);
		jtfMarca.setBounds(117, 126, 351, 20);
		contentPane.add(jtfMarca);
		
		jtfModelo = new JTextField();
		jtfModelo.setColumns(10);
		jtfModelo.setBounds(117, 153, 351, 20);
		contentPane.add(jtfModelo);
   
		jtfCor = new JTextField();
		jtfCor.setColumns(10);
		jtfCor.setBounds(117, 178, 351, 20);
		contentPane.add(jtfCor);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				String nome = jtfNome.getText();
				String placa = jtfPlaca.getText();
				String marca = jtfMarca.getText();
				String modelo = jtfModelo.getText();
				String cor = jtfCor.getText();
				
				CliControl.InsereDados(nome,placa,marca,modelo,cor);
				}
			
		});
  
		btnCadastrar.setBounds(375, 249, 97, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				jtfNome.setText("");
				jtfPlaca.setText("");
				jtfMarca.setText("");
				jtfModelo.setText("");
				jtfCor.setText("");
				}
			});
  
		btnLimpar.setBounds(71, 249, 89, 23);
		contentPane.add(btnLimpar);
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
   
			public void actionPerformed(ActionEvent arg0) {
				String placa = JOptionPane.showInputDialog(null,"Digite o placa do cliente: ");
				CliControl.ExcluirCliente(placa);;
				}
			
		});
  
		btnExcluir.setBounds(276, 249, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnAtualizaer = new JButton("Atualizar");
		btnAtualizaer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				CliControl.AtualizarDados(jtfNome.getText(), jtfPlaca.getText(), jtfMarca.getText(),
						jtfModelo.getText(), jtfCor.getText(), CliBin);
				}
			
		});
  
		btnAtualizaer.setBounds(171, 249, 89, 23);
		contentPane.add(btnAtualizaer);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String nome = JOptionPane.showInputDialog(null,"Digite o nome do cliente: ");
				CliControl.BuscarDados(nome,CliBin);
				jtfNome.setText(CliBin.getNome());
				jtfPlaca.setText(CliBin.getPlaca());
				jtfMarca.setText(CliBin.getMarca());
				jtfModelo.setText(CliBin.getModelo());
				jtfCor.setText(CliBin.getCor());  
				}
		});
		
		btnBuscar.setBounds(379, 283, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				}
			});
		btnSair.setBounds(286, 283, 89, 23);
		contentPane.add(btnSair);
		}
	}