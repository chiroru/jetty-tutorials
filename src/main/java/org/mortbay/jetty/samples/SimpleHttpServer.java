package org.mortbay.jetty.samples;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;

public class SimpleHttpServer {

    static private final int PORT_NO = 8080;
    static private final String[] WELCOME_FILES = {"index.html"};

    public static void main(String[] args) throws Exception {
        Server server = new Server(PORT_NO);
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setWelcomeFiles(WELCOME_FILES);
        resourceHandler.setResourceBase(".");
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] {resourceHandler, new DefaultHandler()});
        server.setHandler(handlers);
        server.start();
        server.join();
    }
}
