package br.com.rgn.cruddedesenhistasjavavraptor;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.rgn.cruddedesenhistasjavavraptor.crud.DesenhistasCRUD;
import br.com.rgn.cruddedesenhistasjavavraptor.entity.Desenhista;

@Resource
public class DesenhistasController {
	private DesenhistasCRUD desenhistasCRUD;
	private Result result;
	public DesenhistasController(Result result){
		this.result = result;
	}
	
	public void listar(){
		List<Desenhista> desenhistas = new ArrayList<Desenhista>(); 
		try{
			desenhistas = desenhistasCRUD.listar();
		}catch(NullPointerException nulo){
			desenhistas =  criarDesenhistas_Provisorio();
		}
		result.include("desenhistas", desenhistas);
	}
	
	public void cadastro(){
        System.out.println("Cadastro de desenhistas em desenvolvimento!");
    }
	
	private List<Desenhista> criarDesenhistas_Provisorio() {
		List<Desenhista> desenhistas = new ArrayList<Desenhista>();
		Desenhista desenhista = new Desenhista();
		desenhista.setNome("Bleck");
		desenhista.setEmail("bleck@desenhoc.com.br");
		desenhistas.add(desenhista);
		desenhista = new Desenhista();
		desenhista.setNome("Drock");
		desenhista.setEmail("drock@desenhoc.com.br");
		desenhistas.add(desenhista);
		return desenhistas;
	}
	
}