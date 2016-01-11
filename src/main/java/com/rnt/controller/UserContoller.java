/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.controller;

import com.rnt.model.User;
import com.rnt.model.UserProfile;
import com.rnt.service.UserProfileService;
import com.rnt.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Nuno
 */
@Controller
@RequestMapping("/")
public class UserContoller {
    
    @Autowired
        UserService userService;
        
        @Autowired
        UserProfileService userProfileService;
        
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
                if(userService.findUserByNif(user.getNif())!=null || userService.findUserByEmail(user.getEmail())!=null){
                    List<UserProfile> uPlist = userProfileService.listUserProfiles();
                    model.addAttribute("uplist",uPlist);
                    model.addAttribute("error", "User email ou nif already registered");
                    return "newuser";
                }
                userService.saveUser(user);
		model.addAttribute("message", "User " + user.getName() + " registered successfully");
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
                model.addAttribute("message", "User " + user.getName() + " updated successfully");
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
               model.addAttribute("message", "User Profile " + userProfile.getDesignation() + " registered successfully");
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
                model.addAttribute("message", "User " + userProfile.getDesignation() + " updated successfully");
		return "index";
	}
        
        @RequestMapping(value = { "/delete-{id}-userProfile" }, method = RequestMethod.GET)
	public String deleteUserProfile(@PathVariable int id) {
                userProfileService.deleteUserProfileById(id);
		return "redirect:/listprofiles";
	}
    
}
