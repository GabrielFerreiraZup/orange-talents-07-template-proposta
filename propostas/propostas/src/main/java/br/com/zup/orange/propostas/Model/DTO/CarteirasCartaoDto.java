package br.com.zup.orange.propostas.Model.DTO;

import java.time.LocalDateTime;

public class CarteirasCartaoDto {

    private String id;
    private String email;
    private LocalDateTime associadaEm;
    private String emissor;

    public CarteirasCartaoDto(String id, String email, LocalDateTime associadaEm, String emissor) {
        this.id = id;
        this.email = email;
        this.associadaEm = associadaEm;
        this.emissor = emissor;
    }

    @Override
    public String toString() {
        return "CarteirasCartaoDto{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", associadaEm=" + associadaEm +
                ", emissor='" + emissor + '\'' +
                '}';
    }
}
