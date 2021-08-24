package br.com.zup.orange.propostas.Model.DTO;

import br.com.zup.orange.propostas.Model.Proposta;

public class PropostaDto {

    private String cpfOuCnpj;

    private String email;

    private String nome;

    private String endereco;

    private Double salario;

    private String restricao;

    private String idCartao;

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

    public String getRestricao() {
        return restricao;
    }

    public String getIdCartao() {
        return idCartao;
    }

    public PropostaDto(String cpfOuCnpj, String email, String nome, String endereco, Double salario, String restricao, String idCartao) {
        this.cpfOuCnpj = cpfOuCnpj;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
        this.restricao = restricao;
        this.idCartao = idCartao;
    }

    public PropostaDto(Proposta proposta){
        this.cpfOuCnpj = proposta.getCpfOuCnpj();
        this.email = proposta.getEmail();
        this.nome = proposta.getNome();
        this.endereco = proposta.getEndereco();
        this.salario = proposta.getSalario();
        this.restricao = proposta.getRestricao();
        this.idCartao = proposta.getIdCartao();
    }

}
