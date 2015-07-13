package sistema.control;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import sistema.bin.ClienteBin;
import sistema.conexao.conexao;

public class ClienteControl {
	
	public void InsereDados(String nome,String placa,String marca,String modelo,String cor){
		conexao banco = new conexao();
		String retorno = "erro";
		try {
			Connection ExConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();
			String sSQL = "INSERT INTO banco.cliente VALUES (null,'"+nome+"','"+placa+"','"+marca+"','"+modelo+"','"+cor+"');";
			System.out.println(sSQL);
			boolean res = stmt.execute(sSQL);
			JOptionPane.showMessageDialog(null,(!res)?"Dados inseridos com sucesso!!!":"" +
			"Os dados não puderam ser inseridos!!!");
			stmt.close();
			banco.fecharBDConn();
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,"Os dados não puderam ser inseridos!!!");
				}
		}

	public void ExcluirCliente(String placa){
		conexao banco = new conexao();
		try {
			Connection ExConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();
			String sSQL = "DELETE FROM banco.cliente WHERE placa = '"+placa+"';";
			boolean rs = stmt.execute(sSQL);
			JOptionPane.showMessageDialog(null,(!rs)? "Dados do cliente excluidos com sucesso.":"Dados do cliente não foram excluidos com sucesso.");
			stmt.close();
			banco.fecharBDConn();
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,"Os dados não foram encontrado!!!");
				} 
		}

	public String AtualizarDados(String nome,String placa,String marca,String modelo,String cor, ClienteBin CliBin){
		conexao banco = new conexao();
		String retorno = "erro";
		int res;
		try {

			Connection ExConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();
			res = stmt.executeUpdate("UPDATE banco.cliente SET nome = '"+nome+"', placa = '"+placa+
					"',marca = '"+marca+"',modelo = '"+modelo+"', cor = '"+cor+"', WHERE idCliente = "+CliBin.getId());
			
			if(res==1)JOptionPane.showMessageDialog(null,"Os dados  foram atualizados com sucesso!!!");
			stmt.close();
			banco.fecharBDConn();
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,"Os dados não puderam ser atualizados!!!");
				}
		return retorno;
		}
	public void BuscarDados(String nome,ClienteBin CliBin) {
		conexao banco = new conexao();

		try {
			Connection ExConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();
			String sSQL = "SELECT * FROM banco.cliente WHERE nome = '"+nome+"';";
			ResultSet rs = stmt.executeQuery(sSQL);
			while(rs.next())
			{
				CliBin.setId(rs.getInt("id"));
				CliBin.setNome(rs.getString("nome"));
				CliBin.setPlaca(rs.getString("placa"));
				CliBin.setMarca(rs.getString("marca"));
				CliBin.setModelo(rs.getString("modelo"));
				CliBin.setCor(rs.getString("cor"));
				}
			stmt.close();
			banco.fecharBDConn();
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,"Os dados não puderam ser encontrado!!!");
				} 
		}
	}