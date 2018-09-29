package formulario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class formulario
 */
@WebServlet("/formulario")
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
			sesion.setAttribute("contador", 0);
		}
		if(getServletContext().getAttribute("contador") == null) {
			getServletContext().setAttribute("contador", 0);
		}
		int contadorSesion = (int) sesion.getAttribute("contador");
		int contadorContexto = (int) getServletContext().getAttribute("contador");
		String formulario = "<!DOCTYPE html>"
				+ "<html>"
					+ "<head>"
						+ "<meta charset='EUC-KR'>"
						+ "<title>Insert title here</title>"
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
