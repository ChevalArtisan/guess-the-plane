package affichage;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class JFrameGuessThePlane extends JFrame {
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
	public JFrameGuessThePlane() {
		setTitle("GuessThePlane");
		
		Reponse = new JPanel();
		getContentPane().add(Reponse, BorderLayout.SOUTH);
		Reponse.setLayout(new GridLayout(0, 2, 0, 0));
		
		Type = new JLabel("Type/Constructeur");
		Reponse.add(Type);
		
		Variante = new JLabel("Variante");
		Reponse.add(Variante);
		
		InputType = new JTextField();
		Type.setLabelFor(InputType);
		Reponse.add(InputType);
		InputType.setColumns(10);
		
		InputVariante = new JTextField();
		Variante.setLabelFor(InputVariante);
		Reponse.add(InputVariante);
		InputVariante.setColumns(10);
		
		EnTete = new JPanel();
		getContentPane().add(EnTete, BorderLayout.NORTH);
		
		Indices = new JPanel();
		getContentPane().add(Indices, BorderLayout.CENTER);
		Indices.setLayout(new GridLayout(1, 0, 0, 0));
		
		IndicePays = new JLabel("");
		IndicePays.setIcon(new ImageIcon(JFrameGuessThePlane.class.getResource("/ressources/Flag_of_France_(1794–1815,_1830–1974).svg.png")));
		Indices.add(IndicePays);
		
		IndicePhoto = new JLabel("");
		IndicePhoto.setFont(new Font("Tahoma", Font.PLAIN, 5));
		IndicePhoto.setIcon(new ImageIcon(JFrameGuessThePlane.class.getResource("/ressources/Mirage2000.jpg")));
		IndicePhoto.setBounds(10,10,400,400);
		Indices.add(IndicePhoto);
		
		IndiceSchema = new JLabel("");
		Indices.add(IndiceSchema);
	}
}
