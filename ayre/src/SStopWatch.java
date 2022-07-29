
public class SStopWatch {

	private  long start;
	private boolean isPaused;
	private double chrono;
	
	public SStopWatch() {
		
		start= System.currentTimeMillis();
		chrono=0;
		
	}
	
	public double elapsedTime() {
		
		if (!isPaused) {
		long now = System.currentTimeMillis();
		return (now-start)/1000.0+chrono;
		
		}
		return chrono;
	}
	
	public void  reset() {
		
		isPaused=true;
		chrono=0;
	}
	
    public void  restart() {
		
		start=System.currentTimeMillis();
		chrono=0;
	}
	
	 public void stop() {
		 
		 if (isPaused) {
			 return;
		 }
		 isPaused=true;
		 long now = System.currentTimeMillis();
		 chrono=(now-start)/1000.0;
	 }
	 
	 public void start() {
		 
		 isPaused=false;
		 start=System.currentTimeMillis();
	 }
	 
	 public static double Harmonic(int n) {
		 
		 if (n==1) {
			 return 1;
		 }
		 return 1.0/n+Harmonic(n-1);
	 }
	
	
	
	public static void main(String[] args) {
		SStopWatch timer1 = new SStopWatch();
		double sum=0;
		for (int i=1; i<10000; i++) {
			sum+=1.0/i;
		}
		System.out.println(sum);
		System.out.println(timer1.elapsedTime());
		timer1.restart();
		
		sum=0;
		double h=Harmonic(10000);
		System.out.println(h);
		System.out.println(timer1.elapsedTime());
		//timer1.start();
		//sum=0;
		//for (int i=0; i<1000000000; i++) {
			//sum+=Math.sqrt(i);
		//}
		//System.out.println(timer1.elapsedTime());
	}

}

