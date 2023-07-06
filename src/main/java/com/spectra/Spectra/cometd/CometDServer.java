//package com.spectra.Spectra.cometd;
//
//import org.cometd.bayeux.server.BayeuxServer;
//import org.cometd.server.BayeuxServerImpl;
//import org.eclipse.jetty.server.Server;
//import org.eclipse.jetty.servlet.ServletContextHandler;
//import org.eclipse.jetty.servlet.ServletHolder;
//import org.eclipse.jetty.websocket.server.WebSocketUpgradeFilter;
//
//public class CometDServer {
//    public static void main(String[] args) throws Exception {
//        Server server = new Server(8080);
//
//        // CometD servlet 설정
//        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
//        context.setContextPath("/");
//        server.setHandler(context);
//
//        // CometD 서버 초기화
//        BayeuxServer bayeuxServer = new BayeuxServerImpl();
////        bayeuxServer.addTransport(new HttpTransport(bayeuxServer));
//        bayeuxServer.addTransport(new org.cometd.server.transport.LongPollingTransport(bayeuxServer));
//
//        // CometD servlet 등록
//        ServletHolder cometdServletHolder = new ServletHolder("cometd", new org.cometd.server.CometDServlet());
//        cometdServletHolder.setInitParameter("transports", "org.cometd.websocket.server.WebSocketTransport");
//        cometdServletHolder.setInitParameter("ws.cometdURLMapping", "/cometd/*");
//        context.addServlet(cometdServletHolder, "/cometd/*");
//
//        // Jetty WebSocket Upgrade 필터 등록
//        WebSocketUpgradeFilter webSocketUpgradeFilter = WebSocketUpgradeFilter.configureContext(context);
//        webSocketUpgradeFilter.getFactory().getPolicy().setIdleTimeout(10000);
//        webSocketUpgradeFilter.addMapping((servletPath, pathParams, request) -> true, factory);
//
//        server.start();
//        server.join();
//    }
//}
