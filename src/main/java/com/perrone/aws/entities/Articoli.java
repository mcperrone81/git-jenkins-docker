package com.perrone.aws.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Articoli implements Serializable {
    private String codArt;
    private String descrizione;
    private String um;
    private String codStat;
    private Integer pzCart;
    private double pesoNetto;
    private String idStatoArt;
    private Date dataCreaz;
    private double prezzo;
    private String localita;

    public Articoli(String codArt, String descrizione, String um, Integer pzCart, double pesoNetto, double prezzo, String localita) {
        this.codArt = codArt;
        this.descrizione = descrizione;
        this.um = um;
        this.pzCart = pzCart;
        this.pesoNetto = pesoNetto;
        this.prezzo = prezzo;
        this.localita = localita;
    }
}
