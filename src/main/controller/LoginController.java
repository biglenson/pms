package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import Util.CMCCConstant;
@Controller
public class LoginController {
	
	@RequestMapping(value ="/")
	public String index(){
		return CMCCConstant.ZongheDashBoard;
	}

}
