package Model;

/**
 * Created by PC on 04/03/2018.
 */

public class Place {
    private long sunset;
    private long sunrise;
    private String country;
    private String city;






    public long getSunset() {
        return sunset;
    }

    public void setSunset(long suntset) {
        this.sunset = suntset;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
