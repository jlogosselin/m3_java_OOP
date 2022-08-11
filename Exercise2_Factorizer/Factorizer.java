package Exercise2_Factorizer;

public class Factorizer {

    private int value;
    private int factor_count;
    private boolean flag;
    private int perfectTotal;

    public Factorizer(int v){
        this.value = v;
        this.factor_count = 0;
        this.flag = true;
        this.perfectTotal = 0;
    }

    public void countFactors(){
        for(int i=1; i<this.value; i++){
            if(this.value % i == 0){
                System.out.println(i + " is a factor of " + this.value);
                this.factor_count++;
            }
        }
        this.factor_count++;
        System.out.println(this.value + " has a total of " + this.factor_count + " factors (including itself). \n\n");
    }

    public void isPrime(){
        for(int i=2; i<Math.sqrt(this.value); i++){
            if(this.value % i == 0){
                this.flag = false;
                break;
            }
        }
        String result = (this.flag == true)? " is prime.\n\n" : " is not prime.\n\n";
        System.out.println(this.value + result);
    }

    public void isPerfect(){
        for(int i=1; i<this.value; i++){
            if(this.value % i == 0){
                this.perfectTotal += i;
            }
        }
        String result = (this.perfectTotal == this.value) ? " is perfect!\n\n" : " is not perfect.\n\n";
        System.out.println("The value " + this.value + result);
    }
}
