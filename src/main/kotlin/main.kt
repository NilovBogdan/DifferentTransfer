fun main() {
    println(calculateTransfer("Mir", 0, 10000))
}

fun calculateTransfer(cardTipe: String, transferSumMonth: Int, nextTransfer: Int): String {
    val maxLimitDay = 150_000
    val maxLimitMonth = 600000
    var different = 0
    if (transferSumMonth + nextTransfer < maxLimitMonth && nextTransfer < maxLimitDay) {
        if (cardTipe == "Mastercard") {
            when {
                nextTransfer + transferSumMonth <= 75000 -> different = 0
                transferSumMonth <= 75000 && nextTransfer + transferSumMonth > 75000 ->
                    different = (((nextTransfer + transferSumMonth - 75000) / 100 * 0.6) + 20).toInt()

                transferSumMonth > 75000 -> different = (nextTransfer / 100 * 0.6 + 20).toInt()
            }
        } else if (cardTipe == "Visa") {
            when {
                nextTransfer / 100 * 0.75 < 35 -> different = 35
                nextTransfer / 100 * 0.75 >= 35 -> different = (nextTransfer / 100 * 0.75).toInt()
            }
        }
    } else return " Перевод не может быть выполнен, превышен лимит!"
    return "Перевод на сумму " + nextTransfer + " руб. выполнен, комиссия составляет " + different + " руб."
}