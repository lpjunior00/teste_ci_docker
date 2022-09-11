package br.com.junior.response;

import java.io.Serializable;
import java.util.Objects;

public class Cambio implements Serializable {
	
	private static final long serialVersionUID = 3424358703880813759L;
	
	private Long id;
	private String from;
	private String to;
	private Double conversion_factor;
	private Double convertion_value;
	private String enviroment;
	
	public Cambio(Long id, String from, String to, Double conversion_factor, Double convertion_value,
			String enviroment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversion_factor = conversion_factor;
		this.convertion_value = convertion_value;
		this.enviroment = enviroment;
	}

	public Cambio() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Double getConversion_factor() {
		return conversion_factor;
	}

	public void setConversion_factor(Double convertion_factor) {
		this.conversion_factor = convertion_factor;
	}

	public Double getConvertion_value() {
		return convertion_value;
	}

	public void setConvertion_value(Double convertion_value) {
		this.convertion_value = convertion_value;
	}

	public String getEnviroment() {
		return enviroment;
	}

	public void setEnviroment(String enviroment) {
		this.enviroment = enviroment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conversion_factor, conversion_factor, enviroment, from, id, to);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cambio other = (Cambio) obj;
		return Objects.equals(conversion_factor, other.conversion_factor)
				&& Objects.equals(convertion_value, other.convertion_value)
				&& Objects.equals(enviroment, other.enviroment) && Objects.equals(from, other.from)
				&& Objects.equals(id, other.id) && Objects.equals(to, other.to);
	}

	
}
