import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Out out=new Out(args[0]);
		for(int i=1;i<1000;i++) {
			int j=i+1;
			out.println(i+","+j);
		}
	}

}
