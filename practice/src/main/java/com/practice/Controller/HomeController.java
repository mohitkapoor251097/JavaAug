package com.practice.Controller;


import com.practice.Repository.UserRepository;
import com.practice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;
  //  @ResponseBody

    @ModelAttribute
    public void commonData(Model model)
    {
        model.addAttribute("title","User Page");
    }
    @RequestMapping("/")
    public String home(Model model)
    {

        model.addAttribute("name","Mohit kapoor");
        System.out.println("this is home");
        return "home";
    }

//    @RequestMapping("/final_page")
//    public String Success(@RequestParam("email") String email,@RequestParam("password") String password)
//    {
//        System.out.println("Email is"+ email);
//        System.out.println("Password is+ "+password);
//        return "success";
//    }

//    @RequestMapping("/final_page")
//    public ModelAndView sucess(@RequestParam("email") String email, @RequestParam("password") String password,
//                               @RequestParam("gender")String gender)
//    {
//
//        if(email.isBlank()|| email.isBlank() || gender.isEmpty())
//        {
//            System.out.println("pleae enter");
//            ModelAndView modelAndView = new ModelAndView();
//            modelAndView.setViewName("home");
//
//            return modelAndView;
//        }
//        else {
//            System.out.println("gender is" + gender);
//            ModelAndView modelAndView = new ModelAndView();
//            modelAndView.addObject("email", email);
//            modelAndView.addObject("password", password);
//            modelAndView.addObject("gender", gender);
//            modelAndView.addObject("submitted", "Your form is submitted Successfully !");
//            modelAndView.setViewName("success");
//
//            return modelAndView;
//        }
//    }


    @RequestMapping(value = "/final_page",method = RequestMethod.POST)
    public String success(@ModelAttribute User u,Model model,BindingResult result)
    {
        User user = this.userRepository.getuserByUserName(u.getEmail());
        if(user!=null)
        {
            System.out.println("email exits");
            model.addAttribute("error","Email Id Already Exists Try another Email...");
            return "home";
        }
        model.addAttribute("user",u);
        User save = this.userRepository.save(u);
        System.out.println(u);
        System.out.println("Saved user"+ save);
        model.addAttribute("saved","User is saved Successfully !");
        return "home";
    }

    @GetMapping("/allusers")
    public String allUsers(Model model)
    {
        List<User> all = this.userRepository.findAll();
        Collections.sort(all, Comparator.comparing(User::getId).reversed());
        all.forEach(System.out::println);
     model.addAttribute("users",all);
        return "alluser";
    }
//
//
    @GetMapping("/allusers/{uId}")
    public String UserById(@PathVariable int uId)
    {
        User user = this.userRepository.findById(uId).get();
        System.out.println(user);
        return "home";
    }

    @GetMapping("/users/{id}")
    public String UserDelete(@PathVariable int id,Model m)
    {
        try
        {

            this.userRepository.deleteById(id);
            m.addAttribute("deleteuser","User Deleted Successhully !!");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "redirect:/allusers";
    }

    @PostMapping("/user/update/{id}")
    public String updateForm(@PathVariable int id,Model model)
    {
        User user = this.userRepository.findById(id).get();
        System.out.println(user.getEmail());
        model.addAttribute("user",user);
//        System.out.println(id);
        return "update_form";
    }
    @PostMapping("/update_success")
    public  String UpdateSuccess(@ModelAttribute User u,Model model)
    {

        this.userRepository.save(u);

        return "redirect:/allusers";
    }
//    @PostMapping("/final_page")
//    public String DBSave(@ModelAttribute User u,Model model)
//    {
//        User save = this.userRepository.save(u);
//        model.addAttribute("user",u);
//        return "success";
//    }
}
