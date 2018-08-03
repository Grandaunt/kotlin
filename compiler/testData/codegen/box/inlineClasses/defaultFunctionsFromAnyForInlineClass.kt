// !LANGUAGE: +InlineClasses
// IGNORE_BACKEND: JVM_IR, JS_IR, JS

inline class Foo(val x: Int)
inline class FooRef(val y: String)

fun box(): String {
    val f = Foo(42)
    if (f.toString() != "Foo(x=42)") return "Fail 1: $f"

    if (!f.equals(f)) return "Fail 2"

    val g = Foo(43)
    if (f.equals(g)) return "Fail 3"

    if (42.hashCode() != f.hashCode()) return "Fail 4"

    val fRef = FooRef("42")
    if (fRef.toString() != "FooRef(y=42)") return "Fail 5: $fRef"

    if (!fRef.equals(fRef)) return "Fail 6"

    val gRef = FooRef("43")
    if (fRef.equals(gRef)) return "Fail 7"

    if ("42".hashCode() != fRef.hashCode()) return "Fail 8"

    return "OK"
}