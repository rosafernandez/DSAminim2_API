package edu.upc.eetac.dsa.etakemon.dao;

import edu.upc.eetac.dsa.etakemon.entity.EtakemonCollection;

import java.sql.SQLException;


public interface EtakemonDAO {
    public EtakemonCollection createEtakemon(String tipus, String nom, String descripcio) throws SQLException;
    public EtakemonCollection getEtakemons() throws SQLException;
}