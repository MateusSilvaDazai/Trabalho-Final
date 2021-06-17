package Exercicio;

public class FuncionarioSalariado extends Funcionario
{
	private double salarioSemanal;
	private Data dataS;
	
	// construtor com quatro argumentos
	public FuncionarioSalariado(Data data, String primeiro, String ultimo, String nss, double salarioS )
	{
		super( data, primeiro, ultimo, nss ); // passa para o construtor de Funcion�rio
		setSalarioSemanal( salarioS ); // valida e armazena o sal�rio
	}
	
	// configura o sal�rio
	public void setSalarioSemanal( double salarioS )
	{
		salarioSemanal = salarioS < 0.0 ? 0.0 : salarioS;
	}
	
	// retorna o sal�rio
	public double getSalarioSemanal()
	{
		return salarioSemanal;
	}
	
	// calcula os rendimentos; sobrescreve o m�todo calculaSalario em Funcionario
	@Override
	public double calculaSalario()
	{
		return salarioSemanal;
	}
	
	// retorna a representa��o String do objeto FuncionarioSalariado
	@Override
	public String toString()
	{
		return String.format( "Funcion�rio salariado: %s\n%s: $%,.2f",
			super.toString(), "Sal�rio semanal", getSalarioSemanal() );
	}
}