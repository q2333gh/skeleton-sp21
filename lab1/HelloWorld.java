public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world!");
	}
}
// ubuntu :
// to get JAVA_HOME:
//    update-alternatives --query java | grep 'Value: ' | sed 's/Value: \(.*\)\/bin\/java/\1/'
//to set JAVA_HOME:
//    export JAVA_HOME="$(update-alternatives --query java | grep 'Value: ' | sed 's/Value: \(.*\)\/bin\/java/\1/')"
