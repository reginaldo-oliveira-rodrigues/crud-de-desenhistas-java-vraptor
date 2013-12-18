package br.com.rgn.cruddedesenhistasjavavraptor.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.rgn.cruddedesenhistasjavavraptor.crud.DesenhistasCRUD;
import br.com.rgn.cruddedesenhistasjavavraptor.entity.Desenhista;

public class DesenhistasRemoverTest {
	
	@Test
	public void removerDesenhista(){
		DesenhistasCRUD desenhistasCRUD = new DesenhistasCRUD();
		
		Desenhista desenhista = new Desenhista();
		desenhista.setNome("Reginaldo");
		desenhista = desenhistasCRUD.consultar(desenhista);
		
		desenhistasCRUD.remover(desenhista);
		Assert.assertNull(desenhistasCRUD.consultar(desenhista));
	}
}
