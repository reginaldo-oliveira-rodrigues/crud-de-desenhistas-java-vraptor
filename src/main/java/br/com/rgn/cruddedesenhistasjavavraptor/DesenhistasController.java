package br.com.rgn.cruddedesenhistasjavavraptor;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;
import br.com.rgn.cruddedesenhistasjavavraptor.crud.DesenhistasCRUD;
import br.com.rgn.cruddedesenhistasjavavraptor.entity.Desenhista;

@Resource
public class DesenhistasController {
	private DesenhistasCRUD desenhistasCRUD;
	private final Result result;
	private Validator validador;

	public DesenhistasController(DesenhistasCRUD desenhistasCRUD,
			Result result, Validator validador) {
		this.desenhistasCRUD = desenhistasCRUD;
		this.result = result;
		this.validador = validador;
	}

	@Get("/desenhistas")
	public List<Desenhista> listar() {
		return desenhistasCRUD.listar();
	}
	
	@Get("/desenhista/novo")
	public void formulario() { /* isso eh soh pra direcionar para formulario.jsp */ }

	@Post("/desenhistas")
	public void adiciona(final Desenhista desenhista) {
		validar(desenhista);
		validador.onErrorUsePageOf(this).formulario();
		desenhistasCRUD.cadastrar(desenhista);
		result.redirectTo(this).listar();
	}

	private void validar(final Desenhista desenhista) {
		validador.checking(new Validations() {
			{
				that(desenhista.getNome() != null
						&& desenhista.getNome().length() >= 3, 
						"desenhista.nome",
						"nome.obrigatorio"
				);
				
				that(desenhista.getEmail() != null
						&& desenhista.getEmail().length() >= 6
						&& desenhista.getEmail().contains("@"),
						"desenhista.email", 
						"email.obrigatorioevalido"
				);
				
				that(desenhista.getSite() != null 
						&& desenhista.getSite().contains("."),
						"desenhista.site", 
						"site.obrigatorio"
				);
			}
		});
	}
	
	@Get("/desenhista/{id}")
	public Desenhista editar(Long id) {
		Desenhista desenhista = new Desenhista();
		desenhista.setId(id);
		return desenhistasCRUD.consultar(desenhista);
	}

	@Put("/desenhista/{desenhista.id}")
	public void atualizar(Desenhista desenhista) {
		validar(desenhista);
		validador.onErrorUsePageOf(this).formulario();
		desenhistasCRUD.atualizar(desenhista);
		result.redirectTo(this).listar();
	}

	@Delete("/desenhista/{id}")
	public void remover(Long id) {
		Desenhista desenhista = new Desenhista();
		desenhista.setId(id);
		desenhistasCRUD.remover(desenhista);
		result.redirectTo(this).listar();
	}

}