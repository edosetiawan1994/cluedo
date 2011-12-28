package control.ai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CNF<T> {
	private List<Clause<T>> clauses;
	private TruthValues value;

	public CNF() {
		this.clauses = new ArrayList<Clause<T>>();
		this.value = TruthValues.UNKNOWN;
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
					if (l.getValue() == value) {
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
				//TODO: do not add same fact twice
			}
		}
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
	 * Generates all possible pairs of clauses from given clause list.
	 * @param clauseList list of clauses
	 * @return	list of pairs (lists) of clauses
	 */
	private List<List<Clause<T>>> generatePairsOfClauses(List<Clause<T>> clauseList) {
		List<List<Clause<T>>> listOfPairs = new ArrayList<List<Clause<T>>>();
		for (Clause<T> c1 : clauseList) {
			for (Clause<T> c2 : clauseList) {
				List<Clause<T>> pair = new ArrayList<Clause<T>>();
				pair.add(c1);
				pair.add(c2);
				listOfPairs.add(pair);
			}
		}
		return listOfPairs;
	}
	
	/**
	 * If clauses can be resolved (there is same literal in both clauses with
	 * different sign) it resolves them, returns NULL otherwise. If one of the
	 * clauses is Empty, return empty clause.
	 * @param c1	first clause
	 * @param c2	second clause
	 * @return NULL if clauses cannot be resolved, otherwise resolved Clause
	 */
	private Clause<T> resolveClauses(Clause<T> c1, Clause<T> c2) {
		int index1 = -1, index2 = -1;		
		
		if (c1.isEmpty() || c2.isEmpty()) {
			return new Clause<T>();
		}
		
		for (int i = 0; i < c1.getLiterals().size(); i++) {
			for (int j = 0; j < c2.getLiterals().size(); j++) {
				Literal<T> l1 = c1.getLiterals().get(i);
				Literal<T> l2 = c2.getLiterals().get(j);
				if (l1.getValue().equals(l2.getValue())) {
					if (l1.getSign() != l2.getSign()) {
						// combine both clauses and remove l1, l2
						index1 = i;
						index2 = j;
						break;
					} 
				}
			}
		}
		if (index1 != -1) {
			Clause<T> result = new Clause<T>();
			for (int i = 0; i < c1.getLiterals().size(); i++) {
				if (i != index1) {
					result.addLiteral(c1.getLiterals().get(i));
				}
			}
			for (int j = 0; j < c2.getLiterals().size(); j++) {
				if (j != index2) {
					result.addLiteral(c2.getLiterals().get(j));
				}
			}
			return result;
		}
		return null;
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
		s += value.toString() + "\n";
		if (clauses.size() > 0) {
			s += clauses.get(0).toString();
			for (int i = 1; i < clauses.size(); i++) {
				s += " ^ " + clauses.get(i).toString();
			}
		}
		return s;
	}

}