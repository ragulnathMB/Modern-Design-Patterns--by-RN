# Adapter Pattern

The Adapter pattern converts the interface of a class into another interface clients expect. It lets classes work together that couldn’t otherwise because of incompatible interfaces.

## When to Use
- You want to use an existing class, but its interface doesn’t match the one you need.
- You need to reuse several existing subclasses that lack some common functionality, and you can’t modify them.

## Example Overview
This example models a `RoundHole` that accepts `RoundPeg` by radius. A `SquarePeg` can’t fit directly, so `SquarePegAdapter` computes an effective radius `(width * sqrt(2))/2` to check compatibility without modifying `SquarePeg`.

