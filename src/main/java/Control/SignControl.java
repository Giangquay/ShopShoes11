package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.AccountDao;
import Model.Account;

/**
 * Servlet implementation class SignControl
 */
@WebServlet("/signup")
public class SignControl extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("user");
		String userPass=request.getParameter("pass");
		String rep_Pass=request.getParameter("repass");
		if (!userPass.equals(rep_Pass)) {
			response.sendRedirect("Login.jsp");
		}else {
			Account cAccount = AccountDao.getInstance().CheckAccount(user);
			if (cAccount==null) {
				Account account = new Account(user,userPass);
				AccountDao.getInstance().Insert(account);
				response.sendRedirect("Home");
			}else {
				request.setAttribute("messageSign", "User is exsis");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}
	}

}
