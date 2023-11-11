package affichage;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

import dialogue.DialogueJeu;
import jeu.Jeu;

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
	private int numindice=0;
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
		btnNewClue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewClue_actionPerformed(e);
			}
		});
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
		IndicePhoto.setIcon(new ImageIcon(JFrameGuessThePlane.class.getResource("/ressources/Dassault_Mirage_2000C_3-view_line_drawing.gif")));
		IndicePhoto.setLabelFor(panelPhoto);
		panelPhoto.add(IndicePhoto);
		IndicePhoto.setFont(new Font("Tahoma", Font.PLAIN, 5));
		
		panelPays = new JPanel();
		Indices.add(panelPays);
		
		IndicePays = new JLabel("");
		IndicePays.setHorizontalAlignment(SwingConstants.CENTER);
		panelPays.add(IndicePays);
	}
	
	public void initPresentation() {
		newPlane();
		
		
	}
	public void setDialogue(DialogueJeu dialoguejeu) {
		this.dialoguejeu=dialoguejeu;
	}
	
	public void newPlane() {
		String[] indices=dialoguejeu.handleNewPlane().getIndices();
		numindice=0;
		btnNewClue.setEnabled(true);
		IndicePhoto.setVisible(true);
		IndicePays.setVisible(false);
		IndiceSchema.setVisible(false);
		System.out.println(indices[0]);
		System.out.println(indices[1]);
		System.out.println(indices[2]);
		IndicePhoto.setIcon(new ImageIcon(JFrameGuessThePlane.class.getResource("/ressources/"+indices[0])));
		IndicePays.setIcon(new ImageIcon(JFrameGuessThePlane.class.getResource("/ressources/"+indices[1])));
		IndiceSchema.setIcon(new ImageIcon(JFrameGuessThePlane.class.getResource("/ressources/"+indices[2])));
		
	}
	
	protected void do_BoutonValider_actionPerformed(ActionEvent e) {
		String repType = InputType.getText();
		String repVar = InputVariante.getText();
		String repSurnom = InputSurnom.getText();
		if (dialoguejeu.handleReponse(repType,repVar,repSurnom)) {
			JOptionPane.showMessageDialog(this, "Bonne reponse");
		} else {
			JOptionPane.showMessageDialog(this, "Mauvaise reponse");
		}
		newPlane();
	}
	
	protected void do_btnNewClue_actionPerformed(ActionEvent e) {
		switch (numindice) {
		case 0: {
			IndicePays.setVisible(true);
			break;
		}
		case 1:{
			IndiceSchema.setVisible(true);
			btnNewClue.setEnabled(false);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: "+numindice);
		}
		numindice++;
	}
	
}
