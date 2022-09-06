package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ProductDao;
import Model.Account;
import Model.Product;

/**
 * Servlet implementation class EditControl
 */
@WebServlet("/edit")
public class EditProductControl extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		int pid=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String image=request.getParameter("image");
		int price=Integer.parseInt(request.getParameter("price"));
		String description=request.getParameter("description");
		String title=request.getParameter("title");
		int category=Integer.parseInt(request.getParameter("category"));
		Product product = new Product(pid, name, image, price, title, description);
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("SessionLogin");
		int id = account.getIdAcount();
		ProductDao.getInstance().updateProduct(product, category, id);
		response.sendRedirect("manager");
	}

}
