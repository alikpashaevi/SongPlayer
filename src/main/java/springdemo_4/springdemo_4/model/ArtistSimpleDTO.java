package springdemo_4.springdemo_4.model;

public class ArtistSimpleDTO {

    private Long id;
    private String name;
    private String monthlyListeners;

    public ArtistSimpleDTO(Long id, String name, String monthlyListeners) {
        this.id = id;
        this.name = name;
        this.monthlyListeners = monthlyListeners;
    }

    public Long getId() {return id;}

    public String getName() {
        return name;
    }

    public String getMonthlyListeners() {
        return monthlyListeners;
    }

    public void printDetails() {
        System.out.println("Name: " + name);
    }

}
