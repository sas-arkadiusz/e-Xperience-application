package pl.arkadiuszsas.eXperience.repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Class contains values to describe the requested latest modified repository.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryInfo {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
