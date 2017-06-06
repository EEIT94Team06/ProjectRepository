package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Class_PriceRange")
public class Class_PriceRangeVO {
	@Id
	private String class_level;
	private int class_price;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="class_level")
	private List<ClassVO> classes;
	
	
	@Override
	public String toString() {
		return "Class_PriceRangeVO [class_level=" + class_level + ", class_price=" + class_price +  "]";
	}
	public List<ClassVO> getClasses() {
		return classes;
	}
	public void setClasses(List<ClassVO> classes) {
		this.classes = classes;
	}
	public String getClass_level() {
		return class_level;
	}
	public void setClass_level(String class_level) {
		this.class_level = class_level;
	}
	public int getClass_price() {
		return class_price;
	}
	public void setClass_price(int class_price) {
		this.class_price = class_price;
	}
}
