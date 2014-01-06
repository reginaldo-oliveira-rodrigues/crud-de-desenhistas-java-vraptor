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
	
	public Desenhista editar(Long id){
		Desenhista desenhista = new Desenhista();
		desenhista.setId(id);
		return desenhistasCRUD.consultar(desenhista);
    }
	
	public void atualizar(Desenhista desenhista){
		desenhistasCRUD.atualizar(desenhista);
	    result.redirectTo(this).listar();
    }
	
	public void remover(Long id){
		Desenhista desenhista = new Desenhista();
		desenhista.setId(id);
		desenhistasCRUD.remover(desenhista);
		result.redirectTo(this).listar();
	}
	
}