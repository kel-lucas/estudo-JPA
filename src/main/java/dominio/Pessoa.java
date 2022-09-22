package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*Indica que a classe também é uma Entidade.*/
@Entity
public class Pessoa implements Serializable{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	/* Indica que o seguinte campo/atributo é a Primary Key da Entidade */
	@Id
	/*
	 * Informa ao provedor de persitência (no caso, Hibernate) que a Primary Key
	 * será gerenciada por ele. A strategy adotada é provedor de persistência que os
	 * valores a serem atribuídos ao identificador único serão gerados pela coluna
	 * de auto incremento do banco de dados. Assim, um valor para o identificador é
	 * gerado para cada registro inserido no banco.
	 */
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	private String name;
	private String email;
	
	public Pessoa() {
		
	}

	public Pessoa(Integer id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	

}
