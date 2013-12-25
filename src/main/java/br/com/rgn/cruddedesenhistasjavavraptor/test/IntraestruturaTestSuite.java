package br.com.rgn.cruddedesenhistasjavavraptor.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import br.com.rgn.cruddedesenhistasjavavraptor.test.crud.CadastroEAtualizacaoDesenhistasTest;
import br.com.rgn.cruddedesenhistasjavavraptor.test.crud.ConsultaDesenhistasTest;
import br.com.rgn.cruddedesenhistasjavavraptor.test.crud.RemocaoDesenhistasTest;

@RunWith(Suite.class)
@SuiteClasses({
		CadastroEAtualizacaoDesenhistasTest.class, ConsultaDesenhistasTest.class, RemocaoDesenhistasTest.class
})
public class IntraestruturaTestSuite {

}