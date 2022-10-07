fun main(){
    println("Masukkan kata atau kalimat yang ingin dienkripsi: ")
    val kalimat = readLine().toString()
    println("Masukkan key yang akan digunakan: ")
    val key = readLine()!!.toInt()
    println("Chiper text: " + caesar(kalimat.toUpperCase(), key))
    println("Dechiper text: " + dechiper(caesar(kalimat.toUpperCase(), key), key))
}

private fun caesar(text: String, key: Int): String{
    var result= ""
    val rumus = 26
    val firstnodeofcaesar = 65

    for (i in 0 until text.length){
        val huruf = text[i].toInt()
        if (huruf == 32){
            result += text[i]
            continue
        }
        val hurufminfirstnode = huruf - firstnodeofcaesar
        var caesar = hurufminfirstnode + key
        if (caesar < 0){
            caesar = (caesar + 26) %26
        }else{
            caesar = caesar % 26
        }

        val chiper = (caesar + firstnodeofcaesar).toChar()
        result += chiper
    }
    return result
}

private fun dechiper(text: String, key: Int): String{
    val dechiper = caesar(text, key * -1)
    return dechiper
}