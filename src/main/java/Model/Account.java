package Model;

public class Account {
	private  int idAcount;
	private String userAccount;
	private String passAccount;
	private int isSell;
	private int isAdmin;
	
	
	public Account() {
		super();
	}
	


	public Account(String userAccount, String passAccount) {
		super();
		this.userAccount = userAccount;
		this.passAccount = passAccount;
	}

	public Account(int idAcount, String userAccount, String passAccount, int isSell, int isAdmin) {
		super();
		this.idAcount = idAcount;
		this.userAccount = userAccount;
		this.passAccount = passAccount;
		this.isSell = isSell;
		this.isAdmin = isAdmin;
	}
	public int getIdAcount() {
		return idAcount;
	}
	public void setIdAcount(int idAcount) {
		this.idAcount = idAcount;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getPassAccount() {
		return passAccount;
	}
	public void setPassAccount(String passAccount) {
		this.passAccount = passAccount;
	}
	public int getIsSell() {
		return isSell;
	}
	public void setIsSell(int isSell) {
		this.isSell = isSell;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return "Account [idAcount=" + idAcount + ", userAccount=" + userAccount + ", passAccount=" + passAccount
				+ ", isSell=" + isSell + ", isAdmin=" + isAdmin + "]";
	}
	
	
}
