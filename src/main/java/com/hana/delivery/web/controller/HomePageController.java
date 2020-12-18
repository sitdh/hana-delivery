package com.hana.delivery.web.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hana.delivery.db.model.Customer;
import com.hana.delivery.db.model.Product;
import com.hana.delivery.db.model.ProductOrder;
import com.hana.delivery.db.service.CustomerService;
import com.hana.delivery.db.service.ProductOrderService;
import com.hana.delivery.db.service.ProductService;

@Scope("session")
@SessionAttributes({"user"})
@Controller
public class HomePageController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductOrderService productOrderService;
	
	@GetMapping("/")
	public String index(ModelMap model, HttpSession session) {
		Collection<Product> products = productService.list();		
		
		Collection<Product> highlight = new ArrayList<Product>();
		int i = 0;
		for (Product p : products) {
			if (i <= 5) {
				highlight.add(p);
			} else {
				break;
			}
			
			i++;
		}

		model.addAttribute("highlightProducts", highlight);
		model.addAttribute("products", products);
		model.addAttribute("count", session.getAttribute("count"));
		
		return "index";
	}
	
	@PostMapping("/api/cart")
	@ResponseBody
	public ModelAndView updateCart(@RequestParam(name = "id") String productId, HttpSession session, ModelMap model) {
		session.getAttribute("cart");
		Optional<Product> optionalProduct = this.productService.getProductRepository().findById(new BigInteger(productId));
		
		double price = 0.0;
		if (optionalProduct.isPresent()) {
			price = optionalProduct.get().getPrice();
		}
		

		int count = 1;
		if (session.getAttribute("cart") == null) {
			session.setAttribute("cart", price);
			session.setAttribute("count", count);
		} else {
			double newPrice = Double.valueOf(String.valueOf(session.getAttribute("cart")));
			price += newPrice;
			
			count = Integer.valueOf(String.valueOf(session.getAttribute("count"))) + 1;
			
			session.setAttribute("cart", price);
			session.setAttribute("count", count);
			
		}
		
		if (null == session.getAttribute("item")) {
			session.setAttribute("item", productId);
		} else {
			String g = String.valueOf(session.getAttribute("item"));
			session.setAttribute("item", g + "," + productId);

		}

		model.putIfAbsent("count", count + 1);

		return new ModelAndView("redirect:/", model);
	}
	
	@GetMapping("/purchase")
	public String purchaseitem(HttpSession session, ModelMap model) {
		
		List<String> ids = Arrays.asList(String.valueOf(session.getAttribute("item")).split(","));
		Collection<BigInteger> idConvert = new ArrayList<BigInteger>();
		for (String i : ids) {
			idConvert.add(new BigInteger(i));
		}
		Collection<Product> products = this.productService.getProductRepository().findAllById(idConvert);
		
		double totalPrice = products.stream().mapToDouble(Product::getPrice).sum();
		
		Collection<Customer> customers = this.customerService.list();
		
		model.addAttribute("key", session.getAttribute("item"));
		model.addAttribute("count", session.getAttribute("count"));
		model.addAttribute("products", products);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("customers", customers);
		
		return "purchase";
	}
	
	@PostMapping("/checkout")
	public String checkoutItem(HttpServletRequest request,
			HttpSession session, 
			ModelMap model,
			@RequestParam("checkout_user") String checkout_id) {

			Optional<Customer> c = this.customerService.getCustomerRepository().findById(new BigInteger(checkout_id));
			if (c.isPresent()) {
				model.addAttribute("customer", c.get());
			}
			
			List<String> ids = Arrays.asList(String.valueOf(session.getAttribute("item")).split(","));
			Collection<BigInteger> idConvert = new ArrayList<BigInteger>();
			for (String i : ids) {
				idConvert.add(new BigInteger(i));
			}
			Collection<Product> products = this.productService.getProductRepository().findAllById(idConvert);

			model.addAttribute("quantity", request.getParameter("checkout"));
			model.addAttribute("products", products);

			return "checkout";
	}

	@GetMapping("/dashboard")
	public String dashboard(HttpServletRequest request, HttpSession session, ModelMap model) {
		
		model.addAttribute("number_of_customer", this.customerService.list().size());
		
		Collection<ProductOrder> productOrder = this.productOrderService.list();
		
		model.addAttribute("number_of_order", productOrder.size());
		
		OptionalDouble avgNumber = this.productOrderService.list().stream().mapToInt(ProductOrder::getItemQuantity).average();
		model.addAttribute("avg_of_item_in_order", avgNumber.orElse(0.0));
		
		Collection<Product> managedProducts = this.productService.getProductRepository().findAllProducts(JpaSort.by(Direction.DESC, "managementCost"));
		model.addAttribute("top_management_products", managedProducts);
		
		
		return "dashboard";
	}
	
}
