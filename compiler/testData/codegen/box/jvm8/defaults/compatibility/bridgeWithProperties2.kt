// !API_VERSION: 1.3
// !JVM_DEFAULT_MODE: compatibility
// TARGET_BACKEND: JVM
// IGNORE_BACKEND: JVM_IR
// FILE: Simple.java

public interface Simple extends KInterface2 {
    default String test() {
        return KInterface2.DefaultImpls.getBar(this);
    }
}

// FILE: Foo.java
public class Foo implements Simple {
    public String getBar() {
        return "fail";
    }
}

// FILE: main.kt
// JVM_TARGET: 1.8
// WITH_RUNTIME

interface KInterface<T>  {

    val foo: T

    @JvmDefault
    val bar: T
        get() = foo
}

interface KInterface2 : KInterface<String> {
    @JvmDefault
    override val foo: String
        get() = "OK"
}


fun box(): String {
    return Foo().test()
}