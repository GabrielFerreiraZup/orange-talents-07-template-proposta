package br.com.zup.orange.propostas.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class AvisoViagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cartao cartao;
    @NotNull
    private String destinoViagem;
    @NotNull
    private LocalDate terminoViagem;

    private LocalDateTime horaAviso;

    private String ipCliente;

    private  String userAgent;

    public Cartao getCartao() {
        return cartao;
    }

    public String getDestinoViagem() {
        return destinoViagem;
    }

    public LocalDate getTerminoViagem() {
        return terminoViagem;
    }

    public LocalDateTime getHoraAviso() {
        return horaAviso;
    }

    public String getIpCliente() {
        return ipCliente;
    }

    public String getUserAgent() {
        return userAgent;
    }
    @Deprecated
    public AvisoViagem() {
    }

    public AvisoViagem(Cartao cartao, String destinoViagem, LocalDate terminoViagem, String ipCliente, String userAgent) {
        this.cartao = cartao;
        this.destinoViagem = destinoViagem;
        this.terminoViagem = terminoViagem;
        this.horaAviso = LocalDateTime.now();
        this.ipCliente = ipCliente;
        this.userAgent = userAgent;
    }
}
