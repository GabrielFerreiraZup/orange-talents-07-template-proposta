package br.com.zup.orange.propostas.Model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BiometriaDto {

    private String biometria;



    public String getBiometria() {
        return biometria;
    }

    public BiometriaDto(@JsonProperty("biometria") String biometria) {
        this.biometria = biometria;
    }
}
