package AmdocsProject.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import AmdocsProject.model.Feedback;


public interface FeedbackRepository extends JpaRepository<Feedback, Integer>{

}