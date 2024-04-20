package sudoko;

import java.util.Scanner;

public class sudoko2 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("\n**********SUDOKU GAME************\n");
		int arr[][]= {
				{0, 0, 3, 0},
				{0, 0, 1, 0},
				{0, 0, 0, 1},
				{3, 0, 2, 0}
		};
				printboard(arr);
				start(arr);
			}
	private static void printboard(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
			public static void start(int[][] arr) {
		        int count=0;
				for (int i = 0; i < arr.length;i++) {
					count=0;
					for (int j = 0; j < arr[i].length;) {
						if (arr[i][j] == 0) {
							System.out.println("\nEnter the Number for "+i+" row "+j+" column");
							int number = sc.nextInt();
							if (checkRow(arr, number, i)) {
								if (checkcol(arr, number, j)) {
										arr[i][j] = number;
										j++;
										System.out.println("Value added successfully\n");
                                        printboard(arr);									
									}
                                        else {
										count++;	
										System.out.println("Invalid Number");
                                        checkchance(count); 
									}
							} else {
								count++;
								System.out.println("Invalid Number");
								  checkchance(count);
							}
						}
						else {
							j++;
						}
					}
				}
				System.out.println("\n**************You have successfully solve the Sudoku Game**************");
				
			}
             public static  void checkchance(int count) {
            	 if(count==1) {
					 System.out.println("\n*****************Game Over***************");
                     System.exit(0);} 
             }
			public static boolean checkRow(int arr[][], int number, int row) {
				for (int i = 0; i < arr.length; i++) {
					if (arr[row][i] == number) {
						return false;
					}
				}
				return true;
			}

			public static boolean checkcol(int arr[][], int number, int col) {
				for (int i = 0; i < arr.length; i++) {
					if (arr[i][col] == number) {
						return false;
					}
				}
				return true;
			}
}
