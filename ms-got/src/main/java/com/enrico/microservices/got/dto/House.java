package com.enrico.microservices.got.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Represents a a family house within the Game of Thrones fantasy world")
@JsonInclude(Include.NON_NULL)
public class House extends ResourceSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min = 1, max = 100)
	@JsonProperty(value = "name")
	@Pattern(regexp = "[a-zA-Z0-9\\s]+")
	@ApiModelProperty(notes = "The name of the house", required = true, allowEmptyValue = false, example = "Lannister")
	private String name;
	
	@JsonCreator
	public House(@JsonProperty("name") String name) {
		super();
		this.name = name;
	}

	public House withLink(Link link) {
		this.add(link);
		return this;
	}
	
	public House withLink(String href, String rel) {
		add(new Link(href, rel));
		return this;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}