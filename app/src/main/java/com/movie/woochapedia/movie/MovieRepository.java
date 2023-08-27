package com.movie.woochapedia.movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository <MovieEntity, Long> {


}
