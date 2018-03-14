package Model;

/**
 * Created by PC on 04/03/2018.
 */

public class Weather {
    //This class uses all other classes

    //We create instance variables of other classes

    public Place place;
    public Condition condition = new Condition();
    public Temperature temperature = new Temperature();
    public Wind wind = new Wind();
    public Clouds clouds = new Clouds();

}
