package br.com.rgn.cruddedesenhistasjavavraptor;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.rgn.cruddedesenhistasjavavraptor.crud.DesenhistasCRUD;
import br.com.rgn.cruddedesenhistasjavavraptor.entity.Desenhista;

@Resource
public class DesenhistasController {
	private DesenhistasCRUD desenhistasCRUD;
	
	public List<Desenhista> listar(){
		return desenhistasCRUD.listarTodos();
	}
	
	public void cadastro(){
        System.out.println("Cadastro de desenhistas em desenvolvimento!");
    }
}