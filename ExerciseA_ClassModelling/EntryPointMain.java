package ExerciseA_ClassModelling;

public class EntryPointMain {
    public static void main(String[] args) {

        House house1 = new House(23.0, 45.0, 56.0);
        house1.get_House_3D_Coordinates();

        //41°24'12.2"N 2°10'26.5"E
        House house2 = new House(41, 24, 12, 2, 10, 26.7);
        house2.get_House_GPS_Coordinates();
    }
}
