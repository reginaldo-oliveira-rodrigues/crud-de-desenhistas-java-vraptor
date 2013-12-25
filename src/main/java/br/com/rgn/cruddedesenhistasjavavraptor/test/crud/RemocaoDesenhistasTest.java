package br.com.rgn.cruddedesenhistasjavavraptor.test.crud;

import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import br.com.rgn.cruddedesenhistasjavavraptor.crud.DesenhistasCRUD;
import br.com.rgn.cruddedesenhistasjavavraptor.entity.Desenhista;

public class RemocaoDesenhistasTest {
	
	public static Desenhista desenhista;
	public static DesenhistasCRUD desenhistasCRUD;
	
	@Before
	public void setup(){
		desenhistasCRUD = new DesenhistasCRUD();
		desenhista = new Desenhista();
		desenhista.setNome("Fulano");
	}
	
	@Test
	public void removerDesenhista(){
		desenhista = desenhistasCRUD.consultar(desenhista);
		desenhistasCRUD.remover(desenhista);
		assertNull(desenhistasCRUD.consultar(desenhista));
	}
}