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
 * Servlet implementation class Detail
 */
@WebServlet("/detail")
public class DetailControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String id=request.getParameter("pid");
		Product dProduct = ProductDao.getInstance().getProductsByID(id);
		List<Category> listCategories =CategoryDao.getInstance().getAllCatogory(); 
		Product product = ProductDao.getInstance().getLast();
		
		request.setAttribute("listC", listCategories);
		request.setAttribute("deltail", dProduct);
		request.setAttribute("p", product);
		request.getRequestDispatcher("Detail.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
