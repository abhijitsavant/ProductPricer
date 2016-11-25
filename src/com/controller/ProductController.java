package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.ProductBean;
import com.entities.ProductDetail;
import com.service.ProductService;

@Controller
public class ProductController {
	private ProductService productService;
	
	@Autowired
	@Qualifier(value="productService")
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public ModelAndView getAddProductPage(Map<String, Object> model) {
		ProductBean productBean = null;
		ModelAndView modelAndView = new ModelAndView("AddProductInformation");
		productBean = productService.getStoreList();
		modelAndView.addObject("stores", productBean.getStores());
		modelAndView.addObject("productLoaderForm",productBean);
		return modelAndView;
	}

	@RequestMapping(value = "/addProductInformationForm", method = RequestMethod.POST)
	public ModelAndView upsertProductData(@ModelAttribute("productLoaderForm") ProductBean productLoaderForm) {
		boolean isProductSaved = false;
		ProductBean productBean = null;
		isProductSaved = productService.upsertProductInformation(productLoaderForm);
		productBean = productService.getStoreList();
		ModelAndView modelAndView = new ModelAndView("AddProductInformation","productLoaderForm",productLoaderForm);
		modelAndView.addObject("stores", productBean.getStores());
		modelAndView.addObject("isProductSaved", isProductSaved?"Product Added Successfully...!":"Saving Failed...!");
		modelAndView.addObject("productLoaderForm",productLoaderForm);
		return modelAndView;
	}
	
	@RequestMapping(value = "/getProductListPage", method = RequestMethod.GET)
	public ModelAndView getProductList() {
		List<ProductDetail> productDetails = null;
		Map<String, String > products = new HashMap<>();
		ModelAndView modelAndView = new ModelAndView("GetProductList");
		productDetails = productService.getProductList();
		if(productDetails != null && !productDetails.isEmpty()){
			for (ProductDetail productDetail : productDetails) {
				products.put(productDetail.getBarCode(), productDetail.getProductDesc());
			}
		}
        modelAndView.addObject("products", products);
        modelAndView.addObject("productLoaderForm", new ProductBean());
		return modelAndView;
	}
	
	@RequestMapping(value = "/getProductDetails", method = RequestMethod.POST)
	public ModelAndView getProductDetails(@ModelAttribute("productLoaderForm") ProductBean productLoaderForm) {
		ProductBean productBean = null;
		ModelAndView modelAndView = new ModelAndView("GetProductDetails");
		
		productBean = productService.getProductDetailsByBarCode(productLoaderForm.getBarCode());
		modelAndView.addObject("productBean",productBean);
		return modelAndView;
	}
}
