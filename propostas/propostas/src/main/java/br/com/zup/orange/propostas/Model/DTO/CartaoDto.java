package br.com.zup.orange.propostas.Model.DTO;

import java.time.LocalDateTime;
import java.util.List;

public class CartaoDto {

    private String id;
    private LocalDateTime emitidoEm;
    private String titular;

    private List<BloqueioCartaoDto> bloqueios;

    private List<AvisoCartaoDto> avisos;

    private List<CarteirasCartaoDto> carteiras;

    private List<ParcelaCartaoDto> parcelas;

    private Double limite;

    private RenegociacaoCartaoDto renegociacao;

    private VencimentoCartaoDto vencimento;

    private String idProposta;

    public String getId() {
        return id;
    }

    public LocalDateTime getEmitidoEm() {
        return emitidoEm;
    }

    public String getTitular() {
        return titular;
    }

    public List<BloqueioCartaoDto> getBloqueios() {
        return bloqueios;
    }

    public List<AvisoCartaoDto> getAvisos() {
        return avisos;
    }

    public List<CarteirasCartaoDto> getCarteiras() {
        return carteiras;
    }

    public List<ParcelaCartaoDto> getParcelas() {
        return parcelas;
    }

    public Double getLimite() {
        return limite;
    }

    public RenegociacaoCartaoDto getRenegociacao() {
        return renegociacao;
    }

    public VencimentoCartaoDto getVencimento() {
        return vencimento;
    }

    public String getIdProposta() {
        return idProposta;
    }

    public CartaoDto(String id, LocalDateTime emitidoEm, String titular, List<BloqueioCartaoDto> bloqueios, List<AvisoCartaoDto> avisos, List<CarteirasCartaoDto> carteiras, List<ParcelaCartaoDto> parcelas, Double limite, RenegociacaoCartaoDto renegociacao, VencimentoCartaoDto vencimento, String idProposta) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.bloqueios = bloqueios;
        this.avisos = avisos;
        this.carteiras = carteiras;
        this.parcelas = parcelas;
        this.limite = limite;
        this.renegociacao = renegociacao;
        this.vencimento = vencimento;
        this.idProposta = idProposta;
    }

    @Override
    public String toString() {
        return "CartaoDto{" +
                "id='" + id + '\'' +
                ", emitidoEm=" + emitidoEm +
                ", titular='" + titular + '\'' +
                ", bloqueios=" + bloqueios +
                ", avisos=" + avisos +
                ", carteiras=" + carteiras +
                ", parcelas=" + parcelas +
                ", limite=" + limite +
                ", renegociacao=" + renegociacao +
                ", vencimento=" + vencimento +
                ", idProposta='" + idProposta + '\'' +
                '}';
    }
}
