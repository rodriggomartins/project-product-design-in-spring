package api.products.models;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;




@Entity 
@Table(name = "products")
public class ProductModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "idProducts")
  private UUID idProducts;

  @Column(name = "name", nullable = false, unique = true)
  private String name;
  
  @Column(name = "price", nullable = false)
  private BigDecimal price;

  @Column(name = "code", nullable = false, unique = true)
  private int code;

  @CreationTimestamp
  @Column(name = "createdAt")
  private Instant createdAt;

  @UpdateTimestamp
  @Column(name = "updatedAt")
  private Instant updatedAt;


  public ProductModel(){
    
  }

  public ProductModel(UUID idProducts, String name, BigDecimal price, int code, Instant createdAt, Instant updatedAt){
    this.idProducts = idProducts;
    this.name = name;
    this.price = price;
    this.code = code;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }
  

   public void setUuid(UUID idProdutcs){
    this.idProducts = idProdutcs;
  }

  public UUID getUuid(){
    return idProducts;
  }  

  public void setName(String name){
    this.name = name;
  }

  public String getName(){
    return name;
  }

  public void setPrice(BigDecimal price){
    this.price = price;
  }

  public BigDecimal getPrice(){
    return price;
  }

  public void setCode(int code){
    this.code = code;
  }

  public int getCode(){
    return code;
  }


  public void setCreated(Instant createdAt){
	  this.createdAt = createdAt;
  }

  public Instant getCreatedAt(){
	  return createdAt;
  }

  public void setUpdatedAt(Instant updatedAt){
	  this.updatedAt = updatedAt;
  }

  public Instant getUpdatedAt(){
	  return updatedAt;
  }


}
