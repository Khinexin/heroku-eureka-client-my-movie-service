package com.mynotes.spring.cloud.eureka;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    private static List<Movie> movieList = new ArrayList<>();
    static {
    	movieList.add(new Movie(1, "Avengers: Infinity War", "Disney", "rank 1 in 2018"));
    	movieList.add(new Movie(2, "Black Panther", "Disney", "rank 2 in 2018"));
    	movieList.add(new Movie(3, "Jurassic World: Fallen Kingdom", "Universal", "rank 3 in 2018"));
    	movieList.add(new Movie(4, "Incredibles 2", "Disney", "rank 4 in 2018"));
    	movieList.add(new Movie(5, "Aquaman", "Warner Bros.", "rank 5 in 2018"));
    	movieList.add(new Movie(6, "Bohemian Rhapsody", "20th Century Fox", "rank 6 in 2018"));
    	movieList.add(new Movie(7, "Venom", "Sony", "rank 7 in 2018"));
    	movieList.add(new Movie(8, "Mission: Impossible – Fallout", "Paramount", "rank 8 in 2018"));
    	movieList.add(new Movie(9, "Deadpool 2", "20th Century Fox", "rank 9 in 2018"));
    	movieList.add(new Movie(10, "Fantastic Beasts: The Crimes of Grindelwald", "Warner Bros.", "rank 10 in 2018"));
    	
    	movieList.add(new Movie(11, "Avengers: Endgame", "Disney", "rank 1 in 2019"));
    	movieList.add(new Movie(12, "The Lion King", "Disney", "rank 2 in 2019"));
    	movieList.add(new Movie(13, "Frozen II", "Disney", "rank 3 in 2019"));
    	movieList.add(new Movie(14, "Spider-Man: Far From Home", "Sony", "rank 4 in 2019"));
    	movieList.add(new Movie(15, "Captain Marvel", "Disney", "rank 5 in 2019"));
    	movieList.add(new Movie(16, "Toy Story 4", "Disney", "rank 6 in 2019"));
    	movieList.add(new Movie(17, "Joker", "Warner Bros.", "rank 7 in 2019"));
    	movieList.add(new Movie(18, "Aladdin", "Disney", "rank 8 in 2019"));
    	movieList.add(new Movie(19, "Star Wars: The Rise of Skywalker", "Disney", "rank 8 in 2019"));
    	movieList.add(new Movie(20, "Hobbs & Shaw", "Universal", "rank 10 in 2019"));
    	
    	movieList.add(new Movie(21, "Tolo Tolo", "Medusa Film", "rank 1 in 2020"));
    	movieList.add(new Movie(22, "The Grudge", "Sony", "rank 2 in 2020"));
    	movieList.add(new Movie(23, "Darbar", "	Lyca Productions", "rank 3 in 2020"));
    	movieList.add(new Movie(24, "Tanhaji", "AA Films", "rank 4 in 2020"));
    	movieList.add(new Movie(25, "Underwater", "Disney", "rank 5 in 2020"));
    	movieList.add(new Movie(26, "The Gentlemen", "Miramax", "rank 6 in 2020"));
    	movieList.add(new Movie(27, "Like A Boss", "Paramount", "rank 7 in 2020"));
    	movieList.add(new Movie(28, "Dolittle", "Universal", "rank 8 in 2020"));
    	movieList.add(new Movie(29, "Lupin III: The First", "Toho Company", "rank 8 in 2020"));
    	movieList.add(new Movie(30, "Chhapaak", "Fox Star Studios", "rank 10 in 2020"));
    }

    @GetMapping("/movies")
    public ResponseEntity<?> getMovies() {
        return ResponseEntity.ok(movieList);
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<?> getMovie(@PathVariable int id) {

        Movie movie = findMovie(id);
        if (movie == null) {
            return ResponseEntity.badRequest()
                .body("Invalid movie id");
        }

        return ResponseEntity.ok(movie);

    }

    private Movie findMovie(int id) {
        return movieList.stream()
            .filter(movie -> movie.getId()
                .equals(id))
            .findFirst()
            .orElse(null);
    }

}
