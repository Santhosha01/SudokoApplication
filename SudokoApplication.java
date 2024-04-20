package sudoko;

import java.util.Scanner;

public class SudokoApplication {
	static Scanner sc = new Scanner(System.in);
        static int gridsize=9;
	public static void main(String[] args) {
		int arr[][]= {
				{7, 0 ,2 ,0 ,5 ,0 ,6 ,0 ,0},
				{0, 0, 0, 0, 0, 3, 0, 0, 0},
				{1, 0, 0, 0, 0, 9, 5, 0, 0},
				{8, 0, 0, 0, 0, 0, 0, 9, 0},
				{0, 4, 3, 0, 0, 0, 7, 5, 0},
				{0, 9, 0, 0, 0, 0, 0, 0, 8},
				{0, 0, 9, 7, 0, 0, 0, 0, 5},
				{0, 0, 0, 2, 0, 0, 0, 0, 0},
				{0, 0, 7, 0, 4, 0, 2, 0, 3}
		};
				printboard(arr);
				start(arr);
				printboard(arr);
			}
	private static void printboard(int[][] arr) {
		for (int i = 0; i < gridsize; i++) {
			for (int j = 0; j < gridsize; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
			public static void start(int[][] arr) {
		        int count=0;
				for (int i = 0; i < gridsize; i++) {
					for (int j = 0; j < gridsize; j++) {
						if (arr[i][j] == 0) {
							System.out.println("\nEnter the Number");
							int number = sc.nextInt();
							if (checkRow(arr, number, i)) {
								if (checkcol(arr, number, j)) {
									if (checkBox(arr, number, i, j)) {
										arr[i][j] = number;
										System.out.println("Number added successfully\n");
                                                                                printboard(arr);									
									} else {
										count++;
										System.out.println("Invalid Number, you have only "+ (3- count)+" chance left");
                                                                                checkchance(count);
									}
								} else {
									count++;
									System.out.println("Invalid Number, you have only"+ (3- count)+" chance left");
									checkchance(count);
									break;
								}
							} else {
								count++;
								System.out.println("Invalid Number, you have only "+ (3- count)+" chance left ");
								checkchance(count);
								break;
							}
						}
					}
				}
			}
             public static  void checkchance(int count) {
            	 if(count==3) {
		     System.out.println("Game Over");
                     System.exit(0);
		 } 
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

			public static boolean checkBox(int arr[][], int number, int row, int col) {
				int presentrow = row - row % 3;
				int presentcol = col - col % 3;
				for (int i = presentrow; i < presentrow + 3; i++) {
					for (int j = presentcol; j < presentcol + 3; j++) {
						if (arr[i][j] == number) {
							return false;
						}
					}
				}
				return true;
			}
}
