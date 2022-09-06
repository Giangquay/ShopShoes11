package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CategoryDao;
import Dao.ProductDao;
import Model.Category;
import Model.Product;

/**
 * Servlet implementation class HomeControl
 */
@WebServlet("/Home")
public class HomeControl extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		List<Product> listProducts = ProductDao.getInstance().getAllProduct();
		List<Category> listcCategories=CategoryDao.getInstance().getAllCatogory();
		Product product = ProductDao.getInstance().getLast();
		request.setAttribute("listC", listcCategories);
		request.setAttribute("listP", listProducts);
		request.setAttribute("p", product);
		request.getRequestDispatcher("Home.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Home.jsp").forward(request, response);
	}

}
