package day15.com.ict.edu4;

public class Protoss implements Unit {
	private String name;
	private int energy;
	private boolean fly;

	public Protoss() {
	}

	public Protoss(String name, int energy, boolean fly) {
		super();
		this.name = name;
		this.energy = energy;
		this.fly = fly;
	}

	// 공격을 받으면 에너지가 감소한다. (에너지가 10 감소한다.)
	@Override
	public void decEnergy() {
		energy = energy - 10;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public boolean isFly() {
		return fly;
	}

	public void setFly(boolean fly) {
		this.fly = fly;
	}
}
