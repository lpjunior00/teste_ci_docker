package br.com.junior.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="cambio")
public class Cambio implements Serializable {
	
	private static final long serialVersionUID = 3424358703880813759L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="from_currency", nullable = false, length = 3)
	private String from;
	
	@Column(name="to_currency", nullable = false, length = 3)
	private String to;
	
	@Column(nullable = false)
	private BigDecimal conversion_factor;
	
	@Transient
	private BigDecimal convertion_value;
	
	@Transient
	private String enviroment;
	
	public Cambio(Long id, String from, String to, BigDecimal conversion_factor, BigDecimal convertion_value,
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

	public BigDecimal getConversion_factor() {
		return conversion_factor;
	}

	public void setConversion_factor(BigDecimal convertion_factor) {
		this.conversion_factor = convertion_factor;
	}

	public BigDecimal getConvertion_value() {
		return convertion_value;
	}

	public void setConvertion_value(BigDecimal convertion_value) {
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
