package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		/*
		 * Um objeto EntityManagerFactory é utilizado para instanciar objetos
		 * EntityManager.
		 * 
		 * Escopo: tipicamente mantem-se uma instância única de EntityManagerFactory
		 * para toda aplicação.
		 * 
		 * É passada como argumento a unidade de persistência configarado no arquivo persistence.xml
		 */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		
		
		/*
		 * Um objeto EntityManager encapsula uma conexão com a base de dados e serve
		 * para efetuar operações de acesso a dados (inserção, remoção, deleção,
		 * atualização) em entidades (clientes, produtos, pedidos, etc.) por ele
		 * monitoradas em um mesmo contexto de persistência.
		 * 
		 * Escopo: tipicamente mantem-se uma instância única de EntityManager para cada
		 * thread do sistema (no caso de aplicações web, para cada requisição ao
		 * sistema).
		 */
		EntityManager em = emf.createEntityManager();
		
		/*
		 * Toda e qualquer alteração de uma entidade (find() não se insere nesse caso) é
		 * uma transação e como tal, deve ser iniciada e comitada como abaixo
		 */		
		Pessoa p = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println("Pronto!");
		em.close();
		emf.close();
		
		
	}

}
