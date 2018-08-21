package interfaz;

import java.awt.*;
import javax.swing.*;
import modelo.Organizer;

public class Mainc extends JFrame{
	

	
	private EntryPanel entryPanel;
	private RandomPanel randomPanel;
	private Organizer organizerF;

	
	public Mainc()
	{
		setSize(438,695);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		entryPanel = new EntryPanel(this);
		randomPanel = new RandomPanel(this);
		
		organizerF = new Organizer();
		
		add(entryPanel, BorderLayout.NORTH);
		add(randomPanel, BorderLayout.CENTER);
		
		
	}
	
	
	public void combSortIntegers(int[] enteros)
	{
		enteros = organizerF.combSortForIntegers(enteros);

		entryPanel.updateCombSortListForIntegers(enteros);
		
	}
	
	public void combSortRealNumbers(double[] flotantes)
	{
		flotantes = organizerF.combSortForRealNumbers(flotantes);

		entryPanel.updateCombSortListForRealNumbers(flotantes);
	}
	
	
	
	public void shellSortInteger(int[] enteros)
	{
		enteros = organizerF.shellSortInteger(enteros);

		entryPanel.updateShellSortListForIntegers(enteros);
	}
	
	public void shellSortRealnumbers(double[] flotantes)
	{
		flotantes = organizerF.shellSortRealnumbers(flotantes);

		entryPanel.updateShellSortListForRealNumbers(flotantes);
	}
	
	
	
	public void gnomeSortInteger(int[] enteros)
	{
		enteros = organizerF.gnomeSortInteger(enteros);

		entryPanel.updateGnomeSortListForIntegers(enteros);
	}
	
	public void gnomeSortRealNumbers(double[] flotantes)
	{
		flotantes = organizerF.gnomeSortRealNumbers(flotantes);

		entryPanel.updateGnomeSortListForRealNumbers(flotantes);
	}
	
	
	public void generateRandomIntegers(int cantidad, int inicio, int fin)
	{
		int[] enteros = new int[cantidad];
		int control = 0;
		
		for(int i=0;i<enteros.length;i++)
		{
			control = (int)(Math.random()*(fin-inicio)+inicio);
			System.out.println(control);
			enteros[i]=control;
		}
		
		randomPanel.updateRandomListForIntegers(enteros);

	}
	
	public void generateRandomDoubles(int cantidad, int inicio, int fin)
	{
		double[] flotantes = new double[cantidad];
		double control = 0;
		
		for(int i=0;i<flotantes.length;i++)
		{
			control = (Math.random()*(fin-inicio)+inicio);
			
			flotantes[i]=control;
		}
		randomPanel.updateRandomListForRealNumbers(flotantes);
	}
	
	
	
	
	public static void main(String[] args)
	{
		Mainc p = new Mainc();
		p.setVisible(true);
	}

}
