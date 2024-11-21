package org.laylagomez.first_api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/saludar")
public class FirstController {

    @GetMapping
    public String saludar() {
        return "Hola";
    }

    @PostMapping
    public String saludar2(@RequestBody String name){
        return "Hola por post" + name;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        return "Quieres eliminar el recurso " + id;
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody String name) {
        return id + "Cambiar nombre por: " + name;
    }
}
