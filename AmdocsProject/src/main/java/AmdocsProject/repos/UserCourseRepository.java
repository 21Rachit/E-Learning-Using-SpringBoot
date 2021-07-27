package AmdocsProject.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import AmdocsProject.model.Course;
import AmdocsProject.model.Mapping;

public interface UserCourseRepository extends JpaRepository<Mapping, Integer>{

}
