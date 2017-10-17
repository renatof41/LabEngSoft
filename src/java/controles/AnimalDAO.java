/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import controles.Conexao;
import entidades.Animal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcello
 */
public class AnimalDAO {

    private Conexao con = new Conexao();

    public Animal salvarAnimal(Animal animal) {
        PreparedStatement st;
        ResultSet res;

        try {
            int i = 1;
            st = con.getConexao().prepareStatement("insert into animal(nome,especie,raca) values (?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            st.setString(i++, animal.getNome());
            st.setString(i++, animal.getEspecie());
            st.setString(i++, animal.getRaca());

            st.execute();
            res = st.getGeneratedKeys();

            if (res.next()) {
                animal.setIdAnimal(res.getInt(1));
            }
            return animal;

        } catch (SQLException e) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return null;
        }

    }

    public ResultSet resultAnimal() {
        PreparedStatement st;
        ResultSet res = null;

        try {
            int i = 1;
            st = con.getConexao().prepareStatement("select * from animal");
            res = st.executeQuery();
            return res;
            
        } catch (SQLException e) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

}
