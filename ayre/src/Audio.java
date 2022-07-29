import java.awt.Color;
import java.util.Scanner;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;


public class Audio {
		
	   protected static final int SAMPLE_RATE = 44100;


	   public static byte[] createSinWaveBuffer(double freq, int t) {
	       int samples = (int)((t * SAMPLE_RATE) );
	       byte[] output = new byte[samples];
	           //
	       double period = (double)SAMPLE_RATE / freq;
	       for (int i = 0; i < output.length; i++) {
	           double angle = 2.0 * Math.PI * i / period;
	           output[i] = (byte)(Math.sin(angle) *127f);  }

	       return output;
	   }



	   public static void main(String[] args) throws LineUnavailableException {
	       final AudioFormat af = new AudioFormat(SAMPLE_RATE, 8, 1, true, true);
	       SourceDataLine line = AudioSystem.getSourceDataLine(af);
	       line.open(af, SAMPLE_RATE);
	       line.start();

	       
	       double freq = 440;

	       byte [] toneBuffer = createSinWaveBuffer(freq, 10);
	       line.write(toneBuffer, 0, toneBuffer.length);

	           

	       line.drain();
	       line.close();
	    }

	
		}