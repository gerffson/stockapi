package com.gps.stockapi.business

import com.github.jairovsky.fixturefactory.kotlin.FixtureDefinitions
import com.github.jairovsky.fixturefactory.kotlin.gimme
import com.gps.stockapi.model.Stock
import com.gps.stockapi.repository.StockRepository
import com.nhaarman.mockito_kotlin.*
import io.kotlintest.TestCase
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.MockitoAnnotations
import java.util.*


class StockBusinessTest {
    private var stockBusiness: StockBusiness = mock()
    private var stockRepository: StockRepository = mock()

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
        stockBusiness = StockBusiness(stockRepository)
    }

    @Test
    fun shouldAddProductToStock() {
        val stock = gimme<Stock>("stock1")
        val captorStock = ArgumentCaptor.forClass(Stock::class.java)

        whenever(stockRepository.findByLocationIdAndProductId(anyInt(), anyInt())).thenReturn(Optional.of(stock))
        whenever(stockRepository.save(captorStock.capture())).thenReturn(stock)

        val result = stockBusiness.addProductToStock(20, 30, 1.0)

        result.quantity shouldBe 2.0
    }
}


//
//class StockBusinessTest: StringSpec() {
//    private var stockBusiness: StockBusiness = mock()
//    private var stockRepository: StockRepository = mock()
//
//    override fun beforeTest(testCase: TestCase) {
//        super.beforeTest(testCase)
//        stockBusiness = mock()
//        stockRepository = mock()
//    }
//
//    init {
//
//        "Should add product to stock" {
//            val stock = gimme<Stock>("stock1")
//            val captorStock = ArgumentCaptor.forClass(Stock::class.java)
//            whenever(stockRepository.findByLocationIdAndProductId(anyInt(), anyInt())).thenReturn(Optional.of(stock))
//            whenever(stockRepository.save(captorStock.capture()  )).thenReturn(stock)
//            val result = stockBusiness.addProductToStock(20, 30, 1.0)
//            result.quantity shouldBe 2.0
//        }
//
//    }
//
//}
class Fixtures : FixtureDefinitions({
    "stock1" {
        Stock(id = 10, locationId = 20, productId = 30, quantity = 1.0)
    }
})