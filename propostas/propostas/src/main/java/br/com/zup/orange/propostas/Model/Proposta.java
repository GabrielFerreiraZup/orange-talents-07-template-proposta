package br.com.zup.orange.propostas.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Proposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String cpfOuCnpj;
    @NotBlank
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String endereco;
    @NotNull
    private Double salario;

    private String restricao;

    private String idCartao;

    public Long getId() {
        return id;
    }

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

    public String getIdCartao() {
        return idCartao;
    }

    public void setRestricao(String restricao) {
        this.restricao = restricao;
    }

    public void setIdCartao(String idCartao) {
        this.idCartao = idCartao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Deprecated
    public Proposta() {
    }

    public Proposta(String cpfOuCnpj, String email, String nome, String endereco, Double salario) {
        this.cpfOuCnpj = cpfOuCnpj;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
    }
}
