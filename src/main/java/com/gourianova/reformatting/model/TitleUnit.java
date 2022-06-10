package com.gourianova.reformatting.model;
import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Setter

public class TitleUnit {
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitlesItem() {
        return titlesItem;
    }

    public void setTitlesItem(String titlesItem) {
        this.titlesItem = titlesItem;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }

    private String titlesItem;
    private String timePeriod;

    public TitleUnit() {

    }



}
