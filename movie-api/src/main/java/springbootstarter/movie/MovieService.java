package springbootstarter.movie;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepo movieRepo;
	
	public List<Movie> getAllMovies(){
		List<Movie> movies = new ArrayList<>();
		movieRepo.findAll()
		.forEach(movies::add);
		return movies;
	}
	
	public Movie getMovie(String id){
		return movieRepo.findOne(id);
	}
	
	public void addMovie(Movie movie){
		movieRepo.save(movie);
	}
	
	public void updateMovie(String id, Movie movie){
		movieRepo.save(movie);
			
	}

	public void deleteMovie(String id) {
		movieRepo.delete(id);
	}
}
