package com.movie.woochapedia.grade;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface GradeRepository extends JpaRepository<com.movie.woochapedia.grade.GradeEntity, Long> {

    ArrayList<com.movie.woochapedia.grade.GradeEntity> findAll();

    @Query(value = "SELECT * FROM GRADE_ENTITY WHERE movie_id = :movieId",
            nativeQuery = true)
    List<com.movie.woochapedia.grade.GradeEntity> findByMovieId(Long movieId);

    @Query(value = "SELECT * FROM GRADE_ENTITY WHERE title = :title",
            nativeQuery = true)
    List<com.movie.woochapedia.grade.GradeEntity> findByTitle(String title);



}
