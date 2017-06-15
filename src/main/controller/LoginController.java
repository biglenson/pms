import org.springframework.web.bind.annotation.RequestMapping;

public class LoginController {
	
	@RequestMapping("/")
	public String index(){
		return "login";
	}
	@RequestMapping("/login") // @RequestMapping 注解可以用指定的URL路径访问本控制层
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) {

		if (username.equals("admin") && password.equals("admin")) {
			model.addAttribute("username", username);
			return "ok.jsp";
		} else {
			model.addAttribute("username", username);
			return "no.jsp";
		}
	}
}
