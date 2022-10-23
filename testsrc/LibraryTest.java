import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import uva.tds.pr1.*;
/**
 * @author mariher
 * @author marllor
 */
class LibraryTest {

	/*
	 * Pruebas válidas inicializador
	 */
	@Test
	void testLibrary() {
		Library books = new Library();
		Library collections = new Library();

		assertNotNull(books);
		assertNotNull(collections);
	}

	/*
	 * Pruebas del metodo CreateNewBook()
	 */
	@Test
	void testCreateNewBook() {
		Library books = new Library();
		Size s = new Size(12,20,6);
		Author autor = new Author("John","Fernandez");
		ArrayList<Author> autores = new ArrayList<>();
		autores.add(autor);

		books.createNewBook("abc123","Milcuentos", 275,"Español","Inglés","Lampa",EnumTypeOfBook.hardCover,"2007",s,autores);
		assertEquals(books.getBookByIsbn("abc123").getID(),"abc123"); 
		assertEquals(books.getBookByIsbn("abc123").getTitulo(),"Milcuentos");
		assertEquals(books.getBookByIsbn("abc123").getNumPags(),275);
		assertEquals(books.getBookByIsbn("abc123").getIdioma(),"Español");
		assertEquals(books.getBookByIsbn("abc123").getIdiomaOriginal(),"Inglés");
		assertEquals(books.getBookByIsbn("abc123").getEditorial(),"Lampa");
		assertEquals(books.getBookByIsbn("abc123").getTipo(),EnumTypeOfBook.hardCover);
		assertEquals(books.getBookByIsbn("abc123").getYear(),"2007");
		assertEquals(books.getBookByIsbn("abc123").getDimensiones(),s);
		assertEquals(books.getBookByIsbn("abc123").getAutores().get(0),autores.get(0));
	}

	@Test
	void testCreateNewBookIsbnNull() {
		Library books = new Library();
		Size s = new Size(12,20,6);
		Author autor = new Author("John","Fernandez");
		ArrayList<Author> autores = new ArrayList<>();
		autores.add(autor);
		assertThrows(IllegalArgumentException.class,()->{books.createNewBook(null,"Milcuentos", 275,"Español","Inglés",
				"Lampa",EnumTypeOfBook.hardCover,"2007",s,autores);});
	}

	@Test
	void testCreateNewBookTituloNull() {
		Library books = new Library();
		Size s = new Size(12,20,6);
		Author autor = new Author("John","Fernandez");
		ArrayList<Author> autores = new ArrayList<>();
		autores.add(autor);
		assertThrows(IllegalArgumentException.class,()->{books.createNewBook("abc133",null, 275,"Español","Inglés",
				"Lampa",EnumTypeOfBook.hardCover,"2007",s,autores);});
	}

	@Test
	void testCreateNewBookNumPagNegativo() {
		Library books = new Library();
		Size s = new Size(12,20,6);
		Author autor = new Author("John","Fernandez");
		ArrayList<Author> autores = new ArrayList<>();
		autores.add(autor);
		assertThrows(IllegalArgumentException.class,()->{books.createNewBook("abc133","Milcuentos",-1,"Español","Inglés",
				"Lampa",EnumTypeOfBook.hardCover,"2007",s,autores);});
	}

	@Test
	void testCreateNewBookIdiomaNull() {
		Library books = new Library();
		Size s = new Size(12,20,6);
		Author autor = new Author("John","Fernandez");
		ArrayList<Author> autores = new ArrayList<>();
		autores.add(autor);
		assertThrows(IllegalArgumentException.class,()->{books.createNewBook("abc133","Milcuentos", 275,null,"Inglés",
				"Lampa",EnumTypeOfBook.hardCover,"2007",s,autores);});
	}

	@Test
	void testCreateNewBookIdiomaOriginalNull() {
		Library books = new Library();
		Size s = new Size(12,20,6);
		Author autor = new Author("John","Fernandez");
		ArrayList<Author> autores = new ArrayList<>();
		autores.add(autor);
		assertThrows(IllegalArgumentException.class,()->{books.createNewBook("abc133","Milcuentos", 275,"Español",null,
				"Lampa",EnumTypeOfBook.hardCover,"2007",s,autores);});
	}

	@Test
	void testCreateNewBookEditorialNull() {
		Library books = new Library();
		Size s = new Size(12,20,6);
		Author autor = new Author("John","Fernandez");
		ArrayList<Author> autores = new ArrayList<>();
		autores.add(autor);
		assertThrows(IllegalArgumentException.class,()->{books.createNewBook("abc133","Milcuentos", 275,"Español","Inglés",
				null,EnumTypeOfBook.hardCover,"2007",s,autores);});
	}

	@Test
	void testCreateNewBookTipoLibroNull() {
		Library books = new Library();
		Size s = new Size(12,20,6);
		Author autor = new Author("John","Fernandez");
		ArrayList<Author> autores = new ArrayList<>();
		autores.add(autor);
		assertThrows(IllegalArgumentException.class,()->{books.createNewBook("abc133","Milcuentos", 275,"Español","Inglés",
				"Lampa",null,"2007",s,autores);});
	}

	@Test
	void testCreateNewBookYearNull() {
		Library books = new Library();
		Size s = new Size(12,20,6);
		Author autor = new Author("John","Fernandez");
		ArrayList<Author> autores = new ArrayList<>();
		autores.add(autor);
		assertThrows(IllegalArgumentException.class,()->{books.createNewBook("abc133","Milcuentos", 275,"Español","Inglés",
				"Lampa",EnumTypeOfBook.hardCover,null,s,autores);});
	}

	@Test
	void testCreateNewBookDimensionesNull() {
		Library books = new Library();
		Size s = new Size(12,20,6);
		Author autor = new Author("John","Fernandez");
		ArrayList<Author> autores = new ArrayList<>();
		autores.add(autor);
		assertThrows(IllegalArgumentException.class,()->{books.createNewBook("abc133","Milcuentos", 275,"Español","Inglés",
				"Lampa",EnumTypeOfBook.hardCover,"2007",null,autores);});
	}

	@Test
	void testCreateNewBookListaAutoresNull() {
		Library books = new Library();
		Size s = new Size(12,20,6);
		assertThrows(IllegalArgumentException.class,()->{books.createNewBook("abc133","Milcuentos", 275,"Español","Inglés",
				"Lampa",EnumTypeOfBook.hardCover,"2007",s,null);});
	}

	@Test
	void testCreateNewBookNingunAutor() {
		Library books = new Library();
		Size s = new Size(12,20,6);
		ArrayList<Author> autores = new ArrayList<>();
		assertThrows(IllegalArgumentException.class,()->{books.createNewBook("abc133","Milcuentos", 275,"Español","Inglés",
				"Lampa",EnumTypeOfBook.hardCover,"2007",s,autores);});
	}


	/*
	 * Pruebas del metodo CreateNewCollection()
	 */
	@Test
	void testCreateNewCollection() {
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

		assertEquals(collections.getCollectionByName("Geografía e Historia").getID(),"Geografía e Historia"); //TODO Cambiar a .getID
		assertEquals(collections.getCollectionByName("Geografía e Historia").librosCollection().get(0),libros.get(0));
		assertEquals(collections.getCollectionByName("Geografía e Historia").librosCollection().get(1),libros.get(1));
		assertEquals(collections.getCollectionByName("Geografía e Historia").librosCollection().get(2),libros.get(2));
	}

	@Test
	void testCreateNewCollectionNombreNull() {
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

		books.createNewBook("abc133","Milcuentos", 275,"Español","Inglés","Lampa",EnumTypeOfBook.softCover,"2007",s,autores1);
		books.createNewBook("adc163","Mares del mundo", 1000,"Francés","Español","Nova",EnumTypeOfBook.hardCover,"1999",s,autores2);
		books.createNewBook("adc164","Historia de Europa", 5000,"Inglés","Español","Lampa",EnumTypeOfBook.hardCover,"2001",s,autores3);

		ArrayList<Book> libros = new ArrayList<>();
		libros.add(books.getBookByIsbn("abc133"));
		libros.add(books.getBookByIsbn("adc163"));
		libros.add(books.getBookByIsbn("adc164"));

		assertThrows(IllegalArgumentException.class,()->{collections.createNewCollection(null,libros);});
	}

	@Test
	void testCreateNewCollectionListaLibrosNull() {
		Library collections = new Library();
		assertThrows(IllegalArgumentException.class,()->{collections.createNewCollection("Geografía e Historia",null);});
	}

	@Test
	void testCreateNewCollectionListaLibrosVacia() {
		Library collections = new Library();
		ArrayList<Book> libros = new ArrayList<>();
		assertThrows(IllegalArgumentException.class,()->{collections.createNewCollection("Geografía e Historia",libros);});
	}

	/*
	 * Pruebas del metodo getAnyLibraryElementById()
	 */
	@Test
	void testGetAnyLibraryElementById() {
		Library books = new Library();
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

		books.createNewBook("abc133","Milcuentos", 275,"Español","Inglés","Lampa",EnumTypeOfBook.softCover,"2007",s,autores1);
		books.createNewBook("adc163","Mares del mundo", 1000,"Francés","Español","Nova",EnumTypeOfBook.hardCover,"1999",s,autores2);
		books.createNewBook("adc164","Historia de Europa", 5000,"Inglés","Español","Lampa",EnumTypeOfBook.hardCover,"2001",s,autores3);

		ArrayList<Book> libros = new ArrayList<>();
		libros.add(books.getBookByIsbn("adc163"));
		libros.add(books.getBookByIsbn("adc164"));

		collections.createNewCollection("Geografía e Historia",libros);

		assertEquals(books.getAnyLibraryElementById("abc133"), books.getBookByIsbn("abc133"));
		assertEquals(collections.getAnyLibraryElementById("Geografía e Historia"), collections.getCollectionByName("Geografía e Historia"));
	}

	@Test
	void testGetAnyLibraryElementByIdNull() {
		Library books = new Library();

		Size s = new Size(12,20,6);
		Author autor = new Author("John","Fernandez");
		ArrayList<Author> autores = new ArrayList<>();
		autores.add(autor);

		books.createNewBook("abc133","Milcuentos", 275,"Español","Inglés","Lampa",EnumTypeOfBook.softCover,"2007",s,autores);

		assertThrows(IllegalArgumentException.class,()->{books.getAnyLibraryElementById(null);});
	}

	/*
	 * Pruebas del metodo getBookByIsbn()
	 */
	@Test
	void testGetBookByIsbn() {
		Library books = new Library();

		Size s = new Size(12,20,6);
		Author autor = new Author("John","Fernandez");
		ArrayList<Author> autores = new ArrayList<>();
		autores.add(autor);

		books.createNewBook("abc133","Milcuentos", 275,"Español","Inglés","Lampa",EnumTypeOfBook.softCover,"2007",s,autores);

		assertEquals(books.getBookByIsbn("abc133"), books.getAnyLibraryElementById("abc133"));

	}

	@Test
	void testGetBookByIsbnNull() {
		Library books = new Library();

		Size s = new Size(12,20,6);
		Author autor = new Author("John","Fernandez");
		ArrayList<Author> autores = new ArrayList<>();
		autores.add(autor);

		books.createNewBook("abc133","Milcuentos", 275,"Español","Inglés","Lampa",EnumTypeOfBook.softCover,"2007",s,autores);

		assertThrows(IllegalArgumentException.class,()->{books.getBookByIsbn(null);});

	}

	/*
	 * Pruebas del metodo getCollectionByName()
	 */
	@Test
	void testGetCollectionByName() {
		Library books = new Library();
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

		books.createNewBook("abc133","Milcuentos", 275,"Español","Inglés","Lampa",EnumTypeOfBook.softCover,"2007",s,autores1);
		books.createNewBook("adc163","Mares del mundo", 1000,"Francés","Español","Nova",EnumTypeOfBook.hardCover,"1999",s,autores2);
		books.createNewBook("adc164","Historia de Europa", 5000,"Inglés","Español","Lampa",EnumTypeOfBook.hardCover,"2001",s,autores3);

		ArrayList<Book> libros = new ArrayList<>();
		libros.add(books.getBookByIsbn("abc133"));
		libros.add(books.getBookByIsbn("adc163"));
		libros.add(books.getBookByIsbn("adc164"));

		collections.createNewCollection("Geografía e Historia",libros);

		assertEquals(collections.getCollectionByName("Geografía e Historia"), collections.getAnyLibraryElementById("Geografía e Historia"));
	}

	@Test
	void testGetCollectionByNameNull() {
		Library books = new Library();
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

		books.createNewBook("abc133","Milcuentos", 275,"Español","Inglés","Lampa",EnumTypeOfBook.softCover,"2007",s,autores1);
		books.createNewBook("adc163","Mares del mundo", 1000,"Francés","Español","Nova",EnumTypeOfBook.hardCover,"1999",s,autores2);
		books.createNewBook("adc164","Historia de Europa", 5000,"Inglés","Español","Lampa",EnumTypeOfBook.hardCover,"2001",s,autores3);

		ArrayList<Book> libros = new ArrayList<>();
		libros.add(books.getBookByIsbn("abc133"));
		libros.add(books.getBookByIsbn("adc163"));
		libros.add(books.getBookByIsbn("adc164"));

		assertThrows(IllegalArgumentException.class,()->{collections.getCollectionByName(null);});
	}

	/*
	 * Pruebas del método addBookToCollection()
	 */

	@Test
	void testAddToCollection() {
		Library books = new Library();
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

		books.createNewBook("abc133","Milcuentos", 275,"Español","Inglés","Lampa",EnumTypeOfBook.softCover,"2007",s,autores1);
		books.createNewBook("adc163","Mares del mundo", 1000,"Francés","Español","Nova",EnumTypeOfBook.hardCover,"1999",s,autores2);
		books.createNewBook("adc164","Historia de Europa", 5000,"Inglés","Español","Lampa",EnumTypeOfBook.hardCover,"2001",s,autores3);

		ArrayList<Book> libros = new ArrayList<>();
		libros.add(books.getBookByIsbn("adc163"));
		libros.add(books.getBookByIsbn("adc164"));

		collections.createNewCollection("Geografía e Historia",libros);
		collections.addBookToCollection(books.getBookByIsbn("abc133"), collections.getCollectionByName("Geografía e Historia"));
		assertTrue(collections.getCollectionByName("Geografía e Historia").inCollection(books.getBookByIsbn("abc133")));
	}

	@Test
	void testAddToCollectionYaEnCollection() {
		Library books = new Library();
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

		books.createNewBook("abc133","Milcuentos", 275,"Español","Inglés","Lampa",EnumTypeOfBook.softCover,"2007",s,autores1);
		books.createNewBook("adc163","Mares del mundo", 1000,"Francés","Español","Nova",EnumTypeOfBook.hardCover,"1999",s,autores2);
		books.createNewBook("adc164","Historia de Europa", 5000,"Inglés","Español","Lampa",EnumTypeOfBook.hardCover,"2001",s,autores3);

		ArrayList<Book> libros = new ArrayList<>();
		libros.add(books.getBookByIsbn("adc163"));
		libros.add(books.getBookByIsbn("adc164"));

		collections.createNewCollection("Geografía e Historia",libros);
		assertThrows(IllegalArgumentException.class,()->{collections.addBookToCollection(books.getBookByIsbn("adc163"),
				collections.getCollectionByName("Geografía e Historia"));});
	}

	/*
	 * Pruebas del método removeBookFromCollection()
	 */
	@Test
	void testRemoveFromCollection() {
		Library books = new Library();
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

		books.createNewBook("abc133","Milcuentos", 275,"Español","Inglés","Lampa",EnumTypeOfBook.softCover,"2007",s,autores1);
		books.createNewBook("adc163","Mares del mundo", 1000,"Francés","Español","Nova",EnumTypeOfBook.hardCover,"1999",s,autores2);
		books.createNewBook("adc164","Historia de Europa", 5000,"Inglés","Español","Lampa",EnumTypeOfBook.hardCover,"2001",s,autores3);

		ArrayList<Book> libros = new ArrayList<>();
		libros.add(books.getBookByIsbn("adc163"));
		libros.add(books.getBookByIsbn("adc164"));

		collections.createNewCollection("Geografía e Historia",libros);
		collections.removeBookFromCollection(books.getBookByIsbn("adc163"), collections.getCollectionByName("Geografía e Historia"));
		assertTrue(!(collections.getCollectionByName("Geografía e Historia").inCollection(books.getBookByIsbn("adc163"))));
	}

	@Test
	void testRemoveFromCollectionNoEnCollection() {
		Library books = new Library();
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

		books.createNewBook("abc133","Milcuentos", 275,"Español","Inglés","Lampa",EnumTypeOfBook.softCover,"2007",s,autores1);
		books.createNewBook("adc163","Mares del mundo", 1000,"Francés","Español","Nova",EnumTypeOfBook.hardCover,"1999",s,autores2);
		books.createNewBook("adc164","Historia de Europa", 5000,"Inglés","Español","Lampa",EnumTypeOfBook.hardCover,"2001",s,autores3);

		ArrayList<Book> libros = new ArrayList<>();
		libros.add(books.getBookByIsbn("adc163"));
		libros.add(books.getBookByIsbn("adc164"));

		assertThrows(IllegalArgumentException.class,()->{collections.removeBookFromCollection(books.getBookByIsbn("abc133"),
				collections.getCollectionByName("Geografía e Historia"));});
	}

	/*
	 * Pruebas del método removeLibraryElementFromLibrary
	 */
	@Test
	void testRemoveLibraryElementFromLibrary() {
		Library books = new Library();
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

		books.createNewBook("abc133","Milcuentos", 275,"Español","Inglés","Lampa",EnumTypeOfBook.softCover,"2007",s,autores1);
		books.createNewBook("adc163","Mares del mundo", 1000,"Francés","Español","Nova",EnumTypeOfBook.hardCover,"1999",s,autores2);
		books.createNewBook("adc164","Historia de Europa", 5000,"Inglés","Español","Lampa",EnumTypeOfBook.hardCover,"2001",s,autores3);

		ArrayList<Book> libros = new ArrayList<>();
		libros.add(books.getBookByIsbn("adc163"));
		libros.add(books.getBookByIsbn("adc164"));

		collections.createNewCollection("Geografía e Historia",libros);

		books.removeLibraryElementFromLibrary(books.getBookByIsbn("abc133"));
		collections.removeLibraryElementFromLibrary(collections.getCollectionByName("Geografía e Historia"));
		assertEquals(books.getBookByIsbn("abc123"),null);
		assertEquals(collections.getCollectionByName("Geografía e Historia"),null);
	}

	@Test
	void testRemoveLibraryElementFromLibraryElementNull() {
		Library books = new Library();
		Library collections = new Library();

		Size s = new Size(12,20,6);
		Author autor = new Author("John","Fernandez");
		ArrayList<Author> autores = new ArrayList<>();
		autores.add(autor);

		books.createNewBook("abc133","Milcuentos", 275,"Español","Inglés","Lampa",EnumTypeOfBook.softCover,"2007",s,autores);

		assertThrows(IllegalArgumentException.class,()->{books.removeLibraryElementFromLibrary(null);});
		assertEquals(books.getBookByIsbn("abc133").getID(),"abc133");
	}
	@Test
	void testUpdateToXML() {
		Library books = new Library();
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

		books.createNewBook("abc133","Milcuentos", 275,"Español","Inglés","Lampa",EnumTypeOfBook.softCover,"2007",s,autores1);
		books.createNewBook("adc163","Mares del mundo", 1000,"Francés","Español","Nova",EnumTypeOfBook.hardCover,"1999",s,autores2);
		books.createNewBook("adc164","Historia de Europa", 5000,"Inglés","Español","Lampa",EnumTypeOfBook.hardCover,"2001",s,autores3);

		ArrayList<Book> libros = new ArrayList<>();
		libros.add(books.getBookByIsbn("adc163"));
		libros.add(books.getBookByIsbn("adc164"));

		collections.createNewCollection("Geografía e Historia",libros);
		Path p1 = Paths.get("C:\\Users\\Subid99\\git\\mariher-marllor\\src\\XML\\Cosas.xml");
		books.updateTo(p1);
		collections.updateTo(p1);
	}
	@Test
	void testLoadFromXML() {
		Library books = new Library();
		books.loadFrom(Paths.get("C:\\Users\\Subid99\\git\\mariher-marllor\\src\\XML\\users1.xml"));
	}
	@Test
	void testIsLoadedTrue() {
		Library books = new Library();
		books.loadFrom(Paths.get("C:\\Users\\Subid99\\git\\mariher-marllor\\src\\XML\\users1.xml"));
		assertEquals(books.isXMLLoaded(),true);
	}
	@Test
	void testIsLoadedFalse() {
		Library books = new Library();
		assertEquals(books.isXMLLoaded(),false);
	}
	@Test
	void testIsModifiedAfterLoadedfalse1() {
		Library books = new Library();
		assertEquals(books.isModifiedAfterLoaded(),false);
	}
	@Test
	void testIsModifiedAfterLoadedfalse2() {
		Library books = new Library();
		books.loadFrom(Paths.get("C:\\Users\\Subid99\\git\\mariher-marllor\\src\\XML\\users1.xml"));
		assertEquals(books.isModifiedAfterLoaded(),false);
	}
	@Test
	void testIsModifiedAfterLoadedfalse3() {
		Library books = new Library();
		books.loadFrom(Paths.get("C:\\Users\\Subid99\\git\\mariher-marllor\\src\\XML\\users1.xml"));
		Size s = new Size(12,20,6);
		Author autor = new Author("John","Fernandez");
		ArrayList<Author> autores = new ArrayList<>();
		autores.add(autor);

		books.createNewBook("abc123","Milcuentos", 275,"Español","Inglés","Lampa",EnumTypeOfBook.hardCover,"2007",s,autores);
		assertTrue(books.isModifiedAfterLoaded());
	}
}
