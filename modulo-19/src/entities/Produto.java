package entities;

import java.util.Objects;

public class Produto implements Comparable<Produto> {

    private String nome;
    private Double preco;

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Produto)) return false;
//        Produto produto = (Produto) o;
//        return Objects.equals(nome, produto.nome) && Objects.equals(preco, produto.preco);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(nome, preco);
//    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }

//    @Override
//    public int compareTo(Produto produto) {
//        return preco.compareTo(produto.getPreco());
//    }

    @Override
    public int compareTo(Produto produto) {
        return nome.toUpperCase().compareTo(produto.getNome().toUpperCase());
    }
}
