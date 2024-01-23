package entities;

public class PessoaJuridica extends Pessoa{
    private final double IMPOSTO_PEQUENA_EMPRESA = 0.16;
    private final double IMPOSTO_MEDIA_EMPRESA = 0.14;

    private int numeroFuncionarios;

    public PessoaJuridica(String nome, double rendaAnual, int numeroFuncionarios) {
        super(nome, rendaAnual);
        this.numeroFuncionarios = numeroFuncionarios;
    }

    @Override
    public double calcularImpostos() {
        if(this.numeroFuncionarios > 10){
            return this.getRendaAnual() * IMPOSTO_MEDIA_EMPRESA;
        }

        return this.getRendaAnual() * IMPOSTO_PEQUENA_EMPRESA;
    }

    public int getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(int numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }
}
