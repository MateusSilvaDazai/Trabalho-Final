package Exercicio;

public class FuncionarioHora extends Funcionario
{
	private double salarioHora; // sal�rio por hora
	private double horas; // horas trabalhadas durante a semana
	private Data dataH;
	
	// construtor de cinco argumentos
	public FuncionarioHora( Data data, String nome, String sobrenome, String nss, double salarioH, double horasT )
	{
		super( data, nome, sobrenome, nss );
		setSalarioHora( salarioH ); // valida a remunera��o por hora
		setHoras( horasT );// valida as horas trabalhadas
	}
	
	// configura a remunera��o
	public void setSalarioHora( double salarioH )
	{
		salarioHora = ( salarioH < 0.0 ) ? 0.0 : salarioH;
	}
	
	// retorna a remunera��o
	public double getSalarioHora()
	{
		return salarioHora;
	}
	
	// configura as horas trabalhadas
	public void setHoras( double horasT )
	{
		horas = ( ( horasT >= 0.0 ) && ( horasT <= 168.0 ) ) ? horasT : 0.0;
	}
	
	// retorna as horas trabalhadas
	public double getHoras()
	{
		return horas;
	}
	
	// calcula os rendimentos; sobrescreve o m�todo calculaSalario em Funcionario
	@Override
	public double calculaSalario()
	{
		if( getHoras() <= 40 ) // nenhuma hora extra
			return getSalarioHora() * getHoras();
		else
			return 40 * getSalarioHora() + ( getHoras() - 40 ) * getSalarioHora() * 1.5;
	}
	
	// retorna a representa��o de String do objeto FuncionarioHora
	@Override
	public String toString()
	{
		return String.format( "Funcion�rio hora: %s\n%s: $%,.2f; %s: %,.2f",
			super.toString(), "Sal�rio hora", getSalarioHora(),
			"Horas trabalhadas", getHoras() );
	}
}