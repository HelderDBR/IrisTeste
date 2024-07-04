package entities;
import java.util.*;

public class Funcional {
	
	public static void listarIngredientes(List<String> Ingredientes) {
		for(String ing : Ingredientes) 
		{
			System.out.println(Ingredientes.indexOf(ing) + "-" + ing+"\n");
		}
	}
	
	public static void listarReceitas(List<Receita> Receitas) {
		for(Receita rcp: Receitas) 
		{
			System.out.println(Receitas.indexOf(rcp) + "-" + rcp.toString()+"\n");
		}
	}
	
	public static void criarReceita(List<Receita> Receitas) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Digite nome da receita:\n");
		String nome = scn.nextLine();
		List<String> componentes = new ArrayList<String>();
		System.out.println("Digite quantos ingredientes compõe a receita");
		int j = scn.nextInt();
		scn.nextLine();
		for(int k = 1; k<=j; k++){
			System.out.println("Digite o nome do "+ k+"º ingrediente");
			componentes.add(scn.nextLine());
		}
		Receita recipe = new Receita(nome, componentes, j);
		Receitas.add(recipe);
	}
	
	public static void main(String [] args) {
		Scanner scn = new Scanner(System.in);
		
		int i = -1;
		List<String> Ingredientes = new ArrayList<String>();
		List<Receita> Receitas = new ArrayList<Receita>();
		
		
		do{
			System.out.println("Digite: 1-Cadastrar Ingrediente\n"
					+ "2- Cadastrar Receita\n"
					+ "3- Editar Receita\n"
					+ "4- Excluir Receita\n"
					+ "5- Excluir Ingrediente\n"
					+ "6- Visualizar Ingredientes\n"
					+ "7- Visualizar Receitas\n"
					+ "0- Encerrar Programa\n");
			
			i = scn.nextInt();
			scn.nextLine();
			switch(i) 
			{
				case 1://Cadastrar Ingrediente
				{
					System.out.println("Digite nome da ingrediente:\n");
					String nome = scn.nextLine();
					Ingredientes.add(nome);
					for(Receita rcp: Receitas) 
					{
						rcp.calcularPorcentagem(Ingredientes);
					}
					break;
				}
				
				case 2://Cadastrar Receita
				{
					System.out.println(i);
					criarReceita(Receitas);
					Receitas.get(Receitas.size() - 1).calcularPorcentagem(Ingredientes);
					break;
				}
				case 3://Editar Receita
				{
					
					System.out.println("Digite o numero de qual receita deseja editar:\n");
					listarReceitas(Receitas);
					int j = scn.nextInt();
					scn.nextLine();
					int k = -1;
					do {
					System.out.println("Digite:\n"
							+ "1- Para adicionar ingrediente\n"
							+ "2- Para remover ingrediente\n"
							+ "0- Para alterar apenas o nome\n");
					k = scn.nextInt();
					scn.nextLine();
					System.out.println(k);
					}while(k != 1 && k != 2 && k != 0);
					
					System.out.println("Digite o novo nome da receita:\n");
					String nome = scn.nextLine();			
					
					if(k == 1)
					{
						List<String> componentes = new ArrayList<String>();
						System.out.println("Digite quantos ingredientes deseja adicionar");
						int l = scn.nextInt();
						scn.nextLine();
						for(int m = 1; m<=l; m++){
							System.out.println("Digite o nome do proximo ingrediente");
							componentes.add(scn.nextLine());
							Receitas.get(j).editar(nome, componentes);
							Receitas.get(j).calcularPorcentagem(Ingredientes);
						}
					}
					else {
						if(k == 2) 
						{
							List<String> aux = new ArrayList<String>();
							aux = Receitas.get(j).getComponentes();
							System.out.println("Digite o numero de qual Ingrediente deseja r:\n");
							for(String ing : aux) 
							{
								System.out.println(Ingredientes.indexOf(ing) + "-" + ing+"\n");
							}
							int l = scn.nextInt();
							scn.nextLine();
							aux.remove(l);
							Receitas.get(j).setComponentes(aux);
							Receitas.get(j).editar(nome);
							Receitas.get(j).calcularPorcentagem(Ingredientes);
						}
						else 
						{
							Receitas.get(j).editar(nome);
						}
					}
					break;
				}
				case 4://Excluir Receita
				{
					System.out.println("Digite o numero de qual receita deseja excluir:\n");
					listarReceitas(Receitas);
					int j = scn.nextInt();
					scn.nextLine();
					Receitas.remove(j);
					break;
				}
				case 5://Excluir Ingrediente
				{
					System.out.println("Digite o numero de qual Ingrediente deseja excluir:\n");
					listarIngredientes(Ingredientes);
					int j = scn.nextInt();
					scn.nextLine();
					Ingredientes.remove(j);
					for(Receita rcp: Receitas) 
					{
						rcp.calcularPorcentagem(Ingredientes);
					}
					break;
				}
				case 6://Visualizar Ingredientes
				{
					listarIngredientes(Ingredientes);
					break;
				}
				case 7://Visualizar Receitas
				{
					listarReceitas(Receitas);
					break;
				}
			}	
		}while(i != 0);
		
	}
	
}
