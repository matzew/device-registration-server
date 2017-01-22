package net.wessendorf.wildfly.swarm.httpserver.rest;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

/**
 * Created by matzew on 1/22/17.
 */
public class Server {

    public static void main(String... args) throws Exception {
        final Swarm swarm = new Swarm();

        // Create one or more deployments
        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);

        // Add resource to deployment
        deployment.addClass(DeviceRegistryResource.class);
        deployment.addAllDependencies();

        swarm.start();
        swarm.deploy(deployment);
    }
}
