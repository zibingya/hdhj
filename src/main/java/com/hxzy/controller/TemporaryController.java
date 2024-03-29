package com.hxzy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TemporaryController {
	/**
	 * 主页
	 * */
	@GetMapping("/index")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("/map");
		return mav;
	}
	
	@GetMapping("/new")
	public ModelAndView newf(ModelAndView mav) {
		mav.setViewName("/newfile");
		return mav;
	}
	
	@GetMapping("/trys")
	public ModelAndView newt(ModelAndView mav) {
		System.out.println("come in");
		mav.setViewName("/try");
		return mav;
	}
	
	@GetMapping("/one")
	public ModelAndView newst(ModelAndView mav) {
		mav.setViewName("/onestation");
		return mav;
	}
	
	@GetMapping("/getsurvey")
	public ModelAndView newsy(ModelAndView mav) {
		mav.setViewName("/showsurvey");
		return mav;
	}
}
