package com.movie.woochapedia.movie;

import com.movie.woochapedia.grade.GradeService;
import com.movie.woochapedia.review.ReviewEntity;
import com.movie.woochapedia.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private com.movie.woochapedia.movie.MovieService movieService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private GradeService gradeService;

    // main 화면 view 페이지
    @GetMapping("/")
    public String mainPage(Model model){

        List<com.movie.woochapedia.movie.MovieEntity> movieEntityList = movieService.findAll();
        model.addAttribute("movieEntityList", movieEntityList);

        List<ReviewEntity> reviewEntityList = reviewService.findAll();
        model.addAttribute("reviewEntityList", reviewEntityList);

        return "index";
    }


}
