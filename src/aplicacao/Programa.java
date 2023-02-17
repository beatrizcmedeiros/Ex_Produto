package aplicacao;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Produto;
import entidades.ProdutoImportado;
import entidades.ProdutoUsado;

public class Programa {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws ParseException {
		cadastrarProduto();
		sc.close();
	}

	private static void cadastrarProduto() throws ParseException {
		Produto produto = new Produto();
		List<Produto> produtos = new ArrayList<>();
		int numero_produtos;
		
		System.out.print("Informe o número de produtos que são cadastrados: ");
		numero_produtos = sc.nextInt();
		
		for(int i = 1; i <= numero_produtos; i++) {
			String tipo_produto;
			String nome;
			Double preco = 0.0;
			
			System.out.printf("\nDados do produto %d: ", i);
			System.out.print("\nQual o tipo do produto? Comum, importado ou usado (c / i / u)? ");
			tipo_produto = sc.next();
			System.out.print("Nome: ");
			sc.nextLine();
			nome = sc.nextLine();
			System.out.print("Preço: ");
			preco = sc.nextDouble();
			
			if(tipo_produto.equalsIgnoreCase("c")) 
				produto = new Produto(nome, preco);
			if(tipo_produto.equalsIgnoreCase("i")) {
				System.out.print("Informe a taxa: ");
				Double taxa = sc.nextDouble();
				produto = new ProdutoImportado(nome, preco, taxa);
			}
			if(tipo_produto.equalsIgnoreCase("u")) {
				System.out.println("Data de fabricação: ");
				LocalDate data_fabricacao = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				produto = new ProdutoUsado(nome, preco, data_fabricacao);
			}
			produtos.add(produto);
		}
		
		imprimeEtiquetasPreco(produtos);
	}

	public static void imprimeEtiquetasPreco(List<Produto> produtos) {
		System.out.print("\nTAGS DE PREÇO");
		for(Produto p : produtos) {
			System.out.printf("\n%s", p.etiquetaPreco());
		}
	}
	
}//class Programa
