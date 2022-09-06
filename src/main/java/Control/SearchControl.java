package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CategoryDao;
import Dao.ProductDao;
import Model.Category;
import Model.Product;

@WebServlet("/search")
public class SearchControl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Home");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			String shoesSearch=request.getParameter("searchShoe");
			if (shoesSearch!=null) {
				List<Product> listProDuctByName= ProductDao.getInstance().getListProductByName(shoesSearch);
				List<Category> listCategories =CategoryDao.getInstance().getAllCatogory(); 
				Product product = ProductDao.getInstance().getLast();
				request.setAttribute("listP", listProDuctByName);
				request.setAttribute("listC", listCategories);
				request.setAttribute("p", product);
				request.setAttribute("saveShoes", shoesSearch);
				request.getRequestDispatcher("Home.jsp").forward(request, response);
				return;
			}
			
	}

}
