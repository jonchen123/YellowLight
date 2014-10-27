
public class SimPhysics {
	
	private final int vf = 0;
	private double vi = 0;
	private double a = 0;
	private double deltaX = 0;
	private double stoppingTime = 0;
	private double fromLight = 0;
	private double coast = 0;
	private double reactionTime = 1;
	
	public SimPhysics(double viT, double aT, double frmLgt){
		vi = viT;
		a = aT;
		deltaX = calcStoppingDistance(vi, a);
		stoppingTime = stoppingTime(vi, a);
		fromLight = frmLgt;
		coast = distanceToReact();
	}
	
	//returns the distance the car needs to travel before stopping in ft
	public double calcStoppingDistance(double vi, double a){
		double deltaX = (Math.pow(vf, 2) - Math.pow(vi, 2))/(2*a);
		return deltaX;
	}
	
	//returns the time it takes to stop the car in seconds
	public double stoppingTime(double vi, double a){
		double t = (vf - vi)/a;
		return t;
	}
	
	public boolean canStop(){//determines if you can stop before the light
		if(fromLight > deltaX){
			return true;
		} return false;
	}
	
	//calculates the distance traveled before hitting the brakes
	//assumes that the reaction time is 1s (very liberal)
	public double distanceToReact(){
		double coast = vi * reactionTime;
		return coast;
	}
	
	
	
	public static void main(String[] args){
		SimPhysics test = new SimPhysics(10, -5, 5);
		System.out.println(test.calcStoppingDistance(10, -5));
		System.out.println(test.stoppingTime(10, -5));
		System.out.println(test.canStop());
	}
	
}
