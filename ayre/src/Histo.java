import java.awt.Color;

public class Histo {

	private final double[] freq;
	private double max;
	
	public Histo(int n) {
		
		freq=new double[n+1];
		max=0;
	}
	
	public void drawm(Draw d) {
		
		d.setPenColor(Color.red);
		double total =0;
		for (int i=0; i<freq.length; i++) {
			total+=freq[i];
		}
		double avg=total/2.0;
		double m=0;
		for (int i=0; i<freq.length; i++) {
			double oldm=m;
			m+=freq[i];
			if (m>=avg) {
				m=i-0.5+(avg-oldm)/(m-oldm);
				break;
			}
		}
		
		
		
		d.line(m,0,m,max);
	}
	
	public void draw(Draw d) {
		
		d.setYscale(0, max);
		d.setXscale(-1,freq.length);
		for (int i=0; i<freq.length; i++) {
			d.filledRectangle(i, freq[i]/2, 0.5, freq[i]/2);
		}
		
		
	}
	
	public static int binomial(int n,double p) {
		
		int count=0;
		for (int i=0; i<n; i++) {
			if (StdRandom.bernoulli(p)) {
				count++;
			}
		}
		return count;
	}
	
	public void addDataPoint(int i) {
		
		freq[i]++;
		if (freq[i]>max) {
			max=freq[i];
		}
	}
	
	public void fromCounter(Counter[] counter) {
		
		for (int i=0; i<freq.length; i++) {
			freq[i]= counter[i].value();
		}
		max=StdStats.max(freq);
	}
	
	public static void main(String[] args) {
		
		int n=Integer.parseInt(args[0]);
		int trial=Integer.parseInt(args[1]);
		Histo hist=new Histo(n);
		Draw draw= new Draw();
		Counter[] counter = new Counter[n+1];
		for (int i=0; i<n+1; i++) {
			counter[i]=new Counter(i+"",trial);
		}
		for (int t=0; t<10000; t++) {
			counter[binomial(n,0.5)].increment();
		  }
		hist.fromCounter(counter);
		hist.draw(draw);
		   
		
		//Draw dra= new Draw();
		//Histo histi=new Histo(n);
		//for (int t=0; t<trial; t++) {
		//histi.addDataPoint(binomial(n,0.2));
	  //}
		//for (int i=0; i<n+1; i++) {
			//System.out.print(hist[0].freq[i]+ " ");
		//}
		//System.out.println();
	   //histi.draw(dra);
	   //histi.drawm(dra);
		
	}
	 

}
