package com.example.plantmall.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.example.plantmall.domain.LineItem;
import com.example.plantmall.domain.Review;
import com.example.plantmall.service.OrderService;
import com.example.plantmall.service.ReviewService;

@Controller
@RequestMapping("/review")
@SessionAttributes("reviewForm")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private OrderService orderService;
	
	@ModelAttribute("reviewForm")
	public ReviewForm createOrderForm() {
		System.out.println("@ModelAttribute(reviewForm) work\n");
		return new ReviewForm();
	}
	
	@RequestMapping("/check")
	public ModelAndView reviewCheck(@RequestParam("userId") String userId, @RequestParam("orderId") int orderId, @RequestParam("lineNumber") int lineNumber, 
			@ModelAttribute("reviewForm") ReviewForm reviewForm, ModelAndView mav) throws ModelAndViewDefiningException
	{
		LineItem lineItem = orderService.getLineItem(orderId, lineNumber);
		reviewForm.getReview().initReview(lineItem.getProductId(), userId, orderId, lineItem);
		
		Review review = reviewService.getReview(reviewForm.getReview());
		System.out.println(review);
		if (review == null) {
			mav.setViewName("review/ReviewForm");
		}
		else {
			mav.setViewName("review/ReviewDetail");
			mav.addObject("review", review);
		}
		mav.addObject("totalPrice", lineItem.getUnitPrice() * lineItem.getQuantity());
		mav.addObject("lineItem", lineItem);
		return mav;
	}
	
	@RequestMapping("/newReviewSubmitted")
	public ModelAndView newReviewSubmitted(@Valid @ModelAttribute("reviewForm") ReviewForm reviewForm, BindingResult result, SessionStatus status,
			ModelAndView mav) {
		System.out.println("\n /newReviewSubmitted");
		if (result.hasErrors()) {
			System.out.println("hasErrore()\n");
			mav.setViewName("review/reviewForm");
			return mav;
		}
		reviewService.insertReview(reviewForm.getReview());
		
		Review review = reviewForm.getReview();
		System.out.println(review);
		
		LineItem lineItem = orderService.getLineItem(review.getOrderId(), review.getLineNumber());
		
		mav.addObject("review", review);
		mav.addObject("lineItem", lineItem);
		mav.setViewName("review/ReviewDetail");
		status.setComplete();

		return mav;
	}
	
	@RequestMapping("/UpdateReview")
	public ModelAndView updateReview(@ModelAttribute("reviewForm") ReviewForm reviewForm, @RequestParam("reviewId") int reviewId, ModelAndView mav)
			throws ModelAndViewDefiningException {
		reviewForm.getReview().initReview(reviewService.getReviewByReviewId(reviewId));
		LineItem lineItem = orderService.getLineItem(reviewForm.getReview().getOrderId(), reviewForm.getReview().getLineNumber());
		reviewForm.getReview().setLineItem(lineItem);

		mav.addObject("lineItem", lineItem);
		mav.addObject("totalPrice", lineItem.getUnitPrice() * lineItem.getQuantity());
		mav.setViewName("review/UpdateReview");
		return mav;
	}
	
	@RequestMapping("/updateReviewSumitted")
	public ModelAndView updateReviewSumitted(@Valid @ModelAttribute("reviewForm") ReviewForm reviewForm, ModelAndView mav,
			BindingResult result, SessionStatus status) throws ModelAndViewDefiningException {
		System.out.println("\n /UpdateReviewSubmitted");
		if (result.hasErrors()) {
			System.out.println("hasErrore()\n");
			mav.setViewName("review/reviewForm");
			return mav;
		}
		Review review = reviewService.updateReview(reviewForm.getReview());
		review.setLineItem(orderService.getLineItem(review.getOrderId(),review.getLineNumber()));
		status.setComplete();
		mav.setViewName("review/ReviewDetail");
		mav.addObject("lineItem", review.getLineItem());
		mav.addObject("review", review);
		return mav;
	}
}
