package entities;
import java.util.*;
public class Receita {
	
	private String nome;
	private List<String> componentes = new ArrayList<String>();
	private int quantidadecomponentes;
	private double porcentagem = 0;
	
	
	public Receita(String nome, List<String> componentes, int quantidadecomponentes) {
		super();
		this.nome = nome;
		this.componentes = componentes;
		this.quantidadecomponentes = quantidadecomponentes;
	}


	public double getPorcentagem() {
		return porcentagem;
	}


	public void setPorcentagem(int porcentagem) {
		this.porcentagem = porcentagem;
	}


	public int getQuantidadeComponentes() {
		return quantidadecomponentes;
	}


	public void setQuantidadeComponentes(int quantidadecomponentes) {
		this.quantidadecomponentes = quantidadecomponentes;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public List<String> getComponentes() {
		return componentes;
	}


	public void setComponentes(List<String> componentes) {
		this.componentes = componentes;
	}
	
	public void calcularPorcentagem(List<String> Ingredientes) {
		double aux = 0;
		System.out.println(Ingredientes);
		for(String ing: Ingredientes)
		{
			for(String cmp: this.componentes)
			{
				if(cmp.equals(ing)) 
				{
					aux++;
					break;
				}
			}
		}
		System.out.println(aux);
		System.out.println(this.componentes.size());
		System.out.println(aux/this.componentes.size());
		this.porcentagem = (aux/this.componentes.size())*100;
		this.porcentagem = Math.round(this.porcentagem * 100) / 100d;
		System.out.println(this.porcentagem);
	}

	public void editar(String nome) {
		this.nome = nome;
	}
	
	public void editar(String nome, List<String> componentes) {
		this.nome =  nome;
		this.componentes.addAll(componentes);
	}

	@Override
	public String toString() {
		return "Receita [nome=" + nome + ", componentes=" + componentes + ", porcentagem=" + porcentagem + "%]";
	}
	
	
}
