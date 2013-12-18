package br.com.rgn.cruddedesenhistasjavavraptor.test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.com.rgn.cruddedesenhistasjavavraptor.crud.DesenhistasCRUD;
import br.com.rgn.cruddedesenhistasjavavraptor.entity.Desenhista;

@RunWith(JUnit4.class)
public class DesenhistasCRUDTest {
	
	public static Desenhista desenhistaCadastrado;
	public static Desenhista desenhistaConsultado;
	public static Desenhista desenhistaRemovido;
	public static DesenhistasCRUD desenhistasCRUD;
	public static String nomeReal;
	
	@Before
	public void setup(){
		desenhistasCRUD = new DesenhistasCRUD();
		
		desenhistaCadastrado = new Desenhista();
		desenhistaCadastrado.setNome("Regis");
		desenhistaCadastrado.setEmail("email@dominio.com");
		desenhistaCadastrado.setSite("www.site.com.br");
		
		nomeReal = "Reginaldo";
		
		desenhistaConsultado = new Desenhista();
		desenhistaConsultado.setNome("egi");
		desenhistaConsultado.setEmail("em");
		
		desenhistaRemovido = new Desenhista();
	}
	
	@Test
	public void cadastrarDesenhista() {
		Long id = desenhistasCRUD.cadastrar(desenhistaCadastrado);
		assertEquals( (id > 0), true );
		
	}
	
	@Test
	public void atualizarDesenhista(){
		desenhistaCadastrado = desenhistasCRUD.consultar(desenhistaCadastrado);
		String apelido = desenhistaCadastrado.getNome();
		desenhistaCadastrado.setNome(nomeReal);
		desenhistasCRUD.atualizar(apelido, desenhistaCadastrado);
		desenhistaCadastrado = desenhistasCRUD.consultar(desenhistaCadastrado);
		Assert.assertNotEquals(apelido, desenhistaCadastrado.getNome());
	}

	/**
	 * Este método de teste consulta um desenhista mas imediatamente remove-o para o teste seguinte, checarDesenhistaRemovido.
	 */
	@Test
	public void consultarDesenhista() {
		desenhistaConsultado = desenhistasCRUD.consultar(desenhistaCadastrado);
		System.out.println("\nDesenhista selecionado\n" + desenhistaConsultado + "\n");
		assertEquals( desenhistaConsultado.getNome().trim().equals(desenhistaCadastrado.getNome().trim()), true );
	}

}
