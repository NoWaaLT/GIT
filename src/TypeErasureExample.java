import java.util.ArrayList;

public class TypeErasureExample {

  static class SomeClass <T> {

    void someMethod(T parameter) {
      System.out.println(parameter);
    }

//  void someMethod(Object parameter) {                                 // This is not allowed because we have specified the type of what Generic type became at runtime.
//    System.out.println(parameter);
//  }

  }

  static class SomeClass2 <T extends Number> {                         // This is a bounded type parameter. It became Number or its subclasses.

        void someMethod(T parameter) {
          System.out.println(parameter);
        }

//      void someMethod(Number parameter) {                            // This is not allowed because we have specified the type of what Generic type became at runtime.
//        System.out.println(parameter);
//      }

        void someMethod(Object parameter) {                            // This is allowed because Object is in the upper bound of Number.
          System.out.println(parameter);
        }

  }


  public static void main(String[] args) {

    ArrayList<Integer> intList = new ArrayList<>();                    // Till compilation process ArrayList holds parameter type as Integer
    ArrayList<Double> doubleList = new ArrayList<>();                  // or Double. Depends on what we have specified.

    intList.add(10);
    doubleList.add(10.0);

    System.out.println(intList.getClass() == doubleList.getClass());  // Before the compilation it seems like these are different types. But
                                                                      // on the runtime they became same type ArrayList because of Type
                                                                      // Erasure. ArrayList<Object> list = new ArrayList<Object>();

    // doubleList.add(10);                                            // This is not allowed because we have specified the type of ArrayList as Double.



  }
}
