---
title: "Scala"
---

Why Scala?

- Criado em 2004
- Integra com java
- Integração gradual com funcionalidades funcionais

## Variables

val is an immutable variable
var is a mutable variable

## Types

- Scala has type inference
- Deve-se evitar type tests e casts
- Built-ins
  - Byte: 8 bit int (-128 to 127)
  - Short: 16 bit integer (-32768 to 32767)
  - Int: 32 bit int - 2 billion to + 2 billion
  - Long: 64 bit integer (-2^63 to 2^63-1)
  - Float: 32 bit single precision float
  - Double: 64 bit single precision float
  - Boolean: true or false
  - Char: unicode char
  - String: sequence of chars
  - BigInt
  - BigDecimal

### Immutable Collections

- Seq: have defined order `Seq(1, 1, 2)`
- Set: no duplicates `Set(1, 1, 2)`
- List: standard linked list `List(1, 1, 2)`
- Array
- Map: key value containers `Map('a' -> 1, 'b' -> 2)`

## Mutable Collections

- HashMap:
- ListBuffer
- ArrayBuffer
- LinkedList
- PriorityQueue
- Stack
- StringBuilder

#### Map

```scala

val ratings = Map(
    "Lady in the Water"  -> 3.0,
    "Snakes on a Plane"  -> 4.0,
    "You, Me and Dupree" -> 3.5
)

```

## Yield

The yield keyword means that I want to yield a new collection from the existing collection that I’m iterating over in the for-expression, using the algorithm shown.”

### String manipulations

```scala
val name = s"$firstName $mi $lastName"
// or

val name = s"Name ${firstName} ${mi} ${lastName} has ${2 + 2} years"

""" Inline
sucks so use
multiple """
```

`println` adds a line after string while `print` only adds a word

## Control Structures

- For
- While
- try catch finally
- If then else
- Match expressions
  - são bastante importantes

## Classes

classes on scala don't allow static methods

There is a special type of classes called case classes

## Traits

Are like interfaces in Java

## Objects

Are like classes but for every definition has one single instance.

## Packages

## Formatação

- Default é 2 espaços de identação

## Naming convention

- Class Names - StoreEmployee
- Variable - firstName
- Methods - toUpper

## Tips

- Evita usar o return
- Evita variáveis mutáveis

## Principios para tornar um código funcional

- reduce side-effects (no mutating state)
- Referential transparent
  - Idempotent is referential transparent but may not be the other way around (ƒ(x) ≠ ƒ(ƒ(x))) !=
- Be immutable

Pure function advantages

- Reduces race conditions
- less complex
- readability

> Function that can accept and/or return a function

> Linked lists are the bread and butter of functional programming

## Functional composing

```scala

// Compose creates a function that composes other functions
val fComposeG = f _ compose g _  //== f(g())

fComposeG("Yay")

// andThen composes but calls the functins by order

f _ andThen g _ # g(f())

```

## Partial functions

## Polymorphism

Has rank-1 polymorphism

## Persistent data structures and structural sharing

Creates versions for each update and shares common data between versions

**Partial and full structural sharing**: use part of the full data structure between versions

Strict vs Lazy (non strict)

> Strict is where all arguments of a function are evaluated before executing

Chaining → Linked List

Hash Table

- Modifications require whole copy of table
- Scala uses Tries to optimize hash tables

Hash Tries

- Each node has a number of children (Base N)
- Each entry has a hash number that facilitates search

> Use optional params not overloading

- Case class automattically adds functions like comparison, applies, etc

### Pattern matching

Extractors

- Extracts properties contained in the case

## Folding

Folding vs Reduce

- Folding requires an initial value

## Category

- Category properties
  - Identity
  - Composition

Functor : Mapping of objects from a category into another

- Nil is for Lists and None is for Options

[Programming Languages](../Programming%20Languages.md)

### Specs

[Scala School specs](https://twitter.github.io/scala_school/specs.html)

We can nest behaviour inside each Spec

- doBefore & doAfter
- doFirst & doLast

## Resources

[learnxinyminutes](https://learnxinyminutes.com/docs/scala/)
[Scala School](https://twitter.github.io/scala_school/)
