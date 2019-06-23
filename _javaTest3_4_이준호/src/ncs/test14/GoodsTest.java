package ncs.test14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoodsTest {
	public static void main(String[] args) {
		Goods goods = new Goods();

		System.out.println("Type following Product info: ");

		try(InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr); ) {

			System.out.print("Name: ");
			goods.setName(br.readLine());
			System.out.print("Price: ");
			goods.setPrice(Integer.valueOf(br.readLine()));
			System.out.print("Qty: ");
			goods.setQuantity(Integer.valueOf(br.readLine()));

		} catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nTyped Product info: ");
		System.out.println(goods);
		System.out.println("Total : " + goods.getPrice()*goods.getQuantity() +" WON");
	}
}
