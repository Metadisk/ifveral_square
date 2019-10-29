package ifveral.square.com.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import ifveral.square.com.R
import ifveral.square.com.data.Source.SquareService
import ifveral.square.com.data.model.Square
import ifveral.square.com.utils.ItemDecorator
import ifveral.square.com.utils.ViewUtils
import ifveral.square.com.utils.squareApp
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }

    @Inject
    lateinit var mainPresenter: MainPresenter

    @Inject
    lateinit var apiService: SquareService


    private val squareAdapter: SquareAdapter = SquareAdapter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        squareApp.component.inject(this)

        mainPresenter.attach(this)

        mainPresenter.loadData(apiService, Schedulers.io(), AndroidSchedulers.mainThread())


    }


    override fun showProgress(show: Boolean) {

        if (show) {
            progress.visibility = View.VISIBLE
        } else {

            progress.visibility = View.GONE
        }

    }

    override fun showErrorMessage(error: String) {

        Log.v(TAG, error)
    }

    override fun loadDataSuccess(squareList: List<Square>) {

        squareAdapter.updateSquares(squareList)
    }


    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.unsubscribe()
        mainPresenter.detach()
    }

    private fun initViews() {
        val gridColumnsSize = ViewUtils.calculateNoOfColumns(this)
        val gridLayoutManager = GridLayoutManager(this,gridColumnsSize)
        val itemDecorator = ItemDecorator(10, gridColumnsSize)
        SquareRV.layoutManager = gridLayoutManager
        SquareRV.addItemDecoration(itemDecorator)
        SquareRV.adapter = squareAdapter

    }


}
