
public class StringGenome {

	private String s="";
	
	public StringGenome(String str) {
		
		for (int i=0; i<str.length(); i++) {
			if(str.charAt(i)!='A' & str.charAt(i)!='C' & str.charAt(i)!='T' & str.charAt(i)!='G' ) {
				throw new IllegalArgumentException("Illegal nucleotide");
			}
		}
		s=str;
	}
	
	public void addNucleotide(char a) {
		if(a=='A' || a=='C' || a=='T' || a=='G' ) {
			s=s+a;
		}
		else throw new RuntimeException("Illegal nucleotide");
	}
	
	public char nucleotidAt(int i) {
		if (i<0 || i>=s.length()) {
			return s.charAt(i);
		}
		else throw new RuntimeException("Genome out of bounds");
	}
	
	public int length()      { 
		return s.length();
		}
	
    public String toString() { 
    	return s;
    }
    
    
    
    
    public  boolean isPotentialGene() {

        
        if (s.length() % 3 != 0) return false;
        if (!s.startsWith("ATG")) return false;
        for (int i = 3; i < s.length() - 3; i++) {
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
		StringGenome genome= new StringGenome("ATGCGCCTGCGTCTGTACTAG");
		//StdOut.println(genome.isPotentialGene());
		System.out.println(unhash(56));

	}

}
