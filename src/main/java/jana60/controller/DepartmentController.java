package jana60.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jana60.model.Department;
import jana60.repository.DepartmentRepository;

@Controller
@RequestMapping("/")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository repo;
	
	@GetMapping("/")
	public String home() {
		return "home";
	} 
	
	@GetMapping("/department")
	public String department(Model model) {
		
		List<Department> departmentList = (List<Department>) repo.findAll();
	    
		model.addAttribute("departmentList", departmentList);
		return "department";
	    
	}
	
}