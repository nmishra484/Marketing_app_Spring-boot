package com.marketingapp1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp1.dto.LeadDto;
import com.marketingapp1.entity.Lead;
import com.marketingapp1.service.LeadService;
import com.marketingapp1.util.EmailService;

@Controller
public class LeadController {
	@Autowired
private LeadService leadService;//new LeadServiceImpl();
	
	@Autowired
private EmailService emailService;
	
	//http://localhost:8080/create
	@RequestMapping("/create")
	public String viewLeadForm() {
		return "create_lead";
		
	}
	@RequestMapping("/savereg")
	public String saveLead(@ModelAttribute Lead lead , Model model) {
	leadService.saveLead(lead);
	model.addAttribute("msg", "Record is saved!!");
	emailService.sendEmail(lead.getEmail(),"welcome" , "Test");
	return "create_lead";
	
	}

//	@RequestMapping("/savereg")
//	public String saveLead(
//			@RequestParam("firstName") String firstName,
//			@RequestParam("lastName") String lastName,
//			@RequestParam("email") String email,
//			@RequestParam("mobile") long mobile
//			) {
//		Lead lead = new Lead();
//	    lead.setFirstName(firstName);
//	    lead.setLastName(lastName);
//	    lead.setEmail(email);
//	    lead.setMobile(mobile);
//	leadService.saveLead(lead);
//	return "create_lead";
	
//	}
//}
	//http://localhost:8080/listall
	@RequestMapping("/listall")
public String listAllLeads(Model model) {
	List<Lead>leads=leadService.listLeads();
	model.addAttribute("leads", leads);
	return "search_results";
}
	@RequestMapping("/delete")
	public String deleteLead(@RequestParam("id") long id,Model model) {
		leadService.deleteLead(id);
		
		List<Lead>leads=leadService.listLeads();
		model.addAttribute("leads", leads);
		return "search_results";
	}
	@RequestMapping("/update")
	public String updateLead(@RequestParam("id") long id,Model model) {
		Lead lead = leadService.findLead(id);
		model.addAttribute("lead",lead);
		return "update_lead";
	}
	@RequestMapping("/updatereg")
	public String updateReg(LeadDto leadDto,Model model ) {
		Lead lead = new Lead();
		lead.setId(leadDto.getId());
		lead.setFirstName(leadDto.getFirstName());
		lead.setLastName(leadDto.getLastName());
		lead.setEmail(leadDto.getEmail());
		lead.setMobile(leadDto.getMobile());
		leadService.saveLead(lead);
		
		List<Lead>leads=leadService.listLeads();
		model.addAttribute("leads", leads);
		return "search_results";
	}
}
