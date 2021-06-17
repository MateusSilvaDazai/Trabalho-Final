package Exercicio;

public class FuncionarioComissionado extends Funcionario
{
	private double vendasBrutas; // vendas brutas semanais
	private double taxaComissao; // porcentagem da comissão
	private Data dataC;
	
	// construtor de cinco argumentos
	public FuncionarioComissionado( Data data, String nome, String sobrenome, String nss, double vendasB, double taxaC )
	{
		super( data, nome, sobrenome, nss );
		setVendasBrutas( vendasB );
		setTaxaComissao( taxaC );
	}
	
	public void setTaxaComissao( double taxa )
	{
		taxaComissao = ( taxa > 0.0 && taxa < 1.0 ) ? taxa : 0.0;
	}
	
	public double getTaxaComissao()
	{
		return taxaComissao;
	}
	
	public void setVendasBrutas( double vendas )
	{
		vendasBrutas = ( vendas < 0.0 ) ? 0.0 : vendas;
	}
	
	public double getVendasBrutas()
	{
		return vendasBrutas;
	}
	
	@Override
	public double calculaSalario()
	{
		return getTaxaComissao() * getVendasBrutas();
	}
	
	@Override
	public String toString()
	{
		return String.format( "%s: %s\n%s $%,.2f; %s: %.2f",
		"Funcionário Comissionado", super.toString(),
		"Vendas brutas", getVendasBrutas(),
		"Taxa de comissão", getTaxaComissao() );
	}
}