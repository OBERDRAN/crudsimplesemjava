package dev.agenda.aplicacao;

import java.util.Date;
import java.util.Scanner;

import dev.agenda.dao.ContatoDAO;
import dev.agenda.model.Contato;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Contato contato = new Contato();
		Scanner sc = new Scanner(System.in);
		
		String nome;
		int idade;
		
		System.out.println("Nome: ");
		nome = sc.next();
		
		System.out.println("Idade: ");
		idade = sc.nextInt();
		
		contato.setNome(nome);
		contato.setIdade(idade);
		contato.setDataCadastro(new Date());
		
		ContatoDAO contatodao = new ContatoDAO();
		
		contatodao.save(contato);
		
	}

}
