import org.jetbrains.annotations.TestOnly

sealed class Country{
object Canada:Country()
}
object Spain:Country()
class Greece(val  someProperty:String):Country()
data class Usa(val someProperty:String):Country()
//class Poland:Country()

class Currency (val code:String)

object CurrenncyFactory{
    fun currenncyFactory(country: Country):Currency =
        when(country) {
            is Spain -> Currency("EUR")
            is Greece -> Currency("EUR")
            is Usa -> Currency("USD")
            is Country.Canada -> Currency("CAD")

            else -> { Currency("gfhjhjf")}
        }


    }
class FactoryMethodTest{
    @TestOnly
    fun currencyTest() {
        val greeceCurrency: String = CurrenncyFactory.currenncyFactory(Greece("")).code
        println("Greece Currency:$greeceCurrency")
    }}