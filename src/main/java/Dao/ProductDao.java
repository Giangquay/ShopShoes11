package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import Context.DBContext;
import Model.Product;

public class ProductDao {
	Connection conn = null;
	PreparedStatement pStatement = null;
	ResultSet rs = null;

	public static ProductDao getInstance() {
		return new ProductDao();
	}

	public List<Product> getAllProduct() {

		List<Product> list = new ArrayList<>();
		String sql = "Select * from Product";
		try {
			conn = new DBContext().getConnection();
			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				Product product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
						rs.getString(5), rs.getString(6));
				list.add(product);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
	public List<Product> getAllProductBySellID(int id) {

		List<Product> list = new ArrayList<>();
		String sql = "select * from product where product.sell_ID=?";
		try {
			conn = new DBContext().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, id);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				Product product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
						rs.getString(5), rs.getString(6));
				list.add(product);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public Product getLast() {
		String sql="Select top(1)* from product \r\n"
				+ "order by id";
		try {
			 conn=new DBContext().getConnection();
			 pStatement =conn.prepareStatement(sql);
			rs=pStatement.executeQuery();
			while(rs.next())
			{
				return new  Product(rs.getInt(1)
						,rs.getString(2)
						,rs.getString(3)
						,rs.getDouble(4)
						,rs.getString(5)
						,rs.getString(6));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public List<Product> getProductsByCateID(String cid) {

		List<Product> list = new ArrayList<>();
		String sql = "Select * from Product where cateId =?";
		try {
			conn = new DBContext().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, cid);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				Product product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
						rs.getString(5), rs.getString(6));
				list.add(product);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
	public Product getProductsByID(String cid) {

		String sql = "SELECT * from product where id=?";
		try {
			conn = new DBContext().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, cid);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
						rs.getString(5), rs.getString(6));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Product> getListProductByName(String nameShoes)
	{
		List<Product> list = new ArrayList<>();
		String sql="\r\n"
				+ "Select * from product where product.[name] like ?";
		try {
			conn = new DBContext().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, "%"+nameShoes+"%");
			rs = pStatement.executeQuery();
			while (rs.next()) {
				Product product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
						rs.getString(5), rs.getString(6));
				list.add(product);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void deleProductID(int cid) {

		String sql = "delete from product where id = ?";
		try {
			conn = new DBContext().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, cid);
			pStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void insertProduct(Product ob,int cateID,int sellID) {

		String sql = "insert into product([name],[image],price,title,[description],cateID,sell_ID) values(?,?,?,?,?,?,?)";
		try {
			conn = new DBContext().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, ob.getName());
			pStatement.setString(2,ob.getImage());
			pStatement.setDouble(3, ob.getPrice());
			pStatement.setString(4, ob.getDescription());
			pStatement.setString(5, ob.getTittle());
			pStatement.setInt(6, cateID);
			pStatement.setInt(7, sellID);
			pStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void updateProduct(Product ob,int cateID,int sellID) {

		String sql = "update product set [name]=? ,[image]=? ,price=?,title=?,[description]=?,cateID=?,sell_ID=?\r\n"
				+ "where product.id=?";
		try {
			conn = new DBContext().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, ob.getName());
			pStatement.setString(2,ob.getImage());
			pStatement.setDouble(3, ob.getPrice());
			pStatement.setString(4, ob.getDescription());
			pStatement.setString(5, ob.getTittle());
			pStatement.setInt(6, cateID);
			pStatement.setInt(7, sellID);
			pStatement.setInt(8,ob.getId());
			pStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
