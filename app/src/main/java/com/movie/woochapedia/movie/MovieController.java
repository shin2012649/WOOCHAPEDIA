package com.movie.woochapedia.movie;


import com.movie.woochapedia.grade.GradeDto;
import com.movie.woochapedia.grade.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private com.movie.woochapedia.movie.MovieRepository movieRepository;

    @Autowired
    private com.movie.woochapedia.movie.MovieService movieService;
    @Autowired
    private GradeService gradeService;

    // movieDetail 화면 전체 view 페이지
    @GetMapping("/detail")
    public String allMoviePage(Model model){

        List<com.movie.woochapedia.movie.MovieEntity> movieEntityList = movieService.findAll();


        model.addAttribute("movieEntityList", movieEntityList);


        return"/movie/details";
    }

    // movie detail view 페이지
    @GetMapping("/detail/{id}")
    public String detailMovie(@PathVariable Long id, Model model){

        com.movie.woochapedia.movie.MovieEntity movieEntity = movieService.findMovie(id);
        List<GradeDto> gradeDtos = gradeService.grades(id);

        model.addAttribute("movieEntity",movieEntity);
        model.addAttribute("gradesDtos", gradeDtos);
        return "/movie/detail";
    }

    // movie 등록 view 페이지
    @GetMapping("/detail/new")
    public String newMoviePage(){

        return"/movie/newDetail";
    }

    // movie 등록 post
    @PostMapping("/detail/create")
    public String createMovie(com.movie.woochapedia.movie.MovieDto movieDto, @RequestParam("imgFile") MultipartFile poster) throws Exception {


       com.movie.woochapedia.movie.MovieEntity movieEntity = movieService.create(movieDto, poster);



        return "redirect:/detail/"+movieEntity.getId();
    }

    // movie 수정 view 페이지
    @GetMapping("/detail/update/{id}")
    public String updateMoviePage(@PathVariable Long id,Model model){

        com.movie.woochapedia.movie.MovieEntity movieEntity = movieService.findMovie(id);
        model.addAttribute("movieEntity", movieEntity);
        return "/movie/update";
    }

    // movie 수정 patch
    @PatchMapping("/detail/edit") // action
    public String editMovie(@PathVariable Long id, com.movie.woochapedia.movie.MovieDto movieDto){
        com.movie.woochapedia.movie.MovieEntity movieEntity = movieService.edit(id, movieDto);
        return "redirect:/detail";
    }

    // movie 삭제 delete
    @GetMapping("/detail/delete/{id}")
    public String deleteMovie(@PathVariable Long id){
        com.movie.woochapedia.movie.MovieEntity movieEntity = movieService.delete(id);
        return "redirect:/detail";
    }

}
