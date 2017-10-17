/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import controles.Conexao;
import entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcello
 */
public class UsuarioDAO {

    private Conexao con = new Conexao();

    public Usuario salvarUsuario(Usuario user) {
        PreparedStatement st;
        ResultSet res;

        try {
            int i = 1;
            st = con.getConexao().prepareStatement("insert into usuario(nome,login,senha) values (?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            st.setString(i++, user.getNome());
            st.setString(i++, user.getLogin());
            st.setString(i++, user.getSenha());

            st.execute();
            res = st.getGeneratedKeys();

            if (res.next()) {
                user.setIdUsuario(res.getInt(1));
            }
            return user;

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return null;
        }

    }

    public Usuario consultaUsuario(String login) {
        Usuario user = null;
        PreparedStatement st;
        ResultSet res;

        try {
            int i = 1;
            st = con.getConexao().prepareStatement("select idusuario,nome,login,senha from usuario where login = ?");
            st.setString(i++, login);

            res = st.executeQuery();
            if (res.next()) {
                user = new Usuario();
                user.setIdUsuario(res.getInt("idusuario"));
                user.setNome(res.getString("nome"));
                user.setLogin(res.getString("login"));
                user.setSenha(res.getString("senha"));

            }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }

        return user;
    }

    public ResultSet resultUsuario() {
        PreparedStatement st;
        ResultSet res = null;

        try {
            int i = 1;
            st = con.getConexao().prepareStatement("select * from usuario");
            res = st.executeQuery();
            return res;
            
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    public Usuario validaUsuario(Usuario user) {
        // consulta banco
        Usuario novo = consultaUsuario(user.getLogin());

        if (novo != null
                && user.getLogin().equals(novo.getLogin())
                && user.getSenha().equals(novo.getSenha())) {
            return novo;
        }
        
        return novo;
    }
}
