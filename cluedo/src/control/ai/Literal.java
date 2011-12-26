package control.ai;

/**
 * Generic literal object. Stores value of the object and its sign. 
 * @param <T>
 */
public class Literal<T> {
	private T value;
	private boolean sign;
	
	/**
	 * Constructor. Sets value and sign of the literal.
	 * @param value	Value of the literal
	 * @param sign	Sign of the literal
	 */
	public Literal(T value, boolean sign) {
		this.setValue(value);
		this.setSign(sign);
	}

	/**
	 * @return the value
	 */
	public T getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(T value) {
		this.value = value;
	}

	/**
	 * @return the sign
	 */
	public boolean getSign() {
		return sign;
	}

	/**
	 * @param sign the sign to set
	 */
	public void setSign(boolean sign) {
		this.sign = sign;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		String s = "";
		if (!sign) {
			s += "!";
		}
		return s + value.toString();
	}
}
