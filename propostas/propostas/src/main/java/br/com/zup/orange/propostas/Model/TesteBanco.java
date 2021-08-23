package br.com.zup.orange.propostas.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class TesteBanco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String test;

    public Long getId() {
        return id;
    }

    public String getTest() {
        return test;
    }

    public TesteBanco() {
    }

    public TesteBanco(String test) {
        this.test = test;
    }
}
