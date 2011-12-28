package control.ai;

import java.util.ArrayList;
import java.util.List;

public class TestCNF {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CNF<String> cnf = fillClauses2();
		System.out.println(cnf.toString());
		
		/*System.out.println("updated: with A = true");
		cnf.updateCNF("A", true);
		System.out.println(cnf.toString());
		System.out.println("updated: with F = true");
		cnf.updateCNF("F", true);*/
		
		System.out.println("Resolution result: " + cnf.resolution());
		System.out.println(cnf.toString());
	}
	
	private static CNF<String> fillClauses() {
		CNF<String> cnf = new CNF<String>();
		List<Literal<String>> l = new ArrayList<Literal<String>>();
		l.add(new Literal<String>("A", true));
		l.add(new Literal<String>("B", true));
		l.add(new Literal<String>("C", true));
		l.add(new Literal<String>("D", true));
		Clause<String> c1 = new Clause<String>(l);
		cnf.addClause(c1);
		l = new ArrayList<Literal<String>>();
		
		l.add(new Literal<String>("A", false));
		l.add(new Literal<String>("C", true));
		//l.add(new Literal<String>("E", true));
		Clause<String> c2 = new Clause<String>(l);
		cnf.addClause(c2);
		l = new ArrayList<Literal<String>>();
		
		l.add(new Literal<String>("B", false));
		l.add(new Literal<String>("C", false));
		l.add(new Literal<String>("D", true));
		l.add(new Literal<String>("F", true));
		Clause<String> c3 = new Clause<String>(l);
		cnf.addClause(c3);
		l = new ArrayList<Literal<String>>();
		
		l.add(new Literal<String>("D", false));
		l.add(new Literal<String>("A", true));
		l.add(new Literal<String>("G", true));
		Clause<String> c4 = new Clause<String>(l);
		cnf.addClause(c4);
		l = new ArrayList<Literal<String>>();
		
		l.add(new Literal<String>("G", true));
		l.add(new Literal<String>("C", true));
		Clause<String> c5 = new Clause<String>(l);
		cnf.addClause(c5);
		return cnf;
	}
	
	private static CNF<String> fillClauses2() {
		CNF<String> cnf = new CNF<String>();
		List<Literal<String>> l = new ArrayList<Literal<String>>();
		l.add(new Literal<String>("P21", false));
		l.add(new Literal<String>("B11", true));
		Clause<String> c1 = new Clause<String>(l);
		cnf.addClause(c1);
		l = new ArrayList<Literal<String>>();
		
		l.add(new Literal<String>("B11", false));
		l.add(new Literal<String>("P12", true));
		l.add(new Literal<String>("P21", true));
		Clause<String> c2 = new Clause<String>(l);
		cnf.addClause(c2);
		l = new ArrayList<Literal<String>>();
		
		l.add(new Literal<String>("P12", false));
		l.add(new Literal<String>("B11", true));
		Clause<String> c3 = new Clause<String>(l);
		cnf.addClause(c3);
		l = new ArrayList<Literal<String>>();
		
		l.add(new Literal<String>("B11", false));
		Clause<String> c4 = new Clause<String>(l);
		cnf.addClause(c4);
		l = new ArrayList<Literal<String>>();
		
		l.add(new Literal<String>("P12", true));
		Clause<String> c5 = new Clause<String>(l);
		cnf.addClause(c5);
		return cnf;
	}

}
