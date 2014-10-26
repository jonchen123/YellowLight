import java.util.Random;

public class RandomSituationGen {
	
	Random gen = new Random();
	private int vi = 0;
	private int a = 0;
	private int fromLight = 0;
	
	public RandomSituationGen(){
		
	}
	
	public double genAcceleration(){// in mi/s^2
		a = gen.nextInt(15) + 15;
		return a;
	}
	
	public double genVI50(){// in mph
		vi =  gen.nextInt(15) + 40;
		return vi;
	}
	
	public double genVI30(){// in mph
		vi = gen.nextInt(15) + 20;
		return vi;
	}
	
	public double distanceFromLight(){
		fromLight = (int)(Math.random()*200.0);
		return fromLight;
	}
	
	public String toString(){
		return "Vi = " + vi + " a = " + a + " fromLight = " + fromLight;
	}
	
	
	
	
	
}
