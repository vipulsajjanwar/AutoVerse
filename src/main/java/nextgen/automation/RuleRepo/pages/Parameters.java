package nextgen.automation.RuleRepo.pages;

public class Parameters {
	
	String ruleID;
	
	String	ruleName ;
 	String chkCheckName;
 	String	chkCheckType;
 	String	chkStatus;				//true-false
 	String	chkDimension;
 	String	chkColumnname;
 	String	chkTestValue;
 	String chkOperator;
 	String chkOperatorValue1;
 	String chkOperatorValue2;		
 	String newCheckType;			//new check type
 	String chkTrimData;				//true-false
 	String chkEmptyStringAsNull;	//true-false
 	String chkWhiteSpaceAsNull;		//true-false
 	String chkFixedStringAsNull;	//string value
 	String chkIgnoreNulls;			//true-false
 	String chkTestOutput;			//true-false
 	String chkExpression;
 	
 	String addCheck;
 	String sourceConnection;
	String sourceSchema;
	String sourceTable;
	
	
	public String getRuleID() {
		return ruleID;
	}
	public void setRuleID(String ruleID) {
		this.ruleID = ruleID;
	}
	
	
	public String getAddCheck() {
		return addCheck;
	}
	public void setAddCheck(String addCheck) {
		this.addCheck = addCheck;
	}
	
 	public String getChkExpression() {
		return chkExpression;
	}


	public void setChkExpression(String chkExpression) {
		this.chkExpression = chkExpression;
	}


	public String getChkTestOutput() {
		return chkTestOutput;
	}


	public void setChkTestOutput(String chkTestOutput) {
		this.chkTestOutput = chkTestOutput;
	}


	public String getChkIgnoreNulls() {
		return chkIgnoreNulls;
	}


	public void setChkIgnoreNulls(String chkIgnoreNulls) {
		this.chkIgnoreNulls = chkIgnoreNulls;
	}


	public String getChkTrimData() {
		return chkTrimData;
	}


	public void setChkTrimData(String chkTrimData) {
		this.chkTrimData = chkTrimData;
	}


	public String getChkEmptyStringAsNull() {
		return chkEmptyStringAsNull;
	}


	public void setChkEmptyStringAsNull(String chkEmptyStringAsNull) {
		this.chkEmptyStringAsNull = chkEmptyStringAsNull;
	}


	public String getChkWhiteSpaceAsNull() {
		return chkWhiteSpaceAsNull;
	}


	public void setChkWhiteSpaceAsNull(String chkWhiteSpaceAsNull) {
		this.chkWhiteSpaceAsNull = chkWhiteSpaceAsNull;
	}


	public String getChkFixedStringAsNull() {
		return chkFixedStringAsNull;
	}


	public void setChkFixedStringAsNull(String chkFixedStringAsNull) {
		this.chkFixedStringAsNull = chkFixedStringAsNull;
	}


	public String getNewCheckType() {
		return newCheckType;
	}


	public void setNewCheckType(String newCheckType) {
		this.newCheckType = newCheckType;
	}


	public String getRulename() {
 		return ruleName;
 	}


 	public void setRulename(String ruleName) {
 		this.ruleName = ruleName;
 	}


 	public String getChkCheckName() {
 		return chkCheckName;
 	}


 	public void setChkCheckName(String chkCheckName) {
 		this.chkCheckName = chkCheckName;
 	}


 	public String getChkCheckType() {
 		return chkCheckType;
 	}


 	public void setChkCheckType(String chkCheckType) {
 		this.chkCheckType = chkCheckType;
 	}


 	public String getChkStatus() {
 		return chkStatus;
 	}


 	public void setChkStatus(String chkStatus) {
 		this.chkStatus = chkStatus;
 	}


 	public String getChkDimension() {
 		return chkDimension;
 	}


 	public void setChkDimension(String chkDimension) {
 		this.chkDimension = chkDimension;
 	}


 	public String getChkColumnname() {
 		return chkColumnname;
 	}


 	public void setChkColumnname(String chkColumnname) {
 		this.chkColumnname = chkColumnname;
 	}

 	public String getChkTestValue1() {
 		return chkTestValue;
 	}

 	public void setChkTestValue1(String chkTestValue) {
 		this.chkTestValue = chkTestValue;
 	}
	public String getChkOperator() {
		return chkOperator;
	}


	public void setChkOperator(String chkOperator) {
		this.chkOperator = chkOperator;
	}


	public String getChkOperatorValue1() {
		return chkOperatorValue1;
	}


	public void setChkOperatorValue1(String chkOperatorValue1) {
		this.chkOperatorValue1 = chkOperatorValue1;
	}


	public String getChkOperatorValue2() {
		return chkOperatorValue2;
	}


	public void setChkOperatorValue2(String chkOperatorValue2) {
		this.chkOperatorValue2 = chkOperatorValue2;
	}
	
	public String getSourceConnection() {
		return sourceConnection;
	}
	public void setSourceConnection(String sourceConnection) {
		this.sourceConnection = sourceConnection;
	}
	public String getSourceSchema() {
		return sourceSchema;
	}
	public void setSourceSchema(String sourceSchema) {
		this.sourceSchema = sourceSchema;
	}
	public String getSourceTable() {
		return sourceTable;
	}
	public void setSourceTable(String sourceTable) {
		this.sourceTable = sourceTable;
	}
	
	@Override
	public String toString() {
		return "Parameters [ruleID=" + ruleID + "]";
	}
}
