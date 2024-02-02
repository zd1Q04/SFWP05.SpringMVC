package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.Item;

import jakarta.servlet.http.HttpSession;

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
	public String addPost(
			Item item,
			HttpSession session
			) {
		
		if (item.getName().isBlank()) {
			// 商品名が未入力⇒フォームを再表示
			return "item/add";
		}

		session.setAttribute("item", item);

		return "redirect:/item/addDone";
	}

	@GetMapping("/addDone")
	public String addDone(HttpSession session, Model model) {

		// セッションからデータを取得
		Item item = (Item) session.getAttribute("item");

		// セッションを破棄
		session.invalidate();

		model.addAttribute("item", item);
		return "item/addDone";

	}

	@GetMapping("/show/{id}")
	public String show(@PathVariable Integer id, Model model) {
		if (id.equals(1)) {
			model.addAttribute("info", "青森県産の美味しいりんごです。");
		} else if (id.equals(2)) {
			model.addAttribute("info", "愛媛県産の美味しいみかんです。");
		} else {
			// 該当する商品がないので、一覧へリダイレクト
			return "redirect:/item";
		}
		return "item/show";
	}

}
