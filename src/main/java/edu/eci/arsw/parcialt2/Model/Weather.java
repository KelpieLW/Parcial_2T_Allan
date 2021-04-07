package edu.eci.arsw.parcialt2.Model;

public class Weather {

    private Integer id;
    private String main;
    private String description;

    public Weather(){

    }

    public Weather(Integer id, String main, String description) {
        this.id = id;
        this.main = main;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
