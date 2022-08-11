package Exercise1_ClassModelling;

/*
Model a house as if the class were to be part of a GPS mapping system.
example of GPS coordinates:
Degrees, minutes, and seconds (DMS): 41°24'12.2"N 2°10'26.5"E
Latitudes measure an angle up from the equator, NORTH oe SOUTH (latitudes to the south are negative).
A longitude is an angle from the prime meridian, EAST or WEST (longitudes to the west are negative).

"A negative number for latitude, such as -7.48° (if it's negative, the minus is always shown), is a SOUTH latitude!"

"And for longitude, if there's no E or W, and if the number is positive (such as 128.3425° or +128.34°),
then the longitude is EAST. If the number is negative, such as -73.9917° (the minus is always shown if the
number is negative), then the longitude is WEST!"

-------------------------------------------------------------------------------------------------------------------

Model a house as if the class were to be part of a 3-D design system.


 */

public class House {

    private double longitudeDegrees;
    private double longitudeMinutes;
    private double longitudeSeconds;
    private double latitudeDegrees;
    private double latitudeMinutes;
    private double latitudeSeconds;

    private double x;
    private double y;
    private double z;


    //constructor 1:
    public House(double longD,  double longM, double longS, double latD,  double latM, double latS) {
        this.longitudeDegrees = longD;
        this.longitudeMinutes = longM;
        this.longitudeSeconds = longS;
        this.latitudeDegrees = latD;
        this.latitudeMinutes = latM;
        this.latitudeSeconds = latS;
    }

    //constructor2:
    public House(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void get_House_GPS_Coordinates(){
        System.out.println("GPS coordinates of the house are: ");
        if(this.latitudeDegrees < 0) {
            System.out.println(this.latitudeDegrees + "\u00B0 " + this.longitudeMinutes + "' " + this.longitudeSeconds + "\" S");
            if(this.longitudeDegrees < 0){
                System.out.println(this.longitudeDegrees + "\u00B0 " + this.longitudeMinutes + "' " + this.longitudeSeconds + "\" W");
            }
            else{
                System.out.println(this.longitudeDegrees + "\u00B0 " + this.longitudeMinutes + "' " + this.longitudeSeconds + "\" E");
            }
        }
        else {
            System.out.println(this.latitudeDegrees + "\u00B0 " + this.longitudeMinutes + "' " + this.longitudeSeconds + "\" S");
            if(this.longitudeDegrees < 0){
                System.out.println(this.longitudeDegrees + "\u00B0 " + this.longitudeMinutes + "' " + this.longitudeSeconds + "\" W");
            }
            else{
                System.out.println(this.longitudeDegrees + "\u00B0 " + this.longitudeMinutes + "' " + this.longitudeSeconds + "\" E");
            }
        }
    }

    public void get_House_3D_Coordinates(){
        System.out.println("3D coordinates of the house are:");
        System.out.println("x = " + this.x + ", y = " + this.y + ", z = " + this.z);
    }

}
