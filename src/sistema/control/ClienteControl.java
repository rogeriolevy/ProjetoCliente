package sistema.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import sistema.bin.ClienteBin;
import sistema.conexao.Conexao;

/**
 * Controller class for Client operations.
 * Handles CRUD operations for clients.
 */
public class ClienteControl {

    /**
     * Inserts a new client into the database.
     * 
     * @param nome   Client name
     * @param placa  Vehicle plate
     * @param marca  Vehicle brand
     * @param modelo Vehicle model
     * @param cor    Vehicle color
     */
    public void insereDados(String nome, String placa, String marca, String modelo, String cor) {
        Conexao banco = new Conexao();
        String sql = "INSERT INTO banco.cliente (nome, placa, marca, modelo, cor) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = banco.abrirBDConn();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nome);
            pstmt.setString(2, placa);
            pstmt.setString(3, marca);
            pstmt.setString(4, modelo);
            pstmt.setString(5, cor);

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!!!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Os dados não puderam ser inseridos!!!\n" + e.getMessage());
        } finally {
            banco.fecharBDConn();
        }
    }

    /**
     * Deletes a client by vehicle plate.
     * 
     * @param placa Vehicle plate of the client to delete
     */
    public void excluirCliente(String placa) {
        Conexao banco = new Conexao();
        String sql = "DELETE FROM banco.cliente WHERE placa = ?";

        try (Connection conn = banco.abrirBDConn();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, placa);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Dados do cliente excluidos com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Dados do cliente não foram excluidos com sucesso.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Os dados não foram encontrados!!!\n" + e.getMessage());
        } finally {
            banco.fecharBDConn();
        }
    }

    /**
     * Updates client data in the database.
     * 
     * @param nome   Client name
     * @param placa  Vehicle plate
     * @param marca  Vehicle brand
     * @param modelo Vehicle model
     * @param cor    Vehicle color
     * @param cliBin Client business object containing the ID
     * @return Status message
     */
    public String atualizarDados(String nome, String placa, String marca, String modelo, String cor,
            ClienteBin cliBin) {
        Conexao banco = new Conexao();
        String sql = "UPDATE banco.cliente SET nome = ?, placa = ?, marca = ?, modelo = ?, cor = ? WHERE idCliente = ?";

        try (Connection conn = banco.abrirBDConn();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nome);
            pstmt.setString(2, placa);
            pstmt.setString(3, marca);
            pstmt.setString(4, modelo);
            pstmt.setString(5, cor);
            pstmt.setInt(6, cliBin.getId());

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected == 1) {
                JOptionPane.showMessageDialog(null, "Os dados foram atualizados com sucesso!!!");
                return "success";
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Os dados não puderam ser atualizados!!!\n" + e.getMessage());
        } finally {
            banco.fecharBDConn();
        }

        return "erro";
    }

    /**
     * Searches for a client by name and populates the provided ClienteBin object.
     * 
     * @param nome   Client name to search
     * @param cliBin ClienteBin object to populate with results
     */
    public void buscarDados(String nome, ClienteBin cliBin) {
        Conexao banco = new Conexao();
        String sql = "SELECT * FROM banco.cliente WHERE nome = ?";

        try (Connection conn = banco.abrirBDConn();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nome);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                cliBin.setId(rs.getInt("IDCliente"));
                cliBin.setNome(rs.getString("nome"));
                cliBin.setPlaca(rs.getString("placa"));
                cliBin.setMarca(rs.getString("marca"));
                cliBin.setModelo(rs.getString("modelo"));
                cliBin.setCor(rs.getString("cor"));
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!!!");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Os dados não puderam ser encontrados!!!\n" + e.getMessage());
        } finally {
            banco.fecharBDConn();
        }
    }
}
