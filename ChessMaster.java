import java.awt.PrintJob;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.print.DocPrintJob;

public class ChessMaster implements Comparable<ChessMaster> {
	enum Pawns {
		K, Q, R, N, B, P
	}

	private String name;
	private int row;
	private char column;
	private Pawns pawn;

	 static String [] positions = {
			 "C:\\Users\\MARIA\\Desktop\\ChessMaster\\InitialPosition.txt",
			 "C:\\Users\\MARIA\\Desktop\\ChessMaster\\Ruy Lopez.txt",
			 "C:\\Users\\MARIA\\Desktop\\ChessMaster\\Italian Game.txt",
			 "C:\\Users\\MARIA\\Desktop\\ChessMaster\\Sicilian Defense.txt",
			 "C:\\Users\\MARIA\\Desktop\\ChessMaster\\French Defense.txt",
			 "C:\\Users\\MARIA\\Desktop\\ChessMaster\\Caro-Kann Defense.txt",
			 "C:\\Users\\MARIA\\Desktop\\ChessMaster\\Pirc Defense.txt",
			 "C:\\Users\\MARIA\\Desktop\\ChessMaster\\Queens Gambit.txt",
			 "C:\\Users\\MARIA\\Desktop\\ChessMaster\\Indian Defenses.txt",
			 "C:\\Users\\MARIA\\Desktop\\ChessMaster\\English Opening.txt",
			 "C:\\Users\\MARIA\\Desktop\\ChessMaster\\Reti Opening.txt",
			 };

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getColumn() {
		return column;
	}

	public void setColumn(char column) {
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setPawn(Pawns pawn) {
		this.pawn = pawn;
	}

	public Pawns getPawn() {
		return pawn;
	}

	public void printAll() {
		System.out.println("Name: " + name);
		System.out.println("White Row: " + row);
		System.out.println("White Column: " + column);
		System.out.println("Pawn: " + pawn);
		System.out.println();
	}

	private ChessMaster(String name, int row, char column, Pawns pawn) {
		this.name = name;
		this.row = row;
		this.column = column;
		this.pawn = pawn;

	}
	 private static HashMap<Integer, ArrayList<ChessMaster>> returnMoves(int counter) {
			
			
			 HashMap<Integer, ArrayList<ChessMaster>> hm = new HashMap<Integer, ArrayList<ChessMaster>>();
			  
			if(counter == 1) {
				System.out.println();
				System.out.println("\t\t\t\t{Initial Position}");
				System.out.println();
			    hm = printPositions(positions[0]);    
			}else if(counter ==  2) {
				System.out.println();
				System.out.println("\t\t\t\t{Ruy Lopez}");
				System.out.println();
				hm = printPositions(positions[1]); 
			}else if(counter == 3) {
				System.out.println();
				System.out.println("\t\t\t\t{Italian Game}");
				System.out.println();
				hm = printPositions(positions[2]); 
				
			}else if(counter ==  4 ) {
				System.out.println();
				System.out.println("\t\t\t\t{Sicilian Defence}");
				System.out.println();
				hm = printPositions(positions[3]); 
				
			}else if(counter ==  5) {
				System.out.println();
				System.out.println("\t\t\t\t{French Defence}");
				System.out.println();
				hm = printPositions(positions[4]); 
				
			}else if(counter == 6) {
				System.out.println();
				System.out.println("\t\t\t\t{CaroKann Defence}");
				System.out.println();
				hm = printPositions(positions[5]);
				
			}else if(counter == 7) {
				System.out.println();
				System.out.println("\t\t\t\t{Pirc Defence}");
				System.out.println();
				hm = printPositions(positions[6]); 
				
			}else if(counter == 8) {
				System.out.println();
				System.out.println("\t\t\t\t{Queen Gambit}");
				System.out.println();
				hm = printPositions(positions[7]); 
				
			}else if(counter == 9) {
				System.out.println();
				System.out.println("\t\t\t\t{Indian Defences}");
				System.out.println();
				hm = printPositions(positions[8]); 
				
			}else if(counter == 10) {
				System.out.println();
				System.out.println("\t\t\t\t{English Opening}");
				System.out.println();
				hm = printPositions(positions[9]); 
				
			}else if(counter == 11) {
				System.out.println();
				System.out.println("\t\t\t\t{Reti Opening}");
				System.out.println();
				hm = printPositions(positions[10]); 
			}
			  
			return hm;
		
	 }
	
	
	private static void chessBoard(int counter ) {
		
		int rows = 8;
		int columns = 8;
		String[][] array = new String[rows][columns];
		int count = 8;
		char pawn = ' ';
		HashMap<Integer, ArrayList<ChessMaster>> hm = returnMoves(counter);
		
		
		ChessMaster chessMaster = null;
		
		printAlphabetic(rows);
		System.out.println();
		printLine(rows);
		System.out.println();

		for (int i = 0; i <= array.length - 1; i++) {
			pawn = 'a';

			System.out.print("\t|");

			if (i % 2 == 0) {

				for (int j = 0; j <= array[i].length - 1; j++) {
					if (j % 2 == 0) {

						System.out.print("\t|");

					} else {
						for (int k = 1; k <= 8; k++) {
							array[i][j] = "|";
							System.out.print(array[i][j]);
						}

					}

				}
				System.out.println();
				System.out.print(count + "\t|  ");
				for (int j = 0; j <= array[i].length - 1; j++) {

					if (j % 2 == 0) {
						chessMaster = returnObject(count, hm, pawn);
						if (chessMaster != null) {
							array[i][j] = " " + "<" + chessMaster.pawn + ">" + "\t";
							System.out.print(array[i][j] + "|");

							if (j == array[i].length - 1) {
								System.out.print("\t" + count);
							}
						} else {

							array[i][j] = "\t";
							System.out.print(array[i][j] + "|");

							if (j == array[i].length - 1) {
								System.out.print("\t" + count);
							}
						}
						pawn++;

					}

					// }

					// end the first option of white pawns with j% 2==0

					else if (j % 2 != 0) {
						chessMaster = returnObject(count, hm, pawn);
						if (chessMaster != null) {

							for (int k = 1; k <= 8; k++) {
								if (k == 3) {
									break;
								} else {
									array[i][j] = "|";
								}
								System.out.print(array[i][j]);
							}
							array[i][j] = "" + "<" + chessMaster.pawn + ">|||";
							System.out.print(array[i][j]);

							if (j == array[i].length - 1) {
								System.out.print("\t" + count);
							}

						} else {
							for (int k = 1; k <= 8; k++) {

								array[i][j] = "|";
								System.out.print(array[i][j]);
							}

							if (j == array[i].length - 1) {
								System.out.print("\t" + count);
							}

						}

						pawn++;
					}
					// end of second option of white pawns with j % 2 !=0

				}

				System.out.println();
				System.out.print("\t|");
				for (int j = 0; j <= array[i].length - 1; j++) {

					if (j % 2 == 0) {
						System.out.print("\t|");

					} else {
						for (int k = 1; k <= 8; k++) {
							array[i][j] = "|";
							System.out.print(array[i][j]);
						}

					}
				}

			} else if (i % 2 != 0) {

				for (int j = 0; j <= array[i].length - 1; j++) {
					if (j % 2 == 0) {
						for (int k = 1; k <= 8; k++) {
							array[i][j] = "|";
							System.out.print(array[i][j]);
						}

					} else {
						System.out.print("\t|");
					}

				}
				System.out.println();
				System.out.print(count + "\t|");

				for (int j = 0; j <= array[i].length - 1; j++) {

					if (j % 2 == 0) {
						chessMaster = returnObject(count, hm, pawn);
						if (chessMaster != null) {

							for (int k = 1; k <= 8; k++) {

								if (k == 3) {
									break;

								} else {
									array[i][j] = "|";
								}
								System.out.print(array[i][j]);

							}
							array[i][j] = "" + "<" + chessMaster.pawn + ">|||";
							System.out.print(array[i][j]);

							if (j == array[i].length - 1) {
								System.out.print("\t" + count);
							}

						} else {

							for (int k = 1; k <= 8; k++) {
								array[i][j] = "|";

								System.out.print(array[i][j]);
							}
							if (j == array[i].length - 1) {
								System.out.print("\t" + count);
							}

						}
						pawn++;

					} else if (j % 2 != 0) {
						chessMaster = returnObject(count, hm, pawn);
						if (chessMaster != null) {

							array[i][j] = "  " + "<" + chessMaster.pawn + ">";
							System.out.print(array[i][j] + "\t|");

							if (j == array[i].length - 1) {
								System.out.print("\t" + count);
							}

						} else {
							System.out.print("\t|");
							if (j == array[i].length - 1) {
								System.out.print("\t" + count);
							}
						}

						pawn++;
					}

				}
				System.out.println();
				System.out.print("\t|");
				for (int j = 0; j <= array[i].length - 1; j++) {
					if (j % 2 == 0) {
						for (int k = 1; k <= 8; k++) {
							array[i][j] = "|";
							System.out.print(array[i][j]);
						}

					} else {
						System.out.print("\t|");
					}
				}

			}

			System.out.println();
			count--;

		}

		printLine(rows);
		System.out.println();
		printAlphabetic(rows);
		
	}

	private static void printLine(int number) {
		System.out.print("\t");
		for (int i = 1; i < 8.2 * number; i++) {
			System.out.print("-");
		}

	}

	private static void printAlphabetic(int number) {
		char character = 'a';
		for (int i = 1; i <= number; i++) {
			System.out.print("\t" + "    " + character + " ");
			character++;
		}

	}

	private static ChessMaster returnObject(int count, HashMap<Integer, ArrayList<ChessMaster>> hm, char pawn) {
		ChessMaster chessMaster = null;
		HashMap<Integer, ArrayList<ChessMaster>> map = hm;
		for (Map.Entry<Integer, ArrayList<ChessMaster>> entry : map.entrySet()) {

			Integer key = entry.getKey();
			if (key == count) {
				ArrayList<ChessMaster> value = entry.getValue();
				for (ChessMaster ch : value) {
					if (ch.getColumn() == pawn)
						chessMaster = ch;
				}
			}
		}

		return chessMaster;

	}

	private static HashMap<Integer, ArrayList<ChessMaster>> printPositions(String path) {

		List<ChessMaster> listPawns = new ArrayList<ChessMaster>();
		

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();

			while (line != null) {
				String[] attributes = line.split(",");
				ChessMaster chess = createPosition(attributes);

				listPawns.add(chess);

				line = br.readLine();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		HashMap<Integer, ArrayList<ChessMaster>> hm = new HashMap<Integer, ArrayList<ChessMaster>>();
		ArrayList<ChessMaster> values = null;
		if (listPawns != null) {
			for (int i = 1; i <= 8; i++) {
				values = new ArrayList<ChessMaster>();

				for (ChessMaster ch : listPawns) {
					if (ch.getRow() == i) {
						values.add(ch);
					}
				}
				if (!values.contains(null)) {
					Collections.sort(values);
				}
				hm.put(i, values);
			}
		}
		
		
		

		return hm;

	}


	
	
	
	private static ChessMaster createPosition(String[] metadata) {
		String name = metadata[0];
		int row = Integer.parseInt(metadata[1]);
		char column = metadata[2].charAt(0);
		Pawns pawn = Pawns.valueOf(metadata[3]);

		return new ChessMaster(name, row, column, pawn);
	}
	

	public static void printMenu() {
		char character = 0;
		int counter = 0;
		//retiOpening();
		
		System.out.println("\t\t\t*******ChessMaster*******");
		System.out.println();
		chessBoard(counter);
		counter++;
		 
		do {
			System.out.println();
			System.out.println();
			System.out.println("\tEnter Space for change the position of Pawns or press e or E for exit");
			Scanner sc = new Scanner(System.in);

			String userInput = sc.nextLine();
			if (userInput.length() > 1 || userInput.length() == 0) {
				while (userInput.length() > 1 || userInput.length() == 0 ) {
					System.out.println("Invalid UserInput");
					System.out.println("Enter Space for change the position of Pawns or press e or E for exit");
					userInput = sc.nextLine();
				}
				if(userInput.length()== 1) {
			   character =userInput.charAt(0);	
			   if(character== 69 || character == 101) {
				   break;
				} else {
			   while ((int) character != 32) {
					System.out.println("Invalid UserInput");
					System.out.println("Enter Space for change the position of Pawns or press e or E for exit");
					character = sc.nextLine().charAt(0);
					if(character == 69 || character== 101) {
						break;
					}
				}
			   if (character == 32) {
				   	
				   	if(counter== positions.length+1) {
						   counter=0;
						   System.out.println();
						   System.out.println("\t\t\t*******ChessMaster*******");
							System.out.println();
					   }
				   	chessBoard(counter);
					counter++;
				}
			   }
				}
			}
			else if (userInput.length() == 1) {
				  character = userInput.charAt(0);
				  if(character== 69 || character == 101) {
					  break;
				  }else {
					while ((int) character != 32) {
						System.out.println("Invalid UserInput");
						System.out.println("Enter Space for change the position of Pawns or press e or E for exit");
						character = sc.nextLine().charAt(0);
						if(character== 69 || character == 101) {
							break;
						}
					}
					if (character == 32) {
						 
						 if(counter== positions.length+1) {
							   counter=0;
							   System.out.println();
							   System.out.println("\t\t\t*******ChessMaster*******");
								System.out.println();
						   }
						 chessBoard(counter);
						counter++;
					}
				}

			}

			} while (character != 69 && character != 101);

	}

	@Override
	public int compareTo(ChessMaster o) {

		if (this.getColumn() > o.getColumn()) {
			return 1;
		} else if (this.getColumn() == o.getColumn()) {
			return 0;
		} else {
			return -1;
		}

	}

}








	
	
	
	
		
	
			
			
			
		