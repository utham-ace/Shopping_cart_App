package com.ecom.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.model.Product;

public interface ProductService {
	public Product saveProduct(Product product);
	
	public List<Product> getAllProducts();
	
	public Boolean deleteProduct(Integer id);
	
	public Product getProductById(Integer id);
	
	public Product updateProduct(Product product,MultipartFile file);
	
	public List<Product> getAllActiveProducts(String category);
	
	public List<Product> searchProduct(String ch);
	
	public Page<Product> getAllActiveProductPagenation(Integer pageNo,Integer pageSize,String category);
	
	public Page<Product> searchProductPagenation(Integer pageNo,Integer pageSize,String ch);
	
	public Page<Product> getAllProductsPagenation(Integer pageNo,Integer pageSize);

	public Page<Product> searchActiveProductPagination(Integer pageNo, Integer pageSize,String category,String ch);
}
