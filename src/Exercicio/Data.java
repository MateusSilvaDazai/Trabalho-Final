package Exercicio;

public class Data
{
	private int dia; // 1-31 conforme o m�s
	private int mes; // 1-12
	private int ano; // qualquer ano
	
	// construtor: chama checkMes para confirmar o valor adequado para mes;
	// chama checkDia para confirmar o valor adequado para dia
	public Data( int day, int month, int year )
	{
		dia = checkDia( day ); // valida dia
		mes = checkMes( month ); // valida month
		ano = year; // poderia validar ano
	}
	
	// m�todo utilit�rio para confirmar o valor adequado de dia com base em mes e ano
	private int checkDia( int testaDia )
	{
		int[] diasPorMes = 
			{ 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
			
		// veririca se dia est� no intervalo para mes
		if( testaDia > 0 && testaDia <= diasPorMes[ mes ] )
			return testaDia;
		
		// verifica ano bissexto
		else if( mes == 2 && testaDia == 29 && ( ano % 400 == 0 || ( ano % 4 == 0 && ano % 100 != 0 ) ) )
			return testaDia;
			
		//System.out.printf( "Dia inv�lido (%d) configura para 1.", testaDia );
		return testaDia; // mant�m o objeto em estado consistente
	}
	
	// m�todo utilit�rio para confirmar o valor adequado do mes
	public int checkMes( int testaMes )
	{
		if( testaMes > 0 && testaMes <= 12 ) // valida mes
			return testaMes;
		else
		{
			System.out.printf(
				"M�s inv�lido (%d) configure para 1.", testaMes );
			return 1; // mant�m o objeto em estado consistente
		}
	}
	
	public int getMes()
	{
		return mes;
	}
	
	// retorna um String no formato m�s/dia/ano
	public String toString()
	{
		return String.format( "%d/%d/%d", dia, mes, ano );
	}	
}