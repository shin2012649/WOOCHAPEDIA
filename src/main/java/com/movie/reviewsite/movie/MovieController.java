package com.movie.reviewsite.movie;

import com.movie.reviewsite.grade.GradeDto;
import com.movie.reviewsite.grade.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieService movieService;
    @Autowired
    private GradeService gradeService;

    // movieDetail 화면 전체 view 페이지
    @GetMapping("/detail")
    public String allMoviePage(Model model){

        List<MovieEntity> movieEntityList = movieService.findAll();


        model.addAttribute("movieEntityList", movieEntityList);

        return"/movie/details";
    }

    // movie detail view 페이지
    @GetMapping("/detail/{id}")
    public String detailMovie(@PathVariable Long id, Model model){

        MovieEntity movieEntity = movieService.findMovie(id);
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
    public String createMovie(MovieDto movieDto, @RequestParam("imgFile") MultipartFile poster) throws Exception {
        // todo: @RequestParam("imgFile") 를 이용해서 post 시 데이터 전달. input 태그의 name 속성이 'imgFile' 이면 전달됨

       MovieEntity movieEntity = movieService.create(movieDto, poster);

        return "redirect:/detail/"+movieEntity.getId();
    }

    // movie 수정 view 페이지
    @GetMapping("/detail/update/{id}")
    public String updateMoviePage(@PathVariable Long id,Model model){

        MovieEntity movieEntity = movieService.findMovie(id);
        model.addAttribute("movieEntity", movieEntity);
        return "/movie/update";
    }

    // movie 수정 patch
    @PatchMapping("/detail/edit") // action
    public String editMovie(@PathVariable Long id, MovieDto movieDto){
        MovieEntity movieEntity = movieService.edit(id, movieDto);
        return "redirect:/detail";
    }

    // movie 삭제 delete
    @GetMapping("/detail/delete/{id}")
    public String deleteMovie(@PathVariable Long id){
        MovieEntity movieEntity = movieService.delete(id);
        return "redirect:/detail";
    }

}
