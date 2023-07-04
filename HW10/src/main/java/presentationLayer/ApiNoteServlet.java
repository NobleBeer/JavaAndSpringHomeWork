package presentationLayer;

import businessLayer.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import configureLayer.AllNotes;
import configureLayer.Note;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet("/api/note")
public class ApiNoteServlet extends HttpServlet {

    Service service;

    public void setService(Service service) {
        this.service = service;
    }

    static ObjectMapper mapper = new ObjectMapper();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        String addTo;
//        addTo = reader.lines().collect(Collectors.joining());

        while((addTo = reader.readLine()) != null) {
            sb.append(addTo);
        }

        try {
            Note note = mapper.readValue(sb.toString(), Note.class);
            service.insertNote(note);
            response.setStatus(HttpServletResponse.SC_CREATED);
            String json = mapper.writeValueAsString(note);
            response.setContentType("application/json");
            PrintWriter write = new PrintWriter(response.getWriter());
            write.write(json);
            write.flush();
            write.close();
        } catch (Exception e) {
            System.out.println("i am stupid");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Optional<List<Note>> returnNotes = service.getAllNotes();

        if(returnNotes.isPresent()) {
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_OK);
            AllNotes allNotes = new AllNotes(returnNotes.get());
            String json = mapper.writeValueAsString(allNotes);
            PrintWriter write = new PrintWriter(response.getWriter());
            write.write(json);
            write.flush();
            write.close();
        }
    }
}
