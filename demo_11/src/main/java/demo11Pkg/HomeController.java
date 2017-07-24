package demo11Pkg;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*

@RestController
public class HomeController {

	@RequestMapping("/")
	public String index()
	{
		return " Greeting from STS";
		
	}
}*/


@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(Model model)
	{
		model.addAttribute("message" , "HELLO_Msg");
		return "hello";
	}
}

