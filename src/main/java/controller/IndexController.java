package controller;

import java.io.Serializable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Sys_User;
import service.*;

/**
 * controller
 * @author csy81
 *
 */
@Controller
@RequestMapping("base")
public class IndexController {
 @Autowired 
 public BaseServiceImpl<Sys_User, Serializable> baseServiceImpl;
 @RequestMapping("/") 
 public String dobase (Map<String, Object> map ){
	 map.put("userlist",baseServiceImpl.getUsers());
	return "index" ;
 }
}
