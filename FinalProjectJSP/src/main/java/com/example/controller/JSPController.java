package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JSPController {

	
	
	@RequestMapping(value="/invoice")
	public String sendInvoice()
	{
		return "invoice";
	}
	
	@RequestMapping(value="/submit")
	public String wel() {
		return "submit";
	}
	
	@RequestMapping(value="/ExistingMerchantInvitation")
	public String sendInvitationToExistingMerchant()
	
	{
		return "ExistingMerchantInvitation";
	}
	
	
	@RequestMapping(value="/AddThirdPartyMerchant")
	public String addThirdPartyMerchantDetails() {
		
		return "AddThirdPartyMerchant";
	}
	
	

	@RequestMapping(value = "/CustomerInvitation")
	public String sendInvitationToCustomer()

	{
		return "CustomerInvitation";
	}

	@RequestMapping(value = "/scheme")
	public String sendScheme() {
		return "scheme";
	}

	@RequestMapping(value = "/promo")
	public String sendPromo() {
		return "Promo";
	}
	
	@RequestMapping(value = "/feedback")
	public String sendFeedback() {
		return "feedback";
	}
	@RequestMapping(value = "/feedbackAdmin")
	public String sendFeedbackAdmin() {
		return "feedbackAdmin";
	}
	@RequestMapping(value = "/feedbackCustomer")
	public String sendFeedbackCust() {
		return "feedbackCustomer";
	}
	@RequestMapping(value = "/feedbackMerchant")
	public String sendFeedbackMerchant() {
		return "feedbackMerchant";
	}

	@RequestMapping(value="/MerchantInvitation")
	public String sendInvitationToMerchant()
	
	{
		return "MerchantInvitation";
	}
	
	
	@RequestMapping(value="/AddMerchant")
	public String addMerchantDetails() {
		System.err.println("In JSP CONTROL TRANSFER  >>>");
		return "AddMerchant";
	}
	
	
	@RequestMapping(value="/DeleteMerchant")
	public String deleteMerchantDetails() {
		System.err.println("In JSP CONTROL TRANSFER  >>>");
	
		return "DeleteMerchant";
	}
	
	@RequestMapping(value="/revenue")
	public String transfer(){
		System.err.println("JSP CALLING");
		return "revenue";
	}
	
	@RequestMapping(value="/order")
	public String getDispatchReport() {
		return "order";
	}

	@RequestMapping(value="/merchant")
	public String getParticularProductDetails() {
		return "merchant";
	}
	
	@RequestMapping(value="/transactionAnalysis")
	public String getTransactionalDetails() {
		return "transactionAnalysis";
	}

		
	}



