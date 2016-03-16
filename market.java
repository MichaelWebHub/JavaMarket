import java.util.Scanner;

import javax.swing.JOptionPane;

import java.io.File;
import java.io.PrintStream;
import java.io.IOException;


public class market {
	
	static String[][] str = new String[3][4]; 
    static Scanner scan;
    
    
    	public static void main(String[] args) throws IOException {

		System.out.println("1. Продажа товара");
		System.out.println("2. Поставка товара");
		System.out.println("3. Данные по продажама");
		System.out.print("Выберите опцию: ");
		
		// Ввод с клавиатуры опции
		Scanner keyboard = new Scanner(System.in);
		int option = keyboard.nextInt();
		System.out.println();
		
		if (option == 1) {
			openFile();
			readFile();
			outFile();
			
			System.out.println();
			System.out.print("Что желаете (id)? ");
			int id = keyboard.nextInt();  // ввод с клавиатуры id товара
			
			System.out.print("Сколько?  ");
			int count = keyboard.nextInt();  // ввод с клавиатуры количества товара
			
			int amount = Integer.parseInt(str[id-1][3]); // читаем из файла количество продукта
			if(count > amount) {
				System.out.println("Данного товара нет в таком количестве!");
			} else {
			
			System.out.println("Вы выбрали: ");
			System.out.print("id - " + str[id-1][0] + "("+ str[id-1][1] +") в количестве "+count + " штук(и)");
			System.out.println();
			System.out.print("Заказать? y/n  ");
			
			String answer = keyboard.next();
			switch(answer) {
			case "y":
				System.out.println("Заказ принят");
				
				PrintStream listout = new PrintStream("res//products.txt");
				for (int row = 0; row < str.length; row++){
					if (row == (id-1)){
						amount = amount - count;
						str[id-1][3] = Integer.toString(amount);
					}
					for (int col = 0; col < str[row].length; col++) {
					listout.print(str[row][col] + " ");
				}
				
				listout.println(" ");
			}
				break;
			case "n":
				System.out.println("Заказ отменен");
				break;
			default:
				System.out.println("error");
				break;
			}
		  }
		} else if (option == 2) {
			System.out.print("чикчик");
		} else if (option == 3) {
			System.out.print("список продаж");
		}
	}
	
	public static void openFile() {
		try {
			scan = new Scanner(new File("res//products.txt"));
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "File does not exist");
			}
		
	}
	
	public static void readFile() {

		while (scan.hasNext()) {   
			for (int row = 0; row < str.length; row++){
				for (int col = 0; col < str[row].length; col++) {
				str[row][col] = scan.next();
			}
		}
	}

}
	public static void outFile() {
		for (int row = 0; row < str.length; row++){
			for (int col = 0; col < str[row].length; col++) {
			System.out.print(str[row][col]+ "  ");
		}
		System.out.println();
	  }
	} 
}
