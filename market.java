import java.util.Scanner;

import javax.swing.JOptionPane;

import java.io.File;
import java.io.PrintStream;
import java.io.IOException;


public class market {
	
	//static int a, b;
	static String[][] str = new String[3][4]; 
    static Scanner scan;
    
    
    	public static void main(String[] args) throws IOException {

		System.out.println("1. Want to Sell");
		System.out.println("2. Want to Buy");
		System.out.println("3. Realization data");
		System.out.print("Choose the option: ");
		
		// Ввод с клавиатуры опции
		Scanner keyboard = new Scanner(System.in);
		int option = keyboard.nextInt();
		System.out.println();
		
		if (option == 1) {
			openFile();
			readFile();
			outFile();
			
			System.out.println();
			System.out.print("What do you need (id)? ");
			int id = keyboard.nextInt();  // ввод с клавиатуры id товара
			
			System.out.print("How many?  ");
			int count = keyboard.nextInt();  // ввод с клавиатуры количества товара
			
			int amount = Integer.parseInt(str[id-1][3]); // читаем из файла количество продукта
			if(count > amount) {
				System.out.println("There is no such amount of this thing!");
			} else {
			
			System.out.println("You choosed: ");
			System.out.print("id - " + str[id-1][0] + "("+ str[id-1][1] +") in amount of "+count);
			System.out.println();
			System.out.print("Book? y/n  ");
			
			String answer = keyboard.next();
			switch(answer) {
			case "y":
				System.out.println("Booking accepted");
				
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
			System.out.print("asdf");
		} else if (option == 3) {
			System.out.print("asdf");
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
