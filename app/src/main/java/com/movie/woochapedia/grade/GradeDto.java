package com.movie.woochapedia.grade;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GradeDto {

    private Long id;
    @JsonProperty("movie_id") 
    private Long movieId;
    private String title;
    private Integer grade;
    private String body;

    // JSON을 DTO로 변환하는 메소드
    public static GradeDto createGradeDto(GradeEntity grade) {
        return new GradeDto( 
                grade.getId(),
                grade.getMovie().getId(),
                grade.getTitle(),
                grade.getGrade(),
                grade.getBody()
        );
    }

//    public GradeEntity toEntity(){
//        return new GradeEntity(id, movieId, title, grade, body);
//    }

}
