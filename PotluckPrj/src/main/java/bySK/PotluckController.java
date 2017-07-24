package bySK;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class PotluckController
{

	@Autowired
	private PotluckRepository potluckRepository;
	
	
	@RequestMapping("/")
	public String loadForm(Model model)
	{
		model.addAttribute(new PersonFood()); 
		return "EnterData"; //call to EnterData form
		
	}
	
	
	@PostMapping("/addFood")
	public @ResponseBody String addFood(@ModelAttribute PersonFood personFood, Model model)
	{
		model.addAttribute("personfoodmsg",personFood);
		potluckRepository.save(personFood);
		return " food has been added ";
	}
	
	/*
	//Validation added
	@PostMapping("/addFood")
	public @ResponseBody String addFood(@Valid PersonFood personFood, BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors())
		{
			return "Error in fields";
			
		}
		model.addAttribute("personfoodmsg",personFood);
		potluckRepository.save(personFood);
		return "Food has been added ";
	} */
	
	@PostMapping("/printList")
	public String printList(Model model)
	{
		Iterable<PersonFood> foodList = potluckRepository.findAll();
		model.addAttribute("ListFoodMsg", foodList);
		return "Output";
	}
}
