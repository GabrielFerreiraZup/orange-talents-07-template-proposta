package br.com.zup.orange.propostas.Model;

import br.com.zup.orange.propostas.enums.BloqueioEnum;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idInterno;
    //talvez refatorar pra receber proposta
    private String idProposta;

    //private boolean bloqueado = false;
    //refatorar com bloqueio como enum
    private BloqueioEnum bloqueio;
    private LocalDateTime horaBloqueio;

    private String ipCliente;

    private String userAgentCliente;

    @OneToMany
    private List<Carteira> carteiras = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public String getIdInterno() {
        return idInterno;
    }

    public String getIdProposta() {
        return idProposta;
    }

    public BloqueioEnum getBloqueio() {
        return bloqueio;
    }

    public void setBloqueio(BloqueioEnum bloqueio) {
        this.bloqueio = bloqueio;
    }

    public LocalDateTime getHoraBloqueio() {
        return horaBloqueio;
    }

    public void setHoraBloqueio(LocalDateTime horaBloqueio) {
        this.horaBloqueio = horaBloqueio;
    }

    public String getIpCliente() {
        return ipCliente;
    }

    public void setIpCliente(String ipCliente) {
        this.ipCliente = ipCliente;
    }

    public String getUserAgentCliente() {
        return userAgentCliente;
    }

    public void setUserAgentCliente(String userAgentCliente) {
        this.userAgentCliente = userAgentCliente;
    }

    public List<Carteira> getCarteiras() {
        return carteiras;
    }

    public void setCarteiras(List<Carteira> carteiras) {
        this.carteiras = carteiras;
    }

    @Deprecated
    public Cartao() {
    }

    public Cartao(String idInterno, String idProposta) {
        this.idInterno = idInterno;
        this.idProposta = idProposta;
        this.bloqueio = BloqueioEnum.NAO_BLOQUEADO;

    }



}

