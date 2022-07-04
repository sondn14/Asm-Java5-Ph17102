package com.asm.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asm.model.CartItem;
import com.asm.model.Motobike;
import com.asm.model.MotobikeColor;
import com.asm.model.MotobikeCompany;
import com.asm.model.MotobikeType;
import com.asm.reponsitory.IMotobikeReponsitory;
import com.asm.service.MotobikeService;
import com.asm.service.ShoppingCartService;

@Controller
public class HomeController {

	@Autowired
	private MotobikeService service;

	@Autowired
	private ShoppingCartService cartService;
	
	@Autowired
	private IMotobikeReponsitory iMotobikeReponsitory;

	@GetMapping("/home")
	public String home(Model model) {
		List<Motobike> listXe = service.getAll();
		model.addAttribute("listXe", listXe);
		return "index";
	}

	@GetMapping("/motobike")
	public String product(Model model) {
		List<Motobike> listXe = service.getAll();
		model.addAttribute("listXe", listXe);
		return "shop";
	}

	@GetMapping("motobike/detail/{motobikeId}")
	public String motobikeDetail(Model model, @PathVariable(value = "motobikeId") int motobikeId) {
		List<Motobike> motobike = service.getById(motobikeId);
		model.addAttribute("sp", motobike);
		List<Motobike> listXe = service.getAll();
		model.addAttribute("listXe", listXe);
		return "detail";
	}

	@GetMapping("admin")
	public String addMotobike(Model model,
			@RequestParam(name = "pageNumber", defaultValue = "0", required = false) int pageNumber) {
		Page<Motobike> page = service.findPage(pageNumber);
		MotobikeCompany[] motobikeCompanys = MotobikeCompany.values();
		model.addAttribute("motobikeCompanys", motobikeCompanys);
		model.addAttribute("page", page);
		return "table";
	}

	@GetMapping("company")
	public String company(Model model, @RequestParam(name = "motobikeCompany", required = false) String company) {
		if (company.equals("all")) {
			return "redirect:/admin";
		} else {
			MotobikeCompany Motocompany = MotobikeCompany.valueOf(company);
			Page<Motobike> page = service.getByCompany(Motocompany, 0);
			MotobikeCompany[] motobikeCompanys = MotobikeCompany.values();
			model.addAttribute("motobikeCompanys", motobikeCompanys);
			model.addAttribute("page", page);
			return "table";
		}
	}

	@GetMapping("create")
	public String formAdd(Model model) {
		MotobikeType[] motobikeType = MotobikeType.values();
		MotobikeColor[] motobikeColor = MotobikeColor.values();
		MotobikeCompany[] motobikeCompany = MotobikeCompany.values();
		model.addAttribute("motobikeType", motobikeType);
		model.addAttribute("motobikeColor", motobikeColor);
		model.addAttribute("motobikeCompany", motobikeCompany);
		return "add";
	}

	@PostMapping("add")
	public String add(Motobike motobike, @RequestParam(name = "motobikeName") String motobikeName,
			@RequestParam(name = "price") BigDecimal price, @RequestParam(name = "quantity") Integer quantity,
			@RequestParam(name = "motobikeType") MotobikeType motobikeType,
			@RequestParam(name = "motobikeColor") MotobikeColor motobikeColor,
			@RequestParam(name = "motobikeCompany") MotobikeCompany motobikeCompany,
			@RequestParam(name = "anh") String anh) {
		motobike.setMotobikeName(motobikeName);
		motobike.setPrice(price);
		motobike.setQuantity(quantity);
		motobike.setMotobikeType(motobikeType);
		motobike.setMotobikeCompany(motobikeCompany);
		motobike.setMotobikeType(motobikeType);
		motobike.setAnh(anh);
		service.addMotobike(motobike);
		return "redirect:/admin";
	}

	@GetMapping("edit/{id}")
	public String updateMotobike(@PathVariable String id, Model model) {
		Integer idInteger = Integer.parseInt(id);
		MotobikeType[] motobikeTypes = MotobikeType.values();
		MotobikeColor[] motobikeColors = MotobikeColor.values();
		MotobikeCompany[] motobikeCompanys = MotobikeCompany.values();

		Motobike motobike = service.getOneMotobikeById(idInteger);

		model.addAttribute("motobike", motobike);
		model.addAttribute("motobikeTypes", motobikeTypes);
		model.addAttribute("motobikeColors", motobikeColors);
		model.addAttribute("motobikeCompanys", motobikeCompanys);
		return "update";
	}

	@PostMapping("update/{id}")
	public String update(@PathVariable(name = "id") Motobike motobike,
			@RequestParam(name = "motobikeName") String motobikeName, @RequestParam(name = "price") BigDecimal price,
			@RequestParam(name = "quantity") Integer quantity,
			@RequestParam(name = "motobikeType") MotobikeType motobikeType,
			@RequestParam(name = "motobikeColor") MotobikeColor motobikeColor,
			@RequestParam(name = "motobikeCompany") MotobikeCompany motobikeCompany,
			@RequestParam(name = "anh") String anh) {
		if ("".equals(motobikeName) || "".equals(price) || "".equals(quantity)) {
			return null;
		}
		motobike.setMotobikeName(motobikeName);
		motobike.setPrice(price);
		motobike.setQuantity(quantity);
		motobike.setMotobikeType(motobikeType);
		motobike.setMotobikeCompany(motobikeCompany);
		motobike.setMotobikeColor(motobikeColor);
		if ("".equals(anh)) {
			anh = motobike.getAnh();
			motobike.setAnh(anh);
		}
		motobike.setAnh(anh);
		service.updateMotobike(motobike);
		int countCart = cartService.getCount();
		CartItem cartExist = cartService.getOneCart(motobike.getMotobikeId());
		if (countCart > 0) {
			if (motobike.getQuantity() < cartExist.getQuantity()) {
				cartService.updateToCart(motobike.getMotobikeId(), quantity);
			}
			cartService.updatePrice(motobike.getMotobikeId());
		}
		return "redirect:/admin";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable String id) {
		Integer idInterge = Integer.parseInt(id);
		cartService.removeToCart(idInterge);
		service.deleteMotobike(idInterge);
		return "redirect:/admin";
	}
	@GetMapping("findByName")
	public String findMoto(Model model,@RequestParam(name = "name", required = false) String motobikeName) {
		List<Motobike> page =  iMotobikeReponsitory.findByMotobikeNameLike("%"+motobikeName+"%");
		model.addAttribute("page", page);
		return "table";
	}
}
