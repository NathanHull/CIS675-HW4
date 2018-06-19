all: rules.sablecc
	java -jar sablecc-3.7/lib/sablecc.jar rules.sablecc
	javac TranslateGraph.java
	javac driver.java
	java driver origInput.txt

clean: rules.sablecc
	java -jar sablecc-3.7/lib/sablecc.jar rules.sablecc
	javac TranslateGraph.java
	javac driver.java
	java driver cleanInput.txt
