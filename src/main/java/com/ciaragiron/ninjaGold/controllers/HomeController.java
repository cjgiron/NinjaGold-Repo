package com.ciaragiron.ninjaGold.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping(value="/processGold", method=RequestMethod.POST)
	public String processGold(@RequestParam(value="venue") String venue, HttpSession session) {
		
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		
		if (session.getAttribute("activityLog") == null) {
			session.setAttribute("activityLog", "");
		}
		
		if(venue.equals("farm")) {
			Random ran = new Random();
			int range = 11;
			int randomNum = ran.nextInt(range) + 10;
			System.out.println(randomNum);
			
			Date myDate = new Date();
			String dateStr = new SimpleDateFormat("MMMM dd, YYYY").format(myDate);
			
			Calendar cal = Calendar.getInstance();
			Date localTime = cal.getTime();
			String timeStr = new SimpleDateFormat("hh:mm").format(localTime);
			
			String str = String.format("You earned %d gold at the %s. %s %s <br>", randomNum, venue, dateStr, timeStr);
			System.out.println(str);
			
			session.setAttribute("activityLog", session.getAttribute("activityLog") + str);
			session.setAttribute("gold", (Integer) session.getAttribute("gold") + randomNum);
			return "redirect:/home";
		}
		
		else if(venue.equals("cave")) {
			Random ran = new Random();
			int range = 6;
			int randomNum = ran.nextInt(range) + 5;
			System.out.println(randomNum);
			
			Date myDate = new Date();
			String dateStr = new SimpleDateFormat("MMMM dd, YYYY").format(myDate);
			
			Calendar cal = Calendar.getInstance();
			Date localTime = cal.getTime();
			String timeStr = new SimpleDateFormat("hh:mm").format(localTime);
			
			String str = String.format("You earned %d gold at the %s. %s %s <br>", randomNum, venue, dateStr, timeStr);
			System.out.println(str);
			
			session.setAttribute("activityLog", session.getAttribute("activityLog") + str);
			session.setAttribute("gold", (Integer) session.getAttribute("gold") + randomNum);
			return "redirect:/home";
		}
		
		else if(venue.equals("house")) {
			Random ran = new Random();
			int range = 3;
			int randomNum = ran.nextInt(range) + 2;

			Date myDate = new Date();
			String dateStr = new SimpleDateFormat("MMMM dd, YYYY").format(myDate);
			
			Calendar cal = Calendar.getInstance();
			Date localTime = cal.getTime();
			String timeStr = new SimpleDateFormat("hh:mm").format(localTime);
			
			String str = String.format("You earned %d gold at the %s. %s %s <br>", randomNum, venue, dateStr, timeStr);
			System.out.println(str);
			
			session.setAttribute("activityLog", session.getAttribute("activityLog") + str);
			session.setAttribute("gold", (Integer) session.getAttribute("gold") + randomNum);
			return "redirect:/home";
		}
		
		else if(venue.equals("casino")) {
			Random ran = new Random();
			int randomNum = ran.nextInt(100) - 50;
			
			if(randomNum > 0) {

				Date myDate = new Date();
				String dateStr = new SimpleDateFormat("MMMM dd, YYYY").format(myDate);
				
				Calendar cal = Calendar.getInstance();
				Date localTime = cal.getTime();
				String timeStr = new SimpleDateFormat("hh:mm").format(localTime);
				
				String str = String.format("You earned %d gold at the %s. %s %s <br>", randomNum, venue, dateStr, timeStr);
				System.out.println(str);
				
				session.setAttribute("activityLog", session.getAttribute("activityLog") + str);
			} else if (randomNum < 0) {

				Date myDate = new Date();
				String dateStr = new SimpleDateFormat("MMMM dd, YYYY").format(myDate);
				
				Calendar cal = Calendar.getInstance();
				Date localTime = cal.getTime();
				String timeStr = new SimpleDateFormat("hh:mm").format(localTime);
				
				String str = String.format("You lost %d gold at the %s. Ouch. %s %s <br>", randomNum, venue, dateStr, timeStr);
				System.out.println(str);
				session.setAttribute("activityLog", session.getAttribute("activityLog") + str);
			}
			session.setAttribute("gold", (Integer) session.getAttribute("gold") + randomNum);
			return "redirect:/home";
		}
		
		return "redirect:/home";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}
}
