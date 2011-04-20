package com.project.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;


import com.project.web.form.User;
 
@Controller
@SessionAttributes
public class UserController {
private User user;
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user")
                            User user, BindingResult result) {
 
        System.out.println("First Name:" + user.getFirstname() +
                    "Last Name:" + user.getLastname());
        this.user = user;
        //return "redirect:userSuccess.htm";
        return "redirect:userSuccess.htm";
    }
	
	
	@RequestMapping("/userSuccess")
    public ModelAndView showUserSuccess() {
       

        return new ModelAndView("userSuccess", "command", this.user);
    }
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model)
	{
		User user = new User();
		model.addAttribute(user);
		return "userForm";
	}
	
	@RequestMapping("/user")
    public ModelAndView showUserDetails() {
       
        return new ModelAndView("userDetails", "user", new User());
    }
	
	@RequestMapping("/ajax")
    public ModelAndView showAjax() {
       

        return new ModelAndView("ajax", "command", new User());
    }
	
	@RequestMapping("/user1")
    public ModelAndView showUser() {
       System.out.println("here");
        return new ModelAndView("ajax1", "user", new User());
    }
	@RequestMapping(value="/ajax1", method=RequestMethod.GET)
	public @ResponseBody User getSomething(@RequestParam String name) {
		System.out.println("****************");
	    User user = new User();
	    user.setFirstname(name+" Pogula");
	    System.out.println(user.getFirstname());
	   // user.setLastname(lastname)
	    
	    return user;
	}
}
