all: rules.sablecc
	java -jar sablecc-3.7/lib/sablecc.jar rules.sablecc
	javac driver.java
	java driver cleanInput.txt
