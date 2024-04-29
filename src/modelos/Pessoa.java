
package modelos;

public class Pessoa {
    
    String cpf, nome, sobrenome;
    
    public Pessoa(String cpf, String nome, String sobrenome) {
        this.nome = nome;
        this.cpf = cpf;
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "cpf=" + cpf + ", nome=" + nome + ", sobrenome=" + sobrenome + '}';
    }
    
}
