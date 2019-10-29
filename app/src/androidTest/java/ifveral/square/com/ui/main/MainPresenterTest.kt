package ifveral.square.com.ui.main

import ifveral.square.com.data.Source.SquareService
import ifveral.square.com.data.model.Square
import io.reactivex.Observable
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MainPresenterTest {


    @Mock
    lateinit var mockService: SquareService


    @Mock
    lateinit var view: MainContract.View

    @Mock
    var mockedList: List<Square>? = null


    @Before
    fun setUp() {

        MockitoAnnotations.initMocks(this)

    }

    @Test
    fun test_LoadData() {


        // Given
        val data = Square( "Objective-C JSON" ,"JsonKit")
        val observable = Observable.just(listOf(data))
        val mainPresenter = MainPresenter()
        val scheduler = TestScheduler()
        // When
        Mockito.`when`(mockService.getCakes()).thenReturn(observable)
        mainPresenter.loadData(mockService, scheduler,scheduler)


        // Then
        Mockito.verify(view, Mockito.times(1)).showProgress(Mockito.anyBoolean())
        Mockito.verify(view, Mockito.times(1)).loadDataSuccess(listOf(data))
        Mockito.verify(view, Mockito.never()).showErrorMessage(Mockito.any())



    }
}