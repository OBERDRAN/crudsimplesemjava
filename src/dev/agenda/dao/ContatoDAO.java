package dev.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import dev.agenda.factory.ConnectionFactory;
import dev.agenda.model.Contato;

public class ContatoDAO {

	public void save(Contato contato) {
		String sql = "INSERT INTO contatos(nome,idade,dataCadastro)VALUES(?,?,?)";
		
		Connection conn = null;
		//Preparar para executar o sql
		
		PreparedStatement pstm = null;
		
		//conectar ao banco
		try {
			//criar conexao com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//cria um PreparedStatement para executar uma query
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			
			//executar a query
			
			pstm.execute();
			
		}catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}finally {
			
			//fechar conexões
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	
	}
	
	
}
