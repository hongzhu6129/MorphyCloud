package morphy.annotations;
import java.util.List;
import java.util.ArrayList;

public class TestPool<InputType,OutputType> {
	/**
	 * container to hold a test set; 
	 */
	public List<TestCase<InputType,OutputType>> testSet;
	
	/**
	 * Constructor to create a new empty set pool
	 */
	public TestPool() {
		testSet = new ArrayList<TestCase<InputType,OutputType>>();
	}

	/**
	 * Add a new test case with a value as the input. The new test case is regarded as an original (seed) test case. 
	 * @param v the value of the input
	 */
	public String addInput(InputType v) {
		TestCase<InputType,OutputType> tc = new TestCase<InputType,OutputType>();
//		TestCase tc = new TestCase();
		tc.input=v;
		tc.setFeature(TestDataFeature.original);
		this.addTestCase(tc);
		return tc.id; 
	}
	
	/**
	 * Add a mutant test case
	 * @param v : the value of input
	 * @param type : the type of the mutant, which is the datamorphism method name
	 * @param originalTcIndex : the list of id numbers of the original test cases used to generate the mutant test case
	 */
/*	public String addMutant(InputType v, String type, List<String> originalTcUUID) {
		TestCase<InputType,OutputType> tc = new TestCase<InputType,OutputType>();
		tc.input = v; 
		tc.setFeature(TestDataFeature.mutant);
		tc.setOrigins(originalTcUUID);
		tc.setType(type);
		this.addTestCase(tc);
		return tc.id; 
	}
*/	
	/**
	 * Add a test case into the test pool
	 * @param tc: the test case to be added
	 */
	public void addTestCase(TestCase<InputType,OutputType> tc) {
		testSet.add(tc);
	}
	
	/**
	 * Remove a test case from the test pool
	 * @param tc: the test case
	 */
	public void removeTestCase(TestCase<InputType,OutputType> tc) {
		for (TestCase<InputType,OutputType> x: testSet) {
			if (x.id.equals(tc.id)) { testSet.remove(x);};
		}
	}
	
	/**
	 * remove one test case from the test pool
	 * @param id: the identity of the test case; 
	 */
	public void removeTestCase(String id) {
		for (TestCase<InputType,OutputType> x: testSet) {
			if (x.id.equals(id)) { testSet.remove(x);};
		}
	}
	
	/**
	 * remove a set of test cases from the test pool
	 * @param tcList: the test cases to be removed
	 */
	public void removeAllTestCases(List<TestCase<InputType,OutputType>> tcList) {
		testSet.removeAll(tcList);
	}
	
	/**
	 * Set the output value of the test case
	 * @param v : the value of the output of the test case
	 * @param tcIndex : the id number of the test case
	 */
	public void setOutput(OutputType v, String id) {
		for (TestCase<InputType,OutputType> x: testSet) {
			if (x.id.equals(id)) {x.output = v;};
		};
	}
	
	/**
	 * Get the test case of a given id number (which is equal to the index of the test case in the TestPool
	 * @param index : id number of the test case
	 * @return : the test case at the index (or of the id number) in the test pool
	 */
	public TestCase<InputType,OutputType> get(String id){
		for (TestCase<InputType,OutputType> tx : testSet) {
			if (tx.id.equals(id)) {
				return tx;
			};
		};
		return null;
	}
	
	/**
	 * Convert the test pool into a string
	 */
	public String toString() {
		String outputStr = "[";
		for (TestCase<InputType,OutputType> x : testSet) {
			outputStr += x.toString() + ",\n";
		};
		if (outputStr.length()>2) {
			outputStr = outputStr.substring(0, outputStr.length()-2) + "]";
		}else {
			outputStr = outputStr + "]";
		};
		return outputStr; 
	}
}
