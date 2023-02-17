package entidades;

public class ProdutoImportado extends Produto {
	private Double taxa;
	
	public ProdutoImportado() {
		super();
	}

	public ProdutoImportado(String nome, Double preco, Double taxa) {
		super(nome, preco);
		this.taxa = taxa;
	}
	
	public Double getTaxa_cliente() {
		return taxa;
	}

	public void setTaxa_cliente(Double taxa) {
		this.taxa = taxa;
	}

	public Double precoTotal() {
		return (getPreco() + taxa);
	}
	
	@Override
	public String etiquetaPreco() {
		return String.format("%s R$%.2f (Taxa do cliente: R$%.2f)", getNome(), precoTotal(), taxa);
	}
}
