package br.unama.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import unama.br.Modelo.Aluno;

public class AlunoDAO {
	private DataSource datasource;
	private List<Aluno> listaAlunos;
	
	public AlunoDAO(DataSource dataSource) {
		this.datasource = dataSource;
	}
	
	public List<Aluno> consultaAlunos() {
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		listaAlunos = new ArrayList<Aluno>();
		
		try {
			con = this.datasource.getConnection();
			String sql = "select * from aluno order by primeiro_nome";
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("idaluno");
				String primeiroNome = rs.getString("primeiro_nome");
				String ultimoNome = rs.getString("ultimo_nome");
				String email = rs.getString("email");
				Aluno aluno = new Aluno(id, primeiroNome, ultimoNome, email);
				listaAlunos.add(aluno);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return listaAlunos;
	}
	
	public void cadastrarAluno(Aluno aluno) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = this.datasource.getConnection();
			String sql = "insert into aluno (primeiro_nome, ultimo_nome, email) values (?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1,  aluno.getPrimeiroNome());
			ps.setString(2,  aluno.getUltimoNome());
			ps.setString(3, aluno.getEmail());
			ps.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
