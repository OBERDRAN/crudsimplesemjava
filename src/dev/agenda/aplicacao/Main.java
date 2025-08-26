package dev.agenda.aplicacao;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dev.agenda.dao.ContatoDAO;
import dev.agenda.model.Contato;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Contato contato = new Contato();
		ContatoDAO contatodao = new ContatoDAO();
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("1 - criar cadastro | 2 - visualizar cadastros");
		int opcao=0;
		
		System.out.print("Escolha uma das opções:");
		opcao = sc.nextInt();
		
		
		switch (opcao) {
			case 1: {
				Scanner sc1 = new Scanner(System.in);
				
				
				System.out.println("Criando Cadastro");
				
				String nome;
				int idade;
				
				System.out.println("Nome: ");
				nome = sc1.nextLine();
				
				System.out.println("Idade: ");
				idade = sc1.nextInt();
				
				contato.setNome(nome);
				contato.setIdade(idade);
				contato.setDataCadastro(new Date());
				
				
				contatodao.save(contato);
				
				break;
				
			}
			
			
			case 2:{
				System.out.println("Visualizando Cadastros");
				
				
				System.out.println("--lista de contatos--");
				System.out.println("Contatos:");
					for(Contato c: contatodao.getContatos()) {
						System.out.println(c.getNome());
					}
				
			}
			
			default:{
				break;	
			}
		
		}
		
		
	}

}
