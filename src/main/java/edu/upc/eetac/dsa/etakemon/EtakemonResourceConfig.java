package edu.upc.eetac.dsa.etakemon;

import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

public class EtakemonResourceConfig extends ResourceConfig {
    public EtakemonResourceConfig() {
        packages("edu.upc.eetac.dsa.etakemon");
        //packages("edu.upc.eetac.dsa.etakemon.auth");
        packages("edu.upc.eetac.dsa.etakemon.cors");
        register(RolesAllowedDynamicFeature.class);
        register(DeclarativeLinkingFeature.class);
    }
}

