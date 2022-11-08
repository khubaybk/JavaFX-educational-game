package assignment.javaFXGame;

/**
 * @author kkhub
 *Factory interface
 */
public interface FactoryIF {
	GameObject createProduct(String discrim, double x, double y);
}
