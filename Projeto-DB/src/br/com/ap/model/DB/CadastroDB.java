package br.com.ap.model.DB;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CadastroDB {

    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public CadastroDB() {
        connection = Conexao.getConnetion();

    }

    public boolean insert(Cadastro cadastro) throws SQLException {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("INSERT INTO servidores-cargo (cargo, quantidade ) values (?, ?)");

            stmt.setString(1, cadastro.getCargo());
            stmt.setInt(2, cadastro.getQuantidade());

            stmt.execute();
            return true;
        } catch (SQLException e){
            System.err.println(e.toString());

        }finally{
            connection.close();

        }
        return false;
    }

}
