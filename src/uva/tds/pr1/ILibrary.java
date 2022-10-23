/**
 * @author mariher
 * @author marllor
 */
package uva.tds.pr1;

import java.nio.file.Path;
import java.util.ArrayList;

public interface ILibrary {
	/**
	 * Carga una libreria desde un archivo XML
	 * @param pathToXML ruta al archivo XML
	 */
	public void loadFrom(Path pathToXML);
	/**
	 * Imprime un XML con los datos de la librería
	 * @param pathToXML
	 */
	public void updateTo(Path pathToXML);
	/**
	 * Informacion acerca de si la libreria fue cargada desde un XML
	 * @return True si el XML esta cargado, false en el resto de situaciones
	 */
	public boolean isXMLLoaded();
	/**
	 * Informacion acerca de si la libreria fue modificada despues de ser cargada
	 * @return True si esta modificada, False si no
	 */
	public boolean isModifiedAfterLoaded();
	/**
	 * Crea un nuevo libro de la libreria
	 * @param Isbn International Standard Book Number
	 * @param title Titulo del libro
	 * @param numPages Numero de paginas
	 * @param language Idioma del libro
	 * @param originalLanguage Idioma original del libro
	 * @param publisher Editor
	 * @param bookType Tipo de libro
	 * @param year Año de salida a la venta
	 * @param size Dimensiones del libro
	 * @param authors Autor(es) del libro
	 */
	public void createNewBook(String Isbn, String title, int numPages, String language, String originalLanguage,
			String publisher, EnumTypeOfBook bookType, String year, Size size, ArrayList<Author> authors);
	/**
	 * Crea una nueva coleccion
	 * @param name Nombre de la coleccion
	 * @param books Libros incluidos en la coleccion
	 */
	public void createNewCollection(String name, ArrayList<Book> books);
	/**
	 * Devuelve cualquier elemento de la libreria a partir de un Id
	 * @param id Id del elemento
	 * @return Elemento de la libreria
	 * @throws IllegalArgumentException si el id es null
	 */
	public LibraryElement getAnyLibraryElementById(String id);
	/**
	 * Devuelve un libro a partir de su isbn
	 * @param Isbn
	 * @return Libro en cuestion
	 * @throws IllegalArgumentException si el isbn es null
	 */
	public Book getBookByIsbn(String isbn);
	/**
	 * Devuelve una coleccion a partir de su nombre
	 * @param name Nombre de la coleccion
	 * @return Coleccion en cuestion
	 * @throws IllegalArgumentException si el nombre es null
	 */
	public Collection getCollectionByName(String name);
	/**
	 * Anade un libro a una coleccion
	 * @param book Libro a anadir
	 * @param collection Coleccion a la que anadir el libro
	 * @throws IllegalArgumentException si el libro es null
	 * @throws IllegalArgumentException si la coleccion es null
	 * @throws IllegalArgumentException si el libro ya está en la coleccion
	 */
	public void addBookToCollection(Book book, Collection collection);
	/**
	 * Elimina un libro de una coleccion
	 * @param book Libro a ser eliminado
	 * @param collection Coleccion de la que eliminar el libro
	 * @throws IllegalArgumentException si el libro es null
	 * @throws IllegalArgumentException si la coleccion es null
	 * @throws IllegalArgumentException si el libro no está en la coleccion
	 */
	public void removeBookFromCollection(Book book, Collection collection);
	/**
	 * Elimina un elemento de la libreria
	 * @param element Elemento a ser eliminado
	 * @throws IllegalArgumentException si el elemento es null
	 */
	public void removeLibraryElementFromLibrary(LibraryElement element);
}