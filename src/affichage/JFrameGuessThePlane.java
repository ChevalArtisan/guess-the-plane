package affichage;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

import dialogue.DialogueJeu;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameGuessThePlane extends JFrame {
	private DialogueJeu dialoguejeu;
	private JPanel Reponse;
	private JPanel EnTete;
	private JPanel Indices;
	private JTextField InputVariante;
	private JTextField InputType;
	private JLabel IndicePhoto;
	private JLabel IndiceSchema;
	private JLabel IndicePays;
	private JLabel Type;
	private JLabel Variante;
	private JPanel panelSchema;
	private JPanel panelPhoto;
	private JPanel panelPays;
	private JTextField InputSurnom;
	private JLabel Surnom;
	private JButton BoutonValider;
	private JButton btnNewClue;
	public JFrameGuessThePlane() {
		setTitle("GuessThePlane");
		
		Reponse = new JPanel();
		getContentPane().add(Reponse, BorderLayout.SOUTH);
		Reponse.setLayout(new GridLayout(0, 3, 0, 0));
		
		Type = new JLabel("Type/Constructeur");
		Reponse.add(Type);
		
		Variante = new JLabel("Variante");
		Reponse.add(Variante);
		
		Surnom = new JLabel("Surnom");
		Reponse.add(Surnom);
		
		InputType = new JTextField();
		Type.setLabelFor(InputType);
		Reponse.add(InputType);
		InputType.setColumns(10);
		
		InputVariante = new JTextField();
		Variante.setLabelFor(InputVariante);
		Reponse.add(InputVariante);
		InputVariante.setColumns(10);
		
		InputSurnom = new JTextField();
		Reponse.add(InputSurnom);
		InputSurnom.setColumns(10);
		
		BoutonValider = new JButton("Valider");
		BoutonValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_BoutonValider_actionPerformed(e);
			}
		});
		Reponse.add(BoutonValider);
		
		EnTete = new JPanel();
		getContentPane().add(EnTete, BorderLayout.NORTH);
		
		btnNewClue = new JButton("Nouvel indice");
		EnTete.add(btnNewClue);
		
		Indices = new JPanel();
		getContentPane().add(Indices, BorderLayout.CENTER);
		Indices.setLayout(new GridLayout(1, 0, 0, 0));
		
		panelSchema = new JPanel();
		Indices.add(panelSchema);
		
		
		IndiceSchema = new JLabel("");
		panelSchema.add(IndiceSchema);
		
		panelPhoto = new JPanel();
		Indices.add(panelPhoto);
		
		IndicePhoto = new JLabel("");
		IndicePhoto.setLabelFor(panelPhoto);
		panelPhoto.add(IndicePhoto);
		IndicePhoto.setFont(new Font("Tahoma", Font.PLAIN, 5));
		IndicePhoto.setIcon(new ImageIcon(JFrameGuessThePlane.class.getResource("/ressources/Mirage2000.jpg")));
		
		panelPays = new JPanel();
		Indices.add(panelPays);
		
		IndicePays = new JLabel("");
		IndicePays.setHorizontalAlignment(SwingConstants.CENTER);
		panelPays.add(IndicePays);
		IndicePays.setIcon(new ImageIcon(JFrameGuessThePlane.class.getResource("/ressources/Flag_of_France_(1794–1815,_1830–1974).svg.png")));
	}
	
	public void initPresentation() {
		//TODO faire le initPresentation 
	}
	public void setDialogue(DialogueJeu dialoguejeu) {
		this.dialoguejeu=dialoguejeu;
	}
	
	protected void do_BoutonValider_actionPerformed(ActionEvent e) {
		String repType = InputType.getText();
		String repVar = InputVariante.getText();
		String repSurnom = InputSurnom.getText();
		dialoguejeu.handle_reponse(repType,repVar,repSurnom);
	}
}
