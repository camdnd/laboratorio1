package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class EntryPanel extends JPanel implements ActionListener{
	
	public static final String B_AGREGAR = "AGREGAR";
	public static final String B_ORDENAR = "ORDENAR"; 
	
	private Mainc p;
	
	private ButtonGroup group1;
	private ButtonGroup group2;
	
	private JRadioButton ent;
	private JRadioButton fl;
	
	private JRadioButton combSort;
	private JRadioButton shellSort;
	private JRadioButton gnomeSort;
	
	private double[] flotantes;
	private int[] enteros;
	
	private JPanel container1;
	private JPanel container2;
	private JPanel container3;
	private JPanel container4;
	private JPanel container5;
	
	private JLabel etiqueta;
	private JTextField ingresoNumeros;
	private JButton agregar;
	private JButton ordenar;
	private JList agregados;
	private JScrollPane scrollList;
	private JList ordenados;
	private JScrollPane scrollList1;

	private DefaultListModel modelo;
	private DefaultListModel modelo1;

	
	public EntryPanel(Mainc p)
	
	{
		this.p = p;
		
		
		
		setLayout(new BorderLayout());
		
		TitledBorder titledBorder = BorderFactory.createTitledBorder("Ingreso");
		titledBorder.setTitleColor(Color.BLUE);
		setBorder(titledBorder);
		
		setSize(90,50);

		container1 = new JPanel();
		container1.setLayout(new GridLayout(2,2));
		TitledBorder titledBorder1 = BorderFactory.createTitledBorder("Datos");
		titledBorder1.setTitleColor(Color.BLUE);
		container1.setBorder(titledBorder1);
		
		container5 = new JPanel();
		container5.setLayout(new BorderLayout());
		
		container4 = new JPanel();
		container4.setLayout(new GridLayout(1,3));
		TitledBorder titledBorder0 = BorderFactory.createTitledBorder("Tipo de ordenamiento");
		titledBorder0.setTitleColor(Color.BLUE);
		container4.setBorder(titledBorder0);
		
		group1 = new ButtonGroup();
		group2 = new ButtonGroup();
		
		combSort = new JRadioButton("CombSort");
		group2.add(combSort);
		shellSort = new JRadioButton("shellSort");
		group2.add(shellSort);
		gnomeSort = new JRadioButton("gnomeSort");
		group2.add(gnomeSort);
		
		container4.add(combSort);
		container4.add(shellSort);
		container4.add(gnomeSort);
		
		container5.add(container4, BorderLayout.NORTH);
		container5.add(container1, BorderLayout.CENTER);
		
		
		ent = new JRadioButton("Enteros");
		group1.add(ent);
		fl = new JRadioButton("Flotantes");
		group1.add(fl);
		
		etiqueta = new JLabel("Ingrese numeros");
		container1.add(etiqueta);
		
		ingresoNumeros = new JTextField();
		container1.add(ingresoNumeros);
		
		
		container2 = new JPanel();
		container2.setLayout(new GridLayout(1,2));
		TitledBorder titledBorder2 = BorderFactory.createTitledBorder("Tipo de dato");
		titledBorder2.setTitleColor(Color.BLUE);
		container2.setBorder(titledBorder2);
		
		container2.add(ent);
		container2.add(fl);
		
		agregar = new JButton("Agregar");
		agregar.setActionCommand(B_AGREGAR);
		agregar.addActionListener(this);
		container1.add(agregar);
		
		ordenar = new JButton("Ordenar");
		ordenar.setActionCommand(B_ORDENAR);
		ordenar.addActionListener(this);
		container1.add(ordenar);
		
		
		container3 = new JPanel();
		container3.setLayout(new GridLayout(1,2));
		TitledBorder titledBorder3 = BorderFactory.createTitledBorder("Listas de datos");
		titledBorder3.setTitleColor(Color.BLUE);
		container3.setBorder(titledBorder3);
		agregados = new JList();
		modelo = new DefaultListModel();
		agregados.setModel(modelo);
		scrollList = new JScrollPane();
		scrollList.setBounds(20, 120,220, 80);
		scrollList.setViewportView(agregados);
		container3.add(scrollList);
		
		ordenados = new JList();
		scrollList1 = new JScrollPane();
		modelo1 = new DefaultListModel();
		ordenados.setModel(modelo1);
		scrollList1.setBounds(20, 120,220, 80);
		scrollList1.setViewportView(ordenados);
		container3.add(scrollList1);
		
		add(container2, BorderLayout.NORTH);
		add(container5, BorderLayout.CENTER);
		add(container3, BorderLayout.SOUTH);
	}
	
	public void updateCombSortListForIntegers(int[] enteros)
	{
        for(int i = 0; i< enteros.length;i++){
        	modelo1.addElement(enteros[i]);           
        }		
	}
	
	public void updateCombSortListForRealNumbers(double[] flotantes)
	{
		for(int i = 0; i< flotantes.length;i++){        	
        	modelo1.addElement(flotantes[i]);            
        }	
	}

	public void updateShellSortListForIntegers(int[] enteros)
	{
        for(int i = 0; i< enteros.length;i++){
        	modelo1.addElement(enteros[i]);           
        }		
	}
	
	public void updateShellSortListForRealNumbers(double[] flotantes)
	{
		for(int i = 0; i< flotantes.length;i++){        	
        	modelo1.addElement(flotantes[i]);            
        }	
	}
	
	public void updateGnomeSortListForIntegers(int[] enteros)
	{
        for(int i = 0; i< enteros.length;i++){
        	modelo1.addElement(enteros[i]);           
        }		
	}
	
	public void updateGnomeSortListForRealNumbers(double[] flotantes)
	{
		for(int i = 0; i< flotantes.length;i++){        	
        	modelo1.addElement(flotantes[i]);            
        }	
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String evento = e.getActionCommand();
		
		if(evento.equals(B_AGREGAR))
		{
			String numero = ingresoNumeros.getText();
			ingresoNumeros.setText(null);
			modelo.addElement(numero);
		}
		
		if(evento.equals(B_ORDENAR))
		{
			if(ent.isSelected()==true)
			{
				enteros = new int[agregados.getModel().getSize()];
		        for(int i = 0; i< agregados.getModel().getSize();i++)
		        {		        	
		        	int a = Integer.valueOf((String) agregados.getModel().getElementAt(i));
		        	enteros[i] = a; 
		        }
		        
		        if(combSort.isSelected()==true)
		        {
		        	p.combSortIntegers(enteros);
		        }
		        else if(shellSort.isSelected()==true)
		        {
		        	p.shellSortInteger(enteros);
		        }
		        else if(gnomeSort.isSelected()==true)
		        {
		        	p.gnomeSortInteger(enteros);
		        }
		        
			}
			
			else if(fl.isSelected()==true)
			{
				flotantes = new double[agregados.getModel().getSize()];
		        for(int i = 0; i< agregados.getModel().getSize();i++)
		        {   	
		        	double a = Double.valueOf((String) agregados.getModel().getElementAt(i));
		        	flotantes[i] = a;		            
		        }
		        if(combSort.isSelected()==true)
		        {
		        	p.combSortRealNumbers(flotantes);;
		        }
		        else if(shellSort.isSelected()==true)
		        {
		        	p.shellSortRealnumbers(flotantes);
		        }
		        else if(gnomeSort.isSelected()==true)
		        {
		        	p.gnomeSortRealNumbers(flotantes);
		        }
			}

	        
		}
		
	}

}
