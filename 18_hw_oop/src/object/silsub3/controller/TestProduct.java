package object.silsub3.controller;

import object.silsub3.model.Product;

public class TestProduct {
	public static void main(String[] args) {
		Product p1 = new Product("ssgnote6", "갤럭시노트6", "서울", 960000, 10.0);
		Product p2 = new Product("lgxnote5", "LG스마트폰5", "평택", 780000, 0.7);
		Product p3 = new Product("ktnorm3", "KT일반폰3", "판교", 25000, 0.3);
		
		p1.information();
		p2.information();
		p3.information();

		p1.setPrice(1200000);
		p2.setPrice(1200000);
		p3.setPrice(1200000);

		p1.setTax(.5);
		p2.setTax(.5);
		p3.setTax(.5);
		
		System.out.println();
		p1.information();
		p2.information();
		p3.information();
		
		p1.setTax(.05);
		p2.setTax(.05);
		p3.setTax(.05);

		System.out.println();
		p1.setPrice((int)(p1.getPrice()* (1 + p1.getTax())));
		p2.setPrice((int)(p2.getPrice()* (1 + p2.getTax())));
		p3.setPrice((int)(p3.getPrice()* (1 + p3.getTax())));
		p1.information();
		p2.information();
		p3.information();
	}
}
