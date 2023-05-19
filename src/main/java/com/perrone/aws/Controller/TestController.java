package com.perrone.aws.Controller;

import com.perrone.aws.entities.Articoli;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/prodotti")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    private List<Articoli> initData()
    {
        List<Articoli> articoli = new ArrayList<Articoli>();

        articoli.add(new Articoli("014600301","BARILLA FARINA 1 KG","PZ",24,1.0,1.09,"Milano"));
        articoli.add(new Articoli("013500121","BARILLA PASTA GR.500 N.70 1/2 PENNE","PZ",30,0.500,1.30,"Roma"));
        articoli.add(new Articoli("007686402","FINDUS FIOR DI NASELLO 300 GR","PZ",8,0.300,6.46,"Milano"));
        articoli.add(new Articoli("057549001","FINDUS CROCCOLE 400 GR","PZ",12,0.400,5.97,"Cosenza"));
        articoli.add(new Articoli("002000301","ACQUA ULIVETO 15 LT","PZ",6,1.5,0.87,"Cosenza"));
        articoli.add(new Articoli("002307701","ACQUA FERRARELLE 15 LT","PZ",6,1.5,0.87,"Napoli"));
        articoli.add(new Articoli("012300344","ACQUA SANGEMINI 15 LT","PZ",6,1.5,0.87,"Cosenza"));
        articoli.add(new Articoli("032070388","BUITONI PIZZA REGINA 250 GR","PZ",12,3.0,12.56,"Cosenza"));
        articoli.add(new Articoli("014600301","BARILLA RIGATONI 1 KG","PZ",24,1.0,1.09,"Milano"));
        articoli.add(new Articoli("014600301","BARILLA FARFALLE 1 KG","PZ",24,1.0,1.09,"Napoli"));

        return articoli;
    }

    @GetMapping(value = "/cerca/codice/{codart}", produces = "application/json")
    public ResponseEntity<Articoli> listArtByCodArt(@PathVariable("codart") String CodArt)
    {
        logger.info("****** Otteniamo l'articolo con codice " + CodArt + " *******");


        List<Articoli> articolo = this.initData()
                .stream()
                .filter(u -> u.getCodArt().equals(CodArt))
                .collect(Collectors.toList());


        return new ResponseEntity<Articoli>(articolo.get(0), HttpStatus.OK);

    }

    @RequestMapping(value = "/cerca/descrizione/{filter}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Articoli>> listArtByDesc(@PathVariable("filter") String Filter)
    {
        logger.info("****** Otteniamo l'articolo con descrizione " + Filter + " *******");

        List<Articoli> articoli = this.initData()
                .stream()
                .filter(u -> u.getDescrizione().toUpperCase().contains(Filter.toUpperCase()))
                .collect(Collectors.toList());

        return new ResponseEntity<List<Articoli>>(articoli, HttpStatus.OK);

    }
    @GetMapping(value = "/cerca/localita/{filter}", produces = "application/json")
    public ResponseEntity<List<Articoli>> listByLocalità (@PathVariable("filter") String Filtro)
    {
        logger.info("****** Otteniamo l'articolo presso il deposito di provenienza " + Filtro + " *****");

        List<Articoli> articoli = this.initData()
                .stream()
                .filter(u -> u.getLocalita().toUpperCase().contains(Filtro.toUpperCase()))
                .collect(Collectors.toList());

        return  new ResponseEntity<List<Articoli>>(articoli,HttpStatus.OK);

    }
}
