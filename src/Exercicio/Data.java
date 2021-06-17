package Exercicio;

public class Data
{
	private int dia; // 1-31 conforme o mês
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
	
	// método utilitário para confirmar o valor adequado de dia com base em mes e ano
	private int checkDia( int testaDia )
	{
		int[] diasPorMes = 
			{ 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
			
		// veririca se dia está no intervalo para mes
		if( testaDia > 0 && testaDia <= diasPorMes[ mes ] )
			return testaDia;
		
		// verifica ano bissexto
		else if( mes == 2 && testaDia == 29 && ( ano % 400 == 0 || ( ano % 4 == 0 && ano % 100 != 0 ) ) )
			return testaDia;
			
		//System.out.printf( "Dia inválido (%d) configura para 1.", testaDia );
		return testaDia; // mantém o objeto em estado consistente
	}
	
	// método utilitário para confirmar o valor adequado do mes
	public int checkMes( int testaMes )
	{
		if( testaMes > 0 && testaMes <= 12 ) // valida mes
			return testaMes;
		else
		{
			System.out.printf(
				"Mês inválido (%d) configure para 1.", testaMes );
			return 1; // mantém o objeto em estado consistente
		}
	}
	
	public int getMes()
	{
		return mes;
	}
	
	// retorna um String no formato mês/dia/ano
	public String toString()
	{
		return String.format( "%d/%d/%d", dia, mes, ano );
	}	
}