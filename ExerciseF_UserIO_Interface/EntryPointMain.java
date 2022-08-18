package ExerciseF_UserIO_Interface;

public class EntryPointMain {

    public static void main(String[] args) {

        //notice below: we create an object of interface UserIO through class UserIO_Implementation
        UserIO obj = new UserIO_Implementation();

        int smallNum = obj.readInt("Give me a small number :");
        int bigNum = obj.readInt("Now give me a much bigger number! :");
        if(bigNum < smallNum){
            obj.print("Hey! " + smallNum +" is BIGGER than " + bigNum);
            obj.print("I guess I can fix it.");
            int swapNum = bigNum;
            bigNum = smallNum;
            smallNum = swapNum;
        }

        int betweenNum = obj.readInt("Now give me one in between! : ", smallNum, bigNum);
        obj.print("I like the number "+betweenNum+"!");

    }
}
