package Exercicio;

public class FuncionarioSalariado extends Funcionario
{
	private double salarioSemanal;
	private Data dataS;
	
	// construtor com quatro argumentos
	public FuncionarioSalariado(Data data, String primeiro, String ultimo, String nss, double salarioS )
	{
		super( data, primeiro, ultimo, nss ); // passa para o construtor de Funcionário
		setSalarioSemanal( salarioS ); // valida e armazena o salário
	}
	
	// configura o salário
	public void setSalarioSemanal( double salarioS )
	{
		salarioSemanal = salarioS < 0.0 ? 0.0 : salarioS;
	}
	
	// retorna o salário
	public double getSalarioSemanal()
	{
		return salarioSemanal;
	}
	
	// calcula os rendimentos; sobrescreve o método calculaSalario em Funcionario
	@Override
	public double calculaSalario()
	{
		return salarioSemanal;
	}
	
	// retorna a representação String do objeto FuncionarioSalariado
	@Override
	public String toString()
	{
		return String.format( "Funcionário salariado: %s\n%s: $%,.2f",
			super.toString(), "Salário semanal", getSalarioSemanal() );
	}
}