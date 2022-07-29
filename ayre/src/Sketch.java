
public class Sketch {
    private final Vector profile;         

    public Sketch(String text, int k, int d) {
        int n = text.length();
        double[] freq = new double[d];
        for (int i = 0; i < n-k+1; i++) {
            String kgram = text.substring(i, i+k);
            int hash = kgram.hashCode();
            freq[Math.abs(hash % d)] += 1;
        }
        Vector vector = new Vector(freq);
        profile = vector.direction();
    }
    
    

    public double similarTo(Sketch other) {
        return profile.dot(other.profile);
    }

    public String toString() {
        return "" + profile;
    }

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        In in1=new In(args[2]);
        In in2=new In(args[3]);
        String text1=in1.readAll();
        String text2=in2.readAll();
        Sketch sketch1 = new Sketch(text1, k, d);
        Sketch sketch2= new Sketch(text2,k,d);
        StdOut.println(sketch1.similarTo(sketch2));
    }
}



