package com.wipro.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.wipro.car.model.Employee;
import com.wipro.car.service.EmployeeService;

@Controller
public class EmployeeController {
	//display list of employees
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees",employeeService.getAllEmployees());
		return "index";
	}
	
	@GetMapping(path = "/findCarbyModel",params = "findModel")
	public ModelAndView findAllCarsByModels(@RequestParam("email") String brandemail){

		ModelAndView mav = new ModelAndView();		
		List<Employee> carsListByModel = employeeService.findAllCarModels(brandemail);

		mav.addObject("carsList", carsListByModel);
		mav.setViewName("carslistbybrand");

		return mav;
	}
	@GetMapping("/sortcarbybrand")
	public String carsortbybrand() {
		return "carbybrand";
	}
	
	@GetMapping("/sortcarbyprice")
	public String carsortbyprice() {
		return "carbyprice";
	}
	
	@GetMapping(path = "/findCarbyModel",params = "back")
	public String carHomePageBrand() {
		return "index";
	}
	@GetMapping(path = "/findCarbyPrice",params = "back")
	public String carHomePagePrice() {
		return "index";
	}
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee)	;
		return "redirect:/";
		
	}
}
