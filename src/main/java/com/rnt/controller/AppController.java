package com.rnt.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rnt.model.Employee;
import com.rnt.model.User;
import com.rnt.model.UserProfile;
import com.rnt.service.EmployeeService;
import com.rnt.service.UserProfileService;
import com.rnt.service.UserService;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	EmployeeService service;
	
	@Autowired
	MessageSource messageSource;
        
        @Autowired
        UserService userService;
        
        @Autowired
        UserProfileService userProfileService;

	@RequestMapping(value = {"/list"}, method = RequestMethod.GET)
	public String listEmployees(ModelMap model) {

		List<Employee> employees = service.findAllEmployees();
		model.addAttribute("employees", employees);
		return "allemployees";
	}
        
        @RequestMapping(value = {"/listprofiles"}, method = RequestMethod.GET)
	public String listProfiles(ModelMap model) {
                List<UserProfile> profiles = userProfileService.listUserProfiles();
		model.addAttribute("profiles", profiles);
		return "listprofiles";
	}
        
        @RequestMapping(value = {"/listusers"}, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {
                List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		return "listusers";
	}
        
        
        @RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String index(ModelMap model) {
		return "index";
	}
        
        @RequestMapping(value = {"/newuser"}, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
                User user = new User();
                List<UserProfile> uPlist = userProfileService.listUserProfiles();
                model.addAttribute("uplist",uPlist);
                model.addAttribute("user", user);
                model.addAttribute("edit", false);
		return "newuser";
	}
        
        @RequestMapping(value = {"/newuser"}, method = RequestMethod.POST)
	public String saveUser(@Valid User user,BindingResult result,ModelMap model) {
                if (result.hasErrors()) {
                        List<UserProfile> uPlist = userProfileService.listUserProfiles();
                        model.addAttribute("uplist",uPlist);
			return "newuser";
		}
                userService.saveUser(user);
		model.addAttribute("success", "User " + user.getName() + " registered successfully");
		return "index";
	}
        
        @RequestMapping(value = { "/edit-{id}-user" }, method = RequestMethod.GET)
	public String editUser(@PathVariable int id, ModelMap model) {
                User user = userService.findById(id);
                List<UserProfile> uPlist = userProfileService.listUserProfiles();
                model.addAttribute("uplist",uPlist);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		return "newuser";
	}
        
        // edit works, but user always have to select a profile, issue to be solved
        @RequestMapping(value = { "/edit-{id}-user" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user,BindingResult result,ModelMap model, @PathVariable int id) {
                if (result.hasErrors()) {
                        List<UserProfile> uPlist = userProfileService.listUserProfiles();
                        model.addAttribute("uplist",uPlist);
			return "newuser";
		}
                userService.updateUser(user);
                model.addAttribute("success", "User " + user.getName() + " updated successfully");
		return "index";
	}
        
        @RequestMapping(value = { "/delete-{id}-user" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable int id) {
                userService.deleteUserById(id);
		return "redirect:/listusers";
	}
        
        @RequestMapping(value = {"/newprofile"}, method = RequestMethod.GET)
	public String newProfile(ModelMap model) {
                UserProfile userProfile = new UserProfile();
                model.addAttribute("userProfile", userProfile);
                model.addAttribute("edit", false);
		return "newprofile";
	}
        
        @RequestMapping(value = {"/newprofile"}, method = RequestMethod.POST)
	public String saveProfile(@Valid UserProfile userProfile,BindingResult result,ModelMap model) {
            if (result.hasErrors()) {
                return "newprofile";
            }
               userProfileService.saveUserProfile(userProfile);
               model.addAttribute("success", "User Profile " + userProfile.getDesignation() + " registered successfully");
               return "index";
	}
        
        @RequestMapping(value = { "/edit-{id}-userProfile" }, method = RequestMethod.GET)
	public String editUserProfile(@PathVariable int id, ModelMap model) {
                UserProfile userProfile = userProfileService.findById(id);
                model.addAttribute("userProfile",userProfile);
		model.addAttribute("edit", true);
		return "newprofile";
	}
        
        // edit works, but user always have to select a profile, issue to be solved
        @RequestMapping(value = { "/edit-{id}-userProfile" }, method = RequestMethod.POST)
	public String updateUserProfile(@Valid UserProfile userProfile,BindingResult result,ModelMap model, @PathVariable int id) {
                if (result.hasErrors()) {
			return "newprofile";
		}
                userProfileService.updateUserProfile(userProfile);
                model.addAttribute("success", "User " + userProfile.getDesignation() + " updated successfully");
		return "index";
	}
        
        @RequestMapping(value = { "/delete-{id}-userProfile" }, method = RequestMethod.GET)
	public String deleteUserProfile(@PathVariable int id) {
                userProfileService.deleteUserProfileById(id);
		return "redirect:/listprofiles";
	}
        
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newEmployee(ModelMap model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		model.addAttribute("edit", false);
		return "registration";
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveEmployee(@Valid Employee employee, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		/*
		 * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation 
		 * and applying it on field [ssn] of Model class [Employee].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */
		if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
			FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
		    result.addError(ssnError);
			return "registration";
		}
		
		service.saveEmployee(employee);

		model.addAttribute("success", "Employee " + employee.getName() + " registered successfully");
		return "success";
	}


	/*
	 * This method will provide the medium to update an existing employee.
	 */
	@RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.GET)
	public String editEmployee(@PathVariable String ssn, ModelMap model) {
		Employee employee = service.findEmployeeBySsn(ssn);
		model.addAttribute("employee", employee);
		model.addAttribute("edit", true);
		return "registration";
	}
	
	/*
	 * This method will be called on form submission, handling POST request for
	 * updating employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.POST)
	public String updateEmployee(@Valid Employee employee, BindingResult result,
			ModelMap model, @PathVariable String ssn) {

		if (result.hasErrors()) {
			return "registration";
		}

		if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
			FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
		    result.addError(ssnError);
			return "registration";
		}

		service.updateEmployee(employee);

		model.addAttribute("success", "Employee " + employee.getName()	+ " updated successfully");
		return "success";
	}

	
	/*
	 * This method will delete an employee by it's SSN value.
	 */
	@RequestMapping(value = { "/delete-{ssn}-employee" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable String ssn) {
		service.deleteEmployeeBySsn(ssn);
		return "redirect:/list";
	}

}
