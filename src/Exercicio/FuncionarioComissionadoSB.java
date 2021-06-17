package Exercicio;

public class FuncionarioComissionadoSB extends FuncionarioComissionado
{
	private double salarioBase; // salário base por semana
	private Data dataCS;
	
	// construtor de seis argumentos
	public FuncionarioComissionadoSB( Data data, String nome, String sobrenome, 
		String nss, double vendas, double taxa, double salario )
	{
		super( data, nome, sobrenome, nss, vendas, taxa );
		setSalarioBase( salario );
	}
	
	public void setSalarioBase( double salario )
	{
		salarioBase = ( salario < 0.0 ) ? 0.0 : salario;
	}
	
	public double getSalarioBase()
	{
		return salarioBase;
	}
	
	@Override
	public double calculaSalario()
	{
		return  getSalarioBase() + super.calculaSalario();
	}
	
	@Override
	public String toString()
	{
		return String.format( "%s %s; %s: $%,.2f",
			"Base de assalariado", super.toString(),
			"Salário Base", getSalarioBase() );
	}
}