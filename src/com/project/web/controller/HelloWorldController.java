package com.project.web.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
 
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.AbstractController;
 
@Controller
public class HelloWorldController  {
	protected final Log logger = LogFactory.getLog(getClass());


    private String message;
    //@Override
   // protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
   	//return new ModelAndView("welcomePage","welcomeMessage", message);
    //}
    
   	@RequestMapping("/hello")
	public ModelAndView welcomePage(){
	logger.info("Return View Latha");
	//return new ModelAndView("welcomePage");
		setMessage("Hello All");
   		return new ModelAndView("welcomePage","welcomeMessage", message);
   	}
     
    public void setMessage(String message) {
        this.message = message;
    }
 
}
