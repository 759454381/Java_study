package com.ssm;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","Hello Spring MVC!");
        mv.setViewName("/firstMvc.jsp");
//        mv.setViewName("firstMvc.jsp");
        return mv;
    }
}
