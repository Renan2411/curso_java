package entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class Usuario {

    private String nome;
    private LocalDateTime dataAcesso;

    public Usuario(String nome, LocalDateTime dataAcesso) {
        this.nome = nome;
        this.dataAcesso = dataAcesso;
    }

    @Override
    public boolean equals(Object object) {
        if (Objects.isNull(object) || object.getClass() != getClass())
            return false;

        return this.nome.equals(((Usuario) object).getNome());
    }

    @Override
    public int hashCode() {
        return this.nome.hashCode();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataAcesso() {
        return dataAcesso;
    }

    public void setDataAcesso(LocalDateTime dataAcesso) {
        this.dataAcesso = dataAcesso;
    }
}
