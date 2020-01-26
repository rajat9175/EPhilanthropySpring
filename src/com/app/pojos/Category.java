package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category 
{
  private Integer categoryId; //p.k
  private String categoryName;
  public Category() 
  {
	super();
  }
public Category(Integer categoryId, String categoryName) {
	super();
	this.categoryId = categoryId;
	this.categoryName = categoryName;
	
}
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer getCategoryId() {
	return categoryId;
}
public void setCategoryId(Integer categoryId) {
	this.categoryId = categoryId;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
 
}
