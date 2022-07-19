package jana60.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jana60.model.Teacher;
import jana60.repository.TeacherRepository;

@Controller
@RequestMapping("/teachers")
public class TeachersController 
{
	@Autowired
	private TeacherRepository repo;
	
	@GetMapping
	public String teachersList(Model model)
	{
		model.addAttribute("TeachersList" , repo.findAll());
		return "teachers";
	}

	@GetMapping("/{teacherId}")
	public String teachersDetail(Model model,
			@PathVariable(name = "teacherId") Integer teachersPrimaryKey)
	{
		Teacher curDep = repo.findById(teachersPrimaryKey).get();
		model.addAttribute("teacher", curDep);
		return "teachersDetails";
	}
}