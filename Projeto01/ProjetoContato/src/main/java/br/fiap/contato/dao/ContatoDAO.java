package br.fiap.contato.dao;

import java.sql.Date;
import java.sql.SQLException;

import br.fiap.contato.conexao.Conexao;
import br.fiap.contato.modelo.Contato;

public class ContatoDAO extends DAO {
	
	// MÉTODO PARA INSERIR UM CONTATO NO BANCO DE DADOS
	public void inserir(Contato contato) {
		Conexao conexao = new Conexao();
		connection = conexao.conectar();
		sql = "insert into java_contatos values (contato_sequence.nextval, ?, ?, ?, ?)";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getEmail());
			ps.setString(3, contato.getSenha());
			ps.setDate(4, Date.valueOf(contato.getDataNascimento()));
			ps.execute();
			ps.close();
			conexao.desconectar();
		} catch(SQLException e) {
			System.out.println("Erro ao inserir o contato" + e);
		}
	}
}
