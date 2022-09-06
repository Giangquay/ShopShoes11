package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Context.DBContext;
import Model.Category;

public class CategoryDao {
	Connection conn=null;
	PreparedStatement pStatement=null;
	ResultSet rs=null;
	public static CategoryDao getInstance()
	{
		return new CategoryDao();
	}
	public List<Category> getAllCatogory()
	{
		
		List<Category> list = new ArrayList<>();
		String sql="Select * from Category";
		try {
			 conn=new DBContext().getConnection();
			 pStatement =conn.prepareStatement(sql);
			rs=pStatement.executeQuery();
			while(rs.next())
			{
				Category product= new  Category(rs.getInt(1),rs.getString(2));
				list.add(product);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
}
