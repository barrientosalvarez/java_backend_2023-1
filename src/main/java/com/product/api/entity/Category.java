package com.product.api.entity;

/**
 * Clase que nos permite modelar categorías.
 * @author Jorge Miguel Aaron Barrientos Alvarez
 * @since septiembre/2022
 */
public class Category{
    
    /** Valor entero que servira como identificador para las categorías.  */
    private int category_id;

    /** Cadena que guardará el nombre de las categorías. */
    private String category;

    /** Valor entero que servirá como estatus para las categorías.  */
    private int status;

    /**
     * Constructor de Categorías.
     * @param category_id identificador de la categoría.
     * @param category nombre de la categoría.
     * @param status estatus de la categoría.
     */
    public Category(int category_id, String category, int status){
        this.category_id=category_id;
        this.category=category;
        this.status=status;
    }

    /**
     * Getter del identificador de las categorías.
     * @return el identificador de la categoría que invocó el método.
     */
    public int getCategory_id(){
        return this.category_id;
    }

    /**
     * Getter del nombre de las categorías.
     * @return el nombre de la categoria que invocó el método.
     */
    public String getCategory(){
        return this.category;
    }

    /**
     * Getter del estatus de las categorías.
     * @return el estatus de la categoría que invocó el método.
     */
    public int getStatus(){
        return this.status;
    }

    @Override
    public String toString(){
        return "{category_id="+category_id+", category="+category+", status="+status+"}";
    }

    @Override
    //algo anda mal
    public boolean equals(Object o){
        if(this==o)
            return true;

        if(o==null || this.getClass()!=o.getClass())
            return false;

        @SuppressWarnings("unchecked") Category c = (Category) o;
        
        if(this.getCategory_id()!=c.getCategory_id())
            return false;

        if(this.getCategory()!=c.getCategory())
            return false;

        if(this.getStatus()!=c.getStatus())
            return false;

        return true;
    }
        
}
