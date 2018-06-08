package example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class MainController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/jquery-3.3.1.js")
    public String jquery() {
        return "jquery-3.3.1.js";
    }

    @GetMapping("/code.js")
    public String code() {
        return "code.js";
    }

    @GetMapping("/task1")
    public String task1(@RequestParam(name = "word") String word, Model model) throws SQLException {
        model.addAttribute("wordSign", word);
        DataAccess data = new DataAccess();
        data.LoadList();
        return "task1template";

    }

    @PostMapping("/join")
    @ResponseBody

    public String join(@RequestParam(name = "user") String user, @RequestParam(name = "pass") String pass) throws SQLException {
        DataAccess data = new DataAccess();
        data.createUser(user, pass);
        return "";
    }

    @GetMapping("/get_msg")
    @ResponseBody

    public String get_msg() throws SQLException {
        return "";
    }

    @GetMapping("/list_users")
    @ResponseBody

    public ArrayList<String> list_users() throws SQLException {
        DataAccess data = new DataAccess();
        ArrayList<String> u = data.getAllUser();
        return u;
    }

    @GetMapping("/post_msg")
    @ResponseBody

    public String post_msg(@RequestParam(name = "msg") String msg) throws SQLException {
        return "";
    }
}