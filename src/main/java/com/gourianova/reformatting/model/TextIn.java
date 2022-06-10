package com.gourianova.reformatting.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Setter
@Entity
public class TextIn implements Serializable {
    @Id
    private long id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private String text_title;
    private String text_path;
    private Language language_of_subtitles;
    @Lob
    @Column(length = Integer.MAX_VALUE)
    private byte[] titles;
    private LocalDate create_time;

    public TextIn() {

    }

    public TextIn(String text_title, String text_path, LocalDate create_time, Language language) {
        {

            this.text_title = text_title;
            this.text_path = text_path;
            this.create_time = create_time;
            //this.language = language;
        }
    }

    public TextIn(String text_title, String text_path) {
        {

            this.text_title = text_title;
            this.text_path = text_path;
        }
    }


    public TextIn(long incrementAndGet, LocalDate now, String text_title, String text_path) {
        this.id = incrementAndGet;
        this.create_time = now;
        this.text_path = text_path;

    }

    public void setId(long id) {
        this.id = id;
    }

    public Language getLanguage_of_subtitles() {
        return language_of_subtitles;
    }

    public void setLanguage_of_subtitles(Language language_of_subtitles) {
        this.language_of_subtitles = language_of_subtitles;
    }

    public byte[] getTitles() {
        return titles;
    }

    public void setTitles(byte[] titles) {
        this.titles = titles;
    }

    public String getText_title() {
        return text_title;
    }
    //  private Language language;

    public void setText_title(String text_title) {
        this.text_title = text_title;
    }

    public String getText_path() {
        return text_path;
    }

    public void setText_path(String text_path) {
        this.text_path = text_path;
    }

    public void setCreate_time(LocalDate create_time) {
        this.create_time = create_time;
    }
}

