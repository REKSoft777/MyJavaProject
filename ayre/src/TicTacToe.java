import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {

	static HashSet<Integer> player=new HashSet<>();
	static HashSet<Integer> cpu=new HashSet<>();
	public static void main(String[] args) {
			char[][] board= {{' ','|',' ','|',' '},{'-','+','-','+','-'},{' ','|',' ','|',' '},{'-','+','-','+','-'},{' ','|',' ','|',' '}};
			printBoard(board);
			boolean game=true;
			while(game) {
				System.out.println("Choose placement: 1-9");
				Scanner myInput=new Scanner(System.in);
				int num=myInput.nextInt();
				while(player.contains(num) || cpu.contains(num)) {
					System.out.println("placement already filled, pick another option");
					myInput=new Scanner(System.in);
					num=myInput.nextInt();
				}
				place(board,num,"player");
				printBoard(board);
				game=check();
				if(!game) break;
				int rand=(int) (9*Math.random()+1);
				while(player.contains(rand) || cpu.contains(rand)) {
					rand=(int) (9*Math.random()+1);
				}
				place(board,rand,"cpu");
				printBoard(board);
				game=check();
			}
			
			result();
		}

		private static void result() {
			List topRow=Arrays.asList(1,2,3);
			List midRow=Arrays.asList(4,5,6);
			List bottomRow=Arrays.asList(7,8,9);
			List leftCol=Arrays.asList(1,4,7);
			List midCol=Arrays.asList(2,5,8);
			List rightCol=Arrays.asList(3,6,9);
			List leftDiag=Arrays.asList(1,5,9);
			List rightDiag=Arrays.asList(3,5,7);
			List<List> winning=new ArrayList<List>();
			winning.add(topRow);
			winning.add(midRow);
			winning.add(bottomRow);
			winning.add(leftCol);
			winning.add(midCol);
			winning.add(rightCol);
			winning.add(leftDiag);
			winning.add(rightDiag);
			for(List curr: winning) {
				if(player.containsAll(curr)) {
					System.out.println("Congratulation");
					return;
				}
				else if(cpu.containsAll(curr)) {
					System.out.println("Try another time");
					return;
				}
			}
			if(player.size()+cpu.size()==9) System.out.println("It's a draw");
	}

		private static boolean check() {
			List topRow=Arrays.asList(1,2,3);
			List midRow=Arrays.asList(4,5,6);
			List bottomRow=Arrays.asList(7,8,9);
			List leftCol=Arrays.asList(1,4,7);
			List midCol=Arrays.asList(2,5,8);
			List rightCol=Arrays.asList(3,6,9);
			List leftDiag=Arrays.asList(1,5,9);
			List rightDiag=Arrays.asList(3,5,7);
			List<List> winning=new ArrayList<List>();
			winning.add(topRow);
			winning.add(midRow);
			winning.add(bottomRow);
			winning.add(leftCol);
			winning.add(midCol);
			winning.add(rightCol);
			winning.add(leftDiag);
			winning.add(rightDiag);
			for(List curr: winning) {
				if(player.containsAll(curr) || cpu.containsAll(curr)) return false;
			}
			if(player.size()+cpu.size()==9) return false;
			return true;
	}

		private static void place(char[][] board, int num, String user) {
			char ans='0';
			if(user.equals("player")) ans='X';
			switch (num) {
			   case 1: board[0][0]=ans;
			         break;
			   case 2: board[0][2]=ans;
			         break;
			   case 3: board[0][4]=ans;
			         break;
			   case 4: board[2][0]=ans;
			         break;
			   case 5: board[2][2]=ans;
			         break;
			   case 6: board[2][4]=ans;
			         break;
			   case 7: board[4][0]=ans;
			         break;
			   case 8: board[4][2]=ans;
			         break;
			   case 9: board[4][4]=ans;
			         break;
			}
			if(user.equals("player")) player.add(num);
			else cpu.add(num);
		
	}

		public static void printBoard(char[][] board) {
			for (int i=0; i<5; i++) {
				   for (int j=0; j<5; j++) {
					   System.out.print(board[i][j]);
				   }
				   System.out.print("\n");
			   }
		 }

	}


