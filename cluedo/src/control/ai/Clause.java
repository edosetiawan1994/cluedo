package control.ai;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public class Clause<T> {
	private List<Literal<T>> literals;
	
	/**
	 * Constructor. Initializes new Clause<T> object with no literals (empty
	 * clause).
	 */
	public Clause() {
		literals = new ArrayList<Literal<T>>();
	}
	
	/**
	 * Constructor. Initializes new clause with given literals.
	 * @param literals
	 */
	public Clause(List<Literal<T>> literals) {
		this.literals = literals;
	}
	
	/**
	 * @return the literals
	 */
	public List<Literal<T>> getLiterals() {
		return literals;
	}

	/**
	 * Checks whether the clause is empty.
	 * @return true if clause is empty, false otherwise
	 */
	public boolean isEmpty() {
		return literals.size() == 0;
	}
	
	/**
	 * Adds literal to the clause.
	 * 
	 * @param value	Value of literal
	 * @param sign	Sign of literal
	 */
	public void addLiteral(T value, boolean sign) {
		literals.add(new Literal<T>(value, sign));
	}

	/**
	 * Removes literal with the specified value from the clause.
	 * 
	 * @param value	Specified value of the literal we want to remove
	 * @return	true, if such value exists; otherwise false
	 */
	public boolean removeLiteral(T value) {
		for (Literal<T> l : literals) {
			if (l.getValue().equals(value)) {
				literals.remove(l);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		String s = " (" + literals.get(0).toString();
		for (int i = 1; i < literals.size(); i++) {
			s += " v " + literals.get(i).toString();
		}
		s += ") ";
		return s;
	}
		
}
