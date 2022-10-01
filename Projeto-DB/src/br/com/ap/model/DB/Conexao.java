package br.com.ap.model.DB;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

public class Conexao {
	    public static java.sql.Connection getConnetion(){
	        try{
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = null;
	            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/servidores-cargo", "root", "1234");
	            return con;

	        }catch (SQLException e){
	            throw new RuntimeException(e);

	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
}


