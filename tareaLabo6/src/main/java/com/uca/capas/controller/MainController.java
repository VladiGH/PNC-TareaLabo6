package com.uca.capas.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;
import com.uca.capas.service.ContribuyenteService;
import com.uca.capas.service.ImportanciaService;

@Controller
public class MainController {
	@Autowired
	ContribuyenteService contribuyenteService;
	
	@Autowired
	ImportanciaService importanciaService;
	
	@RequestMapping("/inicio")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		List<Importancia> importancias = null;
		try {
			importancias = importanciaService.findAll();
			mav.addObject("importanciaL", importancias);
		}catch (Exception e){
			e.printStackTrace();
		}
		mav.setViewName("index");
		mav.addObject("contribuyente", new Contribuyente());
		return mav;
	}
	
	@PostMapping("/guardarContribuyente")
	public ModelAndView save(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date date = new Date();  
	    System.out.println(formatter.format(date));  
		if(!(result.hasErrors())) {
			try{
				contribuyente.setFechaIngreso(date);
				contribuyenteService.save(contribuyente);
				mav.setViewName("exito");
			}catch (Exception e) {
				e.printStackTrace();
			}
			//mav.addObject("contribuyente", new Contribuyente());
		} else {
			List<Importancia> importancias = null;
			try {
				importancias = importanciaService.findAll();
				mav.addObject("importanciaL", importancias);
			}catch (Exception e){
				e.printStackTrace();
			}
			mav.setViewName("index");
		}
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyentes = null;
		try {
			contribuyentes = contribuyenteService.findAll();
		}catch (Exception e){
			e.printStackTrace();
		}
		mav.addObject("contribuyentes", contribuyentes);
		mav.setViewName("listadoC");
		return mav;
	}
}
