
public class Genome {

	private char[] a = new char[2];
	private int n=0;
	
	public void addNucleotide(char c) {
        if (n == a.length) resize();
        if (c == 'A' || c == 'C' || c == 'G' || c == 'T') {
        	//n++;
            a[n] = c;
            n++;
	}
        else throw new RuntimeException("Illegal nucleotide");
    }

    private void resize() {
        char[] temp = new char[2*n];
        for (int i = 0; i < n; i++)
            temp[i] = a[i];
        a = temp;
    }

    public char nucleotideAt(int i) {
        if (i < n) return a[i];
        else throw new RuntimeException("Genome out of bounds");
    }

    public int length() {
        return n;
    }
    
    public  boolean isPotentialGene() {

        
    	if (n%3 != 0) return false;
        String s = "";
        for (int i = 0; i < n; i++) {
        	s=s+a[i];
        }
        if (!s.startsWith("ATG")) return false;
        for (int i = 3; i < n - 3; i+=3) {
        	
            String codon = s.substring(i, i+3);
            if (codon.equals("TAA")) return false;
            if (codon.equals("TAG")) return false;
            if (codon.equals("TGA")) return false;
        } 
        if (s.endsWith("TAA")) return true;
        if (s.endsWith("TAG")) return true;
        if (s.endsWith("TGA")) return true;
        return false;
    }
	
	
	public static void main(String[] args) {
		
		Genome genome = new Genome();
        genome.addNucleotide('A');
        genome.addNucleotide('T');
        genome.addNucleotide('G');
        genome.addNucleotide('C');
        genome.addNucleotide('G');
        genome.addNucleotide('C');
        genome.addNucleotide('C');
        genome.addNucleotide('T');
        genome.addNucleotide('G');
        genome.addNucleotide('C');
        genome.addNucleotide('G');
        genome.addNucleotide('T');
        genome.addNucleotide('C');
        genome.addNucleotide('T');
        genome.addNucleotide('G');
        genome.addNucleotide('T');
        genome.addNucleotide('A');
        genome.addNucleotide('C');
        genome.addNucleotide('T');
        genome.addNucleotide('A');
        genome.addNucleotide('G');
        for (int i = 0; i < genome.length(); i++) {
            StdOut.print(genome.nucleotideAt(i));
        }
        StdOut.println();
        StdOut.print(genome.isPotentialGene());
		//ATGCGCCTGCGTCTGTACTAG
        //ATGCGCCTGCGTCTGTACTAG

	}

}
