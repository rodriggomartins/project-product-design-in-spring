package api.products.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.products.dto.ProductRecordDto;
import api.products.models.ProductModel;
import api.products.services.ProductServices;




@RestController
@RequestMapping("/produtos")
public class ProductController {

	// injecao de dependencia
	// quando quiser pegar as coisas do repository
	@Autowired
	private ProductServices productServices;	

	@GetMapping("/lista")
	public String getProduto(){
		return "Ola Mundo";
	}

	@PostMapping("cadastrar")
	public ResponseEntity<ProductModel>saveProduct(@RequestBody ProductRecordDto productRecordDto){
		var userId = productServices.saveProduct(productRecordDto);
		// aqui vai falar o id no retorno la no header
		return ResponseEntity.created(URI.create("/produtos/list/" + userId.toString())).build();
	}

	@GetMapping("/produtoid{idproducts}")
	public ResponseEntity<ProductModel>productId(@PathVariable("idproducts") String idproducts){
		var product = productServices.productId(idproducts);
		// aqui poderia fazer um if e else
		return product.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());


		/*
			if(produc.isPresent()){
				return RespondeEntity.ok(product.get());
			}else{
				return RespondeEntity.notFound().build();
			}
		*/
	}



}
