package Exercicio;

public class FolhaDePagamentosTeste
{
	public static void main( String[] args )
	{		
		Data dataFS   = new Data( 07, 01, 1994 );
		Data dataFH   = new Data( 10, 02, 2000 );
		Data dataFC   = new Data( 16, 03, 2005 );
		Data dataFCSB = new Data( 02, 04, 1990 );
		
		// cria objetos de sublclasse
		FuncionarioSalariado funcionarioS = new FuncionarioSalariado(
			dataFS , "Mateus", "Dazai", "111-11-1111", 900.00 );
		FuncionarioHora funcionarioH = new FuncionarioHora(
			dataFH, "Lucas", "Silva", "222-22-2222", 8.986, 00 );
		FuncionarioComissionado funcionarioC = new FuncionarioComissionado(
			dataFC, "Bernardo", "Gomes", "333-33-3333", 8.000, .06 );
		FuncionarioComissionadoSB funcionarioCSB = new FuncionarioComissionadoSB(
			dataFCSB, "Maria Eduarda", "Meireles", "444-44-4444", 7.500, .04, 300 );
		
		// cria um array funcionario de 4 elementos
		Funcionario[] funcionarios = new Funcionario[4];
		
		// inicializa o array com funcionários
		funcionarios[0] = funcionarioS;
		funcionarios[1] = funcionarioH;
		funcionarios[2] = funcionarioC;
		funcionarios[3] = funcionarioCSB;
		
		System.out.println( "Funcionários processados polimorficamente:\n" );
		
		// processa genericamente cada elemento no array funcionários
		for( Funcionario funcionarioAtual : funcionarios )
		{
			System.out.println( funcionarioAtual ); // invoca toString
			// determina se elemento é um Funcionario Comissionado com Salario Base
			if( funcionarioAtual instanceof FuncionarioComissionadoSB )
			{
				// downcast da referência de Funcionário para referência a FuncionárioCSB
				FuncionarioComissionadoSB funcionario = ( FuncionarioComissionadoSB ) funcionarioAtual;
				
				funcionario.setSalarioBase( 1.10 * funcionario.getSalarioBase() );
				
				System.out.printf(
					"Novo salário base com 10%% de aumento é: $%,.2f\n",
					funcionario.getSalarioBase() + funcionario.adicionalPorAniversario() );
			}
			
			System.out.printf( 
				"Ganhou $%,.2f\n\n", funcionarioAtual.calculaSalario() + funcionarioAtual.adicionalPorAniversario() );
		}
		
		// obtém o nome do tipo de cada objeto no array funcionarios
		for( int j = 0; j < funcionarios.length; j++ )
			System.out.printf( "Funcionários %d é um %s\n", j, funcionarios[ j ].getClass().getName() );
	}
}