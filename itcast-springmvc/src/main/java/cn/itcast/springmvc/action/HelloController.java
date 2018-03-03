/**
 * 
 */
package cn.itcast.springmvc.action;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;











import cn.itcast.JwtConfiguration;
import cn.itcast.JwtTokenProvider;
import cn.itcast.TokenUtils;
import cn.itcast.UAAClaims;
import cn.itcast.redis.RedisApi;
import cn.itcast.redis.UUIDUtil;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/")
public class HelloController {
	/*@Autowired
	JwtTokenProvider jwtTokenProvider;
	@Autowired
	JwtConfiguration jwtConfiguration;*/
	@RequestMapping("/hello")
    public ModelAndView callHello() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg","我的第一个springmvc应用");
		mv.setViewName("hello");
		return mv;
	}
	
	@RequestMapping("/login")
	@ResponseBody
    public String login(@RequestParam(value="name") String name,@RequestParam(value="pwd") String pwd) {
//		String token = jwtTokenProvider.createToken(name,pwd);
		String token = TokenUtils.createToken(name);
		System.out.println("token="+token);
		return token;
	}
	
	/*@RequestMapping("/logout")
	@ResponseBody
    public String logout(@RequestParam(value="name") String name) {
//		String token = jwtTokenProvider.createToken(name,pwd);
		String token = TokenUtils.delToken(name);
		System.out.println("token="+token);
		return token;
	}    */
	
}
