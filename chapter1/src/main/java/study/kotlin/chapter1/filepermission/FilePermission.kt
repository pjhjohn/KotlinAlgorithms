package study.kotlin.chapter1.filepermission

import java.util.regex.Pattern

object FilePermission {

    private const val VALID_PATTERN = "[r-][w-][x-][r-][w-][x-][r-][w-][x-]"

    fun symbolicToOctal(symbols: String): Int {
        if (!Pattern.compile(VALID_PATTERN).matcher(symbols).matches()) throw IllegalArgumentException("Malformed Permission String : $symbols")
        return symbols.chunked(3).fold(0) { acc, chunk -> 10 * acc + parseUnitSymbols(chunk) }
    }

    private fun parseUnitSymbols(symbols: String): Int {
        if (symbols.length != 3) throw IllegalArgumentException("Malformed Unit Permission String : $symbols")
        return symbols.zip("rwx").fold(0) { acc, (symbol, answer) -> 2 * acc + (symbol == answer).toInt() }
    }

    private fun Boolean.toInt(): Int = if (this) 1 else 0
}
