package configureLayer;

import businessLayer.Service;
import dataLayer.NotesRepository;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import presentationLayer.ApiNodeIdServlet;
import presentationLayer.ApiNoteServlet;

public class MainServer {

    private Server server;

    public void start() {
        int port = 8082;
        Server server = new Server(port);
        NotesRepository repository = new NotesRepository();
        Service service = new Service();
        service.setNotesRepository(repository);

        var apiNoteServlet = new ApiNoteServlet();
        apiNoteServlet.setService(service);

        var apiNodeIdServlet = new ApiNodeIdServlet();
        apiNodeIdServlet.setService(service);

        ServletContextHandler handler = new ServletContextHandler(server, "/");
        handler.addServlet(new ServletHolder(apiNoteServlet), "/api/note");
        handler.addServlet(new ServletHolder(apiNodeIdServlet), "/api/note/*");
        try {
            server.start();
            System.out.println("Начинаем массовое орание");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
