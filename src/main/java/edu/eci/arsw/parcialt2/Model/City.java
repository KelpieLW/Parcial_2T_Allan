package edu.eci.arsw.parcialt2.Model;

public class City {

    private String name;
    private Location location;
    private Weather weather;
    private Temperature temperature;
    private Wind wind;


    public City(){

    }

    public City(String name){
        this.name=name;
    }

    public City(String name, Location location, Weather weather, Temperature temperature, Wind wind) {
        this.name = name;
        this.location = location;
        this.weather = weather;
        this.temperature = temperature;
        this.wind = wind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}
