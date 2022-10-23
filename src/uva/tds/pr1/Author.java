/**
 * Implementacion del autor
 * @author mariher
 * @author marllor
 */

package uva.tds.pr1;

public class Author {
	private String name;
	private String surname;
	/**
	 * Constructor clase Author
	 * @param nombre Nombre del autor
	 * @param apellidos Apellidos del autor
	 * @throws IllegalArgumentException si el nombre es null
	 * @throws IllegalArgumentException si los apellidos son null
	 */
	public Author(String nombre, String apellidos) {
		if(nombre == null) {
			throw new IllegalArgumentException("Nombre null");
		}
		if(apellidos == null) {
			throw new IllegalArgumentException("Apellidos null");
		}
		this.name = nombre;
		this.surname = apellidos;
	}
	/**
	 * Devuelve el nombre del autor
	 * @return nombre del autor
	 */
	public String getName(){
		return name;
	}
	/**
	 * Devuelve el apellido del autor
	 * @return apellido del autor
	 */
	public String getSurname(){
		return surname;
	}
	/**
	 * Cambia el nombre del autor
	 * @param nombre Nuevo nombre del autor
	 * @throws IllegalArgumentException si el nuevo nombre es null
	 */
	public void setName(String nombre) {
		if(nombre == null) {
			throw new IllegalArgumentException("Nombre null");
		}
		this.name=nombre;
	}
	/**
	 * Cambia el apellido del autor
	 * @param apellidos Nuevo apellido del autor
	 * @throws IllegalArgumentException si los nuevos apellidos son null
	 */
	public void setSurname(String apellidos) {
		if(apellidos == null) {
			throw new IllegalArgumentException("Apellidos null");
		}
		this.surname=apellidos;
	}
}
