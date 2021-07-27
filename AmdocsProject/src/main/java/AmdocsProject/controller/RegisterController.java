package AmdocsProject.controller;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import AmdocsProject.model.Admin;
import AmdocsProject.model.Contact;
import AmdocsProject.model.Course;
import AmdocsProject.model.Feedback;
import AmdocsProject.model.User1;
import AmdocsProject.model.Mapping;
import AmdocsProject.repos.AdminRepository;
import AmdocsProject.repos.ContactRepository;
import AmdocsProject.repos.CourseRepository;
import AmdocsProject.repos.FeedbackRepository;
import AmdocsProject.repos.RegisterRepository;
import AmdocsProject.repos.UserCourseRepository;


@Controller
public class RegisterController {

	@Autowired
	RegisterRepository registerrepository;
	
	@Autowired
	AdminRepository adminrepository;
	
	@Autowired
	ContactRepository contactrepository;
	
	@Autowired
	FeedbackRepository feedbackrepository;
	
	@Autowired
	CourseRepository courserepository;
	
	@Autowired
	UserCourseRepository usercourserepository;
	
	
	@RequestMapping("/sendData")
	public ModelAndView sendData() {
		ModelAndView mav = new ModelAndView("data");
		mav.addObject("message", "Hello world this is AI");
		return mav;
	}

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("admin", "This link is for Admin Login");
		mav.addObject("user", "This link is for User Login");
		return mav;
	}
	
	@RequestMapping("/registerForm")
	public ModelAndView displayForm() {
		ModelAndView mav = new ModelAndView("registerForm");
		User1 contact = new User1();
		mav.addObject("contact", contact);
		return mav;
	}
	
	@RequestMapping("/adminLoginForm")
	public ModelAndView adminLoginForm() {
		ModelAndView mav = new ModelAndView("adminLoginForm");
		return mav;
	}
	
	@RequestMapping("/userLoginForm")
	public ModelAndView userLoginForm() {
		ModelAndView mav = new ModelAndView("userLoginForm");
		return mav;
	}
	
	@RequestMapping("/adminForm")
	public ModelAndView displayAdminForm() {
		ModelAndView mav = new ModelAndView("adminForm");
		Admin contact = new Admin();
		mav.addObject("contact", contact);
		return mav;
	}
	
	@RequestMapping("/contactForm")
	public ModelAndView displayContactForm() {
		ModelAndView mav = new ModelAndView("contactForm");
		Contact contact = new Contact();
		mav.addObject("contact", contact);
		return mav;
	}
	
	@RequestMapping("/feedbackForm")
	public ModelAndView displayFeedbackForm() {
		ModelAndView mav = new ModelAndView("feedbackForm");
		Feedback contact = new Feedback();
		mav.addObject("contact", contact);
		return mav;
	}
	
	@RequestMapping("/courseForm")
	public ModelAndView displayCourseForm() {
		ModelAndView mav = new ModelAndView("courseForm");
		Course contact = new Course();
		mav.addObject("contact", contact);
		return mav;
	}
	
	@RequestMapping("/userCourseMapForm")
	public ModelAndView userCourseMapForm() {
		ModelAndView mav = new ModelAndView("userCourseMapForm");
		Mapping contact = new Mapping();
		mav.addObject("contact", contact);
		return mav;
	}
	
	@RequestMapping("/saveUser1")
	public ModelAndView saveUser1(@ModelAttribute User1 contact) {
		Date date = new Date();
		String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
		contact.setReg_date(modifiedDate);
		registerrepository.save(contact);
		ModelAndView mav = new ModelAndView("result");
		System.out.println(contact.getName());
		System.out.println(contact.getAddress());
		System.out.println(contact.getEmail());
		System.out.println(contact.getReg_date());
		return mav;
	}
	
	@RequestMapping("/saveAdmin")
	public ModelAndView saveAdmin(@ModelAttribute Admin contact) {
		adminrepository.save(contact);
		ModelAndView mav = new ModelAndView("result");
		System.out.println(contact.getName());
		System.out.println(contact.getEmail());
		return mav;
	}
	

	@RequestMapping("/saveContact")
	public ModelAndView saveContact(@ModelAttribute Contact contact) {
		contactrepository.save(contact);
		ModelAndView mav = new ModelAndView("result");
		System.out.println(contact.getName());
		System.out.println(contact.getEmail());
		return mav;
	}
	
	@RequestMapping("/saveFeedback")
	public ModelAndView saveFeedback(@ModelAttribute Feedback contact) {
		System.out.println(contact.getName());
		feedbackrepository.save(contact);
		ModelAndView mav = new ModelAndView("result");
		return mav;
	}
	
	@RequestMapping("/saveCourse")
	public ModelAndView saveCourse(@ModelAttribute Course contact) {
		courserepository.save(contact);
		ModelAndView mav = new ModelAndView("result");
		System.out.println(contact.getC_name());
		System.out.println(contact.getC_desp());
		return mav;
	}
	
	@RequestMapping("/saveAdminLogin")
	public ModelAndView saveAdminLogin(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "password", required = false) String password)
	{
		System.out.println(name);
		System.out.println(password);
		List<String> res=adminrepository.validateAdmin(name, password);
		System.out.println(res);
		if(res.size()!=0)
		{
		ModelAndView mav = new ModelAndView("infopage");	
		mav.addObject("name", "Welcome Admin "+name);
		return mav;
		}
		else
		{
		ModelAndView mav = new ModelAndView("adminLoginForm");
		return mav;
		}
	}
	
	@RequestMapping("/saveUserLogin")
	public ModelAndView saveUserLogin(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "password", required = false) String password)
	{
		System.out.println(name);
		System.out.println(password);
		List<String> res=registerrepository.validateUser(name, password);
		System.out.println(res);
		if(res.size()!=0)
		{
		ModelAndView mav = new ModelAndView("infoUserPage");	
		mav.addObject("name", "Welcome User "+name);
		return mav;
		}
		else
		{
		ModelAndView mav = new ModelAndView("userLoginForm");
		return mav;
		}
	}
	
	@RequestMapping("/saveUserCourseMapping")
	public ModelAndView saveUserCourseMapping(@ModelAttribute Mapping contact) {
		usercourserepository.save(contact);
		ModelAndView mav = new ModelAndView("result");
		System.out.println(contact.getName());
		return mav;
	}
	
}
