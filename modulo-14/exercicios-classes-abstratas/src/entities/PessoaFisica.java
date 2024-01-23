package entities;

public class PessoaFisica extends Pessoa{
    private final double IMPOSTO_BAIXA_RENDA = 0.15;
    private final double IMPOSTO_RENDA_MEDIA_ALTA = 0.25;

    private double gastosSaude;

    public PessoaFisica(String nome, double rendaAnual, double gastosSaude) {
        super(nome, rendaAnual);
        this.gastosSaude = gastosSaude;
    }

    @Override
    public double calcularImpostos() {
        double imposto = 0.0;

        if(this.getRendaAnual() < 20000.0){
            imposto = this.getRendaAnual() * IMPOSTO_BAIXA_RENDA;
        }else{
            imposto = this.getRendaAnual() * IMPOSTO_RENDA_MEDIA_ALTA;
        }

        if(this.gastosSaude != 0){
            imposto -= this.gastosSaude * 0.5;
        }

        return imposto;
    }
}
