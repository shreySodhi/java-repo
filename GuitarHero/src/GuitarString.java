import java.util.Arrays;

public class GuitarString
{
    private RingBuffer buffer; // ring buffer
    private int time;
    
    // YOUR OTHER INSTANCE VARIABLES HERE

    /** create a guitar string of the given frequency 
     * @throws Exception*/
    public GuitarString(double frequency) throws Exception {
        int length = (int)Math.ceil(44100/frequency);
        buffer = new RingBuffer(length);
        for(int x = 0; x < length;x++)
            buffer.enqueue(0.0);
        time = 0;
    }

    /** create a guitar string with size & initial values given by the array */
    public GuitarString(double[] init) throws Exception {
       buffer = new RingBuffer(init.length);
        for(int x = 0; x < init.length;x++)
            buffer.enqueue(init[x]);
        time = 0;
    }

    /** pluck the guitar string by replacing the buffer with white noise */
    public void pluck() throws Exception {
        for(int x = 0; x < buffer.size();x++){
            buffer.dequeue();
            buffer.enqueue(-.5 + Math.random());
        }

    }

    /** advance the simulation one time step */
    public void tic() throws Exception {
        buffer.enqueue((buffer.dequeue()+buffer.peek())/2 * 0.994);
        time++;
    }

    /** return the current sample */
    public double sample() throws Exception {

        return buffer.peek();
    }

    /** return number of times tic was called */
    public int time() {
        return time; 
    }

    public static void main(String[] args) throws Exception {
        int N = 25;
        double[] samples = { .2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3 };  
        GuitarString testString = new GuitarString(samples);
        // System.out.println(testString.buffer.dequeue());
        // System.out.println(testString.buffer.peek());
        for (int i = 0; i < N; i++) {
            int t = testString.time();
            double sample = testString.sample();
            System.out.printf("%6d %8.4f\n", t, sample);
            testString.tic();
        }
        /*
         * Your program should produce the following output when the main() 
         * method runs (DON'T WORRY ABOUT VERY MINOR DIFFERENCES, E.G. OFF BY 0.001):
                0   0.2000
			    1   0.4000
			    2   0.5000
			    3   0.3000
			    4  -0.2000
			    5   0.4000
			    6   0.3000
			    7   0.0000
			    8  -0.1000
			    9  -0.3000
			   10   0.2988
			   11   0.4482
			   12   0.3984
			   13   0.0498
			   14   0.0996
			   15   0.3486
			   16   0.1494
			   17  -0.0498
			   18  -0.1992
			   19  -0.0006
			   20   0.3720
			   21   0.4216
			   22   0.2232
			   23   0.0744
			   24   0.2232
         */
    }
}