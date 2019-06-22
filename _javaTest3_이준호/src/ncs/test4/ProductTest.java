package ncs.test4;

public class ProductTest {
	public static void main(String[] args) {
//		main 함수 안에서 Product
//		객체 초기값을 키보드로 입력
		Product p1 = new Product("갤럭시 S7", 563500, 3);
		System.out.println(p1.information());
		System.out.println("총 구매 가격 : " + p1.getQuantity() * p1.getPrice() +" 원");
	}
}
