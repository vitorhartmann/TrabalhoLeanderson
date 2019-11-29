package mvc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mvc.control.CadastroCarroControl;
import mvc.model.CarroModel;
import mvc.util.Observer;
import mvc.util.Subject;

public class CadastroCarroView extends JFrame implements Observer{

	private CarroModel model;
	private CadastroCarroControl control;
	
	private JTextField codigoTextField;
	private JTextField marcaTextField;
	private JTextField modeloTextField;
	private JTextField corTextField;
	private JTextField anomodeloTextField;
	private JButton    salvarButton;
	private JButton    cancelarButton;
	private JButton    novoButton;
	private JButton    deletarButton;
	private JLabel statusLabel;
	
	public CadastroCarroView() {
		// Titulo Janela
		setTitle("Cadastro de Veiculos");
		// Tamanho Janela
		setSize(400,280);
		// Configura local inicial
		setLocation(1366/2 -400/2, 768/2 - 280/2);
		// N�o permite modificar o tamanho da Tela
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildLayout();
	}
	
	public void setModel(CarroModel model) {
		this.model = model;
	}
	
	public void setControl(CadastroCarroControl control) {
		this.control = control;
	}

	private void buildLayout() {
		JPanel root = new JPanel();
		root.setLayout(new BorderLayout());
		
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.setBorder(BorderFactory.createCompoundBorder(
				
				  BorderFactory.createEmptyBorder(20, 20, 0, 20)
				, BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Detalhes do Carro")
						,BorderFactory.createEmptyBorder(10, 10, 10, 10))));

		codigoTextField = new JTextField(20);
		codigoTextField.setEnabled(false);
		marcaTextField = new JTextField(20);
		modeloTextField = new JTextField(20);
		corTextField = new JTextField(20);
		anomodeloTextField = new JTextField(20);
		
		salvarButton = new JButton("Salvar");
		salvarButton.setToolTipText("Salvar as alteracoes");
		salvarButton.addActionListener(e -> salvar());
		
		cancelarButton = new JButton("Cancelar");
		novoButton = new JButton("Novo");
		novoButton.setToolTipText("Criar novo registro");
		novoButton.addActionListener(e -> novo());
		deletarButton = new JButton("Deletar");
		deletarButton.setToolTipText("Excluir registro");
		deletarButton.setEnabled(true);
		deletarButton.addActionListener(e -> deletar());
		
		
		JLabel l = new JLabel("ID",JLabel.RIGHT);
		l.setPreferredSize(new Dimension(70,16));
		panel.add(l);
		panel.add(codigoTextField);
		
		l = new JLabel("Marca",JLabel.RIGHT);
		l.setPreferredSize(new Dimension(70,16));
		panel.add(l);
		panel.add(marcaTextField);

		l = new JLabel("Modelo",JLabel.RIGHT);
		l.setPreferredSize(new Dimension(70,16));
		panel.add(l);
		panel.add(modeloTextField);

		l = new JLabel("Ano/Modelo",JLabel.RIGHT);
		l.setPreferredSize(new Dimension(70,16));
		panel.add(l);
		panel.add(anomodeloTextField);

		l = new JLabel("Cor",JLabel.RIGHT);
		l.setPreferredSize(new Dimension(70,16));
		panel.add(l);
		panel.add(corTextField);

	//	l = new JLabel("Chassi",JLabel.RIGHT);
	//	l.setPreferredSize(new Dimension(70,16));
	//	panel.add(l);
	//	panel.add(chassiTextField);


		l = new JLabel();
		l.setPreferredSize(new Dimension(70,16));
		panel.add(l);

		panel.add(novoButton);
		panel.add(salvarButton);
		panel.add(deletarButton);
		
		JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		statusPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10));
		statusLabel = new JLabel("Bem vindo(a) ao cadastramento de veiculo");
		statusPanel.add(statusLabel);
		
		
		root.add(statusPanel,BorderLayout.SOUTH);
		root.add(panel,BorderLayout.CENTER);
		
		add(root);
	}
	
	private void exibirDados() {
		codigoTextField.setText(Long.toString(model.getId()));
		marcaTextField.setText(model.getMarca());		
		modeloTextField.setText(model.getModelo());
		corTextField.setText(model.getCor());
		anomodeloTextField.setText(Long.toString(model.getAnomodelo()));
		
	}
	
	
	private void salvar() {
		control.salvar();
	}
	
	private void deletar() {
		control.deletar();
	}
	
	private void novo() {
		control.novo();
	}

	public JButton getBotaoDeletar() {
		return deletarButton;
	}

	public void setMensagemStatusBar(String text) {
		statusLabel.setText(text);
	}

	@Override
	public void update(Subject s, Object o) {
		model = (CarroModel) o;
		exibirDados();
	}
	
	public String getMarca() {
		return marcaTextField.getText();
	}
	
	public String getModelo() {
		return modeloTextField.getText();
	}
	
	public String getCor() {
		return corTextField.getText();
	}
	
	
	// Como converter texto para n�mero
	public int getAnomodelo() {
		// return anomodeloTextField.getText();
		return Integer.parseInt(anomodeloTextField.getText());
	}
	
}
