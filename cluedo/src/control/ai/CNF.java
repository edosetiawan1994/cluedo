package control.ai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CNF<T> {
	private List<Clause<T>> clauses;

	public CNF() {
		this.clauses = new ArrayList<Clause<T>>();
	}
	
	/**
	 * Updates CNF using the given knowledge.
	 * @param value	Value of the literal whose sign we explicitly know
	 * @param sign	Sign of the known literal
	 * @throws ArithmeticException	if an empty clause is generated 
	 * 								(contradiction is found) 
	 */
	public void addNewFact(T value, boolean sign) throws ArithmeticException {
		if (!sign) {
			for (Clause<T> c : clauses) {
				c.removeLiteral(value);
				if (c.isEmpty()) {
					throw new ArithmeticException();
				}
			}
		} else {
			List<Clause<T>> newList = new ArrayList<Clause<T>>();
			// delete whole c from clauses if l = true in c
			for (Clause<T> c : clauses) {
				boolean clauseOK = true;
				for (Literal<T> l : c.getLiterals()) {
					if (l.getValue().equals(value)) {
						clauseOK = false;
						break;
					}
				}
				if (clauseOK) {
					newList.add(c);
				}
			}
			clauses = newList;
		}
	}
	
	/**
	 * Updates CNF using the given knowledge.
	 * @param knownLiteral	Literal whose sign we explicitly know
	 * @throws ArithmeticException	if an empty clause is generated 
	 * 								(contradiction is found) 
	 */
	public void addNewFact(Literal<T> knownLiteral) 
			throws ArithmeticException {
		addNewFact(knownLiteral.getValue(), knownLiteral.getSign());
	}
	
	/**
	 * Searches for facts (atomic clauses) in CNF.
	 * @return	List of facts (Literals with their values) in CNF
	 */
	public List<Literal<T>> getNewFacts() {
		List<Literal<T>> facts = new ArrayList<Literal<T>>();
		for (Clause<T> c : clauses) {
			if (c.getLiterals().size() == 1) {
				// found new fact
				facts.add(c.getLiterals().get(0));
			}
		}
		return facts;
	}
	
	/**
	 * Updates CNF resolving facts it gets from atomic clauses recursively.
	 */
	public void updateCNF() {
		List<Literal<T>> facts = getNewFacts();
		while (!facts.isEmpty()) {
			for (Literal<T> l : facts) {
				addNewFact(l);
				facts.addAll(getNewFacts());
			}
		}
	}
	
	
	/**
	 * Removes all clauses from the CNF.
	 */
	public void clear() {
		clauses.clear();
	}
	
	/**
	 * Returns all literals in the CNF (contained in at least one clause)
	 * with their quantity.
	 * @return	HashMap with Literals and their quantities.
	 */
	public HashMap<Literal<T>, Integer> getAllLiterals() {
		HashMap<Literal<T>, Integer> hm = new HashMap<Literal<T>, Integer>();
		for (Clause<T> c : clauses) {
			for (Literal<T> l : c.getLiterals()) {
				if (hm.containsKey(l)) {
					Integer oldValue = hm.get(l);
					hm.put(l, oldValue + 1);
				} else {
					hm.put(l, 1);
				}
			}
		}
		return hm;
	}
	
	/**
	 * @return the clauses
	 */
	public List<Clause<T>> getClauses() {
		return clauses;
	}

	/**
	 * @param clauses the clauses to set
	 */
	public void setClauses(List<Clause<T>> clauses) {
		this.clauses = clauses;
	}
	
	/**
	 * adds given clause to the CNF
	 * @param clause	clause to add to the CNF
	 */
	public void addClause(Clause<T> clause) {
		this.clauses.add(clause);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		String s = "";
		for (Clause<T> clause : clauses) {
			s += " ^ " + clause;
		}
		return s.length() == 0 ? "empty" : s.substring(3);
	}

}