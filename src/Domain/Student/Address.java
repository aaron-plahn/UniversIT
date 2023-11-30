
package Domain.Student;

public class Address {
    private final int homeAddress;
    private final String addressLineOne;
    private final String addressLineTwo;
    private final String cityName;
    private final String provinceOrState; // how could I make this an enum that depends on the country?
    private final Country country;
    private final String postalCode;

    public Address(int homeAddress, String addressLineOne, String cityName, String provinceOrState, Country country,
            String postalCode) {
        this.homeAddress = homeAddress;
        this.addressLineOne = addressLineOne;
        this.cityName = cityName;
        this.provinceOrState = provinceOrState;
        this.country = country;
        this.postalCode = postalCode;
        this.addressLineTwo = "";

    }

    public Address(int homeAddress, String addressLineOne, String addressLineTwo, String cityName,
            String provinceOrState,
            Country country, String postalCode) {
        this.homeAddress = homeAddress;
        this.addressLineOne = addressLineOne;
        this.cityName = cityName;
        this.provinceOrState = provinceOrState;
        this.country = country;
        this.postalCode = postalCode;
        this.addressLineTwo = addressLineTwo;

    }

    public String toString() {
        if (addressLineTwo.length() == 0)
            return (homeAddress + " " + addressLineOne + " " + cityName + " " + provinceOrState + " " + country + " "
                    + postalCode);
        return (homeAddress + " " + " " + addressLineTwo + " " + addressLineOne + " " + cityName + " " + provinceOrState
                + " " + country + " " + postalCode);
    }

    public boolean isEqual(Address addressToComapre) {
        return this.toString().equalsIgnoreCase(addressToComapre.toString());
    }
}
