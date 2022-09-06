package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.AccountDao;
import Model.Account;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet(urlPatterns = "/login")
public class LoginControl extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
		    for (int i = 0; i < cookies.length; i++) {
				Cookie cookie=cookies[i];
				if (cookie.getName().equals("userC")) {
					request.setAttribute("username", cookie.getValue());
				}
			}
		}
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("user");
		String passUser = request.getParameter("pass");
		Account account = AccountDao.getInstance().getLogin(userName, passUser);
		if (account == null) {
			request.setAttribute("message", "User name and pass is wrong");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("SessionLogin",account);
			//luu account len tren cookie
			Cookie user = new Cookie("userC",userName);
			user.setMaxAge(60);
			Cookie passCookie = new Cookie("passC", passUser);
			passCookie.setMaxAge(60);
			response.addCookie(user);
			response.addCookie(passCookie);
			response.sendRedirect("Home");
		}

	}

}
