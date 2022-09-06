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
 * Servlet implementation class EditProductControl
 */
@WebServlet("/editShow")
public class EditProductShow extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("pid");
		Product dProduct = ProductDao.getInstance().getProductsByID(id);
		List<Category> listCategories =CategoryDao.getInstance().getAllCatogory(); 
		request.setAttribute("listCC", listCategories);
		request.setAttribute("detail", dProduct);
		request.getRequestDispatcher("Edit.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
