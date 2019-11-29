 package mvc;

import jdbc.CarroDAO;
import mvc.control.CadastroCarroControl;
import mvc.model.CarroModel;
import mvc.view.CadastroCarroView;

public class Main {

	public static void main(String[] args) {
		CarroModel p = new CarroModel();
		p.setMarca("Fiat");
		p.setModelo("Marea Turbo");
		p.setCor("Roxo");
		p.setAnomodelo(2007);;
		
		CadastroCarroControl control = new CadastroCarroControl(new CadastroCarroView(),p);
		control.exibirTela();

	}

}
// Dedicatória aos indianos do youtube por fazer esse trabalho acontecer.
 // Durga Software Solutions
 // www.youtube.com/channel/UCbjozK_PYCTLEluFlrJ8UZg