package sistema.conexao;
 
import java.sql.Connection;
 
import java.sql.DriverManager;
import java.sql.Statement;
import com.mysql.*;
 
public class conexao {
	Connection con;
	private Connection oConn;
	private Statement sStmt;
	
	public conexao(){}
	public Connection abrirBDConn(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/banco";
			con = DriverManager.getConnection(url,"rogerio","1234");
			System.out.println("Conexao efetuada com sucesso");
			return con;
			}
		catch(Exception e){
			System.out.println("Erro ao abrir conexao com banco:");
			e.printStackTrace();
			return null;
			}
		}
	
	public void fecharBDConn(){
		try{
			con.close();
			System.out.println("Conexao finalizada com sucesso");
			}catch(Exception e){
				System.out.println("Erro ao fechar conexao com banco" + e.getMessage());
				}
		}
	}