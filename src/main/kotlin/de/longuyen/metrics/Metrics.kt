package de.longuyen.metrics

interface Metrics<T> {
    fun compute(a: Array<T>, b: Array<T>) : Double
}