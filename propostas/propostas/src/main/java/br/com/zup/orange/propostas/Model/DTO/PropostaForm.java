package br.com.zup.orange.propostas.Model.DTO;

import br.com.zup.orange.propostas.Model.Proposta;
import br.com.zup.orange.propostas.validation.CpfOrCnpj;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PropostaForm {

    @CpfOrCnpj
    @NotBlank
    private String cpfOuCnpj;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String endereco;
    @Positive
    @NotNull
    private Double salario;

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public Double getSalario() {
        return salario;
    }

    public PropostaForm(String cpfOuCnpj, String email, String nome, String endereco, Double salario) {
        this.cpfOuCnpj = cpfOuCnpj;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
    }

    public Proposta converter(){
        return new Proposta(this.cpfOuCnpj,
                            this.email,
                            this.nome,
                            this.endereco,
                            this.salario);
    }

}
