package mvc.control;

import mvc.model.CarroModel;
import mvc.view.CadastroCarroView;

public class CadastroCarroControl {
	
	private CadastroCarroView view;
	private CarroModel model;
	
	public CadastroCarroControl(CadastroCarroView view, CarroModel model) {
		this.view = view;
		this.model = model;
		model.attach(view);
		view.setModel(model);
		view.setControl(this);
	}
	
	public void exibirTela() {
		view.show();
		model.notifyObservers();
	}

	public void deletar() {
		model.deletar();
		view.setMensagemStatusBar("Registro apagado.");
		view.getBotaoDeletar().setEnabled(false);
	}

	public void novo() {
		model.novoRegistro();
		view.getBotaoDeletar().setEnabled(false);
		view.setMensagemStatusBar("Registro criado.");
	}
	
	public void salvar() {
		model.setMarca(view.getMarca());
		model.setModelo(view.getModelo());
		model.setCor(view.getCor());
		model.setAnomodelo(view.getAnomodelo());
		// model.setChassi(view.getChassi());

		try {
			model.salvar();
			view.setMensagemStatusBar("Salvo com sucesso.");
			view.getBotaoDeletar().setEnabled(true);
		}catch(Exception e) {
			e.printStackTrace();
			view.setMensagemStatusBar("Falha: "+e.getMessage());
		}
	}

}
