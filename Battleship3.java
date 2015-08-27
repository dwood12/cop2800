import java.util.Scanner;


public class Battleship3 {

public static void main(String[] args) {
		
	System.out.println("Drew Wood");
	System.out.println("5973-5485");
	
	Boolean isRunning = true;
	Scanner myScanner = new Scanner(System.in);
	Boolean switchPlayer = false;
	
	Integer whoseTurn = 0;

	
	
	Player Player1 = new Player();
	Player Player2 = new Player();
	System.out.println();

	
	while(isRunning) {
		
		
		
		
		if(whoseTurn == 0) {
			
			System.out.println("Player 1 > "); 
			Player1.printRadar();
			Player1.printBoard();
			
		}
		
		else {
			System.out.println("Player 2 > ");
			Player2.printRadar();
			Player2.printBoard();
			
		}
		
		String command = myScanner.next();
		
		
		if(command.equalsIgnoreCase("fire")) {
			
			String[] letter = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
			String coordinates = myScanner.next();
			String[] parts = coordinates.split (",");
			String colLetter = parts[0];
			int rowNumber = Integer.parseInt(parts[1]);
			
			int row = rowNumber;
			int col = 0;
			
			Boolean colVALID = false;
			Boolean rowVALID = false;
			
			//check row<11 && row > 0, if so, rowVALID = true;
			if(rowNumber > 1 && rowNumber < 11 ) {
				rowVALID = true;
			}
			
			for(Integer i = 0; i <11; i++) {
				if(colLetter.equals(letter[i]))  {
					col = i;
					colVALID = true;
				}
				
			}
			
			if(rowVALID == true && colVALID == true) { 
				
				//if row and column valid, play
					switchPlayer = true;
			
			if(whoseTurn == 0) {
				
				Player2.checkHit(row,col);
				if(Player2.checkHit(row,col)) {
					Player1.radar[row][col] = "X";
					Player2.board[row][col] = Player2.board[row][col].toLowerCase();
				}
				else {
					Player1.radar[row][col] = "0";
					Player2.board[row][col] = "#";
				}
			}
			else if(whoseTurn==1) {
				
				Player1.checkHit(row,col);
				if(Player1.checkHit(row,col)) {
					Player2.radar[row][col] = "X";
					Player1.board[row][col] = Player1.board[row][col].toLowerCase();
				}
				else {
					Player2.radar[row][col] = "0";
					Player1.board[row][col] = "#";
				}
			}
		}
			else{
				System.out.println("Bad Coordinates");
			}
		}
		
		else if(command.equalsIgnoreCase("quit")) {
			isRunning = false;
			switchPlayer = false;
			System.out.println("Game Over!");

		}
		
		if(switchPlayer) {
			whoseTurn ^= 1;
		}
		
		if(Player1.hasShipsLeft()) {
			isRunning = false;
		}
		else if(Player2.hasShipsLeft()) {
			isRunning = false;
		}
		
		
	}
	
	}

}