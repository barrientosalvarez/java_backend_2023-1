package practica01;

import java.util.List;
import java.util.ArrayList;

/**
 * Clase CategoryManager que maneja objetos de la clase embebida Category.
 * @author Jorge Miguel Aaron Barrientos Alvarez
 * @since 28/Ago/2022
 */
public class CategoryManager{
   
    /**
     * Clase embebida Category que modela un objeto del tipo 'Categoría'
     */
    public class Category{
        
        /* Identificador para las categorías. */
        private String category_id;

        /* Nombre de la categoría. */
        private String category;

        /**
         * Constructor de la clase Category
         * @param id identificador de la categoría.
         * @param category nombre de la categoría.
         */ 
        public Category(String id, String category){
            this.category_id=id;
            this.category=category;
        }

        @Override
        public String toString(){
            return "{"+this.category_id+", "+this.category+"}";
        }

        /**
         * Metodo geter para el id de las categorías.
         * @return el id de la categoria que invoca el método.
         */
        public String getId(){
            return this.category_id;
        }

        /**
         * Metodo geter para el nombre de las categorías.
         * @return el nombre de la categoría que invoca el método.
         */
        public String getCategory(){
            return this.category;
        }
    }

    /* Lista de los registros de las categorías. */
    private static List<Category> registros;

    /**
     * Constructor de la clase CategoryManager: inicializa a la variable 'registros'
     * para poder comenzar a guardas los registros de las instancias de Category.
     */
    public CategoryManager(){
        registros=new ArrayList<Category>();
    }

    /**
     * Método que crea una categoría, creando una instancia de Category; la instancia
     * es almacenada en la variable registros. Si se recibe un 'id' repetido
     * la categoría no puede ser creada y se le informa al usuario através de 
     * un mensaje de texto.
     * @param id el id de la categoría que se quiere crear.
     * @param name el nombre de la categoria que se quiere crear.
     * @return 0 si la categoria fue creada correctamente (creada y agregada a 
     *         'registros'), -1 en otro caso.
     */
    public int createCategory(String id, String name){
        if(checkId(id)==null){
            Category categoria=new Category(id, name);
            registros.add(categoria);
            return 0;
        }
        else{
            System.out.println("\nNo se puede crear una categoria con id repetido.\n");
            return -1;
        }
    }

    /**
     * Método auxiliar que nos permite verificar si ya tenemos un registro de una
     * categoría con un id en especifico; sirve para no crear categorías distintas
     * con un mismo identificador
     * @param id el id que se verificara si existe o no existe en los registros una
     *           categoría con este identificador.
     * @return si el id ya existe con anterioridad, se regresara a la instancia de
     *         Category que cuenta con dicho identificador; si no se encuentra un registro
     *         que contenga al identificador id, se regresa <code>null</code>
     */
    private static Category checkId(String id){
        for(Category cat : registros){
            if(cat.getId().equals(id))
                return cat;
        }

        return null;
    }

    /**
     * Método que muestra en pantalla todas las instancias de Category de las que
     * se tiene registro hasta el momento. En caso de no existir ningún registro,
     * notifica através de un mensaje que no existen registros.
     */
    public void getCategories(){
        if(registros.isEmpty())
            System.out.println("\nNo existen registros\n");

        else
            System.out.println("\nRegistros actuales: "+registros.toString());
    }

    /**
     * Método que muestra una categoría en específico; la categoria es buscada dentro
     * de nuestros registros usando como valor de referencia su identificador.
     * @param id id de la categoría que se quiere mostrar en pantalla.
     */
    public void getCategory(String id){
        Category cat=checkId(id);
        if(cat!=null)
            System.out.println("\nCategoria con el identificador "+id+ ": "+cat.toString());
        else
            System.out.println("\nNo se encontro un registro con ese identificador.\n");
        
    }

    /**
     * Método que elimina una categoría en específico de los registros de categorías.
     * La categoría a eliminar se encuentra usando como valor de referencia su 
     * identificador.
     * @param id el identificador de la categoría que se busca eliminar.
     * @return 0 si el registro de la categoría fue eliminado correctamente, -1 en
     * otro caso (cuando no se encontro ningún registro que coincidiera con el 
     * identificador proporcionado por el usuario).
     */
    public int deleteCategory(String id){
        Category cat=checkId(id);
        if(cat!=null){
            registros.remove(cat);
            return 0;
        }
        
        else{
            System.out.println("\nNo se encontro un regsitro con ese identificador.\n");
            return -1;
        }
    }
}
