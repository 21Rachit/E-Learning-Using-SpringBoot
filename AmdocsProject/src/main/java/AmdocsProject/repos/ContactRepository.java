package AmdocsProject.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import AmdocsProject.model.Admin;
import AmdocsProject.model.Contact;


public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
