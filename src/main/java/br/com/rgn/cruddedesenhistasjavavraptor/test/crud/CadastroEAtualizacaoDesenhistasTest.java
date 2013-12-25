package br.com.rgn.cruddedesenhistasjavavraptor.test.crud;

import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import br.com.rgn.cruddedesenhistasjavavraptor.crud.DesenhistasCRUD;
import br.com.rgn.cruddedesenhistasjavavraptor.entity.Desenhista;

@RunWith(JUnit4.class)
public class CadastroEAtualizacaoDesenhistasTest {
	
	public static Desenhista desenhista;
	public static DesenhistasCRUD desenhistasCRUD;
	public static String nomeReal;
	
	@Before
	public void setup(){
		desenhistasCRUD = new DesenhistasCRUD();
		desenhista = new Desenhista();
		desenhista.setNome("Ful");
		desenhista.setEmail("email@dominio.com");
		desenhista.setSite("www.site.com.br");
		
		nomeReal = "Fulano";
	}
	
	@Test
	public void cadastrarDesenhista() {
		Long id = desenhistasCRUD.cadastrar(desenhista);
		assertEquals( (id > 0), true );
	}
	
	@Test
	public void atualizarDesenhista(){
		desenhista = desenhistasCRUD.consultar(desenhista);
		String apelido = desenhista.getNome();
		desenhista.setNome(nomeReal);
		desenhistasCRUD.atualizar(apelido, desenhista);
		Desenhista desenhistaConsultado = desenhistasCRUD.consultar(desenhista);
		Assert.assertNotEquals(apelido, desenhistaConsultado.getNome());
	}
}
