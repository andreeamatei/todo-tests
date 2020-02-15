# todo-tests

1. Open pom.xml file with your IDE (Intellij IDEA)
If prompted with Maven popup to auto-import dependencies - accept

2. Go to IDE Preferences > Build, Execution, Deployment > Compiler > Java compiler  > Project bytecode version choose 8 and at todo-tests version choose 8

3. Go to Run > Edit Configurations > Vm options: -Dchrome.driver=chrome and Use classpath of module: todo-tests project

4. If on win or linux, replace chromedriver with the one downloaded for your OS (the one in the repo is for osx)