package com.movie.woochapedia.grade;
import com.movie.woochapedia.movie.MovieEntity;
import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class GradeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;

    @Column
    private String title;

    @Column
    private Integer grade;

    @Column
    private String body;

    public void patch(com.movie.woochapedia.grade.GradeDto dto) {
        if(this.id != dto.getId())
            throw new IllegalArgumentException("잘못된 id 입니다");

        if(dto.getTitle() != null)
            this.title = dto.getTitle();
        if(dto.getGrade() != null)
            this.grade = dto.getGrade();
        if(dto.getBody() != null)
            this.body = dto.getBody();
    }
    public static GradeEntity createGrade(com.movie.woochapedia.grade.GradeDto dto, MovieEntity movie) {
        if(dto.getId() != null){
            throw new IllegalArgumentException("id입력 하면 안돼요");
        }
        if(dto.getMovieId() != movie.getId()){
            throw new IllegalArgumentException(("id가 잘못됐어요"));
        }
        return new GradeEntity(
                dto.getId(),
                movie,
                dto.getTitle(),
                dto.getGrade(),
                dto.getBody()
        );
    }
}
