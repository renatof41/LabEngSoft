/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import controles.Conexao;
import entidades.Animal;
import entidades.Cliente;
import entidades.Fornecedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcello
 */
public class FornecedorDAO {

    private Conexao con = new Conexao();

    public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
        PreparedStatement st;
        ResultSet res;

        try {
            int i = 1;
            st = con.getConexao().prepareStatement("insert into fornecedor(razaosocial,cnpj,telefone,email) values (?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            st.setString(i++, fornecedor.getRazaoSocial());
            st.setString(i++, fornecedor.getCnpj());
            st.setString(i++, fornecedor.getTelefone());
            st.setString(i++, fornecedor.getEmail());

            st.execute();
            res = st.getGeneratedKeys();

            if (res.next()) {
                fornecedor.setIdFornecedor(res.getInt(1));
            }
            return fornecedor;

        } catch (SQLException e) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return null;
        }

    }

    public ResultSet resultFornecedor() {
        PreparedStatement st;
        ResultSet res = null;

        try {
            int i = 1;
            st = con.getConexao().prepareStatement("select * from fornecedor");
            res = st.executeQuery();
            return res;
            
        } catch (SQLException e) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

}
