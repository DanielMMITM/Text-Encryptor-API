package encriptador.springframework.springencriptadorwebapp.controller;

import encriptador.springframework.springencriptadorwebapp.service.DecryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/decrypt")
public class DecryptController {
    @Autowired
    private DecryptService service;

    @GetMapping("{text}/{columnsNumber}")
    @ResponseStatus(HttpStatus.OK)
    public String decryptByColumn(@PathVariable String text, @PathVariable int columnsNumber){
        return service.columnDecrypt(text, columnsNumber);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String decryptByKey(@RequestParam(value = "text") String text, @RequestParam(value = "key") String key){
        return service.keyDecrypt(text, key);
    }
}
