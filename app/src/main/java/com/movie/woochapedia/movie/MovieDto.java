package com.movie.woochapedia.movie;


import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class MovieDto {

    private Long id;

    private String imgName;

    private String imgUrl;

    private String title;

    private String content;

    private String director;

    private String actor;

    private Integer movieTime;

    private String grade;

    public com.movie.reviewsite.movie.MovieEntity toEntity(){
        return new com.movie.reviewsite.movie.MovieEntity(id, imgName, imgUrl, title, content, director,actor, movieTime, grade);
    }
}
