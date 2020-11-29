package pentalog.hack.controller;

import org.jsoup.Jsoup;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class HackContoller {

    @GetMapping
    public ModelAndView input() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("input");
        return modelAndView;
    }

    @PostMapping(value = "/hack")
    public ModelAndView convert(@RequestParam String palik) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("input");
        String convertedString = Jsoup.parse(palik).text();
        convertedString = convertedString.replaceAll("\\?", "\\?\n");
        convertedString = convertedString.replaceAll(";", ";\n");
        convertedString = convertedString.replaceAll("\\{", "\\{\n");
        convertedString = convertedString.replaceAll("\\}", "\\}\n");
        System.out.println(convertedString);
        return modelAndView;

    }

    List<String> comments;

    {
        comments = new ArrayList<String>();
        comments.add("VALID COMMENT");
    }

    @GetMapping(value = "/comment")
    public void comment(@RequestParam(required = false) String comment, HttpServletResponse res) throws IOException {
        PrintWriter printWriter = res.getWriter();
        System.out.println(comment);
        if (Objects.nonNull(comment)) {
            comments.add(comment);
        }
        comments.forEach(s ->
        {
            printWriter.write("<p>" + s + "</p>");
            printWriter.write("<p>------------------------------------------</p>");

        });

        printWriter.write("<form method=\"get\" action=\"/comment\">" +
                "    <input type=\"text\" name=\"comment\">" +
                "    <button type=\"submit\">submit</button>" +
                "</form>");
//        <script>alert(21);<script>
//        <img src="https://picsum.photos/id/237/200/300" onclick="alert('hacked')">

        List<String> initList = new ArrayList<>();
        initList.add("");

        List<String> secondList = new ArrayList<>(initList);
        initList.add("");
        System.out.println(secondList);
    }

    public static void main(String[] args) throws IOException {

        new URL("http://www.google.com").openConnection().connect();
        new FileWriter(new File("application.properties"));
        System.getProperty("user.dir");

        System.setSecurityManager(new SecurityManager());
        try {
            new URL("http://www.google.com").openConnection().connect();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            new FileWriter(new File("application.properties"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            System.getProperty("user.dir");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class ParentClass {
    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParentClass that = (ParentClass) o;
        return a == that.a;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }
}
