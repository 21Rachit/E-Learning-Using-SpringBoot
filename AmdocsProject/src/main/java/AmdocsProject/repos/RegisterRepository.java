package AmdocsProject.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import AmdocsProject.model.User1;


public interface RegisterRepository extends JpaRepository<User1, Integer>{

	@Query("select name from User1 where name=?1 and password=?2")
	public List<String> validateUser(String name, String password);
	
}
