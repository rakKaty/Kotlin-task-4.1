import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun cardTypeToCommission_VkPay() {
        //arrange
        val transferAmount = 135_000_00
        val cardType: CardType = CardType.VkPay
        val sumMonthlyTransfer = 0

        //act
        val result = cardTypeToCommission(
            transferAmount = transferAmount,
            cardType = cardType,
            sumMonthlyTransfer = sumMonthlyTransfer)

        //assert
        assertEquals(0, result)
    }

    @Test
    fun cardTypeToCommission_MasterCard_Maestro_SumMonthlyTransfer_0() {
        //arrange
        val transferAmount = 135_000_00
        val cardType: CardType = CardType.Mastercard
        val sumMonthlyTransfer = 0

        //act
        val result = cardTypeToCommission(
            transferAmount = transferAmount,
            cardType = cardType,
            sumMonthlyTransfer = sumMonthlyTransfer)

        //assert
        assertEquals(0, result)
    }

    @Test
    fun cardTypeToCommission_MasterCard_Maestro_SumMonthlyTransfer_100_000_00() {
        //arrange
        val transferAmount = 100_000_00
        val cardType: CardType = CardType.Mastercard
        val sumMonthlyTransfer = 100_000_00

        //act
        val result = cardTypeToCommission(
            transferAmount = transferAmount,
            cardType = cardType,
            sumMonthlyTransfer = sumMonthlyTransfer)

        //assert
        assertEquals(620_00, result)
    }

    @Test
    fun cardTypeToCommission_Mir_Visa_TransferAmount_1_000_00() {
        //arrange
        val transferAmount = 1_000_00
        val cardType: CardType = CardType.Visa
        val sumMonthlyTransfer = 0

        //act
        val result = cardTypeToCommission(
            transferAmount = transferAmount,
            cardType = cardType,
            sumMonthlyTransfer = sumMonthlyTransfer)

        //assert
        assertEquals(35_00, result)
    }

    @Test
    fun cardTypeToCommission_Mir_Visa_TransferAmount_100_000_00() {
        //arrange
        val transferAmount = 100_000_00
        val cardType: CardType = CardType.Visa
        val sumMonthlyTransfer = 0

        //act
        val result = cardTypeToCommission(
            transferAmount = transferAmount,
            cardType = cardType,
            sumMonthlyTransfer = sumMonthlyTransfer)

        //assert
        assertEquals(750_00, result)
    }
}