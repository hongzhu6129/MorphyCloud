package morphy.annotations;
import java.util.List;
import java.util.UUID;

public class TestCase<InputType,OutputType> {
	/**
	 * the id number of the test case;
	 */
	public String id; 
	
	/**
	 * the input data of the test case
	 */
	public InputType input;  
	
	/**
	 * the output data of the test case
	 */
	public OutputType output;  
	
	/**
	 * the feature of the test case, which can be either "original" or "mutant"; 
	 */
	public TestDataFeature feature; 
	
	/**
	 * the type of the mutant, which should be the name of the mutation operator use to generate the mutant; 
	 */
	private String type; 
	
	/**
	 * the id numbers of the original test cases that are used to generate the mutant; 
	*/
	public List<String> origins; 
	
	/**
	 * the correctness of the test case. Format: "metamorphismName:(pass|fail);"
	 */
	public String correctness; 
	
	/** The constructor of TestCase and it initialises a new test case
	 * 
	 */
	public TestCase() {
		id=UUID.randomUUID().toString();
		input = null;
		output = null;
		setFeature(TestDataFeature.original);
		setType("");
		correctness = "";
		setOrigins(null); 
	}
	
	/** Convert a test case into a string */
	public String toString() {
		String outputStr ="{\n";
		outputStr = outputStr + " id:" + id + ",\n";
		if (!(input == null)) {
			outputStr = outputStr + " input:" + input + ",\n";
		}else{
			outputStr = outputStr + " input:,\n";
		};
		if (!(output == null)) {
			outputStr = outputStr + " output:" + output + ",\n";
		}else{
			outputStr = outputStr + " output:,\n";
		};
		outputStr = outputStr + " feature:" + getFeature().toString() + ",\n";
		outputStr = outputStr + " type:" + getType() + ",\n";
		outputStr = outputStr + " origins:[";
		if (!(getOrigins() == null)) {
			for (int i=0; i<getOrigins().size(); i++) {
				outputStr = outputStr + "  " + getOrigins().get(i).toString();
				if (i!=getOrigins().size()-1) {
					outputStr = outputStr +";";
				}
			}
		}
		outputStr = outputStr+"],\n";
		outputStr = outputStr + " correctness:"+ correctness + "\n";
		outputStr = outputStr + "}\n"	;
		return outputStr;
	}

	public static TestDataFeature strToFeature(String featureStr) {
		switch (featureStr) {
		case "original": return TestDataFeature.original;
		case "mutant" : return TestDataFeature.mutant;
		default: return null;
		}
	}

	public List<String> getOrigins() {
		return origins;
	}

	public void setOrigins(List<String> origins) {
		this.origins = origins;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public TestDataFeature getFeature() {
		return feature;
	}

	public void setFeature(TestDataFeature feature) {
		this.feature = feature;
	}
}
