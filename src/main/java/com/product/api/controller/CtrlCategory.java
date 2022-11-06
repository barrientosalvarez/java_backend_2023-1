package com.product.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.entity.Category;

/**
 * Clase controlador para las categorías.
 */
@RestController
@RequestMapping("/category")
public class CtrlCategory{

    /** Lista donde se guardarán las categorías que se van a crear. */
    private static List<Category> categorias=new ArrayList<>();
    
    /**
     * Muestra todas las categorías escritas a mano y guardadas en la variable 
     * estática 'categorias'.
     * @return un objeto ResponseEntity con la lista de categorias y un estatus 
     * positivo de http: 'OK'.
     */
    @GetMapping
    public ResponseEntity<List<Category>> getCategories(){
        if(categorias.isEmpty()){
            Category cat1=new Category(1, "Auto", 1);
            Category cat2=new Category(2, "Nave", 1);
            Category cat3=new Category(3, "Avion", 1);
            Category cat4=new Category(4, "Barco", 1);
            Category cat5=new Category(5, "Motocicleta", 1);
            categorias.add(cat1);
            categorias.add(cat2);
            categorias.add(cat3);
            categorias.add(cat4);
            categorias.add(cat5);
        }

        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    /**
     * Nos permite ver el identificador de una categoría, el identificador es 
     * 'recibido' através del url path.
     * @param category_id identificador de la categoría a la cual se querra acceder
     * en un futuro.
     * @return un objeto ResponseEntity con el identificador recibido y un estatus
     * positivo de http: OK.
     */
    @GetMapping("/{category_id}")
    public ResponseEntity<Integer> getCategory(@PathVariable Integer category_id){
        return new ResponseEntity<>(category_id, HttpStatus.OK);
    }

    /**
     * Metodo auxiliar que nos dice si dos categorias son equivalentes. Implementado
     * debido al error de funcionamiento del método equals sobreescrito en la clase
     * 'Category'.
     * @param cat una categoría.
     * @param c otra categoría.
     * @return <code>true</code> si ambas categorías recibidas son equivalentes 
     * (coinciden en identificador y categoría), <code>false</code> en otro caso.
     */
    private static boolean esIgual(Category cat, Category c){
        if(cat.getCategory_id()!=c.getCategory_id())
            return false;

        if(!(cat.getCategory().equals(c.getCategory())))
            return false;

        return true;
    }

    /**
     * Nos permite hacer la simulación de haber creado una nueva categoría.
     * @param c la categoría que se quiere 'crear'.
     * @return un objeto ResponseEntity con un mensaje y un estatus de html:
     * si la categoría que recibe el método no existe en la lista de categorías 
     * 'categorias', se regresa un estatus positivo de html (OK) y un mensaje que 
     * indica que la categoría fue creada. Si la categoría que recibe el método
     * ya existia, se regresa un estatus negativo de html (BAD_REQUEST) y un
     * mensaje que indica que la categoría que se quizo crear ya existía.
     */
    @PostMapping
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category c){
        String mensaje="category created";
        for(Category cat : categorias){
            if(esIgual(cat,c)){
                mensaje="category already exist";
                return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    /**
     * Nos permite hacer la simulación de haber actualizado una categoría.
     * @param c la categoría que se quiere 'actualizar'.
     * @return un objeto ResponseEntity con un mensaje y un estatus de html:
     * si la categoría que recibe el método no existe en la lista de categorías 
     * 'categorias', se regresa un status negativo de html (bad_request) y un 
     * mensaje que indica que la categoría no existe. Si la categoría que recibe 
     * el método existe, se regresa un estatus positivo de html (ok) y un
     * mensaje que indica que la categoría fue actualizada.
     */
    @PutMapping
    public ResponseEntity<String> updateCategory(@Valid @RequestBody Category c){
        String mensaje="category does not exist";

        for(Category cat : categorias){
            if(esIgual(cat, c)){
                mensaje="category updated";
                return new ResponseEntity<>(mensaje, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
    }

    /**
     * Nos permite hacer la simulación de haber eliminado una categoría.
     * @param category_id el id de la categoría a 'eliminar', se recibe através
     * del url path.
     * @return un objeto ResponsEentity con un mensaje y un estatus de html:
     * si el identificador que recibe el método coincide con el de una categoría
     * existente, se regresa un estatus positivo de html (OK) con un mensaje que 
     * indica que la categoría fue removida. Si no se encuentra ninguna categoría
     * con el mismo identificador que recibio el método, se regresa un estatus
     * negativo de html (NOT_FOUND) con un mensaje que indica que la categoría 
     * buscada no existe.
     */
    @DeleteMapping("/{category_id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int category_id){
        String mensaje="category does not exist";

        for(Category cat : categorias){
            if(cat.getCategory_id()==category_id){
                mensaje="category removed";
                return new ResponseEntity<>(mensaje, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);

    }

}
