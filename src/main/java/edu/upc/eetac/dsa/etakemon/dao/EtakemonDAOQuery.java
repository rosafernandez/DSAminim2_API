package edu.upc.eetac.dsa.etakemon.dao;

public interface EtakemonDAOQuery {
    public final static String CREATE_ETAKEMON = "insert into etakemon (tipus, nom, descripcio, puntuacio) values (?, ?, ?, ?)";
    public final static String GET_ETAKEMONS = "select * from etakemon";
}