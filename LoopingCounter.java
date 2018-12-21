package p6;

public class LoopingCounter {
	private int counter = 0;
	private int low = 0;
	private int high;
	
	public LoopingCounter(int high) {
		this.high = high;
	}
	
	public LoopingCounter(int low, int high) {
		this(high);
		this.low = low;
	}
	
	public LoopingCounter(int low, int high, int beginAt) {
		this(low, high);
		this.counter = beginAt;
	}
	
	public void increase() {
		counter++;
		if (counter > high)
			counter = low;
	}
	
	public void decrease() {
		counter--;
		if (counter < low)
			counter = high;		
	}
	
	public int getCounter() {
		return counter;
	}
}