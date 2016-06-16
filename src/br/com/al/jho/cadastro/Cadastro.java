package br.com.al.jho.cadastro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Constants.Constants;

/**
 * Servlet implementation class Cadastro
 */
@WebServlet("/Cadastro")
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Cadastro() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String linguagem = request.getParameter("linguagem");
		String[] paradigmas = request.getParameterValues("paradigmas");
		String anosExp = request.getParameter("anos_exp");
		String cert = request.getParameter("certificacao");
		String habil = request.getParameter("habilidades");

		HttpSession session = request.getSession();

		session = request.getSession(true);
		
		String email = (String) session.getAttribute("email");

		System.out.println(request.getAttribute("usr"));

		String param = "";

		Connection connection = ConnectionFactory.getConnection();
		System.out.println("Conexão aberta!");

		for (int i = 0; i < paradigmas.length; i++) {
			param += paradigmas[i] + "; ";
		}

		try {
			PreparedStatement stmt = connection.prepareStatement(Constants.SQL);

			stmt.setString(1, linguagem);
			stmt.setString(2, param);
			stmt.setString(3, habil);
			stmt.setString(4, anosExp);
			stmt.setString(5, cert);
			//stmt.setString(6, email);

			stmt.execute();

			connection.close();

			System.out.println("Dados inseridos!");

			RequestDispatcher d = getServletContext().getRequestDispatcher("/Sucesso");
			d.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
