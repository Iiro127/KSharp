# K#
K# is a programming language built on top of Java. It features it's own syntax, and it is usable on console and it's own IDE. All code examples are executed on console, but are applicable on the K# IDE.

## Num:

A num-variable can be initialized using the "num"-keyword. Nums can then be used to perform addition and subtraction.

```text
>>> num x = 2;
>>> num y = 3;
>>> num x + y;
5
```

## Str:

A str-variable can be initialized using the "str"-keyword. Like nums, str-variables can also be added together.

```text
>>> str x = ab;
>>> str y = cd;
>>> str x + y;
abcd
```
## Print:

**Printing variables:**

Printing can be done using the "print"-keyword. When printing variables, write the name of the variable.

```text
>>> str car = audi;
>>> print car;
audi
```

**Printing plain text:**

Printing plain text can be done by ending the body with "//".

```text
>>> print car//;
car
```



## When:

"When" checks if a condition is fulfilled before performing an action.

```text
>>> str name = harry;
>>> when (name = harry) { print welcome// };
welcome
```

