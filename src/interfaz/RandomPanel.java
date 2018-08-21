package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class RandomPanel extends JPanel implements ActionListener{ 
	
	public static final String GENERAR = "GENERAR";
	
	private Mainc p;
	
	private ButtonGroup group1;
	private ButtonGroup group2;
	
	private JRadioButton enteros;
	private JRadioButton flotantes;
	
	private JRadioButton option1;
	private JRadioButton option2;
	private JRadioButton option3;
	private JRadioButton option4;
	
	private JLabel aleatorio;
	private JTextField cantidad;
	private JLabel intervalo;
	private JTextField inicio;
	private JLabel y;
	private JTextField fin;
	
	private JButton generar;
	
	private JPanel aux1;
	private JPanel aux2;
	private JPanel aux3;
	private JPanel aux4;
	private JPanel aux5;
	
	private DefaultListModel modelo;
	private JScrollPane scrollLista;
	private JList agregados;
	
	public  RandomPanel(Mainc p)
	{
		this.p=p;
		
		
		setLayout(new BorderLayout());
		
		TitledBorder titledBorder = BorderFactory.createTitledBorder("Aleatorio");
		titledBorder.setTitleColor(Color.BLUE);
		setBorder(titledBorder);
		
		aux1 = new JPanel();
		aux1.setLayout(new GridLayout(1,2));
		TitledBorder titledBorder1 = BorderFactory.createTitledBorder("Tipo de dato");
		titledBorder1.setTitleColor(Color.BLUE);
		aux1.setBorder(titledBorder1);
		
		group1 = new ButtonGroup();
		group2 = new ButtonGroup();
		
		enteros = new JRadioButton("Enteros");
		group1.add(enteros);
		aux1.add(enteros);
		flotantes = new JRadioButton("Flotantes");
		group1.add(flotantes);
		aux1.add(flotantes);

		aux4 = new JPanel();
		aux4.setLayout(new GridLayout(1,6));
		aux5 = new JPanel();
		aux5.setLayout(new BorderLayout());
		TitledBorder titledBorder0 = BorderFactory.createTitledBorder("Criterio");
		titledBorder0.setTitleColor(Color.BLUE);
		aux4.setBorder(titledBorder0);
		
		aleatorio = new JLabel("cantidad");
		aux4.add(aleatorio);
		
		cantidad = new JTextField();
		aux4.add(cantidad);
		
		intervalo = new JLabel("entre:");
		aux4.add(intervalo);
		
		inicio = new JTextField();
		aux4.add(inicio);
		
		y = new JLabel("y");
		aux4.add(y);
		
		fin = new JTextField();
		aux4.add(fin);
		
		aux5.add(aux4, BorderLayout.NORTH);
		
		
		aux2 = new JPanel();
		aux2.setLayout(new GridLayout(1,5));
		TitledBorder titledBorder2 = BorderFactory.createTitledBorder("Tipo de orden");
		titledBorder2.setTitleColor(Color.BLUE);
		aux2.setBorder(titledBorder2);
		
		option1 = new JRadioButton("Op1");
		group2.add(option1);
		aux2.add(option1);
		
		option2 = new JRadioButton("Op2");
		group2.add(option2);
		aux2.add(option2);
		
		option3 = new JRadioButton("Op3");
		group2.add(option3);
		aux2.add(option3);
		
		option4 = new JRadioButton("Op4");
		group2.add(option4);
		aux2.add(option4);
		
		generar = new JButton("Generar");
		generar.setActionCommand(GENERAR);
		generar.addActionListener(this);
		group2.add(option4);
		aux2.add(generar);
		
		aux5.add(aux2, BorderLayout.CENTER);
		
		
		aux3 = new JPanel();
		aux3.setLayout(new GridLayout(1,1));
		TitledBorder titledBorder3 = BorderFactory.createTitledBorder("Datos ordenados");
		titledBorder3.setTitleColor(Color.BLUE);
		aux3.setBorder(titledBorder3);
		
		agregados = new JList();
		modelo = new DefaultListModel();
		agregados.setModel(modelo);
		scrollLista = new JScrollPane();
		scrollLista.setBounds(20, 120,220, 80);
		scrollLista.setViewportView(agregados);
		aux3.add(scrollLista);
		
		add(aux1, BorderLayout.NORTH);
		add(aux5, BorderLayout.CENTER);
		add(aux3, BorderLayout.SOUTH);

	}
	
	public void updateRandomListForIntegers(int[] enteros)
	{
		for (int i = 0; i < enteros.length; i++) {
			modelo.addElement(enteros[i]); 
		}
	}

	public void updateRandomListForRealNumbers(double[] flotantes)
	{
		for (int i = 0; i < flotantes.length; i++) {
			modelo.addElement(flotantes[i]); 
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String evento = e.getActionCommand();
		
		if(evento.equals(GENERAR))
		{
			String c= cantidad.getText();
			int cantidad = Integer.parseInt(c);
			
			String i= inicio.getText();
			int inicio = Integer.parseInt(i);
			
			String f = fin.getText();
			int fin = Integer.parseInt(f); 
			
			if(enteros.isSelected()==true)
			{
				p.generateRandomIntegers(cantidad, inicio, fin);
			}
			else if(flotantes.isSelected()==true)
			{
				p.generateRandomDoubles(cantidad, inicio, fin);
			}
		}
	}

}
