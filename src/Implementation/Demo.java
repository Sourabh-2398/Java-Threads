package Implementation;

import Interface.interfaceA;
import Interface.interfaceB;

public class Demo implements interfaceA, interfaceB {
    @Override
    public void SetEngine() {

    }

    @Override
    public void hasEngine() {
        System.out.println("hasEngine " + "from classB");
    }
}
