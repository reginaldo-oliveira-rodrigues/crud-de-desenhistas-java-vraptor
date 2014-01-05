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
	
	public DesenhistasController(Result result){
	}
	
	public List<Desenhista> listar(){
		List<Desenhista> desenhistas = new ArrayList<Desenhista>(); 
		try{
			desenhistas = desenhistasCRUD.listar();
		}catch(NullPointerException nulo){
			
		}
		return desenhistas;
	}
	
	public void cadastro(){
        System.out.println("Cadastro de desenhistas em desenvolvimento!");
    }
	
}