package br.com.zup.orange.propostas.services;

import br.com.zup.orange.propostas.Model.Biometria;
import br.com.zup.orange.propostas.Model.Cartao;
import br.com.zup.orange.propostas.repository.BiometriaRepository;
import br.com.zup.orange.propostas.repository.CartaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class BiometriaService {

    public boolean checkBase64(String texto){
        var base64Regex = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$";
        return Pattern.matches(base64Regex,texto);
    }

    public ResponseEntity cadastrarBiometria(BiometriaRepository biometriaRepository, CartaoRepository cartaoRepository, String biometria, Long id, UriComponentsBuilder uri){

        Optional<Cartao> cartaoOpt = cartaoRepository.findById(id);

        if (cartaoOpt.isEmpty()) return ResponseEntity.notFound().build();

        if(!checkBase64(biometria)) return ResponseEntity.badRequest().build();
        Biometria novaBiometria = new Biometria(biometria,cartaoOpt.get());
        biometriaRepository.save(novaBiometria);
        URI uriNova = uri.path("/biometria/{id}").buildAndExpand(novaBiometria.getId()).toUri();
        return ResponseEntity.created(uriNova).build();
    }

}
