package ifveral.square.com.ui.main

import ifveral.square.com.data.Source.SquareService
import ifveral.square.com.data.model.Square
import ifveral.square.com.ui.base.BaseContract
import io.reactivex.Scheduler

class MainContract {

    // presenter contract
    interface Presenter : BaseContract.Presenter<MainContract.View>
    {
        fun loadData(service: SquareService, processScheduler: Scheduler, androidScheduler: Scheduler)
    }

    //TODO view contract for MainActivity class , we will show a progress bar during data load , if any error happens  it will show error message
    interface View : BaseContract.View{

        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
        fun loadDataSuccess(list: List<Square>)

    }

}