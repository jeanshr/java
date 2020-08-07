package cursojava.thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;

public class TelaTimeThread extends JDialog {

	private JPanel jPanel = new JPanel(new GridBagLayout());// painel de componentes

	private JLabel descricaoHora = new JLabel("Nome");
	private JTextField mostraTempo = new JTextField();

	private JLabel descricaoHora2 = new JLabel("Email");
	private JTextField mostraTempo2 = new JTextField();

	private JButton jButton = new JButton("Add Lista");
	private JButton jButton2 = new JButton("Stop");

	private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();

	public TelaTimeThread() {
		setTitle("Threads");
		setSize(new DimensionUIResource(240, 240));
		setLocationRelativeTo(null);
		setResizable(false);

		GridBagConstraints g = new GridBagConstraints(); // controlador de posicionamento - componentes
		g.gridx = 0;
		g.gridy = 0;
		g.anchor = g.WEST;
		g.insets = new Insets(5, 10, 5, 5);
		// cospan - ocupara duas linha
		g.gridwidth = 2;

		descricaoHora.setPreferredSize(new Dimension(200, 25));
		jPanel.add(descricaoHora, g);

		mostraTempo.setPreferredSize(new Dimension(200, 25));
		g.gridy++; // pulando linha para nao sobrescrever o conteudo adicionado anteriormente
		jPanel.add(mostraTempo, g);

		descricaoHora2.setPreferredSize(new DimensionUIResource(200, 25));
		g.gridy++;
		jPanel.add(descricaoHora2, g);

		mostraTempo2.setPreferredSize(new Dimension(200, 25));
		g.gridy++; // pulando linha para nao sobrescrever o conteudo adicionado anteriormente
		jPanel.add(mostraTempo2, g);

		/*********** Botoes ***********/
		// cospan - ocupara uma linha
		g.gridwidth = 1;
		jButton.setPreferredSize(new Dimension(92, 25));
		g.gridy++;
		jPanel.add(jButton, g);

		jButton2.setPreferredSize(new Dimension(92, 25));
		g.gridx++;
		jPanel.add(jButton2, g);

		jButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (fila == null) {
					fila = new ImplementacaoFilaThread();
					fila.start();
				}
				for (int qtd = 0; qtd < 100; qtd++) {
					ObjetoFilaThread filaThread = new ObjetoFilaThread();
					filaThread.setNome(mostraTempo.getText());
					filaThread.setEmail(mostraTempo2.getText() + " - " + qtd);

					fila.add(filaThread);
				}
			}
		});

		jButton2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				fila.stop();
				fila = null;
			}
		});

		// Adicionando elementos na tela
		add(jPanel, BorderLayout.WEST);

		fila.start();

		/*
		 * Sempre será o último comando para finalizar a tela e deixar visível ao user
		 */
		setVisible(true);
	}

}
