package br.fiap.contato.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	protected ResultSet rs;
	protected PreparedStatement ps;
	protected Connection connection;
	protected String sql;
}
