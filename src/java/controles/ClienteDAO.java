/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import controles.Conexao;
import entidades.Animal;
import entidades.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcello
 */
public class ClienteDAO {

    private Conexao con = new Conexao();

    public Cliente salvarCliente(Cliente cliente) {
        PreparedStatement st;
        ResultSet res;

        try {
            int i = 1;
            st = con.getConexao().prepareStatement("insert into animal(nome,cpf,telefone,email,endereco) values (?,?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            st.setString(i++, cliente.getNome());
            st.setString(i++, cliente.getCpf());
            st.setString(i++, cliente.getTelefone());
            st.setString(i++, cliente.getEmail());
            st.setString(i++, cliente.getEndereco());

            st.execute();
            res = st.getGeneratedKeys();

            if (res.next()) {
                cliente.setIdCliente(res.getInt(1));
            }
            return cliente;

        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return null;
        }

    }

    public ResultSet resultCliente() {
        PreparedStatement st;
        ResultSet res = null;

        try {
            int i = 1;
            st = con.getConexao().prepareStatement("select * from cliente");
            res = st.executeQuery();
            return res;
            
        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

}
