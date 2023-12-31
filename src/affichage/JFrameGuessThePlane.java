package affichage;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

import dialogue.DialogueJeu;
import jeu.Jeu;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
	private int pts=0;
	private JLabel Score;
	public JFrameGuessThePlane() {
		setTitle("GuessThePlane");
		setPreferredSize(new Dimension(900, 600));
		setSize(getPreferredSize());
		
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
		InputType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_InputType_actionPerformed(e);
			}
		});
		Type.setLabelFor(InputType);
		Reponse.add(InputType);
		InputType.setColumns(10);
		
		InputVariante = new JTextField();
		InputVariante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_InputVariante_actionPerformed(e);
			}
		});
		Variante.setLabelFor(InputVariante);
		Reponse.add(InputVariante);
		InputVariante.setColumns(10);
		
		InputSurnom = new JTextField();
		InputSurnom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_InputSurnom_actionPerformed(e);
			}
		});
		Reponse.add(InputSurnom);
		InputSurnom.setColumns(10);
		
		Score = new JLabel("0pts");
		Score.setHorizontalAlignment(SwingConstants.CENTER);
		Reponse.add(Score);
		
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
		IndiceSchema.setSize(panelSchema.getSize());
		panelSchema.add(IndiceSchema);
		
		panelPhoto = new JPanel();
		Indices.add(panelPhoto);
		
		IndicePhoto = new JLabel("");
		panelPhoto.add(IndicePhoto);
		IndicePhoto.setIcon(new ImageIcon(JFrameGuessThePlane.class.getResource("/ressources/Dassault_Mirage_2000C_3-view_line_drawing.gif")));
		IndicePhoto.setLabelFor(panelPhoto);
		IndicePhoto.setFont(new Font("Tahoma", Font.PLAIN, 5));
		IndicePhoto.setSize(300,200);
		
		panelPays = new JPanel();
		Indices.add(panelPays);
		
		IndicePays = new JLabel("");
		IndicePays.setHorizontalAlignment(SwingConstants.CENTER);
		IndicePays.setSize(panelPays.getSize());
		
		panelPays.add(IndicePays);
	}
	
	public void initPresentation() {
		newPlane();
		
		
	}
	public void setDialogue(DialogueJeu dialoguejeu) {
		this.dialoguejeu=dialoguejeu;
	}
	
//	public Image setImage(String path,JLabel lbl) {
//		BufferedImage img = null;
//		try {
//		    img = ImageIO.read(new File(JFrameGuessThePlane.class.getResource(path)));
//		} catch (IOException e) {
//		    e.printStackTrace();
//		}
//		Image dimg = img.getScaledInstance(lbl.getWidth(), lbl.getHeight(),
//		        Image.SCALE_SMOOTH);
//		return dimg;
//		
//	}
	
	public void newPlane() {
		String[] indices=dialoguejeu.handleNewPlane().getIndices();
		numindice=0;
		btnNewClue.setEnabled(true);
		IndicePhoto.setVisible(true);
		IndicePays.setVisible(false);
		IndiceSchema.setVisible(false);
		
		
		IndicePhoto.setIcon(new ImageIcon(new ImageIcon(JFrameGuessThePlane.class.getResource(
				"/ressources/"+indices[0])).getImage().getScaledInstance(
				300, 200, Image.SCALE_SMOOTH)));
		IndicePays.setIcon(new ImageIcon(new ImageIcon(JFrameGuessThePlane.class.getResource(
				"/ressources/"+indices[1])).getImage().getScaledInstance(
						300, 200, Image.SCALE_SMOOTH)));
		IndiceSchema.setIcon(new ImageIcon(new ImageIcon(JFrameGuessThePlane.class.getResource(
				"/ressources/"+indices[2])).getImage().getScaledInstance(
						300, 200, Image.SCALE_SMOOTH)));
		
//		IndicePhoto.setIcon(new ImageIcon(JFrameGuessThePlane.class.getResource("/ressources/"+indices[0])));
//		IndicePays.setIcon(new ImageIcon(JFrameGuessThePlane.class.getResource("/ressources/"+indices[1])));
//		IndiceSchema.setIcon(new ImageIcon(JFrameGuessThePlane.class.getResource("/ressources/"+indices[2])));
//		
//		
		
		
		Score.setText(pts+"pts");
		InputType.setText("");
		InputVariante.setText("");
		InputSurnom.setText("");
		
	}
	
	private void valider() {
		String repType = InputType.getText().toLowerCase();
		String repVar = InputVariante.getText().toLowerCase();
		String repSurnom = InputSurnom.getText().toLowerCase();
		System.out.println(repType);
		int rep=dialoguejeu.handleReponse(repType,repVar,repSurnom);
		if (rep!=0) {
			JOptionPane.showMessageDialog(this, "Bonne reponse, vous marquez "+rep+"pts");
			pts+=rep;
		} else {
			JOptionPane.showMessageDialog(this, "Mauvaise reponse");
		}
		newPlane();
	}
	
	protected void do_BoutonValider_actionPerformed(ActionEvent e) {
		valider();
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
	
	protected void do_InputType_actionPerformed(ActionEvent e) {
		valider();
	}
	protected void do_InputVariante_actionPerformed(ActionEvent e) {
		valider();
	}
	protected void do_InputSurnom_actionPerformed(ActionEvent e) {
		valider();
	}
}
