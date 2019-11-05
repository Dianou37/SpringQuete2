package com.wildecodeschool.myProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@SpringBootApplication
public class MyProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyProjectApplication.class, args);
    }
    String name[] = {"William Hartnell", "Patrick Troughton", "Jon Pertwee", "Tom Baker", "Peter Davison", "Colin Baker", "Sylvester McCoy", "Paul McGann", "Christopher Eccleston", "David Tennant", "Matt Smith", "Peter Capaldi", "Jodie Whittaker"};
    int i = 0;
    @RequestMapping("/")
    @ResponseBody
    public String index() 
    {
        String listeLien = "<ul>";
        	for (i=0; i<name.length; i++) 
        	{
        		listeLien += "<li><a href='./doctor/"+i+"'>Doctor n°"+(i+1)+"</a></li>";
        	}
        listeLien+="</ul>";
    	return listeLien;
    }
    @RequestMapping("/doctor/{id}")
    @ResponseBody
    public String Doctor1(@PathVariable int id) 
    {
        if(id>=8 && id<=12) 
        {
        	return name[id];
        }
        if(id>=0 && id<=7)
        {
        	throw new ResponseStatusException(HttpStatus.SEE_OTHER);
        }
        
    	throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation " +id);
    }
}