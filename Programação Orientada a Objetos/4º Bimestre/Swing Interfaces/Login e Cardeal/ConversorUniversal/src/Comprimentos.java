import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Comprimentos extends JPanel {
	
	public Comprimentos() {
		
		setLayout();
		
	}
	
	private void setLayout() {
		
		// In�cio Bloco JComboBox Comprimento Origem
		setLayout(null);
				String nomecomprimentosorigem [] = {"quil�metro","metro","cent�metro","mil�metro"};
						
				JComboBox<String> comboBoxOrigem = new JComboBox<String>(nomecomprimentosorigem);
				comboBoxOrigem.setBounds(80, 65, 100, 30);
				// comboBoxOrigem.setSelectedIndex(-1);
								
				// Fim Bloco JComboBox Comprimento Origem  
				
				// In�cio Bloco JComboBox Comprimento Destino
						
				String nomecomprimentosdestino [] = {"quil�metro","metro","cent�metro","mil�metro"};
						
				JComboBox<String> comboBoxDestino = new JComboBox<String>(nomecomprimentosdestino);
				comboBoxDestino.setBounds(300, 65, 100, 30);
				// comboBoxDestino.setSelectedIndex(-1);
									
				// Fim Bloco JComboBox Comprimento Destino 
				
				JLabel lblorigem = new JLabel("De: ");
				lblorigem.setForeground(Color.BLACK);
				lblorigem.setBounds(35, 65, 80, 30);
				
				JTextField txtorigem = new JTextField(200);
				txtorigem.setBounds(80, 125, 100, 30);
				  
				JLabel lbldestino = new JLabel("Para: ");
				lbldestino.setForeground(Color.BLACK);
				lbldestino.setBounds(245, 65, 80, 30);
				
				JTextField txtdestino = new JTextField(200);
				txtdestino.setBounds(300, 125, 100, 30);
				txtdestino.setEditable(false);
							
				JButton bttnconverter = new JButton("Converter!!");
				bttnconverter.setBounds(300, 185, 100, 30);
				
				// A��o do Bot�o Converter
				
				bttnconverter.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String moedade = (String) comboBoxOrigem.getSelectedItem();
						String moedapara = (String) comboBoxDestino.getSelectedItem();
						
						double valorde = Double.parseDouble(txtorigem.getText());
						double valorpara = 0;
							
						if(moedade.equals("quil�metro")&& moedapara.equals("metro")) {
							valorpara = valorde * 1000;
						}
						
						if(moedade.equals("metro")&& moedapara.equals("quil�metro")) {
							valorpara = valorde / 1000;
						}
						
						if(moedade.equals("quil�metro")&& moedapara.equals("cent�metro")) {
							valorpara = valorde * 100000;
						}
						
						if(moedade.equals("cent�metro")&& moedapara.equals("quil�metro")) {
							valorpara = valorde / 100000;
						}
						
						if(moedade.equals("quil�metro")&& moedapara.equals("mil�metro")) {
							valorpara = valorde * 1000000;
						}
						
						if(moedade.equals("mil�metro")&& moedapara.equals("quil�metro")) {
							valorpara = valorde / 1000000;
						}
						
						if(moedade.equals("metro")&& moedapara.equals("cent�metro")) {
							valorpara = valorde * 100;
						}
						
						if(moedade.equals("cent�metro")&& moedapara.equals("metro")) {
							valorpara = valorde / 100;
						}
						
						if(moedade.equals("metro")&& moedapara.equals("mil�metro")) {
							valorpara = valorde * 1000;
						}
						
						if(moedade.equals("mil�metro")&& moedapara.equals("metro")) {
							valorpara = valorde / 1000;
						}
						
						if(moedade.equals("cent�metro")&& moedapara.equals("mil�metro")) {
							valorpara = valorde * 10;
						}
						
						if(moedade.equals("mil�metro")&& moedapara.equals("cent�metro")) {
							valorpara = valorde / 10;
						}
						
						txtdestino.setText(String.format("%.2f", valorpara));		
						
					}
				});
				
				// Fim A��o Bot�o Converter
				
				// Adiciona os itens no frame
				add(lblorigem);
				add(lbldestino);
				add(comboBoxOrigem);
				add(comboBoxDestino);
				add(txtorigem);
				add(txtdestino);
				add(bttnconverter);
		
	}

}