
public class Car {
	//instant variables 
	private double mpg;
	private String modelOfCar;
	//default constructor
	public Car(){
		mpg = 0;
		modelOfCar = null;
	}
	public Car(double mpg, String modelOfCar){
		this.mpg = mpg;
		this.modelOfCar =modelOfCar;
	}
	public double getMpg (){
		return mpg;
	}
	public String getModelOfCar(){
		return modelOfCar;
	}
	public void setMpg(){
		this.mpg = mpg;
	}
	public void setModelOfCar(){
		this.modelOfCar = modelOfCar;
	}
	public String toString() {
		String s = "MPG : " + mpg;
		s+= " Model Of Car :" + modelOfCar;
		return s;
		}
	public boolean equals(Car car2){
		 return mpg == car2.mpg && modelOfCar.equalsIgnoreCase(car2.modelOfCar);
	}
	

}
