package springbootstarter.movie;

//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@RequestMapping("/movies")
	public List<Movie> getAllMovies(){
		return movieService.getAllMovies();
	}

	@RequestMapping("/movies/{id}")
	public Movie getTopic(@PathVariable String id){
		return movieService.getMovie(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/movies")
	public void addTopic(@RequestBody Movie movie){
		movieService.addMovie(movie);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/movies/{id}")
	public void updateMovie(@RequestBody Movie movie, @PathVariable String id){
		movieService.updateMovie(id, movie);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/movies/{id}")
	public void deleteMovie(@PathVariable String id){
		movieService.deleteMovie(id);
	}
}
