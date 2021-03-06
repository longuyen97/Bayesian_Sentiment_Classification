package de.longuyen.nlp

import java.io.Serializable


class NGram(val n: Int, val delimiter: String = " ", private val join: String = "_") : Serializable{
    companion object {
        private const val serialVersionUID: Long = -4270053884763734247
    }

    init {
        if(n < 1){
            throw RuntimeException("N-Gram with n < 1. Bad. Try a number >= 1")
        }
    }

    fun analyze(input: String) : Array<String>{
        val ret = mutableListOf<String>()
        val tokens = input.split(delimiter)
        for(i in tokens.indices){
            if(i + n <= tokens.size) {
                val gram = Array(this.n) { "" }
                for (j in 0 until n) {
                    gram[j] = tokens[i + j]
                }
                ret.add(gram.joinToString(join))
            }
        }
        ret.addAll(input.split(delimiter))
        return ret.toTypedArray()
    }
}
