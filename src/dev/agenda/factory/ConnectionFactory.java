package dev.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static final String USERNAME = "root";
	
	private static final String PASSWORD = "root";
	
	
	//caminho do banco de dados
	//conexao do tipo jdbc
	private static final String DATABASE_URL ="jdbc:mysql://localhost:3306/agenda";
	
	//conexao com o banco de dados
	
	public static Connection createConnectionToMySQL() throws Exception{
		
		//faz com que a classe seja carregada pela jvm
		Class.forName("com.mysql.jdbc.Driver");
		
		//cria conexao com banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
	
		return connection;
	}
	
	//verificar se tem conexao ativa, permitir apenas uma por usuario
	public static void main(String [] args) throws Exception {
		//recuperar conexao com o banco de dados
		Connection conexaoAtiva = createConnectionToMySQL();
		
		if(conexaoAtiva!=null) {
			System.out.println("Conexao obtida com sucesso!");
			conexaoAtiva.close();
		}
		
	}
	
}
