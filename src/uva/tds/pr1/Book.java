package uva.tds.pr1;
import java.util.ArrayList;

/**
 * Implementacion de la creacion de un libro, con su isbn, titulo, paginas, idioma e idioma original,
 * editorial, tipo, año de publicacion, sus dimensiones y autor u autores.
 * 
 * @author mariher
 * @author marllor
 */
public class Book implements LibraryElement {
	private String isbn;
	private String title;
	private int pageNumber;
	private String language;
	private String originalLanguage;
	private String publisher;
	private EnumTypeOfBook typeOfBook;
	private String year;
	private Size size;
	private ArrayList<Author> author;
	
	/**
	 * Inicializacion de un libro.
	 * @param isbn				isbn del libro.
	 * @param titulo			Titulo del libro.
	 * @param numeroPags		Numero de paginas que tiene el libro.
	 * @param idioma			Idioma del libro.
	 * @param idiomaOriginal	Idioma original del libro.
	 * @param editorial			Editorial del libro.
	 * @param tipo				Tipo de libro.
	 * @param year				Año de salida a la venta.
	 * @param dimensiones		Dimensiones del libro(ancho, alto y grosor).
	 * @param autor				Autor/es del libro
	 * @throws IllegalArgumentException si el isbn es null.
	 * @throws IllegalArgumentException si el título es null.
	 * @throws IllegalArgumentException si el número de páginas no es mayor que 0.
	 * @throws IllegalArgumentException si el idioma es null.
	 * @throws IllegalArgumentException si el idioma original es null.
	 * @throws IllegalArgumentException si la editorial es null.
	 * @throws IllegalArgumentException si el tipo de libro es null.
	 * @throws IllegalArgumentException si el año es null.
	 * @throws IllegalArgumentException si las dimensiones son null.
	 * @throws IllegalArgumentException si la lista de autores es null.
	 * @throws IllegalArgumentException si el libro no tiene ningún autor.
	 */

	public Book (String isbn, String titulo, int numeroPags, String idioma, String idiomaOriginal, String editorial,
			EnumTypeOfBook tipo, String year, Size dimensiones, ArrayList<Author> autores) {
		
		if(isbn == null) {
			throw new IllegalArgumentException("Isbn null");
		}
		if(titulo == null) {
			throw new IllegalArgumentException("Título null");
		}
		if(numeroPags <= 0) {
			throw new IllegalArgumentException("El número de páginas debe ser al menos mayor que 0");
		}
		if(idioma == null) {
			throw new IllegalArgumentException("Idioma null");
		}
		if(idiomaOriginal == null) {
			throw new IllegalArgumentException("IdiomaOriginal null");
		}
		if(editorial == null) {
			throw new IllegalArgumentException("Editorial null");
		}
		if(tipo == null) {
			throw new IllegalArgumentException("Tipo de libro null");
		}
		if(year == null) {
			throw new IllegalArgumentException("Año null");
		}
		if(dimensiones == null) {
			throw new IllegalArgumentException("Dimensiones null");
		}
		if(autores == null) {
			throw new IllegalArgumentException("Lista de autores null");
		}
		if(autores.isEmpty()) {
			throw new IllegalArgumentException("Ningún autor del libro");
		}
		this.isbn=isbn;	
		this.title = titulo;
		this.pageNumber = numeroPags;
		this.language = idioma;
		this.originalLanguage = idiomaOriginal;
		this.publisher = editorial;
		this.typeOfBook = tipo;
		this.year = year;
		author=autores;
		this.size = dimensiones;
	}
	
	/**
	 * Devuelve el titulo del libro.
	 * @return titulo del libro
	 */
	public String getTitulo() {
		return title;
	}
	/**
	 * Devuelve el ISBN de un libro
	 * @return isbn del libro
	 */
	public String getID() {
		return isbn;
	}
	
	/**
	 * Devuelve el numero de paginas que tiene el libro.
	 * @return numero de paginas
	 */
	public int getNumPags() {
		return pageNumber;
	}
	
	/**
	 * Devuelve el idioma en el que esta el libro.
	 * @return idioma del libro
	 */
	public String getIdioma() {
		return language;
	}
	
	/**
	 * Devuelve el idioma original del libro,
	 * si es distinto al idioma principal.
	 * @return idioma original del libro
	 */
	public String getIdiomaOriginal() {
		if(language.equals(originalLanguage)) {
			return null;
		}
		return originalLanguage;
	}
	
	/**
	 * Devuelve la editorial del libro.
	 * @return editorial del libro.
	 */
	public String getEditorial() {
		return publisher;
	}
	
	/**
	 * Devuelve el tipo del libro.
	 * @return tipo de libro
	 */
	public EnumTypeOfBook getTipo() {
		return typeOfBook;
	}
	
	/**
	 * Develve el año de publicacion del libro.
	 * @return año de publicacion
	 */
	public String getYear() {
		return year;
	}
	
	/**
	 * Devuelve las dimensiones del libro, alto, ancho 
	 * y grosor.
	 * @return lista de las dimensiones
	 */
	public Size getDimensiones(){
		return size;
	}
	
	/**
	 * Devuelve la lista de los autores
	 * @return lista de autores
	 */
	public ArrayList<Author> getAutores(){
		return author;
	}
		
	/**
	 * Añade un autor a la lista de autores.
	 * @param autor Nuevo autor añadido
	 * @throws IllegalArgumentException si el autor que se añade es null
	 */
	public void addAutor(Author autor) {
		if(autor == null) {
			throw new IllegalArgumentException("Autor null");
		}
		author.add(autor);
	}
}
