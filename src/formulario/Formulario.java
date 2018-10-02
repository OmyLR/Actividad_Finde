package formulario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Numero;

/**
 * Servlet implementation class formulario
 */
public class Formulario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Formulario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession();
		if(sesion.getAttribute("contador") == null) {
			Numero sesN = new Numero();
			sesion.setAttribute("contador", sesN);
		}
		if(getServletContext().getAttribute("contador") == null) {
			Numero contexto = new Numero();
			getServletContext().setAttribute("contador", contexto);
		}
		Numero contadorSesion = (Numero) sesion.getAttribute("contador");
		Numero contadorContexto = (Numero) getServletContext().getAttribute("contador");
		String formulario = "<!DOCTYPE html>"
				+ "<html>"
					+ "<head>"
						+ "<meta charset='EUC-KR'>"
						+ "<title>Concepto de Sesion y Contexto</title>"
					+ "</head>"
					+ "<body>"
						+ "	<form method='POST' action='servlets/contador1'>"
							+ "<label>Contador Session</label>"
							+ "<input type='number' name='contSession' value="+contadorSesion+">"
							+ "	<input type='submit' name='btnSession' value='Incrementar Contador'>"
						+ "</form>"
							+"<form method='POST' action='servlets/contador2'>"
							+ "	<label>Contador Contexto</label>"
							+ "<input type='number' name='contContext' value="+contadorContexto+">"
							+ "<input type='submit' name='btnContext' value='Incrementar Contador' >"
						+"</form>"
							
					+ "</body>"
				+ "</html>";
		response.getWriter().append(formulario);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
