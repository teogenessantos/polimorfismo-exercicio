package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> listProduct = new ArrayList<>();
		System.out.print("Enter the number of products: ");
		Integer qtdProducts = sc.nextInt();
		Character typeProduct;
		String name;
		Double price;
		
		for (int i = 1; i <= qtdProducts; i++) {
			
			System.out.println("Product #"+i+" data:");
			System.out.print("Common, used or imported (c/u/i)?");
			typeProduct = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			name = sc.nextLine();
			System.out.print("Price: ");
			price = sc.nextDouble();
			if(typeProduct == 'i') {
				System.out.print("Customs fee: ");
				Double customesFee = sc.nextDouble();
				listProduct.add(new ImportedProduct(name,price,customesFee));
			}else if(typeProduct == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				listProduct.add(new UsedProduct(name, price, manufactureDate));
			}else {
				listProduct.add(new Product(name, price));
			}
		}
		System.out.println("PRICE TAGS:");
		for (Product product : listProduct) {
			if(product instanceof ImportedProduct) {
				System.out.printf("%s $ %.2f (Customs fee: $ %.2f)%n",product.getName(),product.getPrice(),((ImportedProduct) product).getCustomesFee());
			}else if(product instanceof UsedProduct){
				System.out.printf("%s (Used) $ %.2f (Manufacture: %s)%n",product.getName(),product.getPrice(),sdf.format(((UsedProduct) product).getManufactureDate()));
			}else {
				System.out.printf("%s $ %.2f%n",product.getName(),product.getPrice());
			}
		}
		sc.close();

	}

}
