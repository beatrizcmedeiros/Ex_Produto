package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoUsado extends Produto  {
	private LocalDate  data_fabricacao;
	
	public ProdutoUsado() {
		super();
	}

	public ProdutoUsado(String nome, Double preco, LocalDate data_fabricacao) {
		super(nome, preco);
		this.data_fabricacao = data_fabricacao;
	}

	public LocalDate getData_manufatura() {
		return data_fabricacao;
	}

	public void setData_manufatura(LocalDate data_fabricacao) {
		this.data_fabricacao = data_fabricacao;
	}
	
	@Override
	public String etiquetaPreco() {
		return String.format("%s (usado) R$%.2f (Data de fabricação: %s)",  super.getNome(), super.getPreco(), data_fabricacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}
}
