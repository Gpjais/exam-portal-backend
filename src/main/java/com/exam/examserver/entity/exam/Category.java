package com.exam.examserver.entity.exam;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;

	private String title;

	private String desccription;
	
	// one category can have many Quizes
	//Linked hashset because order of insertion will be maintined
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Quiz> quizes=new LinkedHashSet<>();
	
	
	public Set<Quiz> getQuizes() {
		return quizes;
	}

	public void setQuizes(Set<Quiz> quizes) {
		this.quizes = quizes;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesccription() {
		return desccription;
	}

	public void setDesccription(String desccription) {
		this.desccription = desccription;
	}

	public Category(String title, String desccription) {
		super();
		this.title = title;
		this.desccription = desccription;
	}

	public Category(int cid, String title, String desccription) {
		super();
		this.cid = cid;
		this.title = title;
		this.desccription = desccription;
	}

	public Category() {
		super();
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", title=" + title + ", desccription=" + desccription + "]";
	}

}
