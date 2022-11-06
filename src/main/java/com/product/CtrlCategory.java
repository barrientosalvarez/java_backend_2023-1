package com.product;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class CtrlCategory{
    
    @GetMapping("/category")
    public String categories(){
        CategoryManager categorias=new CategoryManager();
        categorias.createCategory("1", "Computadora");
        categorias.createCategory("2", "Laptop");
        categorias.createCategory("3", "Automovil");
        categorias.createCategory("4", "Avion");
        categorias.createCategory("5", "Barco");
        categorias.createCategory("6", "Nuclear");
        categorias.createCategory("7", "Medicamento");
        categorias.createCategory("8", "Recordatorio");
        return categorias.getCategories();
    }
    
}
