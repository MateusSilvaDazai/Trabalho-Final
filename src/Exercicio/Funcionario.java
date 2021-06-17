package Exercicio;

import java.util.Calendar;

public abstract class Funcionario
{
	private String primeiroNome;
	private String ultimoNome;
	private String numeroSeguroSocial;
	private Data dataDeAniversario;
	
	// Construtor de cinco argumentos
	public Funcionario( Data data, String primeiro, String ultimo, String nss )
	{
		
		dataDeAniversario 	= data;
		primeiroNome 		= primeiro;
		ultimoNome	 		= ultimo;
		numeroSeguroSocial 	= nss;
	}
	
	// configura o nome
	public void setPrimeiroNome( String primeiro )
	{
		primeiroNome = primeiro; // deve validar
	}
	
	// retorna o nome
	public String getPrimeiroNome()
	{
		return primeiroNome;
	}
	
	// configura o sobrenome
	public void setUltimoNome( String ultimo )
	{
		ultimoNome = ultimo; // deve validar
	}
	
	// retorna o sobrenome
	public String getUltimoNome()
	{
		return ultimoNome;
	}
	
	// configura o CIC
	public void setNSS( String nss )
	{
		numeroSeguroSocial = nss;
	}
	
	// retorna o CIC
	public String getNSS()
	{
		return numeroSeguroSocial;
	}
	
	// retorna a representa��o String do objeto Funcionario
	@Override // indica que esse m�todo sobrescreve um m�todo de superclasse
	public String toString()
	{
		return String.format( "%s %s\nN�mero de Seguro Social: %s", 
			getPrimeiroNome(), getUltimoNome(), getNSS() );
	}
	
	// m�todo abstract sobrescrito por subclasse concretas
	public abstract double calculaSalario(); // nenhuma implementa��o aqui
	
	public int adicionalPorAniversario()
	{
		Calendar c = Calendar.getInstance();
		c.setTime(c.getTime());
		
		if( c.get(Calendar.MONTH) + 1 == dataDeAniversario.getMes() )
			return 100;
		
		return 0;
	}
}