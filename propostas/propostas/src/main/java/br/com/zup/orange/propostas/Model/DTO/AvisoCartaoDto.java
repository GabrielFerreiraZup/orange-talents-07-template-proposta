package br.com.zup.orange.propostas.Model.DTO;

import java.time.LocalDate;

public class AvisoCartaoDto {

    private LocalDate validoAte;
    private String destino;

    public LocalDate getValidoAte() {
        return validoAte;
    }

    public String getDestino() {
        return destino;
    }

    public AvisoCartaoDto(LocalDate validoAte, String destino) {
        this.validoAte = validoAte;
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "AvisoCartaoDto{" +
                "validoAte=" + validoAte +
                ", destino='" + destino + '\'' +
                '}';
    }
}
