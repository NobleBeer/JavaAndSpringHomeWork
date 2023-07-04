package presentationLayer;

import businessLayer.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import configureLayer.Note;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
@WebServlet("/api/note/*")
public class ApiNodeIdServlet extends HttpServlet {
    Service service;

    static ObjectMapper mapper = new ObjectMapper();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Long id = (long) Integer.parseInt(request.getPathInfo().substring(1));

        System.out.println(id);

        Optional<Note> returnNotes = service.getIdNotes(id);

        if(returnNotes.isPresent()) {
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_OK);
            String json = mapper.writeValueAsString(returnNotes.get());
            PrintWriter write = new PrintWriter(response.getWriter());
            write.write(json);
            write.flush();
            write.close();
        }
        else {
            response.setContentType("text/plain");
            response.setStatus(HttpServletResponse.SC_OK);
            PrintWriter write = new PrintWriter(response.getWriter());
            write.write("no note");
            write.flush();
            write.close();
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {

        Long id = (long) Integer.parseInt(request.getPathInfo().substring(1));

        service.delete(id);

        response.setStatus(HttpServletResponse.SC_OK);
    }

    public void setService(Service service) {
        this.service = service;
    }
}
