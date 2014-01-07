package br.com.rgn.cruddedesenhistasjavavraptor.test.crud;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.rgn.cruddedesenhistasjavavraptor.crud.DesenhistasCRUD;
import br.com.rgn.cruddedesenhistasjavavraptor.entity.Desenhista;

public class ConsultaDesenhistasTest {
	
	public static DesenhistasCRUD desenhistasCRUD;
	public static Desenhista desenhista;
	
	@Before
	public void setup(){
		desenhistasCRUD = CriadorDeDesenhistasCRUD.criar();
		desenhista = new Desenhista();
		desenhista.setNome("Fu");
		desenhista.setEmail("em");
	}
	
	@Test
	public void listarTodosDesenhistas(){
		List<Desenhista> desenhistas = desenhistasCRUD.listar();
		assertEquals((desenhistas.size() > 0), true );
	}
	
	@Test
	public void consultarDesenhista() {
		desenhista = desenhistasCRUD.consultar(desenhista);
		System.out.println("\nDesenhista selecionado\n" + desenhista + "\n");
		assertEquals( (desenhista.getId() > 0), true );
	}
}
