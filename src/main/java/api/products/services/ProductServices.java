package api.products.services;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import api.products.dto.ProductRecordDto;
import api.products.models.ProductModel;
import api.products.repository.ProductRepository;

@Service
public class ProductServices {
	@Autowired
	private ProductRepository productRepository;

	/*
	Obs: quando eu nao fizer injecao de dependencias
	eu preciso colocar um construtor
	como ta abaixo
 	public ProductServices(ProductRepository productRepository){
		this.productRepository = productRepository;
	}*/

	// saveProduct meu metodo(method) ta vindo do controller, la da rota de criar produtos
	public UUID saveProduct(ProductRecordDto productRecordDto){
		var model = new ProductModel(
			UUID.randomUUID(), 
			productRecordDto.name(), 
			productRecordDto.price(), 
			productRecordDto.code(), 
			Instant.now(),
			null 
		);

	// aqui tenho que criar uma rota para buscar todos
	// com esse metodo searchAll
		var productSave = productRepository.save(model);
		return productSave.getUuid();
	}





	public Optional<ProductModel>productId(String idproducts){
		// convertendo uuid para string.
		// o optional, pq o findbyid retorna um booleano true or false
		return productRepository.findById(UUID.fromString(idproducts));
	}
	
			
}
