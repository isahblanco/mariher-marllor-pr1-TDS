package uva.tds.pr1;

import java.nio.file.Path;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;

/**
 * Implementación de una biblioteca.
 * 
 * @author mariher
 * @author marllor
 *
 */
public class Library implements ILibrary {
	private ArrayList<Book> books;
	private ArrayList<Collection> collections;
	private int loaded=0;
	private int modifLoad=0;
	public Library() {
		books = new ArrayList<Book>();
		collections = new ArrayList<Collection>();
	}

	@Override
	public void loadFrom(Path pathToXML) {
		try {
			parseameEsta(pathToXML);
			loaded=1;
		} catch (Exception e) {
			throw new IllegalArgumentException("Error en XML");
		}

	}

	@Override
	public void updateTo(Path pathToXML) {
		try {
			creaXML(pathToXML);
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Error al crear XML");
		}
	}

	@Override
	public boolean isXMLLoaded() {
		if (loaded==1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isModifiedAfterLoaded() {
		if(modifLoad==1) {
			return true;
		}
		return false;
	}

	@Override
	public void createNewBook(String Isbn, String title, int numPages, String language, String originalLanguage,
			String publisher, EnumTypeOfBook bookType, String year, Size size, ArrayList<Author> authors) {
		books.add(
				new Book(Isbn, title, numPages, language, originalLanguage, publisher, bookType, year, size, authors));
		if(loaded==1) {
			modifLoad=1;
		}
	}

	@Override
	public void createNewCollection(String name, ArrayList<Book> books) {
		collections.add(new Collection(name, books));
		if(loaded==1) {
			modifLoad=1;
		}

	}
	
	@Override
	public LibraryElement getAnyLibraryElementById(String id) {

		if (id == null) {
			throw new IllegalArgumentException("Id null");
		}

		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getID().equals(id)) {
				return books.get(i);
			}
		}
		for (int i = 0; i < collections.size(); i++) {
			if (collections.get(i).getID().equals(id)) {
				return collections.get(i);
			}
		}
		return null;
	}

	@Override
	public Book getBookByIsbn(String isbn) {

		if (isbn == null) {
			throw new IllegalArgumentException("Isbn null");
		}

		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getID().equals(isbn)) {
				return books.get(i);
			}
		}
		return null;
	}

	@Override
	public Collection getCollectionByName(String name) {

		if (name == null) {
			throw new IllegalArgumentException("Name null");
		}

		for (int i = 0; i < collections.size(); i++) {
			if (collections.get(i).getID().equals(name)) {
				return collections.get(i);
			}
		}
		return null;
	}

	@Override
	public void addBookToCollection(Book book, Collection collection) {
		if (book == null) {
			throw new IllegalArgumentException("Book null");
		}

		if (collection == null) {
			throw new IllegalArgumentException("Collection null");
		}

		if (collection.inCollection(book)) {
			throw new IllegalArgumentException("El libro ya está en la colección.");
		}

		collection.addBook(book);
		if(loaded==1) {
			modifLoad=1;
		}
	}

	@Override
	public void removeBookFromCollection(Book book, Collection collection) {
		if (book == null) {
			throw new IllegalArgumentException("Book null");
		}

		if (collection == null) {
			throw new IllegalArgumentException("Collection null");
		}

		if (!collection.inCollection(book)) {
			throw new IllegalArgumentException("El libro no está en la colección.");
		}

		collection.removeBook(book);
		if(loaded==1) {
			modifLoad=1;
		}
	}

	@Override
	public void removeLibraryElementFromLibrary(LibraryElement element) {
		if (element == null) {
			throw new IllegalArgumentException("Element null");
		}

		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getID().equals(element.getID())) {
				books.remove(books.get(i));
				if(loaded==1) {
					modifLoad=1;
				}
			}
		}

		for (int i = 0; i < collections.size(); i++) {
			if (collections.get(i).getID().equals(element.getID())) {
				collections.remove(collections.get(i));
				if(loaded==1) {
					modifLoad=1;
				}
			}
		}
		
	}

	private void parseLibro(Element libro) {
		Node node1 = libro.getElementsByTagName("isbn").item(0);
		String isbn = node1.getTextContent();
		Node node2 = libro.getElementsByTagName("title").item(0);
		String title = node2.getTextContent();
		Node node3 = libro.getElementsByTagName("pageNumber").item(0);
		String pageNumber = node3.getTextContent();
		Node node4 = libro.getElementsByTagName("language").item(0);
		String language = node4.getTextContent();
		Node node5 = libro.getElementsByTagName("originalLanguage").item(0);
		String olanguage = node5.getTextContent();
		Node node6 = libro.getElementsByTagName("publisher").item(0);
		String publisher = node6.getTextContent();
		Node node7 = libro.getElementsByTagName("typeOfBook").item(0);
		String tBook = node7.getTextContent();
		Node node8 = libro.getElementsByTagName("year").item(0);
		String year = node8.getTextContent();
		Node node9 = libro.getElementsByTagName("size").item(0);
		Element nodeSize = (Element) node9;
		Node node10 = nodeSize.getElementsByTagName("width").item(0);
		String ancho = node10.getTextContent();
		Node node11 = nodeSize.getElementsByTagName("height").item(0);
		String alto = node11.getTextContent();
		Node node12 = nodeSize.getElementsByTagName("thickness").item(0);
		String grosor = node12.getTextContent();
		Node node13 = libro.getElementsByTagName("author").item(0);
		Element nodeAuthor = (Element) node13;
		Node node14 = nodeAuthor.getElementsByTagName("authorName").item(0);
		String nombre = node14.getTextContent();
		Node node15 = nodeAuthor.getElementsByTagName("surname").item(0);
		String apellidos = node15.getTextContent();

		Size tamano=new Size(Double.valueOf(ancho),Double.valueOf(alto),Double.valueOf(grosor));
		ArrayList<Author> autores= new ArrayList<Author>();
		autores.add(new Author(nombre,apellidos));
		EnumTypeOfBook tipo =EnumTypeOfBook.valueOf(tBook);
		createNewBook( isbn,  title,  Integer.valueOf(pageNumber),  language,olanguage,
				 publisher, tipo,  year, tamano, autores);
	}
	private void parseLibroToCollection(Element libro,ArrayList<Book> libros) {
		Node node1 = libro.getElementsByTagName("isbn").item(0);
		String isbn = node1.getTextContent();
		Book libroAColeccion=getBookByIsbn(isbn);
		libros.add(libroAColeccion);
	}

	private void parseColeccion(Element coleccion) {
		Node node1 = coleccion.getElementsByTagName("name").item(0);
		String name = node1.getTextContent();
		ArrayList<Book> libros =new ArrayList<Book>();
		
		NodeList listalibros = coleccion.getElementsByTagName("book");
		for (int i = 0; i < listalibros.getLength(); i++) {
			Node nNode = listalibros.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element libro = (Element) nNode;
				parseLibroToCollection(libro,libros);
			}
		}
		collections.add(new Collection(name, libros));
		Collection coleccionCaso=getCollectionByName(name);
	}

	private void parseameEsta(Path path) throws ParserConfigurationException, SAXException, IOException {

		File xmlFile = new File(path.toString());

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
		doc.getDocumentElement().normalize();
		NodeList listalibros = doc.getElementsByTagName("book");
		for (int i = 0; i < listalibros.getLength(); i++) {
			Node nNode = listalibros.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element libro = (Element) nNode;
				parseLibro(libro);
				
			}
		}
		NodeList listacolecciones = doc.getElementsByTagName("collection");
		for (int i = 0; i < listacolecciones.getLength(); i++) {
			Node nNode = listacolecciones.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element coleccion = (Element) nNode;
				parseColeccion(coleccion);
				
			}
		}
	}
	public void creaXML(Path path) throws ParserConfigurationException, TransformerException, IOException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();
		Element root = doc.createElement("Library");
		doc.appendChild(root);
		
		for (int i = 0; i < books.size(); i++) {
			root.appendChild(createBook(doc, books.get(i)));
		}
		for (int i = 0; i < collections.size(); i++) {
			root.appendChild(createCollection(doc, collections.get(i)));
		}
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transf = transformerFactory.newTransformer();
		transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transf.setOutputProperty(OutputKeys.INDENT, "yes");
		transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		DOMSource source = new DOMSource(doc);
		File myFile = new File(path.toString());
		myFile.createNewFile();
		StreamResult file = new StreamResult(myFile);

		transf.transform(source, file);
	}
	private  Node createCollection(Document doc, Collection collection) {
		Element user = doc.createElement("collection");
		user.setAttribute("name", collection.getID());
		user.appendChild(addElement(doc, "name", collection.getID()));
		for (int i = 0; i < collection.getLibros().size(); i++) {
			user.appendChild(createBook(doc, collection.getLibros().get(i)));
		}
		return user;

	}

	private Node createBook(Document doc, Book Book) {

		Element user = doc.createElement("book");

		user.setAttribute("isbn", Book.getID());
		user.appendChild(addElement(doc, "isbn", Book.getID()));
		user.appendChild(addElement(doc, "title", Book.getTitulo()));
		user.appendChild(addElement(doc, "pageNumber", Integer.toString(Book.getNumPags())));
		user.appendChild(addElement(doc, "language", Book.getIdioma()));
		user.appendChild(addElement(doc, "originalLanguage", Book.getIdiomaOriginal()));
		user.appendChild(addElement(doc, "publisher", Book.getEditorial()));
		user.appendChild(addElement(doc, "typeOfBook", Book.getTipo().name()));
		user.appendChild(addElement(doc, "year", Book.getYear()));
		Element tamano = doc.createElement("size");
		tamano.appendChild(addElement(doc, "width", Double.toString(Book.getDimensiones().getAncho())));
		tamano.appendChild(addElement(doc, "height", Double.toString(Book.getDimensiones().getAlto())));
		tamano.appendChild(addElement(doc, "thickness", Double.toString(Book.getDimensiones().getGrosor())));
		user.appendChild(tamano);
		for (int i = 0; i < Book.getAutores().size(); i++) {
			Element author = doc.createElement("author");
			author.appendChild(addElement(doc, "authorName", Book.getAutores().get(i).getName()));
			author.appendChild(addElement(doc, "surname", Book.getAutores().get(i).getSurname()));
			user.appendChild(author);
		}

		return user;
	}

	private Node addElement(Document doc, String name, String value) {

		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));

		return node;
	}
}
