package servlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import service.InMemoryService;

import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

    public class UserServlet extends HttpServlet{
        private InMemoryService inMemoryService=new InMemoryService();
        private ObjectMapper objectMapper=new ObjectMapper();

        protected void doGet(HttpServletRequest request,HttpServletResponse  response)throws IOException{
            List<User> users= inMemoryService.listUsers();
            response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(users));
        }
        protected void doPost(HttpServletRequest request,HttpServletResponse  response)throws IOException {
            User user = objectMapper.readValue(request.getReader(), User.class);
            inMemoryService.insert(user);
        }
    }

