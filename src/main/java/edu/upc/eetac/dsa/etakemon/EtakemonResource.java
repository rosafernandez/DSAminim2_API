package edu.upc.eetac.dsa.etakemon;

import edu.upc.eetac.dsa.etakemon.dao.EtakemonDAO;
import edu.upc.eetac.dsa.etakemon.dao.EtakemonDAOImpl;
import edu.upc.eetac.dsa.etakemon.entity.Etakemon;
import edu.upc.eetac.dsa.etakemon.entity.EtakemonCollection;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

@Path("etakemon")
public class EtakemonResource {
    @Context
    private SecurityContext securityContext;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(EtakemonMediaType.ETAKEMON_COLLECTION)
    public EtakemonCollection createEtakemon(@FormParam("tipus") String tipus, @FormParam("nom") String nom, @FormParam("descripcio") String descripcio) throws URISyntaxException {
        if(tipus == null || nom == null || descripcio == null)
            throw new BadRequestException("all parameters are mandatory");
        EtakemonDAO etakemonDAO = new EtakemonDAOImpl();
        EtakemonCollection etakemonCollection = null;
        try {
            etakemonCollection = etakemonDAO.createEtakemon(tipus, nom, descripcio);
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }
        return etakemonCollection;
    }

    @GET
    @Produces(EtakemonMediaType.ETAKEMON_COLLECTION)
    public EtakemonCollection getAllEtakemons() {
        EtakemonCollection etakemonCollection = null;
        EtakemonDAO etakemonDAO = new EtakemonDAOImpl();
        try {
            etakemonCollection = etakemonDAO.getEtakemons();
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }
        return etakemonCollection;
    }
}