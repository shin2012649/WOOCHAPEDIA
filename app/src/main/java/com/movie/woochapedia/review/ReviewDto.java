package com.movie.woochapedia.review;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class ReviewDto {


    private Long id;

    private Long movieId;

    private String movieTitle;

    private String title;

    private String content;

    private String writer;

    private Long score;

    private Long views;

    public com.movie.woochapedia.review.ReviewEntity toEntity(){
        return new com.movie.woochapedia.review.ReviewEntity(id, movieId, movieTitle, title, content, writer, score, views);
    }

    public Long getMovieId(){
        return movieId;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }
}