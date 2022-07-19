package jana60.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jana60.repository.DegreeRepository;

@Controller
@RequestMapping("/degrees")
public class DegreeController 
{
	@Autowired
	private DegreeRepository repo;
	
	@GetMapping
	public String degrees(Model model) 
	{
		model.addAttribute("DegreesList" , repo.findAll());		
		return "degrees";
	}
	
}