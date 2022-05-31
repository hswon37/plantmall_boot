package com.example.plantmall.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.plantmall.domain.Category;
import com.example.plantmall.domain.Product;
import com.example.plantmall.service.ProductService;

@Controller
public class ManageProductController {
	
		private ProductService productService;
			
		@Autowired
		public void setProductService(ProductService productService) {
			this.productService = productService;
		}
		
		//제품 관리 목록
		@RequestMapping("/product/manage")
		public String showProductManage(@RequestParam(value="userId") String userId, 
									ModelMap model) throws Exception {
			List<Product> itemList = this.productService.getProductListforUser(userId);
			//		String userName = this.~.getUserName(p.userId); //현재 user명 가져오는 방법 없음..
			String userName = "admin";	//임시 userName

			List<List<Product>> productList = new ArrayList<>();
			
			try {
				for (int i = 0; i < itemList.size(); i += 4) {
					List<Product> miniProductList = new ArrayList<>();
					 
					productList.add(miniProductList);
					for (int j = 0; j < 4; j++) {
						miniProductList.add(itemList.get(i+j));
					} 
				}
			} catch (IndexOutOfBoundsException e) {
				System.out.println("더 이상 제품을 찾을 수 없음");
			}
			System.out.println("user: "+userName+"의 관리 페이지 model -> view 전달");
			
			model.put("userId", userId);
			model.put("userName", userName);
			model.put("productList", productList);
			
			return "product/productManage";
		}
		
		//제품 등록
		@RequestMapping("/product/registration")
		public String showProductRegistration(@RequestParam(value="userId") String userId, 
											ModelMap model) {
			
			List<Category> categoryList = this.productService.getCategoryList();
			
			model.put("userId", userId);
			model.put("categoryList", categoryList);
			
			return "product/productRegistration";
		} 
		//제품 등록 완료
		@RequestMapping("/product/registrationResult")
		public String productRegistration(Product product, RedirectAttributes rttr) throws Exception {
			
			this.productService.insertProduct(product);
			
			System.out.println(product.getP_name()+" 제품 등록 완료");
			System.out.println(product);
			rttr.addFlashAttribute(product.getP_name()+" 제품이 등록되었습니다.");
			
			return "redirect:/product/manage?userId="+product.getUserId();
		}
		
		//제품 수정
		@RequestMapping("/product/modify")
		public String showProductModify(@RequestParam(value="userId") String userId, 
				@RequestParam(value="productId") String productId, 
				ModelMap model) throws Exception {
			
			Product product = this.productService.getProduct(productId);
			List<Category> categoryList = this.productService.getCategoryList();

			model.put("userId", userId);
			model.put("product",  product);
			model.put("categoryList", categoryList);
			
			System.out.println(product.getP_name()+" 제품 수정 페이지");
			
			return "product/productModify";
		}
		//제품 수정 완료
		@RequestMapping("/product/modifyResult")
		public String productModify(Product product, RedirectAttributes rttr) throws Exception {
			
			this.productService.updateProduct(product);
			
			System.out.println(product.getP_name()+" 제품 수정 완료");
			System.out.println(product);
			rttr.addFlashAttribute(product.getP_name()+" 제품이 수정되었습니다.");
			
			return "redirect:/product/manage?userId="+product.getUserId();
		}
		
		//제품 삭제
		@RequestMapping("/product/delete")
		public String showProductDelete(@RequestParam(value="userId") String userId, 
				@RequestParam(value="productId") String productId, 
				ModelMap model) throws Exception {
			
			Product product = this.productService.getProduct(productId);
			List<Category> categoryList = this.productService.getCategoryList();
			
			model.put("userId", userId);
			model.put("product",  product);
			model.put("categoryList", categoryList);
			
			System.out.println(product.getP_name()+" 제품 삭제 페이지");
			
			return "product/productDelete";
		}
		//제품 삭제 완료
		@ResponseBody
		@RequestMapping("/product/deleteResult")
		public String productDelete(Product product, RedirectAttributes rttr) throws Exception {
			
			List<Product> checkProductinLineItem = this.productService.getProductHaveLineItem(product.getProductId());
			String resultmsg = "";
			
			if (checkProductinLineItem.size() > 0) {	//lineItem에 담긴 제품은 삭제 불가
				System.out.println(product.getP_name()+" 제품을 삭제할 수 없음");
				resultmsg = "<script>alert('해당 제품을 삭제할 수 없음');location.href='/product/manage?userId="+product.getUserId()+"'</script>";
			}
			else {
				this.productService.deleteContentHaveProduct(product);	//해당 제품 관련 피드 있으면 먼저 삭제
				this.productService.deleteProduct(product);				//그다음 제품 삭제
				
				System.out.println(product.getP_name()+" 제품 삭제 완료");
				System.out.println(product);
				rttr.addFlashAttribute(product.getP_name()+" 제품이 삭제되었습니다.");
			
				resultmsg = "<script>alert('해당 제품이 삭제되었습니다');location.href='/product/manage?userId="+product.getUserId()+"'</script>";
			}
			
			return resultmsg;
		}
				
}
