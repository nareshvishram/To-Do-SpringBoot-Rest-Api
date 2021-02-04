package com.binarybeast.todoapi.in.errorhandler;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorHandler implements ErrorController {
    @Override
    @RequestMapping("/error")
    public String getErrorPath() {
        return "<center><h1>This path doesn't exist. <hr><br><br>Try <b><i>my_todo/menu</i><b> </h1></center>";
    }
}
