package edu.upc.eetac.dsa.etakemon.dao;

import edu.upc.eetac.dsa.etakemon.entity.Etakemon;
import edu.upc.eetac.dsa.etakemon.entity.EtakemonCollection;

import java.sql.*;


public class EtakemonDAOImpl implements EtakemonDAO {

    @Override
    public EtakemonCollection createEtakemon(String tipus, String nom, String descripcio) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();
            stmt = connection.prepareStatement(EtakemonDAOQuery.CREATE_ETAKEMON);

            stmt.setString(1, tipus);
            stmt.setString(2, nom);
            stmt.setString(3, descripcio);
            stmt.setInt(4, Etakemon.getPuntuacioPerTipus(tipus));
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }
        return getEtakemons();
    }

    @Override
    public EtakemonCollection getEtakemons() throws SQLException {
        EtakemonCollection etakemonCollection = new EtakemonCollection();

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();
            stmt = connection.prepareStatement(EtakemonDAOQuery.GET_ETAKEMONS);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Etakemon etakemon = new Etakemon();
                etakemon.setId(rs.getInt("id"));
                etakemon.setTipus(rs.getString("tipus"));
                etakemon.setNom(rs.getString("nom"));
                etakemon.setDescripcio(rs.getString("descripcio"));
                etakemon.setPuntuacio(rs.getInt("puntuacio"));
                etakemonCollection.getEtakemons().add(etakemon);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return etakemonCollection;
    }

}