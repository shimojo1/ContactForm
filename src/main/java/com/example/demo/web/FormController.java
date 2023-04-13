package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Form;
import com.example.demo.service.FormService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/ContactForm")
public class FormController {
	@Autowired
	FormService formService;

	
	/*
	 * 確認画面へ遷移
	 */
	@PostMapping(value = "/confirm")
	public String register(@Valid @ModelAttribute Form form, BindingResult result, Model model, HttpSession session) {
		try {
			if (result.hasErrors()) {
				return "redirect:/ContactForm/input";
			}
			// セッションにフォーム情報をセット
			session.setAttribute("form", form);
			
		} catch(Exception e) {
			return "redirect:/ContactForm/input";
		}
		return "ContactForm/confirm";
	}
	
	/*
	 * 入力画面に戻る
	 */
	@GetMapping(path = {"", "/"})
	public String back(Form form, HttpSession session, Model model) {
		// セッションからフォーム情報を取得する
        Form sessionForm = (Form) session.getAttribute("form");
        if (sessionForm == null) {
            // セッションにフォーム情報がない場合は、入力画面に遷移する
            return "ContactForm/input";
        }
        // フォーム情報をモデルに追加する
        model.addAttribute("form", sessionForm);
		return "ContactForm/input";
	}
	
	/*
	 * DB登録
	 */
	@PostMapping(value = "/complete")
	public String register(HttpSession session) {
		try {
			// 新規登録
			Form form = (Form) session.getAttribute("form");
			formService.save(form);
			// セッションクリア
			session.invalidate();
			
		} catch (Exception e) {
			return "redirect:/ContactForm/confirm";
		}
		return "ContactForm/complete";
	}
}