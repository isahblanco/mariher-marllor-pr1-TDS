package uva.tds.pr1;
/**
 * Implementación de la creación de una biblioteca.
 * 
 * @author mariher
 * @author marllor
 *
 */
public class LibraryFactory implements ILibraryFactory {

	@Override
	public ILibrary createNewLibrary() {
		Library libreria =new Library();
		return libreria;
		
	}

}
