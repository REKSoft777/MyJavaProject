
public class poker {
	
	
	public static boolean flash(int[] x) {
		boolean a = true;
		for (int i=1; i<x.length; i++) {
			if (x[i]!=x[0]) {
				a=false;
				break;
			}
		}
		return a;
	}
	
	public static double[][] countHand (double[] a) {
		
	}
	
	
	

	public static void main(String[] args) {
		int[][] deckInt = { {0,1,2,3,4,5,6,7,8,9,10,11,12}, {0,1,2,3,4,5,6,7,8,9,10,11,12}, {0,1,2,3,4,5,6,7,8,9,10,11,12}, {0,1,2,3,4,5,6,7,8,9,10,11,12} };
		String[][] deck = new String[4][13];
		StdRandom.shuffle(deckInt[0]);
		StdRandom.shuffle(deckInt[1]);
		StdRandom.shuffle(deckInt[2]);
		StdRandom.shuffle(deckInt[3]);
		int[] H1 = new int[5];
		for (int i=0; i<5; i++) {
			H1[i]= (int) (Math.random()*4);
		}
		int[] CountH = new int[4];
		int[] H2 = new int[5];
		for (int i=0; i<5; i++) {
			H2[i]= deckInt[H1[i]][CountH[H1[i]]];
			CountH[H1[i]]++;
		}
		int a =0;
	    for (int j=0; j<13; j++) {
	    	if (deckInt[0][j]==0) {
	    		deck[0][j]= "Ace of Heart";
	    	}
	    	else if (deckInt[0][j]==10) {
	    		deck[0][j]= "Jack of Heart";
	    	}
	    	else if (deckInt[0][j]==11) {
	    		deck[0][j]= "Queen of Heart";
	    	}
	    	else if (deckInt[0][j]==12) {
	    		deck[0][j]= "King of Heart";
	    	}
	    	else {
	    		a= deckInt[0][j] + 1;
		        deck[0][j]= a + " of Heart";
	    	}
		}
	    for (int j=0; j<13; j++) {
	    	if (deckInt[1][j]==0) {
	    		deck[1][j]= "Ace of Spade";
	    	}
	    	else if (deckInt[1][j]==10) {
	    		deck[1][j]= "Jack of Spade";
	    	}
	    	else if (deckInt[1][j]==11) {
	    		deck[1][j]= "Queen of Spade";
	    	}
	    	else if (deckInt[1][j]==12) {
	    		deck[1][j]= "King of Spade";
	    	}
	    	else {
	    		a= deckInt[1][j] + 1;
		        deck[1][j]= a + " of Spade";
	    	}
		}
	    for (int j=0; j<13; j++) {
	    	if (deckInt[2][j]==0) {
	    		deck[2][j]= "Ace of Diamond";
	    	}
	    	else if (deckInt[2][j]==10) {
	    		deck[2][j]= "Jack of Diamond";
	    	}
	    	else if (deckInt[2][j]==11) {
	    		deck[2][j]= "Queen of Diamond";
	    	}
	    	else if (deckInt[2][j]==12) {
	    		deck[2][j]= "King of Diamond";
	    	}
	    	else {
	    		a= deckInt[2][j] + 1;
		        deck[2][j]= a + " of Diamond";
	    	}
		}
	    
	    for (int j=0; j<13; j++) {
	    	if (deckInt[3][j]==0) {
	    		deck[3][j]= "Ace of Club";
	    	}
	    	else if (deckInt[3][j]==10) {
	    		deck[3][j]= "Jack of Club";
	    	}
	    	else if (deckInt[3][j]==11) {
	    		deck[3][j]= "Queen of Club";
	    	}
	    	else if (deckInt[3][j]==12) {
	    		deck[3][j]= "King of Club";
	    	}
	    	else {
	    		a= deckInt[3][j] + 1;
		        deck[3][j]= a + " of Club";
	    	}
		}
	    String[] Hand= new String[5];
	    for (int i=0; i<5; i++) {
	    	Hand[i]= deck[H1[i]][H2[i]];
	    	System.out.println(Hand[i]);
	    }
	   

	}

}
