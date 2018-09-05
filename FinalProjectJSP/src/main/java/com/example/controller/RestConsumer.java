package com.example.controller;

import java.sql.Date;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.beans.MerchantBean;
import com.example.beans.OrderBean;
import com.example.beans.PaymentDetailsBean;


@RestController
public class RestConsumer {

	/*@RequestMapping(value="/")
	public String Hello()
	{
		return "hello";
	}*/
	
	@RequestMapping(value = "/")
	public String check() {
		return "hello FRONT RUNNING";
	}

	@RequestMapping(value="/showRevenue")
	public  PaymentDetailsBean consumeMessage(){
		RestTemplate restTemplate = new RestTemplate();
		PaymentDetailsBean amount = restTemplate.getForObject("http://localhost:9002/revenue1?payment=1", PaymentDetailsBean.class);
		System.out.println(amount);
		return amount;
	}


	@RequestMapping(value="/invoiceDetails")
	public ModelMap invoice(String name, ModelMap modelMap){
		System.err.println(name);

		RestTemplate restTemplate = new RestTemplate();
		String invoice = restTemplate.postForObject("http://localhost:9002/generateInvoice",name, String.class);
		modelMap.put("invoice", invoice);
		System.out.println(invoice);
		return modelMap;
	}


	
	

	@RequestMapping(value="/AddThirdPartyDetails",method=RequestMethod.POST)
	public Model addThirdPartyMerchantDetails(MerchantBean merchantBean, Model model) {
		System.out.println("restconsumer");
		System.out.println(merchantBean);
		model.addAttribute("merchantBean",merchantBean);
		RestTemplate restTemplate=new RestTemplate();

		String merchant1=restTemplate.postForObject("http://localhost:9002/AddThirdPartyMerchant",merchantBean, String.class);

		model.addAttribute("details", merchant1);
		System.out.println("out of rest consumer");
		return model;

	}
	
	
	@RequestMapping(value="/SendMerchantInvitationMail")
	public ModelMap sendMerchantInvitationMail(String email, ModelMap model)
	{
		
		RestTemplate restTemplate=new RestTemplate();
		
		String merchant=restTemplate.postForObject("http://localhost:9002/sendInvitationToMerchant",email, String.class);
		System.out.println(merchant);
		model.put("merchant", merchant);
		
		return model;
	}
	

	@RequestMapping(value = "/registerEmail")
	public ModelMap showRegiterEmail(String name, ModelMap model) {
		System.err.println("IN JSP FRONT CONTROLLER");
		RestTemplate restTemplate = new RestTemplate();
		
		String customer = restTemplate.postForObject("http://localhost:9002/sendMail", name, String.class);
		System.out.println(customer);
		model.put("customer", customer);
		System.err.println("Out Front Controller--- Customer:" + customer);
		return model;

	}

	@RequestMapping(value = "/SendCustomerInvitationMail")
	public ModelMap sendCustomerInvitationMail(String email, ModelMap model) {
		System.err.println("IN JSP FRONT CONTROLLER");
		System.err.println("Customer email---" + email);
		RestTemplate restTemplate = new RestTemplate();
		
		String customer = restTemplate.postForObject("http://localhost:9002/sendInvitationToCustomer", email,
				String.class);
		System.out.println(customer);
		model.put("customer", customer);
		System.err.println("Out Front Controller--- Customer:" + customer);
		return model;
	}

	

	@RequestMapping(value = "/customerScheme")
	public ModelMap sendSchemeToCustomer(String name, ModelMap model) {
		System.err.println("customer scheme front end" + name);
		RestTemplate restTemplate = new RestTemplate();
		String customer = restTemplate.postForObject("http://localhost:9002/sendSchemeToCustomer", name, String.class);
		model.put("customer", customer);
		System.err.println("cuastomer out friont sjkf");
		return model;
	}

	@RequestMapping(value = "/merchantScheme")
	public ModelMap sendSchemeToMerchant(String Merchantname, ModelMap model) {
		RestTemplate restTemplate = new RestTemplate();
		String merchant = restTemplate.postForObject("http://localhost:9002/sendSchemeToMerchant", Merchantname,
				String.class);
		model.put("merchant", merchant);
		System.out.println("front" + merchant);
		return model;

	}

	@RequestMapping(value = "/customerPromo")
	public ModelMap sendPromoToCustomer(String CustomerName, ModelMap model) {
		System.err.println("customer scheme front end" + CustomerName);
		RestTemplate restTemplate = new RestTemplate();
		String customer = restTemplate.postForObject("http://localhost:9002/sendPromoToCustomer", CustomerName,
				String.class);
		model.put("customer", customer);
		System.err.println("cuastomer out friont sjkf");
		return model;
	}

	@RequestMapping(value = "/merchantPromo")
	public ModelMap sendPromoToMerchant(String Merchantname, ModelMap model) {
		System.err.println("FRONT... " + Merchantname);
		RestTemplate restTemplate = new RestTemplate();
		String merchant = restTemplate.postForObject("http://localhost:9002/sendPromoToMerchant", Merchantname,
				String.class);
		model.put("merchant", merchant);
		System.err.println("GOT front:  " + merchant);
		return model;

	}
	
	//======================================================================
	
	@RequestMapping(value="/InviteExistingMerchant")
	public ModelMap InviteExistingMerchant(String email, ModelMap model)
	{
		
		 RestTemplate restTemplate=new RestTemplate();
		
			String merchant=restTemplate.postForObject("http://localhost:9002/sendInvitationToExistingMerchant",email, String.class);
			
			model.put("merchant", merchant);
			
			return model;
	}
	
	
	
	@RequestMapping(value="/addDetails",method=RequestMethod.POST)
	public Model addMerchantDetails(MerchantBean merchantBean, Model model) {
		System.out.println("restconsumer");
		System.out.println(merchantBean);
		model.addAttribute("merchantBean",merchantBean);
		RestTemplate restTemplate=new RestTemplate();
		
		String merchant1=restTemplate.postForObject("http://localhost:9002/addMerchant",merchantBean, String.class);
		
		model.addAttribute("details", merchant1);
		return model;
		
	}
	
	
	
	@RequestMapping(value="/deleteDetails",method=RequestMethod.POST)
	public String deleteMerchantDetails(String emailId) {
		System.err.println("IN JSP FRONT CONTROLLER");
		RestTemplate restTemplate=new RestTemplate();
		System.out.println(emailId);
		String merchant1=restTemplate.postForObject("http://localhost:9002/DeleteMerchant?emailId="+emailId,emailId,String.class);
		System.err.println("Out Front Controller--- Merchant:"+merchant1);
		return merchant1;
		
	}
	//===========================================
	
	
	@RequestMapping(value="/message")
	public String consumMessage(){
		RestTemplate restTemplate = new RestTemplate();
		String message = restTemplate.getForObject("http://localhost:9002/getmessage?id=1", String.class);
		
		return message;
	}
	
	@RequestMapping(value="/welcome")
	public ModelMap showWelcomePage(Integer id, ModelMap model){
		
		RestTemplate restTemplate = new RestTemplate();
		String message = restTemplate.getForObject("http://localhost:9002/revenue1?payment="+id, String.class);
		System.out.println(message);
		model.put("message", message);
	
		return model;
	}
	
	//==========================
	
	@RequestMapping("/getDispatchReport")
	public ModelAndView getDetails(String orderId) {
		System.out.println("***********"+orderId);
		ModelAndView mav1 = new ModelAndView();
		RestTemplate restTemplate = new RestTemplate();
	
	
		OrderBean response = restTemplate.getForObject("http://localhost:9002/getdeliverystatus?orderId="+orderId, OrderBean.class);
		mav1.addObject("customer", response);
		System.out.println(response);
		mav1.setViewName("getDispatchReport");
		return mav1;
	}
	@RequestMapping("/getParticularProductDetails")
	public  ModelAndView category(String emailId) {
		System.out.println("***********"+emailId);
		System.err.println("Hi");
		ModelAndView mav1 = new ModelAndView();
		RestTemplate restTemplate = new RestTemplate();
		MerchantBean response = restTemplate.getForObject("http://localhost:9002/getmerchant?email="+emailId, MerchantBean.class);
		mav1.addObject("customer",response);
		System.out.println(response);
		mav1.setViewName("getParticularProductDetails");
		return mav1;
		
	}
	@RequestMapping("/getTransactionalDetails")
	public  ModelAndView transactionAnalysis(Date start, Date end) {
		System.out.println("***********"+start+"*******"+end);
		ModelAndView mav = new ModelAndView();
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<Date, Date> map = new LinkedMultiValueMap<Date, Date>();
		map.add(start, end);
		System.out.println(map);
		PaymentDetailsBean response = restTemplate.postForObject("http://localhost:9002/generateanalysis?", map,PaymentDetailsBean.class);
		mav.addObject("customer", response);
		mav.setViewName("getTransactionalDetails");
		return mav;
	}
	
	

	


}