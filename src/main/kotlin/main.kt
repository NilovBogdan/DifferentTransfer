fun main() {
    println(calculateTransfer("Visa", 500000, 100))
}

fun calculateTransfer(cardTipe: String, transferSumMonth: Int, nextTransfer: Int): String {
    val maxLimitDay = 150000
    val maxLimitMonth = 600000
    var different = 0
    if (transferSumMonth + nextTransfer < maxLimitMonth && nextTransfer < maxLimitDay) {
        if (cardTipe == "Mastercard") {
            if (transferSumMonth + nextTransfer > 75000 && nextTransfer > 75000) {
                different = (((nextTransfer - 75000) / 100 * 0.6) + 20).toInt()
            } else different = 0
        } else if (cardTipe == "Visa") {
            if (nextTransfer / 100 * 0.75 < 35) {
                different = 35
            } else different = (nextTransfer / 100 * 0.75).toInt()
        }
    } else return " Перевод не может быть выполнен, превышен лимит!"
    return "Перевод выполнен, комиссия составляет " + different + " руб."
}