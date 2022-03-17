import java.lang.Integer.max

enum class CardType {
    Mastercard, Maestro, Visa, Mir, VkPay
}

fun main() {

    println("Коммисия составит: ${changeToRubles(cardTypeToCommission(135_000_00))}")
}

fun cardTypeToCommission(transferAmount: Int, cardType: CardType = CardType.VkPay, sumMonthlyTransfer: Int = 0): Int {
    return when (cardType) {
        CardType.Mastercard, CardType.Maestro -> if (sumMonthlyTransfer < 75_000_00) 0
        else ((transferAmount * 0.006 + 20_00)).toInt()
        CardType.Visa, CardType.Mir -> max((transferAmount * 0.0075).toInt(), 35_00)
        CardType.VkPay -> 0
    }
}

fun changeToRubles(commission: Int): String {
    return "${commission / 100}" + "руб. " + "${commission % 100}" + "коп."
}