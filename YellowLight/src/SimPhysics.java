
public class SimPhysics {
	
	private final int vf = 0;
	private double vi = 0;
	private double a = 0;
	private double deltaX = 0;
	private double stopTime = 0;
	private double fromLight = 0;
	private double coast = 0;
	private double reactionTime = 1;
	private double lightTime = 0;
	
	public SimPhysics(double viT, double aT, double frmLgt, double yellowTime){
		vi = viT;
		a = aT;
		deltaX = calcStoppingDistance(vi, a);
		stopTime = stoppingTime(vi, a);
		fromLight = frmLgt;
		coast = distanceToReact();
		lightTime = yellowTime;
	}
	
	public double getLightTime(){
		return lightTime;
	}
	
	public double getCoast(){
		return coast;
	}
	
	public double getfromLight(){
		return fromLight;
	}
	
	public double getStopTime(){
		return stopTime;
	}
	
	public double getDeltaX(){
		return deltaX;
	}
	
	public double getA(){
		return a;
	}
	
	public double getVI(){
		return vi;
	}
	
	//returns the distance the car needs to travel before stopping in ft
	public double calcStoppingDistance(double vi, double a){
		double deltaX = (Math.pow(vf, 2) - Math.pow(vi, 2))/(2*a);
		return deltaX;
	}
	
	//returns the time it takes to stop the car in seconds
	public double stoppingTime(double vi, double a){
		double t = (vf - vi)/(a);
		return t;
	}
	
	public String canStopDistance(){//determines if you can stop before the light
		if(fromLight > deltaX + coast){
			return String.format("%4s", "true");
		} return String.format("%4s", "false");
	}
	
	//calculates the distance traveled before hitting the brakes
	//assumes that the reaction time is 1s (very liberal)
	public double distanceToReact(){
		double coast = vi * reactionTime;
		return coast;
	}
	
	//determines if you can stop before the yellow changes 
	//true: you can stop
	public String canStopTime(){
		if(lightTime > stopTime){
			return String.format("%4s", "true");
		} return String.format("%4s", "false");
	}
	
	public String toString(){ 
		return "Initial Velocity: " + vi + 
				"\nAcceleration: " + a +
				"\nStopping Distance: " + deltaX +
				"\nDistance from Light: " + fromLight +
				"\nStopping Time: " + stopTime + 
				"\nDistance Traveled Before Braking: " + coast +
				"\nLight TIme: " + lightTime +
				"\nCan Stop in Time: " + canStopTime() +
				"\nCan Stop in Distance: " + canStopDistance();
	}
	
	//determines if the car can just keep going and make the yellow
	//returns true if it can pass, false if it can't
	public String runYellow(){
		if(canStopTime().equals("false") || canStopDistance().equals("false")){
			double distanceToTravel = fromLight + 100;
			double timeToPass = (2*(fromLight + 100))/(2*vi);
			if(timeToPass < lightTime){
				return String.format("%4s", "true");			}
		}
		 return String.format("%4s", "false");
	}
	
	public String toStringFormat(){
		String viFormat = String.format("%4f", vi);
		String aFormat = String.format("%4f", a);
		String deltaXFormat = String.format("%4f", deltaX);
		String fromLightFormat = String.format("%4f", fromLight);
		String stopTimeFormat = String.format("%4f", stopTime);
		String coastFormat = String.format("%4f", coast);
		String lightTimeFormat = String.format("%4f", lightTime);
		return String.format("%-20s%-20s%-20s%-30s%-20s%-30s%-20s%-20s%-20s%-20s", viFormat, aFormat, deltaXFormat,fromLightFormat, stopTimeFormat, coastFormat, lightTimeFormat, canStopTime(), canStopDistance(), runYellow());
		//return viFormat  + aFormat + "\t" + deltaXFormat + "\t" + fromLightFormat + "\t" + stopTimeFormat + 
			//	"\t" + coastFormat + "\t" + lightTimeFormat + "\t" + canStopTime() + "\t" + canStopDistance();
	}
	
	
	
	public static void main(String[] args){
		//vi, a, frmLight, yellowtime
		SimPhysics test = new SimPhysics(100, -5, 5, 5);
		System.out.println(test.calcStoppingDistance(10, -5));
		System.out.println(test.canStopTime());
		System.out.println(test.canStopDistance());
		System.out.println(test.runYellow());
	}
	
}
