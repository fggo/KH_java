package contact;

import java.io.Serializable;

public class ContactVO implements Serializable{
	private static final long serialVersionUID = -9016607018982619689L;
	// 멤버 변수(필드)
	private String menuCategory;
	private int menuNo;
	private String menuName;
	private int menuPrice;

	// 기본 생성자, 매개변수 생성자
	public ContactVO() {}
	
	
	public ContactVO(String menuCategory, String menuName, int menuPrice) {
		super();
		this.menuCategory = menuCategory;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
	}

	public ContactVO(String menuCategory, int menuNo, String menuName, int menuPrice){
		this.menuCategory = menuCategory;
		this.menuNo = menuNo;
		this.menuName = menuName;
		this.menuPrice =menuPrice;
	}


	@Override
	public String toString() {
		String str = "메뉴종류: " + menuCategory + "\t"+ "  | "
				+ "메뉴번호: " + menuNo + "\t" +"  | " 
				+ "메뉴이름: " + menuName +"\t"+"|"
				+ "메뉴가격 ll: " + menuPrice;
		return str;
	}

	public String getmenuCategory() { return menuCategory; }
	public void setmenuCategory(String menuCategory) { this.menuCategory = menuCategory; }
	public int getMenuNo() { return menuNo; }
	public void setMenuNo(int menuNo) { this.menuNo = menuNo; }
	public String getMenuName() { return menuName; }
	public void setMenuName(String menuName) { this.menuName = menuName; }
	public int getMenuPrice() { return menuPrice; }
	public void setMenuPrice(int menuPrice) { this.menuPrice = menuPrice; }
} // end class ContactVO 
