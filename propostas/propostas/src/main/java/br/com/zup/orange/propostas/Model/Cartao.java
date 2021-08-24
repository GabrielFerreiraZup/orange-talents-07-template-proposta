package br.com.zup.orange.propostas.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idInterno;

    private String idProposta;

    public Long getId() {
        return id;
    }

    public String getIdInterno() {
        return idInterno;
    }

    public String getIdProposta() {
        return idProposta;
    }
    @Deprecated
    public Cartao() {
    }

    public Cartao(String idInterno, String idProposta) {
        this.idInterno = idInterno;
        this.idProposta = idProposta;
    }
}
