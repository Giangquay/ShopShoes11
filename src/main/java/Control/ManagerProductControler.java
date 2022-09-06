package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CategoryDao;
import Dao.ProductDao;
import Model.Account;
import Model.Category;
import Model.Product;

/**
 * Servlet implementation class ManagerProductControler
 */
@WebServlet("/manager")
public class ManagerProductControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("SessionLogin");
		int id = account.getIdAcount();
		List<Product> list = ProductDao.getInstance().getAllProductBySellID(id);
		List<Category> listCategories=CategoryDao.getInstance().getAllCatogory();
		request.setAttribute("ListC", listCategories);
		request.setAttribute("ListP", list);
		request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);
	}

}
