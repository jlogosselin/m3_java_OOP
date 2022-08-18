package ExerciseH_StateCapitals3;

public class Capital {

    private String name;
    private int population;
    private double mileage;

    public Capital(String n, int p, double m){
        this.name = n;
        this.population = p;
        this.mileage = m;
    }

    public String getName(){
        return this.name;
    }

    public int getPopulation(){
        return this.population;
    }

    public double getMileage(){
        return this.mileage;
    }

}
