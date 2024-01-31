package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class ItemController {

	@GetMapping
	public String list() {
		return "item/list";
	}

	@GetMapping("/add")
	public String addGet() {
		return "item/add";
	}

	@PostMapping("/add")
	public String addPost() {
		return "redirect:/item/addDone";
	}

	@GetMapping("/addDone")
	public String addDone() {
		return "item/addDone";
	}

}
