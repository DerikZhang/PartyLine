package cn.bnuz.party.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Exception {

	
	@RequestMapping("/exception")
	public String Exception(){
		
		return "exception";
	}
}
