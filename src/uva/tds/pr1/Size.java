package uva.tds.pr1;

/**
 * Implementacion de las dimensiones de un libro.
 * 
 * @author mariher
 * @author marllor
 */
public class Size {
	
	private double width;
	private double height;
	private double thickness;
	
	/**
	 * Inicializacion de las dimensiones de un libro.
	 * 
	 * @param width 		Ancho del libro.
	 * @param height		Alto del libro.
	 * @param thickness		Grosor del libro.
	 * @throws IllegalArgumentException si el ancho es 0 o negativo.
	 * @throws IllegalArgumentException si el alto es 0 o negativo.
	 * @throws IllegalArgumentException si el grosor es 0 o negativo.
	 */
	public Size(double ancho, double alto, double grosor) {
		if(ancho <= 0.0) {
			throw new IllegalArgumentException("El ancho no puede ser 0 o negativo.");
		}
		if(alto <= 0.0) {
			throw new IllegalArgumentException("El alto no puede ser 0 o negativo.");
		}
		if(grosor <= 0) {
			throw new IllegalArgumentException("El grosor no puede ser 0 o negativo.");
		}
		this.width = ancho;
		this.height = alto;
		this.thickness = grosor;
	}
	
	/**
	 * Devuelve el valor del ancho del libro.
	 * @return ancho del libro
	 */
	public double getAncho() {
		return width;
	}
	
	/**
	 * Devuelve el valor de alto del libro.
	 * @return alto del libro
	 */
	public double getAlto() {
		return height;
	}
	
	/**
	 * Devuelve el valor del grosor del libro.
	 * @return grosor del libro
	 */
	public double getGrosor() {
		return thickness;
	}
}
