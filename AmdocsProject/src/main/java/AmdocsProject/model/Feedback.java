package AmdocsProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feedback
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int f_id;
	private int user_id;
	private String name;
	private String email;
	private String feedbackmessage;
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFeedbackmessage() {
		return feedbackmessage;
	}
	public void setFeedbackmessage(String feedbackmessage) {
		this.feedbackmessage = feedbackmessage;
	}

		
	
}
