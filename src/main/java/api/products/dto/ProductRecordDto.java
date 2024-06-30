package api.products.dto;

import java.math.BigDecimal;


// aqui vem os campos do meu model, e cada um com seu tipo, so nao o id
// eles tem os valore imutaveis, uma vez criado nao se pode mudar os valores
// por isso eles nao tem os metodos set, somente o get
public record ProductRecordDto(String name, BigDecimal price, int code) {
}
