/**
 * Implementacion de un main de prueba
 * @author mariher
 * @author marllor
 */
package uva.tds.pr1;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Comprobacion {
	public static void main(String args[]) {
		Library books= new Library();
		Library collections = new Library();
		Size s = new Size(12,20,6);
		Author autor1 = new Author("John","Fernandez");
		Author autor2 = new Author("Rosa","García");
		Author autor3 = new Author("Gabriel","Prieto");
		Author autor4 = new Author("Gonzalo","Gonzalez");
		ArrayList<Author> autores1 = new ArrayList<>();
		autores1.add(autor1);
		ArrayList<Author> autores2 = new ArrayList<>();
		autores2.add(autor2);
		autores2.add(autor3);
		ArrayList<Author> autores3 = new ArrayList<>();
		autores3.add(autor4);
		books.createNewBook("abc133","Milcuentos", 275,"Español","Inglés","Lampa",EnumTypeOfBook.hardCover,"2007",s,autores1);
		books.createNewBook("adc163","Mares del mundo", 1000,"Francés","Español","Nova",EnumTypeOfBook.hardCover,"1999",s,autores2);
		books.createNewBook("adc164","Historia de Europa", 5000,"Inglés","Español","Lampa",EnumTypeOfBook.hardCover,"2001",s,autores3);
		ArrayList<Book> libros = new ArrayList<>();
		libros.add(books.getBookByIsbn("abc133"));
		libros.add(books.getBookByIsbn("adc163"));
		libros.add(books.getBookByIsbn("adc164"));
		collections.createNewCollection("Geografía e Historia",libros);
		Library cargaXML =new Library();
		cargaXML.loadFrom(Paths.get("C:\\Users\\Subid99\\git\\mariher-marllor\\src\\XML\\users1.xml"));
		System.out.println(cargaXML.isXMLLoaded());
		System.out.println(cargaXML.isModifiedAfterLoaded());
		cargaXML.createNewBook("abc133","Milcuentos", 275,"Español","Inglés","Lampa",EnumTypeOfBook.hardCover,"2007",s,autores1);
		System.out.println(cargaXML.isModifiedAfterLoaded());
		Path p1 = Paths.get("C:\\Users\\Subid99\\git\\mariher-marllor\\src\\XML\\Cosas.xml");
		books.updateTo(p1);
	}
}
