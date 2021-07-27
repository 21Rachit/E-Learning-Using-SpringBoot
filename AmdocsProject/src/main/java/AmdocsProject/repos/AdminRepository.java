package AmdocsProject.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import AmdocsProject.model.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer>{

	@Query("select name from Admin where name=?1 and password=?2")
	public List<String> validateAdmin(String name, String password);
	
}
