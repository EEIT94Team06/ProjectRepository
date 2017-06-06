package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.engine.internal.CacheHelper;

@Entity
@Table(name="Class")
public class ClassVO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int class_sd;
	private String class_name;
	private String class_intro;
	@ManyToOne
	@JoinColumn(name="class_level")
	private Class_PriceRangeVO class_PriceRange;//注意hibernate命名會與DB欄位搞混
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="class_sd")
	private List<Class_OrderVO> class_orders;
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="class_sd")
	private List<Profe_ClassVO> profe_classes;
	
	
	@Override
	public String toString() {
		return "ClassVO [class_sd=" + class_sd + ", class_name=" + class_name + ", class_intro=" + class_intro
				+ ", class_PriceRange=" + class_PriceRange +  "]";
	}
	public int getClass_sd() {
		return class_sd;
	}
	public void setClass_sd(int class_sd) {
		this.class_sd = class_sd;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getClass_intro() {
		return class_intro;
	}
	public void setClass_intro(String class_intro) {
		this.class_intro = class_intro;
	}
	public Class_PriceRangeVO getClass_PriceRange() {
		return class_PriceRange;
	}
	public void setClass_PriceRange(Class_PriceRangeVO class_PriceRange) {
		this.class_PriceRange = class_PriceRange;
	}
	public List<Class_OrderVO> getClass_orders() {
		return class_orders;
	}
	public void setClass_orders(List<Class_OrderVO> class_orders) {
		this.class_orders = class_orders;
	}
	public List<Profe_ClassVO> getProfe_classes() {
		return profe_classes;
	}
	public void setProfe_classes(List<Profe_ClassVO> profe_classes) {
		this.profe_classes = profe_classes;
	}
	
	
}
