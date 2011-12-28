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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (sign ? 1231 : 1237);
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Literal other = (Literal) obj;
		if (sign != other.sign)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}
