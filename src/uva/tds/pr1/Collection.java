/**
 * Implementacion de una Coleccion de libros
 * @author mariher
 * @author marllor
 */
package uva.tds.pr1;

import java.util.ArrayList;

public class Collection implements LibraryElement {
	private String name;
	private ArrayList<Book> books;
	/**
	 * Constructor de la clase Collection
	 * @param nombre nombre de la coleccion
	 * @throws IllegalArgumentException si el nombre es null
	 * @throws IllegalArgumentException si la lista de libros es null
	 * @throws IllegalArgumentException si no hay ninguún libro en la colección
	 */
	public Collection(String nombre, ArrayList<Book> books) {
		
		
		if(nombre == null) {
			throw new IllegalArgumentException("Nombre null");
		}
		if(books == null) {
			throw new IllegalArgumentException("La lista de libros es null");
		}
		//TODO ver si puede haver colecciones vacias
		if (books.isEmpty()) {
			throw new IllegalArgumentException("Ningún libro en la colección");
		}
		
		this.name=nombre;
		this.books=books;
	}
	/**
	 * Añade un libro a la coleccion
	 * @param libro Libro a añadir
	 * @throws IllegalArgumentException si el libro es null
	 * @throws IllegalArgumentException si el libro ya esta en la colección
	 */
	public void addBook(Book libro) {
		if(libro == null) {
			throw new IllegalArgumentException("Libro null");
		}
		if(books.contains(libro)) {
			throw new IllegalArgumentException("El libro ya está en la colección");
		}
		books.add(libro);
	}
	/**
	 * Elimina un elemento de la coleccion (si este se encuentra en ella)
	 * @param libro Libro a elmininar
	 * @throws IllegalArgumentException si el libro es null
	 * @throws IllegalArgumentException si el libro no esta en la colección
	 */
	public void removeBook(Book libro) {
		if(libro == null) {
			throw new IllegalArgumentException("Libro null");
		}
		if(!books.contains(libro)) {
			throw new IllegalArgumentException("El libro no está en la colección");
		}
		books.remove(libro);
	}
	/**
	 * Devuelve el nombre de una coleccion
	 * @return nombre de la coleccion
	 */
	public String getID() {
		return name;
	}
	public ArrayList<Book> getLibros(){
		return books;
	}
	/**
	 * Devuelve si un libro está en una colección o no
	 * @param libro Libro que se comprueba
	 * @return true si está, false si no
	 * @throws IllegalArgumentException si el libro es null
	 */
	public boolean inCollection(Book libro) {
		if(libro == null) {
			throw new IllegalArgumentException("Libro null");
		}
		if(books.contains(libro)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Devuelve la lista de libros de la colección
	 * @return lista de libros de la colección
	 */
	public ArrayList<Book> librosCollection() {
		return books;
	}
}
