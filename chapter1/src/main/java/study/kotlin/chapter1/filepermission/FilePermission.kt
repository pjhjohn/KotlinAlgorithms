package study.kotlin.chapter1.filepermission

object FilePermission {
    fun symbolicToOctal(symbols: String): Int {
        val valid = "rwxrwxrwx"

        if(symbols.length != 9) {
            throw IllegalArgumentException("input has to be of length 9!!")
        }

        for(i in 0..8) {
            if(symbols[i] != valid[i] && symbols[i] != '-') {
                throw IllegalArgumentException("invalid sequence!!")
            }
        }

        //kotlin은 boolean이 int로 인식이 안되나요? 굳이 삼항연산자를 써야했네요...
        var hundreds = (if(symbols[0] == 'r') 1 else 0) * 4 + (if(symbols[1] == 'w') 1 else 0) * 2 + (if(symbols[2] == 'x') 1 else 0)
        var tens = (if(symbols[3] == 'r') 1 else 0) * 4 + (if(symbols[4] == 'w') 1 else 0) * 2 + (if(symbols[5] == 'x') 1 else 0)
        var ones = (if(symbols[6] == 'r') 1 else 0) * 4 + (if(symbols[7] == 'w') 1 else 0) * 2 + (if(symbols[8] == 'x') 1 else 0)

        return hundreds * 100 + tens * 10 + ones
    }
}
