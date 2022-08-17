package Exercise9_AddressBook;

public class Address {

    //<firstName>::<lastName>::<streetAddress>::<city>::<state>::<zip>
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;

    public Address(String fn, String ln, String sa, String c, String s, String z){
        this.firstName = fn;
        this.lastName = ln;
        this.streetAddress = sa;
        this.city = c;
        this.state = s;
        this.zip = z;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getStreetAddress(){
        return this.streetAddress;
    }

    public String getCity(){
        return this.city;
    }

    public String getState(){
        return this.state;
    }

    public String getZip(){
        return this.zip;
    }

    public void setFirstName(String f){
        this.firstName = f;
    }

    public void setLastName(String l ){
        this.lastName = l;
    }

    public void setStreetAddress(String sa){ this.streetAddress = sa;}

    public void setCity(String c){
        this.city = c;
    }

    public void setState(String s){
        this.state = s;
    }

    public void setZip(String z){
        this.zip = z;
    }


}
