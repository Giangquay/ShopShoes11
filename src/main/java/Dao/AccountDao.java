package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Context.DBContext;
import Model.Account;

public class AccountDao {
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	public static AccountDao getInstance()
	{
		return  new AccountDao();
	}
	
	public Account getLogin(String name,String pass)
	{
		String sql="Select * from Account where [user]=? and pass=?";
		try {
			conn = new DBContext().getConnection();
			ps= conn.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2, pass);
			rs=ps.executeQuery();
			while(rs.next())
			{
				return new Account(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
	public Account CheckAccount(String name)
	{
		String sql="Select * from Account where [user]=?";
		try {
			conn = new DBContext().getConnection();
			ps= conn.prepareStatement(sql);
			ps.setString(1,name);
			rs=ps.executeQuery();
			while(rs.next())
			{
				return new Account(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
	public void Insert(Account account)
	{
		String sql="Insert into Account values(?,?,0,0)";
		try {
			conn = new DBContext().getConnection();
			ps= conn.prepareStatement(sql);
			ps.setString(1,account.getUserAccount());
			ps.setString(2, account.getPassAccount());
			ps.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
}
