package unama.br.Controlador;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import br.unama.DAO.AlunoDAO;
import unama.br.Modelo.Aluno;


@WebServlet("/ControladorAluno")
public class ControladorAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/web-aluno")
	private DataSource dataSource;
	
	private AlunoDAO alunoDAO;

	public void init(ServletConfig config) throws ServletException {
		alunoDAO = new AlunoDAO(dataSource);
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Aluno> alunos = alunoDAO.consultaAlunos();
		request.setAttribute("LISTA-ALUNOS", alunos);
		request.getRequestDispatcher("/ListaAlunosVisao.jsp").forward(request, response);
	}

}
