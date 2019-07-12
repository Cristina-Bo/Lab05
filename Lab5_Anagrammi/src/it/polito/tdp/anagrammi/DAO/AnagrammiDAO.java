package it.polito.tdp.anagrammi.DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class AnagrammiDAO {
	
	public boolean isCorrect(String anagramma) {
		String jdbcURL = "jdbc:mysql://127.0.0.1/dizionario?user=root&password=Pallinomar99";
		String sql ="SELECT nome FROM parola WHERE nome=?";
		boolean result;
		
		try {
			Connection conn = (Connection) DriverManager.getConnection(jdbcURL);
			PreparedStatement st= (PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, anagramma);
			
			ResultSet res = st.executeQuery();
			
			if(res.next()) {
				result = true;
			}else {
				result = false;
			}
			
			conn.close();
			return result;
			
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
		
		
		
	}

}
