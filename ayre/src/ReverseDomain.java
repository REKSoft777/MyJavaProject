import java.util.Arrays;

public class ReverseDomain implements Comparable<ReverseDomain> {
    private final String[] fields;

    public ReverseDomain(String name) {
        fields = name.split("\\.");
    }

    public String toString() {
        if (fields.length == 0) return "";
        String s = fields[0];
        for (int i = 1; i < fields.length; i++)
            s = fields[i] + "." + s;
        return s;
    }

    public int compareTo(ReverseDomain that) {
        for (int i = 0; i < Math.min(fields.length, that.fields.length); i++) {
            String s = this.fields[fields.length - i - 1];
            String t = that.fields[that.fields.length - i - 1];
            int c = s.compareTo(t);
            if      (c < 0) return -1;
            else if (c > 0) return +1;
        }
        return fields.length - that.fields.length;
    }

    public static void main(String[] args) {

        String[] names = StdIn.readAllStrings(); //mish deman btezbat w mish deman ele glede zabetlon yeha
        ReverseDomain[] domains = new ReverseDomain[names.length];
        for (int i = 0; i < domains.length; i++) {
            domains[i] = new ReverseDomain(names[i]);
        }
        Arrays.sort(domains);
        for (int i = 0; i < domains.length; i++) {
            StdOut.println(domains[i]);
        }
    }

}
