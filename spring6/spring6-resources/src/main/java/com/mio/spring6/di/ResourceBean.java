package com.mio.spring6.di;

import org.springframework.core.io.Resource;

public class ResourceBean {
	
	private Resource resource;
	
	//输出方法
	public void parse() {
		System.out.println(resource.getDescription());
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}
}
