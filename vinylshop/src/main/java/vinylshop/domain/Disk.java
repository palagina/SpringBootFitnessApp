package vinylshop.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Disk {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private String author;
	private int year;
	private String code;

	private double price;

	 @ManyToOne
	 @JsonIgnore
	 @JoinColumn(name = "categoryid")
	    private Category category;
	
	public Disk () {}
	
public Disk(String name, String author, int year, String code, double price, Category category) {
	super();
	this.name = name;
	this.author = author;
	this.year = year;
	this.code = code;
	this.price = price;
	this.category = category;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public int getYear() {
	return year;
}

public void setYear(int year) {
	this.year = year;
}

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public Category getCategory() {
	return category;
}

public void setCategory(Category category) {
	this.category = category;
}

	@Override
	public String toString() {
		if (this.category != null)
			return "Disk [id=" + id + ", Name=" + name + ", Author=" + author + ", Year=" + year + 
					", Code=" + code + ", Price=" + price + " Category =" + this.getCategory() + "]";		
		else
			return "Disk [id=" + id + ", Name=" + name + ", Author=" + author + ", Year=" + year + 
					", Code=" + code + ", Price=" + price + "]";	
	}
}