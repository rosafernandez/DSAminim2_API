package edu.upc.eetac.dsa.etakemon.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EtakemonCollection {

    private List<Etakemon> etakemons = new ArrayList<>();

    public List<Etakemon> getEtakemons() {
        return etakemons;
    }

    public void setEtakemons(List<Etakemon> etakemons) {
        this.etakemons = etakemons;
    }
}