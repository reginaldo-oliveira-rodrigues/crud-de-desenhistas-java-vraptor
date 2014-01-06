package br.com.rgn.cruddedesenhistasjavavraptor;


import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.rgn.cruddedesenhistasjavavraptor.crud.DesenhistasCRUD;
import br.com.rgn.cruddedesenhistasjavavraptor.entity.Desenhista;

@Resource
public class DesenhistasController {
	private DesenhistasCRUD desenhistasCRUD;
	private final Result result;
	
	public DesenhistasController(DesenhistasCRUD desenhistasCRUD, Result result){
		this.desenhistasCRUD = desenhistasCRUD;
		this.result = result;
	}
	
	public List<Desenhista> listar(){
		return desenhistasCRUD.listar();
	}
	
	public void formulario(){ /* isso eh soh pra direcionar para formulario.jsp */ }
	
	public void adiciona(Desenhista desenhista){
		desenhistasCRUD.cadastrar(desenhista);
	    result.redirectTo(this).listar();
    }
}