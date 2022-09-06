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
 * Servlet implementation class AddProductControler
 */
@WebServlet("/add")
public class AddProductControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String image=request.getParameter("image");
		int price=Integer.parseInt(request.getParameter("price"));
		String description=request.getParameter("description");
		String title=request.getParameter("title");
		int category=Integer.parseInt(request.getParameter("category"));
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("SessionLogin");
		int id = account.getIdAcount();
		Product product = new Product( name, image, price, title, description);
		ProductDao.getInstance().insertProduct(product, category, id);
		response.sendRedirect("manager");
	}

}
